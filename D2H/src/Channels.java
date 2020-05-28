public enum Channels {

    Zee("Zee", 10), Sony("Sony", 15), StarPlus("Star Plus", 20), Discovery("Discovery", 10), NatGeo("Nat Geo", 20);
    
    private int amount;
    private String name;

    Channels(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
