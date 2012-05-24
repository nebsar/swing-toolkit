/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.nasel.swingtoolkit.test.annotation;

import ar.com.nasel.annotation.annotation.Length;
import ar.com.nasel.annotation.annotation.Required;

/**
 *
 * @author augusto
 */
public class AnnotatedEntity {
    
    @Required(required=true)
    private String requiredAnnotatedField1;
    
    @Required(required=true)
    private String requiredAnnotatedField2 = "ALGO";
    
    @Required(required=false)
    private String requiredAnnotatedField3;
    
    private String notAnnotatedField;
    
    @Length(min=2,max=4)
    private String lenghtAnnotated1 = "1232";
    
    @Length(min=3,max=6)
    private String lengthAnnotated2 = "12";
}
