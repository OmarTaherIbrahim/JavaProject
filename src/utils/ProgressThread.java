package application;



import javafx.application.Platform;
import ui.ring.RingProgressIndicator;

public class ProgressThread extends Thread {
	RingProgressIndicator rpi;
	int progress,end;
	public ProgressThread(RingProgressIndicator rpi,int end) {
		this.rpi=rpi;
		progress=0;
		this.end =end;
	}
	@Override
	public void run() {
		while(true) {
			try {
			Thread.sleep(100);
			} catch(Exception e) {
				
			}
			Platform.runLater(()->{
				rpi.setProgress(progress);

			});
			progress++;
			if(progress>end) {
				progress--;
				break;
				
			}
		}
	}
}
