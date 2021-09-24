package MenuMethods;

import Objects.Assignment;
import Objects.Course;
import Objects.Student;
import java.util.ArrayList;

/**
 *
 * @author Maria Lykoudi
 */
public class PerStudent {

    //  returns a list of assignments that the selected student has to submit from all his/her courses
    public static ArrayList<Assignment> assignmentsPerStudent(Student student) {
        ArrayList<Assignment> studentsAssignments = new ArrayList();
        for (Course course : student.getCourses()) {
            for (Assignment assignment : course.getCourseAssignments()) {
                studentsAssignments.add(assignment);
            }
        }
        return studentsAssignments;
    }

}
