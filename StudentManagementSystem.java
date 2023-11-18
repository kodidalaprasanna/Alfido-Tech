import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Student {
    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}

class Course {
    private String courseName;
    private int courseId;
    private Map<Student, Integer> grades;
    private Map<Student, Boolean> attendance;

    public Course(String courseName, int courseId) {
        this.courseName = courseName;
        this.courseId = courseId;
        this.grades = new HashMap<>();
        this.attendance = new HashMap<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void addStudent(Student student) {
        grades.put(student, 0); // initialize grade to 0
        attendance.put(student, false); // initialize attendance to false
    }

    public void recordGrade(Student student, int grade) {
        grades.put(student, grade);
    }

    public void markAttendance(Student student) {
        attendance.put(student, true);
    }

    public void displayReport() {
        System.out.println("Course: " + courseName + " (ID: " + courseId + ")");
        System.out.println("Students enrolled:");

        for (Map.Entry<Student, Integer> entry : grades.entrySet()) {
            Student student = entry.getKey();
            int grade = entry.getValue();
            boolean isPresent = attendance.get(student);

            System.out.println("Student ID: " + student.getId() + ", Name: " + student.getName() +
                    ", Grade: " + grade + ", Attendance: " + (isPresent ? "Present" : "Absent"));
        }
    }
}

public class StudentManagementSystem{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create students
        Student student1 = new Student("Anwar", 1);
        Student student2 = new Student("Azma", 2);

        // Create courses
        Course mathCourse = new Course("Mathematics", 101);
        Course physicsCourse = new Course("Physics", 102);

        // Enroll students in courses
        mathCourse.addStudent(student1);
        mathCourse.addStudent(student2);
        physicsCourse.addStudent(student1);
        physicsCourse.addStudent(student2);

        // Record grades and attendance
        mathCourse.recordGrade(student1, 90);
        mathCourse.recordGrade(student2, 85);
        mathCourse.markAttendance(student1);
        mathCourse.markAttendance(student2);

        physicsCourse.recordGrade(student1, 92);
        physicsCourse.recordGrade(student2, 88);
        physicsCourse.markAttendance(student1);
        physicsCourse.markAttendance(student2);

        // Display reports
        mathCourse.displayReport();
        System.out.println();
        physicsCourse.displayReport();
    }
}