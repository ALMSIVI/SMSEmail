package util;
import gui.Main;

import java.util.Arrays;

/**
 * Created by YueWu on 10/21/2017.
 */
public class EmailFile {
    private String[] recipients;
    private String subject;
    private String message;
    public static int MIN_INFO = 3;
    public static int MIN_LINE = 2;

    public EmailFile(String[] recipients, String subject, String message) {
        this.recipients = recipients;
        this.subject = subject;
        this.message = message;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }


}
