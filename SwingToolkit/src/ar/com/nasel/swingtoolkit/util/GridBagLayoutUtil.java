/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.nasel.swingtoolkit.util;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *
 * @author arecordon
 */
public class GridBagLayoutUtil {
    
    public static void add(Component component,GridBagLayout gridBagLayout, GridBagConstraints gridBagConstraints){
        gridBagLayout.setConstraints(component, gridBagConstraints);
    }
    
}
