package MainMenu;

import AddNewEntry.Check;
import MenuMethods.PerStudent;
import MenuMethods.PerCourse;
import MenuMethods.DueThisWeek;
import Objects.Assignment;
import Objects.Course;
import Objects.Student;
import Objects.Trainer;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Maria Lykoudi
 */
public class ReadData {

    private static Scanner sc = new Scanner(System.in);
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void menu() {
        boolean readDataMenu = true;
        System.out.println("1. Print all the students");
        System.out.println("2. Print all the trainers");
        System.out.println("3. Print all the assignments");
        System.out.println("4. Print all the courses");
        System.out.println("5. Print all the students in a specific course");
        System.out.println("6. Print all the trainers in a specific course");
        System.out.println("7. Print all the assignments in a specific course");
        System.out.println("8. Print all the assignments of a specific student");
        System.out.println("9. Print all the students that are attending more than one course");
        System.out.println("10. Enter a date and print all the students that need to submit at least one assignment that week");
        System.out.println("11. Exit");
        while (readDataMenu) {
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    readDataMenu = false;

                    if (!Student.getStudentsList().isEmpty()) {
                        System.out.println("Here is a list of all the students: ");
                        printArithmeticList(Student.getStudentsList());
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case "2":
                    readDataMenu = false;

                    if (!Trainer.getTrainersList().isEmpty()) {
                        System.out.println("Here is a list of all the trainers: ");
                        printArithmeticList(Trainer.getTrainersList());
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case "3":
                    readDataMenu = false;

                    if (!Assignment.getAssignmentsList().isEmpty()) {
                        System.out.println("Here is a list of all the assignments: ");
                        printArithmeticList(Assignment.getAssignmentsList());
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case "4":
                    readDataMenu = false;

                    if (!Course.getCoursesList().isEmpty()) {
                        System.out.println("Here is a list of all the courses: ");
                        printArithmeticList(Course.getCoursesList());
                    } else {
                        System.out.println("List is empty");
                    }
                    break;
                case "5":
                    readDataMenu = false;
                    if (!Course.getCoursesList().isEmpty()) {
                        boolean choose = true;
                        System.out.println("Type course number: ");
                        printArithmeticList(Course.getCoursesList());
                        while (choose) {
                            choice = sc.nextLine();
                            if (Check.checkIfInt(choice) == true && Integer.parseInt(choice) <= Course.getCoursesList().size()) {
                                choose = false;
                            } else {
                                System.out.println("Invalid number");
                            }
                        }
                        System.out.println(Course.getCoursesList().get(Integer.parseInt(choice) - 1) + " has the following students enrolled: ");
                        if(!PerCourse.studentsPerCourse(Course.getCoursesList().get(Integer.parseInt(choice) - 1)).isEmpty()){printArithmeticList(PerCourse.studentsPerCourse(Course.getCoursesList().get(Integer.parseInt(choice) - 1)));}
                        else{System.out.println("No students found");}
                    } else {
                        System.out.println("No courses found");
                    }
                    break;
                case "6":
                    readDataMenu = false;
                    if (!Course.getCoursesList().isEmpty()) {
                        System.out.println("Type course number: ");
                        printArithmeticList(Course.getCoursesList());
                        boolean choose = true;
                        while (choose) {
                            choice = sc.nextLine();
                            if (Check.checkIfInt(choice) == true && Integer.parseInt(choice) <= Course.getCoursesList().size()) {
                                choose = false;
                            } else {
                                System.out.println("Invalid number");
                            }
                        }
                        System.out.println(Course.getCoursesList().get(Integer.parseInt(choice) - 1) + " has the following trainers teaching: ");
                        if(!PerCourse.trainersPerCourse(Course.getCoursesList().get(Integer.parseInt(choice) - 1)).isEmpty()){printArithmeticList(PerCourse.trainersPerCourse(Course.getCoursesList().get(Integer.parseInt(choice) - 1)));}
                        else{System.out.println("No trainers found");}
                    } else {
                        System.out.println("No courses found");
                    }
                    break;
                case "7":
                    readDataMenu = false;
                    if (!Course.getCoursesList().isEmpty()) {
                        System.out.println("Type course number: ");
                        printArithmeticList(Course.getCoursesList());
                        boolean choose = true;
                        while (choose) {
                            choice = sc.nextLine();
                            if (Check.checkIfInt(choice) == true && Integer.parseInt(choice) <= Course.getCoursesList().size()) {
                                choose = false;
                            } else {
                                System.out.println("Invalid number");
                            }
                        }
                        System.out.println(Course.getCoursesList().get(Integer.parseInt(choice) - 1) + " has the following assignments: ");
                        if(!PerCourse.assignmentsPerCourse(Course.getCoursesList().get(Integer.parseInt(choice) - 1)).isEmpty()){printArithmeticList(PerCourse.assignmentsPerCourse(Course.getCoursesList().get(Integer.parseInt(choice) - 1)));}
                        else{System.out.println("No assignments found");}
                    } else {
                        System.out.println("No courses found");
                    }
                    break;
                case "8":
                    readDataMenu = false;
                    if (!Student.getStudentsList().isEmpty()) {
                        System.out.println("Type student number: ");
                        printArithmeticList(Student.getStudentsList());
                        boolean choose = true;
                        while (choose) {
                            choice = sc.nextLine();
                            if (Check.checkIfInt(choice) == true && Integer.parseInt(choice) <= Student.getStudentsList().size()) {
                                choose = false;
                            } else {
                                System.out.println("Invalid number");
                            }
                        }
                        System.out.println(Student.getStudentsList().get(Integer.parseInt(choice) - 1).getFirstName()+" "+Student.getStudentsList().get(Integer.parseInt(choice) - 1).getLastName() + "has the following assignment(s) to complete: ");
                        if (!PerStudent.assignmentsPerStudent(Student.getStudentsList().get(Integer.parseInt(choice) - 1)).isEmpty()) {
                            printArithmeticList(PerStudent.assignmentsPerStudent(Student.getStudentsList().get(Integer.parseInt(choice) - 1)));
                        } else {
                            System.out.println("No assignments found");
                        }
                    } else {
                        System.out.println("No students found");
                    }
                    break;
                case "9":
                    readDataMenu = false;
                    if (!Student.getStudentsList().isEmpty()) {
                        printArithmeticList(Student.moreThanOneCourses());
                    } else {
                        System.out.println("No students found");
                    }
                    break;
                case "10":
                    readDataMenu = false;
                    System.out.println("Enter a date: (dd/mm/yyyy)");
                    System.out.println("Monday counts as the first day of the week");
                    boolean inputDate = true;
                    String date = "";
                    while (inputDate) {
                        date = sc.nextLine();
                        try {
                            LocalDate.parse(date, format);
                            inputDate = false;
                        } catch (java.time.format.DateTimeParseException ex) {
                            System.out.println("Invalid date format");
                        }
                    }
                    if(!DueThisWeek.studentsWithAssignmentsDueThisWeek(date).isEmpty()){printArithmeticList(DueThisWeek.studentsWithAssignmentsDueThisWeek(date));}
                    else{System.out.println("No assignments found");}
                    break;

                case "11":
                    System.exit(0);

                default:
                    System.out.println("Invalid option");
            }
        }
    }

    public static void printArithmeticList(ArrayList arrayList) {
        int counter = 1;
        for (Object object : arrayList) {
            System.out.println(counter + ". " + object);
            counter++;
        }

    }
}
