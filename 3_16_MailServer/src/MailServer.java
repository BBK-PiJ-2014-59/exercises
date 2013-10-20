public class MailServer {
    
    printWelcome() {
        System.out.println("Welcome to my mail server!");
    }
       
    String getCommandAndAddressFromUser(String cmd) {
        boolean okToProceed = false;
        String entry;
        while (!okToProceed) {
            entry = promptUser();
            if (validAddressLine(cmd, entry)) {
                okToProceed = true;
            } else if (entry == "QUIT") {
                quit();
            }
        }
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
        public String getFromUser() {
            return getCommandAndAddressFromUser("MAIL FROM:");            
        }
    }
    
    class To {
        public String getFromUser() {
            return getCommandAndAddressFromUser("RCPT TO:");
        }
    }

    class Data {
        
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
        
        mailserver.printMail();
    }
}