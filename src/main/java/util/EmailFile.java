package util;

/**
 * Created by YueWu on 10/21/2017.
 */
public class EmailFile {
    private String[] recipients;
    private String subject;
    private String passage;

    public EmailFile(String message) {

    }

    public EmailFile(String[] recipients, String subject, String passage) {
        this.recipients = recipients;
        this.subject = subject;
        this.passage = passage;
    }

    public String[] getRecipients() {
        return recipients;
    }

    public String getSubject() {
        return subject;
    }

    public String getPassage() {
        return passage;
    }
}
