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
package ar.com.huargo.annotation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author Augusto Recordon
 * 
 * This annotation adds support for limiting the possible values
 * for an intenger property.
 * 
 * @version  1.0 final
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IntValue {
    
    /**
     * This value can be set to establish te minimum value for the 
     * annotated field.
     * 
     * @return 
     */
    public int min() default Integer.MIN_VALUE;
    
    /**
     * This value will establish the maximum value accepted for the annotated
     * field.
     * 
     * @return 
     */
    public int max() default Integer.MAX_VALUE;
}
