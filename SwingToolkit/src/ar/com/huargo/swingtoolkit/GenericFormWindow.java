/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit;

import ar.com.huargo.swingtoolkit.factory.SwingComponentFactory;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author augusto
 */
public abstract class GenericFormWindow extends GenericWindow{
    
    public static String CANCEL_REQUESTED="CANCEL";
    
    public static String CONFIRM_REQUESTED = "CONFIRM";
    
    protected JPanel contentPanel;
    
    protected JPanel buttonsPanel;
    
    protected JButton cancelButton;
    
    protected JButton confirmButton;
    
    protected GridBagLayout gridBagLayout;
    
    protected GridBagConstraints gridBagConstraints;

    @Override
    protected void initializeContainerPanel() {
        this.createContentPanel();
        this.createButtonsPanel();
        this.containerPanel.add(this.contentPanel,BorderLayout.NORTH);
        this.containerPanel.add(SwingComponentFactory.createVerticalSeparator());
        this.containerPanel.add(this.buttonsPanel,BorderLayout.SOUTH);
    }
    
    protected GenericFormWindow(String title){
        super(title);
    }
    
    protected void createContentPanel(){
        this.contentPanel = new JPanel();
        
        this.gridBagLayout = new GridBagLayout();
        this.gridBagConstraints = new GridBagConstraints();
        this.containerPanel.setLayout(this.gridBagLayout);
        this.gridBagConstraints.fill = GridBagConstraints.BOTH;
//        this.gridBagConstraints.weightx = 1.0;
        
        
        this.addComponents();
    }
    
    protected void createButtonsPanel(){
        this.buttonsPanel = new JPanel();
        this.buttonsPanel.setLayout(new FlowLayout());
        
        this.createConfirmButton();
        this.createCancelButton();
        
        this.buttonsPanel.add(this.confirmButton);
        this.buttonsPanel.add(SwingComponentFactory.createHorizontalSeparator());
        this.buttonsPanel.add(this.cancelButton);
        
    }
    
    protected LayoutManager getContentPanelLayout(){
        return new GridLayout(0, 1);
    }
    
    protected abstract void addComponents();
    
    
    protected void createCancelButton(){
        this.cancelButton = new JButton("Cancel");
        this.cancelButton.setActionCommand(CANCEL_REQUESTED);
        this.cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });
    } 
    
    
    protected void createConfirmButton(){
        this.confirmButton = new JButton("Confirm");
        this.confirmButton.setActionCommand("CONFIRM");
        this.confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onConfirm();
            }
        });
    }
    
    
    protected void onConfirm(){
        if(this.validateFields()){
            this.jFrame.dispose();
        }
    }
    
    protected void onCancel(){
        this.jFrame.dispose();
    }
    
    
    protected abstract boolean validateFields();
    
}
