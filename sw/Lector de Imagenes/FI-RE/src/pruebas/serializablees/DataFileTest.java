package pruebas.serializablees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DataFileTest {
	static void writeData(Employee2 e, PrintWriter out) throws IOException {
		e.writeData(out);
	}

	static Employee2 readData(BufferedReader in) throws IOException {
		Employee2 e = new Employee2();
		e.readData(in);
		return e;
	}

	public static void main(String[] args) {
		Employee2 staff = new Employee2("Java Source", 35500);

		staff.raiseSalary(5.25);

		try {
			PrintWriter out = new PrintWriter(new FileWriter("employee.dat"));
			writeData(staff, out);
			out.close();
		} catch (IOException e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}

		try {
			BufferedReader in = new BufferedReader(new FileReader("employee.dat"));
			Employee2 e = readData(in);
			e.print();
			in.close();
		} catch (IOException e) {
			System.out.print("Error: " + e);
			System.exit(1);
		}
	}
}

class Employee2 {

	private String name;

	private double salary;

	public Employee2(String n, double s) {
		name = n;
		salary = s;
	}

	public Employee2() {
	}

	public void print() {
		System.out.println(name + " " + salary);
	}

	public void raiseSalary(double byPercent) {
		salary *= 1 + byPercent / 100;
	}

	public void writeData(PrintWriter out) throws IOException {
		out.println(name + "|" + salary);
	}

	public void readData(BufferedReader in) throws IOException {
		String s = in.readLine();
		StringTokenizer t = new StringTokenizer(s, "|");

		name = t.nextToken();

		salary = Double.parseDouble(t.nextToken());
	}

}
