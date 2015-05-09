package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class HelpView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	HelpDrawThread helpDrawThread;
	
	Bitmap background;// 背景图片
	Bitmap helpView1;// 帮助界面
	Bitmap helpView2;// 帮助界面
	Bitmap back;// 返回按钮
	Bitmap up;// 向上按钮
	Bitmap down;// 向下按钮
	
	final int helpViewX=23;
	final int helpViewY=138;
	final int backX=144;
	final int backY=400;
	final int buttonX=147;
	final int upY=106;
	final int downY=358;
	
	int alpha=180;
	int state=0;
	
	Paint paint;
	Paint paint1;

	public HelpView(RushHourActivity rushHourActivity) {// 构造器
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		getHolder().addCallback(this);
		helpDrawThread = new HelpDrawThread(this, getHolder());
		background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
		helpView1 = BitmapFactory.decodeResource(getResources(),R.drawable.help_view1);
		helpView2 = BitmapFactory.decodeResource(getResources(),R.drawable.help_view2);
		back = BitmapFactory.decodeResource(getResources(),R.drawable.back);
		up = BitmapFactory.decodeResource(getResources(),R.drawable.up);
		down = BitmapFactory.decodeResource(getResources(),R.drawable.down);
		paint=new Paint();
		paint1=new Paint();
		paint1.setAlpha(alpha);
	}
	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(background, 0, 0,paint);//背景图片
		if(state==0)
		canvas.drawBitmap(helpView1, helpViewX, helpViewY,paint1);//帮助界面
		if(state==1)
		canvas.drawBitmap(helpView2, helpViewX, helpViewY,paint1);//帮助界面
		canvas.drawBitmap(back, backX, backY,paint);// 返回按钮
		canvas.drawBitmap(up, buttonX, upY,paint);// 向上按钮
		canvas.drawBitmap(down, buttonX, downY,paint);// 向下按钮
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		helpDrawThread.setFlag(true);
		helpDrawThread.start();// 启动刷帧线程
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		helpDrawThread.setFlag(false);// 停止刷帧线程
		while (retry) {
			try {
				helpDrawThread.join();// 等待刷帧线程结束
				retry = false;
			} catch (InterruptedException e) {// 不断地循环，直到等待的线程结束
			}
		}
	}
	public boolean onTouchEvent(MotionEvent event) {
	if (event.getX() > 144 && event.getX() < 176 && event.getY() > 400
				&& event.getY() < 432) {// 点击了返回菜单按钮
			rushHourActivity.myHandler.sendEmptyMessage(2);// 向Activity的Handler发送消息
		} 
	else if (event.getX() > 147 && event.getX() < 173 && event.getY() > 106
			&& event.getY() < 122) {// 点击了向上菜单按钮
		state=0;
	} 
	else if (event.getX() > 147 && event.getX() < 173 && event.getY() > 358
			&& event.getY() < 374) {// 点击了向下菜单按钮
		state=1;
	} 
		return super.onTouchEvent(event);
	}
}