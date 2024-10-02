package CourseList;

import Validate.Validate;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

//CourseList.java: Quản lý danh sách Khóa học bằng cấu trúc danh sách liên kết.
public class CourseList {

    Scanner scanner = new Scanner(System.in);
    Course head;
    Validate validate = new Validate();

    // Add a course to the end of the list
    public void addToEnd(Course newCourse) {
        if (head == null) {
            head = newCourse;
        } else {
            Course current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newCourse;
        }
    }

    // Display all courses
    public void display() {
        Course current = head;
        // Adjusted column headers including Subject Name and Registered
        System.out.format("%-15s %-15s %-30s %-10s %-6s %-6s %-12s %s%n",
                "Course Code", "Subject Code", "Subject Name", "Semester", "Year", "Seats", "Registered", "Price");
        System.out.println("--------------------------------------------------------------------------------------------------------------");

        // Loop through the course list
        while (current != null) {
            // Adjusted format specifiers to include Registered
            System.out.format("%-15s %-15s %-30s %-10s %-6s %-6d %-12d %.2f%n",
                    current.ccode, current.scode, current.sname,
                    current.semester, current.year,
                    current.seats, current.registered,
                    current.price);
            current = current.next; // Move to the next course
        }
    }

    // Input and add a new course to the list with validation
    public void inputAndAddCourse() {
        // Input data with validation
        String ccode = validate.getString("Enter course code(Number or letters): ", "Wrong Input!", validate.REGEX_CODE);
        String scode = validate.getString("Enter subject code: ", "Wrong input!", validate.REGEX_CODE);
        String sname = validate.getString("Enter subject name: ", "Please input only letters!", validate.REGEX_NAME);
        String semester = validate.getString("Enter semester(example: Fall24): ", "Wrong input!", validate.REGEX_CODE);
        String year = validate.getString("Enter year: ", "Wrong input!", validate.REGEX_NUMBER);
        int seats = validate.getInteger("Enter number of seats: ", "Please input seats higher than 0", "Over seats in a Class(40)", "Error!!!", 0, 40);
        //Input registered đến bao giờ nó nhỏ hơn seats(đúng điều kiện booked <= quantity
        int registered;
        do {
            registered = validate.getInteger("Enter number of registered students: ", "Error: registered students must be less than or equal to seats", "Seats exceeded!", "Error!!!", 0, seats);
        } while (registered > seats);
        double price = validate.getDouble("Enter price: ", "Input can not be 0 or lower!", "Input's Invalid", "Error!!!", 0, Double.MAX_VALUE);

        // Create the new course
        Course newCourse = new Course(ccode, scode, sname, semester, year, seats, registered, price);

        // Add to the end of the list
        addToEnd(newCourse);
        System.out.println("Course added successfully!");
    }

    // Search for a course by its code
    public Course searchByCCodeNek(String ccode) {
        Course current = head;
        while (current != null) {
            if (current.ccode.equals(ccode)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void searchByCCode() {
        System.out.print("Enter course code to search: ");
        String ccode = scanner.nextLine();
        Course foundCourse = searchByCCodeNek(ccode);
        if (foundCourse != null) {
            System.out.println("Found Course: " + foundCourse.sname);
        } else {
            System.out.println("Course not found.");
        }
    }

    // Delete a course by its code
    public boolean deleteByCCode(String ccode) {
        Course current = head;
        Course previous = null;

        while (current != null) {
            if (current.ccode.equals(ccode)) {
                if (current.registered == 0) {  // Ensure no students are registered
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    return true;
                } else {
                    System.out.println("Cannot delete course, seats are registered.");
                    return false;
                }
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void deleteByCCode() {
        System.out.print("Enter course code to delete: ");
        String ccode = scanner.nextLine();
        boolean deleted = deleteByCCode(ccode);
        if (deleted) {
            System.out.println("Course deleted successfully!");
        } else {
            System.out.println("Course not found or cannot be deleted.");
        }
    }

    // Save course list to a file
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Course current = head;
            System.out.println("Saved with name: 'courses.txt' in your folder");
            while (current != null) {
                writer.write(current.ccode + "," + current.scode + "," + current.sname + "," + current.semester
                        + "," + current.year + "," + current.seats + "," + current.registered + "," + current.price);
                writer.newLine();
                current = current.next;
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // Load course list from a file
    public void loadCoursesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                int seats = Integer.parseInt(data[5]);
                int registered = Integer.parseInt(data[6]);
                double price = Double.parseDouble(data[7]);

                Course course = new Course(data[0], data[1], data[2], data[3], data[4], seats, registered, price);
                addToEnd(course);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Sort courses by course code
    public void sortByCCode() {
        if (head == null || head.next == null) {
            // If the list is empty or contains only one course, no need to sort
            return;
        }

        boolean swapped;
        do {
            Course current = head;
            Course prev = null;
            Course next = head.next;
            swapped = false;

            while (next != null) {
                if (current.ccode.compareTo(next.ccode) > 0) {
                    // Swap the nodes
                    swapped = true;
                    if (prev == null) {
                        // Swapping head with next node
                        head = next;
                    } else {
                        prev.next = next;
                    }

                    // Perform the swap
                    current.next = next.next;
                    next.next = current;

                    // Update the pointers
                    prev = next;
                    next = current.next;
                } else {
                    // No need to swap, just move the pointers
                    prev = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);

        System.out.println("Courses sorted by course code successfully!");
    }

    // Add a course to the beginning of the list
    public void addFirstByCCode() {
        // Get course input from user
        String ccode = validate.getString("Enter course code(Number or letters): ", "Wrong Input!", validate.REGEX_CODE);
        String scode = validate.getString("Enter subject code: ", "Wrong input!", validate.REGEX_CODE);
        String sname = validate.getString("Enter subject name: ", "Please input only letters!", validate.REGEX_NAME);
        String semester = validate.getString("Enter semester(example: Fall24): ", "Wrong input!", validate.REGEX_CODE);
        String year = validate.getString("Enter year: ", "Wrong input!", validate.REGEX_NUMBER);
        int seats = validate.getInteger("Enter number of seats: ", "Please input seats higher than 0", "Over seats in a Class(40)", "Error!!!", 0, 40);
        //Input registered đến bao giờ nó nhỏ hơn seats(đúng điều kiện booked <= quantity
        int registered;
        do {
            registered = validate.getInteger("Enter number of registered students: ", "Error: registered students must be less than or equal to seats", "Seats exceeded!", "Error!!!", 0, seats);
        } while (registered > seats);
        double price = validate.getDouble("Enter price: ", "Input can not be 0 or lower!", "Input's Invalid", "Error!!!", 0, Double.MAX_VALUE);

        // Create new course and add to the beginning
        Course newCourse = new Course(ccode, scode, sname, semester, year, seats, registered, price);
        newCourse.next = head;
        head = newCourse;

        System.out.println("Course added at the beginning successfully!");
    }
    
        public void addAfterPositionK(int k) {
        // Get course input from user
        String ccode = validate.getString("Enter course code(Number or letters): ", "Wrong Input!", validate.REGEX_CODE);
        String scode = validate.getString("Enter subject code: ", "Wrong input!", validate.REGEX_CODE);
        String sname = validate.getString("Enter subject name: ", "Please input only letters!", validate.REGEX_NAME);
        String semester = validate.getString("Enter semester(example: Fall24): ", "Wrong input!", validate.REGEX_CODE);
        String year = validate.getString("Enter year: ", "Wrong input!", validate.REGEX_NUMBER);
        int seats = validate.getInteger("Enter number of seats: ", "Please input seats higher than 0", "Over seats in a Class(40)", "Error!!!", 0, 40);
        double price = validate.getDouble("Enter price: ", "Input can not be 0 or lower!", "Input's Invalid", "Error!!!", 0, Double.MAX_VALUE);

        // Input and validate registered students to ensure it doesn't exceed seats
        int registered;
        do {
            registered = validate.getInteger("Enter number of registered students: ", "Error: registered students must be less than or equal to seats", "Seats exceeded!", "Error!!!", 0, seats);
        } while (registered > seats);

        // Create the new course
        Course newCourse = new Course(ccode, scode, sname, semester, year, seats, registered, price);

        if (head == null) {
            System.out.println("The list is empty. Adding the course as the first entry.");
            head = newCourse;
            return;
        }

        Course current = head;
        int count = 0;

        while (current != null && count < k) {
            current = current.next;
            count++;
        }

        if (current != null) {
            newCourse.next = current.next;
            current.next = newCourse;
            System.out.println("Course added after position " + k + " successfully!");
        } else {
            System.out.println("Position " + k + " is out of range.");
        }
    }
}
