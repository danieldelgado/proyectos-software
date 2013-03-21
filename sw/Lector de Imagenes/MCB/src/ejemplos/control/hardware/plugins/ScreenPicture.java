package ejemplos.control.hardware.plugins;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
 
class ScreenPicture {
 
    public static void main(String[] args) throws AWTException, IOException {
        //instanciamos la clase Robot
        Robot robot = new Robot();
 
        //obtenemos nuestra pantalla como imagen
        BufferedImage pantalla = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
 
        //creamos un archivo de extensión .JPG en el directorio home del usuario del sistema
        File file = new File(System.getProperty("user.home") + File.separator + "pantalla.jpg");
 
        System.out.println(file);
        
        //guardamos el contenido de la imagen en el archivo .JPG
        ImageIO.write(pantalla, "jpg", file);
    }
}