/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validate;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Validate {



    public final String REGEX_CODE = "[a-zA-Z0-9\s]+";
    public final String REGEX_NAME = "[a-zA-Z\s]+";
    public final String REGEX_NUMBER = "[0-9]+";

    public  int getInteger(String message, String firstError, String secondError, String thirdError, double min,
            double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // vòng lặp while sẽ dừng lại khi gặp điều kiện đúng
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Không được để trống!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < min) {
                        System.out.println(firstError);
                    } else if( number > max){
                        System.err.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.err.println(thirdError);
            }
        }
    }

    public  String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.print(message);
            String input = scanner.nextLine().trim(); // trim xóa dấu space
            if (input.isEmpty()) {
                System.out.println("Input's invalid, type it again!");
            } else {
                if (input.matches(regex)) {
                    return input;
                } else {
                    System.err.println(error);
                }
            }
        }
    }

    public  float getFloat(String message, String firstError, String secondError, String thirdError, float min,
            float max) {
        Scanner scanner = new Scanner(System.in);

        // - Yêu cầu người dùng nhập vào một số nguyên
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("KhÔng được để trống");
                } else {
                    float number = Float.parseFloat(input);
                    // check number in range
                    if (number < min) {
                        System.out.println(firstError);
                    } else if(number > max){
                        System.err.println(secondError);
                    } else {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.err.println(thirdError);
            }
        }
    }

    public  double getDouble(String message, String firstError, String secondError, String thirdError, double min,
            double max) {
        // Yêu cầu người dùng nhập vào một số dữ liệu
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // vòng lặp while, sẽ lăp cho đến khi đạt điều kiện đúng
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                if (input.isEmpty()) {
                    System.out.println("Không được để trống!");
                } else {
                    double number = Double.parseDouble(input);
                    // check the number in the range
                    if (number >= min && number <= max) {
                        return number;

                    } else {
                        System.err.println("Bạn phải nhập trong khoảng " + min + "-" + max);
                    }
                }
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
    }
}

