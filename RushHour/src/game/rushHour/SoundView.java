package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SoundView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	SoundDrawThread soundDrawThread;
	
	Bitmap on_off;//背景图片
	Bitmap yellow;
	
	final int yellowX=85;
	final int yellowY1=228;
	final int yellowY2=253;
	final int on_offX=95;
	final int on_offY=203;
	
	int alpha=125;
	
	int state=0;//按钮状态
	
	Paint paint;
	Paint paint1;
	
	public SoundView(RushHourActivity rushHourActivity) {// 构造器
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		getHolder().addCallback(this);
		soundDrawThread = new SoundDrawThread(this, getHolder());
		on_off = BitmapFactory.decodeResource(getResources(),R.drawable.on_off);
		yellow = BitmapFactory.decodeResource(getResources(),R.drawable.yellow);
		paint=new Paint();
		paint1=new Paint();
		paint1.setAlpha(alpha);
	}
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);// 绘制黑色背景
		canvas.drawBitmap(on_off, on_offX, on_offY, paint);
		if(state==0){
			canvas.drawBitmap(yellow,yellowX, yellowY2, paint1);
		}
		if(state==1){
			canvas.drawBitmap(yellow,yellowX, yellowY1, paint1);
		}
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		soundDrawThread.setFlag(true);
		soundDrawThread.start();// 启动刷帧线程
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		soundDrawThread.setFlag(false);// 停止刷帧线程
		while (retry) {
			try {
				soundDrawThread.join();// 等待刷帧线程结束
				retry = false;
			} catch (InterruptedException e) {// 不断地循环，直到等待的线程结束
			}
		}
	}
	public boolean onTouchEvent(MotionEvent event) {
	if (event.getX() > 85 && event.getX() < 235 && event.getY() > 253
				&& event.getY() < 278&&state==0) {// 点击了是/否按钮
			rushHourActivity.myHandler.sendEmptyMessage(0);// 向Activity的Handler发送消息
			rushHourActivity.isSound=false;
		} 
	if (event.getX() > 85 && event.getX() < 235 && event.getY() > 253
			&& event.getY() < 278&&state==1) {// 点击了是/否按钮
		 state=0;
	} 
	if (event.getX() > 85 && event.getX() < 235 && event.getY() > 228
			&& event.getY() < 253&&state==1) {// 点击了是/否按钮
		rushHourActivity.myHandler.sendEmptyMessage(0);// 向Activity的Handler发送消息
		rushHourActivity.isSound=true;
	} 
	if (event.getX() > 85 && event.getX() < 235 && event.getY() > 228
			&& event.getY() < 253&&state==0) {// 点击了是/否按钮
		state=1;
	} 
		return super.onTouchEvent(event);
	}
}