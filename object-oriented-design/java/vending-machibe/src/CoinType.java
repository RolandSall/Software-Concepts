public enum CoinType {
    penny(1),
    nickel(5),
    dime(10),
    quarter(25);


    private int value;
    CoinType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
