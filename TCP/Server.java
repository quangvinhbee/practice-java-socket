package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static java.lang.Math.sqrt;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lamqu
 */
public class Server {
    public static boolean CheckNT(int n){
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static boolean CheckBai5(int n){
        int m = n;
        int temp=0;
        while(m>0){
            temp=temp*10+m%10;
            m/=10;
        }
        if(n==temp){
            return true;
        }else{
            return false;
        }
    }
    public static String Bai11(String str){
        String output="Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        int n = Integer.parseInt(arrStr[1]);
        int a0=0 , a1=1, a2=1;
        while(a2<n){
            if(CheckNT(a2)){
                output+=a2+" ";
            }
            int temp = a1+a2;
            a1=a2;
            a2=temp;
            
        }
        
        return output;
    }
    public static String Bai10(String str){
        String output="Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        int s = Integer.parseInt(arrStr[1]);
        for(int  i=10000; i< 99999; i++){
            if(CheckNT(i)){
                int n = i;
                int count = 0;
                while(n>0){
                    count+=n%10;
                    n/=10;
                }
                if(count == s){
                    output+=i+" ";
                }
            }
        }
        
        return output;
    }
    public static String Bai9(String str){
        String output="Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        int count=0;
        for (int i = 0; i < arrStr[1].length() - 1;) {
            if (arrStr[1].charAt(i) == arrStr[1].charAt(i + 1) && arrStr[1].charAt(i)==' ') {
                arrStr[1] = arrStr[1].substring(0, i) + arrStr[1].substring(i + 1);
            } else {
                i++;
            }
        }
        for (int i = 0; i < arrStr[1].length() - 1; i++){
            if(arrStr[1].charAt(i)==' '){
                count ++ ;
            }
        }
        count++;
        
        return output+=count;
    }
    public static String Bai8(String str){
        String output="Các phần tử là: \n";
        String[] arrStr = str.split("<br>");
        int n = Integer.parseInt(arrStr[1]);
        int[] a = new int[n];
        int[] b = new int[1000];
        for(int i=0;i<1000;i++){
            b[i]=0;
        }
        for(int i=2;i<arrStr.length;i++){
            a[i-2]=Integer.parseInt(arrStr[i]);
        }
        for(int i=0;i<n;i++){
            b[a[i]]++;
        }
        for(int i=0;i<1000;i++){
           if(b[i]!=0){
               output+=i+" xuất hiện "+b[i]+"\n";
           }
        }
        if(output.equals("")){
            output="Không có phần tử nào";
        }
        return output;
    }
    public static String Bai7(String str){
        String output="Các phần tử là: ";
        String[] arrStr = str.split("<br>");
        int n = Integer.parseInt(arrStr[1]);
        int[] a = new int[n];
        for(int i=2;i<arrStr.length;i++){
            a[i-2]=Integer.parseInt(arrStr[i]);
        }
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(a[i]==a[j]){
                    count++;
                }
            }
            if(count==2){
                output+=a[i]+" ";
                a[i]=a[i]+Integer.MIN_VALUE;
            }
        }
        if(output.equals("")){
            output="Không có phần tử nào";
        }
        return output;
    }
    public static String Bai6(String str){
        String output="";
        String[] arrStr = str.split("<br>");
        int n = Integer.parseInt(arrStr[1]);
        int[] a = new int[n];
        for(int i=2;i<arrStr.length;i++){
            a[i-2]=Integer.parseInt(arrStr[i]);
        }
        for(int i=0;i<n;i++){
            int count = 0;
            for(int j=0;j<n;j++){
                if(a[i]==a[j]){
                    count++;
                }
            }
            if(count==1){
                output+=a[i]+" ";
            }
        }
        if(output.equals("")){
            output="Không có phần tử nào";
        }
        return output;
    }
    public static String Bai5(String str){
        String output="";
        String[] arrStr = str.split("<br>");
        for(int i=100000;i < 999999;i++){
            if(CheckBai5(i)){
                output+=i+" ";
            }
        }
        
        return output;
    }
    public static String Bai4(String str){
        String output="";
        String[] arrStr = str.split("<br>");
        int n = Integer.parseInt(arrStr[1]);
        if(n==1){
            output="1";
        }
        for(int i=2; i<n; i++){
            if(CheckNT(i)){
                output+=i+" ";
            }
        }
        return output;
    }
    public static String Bai3(String str){
        String output="";
        String[] arrStr = str.split("<br>");
        int n = Integer.parseInt(arrStr[1]);
        if(n==1){
            output="1";
        }
        while(n>1){
            for(int i = 2 ; i<=n;i++){
                if(CheckNT(i)){
                    if(n%i==0){
                        n=n/i;
                        if(n==1){
                            output+=i;
                        }else{
                            output+=i+"x";
                        }
                        break;
                    }
                }
            }
        }
        return output;
    }
    public static String Bai2(String str){
        String output="";
        String[] arrStr = str.split("<br>");
        int n = Integer.parseInt(arrStr[1]);
        int tong = 0;
        while(n>0){
            tong += n % 10;
            n=n/10;
        }
        return output=String.valueOf(tong);
    }
    public static String Bai1(String str){
        String output="";
        String[] x = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N"};
        String[] arrStr = str.split("<br>");
        int n = Integer.parseInt(arrStr[1]);
        int base = Integer.parseInt(arrStr[2]);
        while(n>0){
            int temp = n%base;
            n/=base;
            output+=x[temp];
        } 
        char[] try1 = output.toCharArray();
        String temp="";
        for (int i = try1.length - 1; i >= 0; i--)
            temp+=try1[i];
        
        return temp;
    }
    public static String Proccess(String str){
        String output="";
        String[] arrStr = str.split("<br>");
        if(arrStr[0].equals("1")){
            output=Bai1(str);
        }else if(arrStr[0].equals("2")){
            output=Bai2(str);
        }else if(arrStr[0].equals("3")){
            output=Bai3(str);
        }else if(arrStr[0].equals("4")){
            output=Bai4(str);
        }else if(arrStr[0].equals("5")){
            output=Bai5(str);
        }else if(arrStr[0].equals("6")){
            output=Bai6(str);
        }else if(arrStr[0].equals("7")){
            output=Bai7(str);
        }else if(arrStr[0].equals("8")){
            output=Bai8(str);
        }else if(arrStr[0].equals("9")){
            output=Bai9(str);
        }else if(arrStr[0].equals("10")){
            output=Bai10(str);
        }else if(arrStr[0].equals("11")){
            output=Bai11(str);
        }
        
            
        
        return output;
    }
    public static void TransferDataTCP() throws IOException{
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server đã sẵn sàng");
        while(true){
            Socket socket = server.accept();
        
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            String input = dis.readUTF();
            dos.writeUTF(Proccess(input));
        }
    } 
    public static void main(String[] args) throws IOException {
        TransferDataTCP();
    }
}
