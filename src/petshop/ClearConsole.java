package petshop;

import java.awt.Robot;
import java.awt.AWTException;
import java.util.concurrent.TimeUnit;

public class ClearConsole {
    
    public void clearConsoleRobot() {
        
        try {

        Robot pressButtonBot = new Robot();

        pressButtonBot.keyPress(17);
        pressButtonBot.keyPress(76);
        pressButtonBot.keyRelease(17);
        pressButtonBot.keyRelease(76);

        } catch (AWTException ex) {
        System.out.println(ex);
        }

        try {

        TimeUnit.MILLISECONDS.sleep(200);

        } catch (InterruptedException clearConsoleRobotEx) {
        System.out.println(clearConsoleRobotEx);
        }
    }
    
}
