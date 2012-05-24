/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.nasel.swingtoolkit.swing.component.factory;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;

/**
 *
 * @author Augusto Recordon
 * 
 * This class is a factory for creating new JButton components.
 * 
 * @version 1.0
 */
public class JButtonFactory {
    
    /* ********************************************************************** */
    
    /**
     * 
     * This method creates a new JButton and configures the corresponding 
     * GridBagLayout given as argument, but the button is not added to its
     * parent component, though.
     * 
     * @param label
     * @param gbl
     * @param gbc
     * @return 
     */
    public static JButton createJButton(String label, GridBagLayout gbl, GridBagConstraints gbc){
        JButton button = JButtonFactory.createJButton(label);
        gbl.setConstraints(button, gbc);
        return button;
    }
    
    /* ********************************************************************** */
    
    /**
     * 
     * This method creates a simple button with the given string as its text.
     * 
     * @param label
     * @return 
     */
    public static JButton createJButton(String label){
        return new JButton(label);
    }
    
    /* ********************************************************************** */
    
    /**
     * This method creates a new JButton with the given size. It sets the
     * image located in the relative path, using the baseClass path as a base
     * path from where to concatenate the relative path. It also sets a tooltip
     * as an emergent message when the mouse is over the component.
     * 
     * @param width
     * @param height
     * @param baseClass
     * @param iconPath
     * @param tooltip
     * @return 
     */
    public static JButton createJButton(int width, int height,Class baseClass,String iconPath, String tooltip){
        JButton result = new JButton();
        result.setPreferredSize(new Dimension(height,width));
        result.setIcon(IconImageFactory.createImageIcon(baseClass, iconPath));
        result.setToolTipText(tooltip);
        return result;
    }
    
    /* ********************************************************************** */
}
