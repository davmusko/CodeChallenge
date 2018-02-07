import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeRun {
	public static void main(String[] args) {
		String directoryString = "resources";
		String file = "employee.txt";
		String name;
		String age;
		String favFood;
		boolean done = false;

		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the employee database!");
		do {
			System.out.println("Would you like to:\n1) View employees\n2) Enter new employee");
			int userChoice = scan.nextInt();

			if (userChoice == 1) {
				ArrayList<Employees> list;
				int employeeNum;
				list = ReadWrite.readFromFile(directoryString, file);
				System.out.println("Select an employee:");
				for (int i = 0; i < list.size(); i++) {
					System.out.println((i + 1) + ") " + list.get(i).getName());
				}
				employeeNum = scan.nextInt();
				System.out.println(list.get(employeeNum - 1).getName() + " is " + (list.get(employeeNum - 1).getAge()
						+ " years old and their favorite food is " + list.get(employeeNum - 1).getFavoriteFood()));

			}
			if (userChoice == 2) {
				System.out.println("New employee's info:\nName: ");
				name = scan.next();
				System.out.println("Age: ");
				age = scan.next();
				System.out.println("Favorite Food: ");
				favFood = scan.next();
				Employees addEmployee = new Employees(name, age, favFood);
				ReadWrite.writeToFile(directoryString, file, addEmployee);
			}
			System.out.println("Continue? (y/n)");
			scan.nextLine();
			done = !scan.nextLine().equalsIgnoreCase("y");

		} while (!done);
		System.out.println("Good-Bye!");
	}
}
