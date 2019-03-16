package src;

import java.awt.datatransfer.DataFlavor;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import static src.Expander.*;

class ExpanderFocusListener implements FocusListener {

    private final Expander expander;

    ExpanderFocusListener(Expander expander) {
        this.expander = expander;
    }

    @Override
    public void focusGained(FocusEvent e) {
        System.out.println("ExpanderFocusListener.focusGained");

        DataFlavor currentFlavor;
        if (clipboard.isDataFlavorAvailable(DataFlavor.imageFlavor))
            currentFlavor = DataFlavor.imageFlavor;
        else
            currentFlavor = DataFlavor.selectBestTextFlavor(clipboard.getAvailableDataFlavors());

        System.out.println(currentFlavor);
        expander.processFocusGained(currentFlavor);
    }
    @Override
    public void focusLost(FocusEvent e) {
        System.out.println("ExpanderFocusListener.focusLost");
    }

}
