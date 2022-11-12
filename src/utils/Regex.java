package utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    /*
        địng đạng regex
        + UserName chứa ký tự và chữ số có độ dài từ 5 đến 15 ký tự
        + Password chứa ít nhất 1 chữ hoa, 1 chữ số và 1 ký tự đặc biệt  (.;_*) có độ dài từ 6-16 ký tự
        + SDT bắt đầu từ 0, số thứ 2 khác 0 và có độ dài tổng 10 số
     */
    String regexUserName = "^[a-zA-Z0-9]{5,15}$";
    Pattern patternUserName = Pattern.compile(regexUserName);
    String regexPassword = "^((?=.*[A-Z])(?=.*[@.;+*])(?=.*[0-9])(\\S){6,16})$";
    Pattern patternPassword = Pattern.compile(regexPassword);
    String regexPhone = "^[0]{1}[1-9]{1}[0-9]{8}$";
    Pattern patternPhone = Pattern.compile(regexPhone);


    // Kiểm tra UserName có đúng định dạnh regex không

    public String checkUserName(Scanner sc) {
        boolean check;
        String inputUserName;
        do {
            inputUserName = sc.nextLine();
            Matcher matcher = patternUserName.matcher(inputUserName);
            if (matcher.find()) {
                System.out.println("Username ----> OK\n");
                check = true;
            } else {
                System.out.println("Username Wrong, re-enter name");
                check = false;
            }
        }while (!check);
        return inputUserName;
    }

    public String checkPassword(Scanner sc) {
        boolean check;
        String inputPassword;
        do {
            inputPassword = sc.nextLine();
            Matcher matcher = patternPassword.matcher(inputPassword);
            if (matcher.find()) {
                System.out.println("Password ---->OK\n");
                check = true;
            } else {
                System.out.println("Password Wrong, re-enter Password");
                check = false;
            }
        } while (!check);
        return inputPassword;
    }

    public String checkPhoneNumber(Scanner sc) {
        boolean check;
        String inputPhone;
        do {
            inputPhone = sc.nextLine();
            Matcher matcher = patternPhone.matcher(inputPhone);
            if (matcher.find()) {
                System.out.println("Phone ---->OK\n");
                check = true;
            } else {
                System.out.println("Number phone Wrong, re-enter ");
                check = false;
            }
        } while (!check);
        return inputPhone;
    }

}
