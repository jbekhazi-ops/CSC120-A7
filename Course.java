public class Course {

    // Attributes
    private String name;
    private String subjectNumber;
    private String meetingTime; 


    /**
     * Constructor
     * @param name
     * @param subjectNumber
     * @param meetingTime
     */
    public Course(String name, String subjectNumber, String meetingTime) {
        this.name = name;
        this.subjectNumber = subjectNumber;
        this.meetingTime = meetingTime; 
    }

    /**
     * Accessor for name of course
     * @return String name of course
     */
    public String getName() {
        return this.name;
    }
/**
 * accessor for subject number
 * @return String number of the subject
 */
    public String getSubjectNumber() {
        return this.subjectNumber;
    }
/**
 * Accessor for meeting times
 * @return String schedule/meeting time of course
 */
    public String getMeetingTime() {
        return this.meetingTime;
    }
/**
 * pretty print function
 * @return String of course description
 */
    public String toString() {
        return this.subjectNumber + ": " + this.name + " " + this.meetingTime; 
    }

    public static void main(String[] args) {
        Course csc120 = new Course("OOP", "CSC120", "TR 10:50");
        System.out.println(csc120);
    }
    
}
