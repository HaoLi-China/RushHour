package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class StartDrawThread extends Thread {
	private int sleep = 200;// ˯�ߵĺ�����
	private boolean flag = true;// ѭ�����λ
	int i=0;
	StartView startView;// ʤ�� ���������
	SurfaceHolder surfaceHolder = null;

	public StartDrawThread(StartView startView, SurfaceHolder surfaceHolder) {// ������
		this.startView = startView;
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
						if(startView.state==0){
							startView.onDraw(c);
						}
						if(startView.state==1){
						   startView.onDraw(c);
						   startView.alpha-=10;
						   if(startView.alpha<0){
							   startView.alpha=0;
						   }
						}
						if(startView.state==2){
							startView.onDraw(c);
							startView.level2_door1X-=4;
							   startView.level2_door2X+=4;;
								if(startView.level2_door1X<-16){
									startView.level2_door1X=-16;
								}
							}
						if(startView.state==3){
							if(i<9){
							startView.onDraw(c,i%2);
							i++;
							}
							else
							startView.onDraw(c);	
						}
						if(startView.state==4){
							   startView.onDraw(c);
							   startView.alpha-=5;
							   startView.winX+=5;
							   if(startView.alpha<0){
								  startView.alpha=0;
							   }
							   if(startView.winX>62){
								 startView.winX=62;
								  }
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
