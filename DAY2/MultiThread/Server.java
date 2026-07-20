package DAY2.MultiThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static  void main(String[] args) throws IOException {
        int port=8001;
        ServerSocket serverSocket=new ServerSocket(port);
        while(true)
        {

            serverSocket.setSoTimeout(1000000);
            Socket socket=serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            System.out.println(bufferedReader.readLine());
            OutputStream outputStream=socket.getOutputStream();
            PrintWriter printWriter=new PrintWriter(outputStream);
            printWriter.println("This is response from Server");
            printWriter.flush();

        }
    }
}
