/**
Copyright (C) 2011  Augusto Recordon

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

 */
package ar.com.nasel.swingtoolkit.test.annotation;

import ar.com.nasel.annotation.processor.LengthAnnotationProcessor;
import ar.com.nasel.annotation.processor.RequiredAnnotationProcessor;

/**
 *
 * @author Augusto Recordon
 */
public class TestAnnotation {


    public static void main(String[] args) {

        System.out.println("--- Starting REQUIRED annotation process ---");
        AnnotatedEntity ae = new AnnotatedEntity();
        RequiredAnnotationProcessor rap = new RequiredAnnotationProcessor();
        String[] fieldsRequiredException = rap.process(ae);
        if (fieldsRequiredException != null) {
            for (String fname : fieldsRequiredException) {
                System.out.println(fname);
            }
        }
        System.out.println("--- REQUIRED annotation process finished ---");
        
        System.out.println("--- Starting LENGTH annotation process---");
        LengthAnnotationProcessor lap = new LengthAnnotationProcessor();
        String[] fieldsLengthException = lap.process(ae);
        if (fieldsLengthException != null) {
            for (String fname : fieldsLengthException) {
                System.out.println(fname);
            }
        }
        System.out.println("--- LENGTH annotation process finished ---");
    }
}
