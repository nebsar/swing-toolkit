/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Rectangle;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;



/**
 * @author Augusto Recordon	- CeSPI-UNLP
 * 
 * Esta clase implementa un conjunto de métodos que permiten crear
 * diversos tipos de componentes Swing.
 *
 */
public class SwingComponentFactory {
	
	
	/* ********************************************************************************************************************* */
	
	/**
	 * Este método crea un nuevo label, con texto y bounds (opcionales).
	 * @param text
	 * @param bounds
	 * @return
	 */
	public static JLabel createJLabel(String text, Rectangle bounds){
		JLabel result = new JLabel(text);
		result.setBounds(bounds);
		return result;
	}
        
        
	
	/* ********************************************************************************************************************* */

	/**
	 * Este método crea un desktop pane con la configuración básica.
	 */
	public static JDesktopPane createJDesktopPane(Color color, boolean visible){
		JDesktopPane result = new JDesktopPane();
		result.setLayout(new BorderLayout());
		result.setForeground(color);
		result.setVisible(visible);
		return result;
	}
	
	/* ********************************************************************************************************************* */
	
	/**
	 * Este método crea un JPanel con un determinado JDesktopPane y un layout.
	 */
	public static JPanel createJPanel(JDesktopPane jDesktopPane, String layout){
		JPanel result = new JPanel() ;
		result.setLayout(new BorderLayout());
		result.add(jDesktopPane, layout);
		return result;
	}

	/* ********************************************************************************************************************* */
	
	/**
	 * Se crea un JPanel con un BorderLayout por defecto.
	 */
	public static JPanel createJPanel(){
		return SwingComponentFactory.createJPanel(new BorderLayout());
	}
	
	/* ********************************************************************************************************************* */
	
	/**
	 * Se crea una JPanel con un determinado LayoutManager, como FlowLayout.
	 */
	public static JPanel createJPanel(LayoutManager layoutManager){
		return new JPanel(layoutManager);
	}
	
	/* ********************************************************************************************************************* */
	
	public static Component createRigidArea(int width, int height){
		return Box.createRigidArea(new Dimension(width,height));
		
	}
	
	/* ********************************************************************************************************************* */
	
	public static Component createRigidAreaDefault(){
		return SwingComponentFactory.createRigidArea(10, 0);
	}
	
	/* ********************************************************************************************************************* */
	
	public static JTextField createTextField(int columns){
		JTextField result = new JTextField();
		result.setColumns(columns);
		result.setMaximumSize(new Dimension(200,10));
		return result;
	}
	
	/* ********************************************************************************************************************* */
	
	public static JTextField createTextField(Dimension dimension, Color foregroundColor){
		JTextField result = new JTextField();
		result.setPreferredSize(dimension);
		result.setForeground(foregroundColor);
		return result;
	}
	
	/* ********************************************************************************************************************* */
	
	public static JButton createJButton(int width,int height, String iconName){
		JButton result = new JButton();
		result.setPreferredSize(new Dimension(width,height));
//		result.setIcon(Env.getImageIcon(iconName));
		return result;
	}
	
	/* ********************************************************************************************************************* */
	
	public static JButton createJButton(String iconName){
		JButton result = new JButton();
//		result.setIcon(Env.getImageIcon(iconName));
		return result;
	}
	
	/* ********************************************************************************************************************* */
	
	public static JScrollPane createJScrollPane(JTable jTable, int...bounds){
		JScrollPane result = new JScrollPane();
		if((bounds != null) && (bounds.length == 4)){
			result.setBounds(SwingComponentFactory.createRectangle(bounds));
		}
		if(jTable != null){
			result.setViewportView(jTable);
		}
		return result;
	}
	
	/* ********************************************************************************************************************* */
	
	public static Rectangle createRectangle(int[]bounds){
		return new Rectangle(bounds[0],bounds[1],bounds[2],bounds[3]);
	}
	
	/* ********************************************************************************************************************* */
	
//	@SuppressWarnings("rawtypes")
//	public static JTable createJTable(Class modelClass, Map<Integer, String[]> modelInfo){
//		JTableModel jtModel = new JTableModel(modelClass, modelInfo);
//		JTable result = new JTable(jtModel.createTableModel());
//		result.setRowHeight(25);
//		result.setAutoCreateColumnsFromModel(true);
//		result.setShowVerticalLines(false);
//		result.setShowGrid(true);	
//			
//		return result;
//	}

	/* ********************************************************************************************************************* */
	

	public static JPanel createContentPane(JDesktopPane jDesktopPane, String layout){
		JPanel result = SwingComponentFactory.createJPanel();
		result.add(jDesktopPane,layout);
		return result;
	}
	
	/* ********************************************************************************************************************* */
}
