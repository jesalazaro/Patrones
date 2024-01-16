import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public abstract class UIBuilder {
    protected JPanel searchUI;

    public abstract void addUIControls();

    public abstract double[] getValues();

    public JPanel getSearchUI() {
        return searchUI;
    }
}

