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
        public static String Bai22() throws IOException{
//      Bài 22: Viết chương trình client/server copy tất cả file/folder qua mạng. Đích và nguồn chỉ định trực tiếp trong mã nguồn hoặc được nhập từ màn hình của client/server.

            String str="";
            System.out.println("Nhập địa chỉ folder nguồn: ");
            str+="22<br>";
            str+=Input.input_String();
            System.out.println("Nhập địa chỉ folder đích: ");
            str+="<br>";
            str+=Input.input_String();
            
            return str;
        }
        public static String Bai21() throws IOException{
//        Bài 21: Viết chương trình client server qua giao thức TCP/UDP thực hiện xử lý nội dụng trong file:
//        Client:
//        - Tìm và đọc file từ 1 đường dẫn với tên file và đường dẫn được nhập trên màn hình, sau đó thực hiện một trong các yêu cầu: 
//        +) Hiển thị các lựa chọn lên màn hình để người dùng lựa chọn nghiệp vụ trong file vừa đọc.
//        +) Hiển thị nội dung trong file theo dạng cấu trúc đề thì lên màn hình và yêu cầu người dùng nhập đáp án gửi lên server xử lý và trả về đáp án đúng.
//        +) Thực hiện trò chơi tìm đường đi ngắn nhất.
//        +) Thực hiện xử lý mảng, ma trận trong file gửi lên server
//        +) …
//        Server:
//        +) Nhận các yêu cầu từ client gửi lên theo từng bài và thực hiện trả kết quả về cho client.

            String str="";
            System.out.println("Nhập n: ");
            str+="21<br>";
            str+=Input.input_int();
            
            return str;
        }
        public static String Bai20() throws IOException{
//          Bài 20: Viết chương trình liệt kê tất cả các hoán vị của 1, 2, .., n. 
            String str="";
            System.out.println("Nhập n: ");
            str+="20<br>";
            str+=Input.input_int();
            
            return str;
        }
         public static String Bai19() throws IOException{
//        Bài 19: Viết chương trình thực hiện nhập một xâu họ tên theo cấu trúc: họ...đệm...tên; chuyển xâu đó sang biểu diễn theo cấu trúc tên…họ…đệm.

            String str="";
            str+="19<br>";
            System.out.println("Nhập chuỗi: ");
            str+=Input.input_String()+"<br>";
            
            return str;
        }
        public static String Bai18() throws IOException{
//        Bài 18: Viết chương trình thực hiện nhập một xâu ký tự và tìm từ dài nhất trong xâu đó. Từ đó xuất hiện ở vị trí nào? (Chú ý. nếu có nhiều từ có độ dài giống nhau thì chọn từ đầu tiên tìm thấy).

            String str="";
            str+="18<br>";
            System.out.println("Nhập chuỗi: ");
            str+=Input.input_String()+"<br>";
            
            return str;
        }
        public static String Bai17() throws IOException{
//        Bài 17: Viết chương trình thực hiện chuẩn hoá một xâu ký tự nhập từ bàn phím (loại bỏ các dấu cách thừa, chuyển ký tự đầu mỗi từ thành chữ hoa, các ký tự khác thành chữ thường)

            String str="";
            str+="17<br>";
            System.out.println("Nhập chuỗi: ");
            str+=Input.input_String()+"<br>";
            
            return str;
        }
        public static String Bai16() throws IOException{
//        Bài 16: Viết chương trình nhập vào vào mảng A có n phần tử, các phần tử là những số nguyên lớn hơn 0 và nhỏ hơn 100 được nhập vào từ bàn phím. Thực hiện các chức năng sau:
//        Tìm phần tử lớn nhất và lớn thứ 2 trong mảng cùng chỉ số của các số đó.
//        Sắp xếp mảng theo thứ tự giảm dần.
//        Nhập một số nguyên x và chèn x vào mảng A sao cho vẫn đảm bảo tính sắp xếp giảm dần.
       

            String str="";
            str+="16<br>";
            System.out.println("Nhập số phần tử: ");
            int n=Input.input_int();
            str+=n+"<br>";
            System.out.println("Nhập số x: ");
            int x=Input.input_int();
            str+=x+"<br>";
            for(int i=0; i<n ;i++){
                str+=Input.input_int()+"<br>";
            }
            
            return str;
        }
        public static String Bai15() throws IOException{
//        Bài 15: Viết chương trình nhập vào vào ma trận A có n dòng, m cột, các phần tử là những số nguyên lớn hơn 0 và nhỏ hơn 100 được nhập vào từ bàn phím. Thực hiện các chức năng sau:
//        Tìm phần tử lớn nhất của ma trận cùng chỉ số của số đó.
//        Tìm và in ra các phần tử là số nguyên tố của ma trận (các phần tử không nguyên tố thì thay bằng số 0).
//        Sắp xếp tất cả các cột của ma trận theo thứ tự tăng dần và in kết quả ra màn hình.

            String str="";
            str+="15<br>";
            System.out.println("Nhập n: ");
            int n=Input.input_int();
            str+=n+"<br>";
            System.out.println("Nhập m: ");
            int m=Input.input_int();
            str+=m+"<br>";
            for(int i=0; i<n ;i++){
                for(int j=0; j<m; j++){
                    str+=Input.input_int()+"<br>";
                }
            }
            
            return str;
        }
        public static String Bai14() throws IOException{
//        Bài 14: Viết chương trình nhập một số nguyên dương n và thực hiện các chức năng sau:
//        Liệt kê n số nguyên tố đầu tiên.
//        Liệt kê n số Fibonaci đầu tiên.
            String str="";
            System.out.println("Nhập n: ");
            str+="14<br>";
            str+=Input.input_int();
            
            return str;
        }
        public static String Bai13() throws IOException{
//      Bài 13: Viết chương trình nhập một số nguyên dương n và thực hiện các chức năng sau:
//      Liệt kê các ước số của n. Có bao nhiêu ước số.
//      Liệt kê các ước số là nguyên tố của


            String str="";
            System.out.println("Nhập n: ");
            str+="13<br>";
            str+=Input.input_int();
            
            return str;
        }
        public static String Bai12() throws IOException{
//          Bài 12: Viết chương trình nhập một số nguyên dương n và thực hiện các chức năng sau: 
//          Tính tổng các chữ số của số nguyên dương.
//          Phân tích n thành các thừa số nguyên tố.

            String str="";
            System.out.println("Nhập n: ");
            str+="12<br>";
            str+=Input.input_int();
            
            return str;
        }
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
            System.out.println(TransferDataTCP(Bai22())); 
        }
}
