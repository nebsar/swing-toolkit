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
package ar.com.nasel.swingtoolkit;

import ar.com.nasel.swingtoolkit.swing.component.factory.JPanelFactory;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Augusto Recordon
 * 
 * 07-06-2011
 * 
 * @version 0.1
 */
public abstract class GenericWindow {
   
    protected JPanel containerPanel;
    
    protected JFrame jFrame;
    
    protected String title;
    
    protected static final int DEFAULT_BORDER = 20;
    
    protected GenericWindow(){
        this("");
    }
    
    protected GenericWindow(String title){
        super();
        this.title = title;
        this.init();
        
    }
    
    private void init(){
        this.createFrame();
        this.createContainerPanel();
        this.postConfiguration();
    }
    
    
    private void createFrame(){
        this.jFrame = new JFrame(this.title);
        this.jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void createContainerPanel(){
        this.containerPanel = JPanelFactory.createJPanel();
        this.containerPanel.setBorder(this.getBorder());
        this.initializeContainerPanel();
    }
    
    
    private void postConfiguration(){
        this.jFrame.getContentPane().add(this.containerPanel);
        this.jFrame.pack();
        this.jFrame.setVisible(true);
    }
    
    protected Border getBorder(){
        return BorderFactory.createEmptyBorder(
                                                DEFAULT_BORDER,
                                                DEFAULT_BORDER,
                                                DEFAULT_BORDER,
                                                DEFAULT_BORDER
                                              );
    }
    
    
    protected abstract void initializeContainerPanel();
    
    
}
