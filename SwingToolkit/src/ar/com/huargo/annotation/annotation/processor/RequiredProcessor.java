/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.annotation.annotation.processor;

import ar.com.huargo.annotation.exception.EmptyInputForRequiredFieldException;
import ar.com.huargo.annotation.exception.ValidationFailedException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author augusto
 */
public class RequiredProcessor extends AnnotationProcessorImpl {

    @Override
    public void processField(Field f, Object o) throws ValidationFailedException {
        try {
            if(f.get(o) == null){
                throw new EmptyInputForRequiredFieldException();
            }
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(RequiredProcessor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(RequiredProcessor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    
    
}
