package TextEditorApp.SpellChecker;

public class PrefixSpellChecker extends SpellChecker {
    private String prefix;

    public PrefixSpellChecker(String prefix) {
        this.prefix = prefix;
    }

    @Override
    boolean evaluate(String text) {
        return text.startsWith(prefix);
    }

    @Override
    public String correct(String text) {
        if (!evaluate(text)) {
            System.out.println("text corrected!");
            return prefix + "-" + text.toLowerCase();
        } else {
            return text;
        }
    }
}
