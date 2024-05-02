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
        keywords.put("data",(byte)0x83);
        keywords.put("input#",(byte)0x84);
        keywords.put("input",(byte)0x85);
        keywords.put("dim",(byte)0x86);
        keywords.put("read",(byte)0x87);
        keywords.put("let",(byte)0x88);
        keywords.put("goto",(byte)0x89);
        keywords.put("run",(byte)0x8a);
        keywords.put("if",(byte)0x8b);
        keywords.put("restore",(byte)0x8c);
        keywords.put("gosub",(byte)0x8d);
        keywords.put("return",(byte)0x8e);
        keywords.put("rem",(byte)0x8f);
        keywords.put("stop",(byte)0x90);
        keywords.put("on",(byte)0x91);
        keywords.put("wait",(byte)0x92);
        keywords.put("load",(byte)0x93);
        keywords.put("save",(byte)0x94);
        keywords.put("verify",(byte)0x95);
        keywords.put("def",(byte)0x96);
        keywords.put("poke",(byte)0x97);
        keywords.put("print#",(byte)0x98);
        keywords.put("print",(byte)0x99);
        keywords.put("cont",(byte)0x9a);
        keywords.put("list",(byte)0x9b);
        keywords.put("clr",(byte)0x9c);
        keywords.put("cmd",(byte)0x9d);
        keywords.put("sys",(byte)0x9e);
        keywords.put("open",(byte)0x9f);
        keywords.put("close",(byte)0xa0);
        keywords.put("get",(byte)0xa1);
        keywords.put("new",(byte)0xa2);
        keywords.put("tab(",(byte)0xa3);
        keywords.put("to",(byte)0xa4);
        keywords.put("fn",(byte)0xa5);
        keywords.put("spc(",(byte)0xa6);
        keywords.put("then",(byte)0xa7);
        keywords.put("not",(byte)0xa8);
        keywords.put("step",(byte)0xa9);
        /*
        keywords.put("+",(byte)0xaa);
        keywords.put("-",(byte)0xab);
        keywords.put("*",(byte)0xac);
        keywords.put("/",(byte)0xad);
        keywords.put("↑",(byte)0xae);
        */
        keywords.put("and",(byte)0xaf);
        keywords.put("or",(byte)0xb0);
        /*
        keywords.put(">",(byte)0xb1);
        keywords.put("=",(byte)0xb2);
        keywords.put("<",(byte)0xb3);
        */
        keywords.put("sgn",(byte)0xb4);
        keywords.put("int",(byte)0xb5);
        keywords.put("abs",(byte)0xb6);
        keywords.put("usr",(byte)0xb7);
        keywords.put("fre",(byte)0xb7);
        keywords.put("pos",(byte)0xb9);
        keywords.put("sqr",(byte)0xba);
        keywords.put("rnd",(byte)0xbb);
        keywords.put("log",(byte)0xbc);
        keywords.put("exp",(byte)0xbd);
        keywords.put("cos",(byte)0xbe);
        keywords.put("sin",(byte)0xbf);
        keywords.put("tan",(byte)0xc0);
        keywords.put("atn",(byte)0xc1);
        keywords.put("peek",(byte)0xc2);
        keywords.put("len",(byte)0xc3);
        keywords.put("str$",(byte)0xc4);
        keywords.put("val",(byte)0xc5);
        keywords.put("asc",(byte)0xc6);
        keywords.put("chr$",(byte)0xc7);
        keywords.put("left$",(byte)0xc8);
        keywords.put("right$",(byte)0xc9);
        keywords.put("mid$",(byte)0xca);
        keywords.put("go",(byte)0xcb);

           }

}


