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
public class Course {
    private String title;
    private String stream;
    private String type;
    private LocalDate start_date;
    private LocalDate end_date;
    private static ArrayList<Course> coursesList = new ArrayList();
    private ArrayList<Assignment> courseAssignments = new ArrayList();
    private ArrayList<Trainer> courseTrainers = new ArrayList();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    
    public Course(String title, String stream, String type, LocalDate start_date, LocalDate end_date){
        this.title=title;
        this.stream=stream;
        this.type=type;
        this.start_date=start_date;
        this.end_date=end_date;
        coursesList.add(this);
        Collections.sort(coursesList, Comparator.comparing(Course::getTitle));
    }
    
    // add assignment to course
    public void addAssignment(Assignment assignment){
        courseAssignments.add(assignment);
    }
    
    // add trainer to the course
    public void addTrainer (Trainer trainer){
        if(!courseTrainers.contains(trainer))courseTrainers.add(trainer);
    }

    public static ArrayList<Course> getCoursesList() {
        return coursesList;
    }
    

    public ArrayList<Assignment> getCourseAssignments() {
        return courseAssignments;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public LocalDate getEnd_date() {
        return end_date;
    }

    public void setEnd_date(LocalDate end_date) {
        this.end_date = end_date;
    }

    public ArrayList<Trainer> getCourseTrainers() {
        return courseTrainers;
    }

    @Override
    public String toString() {
        return title + " " + stream + " " + type + ", Start date: " + format.format(start_date) + ", End date: " + format.format(end_date);
    }
    
}
