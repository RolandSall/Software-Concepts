public class main {
    public static void main(String[] args) {

        Beverages beverages = new Espresso();
        System.out.println(beverages.description + "  " + beverages.cost());


        Beverages beverages1 = new Whip(new Mocha(new Espresso()));
        String desc = beverages1.getDescription();
        double cost = beverages1.cost();
        System.out.println(desc + "  " + cost);

    }
}
