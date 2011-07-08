/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.factory;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import javax.swing.JButton;

/**
 *
 * @author augusto
 */
public class JButtonFactory {
    
    public static JButton createJButton(String label, GridBagLayout gbl, GridBagConstraints gbc){
        JButton button = JButtonFactory.createJButton(label);
        gbl.setConstraints(button, gbc);
        return button;
    }
    
    public static JButton createJButton(String label){
        return new JButton(label);
    }
    
}
