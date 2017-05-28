/*
 * Created on May 28, 2017
 *
 */
package music;

public class Synchronizer {
    
    private boolean firstVoiceFlag;

    public Synchronizer(boolean firstVoiceFlag) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
    }

    public Synchronizer() {
    }

    // Here comes the real thing :)
    
    
    public boolean isFirstVoiceFlag() {
        return firstVoiceFlag;
    }

    public void setFirstVoiceFlag(boolean firstVoiceFlag) {
        this.firstVoiceFlag = firstVoiceFlag;
    }
    
}
