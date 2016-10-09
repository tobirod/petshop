package petshop;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Petshop {

    public static void main(String[] args) throws IOException {
        
        Menu petshopMenu = new Menu();
        
        String userInfoTemplate = "username" + "," + "userpass" + "," + "null" + "&";
        
        Files.write(Paths.get("users.txt"), userInfoTemplate.getBytes(), StandardOpenOption.CREATE);
        
        User.readUserInfo();
        
        petshopMenu.startMenu();
        
    }
    
}
