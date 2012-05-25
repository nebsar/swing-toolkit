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
package ar.com.nasel.swing.component.extension;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Augusto Recordon
 * 
 * This class implements ChangeListener interface, so it provides an
 * implementation for stateChanged method.
 * 
 * @see ChangeListener
 */
public class GenericJTabbedPaneChangeListener implements ChangeListener{
    
    /**
     * This should be the JTabbedPane instance asociated with this change listener.
     */
    protected JTabbedPane tabbedPane;
    
    /**
     * This map contains a tab index and a PanelChangeListener implementation
     * to handle focus gain and loss on that tab.
     * @see PanelChangeListener
     */
    protected Map<Integer,PanelChangeListener> panelListeners;
    
    
    /**
     * @param tabbedPane 
     * 
     * This is the default constructor for this class. It receives
     * the JTabbedPane instance associated with it.
     */
    public GenericJTabbedPaneChangeListener(JTabbedPane tabbedPane){
        super();
        this.tabbedPane = tabbedPane;
    }
    
    /**
     * 
     * @param tabbedPane
     * @param panelListeners 
     */
    public GenericJTabbedPaneChangeListener(JTabbedPane tabbedPane, Map<Integer,PanelChangeListener> panelListeners){
        this(tabbedPane);
        this.panelListeners = panelListeners;
    }
    
    public void addPanelListener(Integer tabIndex, PanelChangeListener panelListener){
        if(this.panelListeners == null){
            this.panelListeners = new HashMap<Integer, PanelChangeListener>();
        }
        this.panelListeners.put(tabIndex,panelListener);
    }

    public void stateChanged(ChangeEvent e) {
        PanelChangeListener panelListener = this.panelListeners.get(this.tabbedPane.getSelectedIndex());
        if(panelListener != null){
            panelListener.focusGained();
        }
    }
    
    
}
