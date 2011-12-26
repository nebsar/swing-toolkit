/**
Copyright (C) 2011  Augusto Recordon

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */
package ar.com.huargo.swingtoolkit.swing.component.factory;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JTextField;

/**
 *
 * @author Augusto Recordon
 * 
 * This class provides a set of methods for creating and configuring
 * new JTextField instances.
 * 
 * @version 1.0 official release.
 */
public class JTextFieldFactory {
    
    
    /* ********************************************************************** */
    
    /**
     * 
     * 
     * @param dimension
     * @param color
     * @param editable
     * @return 
     */
    public static JTextField createJTextField(Dimension dimension, Color color,boolean editable){
        JTextField jTextField = new JTextField();
        jTextField.setPreferredSize(dimension);
        jTextField.setForeground(color);
        jTextField.setEditable(editable);
        return jTextField;
    }
    
    
    /* ********************************************************************** */

    /**
     * 
     * This simple method wraps a standard constructor of the JTextField class, 
     * so the user need only to rely on this toolkit for working with swing components.
     * 
     * @param columns
     * @return 
     */
    public static JTextField createJTextField(int columns){
        return new JTextField(columns);
    }
    
    
    /* ********************************************************************** */
    
    
    /* ********************************************************************** */
}
