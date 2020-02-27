package com.company.MyOwnCode.User1;

import java.util.Scanner;

public class Vigenere1 {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a massage to encode or decode:");
        String x = scan.nextLine();
        String choice = "";
        while (true) {
            System.out.print("If you want to encode the text enter 1\nIf you want to decode  the text enter 0" +
                    "\nPlease, enter your choiсe: ");
            choice = scan.next();
            if (choice.equals("1") || choice.equals("0"))
                break;
            System.out.println("Enter only 1 or 0. ");
        }
        System.out.print("Please, enter a secret keyword: ");
        String key = scan.next();
        String x1 = "";
        for (int i = 0, j = 0, n = x.length(), n1 = key.length(); i < n; i++) {
            char s = x.charAt(i);
            char k = key.charAt(j);
            k += -'A' - ('a' % 'A') * (int)( k / 'a');
            if(((s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z')) && choice.equals("1")) {
                s += - s + 'A' + ('a' % 'A') * (int)(s / 'a') + (s - 'A' - ('a' % 'A') * (int)(s / 'a') + k) % 26;
                j = (j + 1) % n1;
            }
            else if (((s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z')) && choice.equals("0")){
                s += - s + 'Z' + ('a' % 'A') * (int)(s / 'a') + (s - 'Z' - ('a' % 'A') * (int)(s / 'a') - k) % 26;
                j = (j + 1) % n1;
            }
            x1 += s;
        }
        System.out.println(x1);
    }
}
