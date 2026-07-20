package DAY1.SingleThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class Server{

    /**
     * | Data                       | Use                                                                                    |
     * | -------------------------- | -------------------------------------------------------------------------------------- |
     * | Text                       | `BufferedReader` + `PrintWriter`                                                       |
     * | Primitive types            | `DataInputStream` + `DataOutputStream`                                                 |
     * | Images, PDFs, ZIPs, videos | `BufferedInputStream` + `BufferedOutputStream` (or plain `InputStream`/`OutputStream`) |
     * | Java objects               | `ObjectInputStream` + `ObjectOutputStream`                                             |
     */
    public  static void main(String[] args) throws IOException {

        ServerSocket serverSocket= new ServerSocket(8000);
        System.out.println("SERVER LISTENING AT PORT 8000");

        //below line is to keep serverSocket running
        Socket socket=serverSocket.accept();

//        readStringFromClient(socket);

        readImageFromClient(socket);





    }

    public  static void readStringFromClient(Socket socket) throws IOException {

        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        String message= inputStream.readUTF();
        System.out.println(message);
    }

    public  static  void readImageFromClient(Socket socket) throws IOException {
        InputStream inputStream1 = new BufferedInputStream(socket.getInputStream());

        FileOutputStream outputStream= new FileOutputStream("received.jpg");

        byte [] imageBytes = new byte[8192];
        int bytesRead=inputStream1.read(imageBytes);
        while(bytesRead!=-1)
        {
            outputStream.write(imageBytes,0,bytesRead);
            bytesRead=inputStream1.read(imageBytes);
        }
        outputStream.close();
        socket.close();
    }
}