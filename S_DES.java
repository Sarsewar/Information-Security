/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author Ankush
 */
public class S_DES {

    public static char[] straightPbox(char[] k) {
        char[] key = new char[k.length];
        int[] sp = {3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
        //straight p box
        for (int i = 0; i < 10; i++) {
            key[i] = k[(sp[i] - 1)];
        }
        System.out.println("\nStraight p-box:");
        for (int i = 0; i < 10; i++) {
            System.out.print(key[i] + "\t");
        }

        return key;
    }

    public static int[] compressionPbox(char[] kl, char[] kr) {
        int[] cs = {6, 3, 7, 4, 8, 5, 10, 9};
        int[] r = new int[8];
        //compression 
        for (int i = 0; i < 8; i++) {
            if ((cs[i] - 1) < 5) {
                r[i] = Integer.parseInt(String.valueOf(kl[cs[i] - 1]));
            } else {
                r[i] = Integer.parseInt(String.valueOf(kr[(cs[i] - 1) % 5]));
            }
        }
        return r;
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the 10bit key:");
        int[] sp = {3, 5, 2, 7, 4, 10, 1, 9, 8, 6};
        int[] cs = {6, 3, 7, 4, 8, 5, 10, 9};
        String key = sc.next();
        char[] k = key.toCharArray();
        char[] kl = new char[5];
        char[] kr = new char[5];
        int m = 0;
        char[] ks = new char[10];
        //straight p box
        ks = straightPbox(k);
        k = ks;

        for (int i = 0; i < 5; i++) {
            kl[m] = k[i];
            kr[m] = k[m + 5];
            m++;
        }
        int[] r1 = new int[8];
        int[] r2 = new int[8];
        char temp1 = kl[0];
        char temp2 = kr[0];
        //shift left 1 bit
        for (int i = 0; i < 4; i++) {
            kl[i] = kl[i + 1];
            kr[i] = kr[i + 1];
        }
        kl[4] = temp1;
        kr[4] = temp2;
        System.out.println("\nShift Left 1 bit{left side} : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(kl[i] + "\t");
        }
        System.out.println("\nShift Left 1 bit{right side} : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(kr[i] + "\t");
        }
        System.out.println();
        //compression 
        r1 = compressionPbox(kl, kr);
        System.out.println("\nRound key 1:");
        for (int i = 0; i < 8; i++) {
            System.out.print(r1[i] + "\t");
        }
        System.out.println();
        //Shift left 2bit 
        temp1 = kl[0];
        char temp11 = kl[1];
        temp2 = kr[0];
        char temp22 = kr[1];
        for (int i = 0; i < 3; i++) {
            kl[i] = kl[i + 2];
            kr[i] = kr[i + 2];
        }
        kl[3] = temp1;
        kl[4] = temp11;
        kr[3] = temp2;
        kr[4] = temp22;
        System.out.println("\nShift Left 2 bit{left side} : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(kl[i] + "\t");
        }
        System.out.println("\nShift Left 2 bit{right side} : ");
        for (int i = 0; i < 5; i++) {
            System.out.print(kr[i] + "\t");
        }
        System.out.println();
        r2 = compressionPbox(kl, kr);
        System.out.println("\nRound key 2:");
        for (int i = 0; i < 8; i++) {
            System.out.print(r2[i] + "\t");
        }
    }
}

/*
enter the 10bit key:1010000010

Straight p-box:
1    0    0    0    0    0    1    1    0    0    
Shift Left 1 bit{left side} : 
0    0    0    0    1    
Shift Left 1 bit{right side} : 
1    1    0    0    0    

Round key 1:
1    0    1    0    0    1    0    0    

Shift Left 2 bit{left side} : 
0    0    1    0    0    
Shift Left 2 bit{right side} : 
0    0    0    1    1    

Round key 2:
0    1    0    0    0    0    1    1    

**/
