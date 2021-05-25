package server.com;

import model.com.TradeProduct;

import java.io.IOException;
import java.net.ServerSocket;

public class ServerApplication {
    TradeProduct trade;

    public ServerApplication() {
        trade = new TradeProduct();
        Thread t = new Thread();
        t.start();
        try {
            ServerSocket socket = new ServerSocket(12345);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerApplication serverApplication = new ServerApplication();
    }
}
