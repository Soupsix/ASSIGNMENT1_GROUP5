/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass1;

/**
 *
 * @author admin
 */
    //lớp Course là lớp khóa học
    public class Course {
    String ccode;
    String scode;
    String sname;
    String semester;
    String year;
    int seats;
    int registered;
    double price;
    Course next;

    public Course(String ccode, String scode, String sname, String semester, String year, int seats, double price) {
        this.ccode = ccode;
        this.scode = scode;
        this.sname = sname;
        this.semester = semester;
        this.year = year;
        this.seats = seats;
        this.registered = 0; // Initially no seats are registered
        this.price = price;
        this.next = null;
    }
}


