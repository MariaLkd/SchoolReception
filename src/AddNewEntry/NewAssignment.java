package AddNewEntry;

import MainMenu.ReadData;
import Objects.Assignment;
import Objects.Course;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Maria Lykoudi
 */
public class NewAssignment {

    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static Scanner sc = new Scanner(System.in);

    public static void assignment() {
        if (Course.getCoursesList().isEmpty()) {
            System.out.println("No courses found. Would you like to add a new one now? Type y for yes or n for no");
            System.out.println("If you choose no, you will not be able to add an assignment.");
            boolean addCourseNow = true;
            while (addCourseNow) {
                String choice = sc.nextLine();
                if (choice.equalsIgnoreCase("y")) {
                    NewCourse.course();
                    addCourseNow = false;
                } else if (choice.equalsIgnoreCase("n")) {
                    addCourseNow = false;
                } else {
                    System.out.println("Invalid option");
                }
            }
        } else {
            System.out.println("Enter assignment's title: ");
            String title = sc.nextLine();
            System.out.println("Enter assignment's description: ");
            String desc = sc.nextLine();
            System.out.println("Enter assignment's submission date: (dd/mm/yyyy)");
            boolean inputDate = true;
            String subDate = "";
            while (inputDate) {
                subDate = sc.nextLine();
                if (Check.checkDate(subDate) == true) {
                    inputDate = false;
                } else {
                    System.out.println("Invalid date format");
                }

            }
            System.out.println("Type the course's number the assignment belongs: ");
            ReadData.printArithmeticList(Course.getCoursesList());
            boolean choose = true;
            String choice = "";
            while (choose) {
                choice = sc.nextLine();
                if (Check.checkIfInt(choice) == true && Integer.parseInt(choice) <= Course.getCoursesList().size() && Integer.parseInt(choice) > 0) {
                    choose = false;
                } else {
                    System.out.println("Invalid number");
                }
            }
            System.out.println("New Assignment: " + title + ", Description: " + desc + ", Submission Date: " + LocalDate.parse(subDate, format) + ", Course: " + (Course.getCoursesList().get(Integer.parseInt(choice) - 1)));
            Assignment assignment = null;
            boolean inputConfirm = true;
            while (inputConfirm) {
                System.out.println("Type ok to confirm or cancel to discard");
                String confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("ok")) {
                    assignment = new Assignment(title, desc, LocalDate.parse(subDate, format));
                    Course.getCoursesList().get(Integer.parseInt(choice) - 1).addAssignment(assignment);
                    System.out.println("Assignment saved!");
                    inputConfirm = false;
                } else if (confirm.equalsIgnoreCase("cancel")) {
                    inputConfirm = false;
                } else {
                    System.out.println("Invalid input");
                }
            }
        }
    }
}
