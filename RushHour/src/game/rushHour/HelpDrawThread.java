package game.rushHour;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class HelpDrawThread extends Thread {
	private int sleep = 200;// 睡眠的毫秒数
	HelpView helpView;
	private boolean flag = true;// 循环标记位
	SurfaceHolder surfaceHolder = null;

	public HelpDrawThread(HelpView helpView,
			SurfaceHolder surfaceHolder) {// 构造器
		this.helpView = helpView;
		this.surfaceHolder = surfaceHolder;
	}
	
	public void run() {
		Canvas c;// 画布
			c = null;
			while (flag) {
			try {
				// 锁定整个画布，在内存要求比较高的情况下，建议参数不要为null
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
