package InformationSecurity;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Ankush Sarsewar
 */public class ShiftChiper {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Enter the plainText:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = 0;
        do {
            System.out.println("Enter the key :");
            k = sc.nextInt();
            if (k >= 27) {
                System.out.println("Key should be in range [0-26]");
            }
        } while (k >= 27);
        str = Encry(str, k);
        String cipher = str;
        do {
            System.out.println("Enter the key for decryption :");
            k = sc.nextInt();
            if (k >= 27) {
                System.out.println("Key should be in range [0-26]");
            }
        } while (k >= 27);
        String t = Decry(str, k);
        BruteForce(cipher);
    }

    public static void BruteForce(String str) {
        System.out.println("*******Brute Force********");
        String result = new String();
        String s = str;
        for (int i = 1; i <= 26; i++) {
            System.out.println("For key =" + i);
            result = Decry(s, i);
            System.out.println("**************************************");
        }

    }


    public static String Encry(String str, int k)
    {
        str = str.replaceAll("\\s", "");
        str = str.replaceAll("[^a-zA-Z]", "");
        str = str.toLowerCase();
        System.out.println("PlainText:"+str);
        char[] ch = str.toCharArray();
        char[] result = new char[str.length()];
        for (int i = 0; i < ch.length; i++)
        {
            int l = (int) ch[i];
            l += k;
            if (l > 122) {
                l -= 26;
            }
            result[i] = (char) l;

        }
        String res = String.valueOf(result);
        System.out.println("Encrypted data(cipher):");
        System.out.println(res);
        return res;
    }

    public static String Decry(String str, int k) {
        char[] ch = str.toCharArray();
        char[] result = new char[ch.length];
        for (int i = 0; i < ch.length; i++)
        {
            int l = (int) ch[i];
            l -= k;
            if (l < 97) {
                l += 26;
            }
            result[i] = (char) l;
        }
        String res = String.valueOf(result);
        System.out.println("Decrypted data(plainText):");
        System.out.println(res);
        return res;
    }

}
/*
Enter the plainText:
MEET me @airport phone no: 123456789, email-id : xyz@gmail.com
Enter the key :
3
PlainText:meetmeairportphonenoemailidxyzgmailcom
Encrypted data(cipher):
phhwphdlusruwskrqhqrhpdlolgabcjpdlofrp
Enter the key for decryption :
3
Decrypted data(plainText):
meetmeairportphonenoemailidxyzgmailcom
*******Brute Force********
For key =1
Decrypted data(plainText):
oggvogcktrqtvrjqpgpqgocknkfzabiockneqo
**************************************
For key =2
Decrypted data(plainText):
nffunfbjsqpsuqipofopfnbjmjeyzahnbjmdpn
**************************************
For key =3
Decrypted data(plainText):
meetmeairportphonenoemailidxyzgmailcom
**************************************
For key =4
Decrypted data(plainText):
lddsldzhqonqsognmdmndlzhkhcwxyflzhkbnl
**************************************
For key =5
Decrypted data(plainText):
kccrkcygpnmprnfmlclmckygjgbvwxekygjamk
**************************************
For key =6
Decrypted data(plainText):
jbbqjbxfomloqmelkbklbjxfifauvwdjxfizlj
**************************************
For key =7
Decrypted data(plainText):
iaapiawenlknpldkjajkaiweheztuvciwehyki
**************************************
For key =8
Decrypted data(plainText):
hzzohzvdmkjmokcjizijzhvdgdystubhvdgxjh
**************************************
For key =9
Decrypted data(plainText):
gyyngyucljilnjbihyhiygucfcxrstagucfwig
**************************************
For key =10
Decrypted data(plainText):
fxxmfxtbkihkmiahgxghxftbebwqrszftbevhf
**************************************
For key =11
Decrypted data(plainText):
ewwlewsajhgjlhzgfwfgwesadavpqryesaduge
**************************************
For key =12
Decrypted data(plainText):
dvvkdvrzigfikgyfevefvdrzczuopqxdrzctfd
**************************************
For key =13
Decrypted data(plainText):
cuujcuqyhfehjfxedudeucqybytnopwcqybsec
**************************************
For key =14
Decrypted data(plainText):
bttibtpxgedgiewdctcdtbpxaxsmnovbpxardb
**************************************
For key =15
Decrypted data(plainText):
asshasowfdcfhdvcbsbcsaowzwrlmnuaowzqca
**************************************
For key =16
Decrypted data(plainText):
zrrgzrnvecbegcubarabrznvyvqklmtznvypbz
**************************************
For key =17
Decrypted data(plainText):
yqqfyqmudbadfbtazqzaqymuxupjklsymuxoay
**************************************
For key =18
Decrypted data(plainText):
xppexpltcazceaszypyzpxltwtoijkrxltwnzx
**************************************
For key =19
Decrypted data(plainText):
woodwoksbzybdzryxoxyowksvsnhijqwksvmyw
**************************************
For key =20
Decrypted data(plainText):
vnncvnjrayxacyqxwnwxnvjrurmghipvjrulxv
**************************************
For key =21
Decrypted data(plainText):
ummbumiqzxwzbxpwvmvwmuiqtqlfghouiqtkwu
**************************************
For key =22
Decrypted data(plainText):
tllatlhpywvyawovuluvlthpspkefgnthpsjvt
**************************************
For key =23
Decrypted data(plainText):
skkzskgoxvuxzvnutktuksgorojdefmsgorius
**************************************
For key =24
Decrypted data(plainText):
rjjyrjfnwutwyumtsjstjrfnqnicdelrfnqhtr
**************************************
For key =25
Decrypted data(plainText):
qiixqiemvtsvxtlsrirsiqempmhbcdkqempgsq
**************************************
For key =26
Decrypted data(plainText):
phhwphdlusruwskrqhqrhpdlolgabcjpdlofrp
**************************************

Process finished with exit code 0


*/