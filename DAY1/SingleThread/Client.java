package DAY1.SingleThread;

import java.io.*;
import java.net.Socket;

public class Client {

    public static  void main(String[] args) throws IOException {

        Socket socket=new Socket("localhost",8000);
        sendImageToServer(socket);
        System.out.println("IMAGE SENT TO SERVER");

    }


    public void simpleServerTest(Socket socket) throws IOException
    {

        System.out.println("CONNECTED TO SERVER");
        DataOutputStream outputStream=new DataOutputStream(socket.getOutputStream());

        outputStream.writeUTF("WRITING MESSAGE TO SERVER");
        outputStream.flush();

        outputStream.close();
        socket.close();
    }

    public  static void sendImageToServer(Socket socket) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:\\BACKEND\\src\\newimage.jpg");
        OutputStream outputStream=socket.getOutputStream();
        byte []  bytes= new byte[8192];
        int bytesRead=fileInputStream.read(bytes);
        while (bytesRead!=-1) {
            outputStream.write(bytes,0,bytesRead);
            bytesRead=fileInputStream.read(bytes);
        }
        outputStream.flush();
        socket.shutdownOutput();
        outputStream.close();
        socket.close();
    }


}
