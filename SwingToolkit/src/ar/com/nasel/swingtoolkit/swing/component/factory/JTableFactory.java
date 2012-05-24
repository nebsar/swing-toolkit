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

import ar.com.nasel.swing.component.extension.JTableModel;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JTable;

/**
 *
 * @author Augusto Recordon
 */
public class JTableFactory {

    @SuppressWarnings("rawtypes")
    public static JTable createJTable(Class modelClass, Map<Integer, String[]> modelInfo, int[] editableColumns,ActionListener actionListener) {
        JTableModel jtModel = new JTableModel(modelClass, modelInfo, editableColumns,actionListener);
        JTable result = new JTable(jtModel.createTableModel());
        jtModel.setJTable(result);
        result.setRowHeight(25);
        result.setAutoCreateColumnsFromModel(true);
        result.setShowVerticalLines(false);
        result.setShowGrid(true);
        for (int i = 0; i < result.getColumnCount(); i++) {
            result.getColumnModel().getColumn(i).setPreferredWidth(250);
        }
        return result;
    }
    
    @SuppressWarnings("rawtypes")
    public static JTable createJTable(Class modelClass, Map<Integer, String[]> modelInfo, int[] editableColumns) {
        return JTableFactory.createJTable(modelClass, modelInfo, editableColumns,null);
    }
}
