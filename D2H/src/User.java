public class User {

    private final String name;
    private String email;
    private String phoneNumber;
    private int currentBalance;
    private Subscription subscription;

    User(int currentBalance, String name, String email, String phoneNumber, Subscription subscription) {
        this.currentBalance = currentBalance;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.subscription = subscription;
    }

    public String getName() {
        return name;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }


    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int rechargeAccount(int amount) {
        return getCurrentBalance() + amount;
    }
}
