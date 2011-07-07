/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit;

import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Augusto Recordon
 * 
 * 07-06-2011
 * 
 * @version 0.1
 */
public abstract class GenericWindow {
   
    protected JPanel containerPanel;
    
    protected JFrame jFrame;
    
    protected String title;
    
    protected static final int DEFAULT_BORDER = 20;
    
    protected GenericWindow(){
        this("");
    }
    
    protected GenericWindow(String title){
        super();
        this.title = title;
        this.init();
        
    }
    
    private void init(){
        this.createFrame();
        this.createContainerPanel();
        this.postConfiguration();
    }
    
    
    private void createFrame(){
        this.jFrame = new JFrame(this.title);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void createContainerPanel(){
        this.containerPanel = SwingComponentFactory.createJPanel();
        this.containerPanel.setBorder(this.getBorder());
        this.initializeContainerPanel();
    }
    
    
    private void postConfiguration(){
        this.jFrame.getContentPane().add(this.containerPanel);
        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }
    
    protected Border getBorder(){
        return BorderFactory.createEmptyBorder(
                                                DEFAULT_BORDER,
                                                DEFAULT_BORDER,
                                                DEFAULT_BORDER,
                                                DEFAULT_BORDER
                                              );
    }
    
    
    protected abstract void initializeContainerPanel();
    
    
}
