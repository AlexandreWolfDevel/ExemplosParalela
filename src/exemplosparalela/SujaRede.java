package exemplosparalela;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SujaRede {

    public static void main(String[] args) {
        try {
            int porta = 8000;

            DatagramSocket socket = new DatagramSocket();
            InetAddress address = InetAddress.getByName("255.255.255.255");
            socket.setBroadcast(true);

            while (true) {
                String mensagem = "A vaca morreu";
                byte[] buffer = mensagem.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, porta);
                socket.send(packet);

                Thread.sleep(1000);
            }

            //socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
