/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.annotation.annotation.processor;

import ar.com.huargo.annotation.exception.ValidationFailedException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author augusto
 */
public abstract class AnnotationProcessorImpl implements AnnotationProcessor{
    
        
    @Override
    public String[] process(Object o) {
        Class clazz = o.getClass();
        List<String> list = new ArrayList<String>();
        String[] result = null;
        Field[] fields = clazz.getFields();
        for(Field f : fields){
            try{
                this.processField(f,o);
            }catch(ValidationFailedException e){
                list.add(f.getName());
            }
        }
        if(list.size() > 0){
            result  = (String[])list.toArray();
        }
        return result;
    }
    
    public abstract void processField(Field f,Object o) throws ValidationFailedException;
}
