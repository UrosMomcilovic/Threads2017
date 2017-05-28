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

    public synchronized void singFirstVoice(String lyrics1, int delay) {
        while (!firstVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        singCurrent(lyrics1, delay);
    }

    public synchronized void singSecondVoice(String lyrics2, int delay) {
        while (firstVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        singCurrent(lyrics2, delay);
    }

    /**
     * @param lyrics
     */
    private void singCurrent(String lyrics, int delay) {
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(lyrics);
        firstVoiceFlag = !firstVoiceFlag;
        notifyAll();
    }
    
    public boolean isFirstVoiceFlag() {
        return firstVoiceFlag;
    }

    public void setFirstVoiceFlag(boolean firstVoiceFlag) {
        this.firstVoiceFlag = firstVoiceFlag;
    }
    
}
