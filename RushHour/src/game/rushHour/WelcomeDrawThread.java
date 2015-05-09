package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class WelcomeDrawThread extends Thread {
	int i = 0;
	private int sleep = 200;// ˯�ߵĺ�����
	private boolean flag = true;// ѭ�����λ
	WelcomeView welcomeView;// ��ӭ���������
	SurfaceHolder surfaceHolder = null;

	public WelcomeDrawThread(WelcomeView welcomeView,
			SurfaceHolder surfaceHolder) {// ������
		this.welcomeView = welcomeView;
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
						welcomeView.onDraw(c, i);
						i++;
						if (i == 4)
							i = 0;
					} catch (Exception e) {
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
