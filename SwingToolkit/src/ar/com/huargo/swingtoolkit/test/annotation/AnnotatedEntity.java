/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.test.annotation;

import ar.com.huargo.annotation.annotation.Length;
import ar.com.huargo.annotation.annotation.Required;

/**
 *
 * @author augusto
 */
public class AnnotatedEntity {
    
    @Required(required=true)
    private String annotatedField;
    
    private String notAnnotatedField;
    
    @Length(min=2,max=4)
    private String lenghtAnnotated1 = "123";
    
    @Length(min=3,max=6)
    private String lengthAnnotated2 = "12";
}
