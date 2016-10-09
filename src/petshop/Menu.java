package petshop;

import java.util.Scanner;
import java.io.IOException;

public class Menu {
    
User petshopUser = new User();
LogIn petshopLogIn = new LogIn();
ClearConsole petshopClearConsole = new ClearConsole();

private Scanner menuInput = new Scanner(System.in);

    public void startMenu() throws IOException {
        
        System.out.println("\nHej och välkommen till Zoobutiken!");
        System.out.println("För att navigera i menyn, skriv in den siffra som motsvarar ditt val och avsluta med \"Enter\".\n");
        
        System.out.println("1 - Skapa ett nytt konto.");
        System.out.println("2 - Logga in med existerande konto.");
        System.out.println("3 - Avsluta programmet.");
        
        System.out.println("___________________________________________________________________________________________________\n");
        
        String navigateMenu = menuInput.nextLine();
        
        switch (navigateMenu) {
            
            case "1":
                petshopClearConsole.clearConsoleRobot();
                createNewAccountMenu();
                break;
            case "2":
                petshopClearConsole.clearConsoleRobot();
                logInMenu();
                break;
            case "3":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Tack för att du använder Zoobutiken!");
                break;
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Siffran motsvarar inget val i listan, var god försök igen.");
                startMenu();
                break;
        }
        
    }
    
    public void createNewAccountMenu() throws IOException {

        System.out.println("\n1 - Skapa nytt kundkonto.");
        System.out.println("2 - Skapa nytt adminkonto.");
        System.out.println("3 - Tillbaka till föregående meny.");

        System.out.println("___________________________________________________________________________________________________\n");

        String navigateMenu = menuInput.nextLine();

        switch (navigateMenu) {

            case "1":
                petshopClearConsole.clearConsoleRobot();
                setUserInfoMenu();
                break;
            case "2":
                petshopClearConsole.clearConsoleRobot();
                setAdminInfoMenu();
                break;
            case "3":
                petshopClearConsole.clearConsoleRobot();
                startMenu();
                break;
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Siffran motsvarar inget val i listan, var god försök igen.");
                createNewAccountMenu();
                break;
        }
    }

    public void setUserInfoMenu() throws IOException {
        
        System.out.println("\nVar god ange önskat användarnamn - om du vill avbryta, skriv \"avbryt\":");
        System.out.println("___________________________________________________________________________________________________\n");
        
        petshopUser.userNameBuffer = menuInput.nextLine();
        
        if (petshopUser.userNameBuffer.equalsIgnoreCase("avbryt")) {
            petshopUser.userNameBuffer = "";
            petshopClearConsole.clearConsoleRobot();
            startMenu();
        } else {
            
        petshopUser.checkIfUserNameTaken();
        
        petshopClearConsole.clearConsoleRobot();
        
        System.out.println("\nDitt användarnamn är " + petshopUser.userName + ".\n");
        System.out.println("Var god ange önskat lösenord - om du vill avbryta, skriv \"avbryt\":");
        System.out.println("___________________________________________________________________________________________________\n");
        
        petshopUser.userPass = menuInput.nextLine();
        
        if (petshopUser.userPass.equalsIgnoreCase("avbryt")) {
            petshopUser.userName = "";
            petshopUser.userPass = "";
            petshopClearConsole.clearConsoleRobot();
            startMenu();
        } else {
        
        petshopUser.createNewAccount();
        
        petshopClearConsole.clearConsoleRobot();
        
        startMenu();
        }
        }
        
    }
    
    public void setAdminInfoMenu() throws IOException {

        System.out.println("\nVar god ange lösenordet för administrativa rättigheter - om du vill avbryta skriv \"avbryt\":");
        System.out.println("___________________________________________________________________________________________________\n");

        petshopUser.adminPassBufferInput = menuInput.nextLine();
        
        if (petshopUser.adminPassBufferInput.equalsIgnoreCase("avbryt")) {
            petshopUser.adminPassBufferInput = "";
            petshopClearConsole.clearConsoleRobot();
            startMenu();
        } else {

        petshopUser.adminPassAuth();

        petshopClearConsole.clearConsoleRobot();

        System.out.println("\nVar god ange önskat användarnamn - om du vill avbryta skriv \"avbryt\":");
        System.out.println("___________________________________________________________________________________________________\n");

        petshopUser.userNameBuffer = menuInput.nextLine();
        
        if (petshopUser.userNameBuffer.equalsIgnoreCase("avbryt")) {
            petshopUser.userNameBuffer = "";
            petshopClearConsole.clearConsoleRobot();
            startMenu();
        } else {
        
        petshopUser.checkIfUserNameTaken();

        petshopClearConsole.clearConsoleRobot();

        System.out.println("\nDitt användarnamn är " + petshopUser.userName + ".\n");
        System.out.println("Var god ange önskat lösenord - om du vill avbryta skriv \"avbryt\":");
        System.out.println("___________________________________________________________________________________________________\n");

        petshopUser.userPass = menuInput.nextLine();
        
        if (petshopUser.userPass.equalsIgnoreCase("avbryt")) {
            petshopUser.userPass = "";
            petshopClearConsole.clearConsoleRobot();
            startMenu();
        } else {

        petshopUser.createNewAccount();
        
        petshopClearConsole.clearConsoleRobot();
        
        startMenu();
        }
        }
        }
        
    }
    
    public void logInMenu() throws IOException {
        
        System.out.println("\nVar god ange användarnamn - om du vill avbryta skriv \"avbryt\":");
        System.out.println("___________________________________________________________________________________________________\n");
        
        petshopLogIn.logInBuffer = menuInput.nextLine();
        
        if (petshopLogIn.logInBuffer.equalsIgnoreCase("avbryt")) {
            petshopLogIn.logInBuffer = "";
            petshopClearConsole.clearConsoleRobot();
            startMenu();
        } else {
        
        petshopLogIn.logIn();
        
        petshopClearConsole.clearConsoleRobot();
        
        System.out.println("\nFörsöker logga in användare " + petshopLogIn.logInBuffer + ".\n");
        System.out.println("Var god ange lösenord - om du vill avbryta skriv \"avbryt\":");
        System.out.println("___________________________________________________________________________________________________\n");
        
        petshopLogIn.logInBuffer = menuInput.nextLine();
        
        if (petshopLogIn.logInBuffer.equalsIgnoreCase("avbryt")) {
            petshopLogIn.logInBuffer = "";
            petshopClearConsole.clearConsoleRobot();
            startMenu();
        } else {
        
        petshopLogIn.checkLogInPass();
        
        petshopLogIn.checkIfAdmin();
        
        if (petshopLogIn.checkAdmin == true) {
            
            adminMenu();
            
        } else if (petshopLogIn.checkAdmin == false) {
            
            userMenu();
        }
        }
        }
    }
    
    public void adminMenu() throws IOException {
        petshopClearConsole.clearConsoleRobot();
        
        System.out.println("\n1 - Sök efter produkt.");
        System.out.println("2 - Granska produktlista.");
        System.out.println("3 - Lägg till produkt.");
        System.out.println("4 - Ta bort produkt.");
        System.out.println("5 - Uppdatera produkt.");
        System.out.println("6 - Avsluta programmet.");
        
        System.out.println("___________________________________________________________________________________________________\n");
        
        String navigateMenu = menuInput.nextLine();
        
        switch (navigateMenu) {
            
            case "1":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("1 - Sök efter produkt.");
                break;
            case "2":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("2 - Granska produktlista.");
                break;
            case "3":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("3 - Lägg till produkt.");
                break;
            case "4":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("4 - Ta bort produkt.");
                break;
            case "5":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("5 - Uppdatera produkt.");
                break;
            case "6":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Tack för att du använder Zoobutiken!");
                break;
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Siffran motsvarar inget val i listan, var god försök igen.");
                startMenu();
                break;
        }
    }
    
    public void userMenu() throws IOException {
        petshopClearConsole.clearConsoleRobot();
        
        System.out.println("\n1 - Sök efter produkt.");
        System.out.println("2 - Granska produktlista.");
        System.out.println("3 - Avsluta programmet.");
        
        System.out.println("___________________________________________________________________________________________________\n");
        
        String navigateMenu = menuInput.nextLine();
        
        switch (navigateMenu) {
            
            case "1":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("1 - Sök efter produkt.");
                break;
            case "2":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("2 - Granska produktlista.");
                break;
            case "3":
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Tack för att du använder Zoobutiken!");
                break;
            default:
                petshopClearConsole.clearConsoleRobot();
                System.out.println("Siffran motsvarar inget val i listan, var god försök igen.");
                startMenu();
                break;
        }
    }
    
}
