import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class VendingMachine {
    private int id;
    private HashMap<Beverage, Integer> beverages;
    private HashMap<CoinType, Integer> containedCoins;
    private TreeMap<CoinType, Integer> currentSuppliedCoins;
    private int runningSum = 0;
    private Optional<Beverage> current;


    public void addCoin(CoinType coinType) {
        if (currentSuppliedCoins.containsKey(coinType)) {
            int occ = currentSuppliedCoins.get(coinType);
            currentSuppliedCoins.put(coinType, ++occ);
            runningSum += coinType.getValue();
        } else {
            currentSuppliedCoins.put(coinType, 1);
            runningSum += coinType.getValue();
        }
    }

    private void addBeverages(Beverage beverage) {
        beverages.put(beverage, beverages.getOrDefault(beverage, 0) + 1);
    }

    public HashMap<Beverage, Integer> checkBeverages() {
        return beverages;
    }

    public void selectBeverage(Beverage beverage) {
        current = Optional.ofNullable(beverage);
    }

    public void reset() {
        current = Optional.empty();
    }

    public Beverage getBeverage() {
        if (current.isEmpty()) {
            System.out.println("Select an item first");
            return null;
        }


        int beveragePrice = current.get().getPrice();



        if (calculateDiff(beveragePrice, runningSum) < 0)
            throw new IllegalArgumentException("Not Enough Balance");

        for (Map.Entry<CoinType, Integer> entry : currentSuppliedCoins.entrySet()) {
            int coinValue = entry.getKey().getValue();
            int coinOccurrence = entry.getValue();

            if (beveragePrice - coinValue > 0 && coinOccurrence > 0) {
                beveragePrice -= coinValue;
                coinOccurrence -= 1;

                currentSuppliedCoins.put(entry.getKey(), coinOccurrence);

            }

            if(beveragePrice == 0)
                break;

        }

        reset();

        System.out.println("You current balance is: " + runningSum);
        return current.get();

    }

    public TreeMap<CoinType, Integer> endProcess() {
        return currentSuppliedCoins;
    }

    public TreeMap<CoinType, Integer> refund() {
        return currentSuppliedCoins;
    }


    private static int calculateDiff(int num1, int num2) {
        return num1 - num2;
    }


}
