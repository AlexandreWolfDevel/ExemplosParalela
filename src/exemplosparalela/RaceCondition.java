package exemplosparalela;

public class RaceCondition extends Thread {

    private static int valor = 4;

    public RaceCondition() {

    }

    @Override
    public void run() {
        valor = valor + 1;
    }

    public static void main(String[] args) {
        new RaceCondition().start();
        new RaceCondition().start();
        new RaceCondition().start();
        System.out.println(valor);
    }
}
