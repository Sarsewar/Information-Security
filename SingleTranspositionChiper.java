/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;
/**

@author : Ankush Sarsewar
**/
/* Name of the class has to be "Main" only if the class is public. */
class SinlgeTranspositionCipher
{
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Enter the plainText:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = 0;
        System.out.println("Enter the key :");
        k = sc.nextInt();      
        String c1 = Encry(str, k);
        System.out.println("Enter Second key:");
        int k2=sc.nextInt();
        String c2=Encry(c1,k2);
        String d2= Decrypt(c2,k2);
        String d1=Decrypt(d2,k);

    }

    public static String Encry(String str, int k)
    {
     
        str = str.replaceAll("\\s", "");
        str = str.replaceAll("[^a-zA-Z]", "");
        str = str.toLowerCase();
        char[] ch = str.toCharArray();
        char[] result = new char[ch.length];
      
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
    
    public static String Decrypt(String str, int k)
    {
        char[] ch = str.toCharArray();
        char[] result = new char[100];
        System.out.println("str in Decrypt:"+str);
        char[] key = String.valueOf(k).toCharArray();
        int l = k;
        int m = -1;

        while (l != 0) {
            int r = l % 10;
            l = l / 10;
            m = Math.max(m, r);
        }   
        System.out.println("\nMax:"+m);
        
        int d = ch.length / m;
        if(ch.length%m != 0)
            d++;
        
        int b = 0;
        
        char[][] matrix = new char[d][m];
        int v=0;
          for(char c:key)
          {
              int g=Integer.parseInt(String.valueOf(c));
              System.out.println("v:"+ (v));
                for(int i =0; i<d ;i++)
                {
                    matrix[i][g-1]=ch[v];
                    v++;
                }
          }
          String o="";
              System.out.println("Decrypt text:");
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < m; j++) {
                o+=matrix[i][j];
                System.out.print(matrix[i][j]);
            }
        }
        return o;
      
    }
    
}
