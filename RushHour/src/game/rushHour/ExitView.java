package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class ExitView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	ExitDrawThread exitDrawThread;
	
	Bitmap exit1;//退出提示
	Bitmap yes[]=new Bitmap[3];//是
	Bitmap no[]=new Bitmap[3];//否

	final int exit1X=74;
	final int exit1Y=200;
	final int yesX=32;
	final int yesY=280;
	final int noX=240;
	final int noY=280;

	Paint paint;

	
	public ExitView(RushHourActivity rushHourActivity) {// 构造器
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		getHolder().addCallback(this);
		exitDrawThread = new ExitDrawThread(this, getHolder());
		exit1 = BitmapFactory.decodeResource(getResources(),R.drawable.exit1);
		yes[0] = BitmapFactory.decodeResource(getResources(),R.drawable.y1);
		yes[1] = BitmapFactory.decodeResource(getResources(),R.drawable.y2);
		yes[2] = BitmapFactory.decodeResource(getResources(),R.drawable.y3);
		no[0] = BitmapFactory.decodeResource(getResources(),R.drawable.n1);
		no[1] = BitmapFactory.decodeResource(getResources(),R.drawable.n2);
		no[2] = BitmapFactory.decodeResource(getResources(),R.drawable.n3);
		paint=new Paint();
	}
	protected void onDraw(Canvas canvas,int i) {
		canvas.drawColor(Color.BLACK);// 绘制黑色背景
		canvas.drawBitmap(exit1, exit1X, exit1Y, paint);
	    canvas.drawBitmap(yes[i],yesX, yesY, paint);
		canvas.drawBitmap(no[i],noX, noY, paint);
		
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		exitDrawThread.setFlag(true);
		exitDrawThread.start();// 启动刷帧线程
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		exitDrawThread.setFlag(false);// 停止刷帧线程
		while (retry) {
			try {
				exitDrawThread.join();// 等待刷帧线程结束
				retry = false;
			} catch (InterruptedException e) {// 不断地循环，直到等待的线程结束
			}
		}
	}
	public boolean onTouchEvent(MotionEvent event) {
	if (event.getX() > 32 && event.getX() < 80 && event.getY() > 280
				&& event.getY() < 328) {// 点击了是按钮
		System.exit(0);//退出游戏
		} 
	if (event.getX() > 240 && event.getX() < 288 && event.getY() > 280
			&& event.getY() < 328) {// 点击了否按钮
		rushHourActivity.myHandler.sendEmptyMessage(19);// 向Activity的Handler发送消息
	} 
		return super.onTouchEvent(event);
	}
}