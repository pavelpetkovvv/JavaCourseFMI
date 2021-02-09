package Client;
import com.sun.source.tree.WhileLoopTree;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client implements Runnable{
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;

    public Client(String address, int port){
        try {
            socket = new Socket(address, port);
            System.out.println("connected");

            input = new DataInputStream(System.in);


            out = new DataOutputStream(socket.getOutputStream());

        }catch (UnknownHostException e){
            e.printStackTrace();
        }catch (IOException i){
            i.printStackTrace();
        }


        /*
        String line = " ";

        while (!line.equals(".")){
            try{
                line = input.readLine();
                out.writeUTF(line);
            }catch (IOException e){
                e.printStackTrace();
            }
        }

         */
    }

    public static void main(String[] args) {
        Client client = new Client("localHost", 1234);
        client.run();
    }


    private void sendMessage(String message) {
        try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            writer.write(message);
            //writer.flush();
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long millisStart = System.currentTimeMillis();
        long millisEnd = System.currentTimeMillis();

        while(true) {

            millisEnd = System.currentTimeMillis();

            //System.out.println(millisEnd-millisStart);
            if(millisEnd-millisStart >= 3000){
                millisStart=System.currentTimeMillis();
                sendMessage("str");
            }
/*
            Thread thread = new Thread();

            sendMessage("str");

            try {

                System.out.println(1);
                thread.sleep(5000);
                System.out.println(2);
                sendMessage("str");
            }catch (InterruptedException e){
                e.printStackTrace();
            }

 */
        }
    }
}
