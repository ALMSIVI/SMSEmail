
import static spark.Spark.post;

import com.twilio.twiml.*;

import java.net.*;

public class TestReceive {

    public static void main(String[] args) {

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

}
