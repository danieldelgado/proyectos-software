package pruebas.serializablees;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
public class GetPersonDetails {

	public static void main(String[] args) {
		String filename = "person.txt";
		List pDetails = null;
		FileInputStream fis = null;
		ObjectInputStream in = null;
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			pDetails = (ArrayList) in.readObject();
			in.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		// print out the size
		System.out.println(pDetails);
		System.out.println("Person Details Size: " + pDetails.size());
		System.out.println();
	}
}