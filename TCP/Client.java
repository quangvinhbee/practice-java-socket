/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lamqu
 */
public class Client {
        public static String Bai1(){
//          Bài 1: Viết chương trình chuyển đổi một số tự nhiên ở hệ cơ số 10 thành số ở hệ cơ số b bất kì (1< b≤ 24). 
            String str ="";
            System.out.println("Nhập số tự nhiên: ");
            String n = String.valueOf(Input.input_int());
            System.out.println("Nhập cơ số muốn chuyển: ");
            String coso = String.valueOf(Input.input_int());
            str=n+"<br>"+coso;
            return str;
        }
        public static void TransferDataTCP(String str){
            Socket client;
            try {
                client = new Socket("localhost", 1234);
                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(str);//send Dta
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public static void main(String[] args) {
            TransferDataTCP(Bai1());
        }
}
