package com.company.MyOwnCode.User1;

import java.util.Scanner;

public class Vigenere {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a massage to encode or decode:");
        String  x = scan.nextLine();
        String choice ="";
        do {
            System.out.print("If you want to encode the text enter 1\nIf you want to decode  the text enter 0\nPlease, enter your choiсe: ");
            choice = scan.next();
        }
        while(!choice.equals("1") && !choice.equals("0"));
        System.out.print("Please, enter a secret keyword: ");
        String key = scan.next();
        for (int i = 0, j = 0, n = x.length(), n1 = key.length(); i < n; i++) {
            char s = x.charAt(i);
            char k = key.charAt(j);
            k += -'A' - ('a' % 'A') * (int)( k / 'a');
            if((s >= 'A' && s <= 'Z') || (s >= 'a' && s <= 'z')) {
                if (choice.equals("1")) {
                    s += k - 26 * ((int) (s - 'A' - ('a' % 'A') * (int) (s / 'a') + k) / 26);
                    System.out.print(s);
                    j = (j + 1) % n1;
                } else {
                    s += - k + 26 * ((int) (s - 'Z' - ('a' % 'A') * (int) (s / 'a') - k) / 26);
                    System.out.print(s);
                    j = (j + 1) % n1;
                }
            }
            else{
                System.out.print(s);
            }
        }
    }
}

