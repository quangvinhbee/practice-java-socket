package UDP;

import TCP.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import static java.lang.Math.sqrt;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;
import static jdk.nashorn.internal.objects.ArrayBufferView.buffer;

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

    public static boolean CheckNT(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean CheckBai5(int n) {
        int m = n;
        int temp = 0;
        while (m > 0) {
            temp = temp * 10 + m % 10;
            m /= 10;
        }
        if (n == temp) {
            return true;
        } else {
            return false;
        }
    }

    public static String Bai23(String str) throws IOException {
        String output = "Kết quả là: ";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        output += "Copy file thành công";
        InputStream is = null;
        OutputStream os = null;
        String src = "";
        String dest = "";
        if (arrStr[1].equals("upload.txt")) {
            src = "E:\\client\\" + arrStr[1];
            dest = "E:\\server";
        } else {
            dest = "E:\\client\\" + arrStr[1];
            src = "E:\\server";
        }
        try {
            is = new FileInputStream(src);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (Exception e) {
            output = "Kết quả là: Copy file thất bại";
            System.out.println(e);
        }

        return output;
    }

    public static String Bai22(String str) {
        
        String output = "Kết quả là: ";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        output += "Copy file thành công";
        try {
            // source & destination directories
            Path src = Paths.get(arrStr[1]);
            Path dest = Paths.get(arrStr[2]);

            // create stream for `src`
            Stream<Path> files = Files.walk(src);

            // copy all files and folders from `src` to `dest`
            files.forEach(file -> {
                try {
                    Files.copy(file, dest.resolve(src.relativize(file)),
                            StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // close the stream
            files.close();

        } catch (IOException ex) {
            output = "Kết quả là: Copy file thất bại";
            ex.printStackTrace();
        }
        return output;
    }

    public static String Bai20(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        
        int n = Integer.parseInt(arrStr[1]);
        // khoi tao mang gom n phan tu
        int[] mang = new int[n];
        output += "Tất cả hoán vị là: \n";
        // gan gia tri cho cac phan tu cua mang va in ra bo hoan vi dau tien
        int i;
        for (i = 0; i < n; i++) {
            mang[i] = i + 1;
            output += mang[i];
        }
        output += " ";
        // xu ly de in ra cac bo hoan vi tiep theo
        for (i = n - 1; i > 0; i--) {
            // neu gap mang[i] > mang[i - 1]
            if (mang[i] > mang[i - 1]) {
                int j;

                // tim trong bo cuoi giam dan phan tu vua du lon hon mang[i - 1] sau do swap.
                for (j = n - 1; j >= i; j--) {
                    if (mang[j] > mang[i - 1]) {
                        int temp = mang[j];
                        mang[j] = mang[i - 1];
                        mang[i - 1] = temp;
                        break;
                    }
                }

                // dao nguoc bo cuoi
                for (j = n - 1; j > ((n - 1 + i) / 2); j--) {
                    int temp = mang[i + n - 1 - j];
                    mang[i + n - 1 - j] = mang[j];
                    mang[j] = temp;
                }

                // in ra bo hoan vi moi
                output += " ";
                for (j = 0; j < n; j++) {
                    output += mang[j];
                }

                // i = n de khi thoat vong lap hien tai i-- thanh i = n - 1; va vong lap chay lai tu dau.
                i = n;
            }
        }
        return output;
    }

    public static String Bai19(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        StringTokenizer strToken = new StringTokenizer(arrStr[1], " ,\t,\r");
        String ho = strToken.nextToken();
        String hoDem = strToken.nextToken();
        String ten = strToken.nextToken();
        String strOutput = ten + " " + ho + " " + hoDem;
        output += "Chuỗi sau khi đổi vị trí là: " + strOutput;
        return output;
    }

    public static String Bai18(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        StringTokenizer strToken = new StringTokenizer(arrStr[1], " ,\t,\r");
        int Max, i = 1, lengthStr;
        Max = strToken.nextToken().length();
        int viTriMax = i;
        String StrMax = "";
        while (strToken.hasMoreTokens()) {
            StrMax = strToken.nextToken();
            lengthStr = strToken.nextToken().length();
            i++;
            if (Max < lengthStr) {
                Max = lengthStr;
                viTriMax = i;
            }
        }
        output += "Do dai xau lon nhat la: " + StrMax + " o vi tri " + viTriMax;
        return output;
    }

    public static String Bai17(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        for (int i = 0; i < arrStr[1].length() - 1;) {
            if (arrStr[1].charAt(i) == arrStr[1].charAt(i + 1) && arrStr[1].charAt(i) == ' ') {
                arrStr[1] = arrStr[1].substring(0, i) + arrStr[1].substring(i + 1);
            } else {
                i++;
            }
        }
        char k;

        char[] arr = arrStr[1].toCharArray();
        arrStr[1] = "";
        arrStr[1] += Character.toUpperCase(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Character.toLowerCase(arr[i]);
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != ' ' && arr[i - 1] == ' ') {
                arr[i] = Character.toUpperCase(arr[i]);
            }
        }
        for (int i = 1; i < arr.length; i++) {
            arrStr[1] += arr[i];
        }
        output += "Chuỗi sau khi chuẩn hóa: " + arrStr[1];
        return output;
    }

    public static String Bai16(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        int x = Integer.parseInt(arrStr[2]);
        int[] arr = new int[n];
        String temp = "";
        int max1 = 0, max2 = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i + 3]);
            if (arr[i] > max1) {
                max1 = arr[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] < max1 && arr[i] > max2) {
                max2 = arr[i];
                temp = arr[i] + "[" + i + "]";
            }
        }
        output += "\nSố lớn hai trong mảng là: " + temp;
        Arrays.sort(arr);
        output += "\nMảng sau khi sắp xếp là: ";
        for (int i = 0; i < n; i++) {
            output += arr[i] + " ";
        }
        int[] b = new int[n + 1];
        for (int i = 0; i < n; i++) {
            b[i] = arr[i];
        }
        b[n] = x;
        Arrays.sort(b);
        output += "\nMảng sau khi thêm x: ";
        for (int i = 0; i < n; i++) {
            output += b[i] + " ";
        }

        return output;
    }

    public static String Bai15(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        int m = Integer.parseInt(arrStr[2]);
        int[][] arr = new int[n][m];
        String temp = "";
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(arrStr[m * i + j + 3]);
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    temp = arr[i][j] + "[" + i + "]" + "[" + j + "]";
                }
            }
        }
        output += "\nSố lớn nhất trong mảng nxm là: " + temp;
        output += "\nMa trận các số nguyên tố:\n";
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (CheckNT(arr[i][j])) {
                    output += arr[i][j] + " ";
                } else {
                    output += 0 + " ";
                }
            }
            output += "\n";
        }

        output += "\nMa trận sau khi sắp xếp:\n";
        for (int j = 0; j < m; j++) {
            for (int i = 1; i < n; i++) {
                if (arr[i - 1][j] > arr[i][j]) {
                    int temp1 = arr[i - 1][j];
                    arr[i - 1][j] = arr[i][j];
                    arr[i][j] = temp1;

                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                output += arr[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }

    public static String Bai14(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        output += "Số nguyên tố nhỏ hơn n là: ";
        int count = 0;
        int so = 2;
        while (count <= n) {
            if (CheckNT(so)) {
                count++;
                output += so + " ";
            }
            so++;
        }
        output += "\nn số Fibonacci: ";
        int a0 = 0, a1 = 1, a2 = 1;
        count = 0;
        while (count <= n) {
            output += a2 + " ";
            int temp = a1 + a2;
            a1 = a2;
            a2 = temp;
            count++;
        }
        return output;
    }

    public static String Bai13(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        output += "Ước của n là: ";
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                output += i + " ";
                count++;
            }
        }
        output += "\nTổng số ước là: " + count;
        output += "\nƯớc nguyên tố của n là: ";
        for (int i = 1; i <= n; i++) {
            if (n % i == 0 && CheckNT(i)) {
                output += i + " ";
            }
        }
        return output;
    }

    public static String Bai12(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        int m = n;
        int total = 0;
        while (m > 0) {
            total += m % 10;
            m /= 10;
        }
        output += "Tổng là: " + total;
        if (n == 1) {
            output += "\nPhân tích số nguyên tố: " + 1;
        }
        output += "\nPhân tích số nguyên tố: ";
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (CheckNT(i)) {
                    if (n % i == 0) {
                        n = n / i;
                        if (n == 1) {
                            output += i;
                        } else {
                            output += i + "x";
                        }
                        break;
                    }
                }
            }
        }

        return output;
    }

    public static String Bai11(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        int a0 = 0, a1 = 1, a2 = 1;
        while (a2 < n) {
            if (CheckNT(a2)) {
                output += a2 + " ";
            }
            int temp = a1 + a2;
            a1 = a2;
            a2 = temp;

        }

        return output;
    }

    public static String Bai10(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int s = Integer.parseInt(arrStr[1]);
        for (int i = 10000; i < 99999; i++) {
            if (CheckNT(i)) {
                int n = i;
                int count = 0;
                while (n > 0) {
                    count += n % 10;
                    n /= 10;
                }
                if (count == s) {
                    output += i + " ";
                }
            }
        }

        return output;
    }

    public static String Bai9(String str) {
        String output = "Kết quả là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int count = 0;
        for (int i = 0; i < arrStr[1].length() - 1;) {
            if (arrStr[1].charAt(i) == arrStr[1].charAt(i + 1) && arrStr[1].charAt(i) == ' ') {
                arrStr[1] = arrStr[1].substring(0, i) + arrStr[1].substring(i + 1);
            } else {
                i++;
            }
        }
        for (int i = 0; i < arrStr[1].length() - 1; i++) {
            if (arrStr[1].charAt(i) == ' ') {
                count++;
            }
        }
        count++;

        return output += count;
    }

    public static String Bai8(String str) {
        String output = "Các phần tử là: \n";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        int[] a = new int[n];
        int[] b = new int[1000];
        for (int i = 0; i < 1000; i++) {
            b[i] = 0;
        }
        for (int i = 2; i < arrStr.length; i++) {
            a[i - 2] = Integer.parseInt(arrStr[i]);
        }
        for (int i = 0; i < n; i++) {
            b[a[i]]++;
        }
        for (int i = 0; i < 1000; i++) {
            if (b[i] != 0) {
                output += i + " xuất hiện " + b[i] + "\n";
            }
        }
        if (output.equals("")) {
            output = "Không có phần tử nào";
        }
        return output;
    }

    public static String Bai7(String str) {
        String output = "Các phần tử là: ";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        int[] a = new int[n];
        for (int i = 2; i < arrStr.length; i++) {
            a[i - 2] = Integer.parseInt(arrStr[i]);
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if (count == 2) {
                output += a[i] + " ";
                a[i] = a[i] + Integer.MIN_VALUE;
            }
        }
        if (output.equals("")) {
            output = "Không có phần tử nào";
        }
        return output;
    }

    public static String Bai6(String str) {
        String output = "";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        int[] a = new int[n];
        for (int i = 2; i < arrStr.length; i++) {
            a[i - 2] = Integer.parseInt(arrStr[i]);
        }
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (a[i] == a[j]) {
                    count++;
                }
            }
            if (count == 1) {
                output += a[i] + " ";
            }
        }
        if (output.equals("")) {
            output = "Không có phần tử nào";
        }
        return output;
    }

    public static String Bai5(String str) {
        String output = "";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        for (int i = 100000; i < 999999; i++) {
            if (CheckBai5(i)) {
                output += i + " ";
            }
        }

        return output;
    }

    public static String Bai4(String str) {
        String output = "";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        if (n == 1) {
            output = "1";
        }
        for (int i = 2; i < n; i++) {
            if (CheckNT(i)) {
                output += i + " ";
            }
        }
        return output;
    }

    public static String Bai3(String str) {
        String output = "";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        if (n == 1) {
            output = "1";
        }
        while (n > 1) {
            for (int i = 2; i <= n; i++) {
                if (CheckNT(i)) {
                    if (n % i == 0) {
                        n = n / i;
                        if (n == 1) {
                            output += i;
                        } else {
                            output += i + "x";
                        }
                        break;
                    }
                }
            }
        }
        return output;
    }

    public static String Bai2(String str) {
        String output = "";
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        int tong = 0;
        while (n > 0) {
            tong += n % 10;
            n = n / 10;
        }
        return output = String.valueOf(tong);
    }

    public static String Bai1(String str) {
        String output = "";
        String[] x = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N"};
        String[] arrStr = str.split("<br>");
        for(int i=0; i<arrStr.length; i++){
            arrStr[i] = arrStr[i].trim();
        }
        int n = Integer.parseInt(arrStr[1]);
        int base = Integer.parseInt(arrStr[2]);
        while (n > 0) {
            int temp = n % base;
            n /= base;
            output += x[temp];
        }
        char[] try1 = output.toCharArray();
        String temp = "";
        for (int i = try1.length - 1; i >= 0; i--) {
            temp += try1[i];
        }

        return temp;
    }

    public static String Proccess(String str) throws IOException {
        String output = "";
        String[] arrStr = str.split("<br>");
        if (arrStr[0].equals("1")) {
            output = Bai1(str);
        } else if (arrStr[0].equals("2")) {
            output = Bai2(str);
        } else if (arrStr[0].equals("3")) {
            output = Bai3(str);
        } else if (arrStr[0].equals("4")) {
            output = Bai4(str);
        } else if (arrStr[0].equals("5")) {
            output = Bai5(str);
        } else if (arrStr[0].equals("6")) {
            output = Bai6(str);
        } else if (arrStr[0].equals("7")) {
            output = Bai7(str);
        } else if (arrStr[0].equals("8")) {
            output = Bai8(str);
        } else if (arrStr[0].equals("9")) {
            output = Bai9(str);
        } else if (arrStr[0].equals("10")) {
            output = Bai10(str);
        } else if (arrStr[0].equals("11")) {
            output = Bai11(str);
        } else if (arrStr[0].equals("12")) {
            output = Bai12(str);
        } else if (arrStr[0].equals("13")) {
            output = Bai13(str);
        } else if (arrStr[0].equals("14")) {
            output = Bai14(str);
        } else if (arrStr[0].equals("15")) {
            output = Bai15(str);
        } else if (arrStr[0].equals("16")) {
            output = Bai16(str);
        } else if (arrStr[0].equals("17")) {
            output = Bai17(str);
        } else if (arrStr[0].equals("18")) {
            output = Bai18(str);
        } else if (arrStr[0].equals("19")) {
            output = Bai19(str);
        } else if (arrStr[0].equals("20")) {
            output = Bai20(str);
        } else if (arrStr[0].equals("22")) {
            output = Bai22(str);
        } else if (arrStr[0].equals("23")) {
            output = Bai23(str);
        }

        return output;
    }

    public static void TransferDataUDP() throws IOException {
        //recieve data
        DatagramSocket socket = new DatagramSocket(12344);
        System.out.println("Server aldready");
        byte[] buff = new byte[1024];
        DatagramPacket packetRecieve = new DatagramPacket(buff, buff.length);
        byte[] receiveData = packetRecieve.getData();
        socket.receive(packetRecieve);
        String strRecieve = new String(receiveData, 0, receiveData.length, "UTF-8");
        System.out.println(strRecieve);
        //send data
        String str = strRecieve;
        byte[] sendClient = Proccess(str).getBytes();
        int port = packetRecieve.getPort();
        InetAddress add = packetRecieve.getAddress();
        DatagramPacket toclient = new DatagramPacket(sendClient, sendClient.length, add, port);
        socket.send(toclient);
    }

    public static void main(String[] args) throws IOException {
        TransferDataUDP();
    }
}
