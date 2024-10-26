/* =========================================================================
   Author_______: Alexandre Stürmer Wolf
   Date_________: 10/25/2024
   Utility______: Examples - source code - Parallel Programming
   ========================================================================= */
package exemplosparalela;

public class ExemplosParalela extends Thread{

    //public static char validos[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'x', 'y', 'w', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    
    public ExemplosParalela() {
        
    }   
    
    public void run() {
        processa();
    }
    
    public static String geraSenha() {
        String aux = "";
        for (int i = 0; i < 4; i++) {
            //aux = aux + validos[(int)(Math.random() * validos.length)];
            aux += (char)(Math.random() * 255);
            
        }
        return aux;
    }

    public static boolean testeEstranhos(String mens) {
        boolean temEstranhos = false;
        for (int i = 0; i < mens.length(); i++) {
            char s = mens.charAt(i);
            if (s > 128 || s < 32 || s == '%' || s == ':' || s == '}' || s == '{' || s == '*' || s == '#' || s == '~' || s == '+' || s == '\\' || s == '`' || s == ';' || s == '|' || s == '\'' || s == '\"') {
                temEstranhos = true;
                break;
            }
        }
        return temEstranhos;
    }

    public static void processa() {

        char vetMensagem[] = {55, 65, 21, 80, 21, 0, 67, 92, 25, 19, 17, 84, 3, 65, 7, 84, 86, 5, 12, 67, 86, 5, 6, 17, 20, 0, 17, 67, 31, 6, 2};
        String senha = "";
        int checksum = 0;

        System.out.println("Iniciando a quebra da senha");
        while (true) {
            int pos = 0;
            checksum = 0;
            senha = geraSenha();
            String mensagemDescriptografada = "";
            for (int j = 0; j < vetMensagem.length; j++) {
                mensagemDescriptografada += (char) (vetMensagem[j] ^ senha.charAt(pos));
                checksum += vetMensagem[j] ^ senha.charAt(pos);
                pos++;
                if (pos > 3) {
                    pos = 0;
                }
            }
            if (checksum == 2789 && !testeEstranhos(mensagemDescriptografada)) { // candidatos e possivel eleito
                System.out.println(mensagemDescriptografada + "  " + senha);
            }
        }
    }
    
    public static void main(String[] args) {
        for (int i = 0; i < 30; i++) {
            new ExemplosParalela().start();
        }
    }
}
