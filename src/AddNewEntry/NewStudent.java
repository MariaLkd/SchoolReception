package AddNewEntry;

import MainMenu.ReadData;
import Objects.Course;
import Objects.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Maria Lykoudi
 */
public class NewStudent {

    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static Scanner sc = new Scanner(System.in);

    public static void student() {
        System.out.println("Enter student's first name:");
        String firstName = sc.nextLine();
        System.out.println("Enter student's last name:");
        String lastName = sc.nextLine();
        System.out.println("Enter student's date of birth: (dd/mm/yyyy)");
        boolean inputDob = true;
        String dob = "";
        while (inputDob) {
            dob = sc.nextLine();
            try {
                LocalDate.parse(dob, format);
                inputDob = false;
            } catch (java.time.format.DateTimeParseException ex) {
                System.out.println("Invalid date format");
            }
        }
        System.out.println("Enter student's tuition fees:");
        boolean enterFees = true;
        String tuitionFees = "";
        while (enterFees) {
            tuitionFees = sc.nextLine();
            if (Check.checkIfInt(tuitionFees) == true) {
                enterFees = false;
            } else {
                System.out.println("Please enter an integer");
            }
        }
        if (Course.getCoursesList().isEmpty()) {
            System.out.println("No courses found. Would you like to add a new one now? Type y for yes or n for no");
            System.out.println("If you choose no, the student will not be saved.");
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

        }
        if (!Course.getCoursesList().isEmpty()) {
            Boolean selectCourses = true;
            System.out.println("New Student: " + firstName + " " + lastName + ", Date of Birth: " + format.format(LocalDate.parse(dob, format)) + ", Tuition Fees: " + Integer.parseInt(tuitionFees));
            Student student = null;
            boolean inputConfirm = true;
            boolean confirmed = false;
            while (inputConfirm) {
                System.out.println("Type ok to confirm or cancel to discard");
                String confirm = sc.nextLine();
                if (confirm.equalsIgnoreCase("ok")) {
                    student = new Student(firstName, lastName, LocalDate.parse(dob, format), Integer.parseInt(tuitionFees));
                    confirmed = true;
                    inputConfirm = false;
                } else if (confirm.equalsIgnoreCase("cancel")) {
                    inputConfirm = false;
                } else {
                    System.out.println("Invalid input");
                }
            }
            if (confirmed==true) {
                System.out.println(student);
                System.out.println("Student saved!");
                while (selectCourses) {
                    System.out.println("Type the number of the course the student " + student.getFirstName()+" "+student.getLastName() + " is enrolled in or new to create a new course");
                    ReadData.printArithmeticList(Course.getCoursesList());
                    boolean choose = true;
                    String choice = "";
                    while (choose) {
                        choice = sc.nextLine();
                        if (Check.checkIfInt(choice) == true && Integer.parseInt(choice) <= Course.getCoursesList().size() && Integer.parseInt(choice) > 0) {
                            student.addCourse(Course.getCoursesList().get(Integer.parseInt(choice) - 1));
                            choose = false;
                        } else if (choice.equalsIgnoreCase("new")) {
                            NewCourse.course();
                            choose = false;
                        } else {
                            System.out.println("Invalid number");
                        }
                    }

                    System.out.println("Is the student enrolled in another course? Type y for yes, n for no");
                    String choice1 = sc.nextLine();
                    if (choice1.equalsIgnoreCase("y")) {
                        selectCourses = true;
                    } else if (choice1.equalsIgnoreCase("n")) {
                        selectCourses = false;
                    } else {
                        System.out.println("Invalid option");
                        selectCourses = false;
                    }
                }
            }
        }
    }
}
