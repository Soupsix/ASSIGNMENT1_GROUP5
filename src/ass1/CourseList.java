/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass1;

/**
 *
 * @author admin
 */
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


//CourseList.java: Quản lý danh sách Khóa học bằng cấu trúc danh sách liên kết.

public class CourseList {
    Course head;

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

    public void display() {
        Course current = head;
        System.out.format("%-15s %-30s %-10s %-6s %-6s %-12s %s%n",
                "Course Code", "Subject", "Semester", "Year", "Seats", "Registered", "Price");
        System.out.println("--------------------------------------------------------------------------------------------");
        while (current != null) {
        System.out.format("%-15s %-30s %-10s %-6s %-6d %-12d %.2f%n",
                          current.ccode, current.sname,
                          current.semester, current.year,
                          current.seats, current.registered,
                          current.price);
            current = current.next;
        }
    }

    public Course searchByCCode(String ccode) {
        Course current = head;
        while (current != null) {
            if (current.ccode.equals(ccode)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean deleteByCCode(String ccode) {
        Course current = head;
        Course previous = null;

        while (current != null) {
            if (current.ccode.equals(ccode)) {
                if (current.registered == 0) {
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

    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Course current = head;
            System.out.println("Saved with name: 'courses.txt' in your folder");
            while (current != null) {
                writer.write(current.ccode + "," + current.scode + "," + current.sname + "," + current.semester +
                        "," + current.year + "," + current.seats + "," + current.price);
                writer.newLine();
                current = current.next;
                
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
    
    // Add methods for sorting, adding at the beginning, and adding after position k here.
}

