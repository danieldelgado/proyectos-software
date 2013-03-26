package pruebas.serializablees;
import java.io.File;

public class Main3{
  public static void main(String[] args) throws Exception{
    File f = File.createTempFile("temp_", null);
    
    System.out.println(f.getAbsolutePath());
    
    f.deleteOnExit();
  }
}