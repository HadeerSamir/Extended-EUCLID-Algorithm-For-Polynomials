package etended_euclid_polynomials;

import java.util.Scanner;

public class Etended_EUCLID_Polynomials {
    
    
    
//    public static String gcd(String x,String y){
//            int output;
//            int smallNumber;
//            int largeNumber;
//            if(x<y){
//                smallNumber=x;
//                largeNumber=y;
//            }
//            else{
//                smallNumber=y;
//                largeNumber=x;
//            }
//            
//            if(x==0){
//                output=y;
//            }
//            else if(y==0){
//                output=x;
//            }
//            else{
//                output=gcd(smallNumber,largeNumber%smallNumber);
//            }
//            
//            return output;
//
//
//        }

    public static String hexaToBinary(String hexa) {
        String binary = "";
        String formatedInput = "";
        for (int i = 0; i < hexa.length(); i++) {
            switch (hexa.charAt(i)) {

                case '0':
                    binary = "0000";
                    break;

                case '1':
                    binary = "0001";
                    break;

                case '2':
                    binary = "0010";
                    break;

                case '3':
                    binary = "0011";
                    break;

                case '4':
                    binary = "0100";
                    break;

                case '5':
                    binary = "0101";
                    break;

                case '6':
                    binary = "0110";
                    break;

                case '7':
                    binary = "0111";
                    break;

                case '8':
                    binary = "1000";
                    break;

                case '9':
                    binary = "1001";
                    break;

                case 'A':
                    binary = "1010";
                    break;

                case 'B':
                    binary = "1011";
                    break;

                case 'C':
                    binary = "1100";
                    break;

                case 'D':
                    binary = "1101";
                    break;

                case 'E':
                    binary = "1110";
                    break;

                case 'F':
                    binary = "1111";
                    break;
            }
            formatedInput += binary;

        }
        return formatedInput;

    }

    public static String performXOR(String key, String permulationTableOutput) {
        int res;
        String output = "";

        for (int i = 0; i < key.length(); i++) {
            int keyChar = (int) key.charAt(i);
            int permulationTableOutputChar = (int) permulationTableOutput.charAt(i);
            res = (int) (keyChar ^ permulationTableOutputChar);

            output += res;
        }

        return output;   //binaryformat
    }

    public static String binaryToHexa(String input) {

        String result = "";
        String hexaOutput = "";

        for (int i = 0; i < input.length(); i = i + 4) {

            String tmp = input.substring(i, i + 4);

            int decimal = Integer.parseInt(tmp, 2);
            hexaOutput = hexaOutput + Integer.toHexString(decimal);

        }
        result = hexaOutput.toUpperCase();

        return result;
    }

    public static String divide(String a, String b) {
        String output = "00000000";
        String B1 = "00011011";
        int flag = 0;

        String a1 = a;
        if (a1.charAt(0) == '1') {
            flag = 1;
        }

        //String a2 = a1.substring(1) + "0";
        String a2 = "0" + a1.substring(0, 7);
        if (flag == 1) {
            a2 = performXOR(a2, B1);
            flag = 0;
        }
        if (a2.charAt(0) == '1') {
            flag = 1;
        }

        String a3 = "0" + a2.substring(0, 7);
        if (flag == 1) {
            a3 = performXOR(a3, B1);
            flag = 0;
        }
        if (a3.charAt(0) == '1') {
            flag = 1;
        }

        String a4 = "0" + a3.substring(0, 7);
        if (flag == 1) {
            a4 = performXOR(a4, B1);
            flag = 0;
        }
        if (a4.charAt(0) == '1') {
            flag = 1;
        }

        String a5 = "0" + a4.substring(0, 7);
        if (flag == 1) {
            a5 = performXOR(a5, B1);
            flag = 0;
        }
        if (a5.charAt(0) == '1') {
            flag = 1;
        }
        String a6 = "0" + a5.substring(0, 7);
        if (flag == 1) {
            a6 = performXOR(a6, B1);
            flag = 0;
        }
        if (a6.charAt(0) == '1') {
            flag = 1;
        }

        String a7 = "0" + a6.substring(0, 7);
        if (flag == 1) {
            a7 = performXOR(a7, B1);
            flag = 0;
        }
        if (a7.charAt(0) == '1') {
            flag = 1;
        }

        String a8 = "0" + a7.substring(0, 7);
        if (flag == 1) {
            a8 = performXOR(a8, B1);
            flag = 0;
        }
        if (a8.charAt(0) == '1') {
            flag = 1;
        }

        String bIndex = "";
        for (int i = 0; i < b.length(); i++) {
            if (b.charAt(i) == '1') {
                bIndex += i;
            }

        }

        //String initial="00000000";
        for (int i = 0; i < bIndex.length(); i++) {
            switch (bIndex.charAt(i)) {
                case '0':
                    output = performXOR(output, a8);
                    break;

                case '1':
                    output = performXOR(output, a7);
                    break;

                case '2':
                    output = performXOR(output, a6);
                    break;

                case '3':
                    output = performXOR(output, a5);
                    break;

                case '4':
                    output = performXOR(output, a4);
                    break;

                case '5':
                    output = performXOR(output, a3);
                    break;

                case '6':
                    output = performXOR(output, a2);
                    break;

                case '7':
                    output = performXOR(output, a1);
                    break;

            }
        }

        return output;

    }
    
     public static String add(String a, String b) {

        String output = performXOR(a, b);

        return output;

    }

     
     public static String multiply(String a, String b) {
        String output="00000000";
        String B1 = "00011011";
        int flag=0;

        String a1 = a;
        if (a1.charAt(0) == '1') {
            flag=1;
        }

        String a2 = a1.substring(1) + "0";
        if(flag==1){
            a2=performXOR(a2, B1);
            flag=0;
        }
        if (a2.charAt(0) == '1') {
            flag=1;
        }

        String a3 = a2.substring(1) + "0";
        if(flag==1){
            a3=performXOR(a3, B1);
            flag=0;
        }
        if (a3.charAt(0) == '1') {
            flag=1;
        }

          String a4 = a3.substring(1) + "0";
        if(flag==1){
            a4=performXOR(a4, B1);
            flag=0;
        }
        if (a4.charAt(0) == '1') {
            flag=1;
        }

         String a5 = a4.substring(1) + "0";
        if(flag==1){
            a5=performXOR(a5, B1);
            flag=0;
        }
        if (a5.charAt(0) == '1') {
            flag=1;
        }
         String a6 = a5.substring(1) + "0";
        if(flag==1){
            a6=performXOR(a6, B1);
            flag=0;
        }
        if (a6.charAt(0) == '1') {
            flag=1;
        }

           String a7 = a6.substring(1) + "0";
        if(flag==1){
            a7=performXOR(a7, B1);
            flag=0;
        }
        if (a7.charAt(0) == '1') {
            flag=1;
        }
        
                   String a8 = a7.substring(1) + "0";
        if(flag==1){
            a8=performXOR(a8, B1);
            flag=0;
        }
        if (a8.charAt(0) == '1') {
            flag=1;
        }
        
        
        String bIndex="";
        for(int i=0;i<b.length();i++){
            if(b.charAt(i)=='1'){
                bIndex+=i;   
            }
            
        }
        
        //String initial="00000000";
        
        
        for(int i=0;i<bIndex.length();i++){
            switch(bIndex.charAt(i)){
                case '0':
                    output=performXOR(output,a8);
                    break;
                    
                    case '1':
                    output=performXOR(output,a7);
                    break;
                    
                     case '2':
                    output=performXOR(output,a6);
                    break;
                    
                     case '3':
                    output=performXOR(output,a5);
                    break;
                    
                     case '4':
                    output=performXOR(output,a4);
                    break;
                    
                     case '5':
                    output=performXOR(output,a3);
                    break;
                    
                     case '6':
                    output=performXOR(output,a2);
                    break;
                    
                     case '7':
                    output=performXOR(output,a1);
                    break;
                    
            }
        }

     

        return output;

    }
    
    
    public static String extend(String b){
        String m="00011011";
        
        String output="";
        String A1="1";
        String A2="0";
        String A3=m;
        String B1="0";
        String B2="1";
        String B3=b;
        String T1,T2,T3="0";
        
        
       while(true){
        
        
        if(B3=="0"){
          //  A3=gcd(m,b);   //no inverse
            output="IMPOSSIBLE";
            break;
        }
        else if(B3=="1"){
           // B3=gcd(m,n);
//            if(B2<0){
//                B2=B2+m;
//                B2=B2%m;
//            }
            output+=B2;
            break;
        }
        else{
            
        String Q=divide(A3,B3);
        //T1=A1-Q*B1;
        T1=add(A1,multiply(Q,B1));
        T2=add(A2,multiply(Q,B2));
        T3=add(A3,multiply(Q,B3));
//        T2=A2-Q*B2;
//        T3=A3-Q*B3;
        A1=B1;
        A2=B2;
        A3=B3;
        B1=T1;
        B2=T2;
        B3=T3;
        }
       }
       return output;
        
    }

    

    public static void main(String[] args) {

        
        
        Scanner scan=new Scanner(System.in);
        String input=scan.next();
        
       
    }

}
