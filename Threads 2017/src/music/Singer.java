/*
 * Created on May 28, 2017
 *
 */
package music;

public class Singer extends Thread {
    
    private String singerName;
    private Voice voice;
    private Performance performance;
    
    private Synchronizer synch;
    private boolean stopIt;
    
    public Singer(String singerName, Voice voice, Performance performance, Synchronizer synch, boolean stopIt) {
        super();
        this.singerName = singerName;
        this.voice = voice;
        this.performance = performance;
        this.synch = synch;
        this.stopIt = stopIt;
    }
    
    public Singer() {
        super();
    }
    
    // Here comes the real thing :)
    
    
    public String getSingerName() {
        return singerName;
    }
    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }
    public Voice getVoice() {
        return voice;
    }
    public void setVoice(Voice voice) {
        this.voice = voice;
    }
    public Performance getPerformance() {
        return performance;
    }
    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
    public Synchronizer getSynch() {
        return synch;
    }
    public void setSynch(Synchronizer synch) {
        this.synch = synch;
    }
    public boolean isStopIt() {
        return stopIt;
    }
    public void setStopIt(boolean stopIt) {
        this.stopIt = stopIt;
    }

}
