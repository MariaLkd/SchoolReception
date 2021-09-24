package MainMenu;

import MenuMethods.PerCourse;
import Objects.Assignment;
import Objects.Course;
import Objects.Student;
import Objects.Trainer;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.DAYS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Maria Lykoudi
 */
public class SyntheticData {

    private static boolean alreadyAdded = false;
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void add() {
        if (alreadyAdded == false) {

            Student student1 = new Student("firstName1", "Surname1", LocalDate.parse("10/03/1995", format), 2250);
            Student student2 = new Student("firstName2", "Surname2", LocalDate.parse("16/04/1993", format), 2500);
            Student student3 = new Student("firstName3", "Surname3", LocalDate.parse("25/01/1990", format), 2500);
            Student student4 = new Student("firstName4", "Surname4", LocalDate.parse("20/06/1988", format), 2250);
            Student student5 = new Student("firstName5", "Surname5", LocalDate.parse("05/11/2000", format), 2200);
            Course course1 = new Course("CB13", "Java", "Part Time", LocalDate.parse("15/03/2021", format), LocalDate.parse("15/09/2021", format));
            Course course2 = new Course("CB12", "C++", "Full Time", LocalDate.parse("15/04/2021", format), LocalDate.parse("15/10/2021", format));

            student1.addCourseWithoutMessage(course2);
            student2.addCourseWithoutMessage(course2);
            student3.addCourseWithoutMessage(course1);
            student4.addCourseWithoutMessage(course1);
            student2.addCourseWithoutMessage(course1);
            student5.addCourseWithoutMessage(course2);

            Trainer trainer1 = new Trainer("firstNameTrainer1", "lastNameTrainer1", "subjectTrainer1");
            Trainer trainer2 = new Trainer("firstNameTrainer2", "lastNameTrainer2", "subjectTrainer2");
            Trainer trainer3 = new Trainer("firstNameTrainer3", "lastNameTrainer3", "subjectTrainer3");

            Assignment assignment1 = new Assignment("Title1", "description1", LocalDate.parse("31/03/2021", format));
            Assignment assignment2 = new Assignment("Title2", "description2", LocalDate.parse("29/04/2021", format));
            Assignment assignment3 = new Assignment("Title3", "description3", LocalDate.parse("30/06/2021", format));

            course1.addAssignment(assignment1);
            course1.addAssignment(assignment2);
            course2.addAssignment(assignment3);

//            For generating random data          
//
//            Random rand = new Random();
//            Course course1 = new Course("CB13", "Java", "Part Time", LocalDate.parse("15/02/2021", format), LocalDate.parse("15/08/2021", format));
//            Course course2 = new Course("CB13", "C#", "Full Time", LocalDate.parse("15/02/2021", format), LocalDate.parse("15/08/2021", format));
//            Course course3 = new Course("CB14", "Python", "Part Time", LocalDate.parse("15/03/2021", format), LocalDate.parse("15/09/2021", format));
//            Course course4 = new Course("CB12", "Javascript", "Full Time", LocalDate.parse("15/03/2021", format), LocalDate.parse("15/09/2021", format));
//            ArrayList<Course> syntheticCourses = new ArrayList();
//            Collections.addAll(syntheticCourses, course1, course2, course3, course4);
//
//            for (int i = 1; i <= 20; i++) {
//                char letter = (char) (rand.nextInt(26) + 'A');
//                String firstName = "FirstNameStudent" + letter + i;
//                String lastName = "LastNameStudent" + letter + i;
//                LocalDate dob = LocalDate.now();
//                int tuitionFees = rand.nextInt(2500 - 2000) + 2000;
//                Student student = new Student(firstName, lastName, dob, tuitionFees);
//                int randNum = rand.nextInt(3) + 1;
//                student.addCourseWithoutMessage(syntheticCourses.get(randNum));
//                if (i >= 1 && i <= 3) {
//                    int randNum2 = rand.nextInt(3) + 1;
//                    student.addCourseWithoutMessage(syntheticCourses.get(randNum2));
//                }
//                for (Course syntheticCourse : syntheticCourses) {
//                    if (PerCourse.studentsPerCourse(syntheticCourse).size() < 5) {
//                        student.addCourseWithoutMessage(syntheticCourse);
//                    }
//                }
//            }
//
//            for (int i = 1; i <= 6; i++) {
//                char letter = (char) (rand.nextInt(26) + 'A');
//                String firstName = "FirstNameTrainer" + letter + i;
//                String lastName = "LastNameTrainer" + letter + i;
//                String subject = "Subject" + i;
//                Trainer trainer = new Trainer(firstName, lastName, subject);
//                trainer.addCourseWithoutMessage(syntheticCourses.get(rand.nextInt(3) + 1));
//                for (Course syntheticCourse : syntheticCourses) {
//                    if (PerCourse.trainersPerCourse(course4).size() < 2) {
//                        trainer.addCourseWithoutMessage(syntheticCourse);
//                    }
//                }
//            }
//            int i = 1;
//            for (i = 1; i <= 7; i++) {
//                char letter = (char) (rand.nextInt(26) + 'A');
//                String title = "Assignment" + letter + i;
//                String desc = "describing";
//                Course course = syntheticCourses.get(rand.nextInt(3) + 1);
//                int dueDateLimit = (int) DAYS.between(course.getStart_date(), course.getEnd_date());
//                LocalDate dueDate = course.getStart_date().plusDays(rand.nextInt(dueDateLimit));
//                Assignment assignment = new Assignment(title, desc, dueDate);
//            }

            System.out.println("Synthetic Data added successfully");
            alreadyAdded = true;
        } else {
            System.out.println("Synthetic Data already added");
        }
    }

}
