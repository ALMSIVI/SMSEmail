package util;

/**
 * Created by YueWu on 10/21/2017.
 */
public class Message {
    private final String[] COMMANDS = {"update", "read", "send", "reply", "forward"};

    public Message(String s) {
        String command = s.split("\n")[0].split(" ")[0].toLowerCase();

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
            case "forward":
            case "reply":
                EmailFile toSend = new EmailFile(s);
                // TODO: send email
                break;

            default: // wrong command
                //TODO: send usage message
        }

    }
}
