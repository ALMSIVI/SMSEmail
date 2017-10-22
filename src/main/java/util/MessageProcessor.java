package util;

import gui.Main;

/**
 * Created by YueWu on 10/21/2017.
 */
public class MessageProcessor {

    // process message
    public void process(String s) {
        String[] lines = s.split("\n");
        String[] info = lines[0].split(" ");

        // for send, reply and forward
        String message;
        String[] recipients;
        String subject;
        EmailFile email;
        String command = info[0].toLowerCase();

        switch(command) {
            case "update":
                //TODO: update function
                break;

            case "read":
                String[] arg = s.split("\n")[0].split(" ");
                if (arg.length != 2) {
                    // TODO: send message
                } else {
                    try {
                        int index = Integer.parseInt(arg[1]);
                        if (index <= 0 || index >= 6) {
                            //TODO: send message
                        } else { // in bound
                            //TODO: send correct message
                        }
                    } catch (Exception e) {
                        //TODO: send message
                    }
                }
                break;

            case "send":
                if(info.length != 3 || lines.length < 2 || !check(info[1])) {
                    // TODO
                }
                recipients = info[1].split(";");
                subject = info[2];
                message = s.substring(message.indexOf('\n') + 1);
                email = new EmailFile(recipients, subject, message);
                SendMail.run(email);
                break;

            case "forward":
                if(info.length != 2 || !check(info[1])) {
                    // TODO
                }
                message = Main.currentEmail.getMessage();
                if(lines.length > 1) {
                    message = s.subString(s.indexOf('\n') + 1) + "\n------\n" + message;
                }
                recipients = info[1].split(";");
                subject = "Fwd: " + Main.currentEmail.getSubject();
                email = new EmailFile(recipients, subject, message);
                SendMail.run(email);
                break;

            case "reply":
                if(info.length != 1 || lines.length < 2 || !check(info[1])) {
                    // TODO
                }
                // TODO: On xxx, sb. wrote:
                message = s.subString(s.indexOf('\n') + 1) + "\n------\n" + Main.currentEmail.getMessage();
                recipients = Main.currentEmail.getRecipients();
                subject = "Re: " +  Main.currentEmail.getSubject();
                email = new EmailFile(recipients, subject, message);
                SendMail.run(email);
                break;

            default: // wrong command
                //TODO: send usage message
        }

    }

    public boolean check(String emails) {
        if(info.length != 3)
    }
}
