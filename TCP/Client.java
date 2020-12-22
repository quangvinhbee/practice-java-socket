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
        public static String Bai11() throws IOException{
//          Bài 11: Nhập một số tự nhiên n. Hãy liệt kê các số Fibonaci nhỏ hơn n là số nguyên tố. 
            String str="";
            System.out.println("Nhập n: ");
            str+="11<br>";
            str+=Input.input_int();
            
            return str;
        }
        public static String Bai10() throws IOException{
//          Bài 10: Viết chương trình liệt kê tất cả các số nguyên tố có 5 chữ số sao cho tổng của các chữ số trong mỗi số nguyên tố đều bằng S cho trước. 
            String str="";
            System.out.println("Nhập S: ");
            str+="10<br>";
            str+=Input.input_int();
            
            return str;
        }
        public static String Bai9() throws IOException{
//          Bài 9: Nhập một xâu ký tự. Đếm số từ của xâu ký tự đó. Thí dụ " Trường học " có 2 từ. 
            String str="";
            System.out.println("Nhập Chuỗi: ");
            str+="9<br>";
            str+=Input.input_String();
            
            return str;
        }
        public static String Bai8(){
//          Bài 8: Nhập số liệu cho dãy số thực a0, a1,..., an-1. In ra màn hình số lần xuất hiện của các phần tử.
            String str="";
            System.out.println("Nhập số phần tử: ");
            str+="8<br>";
            int n = Input.input_int();
            System.out.println("Nhập: ");
            str+=n+"<br>";
            for(int i=0; i<n; i++){
                str+=Input.input_int()+"<br>";
            }
            return str;
        }
        public static String Bai7(){
//          Bài 7: Nhập số liệu cho dãy số thực a0, a1,..., an-1. Hãy liệt kê các phần tử xuất hiện trong dãy đúng 2 lần. 
            String str="";
            System.out.println("Nhập số phần tử: ");
            str+="7<br>";
            int n = Input.input_int();
            System.out.println("Nhập: ");
            str+=n+"<br>";
            for(int i=0; i<n; i++){
                str+=Input.input_int()+"<br>";
            }
            return str;
        }
        public static String Bai6(){
//          Bài 6: Nhập số liệu cho dãy số thực a0, a1,..., an-1. Hãy liệt kê các phần tử xuất hiện trong dãy đúng một lần. 
            String str="";
            System.out.println("Nhập số phần tử: ");
            str+="6<br>";
            int n = Input.input_int();
            System.out.println("Nhập: ");
            str+=n+"<br>";
            for(int i=0; i<n; i++){
                str+=Input.input_int()+"<br>";
            }
            return str;
        }
        public static String Bai5(){
//          Bài 5: Một số được gọi là số thuận nghịch độc nếu ta đọc từ trái sang phải hay từ phải sang trái số đó ta vẫn nhận được một số giống nhau. 
//          Hãy liệt kê tất cả các số thuận nghịch độc có sáu chữ số (Ví dụ số: 336633). 
            String str="";
            System.out.println("Nhập số tự nhiên: ");
            String n = String.valueOf(Input.input_int());
            str="5<br>"+n;
            return str;
        }
        public static String Bai4(){
//          Bài 4: Viết chương trình liệt kê tất cả các số nguyên tố nhỏ hơn n cho trước. 
            String str="";
            System.out.println("Nhập số tự nhiên: ");
            String n = String.valueOf(Input.input_int());
            str="4<br>"+n;
            return str;
        }
        public static String Bai3(){
//          Bài 3: Viết chương trình phân tích một số nguyên thành các thừa số nguyên tố Ví dụ: Số 28 được phân tích thành 2 x 2 x 7. 
            String str="";
            System.out.println("Nhập số tự nhiên: ");
            String n = String.valueOf(Input.input_int());
            str="3<br>"+n;
            return str;
        }
        public static String Bai2(){
//          Bài 2: Hãy viết chương trình tính tổng các chữ số của một số nguyên bất kỳ. Ví dụ: Số 8545604 có tổng các chữ số là: 8+5+4+5+6+0+4= 32.  
            String str="";
            System.out.println("Nhập số tự nhiên: ");
            String n = String.valueOf(Input.input_int());
            str="2<br>"+n;
            return str;
        }
    
        public static String Bai1(){
//          Bài 1: Viết chương trình chuyển đổi một số tự nhiên ở hệ cơ số 10 thành số ở hệ cơ số b bất kì (1< b≤ 24). 
            String str ="1<br>";
            System.out.println("Nhập số tự nhiên: ");
            String n = String.valueOf(Input.input_int());
            System.out.println("Nhập cơ số muốn chuyển: ");
            String coso = String.valueOf(Input.input_int());
            str="1<br>"+n+"<br>"+coso;
            return str;
        }
        public static String TransferDataTCP(String str){
            Socket client;
            String output="";
            try {
                client = new Socket("localhost", 1234);
                DataInputStream dis = new DataInputStream(client.getInputStream());
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF(str);//send Dta
                output= dis.readUTF();
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            return output;
        }
        public static void main(String[] args) throws IOException {
            System.out.println(TransferDataTCP(Bai11())); 
        }
}
