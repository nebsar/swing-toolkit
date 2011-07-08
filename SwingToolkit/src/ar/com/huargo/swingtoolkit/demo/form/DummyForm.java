/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.demo.form;

import ar.com.huargo.swingtoolkit.form.GenericFormWindow;
import ar.com.huargo.swingtoolkit.factory.JLabelFactory;

/**
 *
 * @author augusto
 */
public class DummyForm extends GenericFormWindow{

    public DummyForm(String title){
        super(title);
    }
    
    
    @Override
    protected void addComponents() {
        this.contentPanel.add(JLabelFactory.createJLabel("234", 0));
        this.contentPanel.add(JLabelFactory.createJLabel("234", 0));
        this.contentPanel.add(JLabelFactory.createJLabel("234", 1));
        this.contentPanel.add(JLabelFactory.createJLabel("234", 1));
    }

    @Override
    protected boolean validateFields() {
        return true;
    }
    
}
