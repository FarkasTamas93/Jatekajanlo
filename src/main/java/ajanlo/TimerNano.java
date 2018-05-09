package ajanlo;

/**
 * Created by Farkas Tamas on 2018.04.25..
 */
public class TimerNano {

    private long startTime = 0;
    private long endTime   = 0;

    public TimerNano() {
    }

    public void start(){
        this.startTime = System.nanoTime();
    }

    public void end() {
        this.endTime   = System.nanoTime();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getTotalTime() {
        return this.endTime - this.startTime;
    }

}
