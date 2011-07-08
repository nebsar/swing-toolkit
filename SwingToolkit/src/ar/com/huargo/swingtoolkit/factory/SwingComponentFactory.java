/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.factory;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author augusto
 */
public class SwingComponentFactory extends ar.com.huargo.swingtoolkit.SwingComponentFactory {
    
    protected static final int DEFAULT_BORDER_LENGTH = 1;
    
    protected static Border createDefaultBorder(){
        return SwingComponentFactory.createBorder(SwingComponentFactory.DEFAULT_BORDER_LENGTH);
    }
    
    protected static Border createBorder(int length){
        return BorderFactory.createEmptyBorder(length,length,length,length);
    }
    
    
}
