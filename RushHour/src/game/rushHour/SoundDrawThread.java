package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class SoundDrawThread extends Thread {
	private int sleep = 200;// ˯�ߵĺ�����
	SoundView soundView;
	private boolean flag = true;// ѭ�����λ
	SurfaceHolder surfaceHolder = null;

	public SoundDrawThread(SoundView soundView,
			SurfaceHolder surfaceHolder) {// ������
		this.soundView = soundView;
		this.surfaceHolder = surfaceHolder;
	}
	
	public void run() {
		Canvas c;// ����
			c = null;
			while (flag) {
			try {
				// �����������������ڴ�Ҫ��Ƚϸߵ�����£����������ҪΪnull
				c = surfaceHolder.lockCanvas(null);
				synchronized (this.surfaceHolder) {
					try {
						soundView.onDraw(c);
					} 
					catch (Exception e) {
	          
					}
				}
			} finally {
				if (c != null) {
					// ������Ļ��ʾ����
					surfaceHolder.unlockCanvasAndPost(c);
				}
			}
			try {
				Thread.sleep(sleep);// ˯��sleep����
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}
	public void setFlag(boolean flag) {// ����ѭ�����
	this.flag = flag;
}
}

