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
package ar.com.nasel.swingtoolkit.swing.component.factory;

import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * @author Augusto Recordon
 * 
 * This class provides a set of methods for creating and showing messages
 * to the user and handling his/her input as well.
 * 
 * @version 1.0
 */
public class MessageDialogFactory {
    
    
    /* ********************************************************************** */
    
    /**
     * This constant should be used for displaying warning messages.
     */
    public static final String WARNING = "Warning";
    
    /* ********************************************************************** */
    
    /**
     * This constant should be used when displaying error messages.
     */
    public static final String ERROR = "Error";
    
    /* ********************************************************************** */
    
    /**
     * This constant should be used for displaying simple messages.
     */
    public static final String NOTIFICATION = "Message";
    
    /* ********************************************************************** */
    
    /**
     * This method creates and displays an YES/NO confirmation message
     * 
     * @param parentComponent : the parentComponent for the new dialog box.
     * @param message : the message to be displayed to the user.
     * @param title : the title of the dialog. If null, NOTIFICATION constant
     *                will be used a title for the box.
     * 
     * @return true : the user pressed YES
     * @return false : the user pressed NO
     * @return null : an error occurred.
     */
    public static Boolean showYesNoMessageDialog(Component parentComponent, String message, String title){
        int userResponse = JOptionPane.showConfirmDialog(parentComponent,message,title,JOptionPane.YES_NO_OPTION);
        Boolean result = null;
        if(userResponse == JOptionPane.YES_OPTION){
            result = true;
        }else{
            if(userResponse == JOptionPane.NO_OPTION){
                result = false;
            }
        }
        return result;
    }
   
}
