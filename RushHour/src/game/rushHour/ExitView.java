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
	
	Bitmap exit1;//�˳���ʾ
	Bitmap yes[]=new Bitmap[3];//��
	Bitmap no[]=new Bitmap[3];//��

	final int exit1X=74;
	final int exit1Y=200;
	final int yesX=32;
	final int yesY=280;
	final int noX=240;
	final int noY=280;

	Paint paint;

	
	public ExitView(RushHourActivity rushHourActivity) {// ������
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
		canvas.drawColor(Color.BLACK);// ���ƺ�ɫ����
		canvas.drawBitmap(exit1, exit1X, exit1Y, paint);
	    canvas.drawBitmap(yes[i],yesX, yesY, paint);
		canvas.drawBitmap(no[i],noX, noY, paint);
		
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		exitDrawThread.setFlag(true);
		exitDrawThread.start();// ����ˢ֡�߳�
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		exitDrawThread.setFlag(false);// ֹͣˢ֡�߳�
		while (retry) {
			try {
				exitDrawThread.join();// �ȴ�ˢ֡�߳̽���
				retry = false;
			} catch (InterruptedException e) {// ���ϵ�ѭ����ֱ���ȴ����߳̽���
			}
		}
	}
	public boolean onTouchEvent(MotionEvent event) {
	if (event.getX() > 32 && event.getX() < 80 && event.getY() > 280
				&& event.getY() < 328) {// ������ǰ�ť
		System.exit(0);//�˳���Ϸ
		} 
	if (event.getX() > 240 && event.getX() < 288 && event.getY() > 280
			&& event.getY() < 328) {// ����˷�ť
		rushHourActivity.myHandler.sendEmptyMessage(19);// ��Activity��Handler������Ϣ
	} 
		return super.onTouchEvent(event);
	}
}