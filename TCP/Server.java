package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
    public static String Bai1(String str){
        String output="";
        String[] arrStr = str.split("<br>");
        
        return output;
    }
    public static String Proccess(String str){
        String output="";
        String[] arrStr = str.split("<br>");
        if(arrStr[0]=="1"){
            output=Bai1(str);
        }
        
        return output;
    }
    public static void TransferDataTCP() throws IOException{
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server đã sẵn sàng");
        Socket socket = server.accept();
        
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        
        String input = dis.readUTF();
        
        dos.writeUTF(Proccess(input));
    } 
}
