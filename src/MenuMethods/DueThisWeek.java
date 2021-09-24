package MenuMethods;

import Objects.Assignment;
import Objects.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Locale;

/**
 *
 * @author Maria Lykoudi
 */
public class DueThisWeek {
    private static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static WeekFields ISO;
    
    //  returns a list of students that have to submit assignments within the week of date input
    public static ArrayList<Student> studentsWithAssignmentsDueThisWeek(String date){
    ArrayList<Student> students = new ArrayList();
    LocalDate getDate = LocalDate.parse(date, format);
    WeekFields weekFields = WeekFields.of(Locale.getDefault());
    int weekNum = getDate.get(weekFields.ISO.weekOfWeekBasedYear());
    int assignmentWeekNum;
        for (Student student : Student.getStudentsList()) {
            for (Assignment assignment : PerStudent.assignmentsPerStudent(student)) {
                assignmentWeekNum= assignment.getSubDateTime().get(weekFields.ISO.weekOfWeekBasedYear());
                if(assignmentWeekNum==weekNum && getDate.getYear()==assignment.getSubDateTime().getYear()){
                    students.add(student);}
            }
        }
        return students;
    }
}
