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
package ar.com.nasel.swingtoolkit.form;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Augusto Recordon
 */
public abstract class AbstractSwingForm {
    
    /* ********************************************************************** */
    
    protected Component containerComponent;
    
    
    /* ********************************************************************** */
    
    protected List<Component> components;

    
    /* ********************************************************************** */
    

    /**
     * 
     * This is the default constructor. It doesn't set
     * any container component. 
     * 
     * Take under consideration that the container component can only
     * be setted while there's no components added to the form, yet.
     */
    public AbstractSwingForm(){
        super();
        this.components = new ArrayList<Component>();
    }    
    
    
    /* ********************************************************************** */
    
    /**
     * This constructor sets the container component for the form.
     * @param containerComponent 
     */
    public AbstractSwingForm(Component containerComponent){
        this();
        this.containerComponent = containerComponent;
    }
    
    
    /* ********************************************************************** */
    
    public AbstractSwingForm(Component containerComponent,List<Component> components) {
        this(containerComponent);
        this.components = components;
    }
    
    /* ********************************************************************** */
    
    public AbstractSwingForm(Component containerComponent,Component component){
        this(containerComponent);
        this.components.add(component);
    }
    
    /* ********************************************************************** */
    
    public void add(Component component){
        
    }
    
    /* ********************************************************************** */
}
