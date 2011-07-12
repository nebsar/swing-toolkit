/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.test.annotation;

import ar.com.huargo.annotation.annotation.processor.RequiredAnnotationProcessor;

/**
 *
 * @author augusto
 */
public class TestRequiredAnnotation {


    public static void main(String[] args) {

        AnnotatedEntity ae = new AnnotatedEntity();
        RequiredAnnotationProcessor rap = new RequiredAnnotationProcessor();
        String[] fieldsException = rap.process(ae);
        if (fieldsException != null) {
            for (String fname : fieldsException) {
                System.out.println(fname);
            }
        }
    }
}
