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
	
	Bitmap background;// ����ͼƬ
	Bitmap helpView1;// ��������
	Bitmap helpView2;// ��������
	Bitmap back;// ���ذ�ť
	Bitmap up;// ���ϰ�ť
	Bitmap down;// ���°�ť
	
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

	public HelpView(RushHourActivity rushHourActivity) {// ������
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
		canvas.drawBitmap(background, 0, 0,paint);//����ͼƬ
		if(state==0)
		canvas.drawBitmap(helpView1, helpViewX, helpViewY,paint1);//��������
		if(state==1)
		canvas.drawBitmap(helpView2, helpViewX, helpViewY,paint1);//��������
		canvas.drawBitmap(back, backX, backY,paint);// ���ذ�ť
		canvas.drawBitmap(up, buttonX, upY,paint);// ���ϰ�ť
		canvas.drawBitmap(down, buttonX, downY,paint);// ���°�ť
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		helpDrawThread.setFlag(true);
		helpDrawThread.start();// ����ˢ֡�߳�
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		helpDrawThread.setFlag(false);// ֹͣˢ֡�߳�
		while (retry) {
			try {
				helpDrawThread.join();// �ȴ�ˢ֡�߳̽���
				retry = false;
			} catch (InterruptedException e) {// ���ϵ�ѭ����ֱ���ȴ����߳̽���
			}
		}
	}
	public boolean onTouchEvent(MotionEvent event) {
	if (event.getX() > 144 && event.getX() < 176 && event.getY() > 400
				&& event.getY() < 432) {// ����˷��ز˵���ť
			rushHourActivity.myHandler.sendEmptyMessage(2);// ��Activity��Handler������Ϣ
		} 
	else if (event.getX() > 147 && event.getX() < 173 && event.getY() > 106
			&& event.getY() < 122) {// ��������ϲ˵���ť
		state=0;
	} 
	else if (event.getX() > 147 && event.getX() < 173 && event.getY() > 358
			&& event.getY() < 374) {// ��������²˵���ť
		state=1;
	} 
		return super.onTouchEvent(event);
	}
}