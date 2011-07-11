/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.swing.component.factory;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author arecordon
 */
public class JPanelFactory {

    public static JPanel createJPanel(){
        return new JPanel(new BorderLayout());
    }
}
