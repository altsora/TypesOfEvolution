import java.math.BigInteger;

public class StepSelection extends Thread {
    private String text;
    private char[] alphabet;
    private BigInteger count;

    public StepSelection(String name, String text, char[] alphabet) {
        this.setName(name);
        this.text = text;
        this.alphabet = alphabet;
        this.count = BigInteger.valueOf(0);
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        StringBuilder sb;
        while (true) {
            sb = new StringBuilder();
            createLine(sb);
            count = count.add(BigInteger.valueOf(1));
            if (sb.toString().equals(text)) break;
        }
        long resultTime = System.currentTimeMillis() - start;
        Main.showResult(resultTime, text, sb, count, this.getName());
    }

    private void createLine(StringBuilder sb) {
        for (int i = 0; i < text.length(); i++) {
            int index = (int) (Math.random() * alphabet.length);
            sb.append(alphabet[index]);
        }
    }
}
