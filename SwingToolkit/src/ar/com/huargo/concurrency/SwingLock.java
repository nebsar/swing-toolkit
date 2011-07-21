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
package ar.com.huargo.concurrency;

/**
 *
 * @author Augusto Recordon
 * 
 * This is an implementation of a basic concurrency lock. It provides 
 * typical operations of lock and unlock to handle the lock.
 * 
 * @version 1.0 final
 * 
 */
public final class SwingLock {
    
    /* ************************************************************************/
    
    /**
     * This property holds the state of the lock.
     */
    private boolean isLocked;
    
    /* ************************************************************************/
    
    /**
     * This property holds a reference to the Thread that holds the lock.
     */
    private Thread lockedBy;
    
    /* ************************************************************************/
    
    /**
     * This property counts how many Thread locked this instance.
     */
    private int lockedCount;

    /* ************************************************************************/
    
    /**
     * Default constructor. This creates an unlocked SwingLock.
     * 
     */
    public SwingLock() {
        this(false);
    }

    /* ************************************************************************/
    
    /**
     * This constructor allows the method that instantiates the Lock to determine
     * if it should be locked automatically.
     * @param locked 
     */
    public SwingLock(boolean locked) {
        super();
        this.isLocked = locked;
        this.lockedCount = (locked) ? 1 : 0;
    }

    /* ************************************************************************/
    
    /**
     * This method attempts to use the lock. If it fails, then it waits until
     * other thread releases the Lock.
     * 
     * @throws InterruptedException 
     */
    public synchronized final void lock() throws InterruptedException {
        Thread callingThread = Thread.currentThread();
        while (isLocked && ((lockedBy == null) || (lockedBy != callingThread))) {
            wait();
        }
        isLocked = true;
        lockedCount++;
        lockedBy = callingThread;
    }
    
    /* ************************************************************************/

    /**
     * This method is called when a thread wants to release the lock.
     */
    public synchronized final void unlock() {
        if ((this.lockedBy == null) || (Thread.currentThread() == this.lockedBy)) {
            lockedCount--;
            if (lockedCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }
    
    /* ************************************************************************/
}
