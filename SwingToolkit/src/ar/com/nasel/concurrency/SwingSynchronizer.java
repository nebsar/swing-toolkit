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
package ar.com.nasel.concurrency;

/**
 * @author Augusto Recordon
 * 
 * This class allows two threads to synchronize with each other.
 * In order the mechanism to work, the first window must call the
 * synchronizeWith method with a reference to a second window, the one it wants
 * to synchronize with. This will make the corresponding thread to synchronize.
 * 
 * Have in mind that this only a kind of barrier synchronization mechanism.
 * Version 1.0 doesn't provide a way for communication, so if one thread must
 * make calls on the second windows (and viceversa), that logic must be implemented
 * in the windows' logic.
 * 
 * @version  1.0 final
 */
public final class SwingSynchronizer {
    
    /* ************************************************************************/
    
    /**
     * Reference to the lock being used for synchronization purpose.
     * 
     * @see SwingLock
     */
    private SwingLock lock;

    /* ************************************************************************/
    
    /**
     * This method takes care of the synchronization of two threads. The frist
     * thread is the current thread. The second is the given as argument to this
     * method.
     * 
     * @param synchronizable : this should be a thread implementing de Synchronizable
     * interface. That would allow the thread and the synchronizer instance to
     * communicate correctly.
     * 
     * @throws InterruptedException 
     */
    public final void synchronizeWith(Synchronizable synchronizable) throws InterruptedException {
        this.lock = new SwingLock(true);
        synchronizable.receiveLock(this.lock);
        this.lock.lock();
    }
    
    /* ************************************************************************/
}
