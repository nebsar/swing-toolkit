/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.huargo.swingtoolkit.concurrency;

/**
 *
 * @author arecordon
 */
public class SwingLock {

  private boolean isLocked;
  private Thread  lockedBy;
  private int lockedCount;

  
  public SwingLock(){
      this(false);
  }
  
  
  public SwingLock(boolean locked){
      super();
      this.isLocked = locked;
      this.lockedCount = (locked) ? 1 : 0;
  }
  
  public synchronized void lock() throws InterruptedException{
    Thread callingThread = Thread.currentThread();
    while(isLocked && ((lockedBy == null) || (lockedBy != callingThread))){
      wait();
    }
    isLocked = true;
    lockedCount++;
    lockedBy = callingThread;
  }


  public synchronized void unlock(){
    if((this.lockedBy == null) || (Thread.currentThread() == this.lockedBy)){
      lockedCount--;
      if(lockedCount == 0){
        isLocked = false;
        notify();
      }
    }
  }

}
