package pruebas.serializablees;
import java.io.File;

public class Main {
  public static void main(String[] argv) throws Exception {

    File file1 = new File("./filename");
    System.out.println(file1.getAbsolutePath());
    File file2 = new File("filename");
    System.out.println(file2.getAbsolutePath());
    System.out.println(file1.equals(file2));

    file1 = file1.getCanonicalFile();
    file2 = file2.getCanonicalFile();
    System.out.println(file1.equals(file2));
  }
}