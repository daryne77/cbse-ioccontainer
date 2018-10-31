package TextEditorApp;

import IOCFramework.IOCContainer;
import IOCFramework.IOCContainerFactory;
import TextEditorApp.TextEditor.TextEditor;

public class TextEditorApp {
    public static void main(String[] args) {
        IOCContainer container = IOCContainerFactory.configureIOCContainer("text_editor_app_config.json");

        TextEditor textEditor = (TextEditor) container.getInstance(TextEditor.class);
        textEditor.displayCorrectedText("abcdef");
    }
}
