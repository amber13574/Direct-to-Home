public enum Services {

    LearnEnglish("LearnEnglish",200),LearnCooking("LearnCooking",100);
    private String name;
    private int amount;

    Services(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
