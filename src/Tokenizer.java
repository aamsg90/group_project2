import java.util.HashMap;
import java.util.Map;
import java.nio.charset.StandardCharsets;

public class Tokenizer {

    private final String source;
    private final StringBuilder tokenizedProgram;
    static Map<String, Byte> keywords = new HashMap<>();

    public Tokenizer(String source) {
        this.source = source;
        this.tokenizedProgram = new StringBuilder();
        populateKeywords();
    }

    public byte[] scanTokens() {
        String[] lines = source.split("\\r?\\n");
        for (String line : lines) {
            tokenizeLine(line);
        }
        return tokenizedProgram.toString().getBytes(StandardCharsets.UTF_8);
    }

    private void tokenizeLine(String line) {
        String[] tokens = line.split(" ");
        for (String token : tokens) {
            if (keywords.containsKey(token)) {
                tokenizedProgram.append(keywords.get(token));
            } else {
                tokenizedProgram.append(token);
            }
            tokenizedProgram.append(" ");
        }
        tokenizedProgram.append("\n");
    }

    private static void populateKeywords() {
        keywords.put("end", (byte) 0x80);
        keywords.put("for", (byte) 0x81);
        keywords.put("next", (byte) 0x82);
        // Add more keywords here
    }
}
