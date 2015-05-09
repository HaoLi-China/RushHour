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
	Bitmap words;// ��
	Bitmap forward;// ǰ����ť
	
	final int bitX = 65;// ͼƬ��ʼ����
	final int bitY = 145;
	final int wordsX = 33;// �ֳ�ʼ����
	final int wordsY = 50;
	final int forwardX = 144;// ��ť�ĳ�ʼ����
	final int forwardY = 380;
	
	Paint paint;

	public WelcomeView(RushHourActivity rushHourActivity) {// ������
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
		canvas.drawBitmap(bit[i], bitX, bitY, paint);// ������Ϸ����ͼƬ
		canvas.drawBitmap(words, wordsX, wordsY,paint);// ��
		canvas.drawBitmap(forward, forwardX, forwardY,paint);// ǰ����ť
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		welcomeDrawThread.setFlag(true);
		welcomeDrawThread.start();// ����ˢ֡�߳�
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		welcomeDrawThread.setFlag(false);// ֹͣˢ֡�߳�
		while (retry) {
			try {
				welcomeDrawThread.join();// �ȴ�ˢ֡�߳̽���
				retry = false;
			} catch (InterruptedException e) {// ���ϵ�ѭ����ֱ���ȴ����߳̽���
			}
		}
	}

	public boolean onTouchEvent(MotionEvent event) {
		if (event.getX() > 144 && event.getX() < 176 && event.getY() > 380
				&& event.getY() < 412) {// �����ǰ����ť
			rushHourActivity.myHandler.sendEmptyMessage(1);// ��Activity��Handler������Ϣ
		}
		return super.onTouchEvent(event);
	}
}