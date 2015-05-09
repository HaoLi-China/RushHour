package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class StartDrawThread extends Thread {
	private int sleep = 200;// 睡眠的毫秒数
	private boolean flag = true;// 循环标记位
	int i=0;
	StartView startView;// 胜利 界面的引用
	SurfaceHolder surfaceHolder = null;

	public StartDrawThread(StartView startView, SurfaceHolder surfaceHolder) {// 构造器
		this.startView = startView;
		this.surfaceHolder = surfaceHolder;
	}

	public void run() {

		Canvas c;// 画布
		while (flag) {
			c = null;
			try {
				// 锁定整个画布，在内存要求比较高的情况下，建议参数不要为null
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
					// 更新屏幕显示内容
					surfaceHolder.unlockCanvasAndPost(c);
				}
			}
			try {
				Thread.sleep(sleep);// 睡眠sleep毫秒
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void setFlag(boolean flag) {// 设置循环标记
		this.flag = flag;
	}
}
