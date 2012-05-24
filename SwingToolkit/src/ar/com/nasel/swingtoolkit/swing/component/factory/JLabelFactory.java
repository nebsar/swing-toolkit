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
package ar.com.nasel.swingtoolkit.swing.component.factory;

import java.awt.Component;
import javax.swing.JLabel;

/**
 *
 * @author Augusto Recordon
 * 
 * This factory class creates labels and preconfigure them according
 * to the arguments provided by the user when invoking each method.
 * 
 */
public class JLabelFactory extends SwingComponentFactory{

    
    /* ********************************************************************** */
    
    /**
     * This method creates and return a JLabel instance with the text received
     * as its content.
     * 
     * @param text
     * @return 
     */
    public static JLabel createJLabel(String text){
        JLabel label = new JLabel(text);
        return label;
    }
    
    
    /* ********************************************************************** */
    
    /**
     * 
     * This method returns a new JLabel with the borderLength that it's specified.
     * 
     * @param text
     * @param borderLength
     * @return 
     */
    public static JLabel createJLabel(String text, int borderLength){
        JLabel label = JLabelFactory.createJLabel(text);
        label.setBorder(SwingComponentFactory.createBorder(borderLength));
        return label;
    }
    
    /* ********************************************************************** */
    
    public static JLabel createJLabel(String text, Component component){
        JLabel jlabel = new JLabel(text);
        jlabel.setLabelFor(component);
        return jlabel;
    }
    
    /* ********************************************************************** */
}
