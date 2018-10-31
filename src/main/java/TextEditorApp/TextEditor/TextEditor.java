package TextEditorApp.TextEditor;

import TextEditorApp.SpellChecker.SpellChecker;

public class TextEditor {
    private final SpellChecker spellChecker;

    public TextEditor(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void displayCorrectedText(String text) {
        System.out.println(this.spellChecker.correct(text));
    }
}
