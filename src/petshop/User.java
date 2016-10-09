package petshop;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class User {

ClearConsole petshopClearConsole = new ClearConsole();

private Scanner menuInput = new Scanner(System.in);

String userName;
String userNameBuffer;
String userPass;

String isAdmin = "false";

String adminPassInput;
String adminPassBufferInput;
String adminPass = "admin123";

    public void createNewAccount() {
        try {
        
        petshopClearConsole.clearConsoleRobot();
        
        String userInfo = userName.toLowerCase() + "," + userPass + "," + isAdmin + "&";
        
        try (BufferedWriter writeToFile = new BufferedWriter(new FileWriter("users.txt", true))) {
            writeToFile.write(userInfo);
        }
        
        System.out.println("\nDina användaruppgifter är sparade. Återvänder till startmenyn...");
        
        try {

        TimeUnit.MILLISECONDS.sleep(1000);

        } catch (InterruptedException ex) {
        System.out.println(ex);
        }
        
        isAdmin = "false";
        } catch (IOException createNewAccountEx) {
            System.out.println(createNewAccountEx);
        }
    }
    
    public void adminPassAuth() {
        
        if (adminPassBufferInput.equals(adminPass)) {
            isAdmin = "true";
        } else if (adminPassBufferInput.equalsIgnoreCase("avbryt")) {
        
        } else {
            while (!adminPassBufferInput.equals(adminPass)) {
                petshopClearConsole.clearConsoleRobot();
                System.out.println("\nLösenordet underkänt. Försök igen.");
                
                System.out.println("\nVar god ange lösenordet för administrativa rättigheter - om du vill avbryta skriv \"avbryt\".");
                System.out.println("___________________________________________________________________________________________________\n");
                
                adminPassBufferInput = menuInput.nextLine();
                
                if (adminPassBufferInput.equalsIgnoreCase("avbryt")) {
                    break;
                }
            }
        if (adminPassBufferInput.equals(adminPass)) {
            isAdmin = "true";
        }
        }
    }
    
    public static ArrayList<User> readUserInfo() {
        ArrayList<User> userList = new ArrayList();
        
        try {
        
        BufferedReader readFile = new BufferedReader(new FileReader("users.txt"));
        
        String fileContents = readFile.readLine();
        
        String[] splitUsers = fileContents.split("&");
        
        int count = 0;
        String userInfoSplitter;
        
        while(count < splitUsers.length){
            userInfoSplitter = splitUsers[count];
            String[] userBuffer = userInfoSplitter.split(",");
            
            User readUserIntoUserList = new User();
            
            readUserIntoUserList.userName = userBuffer[0];
            readUserIntoUserList.userPass = userBuffer[1];
            readUserIntoUserList.isAdmin = userBuffer[2];
            
            userList.add(readUserIntoUserList);
            
            count++;
        }
        } catch (IOException readUserInfoEx) {
            System.out.println(readUserInfoEx);
        }
        return userList;
    }
    
    public void checkIfUserNameTaken() {
        
        for (int userCount = 0; userCount < User.readUserInfo().size(); userCount++) {
            
            while (User.readUserInfo().get(userCount).userName.equalsIgnoreCase(userNameBuffer)) {

                petshopClearConsole.clearConsoleRobot();
                
                System.out.println("Användarnamnet är upptaget. Försök igen.");
                System.out.println("\nVar god ange önskat användarnamn - om du vill avbryta skriv \"avbryt\":");
                System.out.println("___________________________________________________________________________________________________\n");

                userNameBuffer = menuInput.nextLine();
                
                if (userNameBuffer.equalsIgnoreCase("avbryt")) {
                userNameBuffer = "";
                petshopClearConsole.clearConsoleRobot();
                break;
                }
            }
        }
        if (userNameBuffer.equalsIgnoreCase("avbryt")) {
        userNameBuffer = "";
        petshopClearConsole.clearConsoleRobot();
        } else {
        userName = userNameBuffer;
        }
    }
}