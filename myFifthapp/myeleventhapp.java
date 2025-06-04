import java.util.*;

class Student {
    private String indexNumber;
    private String firstName;
    private String lastName;
    private List<Integer> grades;

    // Constructor
    public Student(String indexNumber, String firstName, String lastName, List<Integer> grades) {
        this.indexNumber = indexNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
    }

    // Getters
    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    // Calculate average
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Nicely formatted string
    public String toString() {
        return firstName + " " + lastName + " (" + indexNumber + ") - Average: " + String.format("%.2f", getAverageGrade());
    }
}

public class myeleventhapp {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("12345", "Jan", "Kowalski", Arrays.asList(4, 5, 3, 5)),
                new Student("67890", "Anna", "Nowak", Arrays.asList(5, 5, 4, 4)),
                new Student("54321", "Paweł", "Wiśniewski", Arrays.asList(2, 3, 2, 4)),
                new Student("09876", "Katarzyna", "Kowalczyk", Arrays.asList(5, 4, 4, 5))
        );

        // Student with the highest average
        Student topStudent = Collections.max(students, Comparator.comparingDouble(Student::getAverageGrade));
        System.out.println("Student with the highest average: " + topStudent);

        // Sorted list by last name
        students.sort(Comparator.comparing(Student::getLastName));
        System.out.println("Students sorted by last names:");
        for (Student s : students) {
            System.out.println(s);
        }

        // Average grade of all students
        double totalSum = 0;
        int totalCount = 0;
        for (Student s : students) {
            for (int grade : s.getGrades()) {
                totalSum += grade;
                totalCount++;
            }
        }
        double overallAverage = totalCount > 0 ? totalSum / totalCount : 0.0;
        System.out.println("Average grade of all students: " + String.format("%.2f", overallAverage));
    }
}



