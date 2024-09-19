import javax.swing.*;
import java.awt.*;

public class crosshair {
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

        // Outer circle dimensions and gap
        int outerCircleDiameter = 10;  // You can tweak this value to increase or decrease the size
        int gap = 5;  // Adjust this for space between the inner dot and outer circle

        // Inner dot diameter
        int innerDotDiameter = 5;  // Inner dot size (depends on the gap and outer circle)

        // Set window size based on the outer circle's diameter
        frame.setSize(outerCircleDiameter, outerCircleDiameter);
        frame.setLocation(screenWidth / 2 - outerCircleDiameter / 2, screenHeight / 2 - outerCircleDiameter / 2);

        // Create a panel to draw the dot and circle
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                // Set custom color for the dot
                Color dotColor = Color.decode("#00FF00"); // Green color for the inner dot
                g.setColor(dotColor);

                // Calculate the position to center the inner dot
                int innerDotX = (outerCircleDiameter - innerDotDiameter) / 2;
                int innerDotY = (outerCircleDiameter - innerDotDiameter) / 2;

                // Draw the inner dot
                g.fillOval(innerDotX, innerDotY, innerDotDiameter, innerDotDiameter);

                // Set color for the outer circle
                Color circleColor = Color.decode("#FF0000"); // Red color for the outer circle
                g.setColor(circleColor);

                // Draw the outer circle
                g.drawOval(0, 0, outerCircleDiameter - 1, outerCircleDiameter - 1);  // -1 to keep the circle within bounds
            }
        };

        // Set panel properties
        panel.setOpaque(false);  // Transparent panel background
        panel.setPreferredSize(new Dimension(outerCircleDiameter, outerCircleDiameter));

        // Add panel to the frame
        frame.add(panel);

        // Display the frame
        frame.pack();
        frame.setVisible(true);
    }
}
