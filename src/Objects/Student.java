package Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Maria Lykoudi
 */
public class Student {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private int tuitionFees;
    private static ArrayList<Student> studentsList = new ArrayList();
    private ArrayList<Course> courses = new ArrayList();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/YYYY");

    public Student(String firstName, String lastName, LocalDate dateOfBirth, int tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
        this.studentsList.add(this);
        Collections.sort(Student.getStudentsList(), Comparator.comparing(Student::getLastName));
    }

    //  adds course the student attends
    public void addCourse(Course course) {
        if (courses.contains(course)) {
            System.out.println("Student already enrolled in this course");
        } else if(!courses.contains(course)){
            courses.add(course);
            System.out.println(this + " succesfully enrolled in "+course);
        }
    }
    
    // adds course to the student without printing the success message(for synthetic data)
    public void addCourseWithoutMessage(Course course){
        if (!courses.contains(course)){courses.add(course);}
}

    // prints students the attend more than 1 courses
    public static ArrayList<Student> moreThanOneCourses() {
        ArrayList<Student> moreCourses = new ArrayList();
        for (Student student : studentsList) {
            if (student.courses.size() > 1) {
                moreCourses.add(student);
            }
        }
        return moreCourses;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public static ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + ", Date Of Birth: "+dateOfBirth+", Tuition Fees: "+tuitionFees;
    }

}
