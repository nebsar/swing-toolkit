/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.concurrency;

/**
 *
 * @author arecordon
 */
public class SwingSynchronizer {
     
    private SwingLock lock;
    
    public void synchronizeWith(Synchronizable synchronizable) throws InterruptedException{
        this.lock = new SwingLock(true);
        synchronizable.receiveLock(this.lock);
        this.lock.lock();
    }
}
