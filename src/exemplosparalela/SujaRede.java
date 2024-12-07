package exemplosparalela;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SujaRede {

    public static void main(String[] args) {
        try {
            int porta = 8000;

            DatagramSocket socket = new DatagramSocket();// ansy codes
            InetAddress address = InetAddress.getByName("177.44.248.13");
            //socket.setBroadcast(true);

            while (true) {

                String mensagem = new String("ola tudo bem");
                byte[] buffer = mensagem.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, porta);
                socket.send(packet);

                socket.receive(packet);
                
                byte novoBuffer[] = new byte[1000];
                String mensagemRecebida = new String(novoBuffer, 0, packet.getLength());
                System.out.println("Recebido do servidor" + mensagemRecebida);

                for (int i = 0; i < mensagemRecebida.length(); i++) {
                    System.out.println((char)mensagemRecebida.charAt(i) + " " + (int)mensagemRecebida.charAt(i));
                }
                
                if(mensagemRecebida.equals("eu consegui chegar até você")){
                    System.out.println("UIPI");
                }
                
                Thread.sleep(1000);
            }

            //socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
