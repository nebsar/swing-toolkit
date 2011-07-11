/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.test.annotation;

import ar.com.huargo.annotation.annotation.Required;

/**
 *
 * @author augusto
 */
public class AnnotatedEntity {
    
    @Required(required=true)
    private String annotatedField;
    
    private String notAnnotatedField;
    
}
