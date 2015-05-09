package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class AboutDrawThread extends Thread {
	int i = 4;
	private int sleep = 200;// ˯�ߵĺ�����
	private boolean flag = true;// ѭ�����λ
	AboutView aboutView;// ������Ϸ���������
	SurfaceHolder surfaceHolder = null;

	public AboutDrawThread(AboutView aboutView, SurfaceHolder surfaceHolder) {// ������
		this.aboutView = aboutView;
		this.surfaceHolder = surfaceHolder;
	}

	public void run() {

		Canvas c;// ����
		while (flag) {
			c = null;
			try {
				// �����������������ڴ�Ҫ��Ƚϸߵ�����£����������ҪΪnull
				c = surfaceHolder.lockCanvas(null);
				synchronized (this.surfaceHolder) {
					try {
						aboutView.onDraw(c);
							setFlag(false);
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
