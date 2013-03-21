
package ejemplos.control.hardware.plugins;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
 
class ControlMouse3 {
 
    public static void main(String[] args) throws AWTException {
        //instanciamos la clase Robot
        Robot robot = new Robot();
 
        //click con el boton izquierdo
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
    }
}