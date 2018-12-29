package utils;



import javafx.application.Platform;
import ui.ring.RingProgressIndicator;

public class ProgressThread extends Thread {
	RingProgressIndicator rpi;
	int progress,end;
	float speed;
	public ProgressThread(RingProgressIndicator rpi,int end,float speed) {
		this.rpi=rpi;
		progress=0;
		this.speed=speed;
		this.end =end;
	}
	public ProgressThread(RingProgressIndicator rpi, int end) {
		// TODO Auto-generated constructor stub
		this.rpi=rpi;
		progress=0;
		this.speed=(float) (end*2.5);
		this.end =end;
	}
	@Override
	public void run() {
		while(true) {
			try {
			Thread.sleep(100000/((int)speed*100));
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
