package MainMenu;

import java.util.Scanner;
import AddNewEntry.NewCourse;
import AddNewEntry.NewAssignment;
import AddNewEntry.NewStudent;
import AddNewEntry.NewTrainer;
/**
 *
 * @author Maria Lykoudi
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        boolean runProgram = true;
        while (runProgram) {
            System.out.println("Type the number of the action you want: ");
            System.out.println("1. Add new course");
            System.out.println("2. Add new trainer");
            System.out.println("3. Add new student");
            System.out.println("4. Add new assignment");
            System.out.println("5. Read Data");
            System.out.println("6. Add synthetic data");
            System.out.println("7. Exit");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    NewCourse.course();
                    BackToMenu.backToMenu();
                    break;
                case "2":
                    NewTrainer.trainer();
                    BackToMenu.backToMenu();
                    break;
                case "3":
                    NewStudent.student();
                    BackToMenu.backToMenu();
                    break;
                case "4":
                    NewAssignment.assignment();
                    BackToMenu.backToMenu();
                    break;
                case "5":
                    ReadData.menu();
                    BackToMenu.backToMenu();
                    break;
                case "6":
                    SyntheticData.add();
                    BackToMenu.backToMenu();
                    break;
                case "7":
                    runProgram = false;
                    break;
            }
        }
    }

}
