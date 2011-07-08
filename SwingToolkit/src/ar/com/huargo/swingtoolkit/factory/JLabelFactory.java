/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.factory;

import javax.swing.JLabel;

/**
 *
 * @author augusto
 */
public class JLabelFactory extends SwingComponentFactory{

    public static JLabel createJLabel(String text){
        JLabel label = new JLabel(text);
        return label;
    }
    
    public static JLabel createJLabel(String text, int borderLength){
        JLabel label = JLabelFactory.createJLabel(text);
        label.setBorder(SwingComponentFactory.createBorder(borderLength));
        return label;
    }
    
}
