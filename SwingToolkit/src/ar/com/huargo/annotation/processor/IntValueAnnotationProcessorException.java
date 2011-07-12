/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.annotation.processor;

import ar.com.huargo.annotation.annotation.IntValue;
import ar.com.huargo.annotation.exception.InvalidIntegerRangeException;
import ar.com.huargo.annotation.exception.ValidationFailedException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author augusto
 */
public class IntValueAnnotationProcessorException extends AnnotationProcessorImpl{

    @Override
    protected void processField(Field f, Object o) throws ValidationFailedException {
        IntValue intValueAnnotation = f.getAnnotation(IntValue.class);
        if (intValueAnnotation != null) {
            int value;
            try {
                value = Integer.parseInt(f.get(o).toString());

                if (!((value >= intValueAnnotation.min()) && (value <= intValueAnnotation.max()))) {
                    throw new InvalidIntegerRangeException();
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(LengthAnnotationProcessor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(LengthAnnotationProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
