/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pertemuan4;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Aldi Reza
 */
public class BlankArea extends JLabel{
    Dimension minSize = new Dimension(100, 50);
    
    public BlankArea(Color color){
        setBackground(color);
        setOpaque(true);
        setBorder(BorderFactory.createLineBorder(Color.black));
    }
    public Dimension getMinimumSize(){
        return minSize;
    }
    public Dimension getPreferredSize(){
        return minSize;
    }
}
