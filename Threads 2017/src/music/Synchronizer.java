/*
 * Created on May 28, 2017
 *
 */
package music;

public class Synchronizer {
    
    private Voice firstVoiceFlag;

    public Synchronizer(Voice firstVoiceFlag) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
    }

    public Synchronizer() {
    }

    public synchronized void singFirstVoice(String lyrics1, int delay) {
        while (firstVoiceFlag != Voice.FIRST) {
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
        while (firstVoiceFlag != Voice.SECOND) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        singCurrent(lyrics2, delay);
    }
    
    public synchronized void playInstrumental(String instrumental, int delay) {
        while (firstVoiceFlag != Voice.INSTRUMENTAL) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        singCurrent(instrumental, delay);
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
        if(firstVoiceFlag == Voice.FIRST){
        	firstVoiceFlag = Voice.SECOND;
        }else if(firstVoiceFlag == Voice.SECOND){
        	firstVoiceFlag = Voice.INSTRUMENTAL;
        }else{
        	firstVoiceFlag = Voice.FIRST;
        }
        notifyAll();
    }
    
    public Voice getFirstVoiceFlag() {
        return firstVoiceFlag;
    }

    public void setFirstVoiceFlag(Voice firstVoiceFlag) {
        this.firstVoiceFlag = firstVoiceFlag;
    }
    
}
