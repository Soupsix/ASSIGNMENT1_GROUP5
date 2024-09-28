/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ass1;

/**
 *
 * @author chuong2309
 */
import java.io.*;
import java.util.Scanner;

public class CourseManagementSystem {

    CourseList courseList = new CourseList();
    StudentList studentList = new StudentList();
    RegistrationList registrationList = new RegistrationList();

    //Tạo object validate để sử dụng cho việc validate dữ liệu nhập vào
    Validate validate = new Validate();

    Scanner scanner = new Scanner(System.in);

    public void loadCoursesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Course course = new Course(data[0], data[1], data[2], data[3], data[4], Integer.parseInt(data[5]), Double.parseDouble(data[6]));
                courseList.addToEnd(course);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("===========================================================================================================");
            System.out.println("                                       CMS - COURSE MANAGEMENT SYSTEM                                   ");
            System.out.println("                                               - GROUP 5 -                                             ");
            System.out.println("===========================================================================================================");
            System.out.println("1. Load data from file.");
            System.out.println("2. Input & add to the end.");
            System.out.println("3. Display data.");
            System.out.println("4. Save course list to file.");
            System.out.println("5. Search by ccode.");
            System.out.println("6. Delete by ccode.");
            System.out.println("7. Sort by ccode.");
            System.out.println("8. Input & add to beginning.");
            System.out.println("9. Add after position k.");
            System.out.println("10. Delete position k.");
            System.out.println("11. Search course by name.");
            System.out.println("12. Search course by ccode.");
            System.out.println("13. Exit!");
            System.out.println("===========================================================================================================");

            while (true) {
                int choice = validate.getInteger("Choose an options: ", "???", "?????", "Please input serious!", 0, 13);

                switch (choice) {
                    case 1:
                        loadCoursesFromFile("courses.txt");
                        break;
                    case 2:
                        inputAndAddCourse();
                        break;
                    case 3:
                        courseList.display();
                        break;
                    case 4:
                        courseList.saveToFile("courses.txt");
                        break;
                    case 5:
                        searchByCCode();
                        break;
                    case 6:
                        deleteByCCode();
                        break;
                    case 7:
                        // Implement sorting by ccode
                        break;
                    case 8:
                        // Implement adding to beginning
                        break;
                    case 9:
                        // Implement adding after position k
                        break;
                    case 10:
                        // Implement deleting position k
                        break;
                    case 11:
                        // Implement searching course by name
                        break;
                    case 12:
                        // Implement searching course by ccode with registered students
                        break;
                    case 13:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        }
    }

    private void inputAndAddCourse() {

        //Hàm validate dữ liệu đầu vào sử dụng từ class Validate
        String ccode = validate.getString("Enter course code(Number or letters): ", "Wrong Input!", validate.REGEX_CODE);
        String scode = validate.getString("Enter subject code: ", "Wrong input!", validate.REGEX_CODE);
        String sname = validate.getString("Enter subject name: ", "Please input only letters!", validate.REGEX_NAME);
        String semester = validate.getString("Enter semester(example: Fall24): ", "Wrong input!", validate.REGEX_CODE);
        String year = validate.getString("Enter year: ", "Wrong input!", validate.REGEX_NUMBER);
        int seats = validate.getInteger("Enter number of seats: ", "Please input seats higher than 0", "Over seats in a Class(40)", "Error!!!", 0, 40);
        double price = validate.getDouble("Enter price: ", "Input can not be 0 or lower!", "Input's Invalid", "Error!!!", 0, Double.MAX_VALUE);

        //Constructor
        Course newCourse = new Course(ccode, scode, sname, semester, year, seats, price);

        //ArrayList lưu zô!
        courseList.addToEnd(newCourse);
        System.out.println("Course added successfully!");

    }

    private void searchByCCode() {
        System.out.print("Enter course code to search: ");
        String ccode = scanner.nextLine();
        Course foundCourse = courseList.searchByCCode(ccode);
        if (foundCourse != null) {
            System.out.println("Found Course: " + foundCourse.sname);
        } else {
            System.out.println("Course not found.");
        }
    }

    private void deleteByCCode() {
        System.out.print("Enter course code to delete: ");
        String ccode = scanner.nextLine();
        boolean deleted = courseList.deleteByCCode(ccode);
        if (deleted) {
            System.out.println("Course deleted successfully!");
        } else {
            System.out.println("Course not found or cannot be deleted.");
        }

    }

    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();
        cms.showMenu();
    }

}
