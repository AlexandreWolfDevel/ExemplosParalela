package exemplosparalela;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class CheiraRede {

    public static void main(String[] args) {

        try {
            int porta = 8000;

            byte[] buffer = new byte[10024];

            DatagramSocket socket = new DatagramSocket(porta);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                socket.receive(packet);

                InetAddress client = packet.getAddress();
                int clientPort = packet.getPort();

                String mensagemRecebida = new String(buffer, 0, packet.getLength());

                System.out.println("Recebido " + mensagemRecebida + " do cliente " + client);

                String resposta = "eu consegui chegar até você";
                byte byteResposta[] = resposta.getBytes();
                
               
                DatagramPacket packetNovo = new DatagramPacket(byteResposta, byteResposta.length, packet.getAddress(), packet.getPort());
                socket.send(packetNovo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
