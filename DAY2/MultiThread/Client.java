package DAY2.MultiThread;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static  void main(String[] args) throws IOException {

//        Client client=new Client();
//        for(int i=0;i<10000;i++)
//        {
//            startTask();
//        }

        taskUsingThreadPool();



    }

    private static void taskUsingThreadPool() {

        ExecutorService pool= Executors.newFixedThreadPool(100);

        for(int i=0;i<10000;i++) {
            pool.submit(newTask());
        }

    }

    private static void startTask() {
        Thread thread= new Thread(()->{
            try {
                Socket socket=new Socket("localhost",8001);
                OutputStream outputStream=socket.getOutputStream();
                PrintWriter writer= new PrintWriter(outputStream);
                writer.println(Thread.currentThread()+ "REQUEST TO SERVER");
                writer.flush();
                InputStream is=socket.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(is));
                System.out.println(bufferedReader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
        thread.start();
    }

    public static Runnable newTask() {
        return () ->
        {
            try {
                Socket socket = new Socket("localhost", 8001);
                OutputStream outputStream = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(outputStream);
                writer.println(Thread.currentThread() + "REQUEST TO SERVER");
                writer.flush();
                InputStream is = socket.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
                System.out.println(bufferedReader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

    }


}
