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

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author Augusto Recordon
 */
public class CellEditor extends AbstractCellEditor implements TableCellEditor {

    /* ********************************************************************** */
    
    /**
     * Component being edited.
     */
    private JComponent component = new JTextField();

    /* ********************************************************************** */
    
    /**
     * Column number corresponding to the cell being edited.
     */
    private int column;
    
    /* ********************************************************************** */
    
    /**
     * Row number corresponding to the cell being edited.
     */
    private int row;

    /* ********************************************************************** */
    
    /**
     * TableModel required for update the corresponding model object
     */
    private JTableModel tableModel;
    
    /* ********************************************************************** */
    
    
    public CellEditor(JTableModel tableModel){
        super();
        this.tableModel = tableModel;
    }
    
    
    /* ********************************************************************** */
    
    /**
     * This method is invoked after cell edition is completed.
     * 
     * @return The new value contained in the cell.
     */
    public Object getCellEditorValue() {
        String newValue = ((JTextField) this.component).getText();
        this.tableModel.cellContentUpdated(this.row, this.column, newValue);
        return newValue;
    }

    /* ********************************************************************** */
    
    /**
     * 
     * This method is invoked when trying to edit a cell.
     * 
     * @param table
     * @param value
     * @param isSelected
     * @param row
     * @param column
     * @return 
     */
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        JTextField field = (JTextField) this.component;
        field.setText(value.toString());
        field.selectAll();
        this.row = row;
        this.column = column;
        return this.component;
    }
    
    /* ********************************************************************** */
}
