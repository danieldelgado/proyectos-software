package pruebas.serializablees;
 import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Main2 {
  public static void main(String[] argv) throws Exception {
    File temp = File.createTempFile("pattern", ".dat");

    temp.deleteOnExit();

    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
    out.write("asdf");
    out.close();
  }
}