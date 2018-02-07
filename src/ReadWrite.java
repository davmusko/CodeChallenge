import java.io.*;
import java.nio.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ReadWrite {
	public static void writeToFile(String dirString, String fileString, Employees employee) {

		Path writeFile = Paths.get(dirString, fileString);
		File file = writeFile.toFile();

		try {
			PrintWriter printOut = new PrintWriter(new FileOutputStream(file, true));
			printOut.println(employee);
			printOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList readFromFile(String dirString, String filePath) {
		Path readFile = Paths.get(dirString, filePath);
		ArrayList<Employees> employeeList = new ArrayList<>();
		File file = readFile.toFile();

		try {
			FileReader fr = new FileReader(file);
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			while (line != null) {
				String[] list = line.split("\\.");
				Employees readEmployee = new Employees(list[0], list[1], list[2]);
				employeeList.add(readEmployee);

				line = reader.readLine();
			}
			reader.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Something went wrong");
		}
		return employeeList;
	}
}
