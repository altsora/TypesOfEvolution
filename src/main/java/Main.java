import java.math.BigInteger;

public class Main {

    private static String text = "Hello my dear friend"
            .toLowerCase();

    private static char[] alphabet = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', ' '
    };

    public static void main(String[] args) {
        new Thread(new CumulativeSelection(text, alphabet, "Накапливающий отбор")).start();
    }

    public synchronized static void showResult(long resultTime, String text, StringBuilder sb, BigInteger count, String name) {
        System.out.println("Отработал: " + name);
        System.out.println("\tЧисло попыток: " + count);
        System.out.println("\tВремя выполнения: " + resultTime + " ns");
        System.out.println("\tИсходный текст: |" + text + "|");
        System.out.println("\tРезультат:      |" + sb.toString() + "|");
    }
}
