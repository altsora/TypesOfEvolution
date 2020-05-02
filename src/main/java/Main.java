import java.math.BigInteger;

public class Main {
    // Осторожно: с добавлением каждой буквы ступенчатый отбор работает НАМНОГО дольше!
    private static String text = "hello"
            .toLowerCase();

    private static final char[] ALPHABET = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', ' '
    };

    public static void main(String[] args) {
        new CumulativeSelection("Накапливающий отбор", text, ALPHABET).start();
        new StepSelection("Ступенчатый отбор", text, ALPHABET).start();
    }

    public synchronized static void showResult(long resultTime, String text, StringBuilder sb, BigInteger count, String name) {
        System.out.println("Отработал: " + name);
        System.out.println("\tЧисло попыток: " + count);
        System.out.println("\tВремя выполнения: " + resultTime + " ms");
        System.out.println("\tИсходный текст: |" + text + "|");
        System.out.println("\tРезультат:      |" + sb.toString() + "|");
        System.out.println("=".repeat(40));
    }
}
