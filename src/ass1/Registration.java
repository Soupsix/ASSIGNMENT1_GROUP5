/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass1;

/**
 *
 * @author chuong
 */
public class Registration {
    String ccode;
    String scode;
    String bdate; // For simplicity, use String
    double mark;
    int state;
    Registration next;

    public Registration(String ccode, String scode, String bdate, double mark, int state) {
        this.ccode = ccode;
        this.scode = scode;
        this.bdate = bdate;
        this.mark = mark;
        this.state = state;
        this.next = null;
    }
}

