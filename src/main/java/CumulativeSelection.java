import java.math.BigInteger;

public class CumulativeSelection extends Thread {
    private String text;
    private char[] alphabet;
    private BigInteger count;

    public CumulativeSelection(String text, char[] alphabet, String name) {
        this.setName(name);
        this.text = text;
        this.alphabet = alphabet;
        this.count = BigInteger.valueOf(0);
    }

    @Override
    public void run() {
//        long start = System.currentTimeMillis();
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        createLine(sb);
        while (true) {
            count = count.add(BigInteger.valueOf(1));
            if (sb.toString().equals(text)) {
                break;
            }
            checkLine(sb);
            changeLine(sb);
        }
//        long resultTime = System.currentTimeMillis() - start;
        long resultTime = System.nanoTime() - start;
        Main.showResult(resultTime, text, sb, count, this.getName());
    }

    private void createLine(StringBuilder sb) {
        for (int i = 0; i < text.length(); i++) {
            int index = (int) (Math.random() * alphabet.length);
            sb.append(alphabet[index]);
        }
    }

    private void checkLine(StringBuilder sb) {
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != sb.charAt(i)) {
                sb.replace(i, i + 1, "*");
            }
        }
    }

    private void changeLine(StringBuilder sb) {
        for (int i = 0; i < text.length(); i++) {
            if (sb.charAt(i) == '*') {
                int index = (int) (Math.random() * alphabet.length);
                sb.replace(i, i + 1, String.valueOf(alphabet[index]));
                //break;
            }
        }
    }
}
