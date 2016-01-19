/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import javax.accessibility.AccessibleRole;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Aldi Reza
 */
public class ActionEventDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Button Sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JButton button1 = new JButton("Select Me");
        final JButton button2 = new JButton("No Select Me");
        final Random random = new Random();

        ActionListener actionListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JButton button = (JButton) actionEvent.getSource();
                int red = random.nextInt(255);
                int green = random.nextInt(255);
                int blue = random.nextInt(255);
                button.setBackground(new Color(red, green, blue));
            }

        };

        PropertyChangeListener propertyChangeListener = new PropertyChangeListener() {

            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                String property = propertyChangeEvent.getPropertyName();
                if ("background".equals(property)) {
                    button2.setBackground((Color) propertyChangeEvent.getNewValue());
                }
            }
        };

        button1.addActionListener(actionListener);
        button1.addPropertyChangeListener(propertyChangeListener);
        button2.addActionListener(actionListener);

        frame.add(button1, BorderLayout.NORTH);
        frame.add(button2, BorderLayout.SOUTH);
        frame.setSize(300, 100);
        frame.setVisible(true);
    }

}
