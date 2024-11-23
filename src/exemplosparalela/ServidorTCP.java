package exemplosparalela;

import java.io.*;
import java.net.*;

public class ServidorTCP {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5000, 10);
            while (true) {
                Socket client = serverSocket.accept();
                System.out.println("Conectado pelo IP: " + client.getRemoteSocketAddress());
                new PerformClient(client).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PerformClient extends Thread {

    private Socket client = null;

    public PerformClient(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));

            out.println("Vai catar coquinho!!!!\n te ajeita por ai");
            String s = in.readLine();

            System.out.println("O cliente enviou" + s);

            out.close();
            in.close();
            client.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
