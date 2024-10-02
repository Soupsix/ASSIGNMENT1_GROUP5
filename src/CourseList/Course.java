/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CourseList;

/**
 *
 * @author admin
 */
//lớp Course là lớp khóa học
class Course {

    String ccode;
    String scode;
    String sname;
    String semester;
    String year;
    int seats;
    int registered; // Registered students in the course
    double price;
    Course next;

    // Constructor with validation for registered <= seats
    public Course(String ccode, String scode, String sname, String semester, String year, int seats, int registered, double price) {
        this.ccode = ccode;
        this.scode = scode;
        this.sname = sname;
        this.semester = semester;
        this.year = year;
        this.seats = seats;

        // Ensure registered <= seats
        if (registered <= seats) {
            this.registered = registered;
        } else {
            throw new IllegalArgumentException("Registered students cannot exceed available seats.");
        }

        this.price = price;
        this.next = null;
    }
}
