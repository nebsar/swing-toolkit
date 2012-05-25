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
package ar.com.nasel.swingtoolkit.test.panel;

import ar.com.nasel.swing.component.extension.GenericJTabbedPaneChangeListener;
import ar.com.nasel.swing.component.extension.PanelChangeListener;
import ar.com.nasel.swingtoolkit.swing.component.factory.JLabelFactory;
import ar.com.nasel.swingtoolkit.swing.component.factory.JPanelFactory;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author Augusto Recordon
 */
public class TestTabbedPane {
    
    
    public static GenericJTabbedPaneChangeListener getListener(JTabbedPane pane){
        Map<Integer,PanelChangeListener> mapa = new HashMap<Integer, PanelChangeListener>();
        
        mapa.put(0,new PanelChangeListener() {

            public void focusGained() {
                System.out.println("FOCO en 1");
            }

            public void focusLost() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        
        
        mapa.put(1,new PanelChangeListener() {

            public void focusGained() {
                System.out.println("FOCO en 2");
            }

            public void focusLost() {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
        
        GenericJTabbedPaneChangeListener result = new GenericJTabbedPaneChangeListener(pane,mapa);
        return result;
    }
    
    
    public static void main(String[] args){
        JFrame frame = new JFrame();
        JPanel panel = JPanelFactory.createJPanel();
        panel.add(JLabelFactory.createJLabel("hello"));
        frame.setSize(new Dimension(800,800));
        frame.add(panel);
        frame.setVisible(true);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel innerPanel = new JPanel();
        innerPanel.add(new JLabel("a label"));
        
        JTabbedPane tabbedPane = new JTabbedPane();
	tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
	tabbedPane.addTab("Cuotas a Reimprimir",null,innerPanel,"Formulario de Reimpresión");
	tabbedPane.addTab("Cuenta Corriente",null ,new JPanel(),"Detalle de la Cuenta Corriente");
        tabbedPane.addChangeListener(getListener(tabbedPane));
        panel.add(tabbedPane);
    }
    
}
