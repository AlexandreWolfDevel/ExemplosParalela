package exemplosparalela;

public class AuxTest {

        public static byte[] intToBytes(int i) {
        /*
            00000000 00000000 00000000 00000000
            00000004 00000003 00000002 00000001
               d1       d2       d3       d4
            d1 * 255 * 255 * 255 + d2 * 255 * 255 + d3 * 255 + d4 = i
            
            00000000 00000000 00000000 00000004
            00000000 00000000 00000004 00000003
            00000000 00000004 00000003 00000002
            00000004 00000003 00000002 00000001
            
        */    
        byte[] bytes = new byte[4];
        bytes[0] = (byte) (i >> 24);
        bytes[1] = (byte) (i >> 16);
        bytes[2] = (byte) (i >> 8);
        bytes[3] = (byte) (i);
        return bytes;
    }


    public static int bytesToInt(byte[] b) {
        return ((b[0] & 0xFF) << 24) | ((b[1] & 0xFF) << 16) | ((b[2] & 0xFF) << 8) | (b[3] & 0xFF);
    }

    public static void main(String[] args) {

        int pixel = 4040400;
        byte bytes[] = intToBytes(pixel);
        int out = bytesToInt(bytes);
        System.out.println(out);

    }

}
