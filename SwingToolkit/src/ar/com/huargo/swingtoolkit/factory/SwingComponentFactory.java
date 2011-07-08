/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.factory;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.border.Border;

/**
 *
 * @author augusto
 */
public class SwingComponentFactory  {
    
    protected static final int DEFAULT_BORDER_LENGTH = 1;
    
    protected static final int DEFAULT_SEPARATOR = 10;
    
    public static Border createDefaultBorder(){
        return SwingComponentFactory.createBorder(SwingComponentFactory.DEFAULT_BORDER_LENGTH);
    }
    
    public static Border createBorder(int length){
        return BorderFactory.createEmptyBorder(length,length,length,length);
    }
    
    public static Component createHorizontalSeparator(){
        return SwingComponentFactory.createHorizonalSeparator(SwingComponentFactory.DEFAULT_SEPARATOR);
    }
    
    public static Component createHorizonalSeparator(int width){
        return SwingComponentFactory.createSeparator(width, 0);
    }

    public static Component createSeparator(int width, int height){
        return Box.createRigidArea(new Dimension(width,height));
    }
    
    public static Component createVerticalSeparator(int height){
        return SwingComponentFactory.createSeparator(0, height);
    }
    
    public static Component createVerticalSeparator(){
        return SwingComponentFactory.createVerticalSeparator(SwingComponentFactory.DEFAULT_SEPARATOR);
    }
    
    
}
