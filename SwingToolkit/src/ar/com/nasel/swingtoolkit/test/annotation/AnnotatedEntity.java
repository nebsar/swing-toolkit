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

import ar.com.nasel.annotation.annotation.Length;
import ar.com.nasel.annotation.annotation.Required;

/**
 *
 * @author Augusto Recordon
 * 
 * This class is an example of an entity using the Swing-Toolkit annotation
 * system.
 * 
 * @version  1.0 final
 */
public class AnnotatedEntity {
    
    /**
     * This field is required to have a value, but no value
     * is given.
     */
    @Required(required=true)
    private String requiredAnnotatedField1;
    
    
    /**
     * This field is required and has a default value. 
     */
    @Required(required=true)
    private String requiredAnnotatedField2 = "Something";
    
    
    /**
     * This field is specified as not required and not value
     * is assigned to it.
     */
    @Required(required=false)
    private String requiredAnnotatedField3;
    
    
    /**
     * This is a simple property (not annotated).
     */
    private String notAnnotatedField;
    
    /**
     * This field length should be between 2 and 4 characters.
     */
    @Length(min=2,max=4)
    private String lenghtAnnotated1 = "1232";
    
    /**
     * This field length is required to be between 3 and 6, but its
     * value has a length of 2.
     */
    @Length(min=3,max=6)
    private String lengthAnnotated2 = "12";
}
