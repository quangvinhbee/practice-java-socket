/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cau2_UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author lamqu
 */
public class Client {

    public static void sendtoServer(DatagramSocket ds, String str) throws UnknownHostException, IOException {
        byte[] buff = str.getBytes();
        InetAddress remote = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(buff, buff.length, remote, 1234);
        ds.send(packet);
    }

    public static String receivefromServer(DatagramSocket ds) throws IOException {
        String output = "";
        byte[] buff = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buff, 1024);
        ds.receive(packet);
        byte[] receiveData = packet.getData();
        output = (new String(receiveData, 0, receiveData.length, "UTF-8")).trim();
        return output;
    }

    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket ds = new DatagramSocket();
        sendtoServer(ds, "Gui tu client");
        System.out.println(receivefromServer(ds));
    }
}
