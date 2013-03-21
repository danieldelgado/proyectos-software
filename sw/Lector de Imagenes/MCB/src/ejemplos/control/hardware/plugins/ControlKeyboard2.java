package ejemplos.control.hardware.plugins;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
 
class ControlKeyboard2 {
 
    //arreglo de teclas para escribir "HOLA MUNDO" en la ventana activa del escritorio
    final static int teclas[] = {
        KeyEvent.VK_H, KeyEvent.VK_O,
        KeyEvent.VK_L, KeyEvent.VK_A,
        KeyEvent.VK_SPACE, KeyEvent.VK_M,
        KeyEvent.VK_U, KeyEvent.VK_N,
        KeyEvent.VK_D, KeyEvent.VK_O
    };
 
    public static void main(String[] args) throws AWTException {
        //instanciamos la clase Robot
        Robot robot = new Robot();
 
        //esperamos 2 segundos antes de empezar a escribir
        robot.delay(2000);
 
        //iteramos a través del arreglo de teclas
        for (int i = 0 ; i < teclas.length ; i++) {
            //presionamos y soltamos cada tecla del array
            robot.keyPress(teclas[i]);
            robot.keyRelease(teclas[i]);
 
            //dormimos el robot por 250 mili segundos luego de usar cada tecla
            robot.delay(250);
        }
    }
}