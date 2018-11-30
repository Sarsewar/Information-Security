/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author CSE039
 */
public class SingleTranspositionChiper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Enter the plainText:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = 0;
        System.out.println("Enter the key :");
        k = sc.nextInt();
        str = Encry(str, k);

    }

    public static String Encry(String str, int k) {

        str = str.replaceAll("\\s", "");
        str = str.replaceAll("[^a-zA-Z]", "");
        str = str.toLowerCase();
        char[] ch = str.toCharArray();
        char[] result = new char[1000];

        char[] key = String.valueOf(k).toCharArray();
        int l = k;
        int m = -1;

        while (l != 0) {
            int r = l % 10;
            l = l / 10;
            m = Math.max(m, r);
        }
        System.out.println("Max:"+m);

        int d = ch.length / m;
        if(ch.length%m != 0)
            d++;

        int b = 0;

        char[][] matrix = new char[d][m];
        for (int i = 0; i < d; i++)
        {
            for (int j = 0; j < m; j++) {
                if (b < ch.length)
                {
                    matrix[i][j] = ch[b];
                    b++;
                } else {
                    matrix[i][j]='z';
                }
            }

        }
        //attackistonights
        System.out.println("Matrix key:");
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.print("\n");
        }
        String res="";
        System.out.println("Chiper :");
        for(char c:key)
        {
            int u=Integer.parseInt(String.valueOf(c));
            u--;
            for(int i=0;i<d;i++)
                res+=matrix[i][u];
        }

        System.out.println(res);

        return res;
    }

}
/*

Enter the plainText:
Attack is tonight
Enter the key :
31452
Max:5
Matrix key:
a	t	t	a	c
k	i	s	t	o
n	i	g	h	t
Chiper :
tsgaknathcottii

Process finished with exit code 0


*/
