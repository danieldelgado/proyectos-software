package ejemplos.control.hardware.plugins;
import java.awt.AWTException;
import java.awt.Robot;
 
class ControlMouse1 {
 
    public static void main(String[] args) throws AWTException {
        //instanciamos la clase Robot
        Robot robot;
		try {
			robot = new Robot();
	        //cambia la posición en pantalla del puntero a las coordenadas
	        //X=300 e Y=600.
	        robot.mouseMove(300, 600);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
    }
}