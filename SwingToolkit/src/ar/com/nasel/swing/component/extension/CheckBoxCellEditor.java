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

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Augusto Recordon
 */
public class CheckBoxCellEditor extends AbstractCellEditor implements TableCellEditor {

    protected JCheckBox checkBox;
    private JTableModel tableModel;
    private int column;
    /* ********************************************************************** */
    /**
     * Row number corresponding to the cell being edited.
     */
    private int row;

    /* ********************************************************************** */
    public CheckBoxCellEditor(JTableModel tableModel,ActionListener actionListener) {
        super();
        checkBox = new JCheckBox();
        checkBox.addActionListener(actionListener);
        checkBox.setHorizontalAlignment(SwingConstants.CENTER);
        checkBox.setBackground(Color.white);
        this.tableModel = tableModel;
    }

//		public CheckBoxCellEditor() {  
//			checkBox = new JCheckBox();  
//			checkBox.setHorizontalAlignment(SwingConstants.CENTER);  
//			checkBox.setBackground( Color.white);  
//		}  
    public Component getTableCellEditorComponent(
            JTable table,
            Object value,
            boolean isSelected,
            int row,
            int column) {

        checkBox.setSelected(((Boolean) value).booleanValue());

        //	            Component c = table.getDefaultRenderer(String.class).getTableCellRendererComponent(table, value, isSelected, false, row, column);  
        //	            if (c != null) {  
        //	                checkBox.setBackground(c.getBackground());  
        //	            }  

        this.row = row;
        this.column = column;
        return checkBox;
    }

    public Object getCellEditorValue() {
        this.tableModel.cellContentUpdated(this.row, this.column, Boolean.valueOf(checkBox.isSelected()));
        return Boolean.valueOf(checkBox.isSelected());
    }
}
