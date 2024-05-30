import java.awt.*;
import javax.swing.*;

/**
 * The `Frame` class creates a JFrame window with a SortingPanel object and sets its properties.
 */
public class Frame extends JFrame {
    private static final long serialVersionUID = 1L;
    private SortingPanel mypanel = new SortingPanel();

    /**
     * The function returns a SortingPanel object.
     * 
     * @return A SortingPanel object named "mypanel" is being returned.
     */
    public SortingPanel getPanel() {
        return this.mypanel;
    }

   // This is the constructor method for the `Frame` class. It sets the title of the frame to "Sorting
   // Visualizer", sets the visibility of the frame to true, sets the preferred size of the content
   // pane to 1250x650 pixels, adds the `mypanel` instance of `SortingPanel` to the content pane,
   // centers the frame on the screen, packs the components in the frame, and sets the default close
   // operation to exit the application when the frame is closed.
    public Frame() {
        this.setTitle("Sorting Visualizer");
        this.setVisible(true);
        this.getContentPane().setPreferredSize(new Dimension(1250, 650));
        this.getContentPane().add(mypanel);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
