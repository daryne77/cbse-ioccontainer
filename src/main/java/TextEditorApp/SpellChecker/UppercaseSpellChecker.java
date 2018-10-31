package TextEditorApp.SpellChecker;

public class UppercaseSpellChecker extends SpellChecker {
    public UppercaseSpellChecker() {}

    @Override
    public boolean evaluate(String text) {
        return text.equals(text.toUpperCase());
    }

    @Override
    public String correct(String text) {
        return text.toUpperCase();
    }
}
