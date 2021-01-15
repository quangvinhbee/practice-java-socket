/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author lamqu
 */
public class Client {
    public static String Nhap() throws IOException{
        String str="";
        System.out.println("Nhap duong dan: ");
        str = Input.input_String();
        return str;
    }
    public static String readFile(String address) throws FileNotFoundException{
        String output ="";
        File myFile = new File(address+"\\MANGMATRAN.txt");
        Scanner myReader = new Scanner(myFile);
        while(myReader.hasNextLine()){
            String data= myReader.nextLine();
            output += data+"<br>";
        }
        
        return output;
    }
    public static void Bai2() throws IOException{
        Socket client = new Socket("localhost", 1234);
        DataInputStream is = new DataInputStream(client.getInputStream());
        DataOutputStream os = new DataOutputStream(client.getOutputStream());
        os.writeUTF(readFile(Nhap()));
        System.out.println(is.readUTF());
    }
    public static void main(String[] args) throws IOException {
        Bai2();
    }
}
