package MenuMethods;

import Objects.Assignment;
import Objects.Course;
import Objects.Student;
import Objects.Trainer;
import java.util.ArrayList;

/**
 *
 * @author Maria Lykoudi
 */
public class PerCourse {
    //  returns a list of the students enrolled in the selected course
    public static ArrayList<Student> studentsPerCourse(Course course) {
        ArrayList<Student> studentsPerCourse = new ArrayList();
        for (Student student : Student.getStudentsList()) {
            for (Course studentCourse : student.getCourses()) {
                if(studentCourse.equals(course)){studentsPerCourse.add(student);}
            }
        }
        return studentsPerCourse;
    }
    
    //  returns a list of trainers teaching the selected course
    public static ArrayList<Trainer> trainersPerCourse(Course course){
        return course.getCourseTrainers();
    }
    
    //  returns a list of assignments of the selected course
    public static ArrayList<Assignment> assignmentsPerCourse(Course course){
        return course.getCourseAssignments();
    }
}
