package gui;

import com.twilio.twiml.Body;
import com.twilio.twiml.Message;
import com.twilio.twiml.MessagingResponse;
import util.*;

import java.net.URLDecoder;

import static spark.Spark.post;

public class Main {

    private static String phone;
    private static String email;
    private static String password;

    public static EmailFile currentEmail;

    public static void main(String[] args) {
        new MainFrame().launchFrame();

        post("receive-sms", (req, res) -> {

            String bodyMessage = getMessageBody(req.body());

            EmailFile newEmail = new EmailFile(bodyMessage);
            SendMail.run(newEmail, email, password);

            Message sms = new Message.Builder().body(new Body("mail sent")).build();
            MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();

            return twiml.toXml();
        });

    }

    private static String getMessageBody(String str) {
        String[] attributes = str.split("&");
        for (String s : attributes) {
            if (s.substring(0, 4).equals("Body")) {
                try {
                    return URLDecoder.decode(s.substring(5), "UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }

            }
        }
        return "";
    }

    public static void setPhone(String s) {
        phone = s;
    }

    public static void setEmail(String s) {
        email = s;
    }

    public static void setPassword(String s) {
        password = s;
    }
}
