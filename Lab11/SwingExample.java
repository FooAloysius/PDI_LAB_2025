import java.awt.event.*;
import javax.swing.*;

class GuiWindow implements ActionListener {
    JLabel labelWorld;
    public GuiWindow() {
        // create the GUI window and set its properties
        JFrame windowFrame = new JFrame("My GUI Window");
        windowFrame.setSize(330,330);
        windowFrame.setLayout(null);
        windowFrame.setVisible(true);

        // Add the JLabel to the GUI
        labelWorld = new JLabel("Hello, World!");
        labelWorld.setSize(150,50);
        windowFrame.add(labelWorld);

        // add the Button to the GUI
        JButton theButton = new JButton("Click Me!");
        theButton.setSize(150,50);
        theButton.setLocation(50,100);
        theButton.addActionListener(this);
        windowFrame.add(theButton);
    }

    @Override
    public void actionPerformed(ActionEvent click) {
        if (labelWorld.getText().equals("Hello, World!")) {
            labelWorld.setText("Goodbye, world!");
        } else {
            labelWorld.setText("Hello, World!");
        }
    }
}

public class SwingExample {
    JLabel labelWorld;
    public static void main(String[] args) {
        new GuiWindow();
        
    }
}