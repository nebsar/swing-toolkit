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
package ar.com.huargo.swing.component.extension;

import ar.com.huargo.reflection.ReflectionUtil;
import ar.com.huargo.exception.reflection.NoSuchPropertyException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

/**
 * @author Augusto Recordon
 * 
 * This class represents a JTableModel to be used in a JTable to manage its
 * content.
 * 
 * @version 1.0 stable
 */
public class JTableModel implements JTableModelContentUpdater{

    /* ********************************************************************************************************************* */
  
    /**
     * JTable related to this instance.
     */
    private JTable jTable;
    
    /* ********************************************************************************************************************* */
    
    /**
     * Number of columns.
     */
    private int columnCount;
    
    /* ********************************************************************************************************************* */
    
    /**
     * Array containing the number of the columns that may be 
     * editables.
     */
    private int[] editableColumns;
    
    /* ********************************************************************************************************************* */
    
    /**
     * List of records contained in the table.
     */
    @SuppressWarnings("rawtypes")
    private List data;
    
    /* ********************************************************************************************************************* */
    
    /**
     * Auxiliary structure containing data required for configuring
     * the TableModel properly.
     */
    private Map<Integer, String[]> modelInfo;
    
    /* ********************************************************************************************************************* */
    
    /**
     * This object holds a reference to the concrete class whose instances 
     * will be stored in the table.
     */
    @SuppressWarnings("rawtypes")
    private Class modelClass;
    
    /* ********************************************************************************************************************* */
    
    /**
     * Array of the properties of the objects that are displayed in the table.
     */
    private String[] properties;
    
    /* ********************************************************************************************************************* */

    /**
     * 
     * @param modelClass
     * @param modelInfo
     * @param editableColumns 
     */
    @SuppressWarnings("rawtypes")
    public JTableModel(Class modelClass, Map<Integer, String[]> modelInfo, int[] editableColumns) {
        super();
        this.modelClass = modelClass;
        this.modelInfo = modelInfo;
        this.columnCount = this.modelInfo.keySet().size();
        this.editableColumns = editableColumns;
        this.data = new ArrayList();
    }

    /* ********************************************************************************************************************* */
    
    /**
     * This method creates a new instance of TableModel based on the
     * configuration made previously.
     * 
     * @return a new instance of table model, properly configured, according
     * to the configuration established.
     */
    public TableModel createTableModel() {
        String[] names = new String[this.columnCount];
        properties = new String[this.columnCount];
        for (int i = 0; i < this.columnCount; i++) {
            names[i] = modelInfo.get(i)[0];
            properties[i] = modelInfo.get(i)[1];
        }
        final String[] columnNames = names;
        final String[] columnProperties = properties;
        final List<Integer> editableColumnsList = this.createEditableColumnsList();

        return new AbstractTableModel() {

            private static final long serialVersionUID = -9096131181743204109L;

            public int getRowCount() {
                return data.size();
            }

            public int getColumnCount() {
                return columnCount;
            }

            public Object getValueAt(int rowIndex, int columnIndex) {
                Object item = data.get(rowIndex);
                Object result = item;
                if (columnIndex >= 0) {
                    try {
                        result = ReflectionUtil.executeGetter(item, columnProperties[columnIndex]);
                    } catch (NoSuchPropertyException e) {
                        result = columnProperties[columnIndex];
                    }
                }
                return result;
            }

            @Override
            public void fireTableDataChanged() {
                super.fireTableDataChanged();
            }

            @Override
            public String getColumnName(int column) {
                return columnNames[column];
            }

            @Override
            public boolean isCellEditable(int row, int col) {
                return ((editableColumns != null) && (editableColumnsList.contains(col)));
            }

            @SuppressWarnings("unchecked")
            @Override
            public void setValueAt(Object aValue, int row, int column) {

                TableCellEditor ce = jTable.getCellEditor();

                if (ce != null) {
                    jTable.getCellEditor().cancelCellEditing();
                }

                //used to delete all lines
                if (aValue instanceof Integer) {
                    if (aValue.equals(-1)) {
                        data.removeAll(data);
                        super.fireTableDataChanged();
                    } else if (aValue.equals(1)) {
                        data.remove(row);
                        super.fireTableDataChanged();
                    }
                }
                if (ReflectionUtil.isInstanceOf(modelClass, aValue)) {
                    data.add(aValue);
                }

            }
     
        };
    }

    /* ********************************************************************** */
    
    public void setJTable(JTable jTable) {
        this.jTable = jTable;
        this.activateColumnEdition();
    }
    
    /* ********************************************************************** */
    
    private final List<Integer> createEditableColumnsList(){
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < this.editableColumns.length; i++){
            result.add(this.editableColumns[i]);
        }
        return result;
    }
    
    /* ********************************************************************** */
    
    private void activateColumnEdition(){
        for(int i = 0; i < this.editableColumns.length; i++){
            this.jTable.getColumnModel().getColumn(editableColumns[i]).setCellEditor(new CellEditor(this));
        } 
    }
    
    /* ********************************************************************** */
    
    /**
     * This method is invoked when a cell in the table has been updated, so it 
     * can reflect the corresponding modification in the model.
     * 
     * @param row
     * @param column
     * @param newValue 
     */
    public void updateBusinessComponent(int row, int column, Object newValue){
        Object o = this.jTable.getModel().getValueAt(row, -1);
    }
    
    /* ********************************************************************** */

    /**
     * This method is added so this class may implement the JTableModelContentUpdater
     * interface
     * 
     */
    public void cellContentUpdated(int row, int column, String newValue) {
        Object backingObject = this.jTable.getModel().getValueAt(row, -1);
        ReflectionUtil.executeSetter(this.properties[column], backingObject, newValue, String.class);
    }
    
}
