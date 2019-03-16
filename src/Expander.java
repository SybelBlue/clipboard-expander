package src;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;
import java.io.Reader;

public class Expander {

    static final Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    static final int WIDTH = 300, HEIGHT = 600;

    private final JFrame frame;
    private final Container contentPane;

    public Expander() {
        frame = new JFrame("Expander");
        frame.setSize(new Dimension(WIDTH, HEIGHT));
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.addFocusListener(new ExpanderFocusListener(this));

        contentPane = frame.getContentPane();

        frame.requestFocus();
    }

    public void processFocusGained(DataFlavor flavor) {
        try {
            if (flavor.isFlavorTextType()) {
                Transferable data = clipboard.getContents(null);
                if (data == null) return;

                Reader reader = flavor.getReaderForText(data);

            }
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Expander();
    }
}
