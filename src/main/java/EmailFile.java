/**
 * Created by YueWu on 10/21/2017.
 */
public class EmailFile {
    private String[] recipients;
    private String subject;
    private String message;
    public static String[] COMMAND = {"SEND", "FORWARD", "REPLY"};
    public static int MIN_INFO = 3;
    public static int MIN_LINE = 2;

    // default
    public EmailFile(String[] recipients, String subject, String message) {
        this.recipients = recipients;
        this.subject = subject;
        this.message = message;
    }

    // send
    public EmailFile(String message) {
        String lines[] = message.split("\n");
        String info[] = lines[0].split(" ");

        // TODO: format error
        if( info.length < MIN_INFO
                || info[0] != COMAMND[0]
                || lines.length <= MIN_LINE ) {

        }

        else {
            int subject_index = info.length - 1;
            this.recipients = Arrays.copyOfRange(info, 1, subject_index - 1);
            this.subject = info[subject_index];
            this.message = message.substring(message.indexOf('\n') + 1);
        }

    }


    public String[] getRecipients() {
        return recipients;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return passage;
    }


}
