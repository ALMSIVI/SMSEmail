package util;
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

    // For send
    public EmailFile(String message) {
        String lines[] = message.split("\n");
        String info[] = lines[0].split(" ");

        // TODO: format error
        if( info.length < MIN_INFO || lines.length <= MIN_LINE ) {
            // send text message
        }

        else {
            this.recipients = info[1].split(";");
            this.subject = info[2];
            this.message = message.substring(message.indexOf('\n') + 1);
        }

    }

    // For forward and reply
    public EmailFile(EmailFile original, String newInfo, boolean forward) {
        if (forward) { // forward
            this.message = original.getMessage();
            this.recipients = newInfo.split(";");
            this.subject = "Fwd: " + original.getSubject();
        } else { // reply
            // TODO: On xxx, sb. wrote:
            this.message = newInfo + "\n------\n" + original.getMessage();
            this .recipients = original.getRecipients();
            this.subject = "Re: " + original.getSubject();
        }
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
