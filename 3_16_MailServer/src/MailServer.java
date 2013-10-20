import java.util.*;

public class MailServer {
    
    void printWelcome() {
        System.out.println("Welcome to my mail server!");
    }
       
    void printMail(From f, To t, Data d) {
        System.out.println(f.get());
        System.out.println(t.get());
        List<String> lines = new ArrayList<String>();
        lines = d.get();
        for (int i = 0; i < lines.size(); ++i) {
            System.out.println(lines.get(i));
        }        
    }
    
    String getCommandAndAddressFromUser(String cmd) {
        boolean okToProceed = false;
        String entry = "";
        String address = "";
        while (!okToProceed) {
            entry = promptUser();
            if (validAddressLine(cmd, entry)) {
                address = entry.substring(cmd.length());
                okToProceed = true;
            } else if (entry == "QUIT") {
                System.out.println("Bye!");
                System.exit(0);
            }
        }
        return address;
    }
    
    boolean validAddressLine(String cmd, String entry) {
        boolean isOk = false;
        if (entry.startsWith(cmd)) {
            String part2 = entry.substring(cmd.length());
            System.out.println("part2 " + part2);
            if (looksLikeAnEmailAddress(part2)) {
                isOk = true;
            } 
        } 
        return isOk;
    }
    
    boolean looksLikeAnEmailAddress(String str) {
        boolean isOk = true;
        char[] chars = str.toCharArray();
        int numats = 0;
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == '@') {
                if (i == 1 || i == chars.length - 1 || numats > 0) {
                    isOk = false;
                    break;
                } else {
                    ++numats;
                }
            }
        }
        return isOk;
    }
    
    class From {
        String command = "MAIL FROM:";
        String fromAddress;
        
        public void getFromUser() {
            fromAddress = getCommandAndAddressFromUser(command);            
        }
        
        public String get() {
            return fromAddress;
        }
    }
    
    class To {
        String command = "RCPT TO:";
        String toAddress;

        public void getFromUser() {
            toAddress = getCommandAndAddressFromUser(command);
        }
        
        public String get() {
            return toAddress;
        }
    }

    class Data {
        String command = "DATA";
        List<String> body = new ArrayList<String>();

        public List<String> get() {
            return body;
        }
        
        public void getFromUser() {
            body = getCommandAndDataFromUser(command);
        }
        
        List<String> getCommandAndDataFromUser(String cmd) {
            boolean okToProceed = false;
            List<String> lines = new ArrayList<String>();
            String entry = "";
            while (!okToProceed) {
                entry = promptUser();
                if (entry.trim() == cmd) {
                    boolean endBody = false;
                    String curline;
                    while (!endBody) {
                        curline = System.console().readLine();
                        if (curline == ".") {
                            endBody = true;
                        } else {
                            lines.add(curline);
                        }
                    }
                }
            }
            return lines;
        }
        
    }
    
    String promptUser() {
        System.out.print(">>> ");
        return System.console().readLine();
    }
    
    public static void main(String[] args) {
        MailServer mailserver = new MailServer();
        mailserver.printWelcome();
        
        // OuterClass.InnerClass innerObject = outerObject.new InnerClass();
        MailServer.From from = mailserver.new From();
        from.getFromUser();
        
        MailServer.To to = mailserver.new To();
        to.getFromUser();
        
        MailServer.Data data = mailserver.new Data();
        data.getFromUser();
        
        mailserver.printMail(from, to, data);
    }
}