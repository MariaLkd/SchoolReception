package Objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Maria Lykoudi
 */
public class Trainer {
    private String firstName;
    private String lastName;
    private String subject;
    private static ArrayList<Trainer> trainersList = new ArrayList();
    private ArrayList<Course> courses = new ArrayList();
    
    public Trainer(String firstName, String lastName, String subject){
        this.firstName=firstName;
        this.lastName=lastName;
        this.subject=subject;
        trainersList.add(this);
        Collections.sort(Trainer.getTrainersList(), Comparator.comparing(Trainer::getLastName));
    }
    
    //  adds a course that the trainer teaches
    public void addCourse(Course course){
        if(!courses.contains(course)){courses.add(course);
        course.addTrainer(this);
            System.out.println("Course successfully added to trainer "+this);}
        else{System.out.println("Trainer already teaches this subject");}
    }
    
    // adds a course that the trainer teaches without success message(for synthetic data)
    public void addCourseWithoutMessage(Course course){
        if(!courses.contains(course)){courses.add(course);
        course.addTrainer(this);}
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

    public static ArrayList<Trainer> getTrainersList() {
        return trainersList;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
    
    @Override
    public String toString() {
        return firstName +" "+ lastName + ", Subject: " + subject;
    }

    
    
    
}
