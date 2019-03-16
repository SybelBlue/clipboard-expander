package src;

import javax.swing.*;

public class DataPanel<T> extends JPanel {

    private T data;

    public DataPanel(T data) {
        this.data = data;

        setSize(Expander.WIDTH, 300);
    }
}
