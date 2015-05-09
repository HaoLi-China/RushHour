package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class SetView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	SetDrawThread setDrawThread;
	
	Bitmap yellow;//���
	Bitmap on;//��״̬
	Bitmap off;//��״̬
	Bitmap back;// ���ذ�ť
	
	final int buttonX=80;
	final int buttonY=218;
	final int yellowX=85;
	final int yellowY=227;
	final int backX=144;
	final int backY=400;
	
	int alpha=125;
	
	Paint paint;
	Paint paint1;
	
	public SetView(RushHourActivity rushHourActivity) {// ������
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		getHolder().addCallback(this);
		setDrawThread = new SetDrawThread(this, getHolder());
		on = BitmapFactory.decodeResource(getResources(),R.drawable.on);
		off = BitmapFactory.decodeResource(getResources(),R.drawable.off);
		yellow = BitmapFactory.decodeResource(getResources(),R.drawable.yellow);
		back = BitmapFactory.decodeResource(getResources(),R.drawable.back);
		paint=new Paint();
		paint1=new Paint();
		paint1.setAlpha(alpha);
	}
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.BLACK);// ���ƺ�ɫ����
		if(rushHourActivity.isSound==true)
		canvas.drawBitmap(on, buttonX, buttonY, paint);
		if(rushHourActivity.isSound==false)
			canvas.drawBitmap(off, buttonX, buttonY, paint);
		canvas.drawBitmap(yellow,yellowX, yellowY, paint1);
		canvas.drawBitmap(back,backX, backY, paint);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		setDrawThread.setFlag(true);
		setDrawThread.start();// ����ˢ֡�߳�
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		setDrawThread.setFlag(false);// ֹͣˢ֡�߳�
		while (retry) {
			try {
				setDrawThread.join();// �ȴ�ˢ֡�߳̽���
				retry = false;
			} catch (InterruptedException e) {// ���ϵ�ѭ����ֱ���ȴ����߳̽���
			}
		}
	}
	public boolean onTouchEvent(MotionEvent event) {
	if (event.getX() > 80 && event.getX() < 239 && event.getY() > 218
				&& event.getY() < 262) {// ��������ֿ���/�رհ�ť
		if (rushHourActivity.isSound == true) {
			rushHourActivity.isSound = false;
			rushHourActivity.sound[0].pause();
		} 
		else {
			rushHourActivity.isSound = true;
			rushHourActivity.sound[0].start();
		}
		//rushHourActivity.setSound(0);
		} 
	if (event.getX() > 144 && event.getX() < 176 && event.getY() > 400
			&& event.getY() < 432) {// ����˷��ز˵���ť
		rushHourActivity.myHandler.sendEmptyMessage(6);// ��Activity��Handler������Ϣ
	} 
		return super.onTouchEvent(event);
	}
}