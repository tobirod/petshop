package petshop;

import java.util.Scanner;

public class LogIn {

ClearConsole petshopClearConsole = new ClearConsole();

private Scanner menuInput = new Scanner(System.in);

String logInName;
String logInPass;
String logInBuffer;

Boolean userExists = false;
Boolean passMatch = false;
Boolean checkAdmin = false;

int userCount = 0;
int passCount = 0;
    
    public void logIn() {
        
        while (userCount < User.readUserInfo().size()) {
            
            if (logInBuffer.equalsIgnoreCase(User.readUserInfo().get(userCount).userName)) {
                userExists = true;
                passCount = userCount;
            }
            userCount++;
        }
        
        if (!userExists) {
            noUserFound();
        }
    }
    
    public void checkLogInPass() {
                
        if (logInBuffer.equals(User.readUserInfo().get(passCount).userPass)) {
            passMatch = true;
        } else if (!passMatch) {
            noPassMatch();
        }
    }
    
    public void checkIfAdmin() {
        
        if (User.readUserInfo().get(passCount).isAdmin.equalsIgnoreCase("true")) {
            checkAdmin = true;
        } else if (User.readUserInfo().get(passCount).isAdmin.equalsIgnoreCase("false")) {
            checkAdmin = false;
        }
    }
    
    public void noUserFound() {
        
        petshopClearConsole.clearConsoleRobot();

        System.out.println("\nFinns ingen användare vid namn " + logInBuffer + ". Försök igen.");
        System.out.println("\nVar god ange användarnamn - om du vill avbryta skriv \"avbryt\":");
        System.out.println("___________________________________________________________________________________________________\n");

        logInBuffer = menuInput.nextLine();
        
        if (logInBuffer.equalsIgnoreCase("avbryt")) {
        logInBuffer = "";
        petshopClearConsole.clearConsoleRobot();
        }
        
        userCount = 0;

        logIn();
    }
    
    public void noPassMatch() {
        
        petshopClearConsole.clearConsoleRobot();

        System.out.println("\nFel lösenord för användare " + User.readUserInfo().get(passCount).userName + ". Försök igen.");
        System.out.println("\nVar god ange lösenord - om du vill avbryta skriv \"avbryt\":");
        System.out.println("___________________________________________________________________________________________________\n");

        logInBuffer = menuInput.nextLine();
        
        if (logInBuffer.equalsIgnoreCase("avbryt")) {
        logInBuffer = "";
        petshopClearConsole.clearConsoleRobot();
        }

        checkLogInPass();
    }
}
