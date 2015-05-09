package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MenuView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	MenuDrawThread menuDrawThread = null;

	Bitmap bit[] = new Bitmap[4];
	Bitmap title;
	Bitmap about;
	Bitmap start;
	Bitmap set;
	Bitmap help;
	Bitmap exit;

	final int bitX=65;//����ͼƬ����
	final int bitY=145;
	final int titleX=70;//����ĳ�ʼ������
	final int titleY=40;//����ĳ�ʼ������
	final int menuButtonX=65;//�˵���ť�ĳ�ʼ������
	final int startY=145;
	final int aboutY=183;
	final int setY=221;
	final int helpY=259;
	final int exitY=297;
	
	Paint paint;
	Paint paint1;
	Paint paint2;
	Paint paint3;
	Paint paint4;
	Paint paint5;
	
	int state=0;
	
	int alpha1=255;
	int alpha2=125;
	
	public MenuView(RushHourActivity rushHourActivity) {// ������
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		getHolder().addCallback(this);
		menuDrawThread = new MenuDrawThread(this, getHolder());
		bit[0] = BitmapFactory
				.decodeResource(getResources(), R.drawable.back_1);
		bit[1] = BitmapFactory
				.decodeResource(getResources(), R.drawable.back_2);
		bit[2] = BitmapFactory
				.decodeResource(getResources(), R.drawable.back_3);
		bit[3] = BitmapFactory
				.decodeResource(getResources(), R.drawable.back_4);
		title = BitmapFactory
		.decodeResource(getResources(), R.drawable.title);
		about = BitmapFactory
		.decodeResource(getResources(), R.drawable.about);
		start = BitmapFactory
		.decodeResource(getResources(), R.drawable.start);
		set = BitmapFactory
		.decodeResource(getResources(), R.drawable.set);
		help = BitmapFactory
		.decodeResource(getResources(), R.drawable.help);
		exit = BitmapFactory
		.decodeResource(getResources(), R.drawable.exit);
		
		paint=new Paint();
		paint1=new Paint();
		paint1.setAlpha(alpha2);
		paint2=new Paint();
		paint3=new Paint();
		paint4=new Paint();
		paint5=new Paint();
	}

	protected void onDraw(Canvas canvas, int i) {
		canvas.drawBitmap(bit[i], bitX, bitY, paint);
		canvas.drawBitmap(title, titleX, titleY,paint);
		canvas.drawBitmap(start, menuButtonX, startY, paint1);
		canvas.drawBitmap(about, menuButtonX, aboutY, paint2);
		canvas.drawBitmap(set, menuButtonX, setY, paint3);
		canvas.drawBitmap(help, menuButtonX, helpY, paint4);
		canvas.drawBitmap(exit, menuButtonX, exitY, paint5);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		menuDrawThread.setFlag(true);
		menuDrawThread.start();// ����ˢ֡�߳�
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		menuDrawThread.setFlag(false);// ֹͣˢ֡�߳�
		while (retry) {
			try {
				menuDrawThread.join();// �ȴ�ˢ֡�߳̽���
				retry = false;
			} catch (InterruptedException e) {// ���ϵ�ѭ����ֱ���ȴ����߳̽���
			}
		}
	}

	
	  public boolean onTouchEvent(MotionEvent event) { 
		  if (event.getX() > 65 && event.getX() < 255 && event.getY() > 145
					&& event.getY() < 183&&state==0) {// ����˿�ʼ��Ϸ��ť
				rushHourActivity.myHandler.sendEmptyMessage(3);// ��Activity��Handler������Ϣ
			} 
		  else if (event.getX() > 65 && event.getX() < 255 && event.getY() > 145
					&& event.getY() < 183&&state!=0) {// ����˿�ʼ��Ϸ��ť
			  state=0;
				paint1.setAlpha(alpha2);
				paint2.setAlpha(alpha1);
				paint3.setAlpha(alpha1);
				paint4.setAlpha(alpha1);
				paint5.setAlpha(alpha1);
			} 
		  else  if (event.getX() > 65 && event.getX() < 255 && event.getY() > 183
					&& event.getY() < 221&&state==1) {// ����˹�����Ϸ��ť
				rushHourActivity.myHandler.sendEmptyMessage(8);// ��Activity��Handler������Ϣ
			} 
		  else  if (event.getX() > 65 && event.getX() < 255 && event.getY() > 183
					&& event.getY() < 221&&state!=1) {// ����˹�����Ϸ��ť
			    state=1;
	    	    paint1.setAlpha(alpha1);
				paint2.setAlpha(alpha2);
				paint3.setAlpha(alpha1);
				paint4.setAlpha(alpha1);
				paint5.setAlpha(alpha1);
			} 
	      
		  else if (event.getX() > 65 && event.getX() < 221
					&& event.getY() > 215 && event.getY() < 259&&state==2) {// �������Ϸ���ð�ť
				rushHourActivity.myHandler.sendEmptyMessage(4);// ��Activity��Handler������Ϣ
			}
		  else if (event.getX() > 65 && event.getX() < 221
					&& event.getY() > 215 && event.getY() < 259&&state!=2) {// �������Ϸ���ð�ť
			    state=2;
	    	    paint1.setAlpha(alpha1);
				paint2.setAlpha(alpha1);
				paint3.setAlpha(alpha2);
				paint4.setAlpha(alpha1);
				paint5.setAlpha(alpha1);
			} 
		  else if (event.getX() > 65 && event.getX() < 255
						&& event.getY() > 259 && event.getY() < 297&&state==3) {// �������Ϸ������ť
					rushHourActivity.myHandler.sendEmptyMessage(5);// ��Activity��Handler������Ϣ
				}
		  else if (event.getX() > 65 && event.getX() < 255
					&& event.getY() > 259 && event.getY() < 297&&state!=3) {// �������Ϸ������ť
			    state=3;
	    	    paint1.setAlpha(alpha1);
				paint2.setAlpha(alpha1);
				paint3.setAlpha(alpha1);
				paint4.setAlpha(alpha2);
				paint5.setAlpha(alpha1);
			}
		  else if (event.getX() > 65 && event.getX() < 255
						&& event.getY() > 297 && event.getY() < 335&&state==4) {// ������˳���Ϸ��ť
			  rushHourActivity.myHandler.sendEmptyMessage(18);// ��Activity��Handler������Ϣ
				}
		  else if (event.getX() > 65 && event.getX() < 255
					&& event.getY() > 297 && event.getY() < 335&&state!=4) {// ������˳���Ϸ��ť
			    state=4;
			    paint1.setAlpha(alpha1);
				paint2.setAlpha(alpha1);
				paint3.setAlpha(alpha1);
				paint4.setAlpha(alpha1);
				paint5.setAlpha(alpha2);
			}
		  
		  return super.onTouchEvent(event); }
}