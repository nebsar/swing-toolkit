/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Augusto Recordon
 */
public class GenericWindowOld {
    
    private JFrame jFrame;
    
    protected JPanel containerPanel;
    
    
    public GenericWindowOld(String title){
        this.initializeJFrame(title);
        this.initializeContainerPanel();
        JLabel label = new JLabel("Hello World");
        this.containerPanel.add(label);
        label = new JLabel("Hello World2345453454534");
        this.containerPanel.add(label);
        label = new JLabel("Hello World234242");
        this.containerPanel.add(label);
        
        this.lastConfiguration();
    }
    
    
    private void initializeJFrame(String title){
        this.jFrame = new JFrame(title);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    private void lastConfiguration(){
        this.jFrame.getContentPane().add(this.containerPanel);
        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }
    
    protected void initializeContainerPanel(){
        this.containerPanel = new JPanel();
        this.containerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        this.containerPanel.setLayout(new GridLayout(0,1));
    }
    
}
