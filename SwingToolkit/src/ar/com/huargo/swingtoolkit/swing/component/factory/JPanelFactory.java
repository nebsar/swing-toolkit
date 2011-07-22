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

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 * @author Augusto Recordon
 * 
 * This class is a factory for creating custom JPanels.
 */
public class JPanelFactory {

    /* ********************************************************************** */
    
    /**
     * This is a default constructor. It creates a JPanel with
     * a BorderLayout as its LayoutManager.
     * 
     * @return 
     */
    public static JPanel createJPanel(){
        return JPanelFactory.createJPanel(new BorderLayout());
    }
    
    /* ********************************************************************** */
    
    /**
     * This method creates a JPanel with the specified
     * layout manager.
     * 
     * @param layoutManager
     * @return 
     */
    public static JPanel createJPanel(LayoutManager layoutManager){
        return new JPanel(layoutManager);
    }
    
    /* ********************************************************************** */
}
