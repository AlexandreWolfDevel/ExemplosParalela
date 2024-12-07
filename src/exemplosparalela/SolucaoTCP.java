package exemplosparalela;

import java.io.*;
import java.net.*;

public class SolucaoTCP {

    private static BufferedReader in = null;
    private static PrintWriter out = null;

    public static void main(String[] args) {
        try {
            Socket client = new Socket("177.44.248.10", 5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream(), "UTF-8"));
            PrintWriter out = new PrintWriter(new OutputStreamWriter(client.getOutputStream(), "UTF-8"), true);

            long matr = 505885;
            System.out.println(in.readLine());  // E
            out.println("" + matr);              // S

            System.out.println(in.readLine());   // E
            out.println("49");                   // S

            String info = in.readLine();        // E
            System.out.println("A expressão recebida é : " + info);

            String expr = info.substring(info.indexOf(":") + 2, info.lastIndexOf(","));
            String value1 = expr.substring(expr.indexOf("*") + 2, expr.indexOf("+") - 1);
            System.out.println("Value 1: " + value1);
            String value2 = expr.substring(expr.lastIndexOf("+") + 2);
            System.out.println("Value 2: " + value2);

            long resp = matr * Long.parseLong(value1) + Long.parseLong(value2);
            System.out.println("Resposta" + resp);
            out.println("" + resp); // S

            System.out.println(in.readLine()); // E

            in.close();
            out.close();
            client.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
