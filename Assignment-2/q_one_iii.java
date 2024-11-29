import javax.swing.*;
import java.awt.event.*;

public class q_one_iii {
    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Anonymous Inner Class Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit application on close

        // Create a button
        JButton button = new JButton("Click Me");

        // Add an action listener using an anonymous inner class
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button Clicked!");
            }
        });

        // Add the button to the frame
        frame.add(button);

        // Set the layout and frame size
        frame.setLayout(null); // Using null layout
        button.setBounds(50, 50, 100, 40); // Position the button
        frame.setSize(200, 200);

        // Make the frame visible
        frame.setVisible(true);
    }
}
