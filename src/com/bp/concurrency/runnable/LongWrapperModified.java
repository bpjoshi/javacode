package com.bp.concurrency.runnable;

/**
 * @author Bhagwati Prasad
 */
public class LongWrapperModified {
    private final Object monitor=new Object();
    public Long l;

    public LongWrapperModified(Long l) {
        this.l = l;
    }

    public Long getL() {
        return l;
    }

    public void setL(Long l) {
        this.l = l;
    }
    //Will not have race condition anymore due to synchronized on a monitor/key
    public void increaseValue(){
        synchronized (monitor){
            this.l=this.l+1;
        }
    }
}
