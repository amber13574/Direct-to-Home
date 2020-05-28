public enum Packs {

    Silver("Silver", 50, new Channels[]{Channels.Sony, Channels.Zee, Channels.StarPlus}), Gold("Gold", 100, new Channels[]{Channels.Sony, Channels.Zee, Channels.StarPlus, Channels.NatGeo, Channels.Discovery});
    private int amount;
    private String name;
    private Channels[] channels;

    Packs(String name, int amount, Channels[] channels) {
        this.name = name;
        this.amount = amount;
        this.channels = channels;
    }

    public Channels[] getChannels() {
        return channels;
    }

    public void setChannels(Channels[] channels) {
        this.channels = channels;
    }


    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }
}
