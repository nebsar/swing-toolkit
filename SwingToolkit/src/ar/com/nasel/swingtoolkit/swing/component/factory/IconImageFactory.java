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

import ar.com.nasel.exception.resource.ResourceNotFoundException;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Augusto Recordon
 */
public class IconImageFactory {
    
    
    public static ImageIcon createImageIcon(Class baseClass, String relativePath){
        URL iconPath = baseClass.getResource(relativePath);
        ImageIcon result = null;
        if(iconPath != null){
            result = new ImageIcon(iconPath);
        }else{
            throw new ResourceNotFoundException();
        }
        return result;
    }
    
}
