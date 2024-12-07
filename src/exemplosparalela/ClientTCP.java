package exemplosparalela;

import java.io.*;
import java.net.*;

public class ClientTCP {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("177.44.248.13", 5000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            System.out.println(in.readLine());
            out.println("""
                                _   ,_,   _\n
                               / `'=) (='` \\\n
                              /.-.-.\\ /.-.-.\\\n 
                              `      "      `\n
                        
                        """);
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
