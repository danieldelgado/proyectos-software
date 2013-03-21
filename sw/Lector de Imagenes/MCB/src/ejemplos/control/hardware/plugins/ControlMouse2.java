package ejemplos.control.hardware.plugins;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.InputEvent;
 
class ControlMouse2 {
 
    public static void main(String[] args) throws AWTException {
        //instanciamos la clase Robot
        Robot robot = new Robot();
 
        //click con el botón derecho
        robot.mousePress(InputEvent.BUTTON3_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_MASK);
    }
}