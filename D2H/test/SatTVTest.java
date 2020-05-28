import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SatTVTest {

    private UserHelper m_userHelper;

    @Test
    public void userSubscription() throws Exception {
        User user = new User(600, "testUser", "testUser@13574", "7767983611", new Subscription(null, null, null));
        List<String> channels = new ArrayList<>();
        channels.add(Channels.Discovery.getName());
        m_userHelper.packsSubscription(user, "S", 3, user.getSubscription());
        m_userHelper.channelsSubscription(user, channels, user.getSubscription());
        m_userHelper.servicesSubscription(Services.LearnCooking.getName(), user, user.getSubscription());

        for (Packs pack : user.getSubscription().getPacks()) {
            Assert.assertNotNull(pack);
            Assert.assertEquals("Packs are not equal",pack.getName(), Packs.Silver.getName());
        }
        for (Channels channel : user.getSubscription().getChannels()) {
            Assert.assertNotNull(channel);
            Assert.assertEquals("Channels are not equal",channel.getName(), Channels.Discovery.getName());
        }

        for (Services service : user.getSubscription().getServices()) {
            Assert.assertNotNull(service);
            Assert.assertEquals("Services are not equal",service.getName(), Services.LearnCooking.getName());
        }

        System.out.println("Test case passed successfully");
    }

}
