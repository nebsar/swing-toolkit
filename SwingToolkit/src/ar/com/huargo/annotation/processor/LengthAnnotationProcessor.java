/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.annotation.processor;

import ar.com.huargo.annotation.annotation.Length;
import ar.com.huargo.annotation.exception.InvalidLengthForFieldException;
import ar.com.huargo.annotation.exception.ValidationFailedException;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto Recordon
 */
public class LengthAnnotationProcessor extends AnnotationProcessorImpl {

    @Override
    protected void processField(Field f, Object o) throws ValidationFailedException {
        Length lengthAnnotation = f.getAnnotation(Length.class);
        if (lengthAnnotation != null) {
            String value;
            try {
                value = f.get(o).toString();

                int length = value.length();
                if (!((length >= lengthAnnotation.min()) && (length <= lengthAnnotation.max()))) {
                    throw new InvalidLengthForFieldException();
                }
            } catch (IllegalArgumentException ex) {
                Logger.getLogger(LengthAnnotationProcessor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                Logger.getLogger(LengthAnnotationProcessor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
