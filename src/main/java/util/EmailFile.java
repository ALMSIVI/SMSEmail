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

    // For send
    public EmailFile(String message) {
        String lines[] = message.split("\n");
        String info[] = lines[0].split(" ");

        // TODO: format error
        if( info.length < MIN_INFO || lines.length <= MIN_LINE ) {
            // send text message
        }

        else {

            switch(info[0].toLowerCase()) {
                case "send":
                    this.recipients = info[1].split(";");
                    this.subject = info[2];
                    this.message = message.substring(message.indexOf('\n') + 1);
                    break;

                case "forward":
                    this.message = Main.currentEmail.getMessage();
                    this.recipients = info[1].split(";");
                    this.subject = "Fwd: " + Main.currentEmail.getSubject();
                    break;

                case "reply":
                    // TODO: On xxx, sb. wrote:
                    this.message = lines[1] + "\n------\n" +  Main.currentEmail.getMessage();
                    this .recipients = Main.currentEmail.getRecipients();
                    this.subject = "Re: " +  Main.currentEmail.getSubject();
                    break;
            }

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
