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

	public AboutView(RushHourActivity rushHourActivity) {// ������
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
		aboutDrawThread.start();// ����ˢ֡�߳�
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		aboutDrawThread.setFlag(false);// ֹͣˢ֡�߳�
		while (retry) {
			try {
				aboutDrawThread.join();// �ȴ�ˢ֡�߳̽���
				retry = false;
			} catch (InterruptedException e) {// ���ϵ�ѭ����ֱ���ȴ����߳̽���
			}
		}
	}

	
	  public boolean onTouchEvent(MotionEvent event) { 
             if (event.getX() > 144 && event.getX() < 176
						&& event.getY() > 400 && event.getY() < 432) {// ����˷��ذ�ť
            	 rushHourActivity.myHandler.sendEmptyMessage(2);// ��Activity��Handler������Ϣ
				}
		  
		  return super.onTouchEvent(event); }
}