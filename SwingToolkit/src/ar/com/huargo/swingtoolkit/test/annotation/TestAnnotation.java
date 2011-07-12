/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.test.annotation;

import ar.com.huargo.annotation.processor.LengthAnnotationProcessor;
import ar.com.huargo.annotation.processor.RequiredAnnotationProcessor;

/**
 *
 * @author augusto
 */
public class TestAnnotation {


    public static void main(String[] args) {

        System.out.println("--- COMENZANDO EL PROCESAMIENTO DE REQUIRED ---");
        AnnotatedEntity ae = new AnnotatedEntity();
        RequiredAnnotationProcessor rap = new RequiredAnnotationProcessor();
        String[] fieldsRequiredException = rap.process(ae);
        if (fieldsRequiredException != null) {
            for (String fname : fieldsRequiredException) {
                System.out.println(fname);
            }
        }
        System.out.println("--- FINALIZANDO EL PROCESAMIENTO DE REQUIRED ---");
        System.out.println("--- COMENZANDO EL PROCESAMIENTO DE LENGTH ---");
        LengthAnnotationProcessor lap = new LengthAnnotationProcessor();
        String[] fieldsLengthException = lap.process(ae);
        if (fieldsLengthException != null) {
            for (String fname : fieldsLengthException) {
                System.out.println(fname);
            }
        }
        System.out.println("--- FINALIZANDO EL PROCESAMIENTO DE LENGTH ---");
    }
}
