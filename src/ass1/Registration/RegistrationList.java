/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ass1.Registration;

import Validate.Validate;
import ass1.Registration.Registration;

/**
 *
 * @author admin
 */
public class RegistrationList {
    Registration head;
    Validate validate = new Validate();

    public void addToEnd(Registration newRegistration) {
        if (head == null) {
            head = newRegistration;
        } else {
            Registration current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newRegistration;
        }
    }

    // Implement search and other functionalities as needed
}
