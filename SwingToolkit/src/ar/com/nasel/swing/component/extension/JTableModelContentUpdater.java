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

/**
 *
 * @author Augusto Recordon
 * 
 * This interface defines the protocol required to allow a component to update
 * the backing model of a JTable after a cell is edited. That means that if a 
 * cell is edited its change will be reflected in the object mapped to the 
 * corresponding row.
 * 
 * @version 1.0 final
 * 
 * Implementations: @see JTableModel
 * 
 */
public interface JTableModelContentUpdater {
    
    public void cellContentUpdated(int row, int column, Object newValue);
    
}
