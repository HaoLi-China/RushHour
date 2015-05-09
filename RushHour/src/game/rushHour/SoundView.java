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
	
	Bitmap on_off;//����ͼƬ
	Bitmap yellow;
	
	final int yellowX=85;
	final int yellowY1=228;
	final int yellowY2=253;
	final int on_offX=95;
	final int on_offY=203;
	
	int alpha=125;
	
	int state=0;//��ť״̬
	
	Paint paint;
	Paint paint1;
	
	public SoundView(RushHourActivity rushHourActivity) {// ������
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
		canvas.drawColor(Color.BLACK);// ���ƺ�ɫ����
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
		soundDrawThread.start();// ����ˢ֡�߳�
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		soundDrawThread.setFlag(false);// ֹͣˢ֡�߳�
		while (retry) {
			try {
				soundDrawThread.join();// �ȴ�ˢ֡�߳̽���
				retry = false;
			} catch (InterruptedException e) {// ���ϵ�ѭ����ֱ���ȴ����߳̽���
			}
		}
	}
	public boolean onTouchEvent(MotionEvent event) {
	if (event.getX() > 85 && event.getX() < 235 && event.getY() > 253
				&& event.getY() < 278&&state==0) {// �������/��ť
			rushHourActivity.myHandler.sendEmptyMessage(0);// ��Activity��Handler������Ϣ
			rushHourActivity.isSound=false;
		} 
	if (event.getX() > 85 && event.getX() < 235 && event.getY() > 253
			&& event.getY() < 278&&state==1) {// �������/��ť
		 state=0;
	} 
	if (event.getX() > 85 && event.getX() < 235 && event.getY() > 228
			&& event.getY() < 253&&state==1) {// �������/��ť
		rushHourActivity.myHandler.sendEmptyMessage(0);// ��Activity��Handler������Ϣ
		rushHourActivity.isSound=true;
	} 
	if (event.getX() > 85 && event.getX() < 235 && event.getY() > 228
			&& event.getY() < 253&&state==0) {// �������/��ť
		state=1;
	} 
		return super.onTouchEvent(event);
	}
}