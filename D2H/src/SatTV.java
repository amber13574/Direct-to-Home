import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SatTV {

    private static final int INITIAL_BALANCE = 100;

    public static void showAvailablePacks() {
        System.out.println("Available packs for subscription");
        for (Packs pack : Packs.values()) {
            System.out.print(pack.getName() + " " + "packs :" + " ");
            for (Channels channel : pack.getChannels()) {
                System.out.print(channel.getName() + " ");
            }
            System.out.println(":" + " " + pack.getAmount() + " " + "Rs.");
        }
        System.out.println("Available channels for subscription");
        for (Channels channels : Channels.values()) {
            System.out.println(channels.getName() + ":" + " " + channels.getAmount() + " " + "Rs.");
        }
        System.out.println("Available services for subscription");
        for (Services services : Services.values()) {
            System.out.println(services.getName() + " " + "services" + " " + ":" + " " + services.getAmount() + " " + "Rs.");
        }
    }

    public static void main(String[] args) {

        User user = new User(INITIAL_BALANCE, "Amber", "amber@13574", "7767983611", new Subscription(null, null, null));
        int value = 0;
        Scanner sc = new Scanner(System.in);
        try {
            while (value != -1) {
                System.out.println("--------------- Press -1 to exit -------------------");
                System.out.println("Enter your Choice :");
                value = sc.nextInt();
                switch (value) {
                    case 1:
                        System.out.println("View current balance in the account");
                        System.out.println("Current balance is " + user.getCurrentBalance());
                        break;
                    case 2:
                        System.out.println("Enter the amount to recharge: ");
                        int amount = sc.nextInt();
                        user.setCurrentBalance(user.rechargeAccount(amount));
                        System.out.println("Recharge completely successfully.Current balance is " + user.getCurrentBalance());
                        break;
                    case 3:
                        System.out.println("View available packs,channels,services");
                        showAvailablePacks();
                        break;
                    case 4:
                        System.out.println("Subscribe to channel packs");
                        System.out.println("Enter the Pack you wish to subscribe: (Silver:'S',Gold:'G):");
                        String choice = sc.next();
                        System.out.println(choice);
                        System.out.print("Enter the months:");
                        int months = sc.nextInt();
                        System.out.println(months);
                        UserHelper.packsSubscription(user, choice, months, user.getSubscription());
                        System.out.println("Email notification sent successfully");
                        System.out.println("SMS notification sent successfully");
                        break;
                    case 5:
                        System.out.println("Add Channels to existing subscription");
                        System.out.println("Enter channels names to add");
                        String channel = sc.next();
                        List<String> channels = new ArrayList<>();
                        String[] s = channel.split(",");
                        for (String s1 : s) {
                            channels.add(s1);
                        }
                        UserHelper.channelsSubscription(user, channels, user.getSubscription());
                        break;
                    case 6:
                        System.out.println("Subscribe to special services");
                        System.out.println("Enter the service name :");
                        String serviceName = sc.next();
                        UserHelper.servicesSubscription(serviceName, user, user.getSubscription());
                        System.out.println("Email notification sent successfully");
                        System.out.println("SMS notification sent successfully");
                        break;
                    case 7:
                        System.out.println("View current subscription details");
                        UserHelper.viewSubscription(user.getSubscription());
                        break;
                    case 8:
                        System.out.println("Update email and phone number for notifications");
                        System.out.println("Enter the email:");
                        String email = sc.next();
                        System.out.println("Enter phone:");
                        String phone = sc.next();
                        UserHelper.updateDetails(user, email, phone);
                        break;
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }


}
