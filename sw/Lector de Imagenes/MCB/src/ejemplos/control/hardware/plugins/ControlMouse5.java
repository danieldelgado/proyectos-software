package ejemplos.control.hardware.plugins;
import java.awt.AWTException;
import java.awt.Robot;
 
class ControlMouse5 {
 
    public static void main(String[] args) throws AWTException {
        //instanciamos la clase Robot
        Robot robot = new Robot();
        robot.delay(1000);
        //desplazar la rueda del ratón
        robot.mouseWheel(-100);
    }
}














































