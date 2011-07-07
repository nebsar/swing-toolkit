/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.concurrency;

/**
 *
 * @author arecordon
 */
public interface Synchronizable {
    
    public void receiveLock(SwingLock lock);
    
    public void releaselock();
    
}
