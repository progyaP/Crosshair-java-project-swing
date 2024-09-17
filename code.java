import javax.swing.*;
import java.awt.*;

public class crosshair{
    public static void main(String[] args) {
        // Create the frame (window)
        JFrame frame = new JFrame();
        frame.setUndecorated(true);  // Remove window decorations
        frame.setAlwaysOnTop(true);  // Set window to always be on top
        frame.setBackground(new Color(0, 0, 0, 0));  // Transparent background

        // Get the screen width and height
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int screenWidth = toolkit.getScreenSize().width;
        int screenHeight = toolkit.getScreenSize().height;

        // Set window size and position (centered and moved diagonally)
        frame.setSize(10, 10);
        frame.setLocation(screenWidth / 2 - 4, screenHeight / 2 - 4);

        // Create a panel to draw the dot
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.green);
                g.fillOval(0, 0, 10, 10);  // Draw a small yellow dot
            }
        };

        // Set panel properties
        panel.setOpaque(false);  // Transparent panel background
        panel.setPreferredSize(new Dimension(10, 10));

        // Add panel to the frame
        frame.add(panel);

        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }
}

