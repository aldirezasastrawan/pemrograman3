/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Aldi Reza
 */
public class MouseEventDemo extends JPanel implements MouseListener {

    BlankArea blankArea;
    JTextArea textArea;
    static final String NEWLINE = System.getProperty("line.separator");

    public static void main(String[] args) {
        /* Use an apporipate Look and Feel */
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /*Turn off metal's use of bold fonts*/
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        //schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event dispatch thread.
     */
    private static void createAndShowGUI() {
//create and set up the window.
        JFrame frame = new JFrame("MouseEventDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//create and set up the content pane.
        JComponent newContentPane = new MouseEventDemo();
        newContentPane.setOpaque(true); //content pane must be opaque.
        frame.setContentPane(newContentPane);

//Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public MouseEventDemo() {
        super(new GridLayout(0, 1));
        blankArea = new BlankArea(Color.YELLOW);
        add(blankArea);
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(200,75));
        add(scrollPane);
       
        //Register for Mouse event on blankArea and the pannel.
        blankArea.addMouseListener(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(450,450));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
    
    void eventOutput(String eventDescription, MouseEvent e){
        textArea.append(eventDescription + "detected on" + e.getComponent().getClass().getName() + "." + NEWLINE);
        textArea.setCaretPosition(textArea.getDocument().getLength());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        eventOutput("Mouse clicked ( # of clicks: " + e.getClickCount() + ")", e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        eventOutput("Mouse pressed (# of clicks: " + e.getClickCount() + ")",e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        eventOutput("Mouse relased (# of clicks: " + e.getClickCount() + ")", e);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        eventOutput("Mouse entered", e);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        eventOutput("Mouse exited ( # of clicks:" + e.getClickCount() + ")", e);
    }

}
