package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class AboutView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	AboutDrawThread aboutDrawThread = null;

	Bitmap background;
	Bitmap about;
	Bitmap back;
	Bitmap title1;
	
	public  final int aboutX=9;
	public  final int aboutY=130;
	public  final int backX=144;
	public  final int backY=400;
	public  final int title1X=54;
	public  final int title1Y=50;
	
	int alpha=180;
	
	Paint paint;
	Paint paint1;

	public AboutView(RushHourActivity rushHourActivity) {// 构造器
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		getHolder().addCallback(this);
		aboutDrawThread = new AboutDrawThread(this, getHolder());
		background = BitmapFactory
		.decodeResource(getResources(), R.drawable.background);
		about = BitmapFactory
		.decodeResource(getResources(), R.drawable.about_view);
		back = BitmapFactory
		.decodeResource(getResources(), R.drawable.back);
		title1 = BitmapFactory
		.decodeResource(getResources(), R.drawable.title1);
		paint=new Paint();
		paint1=new Paint();
		paint1.setAlpha(alpha);
	}

	protected void onDraw(Canvas canvas) {
		canvas.drawBitmap(background, 0, 0, paint);
		canvas.drawBitmap(title1, title1X, title1Y, paint);
	    canvas.drawBitmap(about, aboutX, aboutY, paint1);
		canvas.drawBitmap(back, backX, backY, paint);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		aboutDrawThread.setFlag(true);
		aboutDrawThread.start();// 启动刷帧线程
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		aboutDrawThread.setFlag(false);// 停止刷帧线程
		while (retry) {
			try {
				aboutDrawThread.join();// 等待刷帧线程结束
				retry = false;
			} catch (InterruptedException e) {// 不断地循环，直到等待的线程结束
			}
		}
	}

	
	  public boolean onTouchEvent(MotionEvent event) { 
             if (event.getX() > 144 && event.getX() < 176
						&& event.getY() > 400 && event.getY() < 432) {// 点击了返回按钮
            	 rushHourActivity.myHandler.sendEmptyMessage(2);// 向Activity的Handler发送消息
				}
		  
		  return super.onTouchEvent(event); }
}