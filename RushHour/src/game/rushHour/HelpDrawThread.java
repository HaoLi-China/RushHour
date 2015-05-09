package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class HelpDrawThread extends Thread {
	private int sleep = 200;// ˯�ߵĺ�����
	HelpView helpView;
	private boolean flag = true;// ѭ�����λ
	SurfaceHolder surfaceHolder = null;

	public HelpDrawThread(HelpView helpView,
			SurfaceHolder surfaceHolder) {// ������
		this.helpView = helpView;
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
						helpView.onDraw(c);
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
