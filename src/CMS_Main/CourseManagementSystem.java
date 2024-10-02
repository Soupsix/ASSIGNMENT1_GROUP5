/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package CMS_Main;

/**
 *
 * @author chuong2309
 */
import CourseList.CourseList;
import Validate.Validate;
import StudentList.StudentList;
import ass1.Registration.RegistrationList;
import java.io.*;
import java.util.Scanner;

public class CourseManagementSystem {

    CourseList courseList = new CourseList();
    StudentList studentList = new StudentList();
    RegistrationList registrationList = new RegistrationList();

    //Tạo object validate để sử dụng cho việc validate dữ liệu nhập vào
    Validate validate = new Validate();

    Scanner scanner = new Scanner(System.in);

    //1. CourseList!!!
    public void showMenu1() {
        while (true) {
            System.out.println("===========================================================================================================");
            System.out.println("                                       CMS - COURSE MANAGEMENT SYSTEM - COURSE LIST                                  ");
            System.out.println("                                                       - GROUP 5 -                                             ");
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
                        courseList.loadCoursesFromFile("courses.txt");
                        break;
                    case 2:
                        courseList.inputAndAddCourse();
                        break;
                    case 3:
                        courseList.display();
                        break;
                    case 4:
                        courseList.saveToFile("courses.txt");
                        break;
                    case 5:
                        courseList.searchByCCode();
                        break;
                    case 6:
                        courseList.deleteByCCode();
                        break;
                    case 7:
                        courseList.sortByCCode();
                        // Implement sorting by ccode
                        break;
                    case 8:
                        courseList.addFirstByCCode();
                        // Implement adding to beginning
                        break;
                    case 9:
                        // Implement adding after position k
                        int k = validate.getInteger("Input Position k to Add After this: ", "Error cause it's lower than 0", "EXPENSIVE!", "Error!!", 0, Integer.MAX_VALUE);
                        courseList.addAfterPositionK(k);
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

    //2.STUDENT LIST
    //Menu chứa các method của StudentList
    public void showMenu2() {
        while (true) {
            System.out.println("===========================================================================================================");
            System.out.println("                                       CMS - COURSE MANAGEMENT SYSTEM - STUDENT LIST                                  ");
            System.out.println("                                                    - GROUP 5 -                                             ");
            System.out.println("===========================================================================================================");
            System.out.println("1. Load data from file.");
            System.out.println("2. Input & add to the end.");
            System.out.println("3. Display data.");
            System.out.println("4. Save student list to file.");
            System.out.println("5. Search by scode.");
            System.out.println("6. Delete by scode.");
            System.out.println("7. Search by name (student name).");
            System.out.println("8. Search registered courses by scode.");
            System.out.println("9. Exit!");
            System.out.println("===========================================================================================================");

            while (true) {
                int choice = validate.getInteger("Choose an options: ", "???", "?????", "Please input serious!", 0, 9);

                switch (choice) {
                    case 1:
                        
                        break;
                    case 2:
                        //Input & add to the end

                        break;
                    case 3:
                        //Display data

                        break;
                    case 4:
                        //4. Save course list to file.

                        break;
                    case 5:
//                        5. Search by scode

                        break;
                    case 6:
                        //6. Delete by scode

                        break;
                    case 7:
                        //Search by name (student name).
                        break;
                    case 8:
                        //8. Search registered courses by scode.

                        break;
                    case 9:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        }
    }

    //3. REGISTRATION LIST!!!
    //Menu chứa các method của Registration List
    public void showMenu3() {
        while (true) {
            System.out.println("===========================================================================================================");
            System.out.println("                                       CMS - COURSE MANAGEMENT SYSTEM - REGISTRATION LIST                                  ");
            System.out.println("                                                         - GROUP 5 -                                             ");
            System.out.println("===========================================================================================================");
            System.out.println("1. Load data from file.");
            System.out.println("2. Register the course.");
            System.out.println("3. Display data.");
            System.out.println("4. Save registering list to file.");
            System.out.println("5. Sort by ccode + scode.");
            System.out.println("6. Update mark by ccode + scode.");
            System.out.println("7. Exit!");
            System.out.println("===========================================================================================================");

            while (true) {
                int choice = validate.getInteger("Choose an options: ", "???", "?????", "Please input serious!", 0, 7);

                switch (choice) {
                    case 1:
                        
                        break;
                    case 2:
                        //2. Register the course

                        break;
                    case 3:
                        //Display data

                        break;
                    case 4:
                        //4. Save registering list to file.

                        break;
                    case 5:
//                        5. Sort by ccode + scode.

                        break;
                    case 6:
                        //6. Update mark by ccode + scode

                        break;
                    case 7:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            }

        }
    }


    
    //Hàm main :v 
    public static void main(String[] args) {
        CourseManagementSystem cms = new CourseManagementSystem();
        Scanner sc = new Scanner(System.in);
         while (true) {
            System.out.println("===========================================================================================================");
            System.out.println("                              CMS - COURSE MANAGEMENT SYSTEM - SUPER MENU                                  ");
            System.out.println("                                           - GROUP 5 -                                             ");
            System.out.println("===========================================================================================================");
            System.out.println("1. Course List Mangement.");
            System.out.println("2. Student List Management.");
            System.out.println("3. Registering List Management.");
            System.out.println("4. Exit!");

            System.out.println("===========================================================================================================");
            System.out.print("Options: ");

                int choice = sc.nextInt() ;

                switch (choice) {
                    case 1:
                        cms.showMenu1();
                        break;
                    case 2:
                        cms.showMenu2();
                        break;
                    case 3:
                        cms.showMenu3();
                        break;
                    case 4:
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Try again.");
                
            }

        }
        
    }

}

