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
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * @author Augusto Recordon
 * 
 * This class is a factory for creating customized JPanels.
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
    
    
    /**
     * This method instanciates an object of the JTabbedPane and
     * set its TabLayoutPolicy to JTabbedPane.WRAP_TAB_LAYOUT.
     * 
     * @return 
     */
    public static JTabbedPane createJTabbedPane(){
        JTabbedPane aTabbedPane = new JTabbedPane();
        aTabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
        
        return aTabbedPane;
    }
    
    
    /* ********************************************************************** */
    
    /**
     * This method creates a new JPanel (using the starndard
     * method of this very class) and sets its preferredSize attribute
     * according to the parameters received.
     * 
     * @param width
     * @param height
     * @return 
     */
    public static JPanel createJPanel(int width, int height){
        JPanel aPanel = JPanelFactory.createJPanel();
        aPanel.setPreferredSize(new Dimension(width,height));
        
        return aPanel;
    }
    
    
    
    /* ********************************************************************** */
    
    /**
     * 
     * This method returns a new JPanel width the preferredSize and layoutManager
     * received as arguments.
     * 
     * @param layoutManager
     * @param width
     * @param height
     * @return 
     */
    public static JPanel createJPanel(LayoutManager layoutManager, int width, int height){
        JPanel aPanel = JPanelFactory.createJPanel(layoutManager);
        aPanel.setPreferredSize(new Dimension(width,height));
        
        return aPanel;
    }
    
    
    /* ********************************************************************** */
    
    /**
     * This method creates and returns a new instance of JPanel with the
     * preferredSize attribute setted to the values received. It also 
     * configures the panel, adding a titleBorder to it (with the title
     * specified).
     * 
     * @param width
     * @param height
     * @param title
     * @return 
     */
    public static JPanel createJPanel(int width, int height, String borderTitle){
        JPanel aPanel = JPanelFactory.createJPanel(new FlowLayout(), width, height);
        aPanel.setBorder(BorderFactory.createTitledBorder(borderTitle));
        
        return aPanel;
    }
    
    /* ********************************************************************** */
    
    /**
     * 
     * This method will return an instance of JPanel width the preferredSize,
     * layout manager specified. It also will create a titledBorder for the
     * panel and set its title according to the string literal received.
     * 
     * 
     * @param layoutManager
     * @param width
     * @param height
     * @param borderTitle
     * @return 
     */
    public static JPanel createJPanel(LayoutManager layoutManager, int width, int height, String borderTitle){
        JPanel aPanel = JPanelFactory.createJPanel(width, height, borderTitle);
        aPanel.setLayout(layoutManager);
        
        return aPanel;
    }
    
    /* ********************************************************************** */
    
    
    
    /* ********************************************************************** */
}
