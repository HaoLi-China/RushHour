package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MenuDrawThread extends Thread {
	int i = 0;
	private int sleep = 200;// ˯�ߵĺ�����
	private boolean flag = true;// ѭ�����λ
	MenuView menuView;// ��ӭ���������
	SurfaceHolder surfaceHolder = null;

	public MenuDrawThread(MenuView menuView, SurfaceHolder surfaceHolder) {// ������
		this.menuView = menuView;
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
						menuView.onDraw(c, i);
						i++;
						if (i == 4) {
							i=0;
						}
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
