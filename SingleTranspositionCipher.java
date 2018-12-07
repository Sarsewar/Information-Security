/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lp;
import java.util.*;
import java.lang.*;
import java.io.*;

/**
 *
 * @author Ankush
 */

/**

@author : Ankush Sarsewar
**/
/* Name of the class has to be "Main" only if the class is public. */


class Transposition
{
    private String plaintext;
    private String k1,k2;
    private int ch=0;
    private int  key1,key2;
    Scanner sc=new Scanner(System.in);
     Transposition()
    {
        k1=k2=null;ch=0;
        plaintext=null;
        int key1=key2=-1;
    }
    void get()
    {
        System.out.println("Enter the plainText:");
        this.plaintext=sc.nextLine();
        this.plaintext = plaintext.replaceAll("\\s", "");
        plaintext = plaintext.replaceAll("[^a-zA-Z]", "");
        plaintext = plaintext.toLowerCase();
        System.out.println("Enter the key:");
        k1=sc.next();
        System.out.println("Enter Following option:\n1.Single Column \n 2.Doulbe Column\n");
        ch=sc.nextInt();
        switch(ch)
        {
            case 1: single(); break;
            case 2: Double();
            break;
            default : System.out.println("Wrong option, Sorry!\n");
        }
    }
    int keyPro(String k)
    {
        if(k.matches("[0-9]+"))
        {
            return Integer.parseInt(k);
        }
        else if(k.matches("[a-zA-Z]+"))
        {   k=k.toLowerCase();
            String str="";
            char[] ch  = k.toCharArray();
            for(char c : ch)
            {
                int temp = (int)c;
                int temp_integer = 96; //for lower case
                if(temp<=122 & temp>=97)
                str+=(temp-temp_integer);
            }
            return Integer.parseInt(str);
        }
        return 0;
    }
    void single()
    { 
        
        System.out.println(" Single Transpositon ");
        key1=keyPro(k1);
        String cipher = Encry(plaintext, key1);
        System.out.println("Enter the key :");
        String res= Decrypt(cipher,keyPro(sc.next()));
        System.out.println("Decryption using single transposition cipher :");
        System.out.println(res);
    }
    void Double()
    {
        System.out.println(" Double Transpositon ");
        key1=keyPro(k1);
        String cipher = Encry(plaintext, key1);
        System.out.println("Enter the key for double transposition:");
        k2=sc.next();
        String cipher1=Encry(cipher,keyPro(k2));
        String d1= Decrypt(cipher1,keyPro(k2));
        System.out.println(" Intermediate Decryption using double transposition cipher :");
        System.out.println(d1);
        String d2=Decrypt(d1,key1);
        System.out.println("Decryption:\n"+d2);
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
        char[] key = String.valueOf(k).toCharArray();
        int l = k;
        int m = -1;

        while (l != 0) {
            int r = l % 10;
            l = l / 10;
            m = Math.max(m, r);
        }   
        
        int d = ch.length / m;
        if(ch.length%m != 0)
            d++;
        
        int b = 0;
        
        char[][] matrix = new char[d][m];
        int v=0;
          for(char c:key)
          {
              int g=Integer.parseInt(String.valueOf(c));
             // System.out.println("v:"+ (v));
                for(int i =0; i<d ;i++)
                {
                    matrix[i][g-1]=ch[v];
                    v++;
                }
          }
          String o="";
             // System.out.println("Decrypt text:");
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < m; j++) {
                o+=matrix[i][j];
               // System.out.print(matrix[i][j]);
            }
        }
        return o;
      
    }
    
}
class LP
{  
    
    public static void main(String[] args) {
        // TODO code application logic here
      
      Scanner sc = new Scanner(System.in);
            Transposition t=new Transposition();
            t.get();

    }
     
}

/**
Enter the plainText:
attack is tonight
Enter the key:
31452
Enter Following option:
1.Single Column 
 2.Doulbe Column

1
 Single Transpositon 
Max:5
Matrix key:
a	t	t	a	c	
k	i	s	t	o	
n	i	g	h	t	
Chiper :
tsgaknathcottii
Enter the key :
31452
Decryption using single transposition cipher :
attackistonight
*******************************************
run:
Enter the plainText:
attack is tonight
Enter the key:
31452
Enter Following option:
1.Single Column 
 2.Doulbe Column

2
 Double Transpositon 
Max:5
Matrix key:
a	t	t	a	c	
k	i	s	t	o	
n	i	g	h	t	
Chiper :
tsgaknathcottii
Enter the key for double transposition:
31452
Max:5
Matrix key:
t	s	g	a	k	
n	a	t	h	c	
o	t	t	i	i	
Chiper :
gtttnoahikcisat
 Intermediate Decryption using double transposition cipher :
tsgaknathcottii
Decryption:
attackistonight
BUILD SUCCESSFUL (total time: 16 seconds)


*/
    
