import java.io.OutputStream;
import java.io.PrintStream;
import javax.swing.JTextArea;

/**
 * Die Klasse ConsoleTextArea wird genützt, um die Konsolen-Statements an die Status-Updates im GUI zu senden, ohne dass man es aktualisieren muss.
 */

public class ConsoleTextArea extends JTextArea {
    public ConsoleTextArea() {
        setEditable(false); // Make the text area non-editable
    }

    public PrintStream getPrintStream() {
        return new PrintStream(new CustomOutputStream(this), true);
    }

    private static class CustomOutputStream extends OutputStream {
        private JTextArea textArea;

        public CustomOutputStream(JTextArea textArea) {
            this.textArea = textArea;
        }

        @Override
        public void write(int b) {
            textArea.append(String.valueOf((char) b));
            textArea.setCaretPosition(textArea.getDocument().getLength());
        }
    }
}
