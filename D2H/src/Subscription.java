import java.util.List;

public class Subscription {

    private List<Packs> packs;
    private List<Channels> channels;
    private List<Services> services;

    public Subscription(List<Packs> packs, List<Channels> channels, List<Services> services) {
        this.packs = packs;
        this.channels = channels;
        this.services = services;
    }


    public List<Packs> getPacks() {
        return packs;
    }

    public void setPacks(List<Packs> packs) {
        this.packs = packs;
    }

    public List<Channels> getChannels() {
        return channels;
    }

    public void setChannels(List<Channels> channels) {
        this.channels = channels;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }
}
