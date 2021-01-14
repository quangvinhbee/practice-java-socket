/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2_UDP;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author lamqu
 */
public class Server {

    public static InetAddress address;
    public static int port;

    public static void sendtoClient(DatagramSocket ds, String str) throws UnknownHostException, IOException {
        byte[] buff = str.getBytes();
        DatagramPacket packet = new DatagramPacket(buff, buff.length, address, port);
        ds.send(packet);
    }

    public static String receivefromClient(DatagramSocket ds) throws IOException {
        String output = "";
        byte[] buff = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buff, 1024);
        ds.receive(packet);
        address = packet.getAddress();
        port = packet.getPort();
        byte[] receiveData = packet.getData();
        output = (new String(receiveData, 0, receiveData.length, "UTF-8")).trim();
        return output;
    }
//write read file

    public static String readFile(String filename) {
        String output = "";
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                output += data + "<br>";
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lỗi đọc file.");
            e.printStackTrace();
        }

        return output;
    }

    public static void CreateFile(String filename) {
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteFile(String str, String address) {
        try {
            FileWriter myWriter = new FileWriter(address);
            myWriter.write(str);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void DeleteFile(String filename) {
        File myObj = new File(filename);
        if (myObj.delete()) {
            System.out.println("Deleted the folder: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the folder.");
        }
    }

    public static void CopyFile(String add1, String add2, String filename) {
        String src = add1+"\\"+filename;
        String dest = add2;
        try {
            InputStream is = new FileInputStream(src);
            OutputStream os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static String Process(String str) {
        String output = "";
        float total = 0;
        float n = 0;
        DecimalFormat df = new DecimalFormat("#.#");
        String[] arrStr = str.split("<br>");
        for (int i = 0; i < arrStr.length; i++) {
            if (!arrStr[i].equals("")) {
                float avg = 0;
                String[] item = arrStr[i].split(",");
                output += item[0] + "\t";
                avg = Float.parseFloat(df.format(Integer.parseInt(item[1]) * 20 / 100 + Integer.parseInt(item[2]) * 20 / 100 + Integer.parseInt(item[3]) * 60 / 100));
                output += avg + "\n";
                total += avg;
                n++;
            }
        }
        output += "\nTrung binh diem cua lop do la: " + Float.parseFloat(df.format(total / n));
        WriteFile(output, "E:\\DeThi1.txt");
        return output;
    }

    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket ds = new DatagramSocket(1234);
        //sendtoClient(ds, Process(receivefromClient(ds)));
        CopyFile("E:\\client","\\","DeThi1.txt");
    }
}
