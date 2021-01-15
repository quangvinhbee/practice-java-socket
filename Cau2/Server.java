/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author lamqu
 */
public class Server {
    public static boolean checkNT(int n){
        for(int i=2; i<n/2 ;i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static String Process(String str){
        String output = "";
        String[] arrStr = str.split("<br>");
        int n, m;
        String[] s = arrStr[0].split(" ");
        n = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);// neu de cho n voi m san trong file
        int[] a = new int[1000];
        int dem=0;
        int k=0;
        for(int i=1; i<arrStr.length; i++){
            k = 0;
            String[] str2 = arrStr[i].split(" ");
            for(int j=0; j<str2.length; j++){
                k++;
                if(!str2[i].equals("")) a[dem] = Integer.parseInt(str2[i]);
            }
        }
        int max1=0,max2=0;
        int[] b = new int[1000];
        for(int i=0;i<dem;i++){
            b[i]=a[i];
        }
        for(int i=0; i<dem ;i++){
            if(checkNT(b[i])) b[i]=0;
        }
        output+="Mang sau khi kiem tra so nguyen to: \n";
        for(int i=0; i<dem; i++){
            output+=String.valueOf(b[i])+" ";
            if((i+1)%(k)==0) output+="\n";
        }
        for(int i=0; i<dem; i++){//tim phan tu lon thu 2
            if(a[i]>max1) max1=a[i];
        }
        for(int i=0; i<dem; i++){
            if(a[i]>max2  && max1>a[i]) max2=a[i];
        }
        for(int i=0; i<dem; i++){
            if(a[i]==max2) a[i]=100;
        }
        
        return output;
    }

    public static void Bai2() throws IOException {
        ServerSocket server = new ServerSocket(1234);
        while (true) {
            Socket socket = server.accept();
            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());
            
            String data = is.readUTF();
            System.out.println(data);
            os.writeUTF(Process(data));
        }
    }
    public static void main(String[] args) throws IOException {
        Bai2();
    }
}
