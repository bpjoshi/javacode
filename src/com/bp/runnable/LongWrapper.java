package com.bp.runnable;

/**
 * @author Bhagwati Prasad
 */
public class LongWrapper {
    public Long l;

    public LongWrapper(Long l) {
        this.l = l;
    }

    public Long getL() {
        return l;
    }

    public void setL(Long l) {
        this.l = l;
    }
    //read and write operation, prone to raceCondition
    public void increaseValue(){
        this.l=this.l+1;
    }
}
