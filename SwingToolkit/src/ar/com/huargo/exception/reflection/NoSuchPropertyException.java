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
package ar.com.huargo.exception.reflection;

/**
 *
 * @author Augusto Recordon
 * 
 * This exception is useful for signaling where a property
 * tried to be accessed via reflection is not found.
 * 
 * @version 1.0 final
 */
public class NoSuchPropertyException extends RuntimeException{

	private static final long serialVersionUID = -4046796475209783891L;

}