/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.demo.form;

import ar.com.huargo.swingtoolkit.form.GenericFormWindow;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author arecordon
 */
public class DummyInputForm extends GenericFormWindow{

    public DummyInputForm(String title) {
        super(title);
    }

    @Override
    protected void addComponents() {
        JTextField nameField = new JTextField(20);
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setLabelFor(nameField);
        
        JTextField lastnameField = new JTextField(20);
        JLabel lastnameLabel = new JLabel("Last Name");
        this.contentPanel.add(nameLabel);
        this.contentPanel.add(nameField);
        this.contentPanel.add(lastnameLabel);
        this.contentPanel.add(lastnameField);
    }

    @Override
    protected boolean validateFields() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}