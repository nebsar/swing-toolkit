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
package ar.com.huargo.reflection;

import ar.com.huargo.exception.reflection.NoSuchPropertyException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Augusto Recordon
 */
public class ReflectionUtil {

    /**
     * Este m�todo retorna el valor de una property determinada
     * para una instancia de cualquier objeto
     * @param object
     * @param property
     * @return
     */
    public static Object getValueOf(Object object, String property) {

        Object value = null;

        try {
            value = object.getClass().getField(property).get(object);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchFieldException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        return value;
    }

    public static Method getSetter(String property, Object o) {
        Method result = null;
        Method[] methods = o.getClass().getMethods();
        String setterName = "set" + property.substring(0, 1).toUpperCase() + property.substring(1);
        for (int i = 0; i <= methods.length; i++) {
            if (methods[i].getName().equals(setterName)) {
                result = methods[i];
                break;
            }
        }
        return result;
    }

    public static void executeSetter(String property, Object o, Object value, Class valueClass) {
        try {
            Method m = o.getClass().getMethod("set" + property.substring(0, 1).toUpperCase() + property.substring(1),valueClass);
            m.invoke(o, value);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public static Object executeGetter(Object object, String property) {
        StringBuffer sb = new StringBuffer("get").append(property.substring(0, 1).toUpperCase()).append(property.substring(1));
        Object result = null;
        try {
            Method method = ReflectionUtil.getMethod(object.getClass(), sb.toString());

            result = method.invoke(object);
        } catch (Exception e) {

            throw new NoSuchPropertyException();
        }
        return result;
    }

    public static String getValueAsStringOf(Object object, String property) {
        Object obj = ReflectionUtil.getValueOf(object, property);
        String result = null;
        if (obj != null) {
            result = obj.toString();
        }
        return result;
    }

    public static Object getInstance(Class clazz) throws InstantiationException, IllegalAccessException {
        return clazz.newInstance();
    }

    public static Object getInstance(String fullclassname) {
        Object result = null;

        try {
            result = Class.forName(fullclassname).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }

        return result;
    }

    public static Object getInstance(String fullclassname, Object param) {
        Object result = null;
        try {
            Constructor constructor = Class.forName(fullclassname).getConstructor(param.getClass());
            result = constructor.newInstance(param);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("rawtypes")
    public static Method getMethod(Class clazz, String name) {
        Method[] methods = clazz.getMethods();
        Method method = null;
        for (Method m : methods) {
            if (m.getName().equals(name)) {
                method = m;
                break;
            }
        }
        return method;
    }

    @SuppressWarnings("rawtypes")
    public static Field[] getFields(Class clazz) {
        return clazz.getFields();
    }

    @SuppressWarnings("rawtypes")
    public static Object getFieldValue(Class clazz, String fieldName) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
        return clazz.getField(fieldName).get(clazz);
    }

    @SuppressWarnings("rawtypes")
    public static void setFieldValue(Class clazz, String fieldName, Object value) throws IllegalArgumentException, SecurityException, IllegalAccessException, NoSuchFieldException {
        clazz.getField(fieldName).set(clazz, value);
    }

    public static boolean isInstanceOf(Class clazz, Object o) {
        Class oClass = o.getClass();
        boolean result = oClass.equals(clazz);
        while ((!result) && (oClass != Object.class)) {
            oClass = oClass.getSuperclass();
            result = oClass.equals(clazz);
        }
        return result;
    }
    
    public static Class getGetterReturnClass(Class clazz, String propertyName){
        try {
            Method m = clazz.getMethod( new StringBuffer("get").append(propertyName.substring(0, 1).toUpperCase()).append(propertyName.substring(1)).toString());
            return m.getReturnType();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(ReflectionUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static void main(String[] args){
        System.out.println(ReflectionUtil.getGetterReturnClass(ArrayList.class, "size"));
    }
}
