import java.math.BigInteger;

public class Main {
    private static final String TEXT_CUMULATIVE_SELECTION = "hello, my dear github. i love you. i like working with you"
            .toLowerCase();
    // Осторожно: с добавлением каждой буквы одноступенчатый отбор работает НАМНОГО дольше!
    private static final String TEXT_STEP_SELECTION = "hello"
            .toLowerCase();

    private static final char[] ALPHABET = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
            'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z', ' ', ',', '.'
    };

    public static void main(String[] args) {
        if (checkAlphabet()) return;
        new CumulativeSelection("Накапливающий отбор", TEXT_CUMULATIVE_SELECTION, ALPHABET).start();
        new OneStageSelection("Одноступенчатый отбор", TEXT_STEP_SELECTION, ALPHABET).start();
    }

    public static synchronized void showResult(long resultTime, String text, StringBuilder sb, BigInteger count, String name) {
        System.out.println("Отработал: " + name);
        System.out.println("\tЧисло попыток: " + count);
        System.out.println("\tВремя выполнения: " + resultTime + " ms");
        System.out.println("\tИсходный текст: |" + text + "|");
        System.out.println("\tРезультат:      |" + sb.toString() + "|");
        System.out.println("=".repeat(40));
    }

    private static boolean checkAlphabet() {
        for (char symbol : TEXT_CUMULATIVE_SELECTION.toCharArray()) {
            if (!String.valueOf(ALPHABET).contains(String.valueOf(symbol))) {
                System.out.println("В |" + TEXT_CUMULATIVE_SELECTION + "| содержится неизвестный символ: |" + symbol + "|");
                return true;
            }
        }
        for (char symbol : TEXT_STEP_SELECTION.toCharArray()) {
            if (!String.valueOf(ALPHABET).contains(String.valueOf(symbol))) {
                System.out.println("В |" + TEXT_STEP_SELECTION + "| содержится неизвестный символ: |" + symbol + "|");
                return true;
            }
        }
        return false;
    }
}
