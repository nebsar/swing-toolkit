/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.demo;

import ar.com.huargo.swingtoolkit.GenericFormWindow;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected boolean validateFields() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
