package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class WelcomeView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	WelcomeDrawThread welcomeDrawThread = null;

	Bitmap bit[] = new Bitmap[4];
	Bitmap words;// 字
	Bitmap forward;// 前进按钮
	
	final int bitX = 65;// 图片初始坐标
	final int bitY = 145;
	final int wordsX = 33;// 字初始坐标
	final int wordsY = 50;
	final int forwardX = 144;// 按钮的初始坐标
	final int forwardY = 380;
	
	Paint paint;

	public WelcomeView(RushHourActivity rushHourActivity) {// 构造器
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		getHolder().addCallback(this);
		welcomeDrawThread = new WelcomeDrawThread(this, getHolder());
		bit[0] = BitmapFactory
				.decodeResource(getResources(), R.drawable.back_1);
		bit[1] = BitmapFactory
				.decodeResource(getResources(), R.drawable.back_2);
		bit[2] = BitmapFactory
				.decodeResource(getResources(), R.drawable.back_3);
		bit[3] = BitmapFactory
				.decodeResource(getResources(), R.drawable.back_4);
		words = BitmapFactory.decodeResource(getResources(), R.drawable.words);
		forward = BitmapFactory.decodeResource(getResources(),
				R.drawable.forward);
		paint=new Paint();
	}

	protected void onDraw(Canvas canvas, int i) {
		canvas.drawBitmap(bit[i], bitX, bitY, paint);// 进入游戏界面图片
		canvas.drawBitmap(words, wordsX, wordsY,paint);// 字
		canvas.drawBitmap(forward, forwardX, forwardY,paint);// 前进按钮
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		welcomeDrawThread.setFlag(true);
		welcomeDrawThread.start();// 启动刷帧线程
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		welcomeDrawThread.setFlag(false);// 停止刷帧线程
		while (retry) {
			try {
				welcomeDrawThread.join();// 等待刷帧线程结束
				retry = false;
			} catch (InterruptedException e) {// 不断地循环，直到等待的线程结束
			}
		}
	}

	public boolean onTouchEvent(MotionEvent event) {
		if (event.getX() > 144 && event.getX() < 176 && event.getY() > 380
				&& event.getY() < 412) {// 点击了前进按钮
			rushHourActivity.myHandler.sendEmptyMessage(1);// 向Activity的Handler发送消息
		}
		return super.onTouchEvent(event);
	}
}