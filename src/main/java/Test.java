// Sending an SMS using the Twilio API
// Install the Java helper library from twilio.com/docs/java/install
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class Test {
    // Find your Account Sid and Token at twilio.com/user/account
    public static final String ACCOUNT_SID = "ACd71f95a55c821ee457d34249f4f8edbe";
    public static final String AUTH_TOKEN = "b7a6d4eca541b847bc9e8fda67bcc406";

    private static final String MY_NUM = "+14159681247";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message
                .creator(new PhoneNumber("+14252463696"), new PhoneNumber(MY_NUM),
                        "Tomorrow's forecast in Financial District, San Francisco is Clear")
                .create();
        System.out.println(message.getSid());
    }
}