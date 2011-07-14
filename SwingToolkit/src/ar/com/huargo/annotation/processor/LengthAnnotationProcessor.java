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
package ar.com.huargo.annotation.processor;

import ar.com.huargo.annotation.annotation.Length;
import ar.com.huargo.exception.annotation.InvalidLengthForFieldException;
import ar.com.huargo.exception.annotation.ValidationFailedException;
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
