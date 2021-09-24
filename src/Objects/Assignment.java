package Objects;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Maria
 */
public class Assignment {
    private String title;
    private String description;
    private LocalDate subDateTime;
    private int oralMark;
    private int totalMark;
    private static ArrayList<Assignment> assignmentsList= new ArrayList();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/YYYY");
    
    public Assignment(String title, String description, LocalDate subDateTime){
        this.title=title;
        this.description=description;
        this.subDateTime=subDateTime;
        assignmentsList.add(this);
        Collections.sort(assignmentsList, Comparator.comparing(Assignment::getTitle));
    }

    public static ArrayList<Assignment> getAssignmentsList() {
        return assignmentsList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(LocalDate subDateTime) {
        this.subDateTime = subDateTime;
    }

    public int getOralMark() {
        return oralMark;
    }

    public void setOralMark(int oralMark) {
        this.oralMark = oralMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    @Override
    public String toString() {
        return "Assignment title: " + title + ", Description: " + description + ", Submission Date: " + format.format(subDateTime);
    }
    
    
    
}
