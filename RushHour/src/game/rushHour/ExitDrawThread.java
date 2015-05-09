package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class ExitDrawThread extends Thread {
	private int sleep = 200;// ˯�ߵĺ�����
	ExitView exitView;
	private boolean flag = true;// ѭ�����λ
	SurfaceHolder surfaceHolder = null;
	int i=0;

	public ExitDrawThread(ExitView exitView,
			SurfaceHolder surfaceHolder) {// ������
		this.exitView = exitView;
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
						exitView.onDraw(c,i);
						i++;
						if(i==3){
							i=0;
						}
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

