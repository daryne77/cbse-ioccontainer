package TextEditorApp.SpellChecker;

public abstract class SpellChecker {
    abstract boolean evaluate(String text);
    public abstract String correct(String text);
}
