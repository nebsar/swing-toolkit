/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.swing.component.factory;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
    
    public static JButton createJButton(int width, int height,Class baseClass,String iconPath, String tooltip){
        JButton result = new JButton();
        result.setPreferredSize(new Dimension(height,width));
        result.setIcon(IconImageFactory.createImageIcon(baseClass, iconPath));
        result.setToolTipText(tooltip);
        return result;
    }
    
}
