package ajanlo;

/**
 * Created by Farkas Tamas on 2018.04.25..
 */

/**
 * segéd osztály amely a klaszterezési eljárás alatt eltelt időt hivatott mérni milisecundumban.
 *
 */
public class Timer {

    private long startTime = 0;
    private long endTime   = 0;

    /**
     * praméter nélküli konstruktor.
     *
     */
    public Timer() {
    }

    /**
     * rögzíti a méréshez a kezdeti időpontot.
     *
     */
    public void start(){
        this.startTime = System.currentTimeMillis();
    }

    /**
     * rögzíti a méréshez a befejezéskori időpontot.
     *
     */
    public void end() {
        this.endTime   = System.currentTimeMillis();
    }

    /**
     *lekéri a kezdeti időpontot.
     *
     * @return visszatér a kezdeti időponttal
     */
    public long getStartTime() {
        return this.startTime;
    }

    /**
     * lekéri a befejezéskori időpontot.
     *
     * @return visszatér az időponttal
     */
    public long getEndTime() {
        return this.endTime;
    }

    /**
     * megadja az eltelt időt a mérés kezdete és vége között.
     *
     * @return visszatér az eltelt idővel
     */
    public long getTotalTime() {
        return this.endTime - this.startTime;
    }

}
