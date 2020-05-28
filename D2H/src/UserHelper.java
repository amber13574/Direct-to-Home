import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class UserHelper {

    static void packsSubscription(User user, String choice, int month, Subscription subscription) {
        List<Packs> packs = new ArrayList<>();
        int finalAmount;
        int subscriptionAmount = 0;
        if (choice.equals("G")) {
            System.out.println("You have successfully subscribed the following packs - " + Packs.Gold);
            packs.add(Packs.Gold);
            subscriptionAmount = Packs.Gold.getAmount();
        } else if (choice.equals("S")) {
            System.out.println("You have successfully subscribed the following packs - " + Packs.Silver);
            packs.add(Packs.Silver);
            subscriptionAmount = Packs.Silver.getAmount();
        } else {
            System.out.println("Invalid Input");
            exit(0);
        }
        System.out.println("Monthly price:" + subscriptionAmount + " " + "Rs.");
        System.out.println("Number of months:" + month);
        System.out.println("Subscription amount:" + subscriptionAmount * month + " " + "Rs.");

        if (month >= 3) {
            System.out.println("Discount applied :" + (0.1 * subscriptionAmount * month) + " " + "Rs.");
            finalAmount = (int) ((subscriptionAmount * month) - (0.1 * subscriptionAmount * month));
        } else {
            System.out.println("Discount applied :" + 0);
            finalAmount = subscriptionAmount * month;
        }
        System.out.println("Final price after discount :" + finalAmount + " " + "Rs.");

        subscription.setPacks(packs);
        user.setSubscription(subscription);
        user.setCurrentBalance(user.getCurrentBalance() - finalAmount);
        System.out.println("Account balance :" + user.getCurrentBalance() + " " + "Rs.");
    }

    static void channelsSubscription(User user, List<String> channels, Subscription subscription) {
        int amountToBeDeducted = 0;
        List<Channels> listOfChannels = new ArrayList<>();
        for (String channel : channels) {
            if (channel.equalsIgnoreCase(Channels.Zee.toString())) {
                amountToBeDeducted += Channels.Zee.getAmount();
                listOfChannels.add(Channels.Zee);
            } else if (channel.equalsIgnoreCase(Channels.StarPlus.toString())) {
                amountToBeDeducted += Channels.StarPlus.getAmount();
                listOfChannels.add(Channels.StarPlus);
            } else if (channel.equalsIgnoreCase(Channels.Discovery.toString())) {
                amountToBeDeducted += Channels.Discovery.getAmount();
                listOfChannels.add(Channels.Discovery);
            } else if (channel.equalsIgnoreCase(Channels.NatGeo.toString())) {
                amountToBeDeducted += Channels.NatGeo.getAmount();
                listOfChannels.add(Channels.NatGeo);
            } else if (channel.equalsIgnoreCase(Channels.Sony.toString())) {
                amountToBeDeducted += Channels.Sony.getAmount();
                listOfChannels.add(Channels.Sony);
            } else {
                System.out.println("Invalid Input");
                exit(0);
            }
        }
        subscription.setChannels(listOfChannels);
        user.setSubscription(subscription);
        System.out.println("Channels added successfully");
        user.setCurrentBalance(user.getCurrentBalance() - amountToBeDeducted);
        System.out.println("Account Balance :" + user.getCurrentBalance() + "Rs.");
    }

    static void servicesSubscription(String serviceName, User user, Subscription subscription) {
        int amountToBeDeducted = 0;
        List<Services> listOfServices = new ArrayList<>();
        if (Services.LearnEnglish.getName().equalsIgnoreCase(serviceName)) {
            listOfServices.add(Services.LearnEnglish);
            amountToBeDeducted += Services.LearnEnglish.getAmount();
        } else if (Services.LearnCooking.getName().equalsIgnoreCase(serviceName)) {
            listOfServices.add(Services.LearnCooking);
            amountToBeDeducted += Services.LearnCooking.getAmount();
        } else {
            System.out.println("Invalid Input");
            exit(0);
        }
        subscription.setServices(listOfServices);
        user.setSubscription(subscription);
        System.out.println("Services subscribed successfully");
        user.setCurrentBalance(user.getCurrentBalance() - amountToBeDeducted);
        System.out.println("Account Balance :" + user.getCurrentBalance() + "Rs.");
    }

    static void viewSubscription(Subscription subscription) {
        if (subscription != null) {
            List<String> listOfPacksAndChannels = new ArrayList<>();
            for (Channels channel : subscription.getChannels()) {
                listOfPacksAndChannels.add(channel.getName());
            }
            for (Packs pack : subscription.getPacks()) {
                listOfPacksAndChannels.add(pack.getName());
            }
            System.out.println("Currently subscribed packs and channels:");
            for (String s : listOfPacksAndChannels) {
                System.out.println(s + " ");
            }

            System.out.println("Currently subscribed services:");
            for (Services service : subscription.getServices()) {
                System.out.println(service.getName() + " ");
            }
        }

    }

    static void updateDetails(User user, String email, String phone) {
        user.setEmail(email);
        user.setPhoneNumber(phone);
        System.out.println("Email and Phone updated successfully");
        System.out.println("Name : " + user.getName() + " " + "Email : " + user.getEmail() + " " + "Phone : " + user.getPhoneNumber());
    }

}
