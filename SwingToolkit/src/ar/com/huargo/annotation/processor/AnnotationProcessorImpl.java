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

import ar.com.huargo.exception.annotation.ValidationFailedException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Augusto Recordon
 */
public abstract class AnnotationProcessorImpl implements AnnotationProcessor{
    
        
    public String[] process(Object o) {
        Class clazz = o.getClass();
        List<String> list = new ArrayList<String>();
        String[] result = null;
        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields){
            try{
                f.setAccessible(true);
                this.processField(f,o);
            }catch(ValidationFailedException e){
                list.add(f.getName());
            }
        }
        if(list.size() > 0){
            result  = new String[list.size()];
            int i = 0;
            for(String name : list){
                result[i++] = name;
            }
        }
        return result;
    }
    
    protected abstract void processField(Field f,Object o) throws ValidationFailedException;
}
