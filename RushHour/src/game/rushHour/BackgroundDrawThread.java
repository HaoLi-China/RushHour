package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class BackgroundDrawThread extends Thread {
	private int sleep = 200;// ˯�ߵĺ�����
	private boolean flag = true;// ѭ�����λ
	BackgroundView backgroundView;
	SurfaceHolder surfaceHolder = null;

	public BackgroundDrawThread(BackgroundView backgroundView,
			SurfaceHolder surfaceHolder) {// ������
		this.backgroundView = backgroundView;
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
						backgroundView.onDraw(c);
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
