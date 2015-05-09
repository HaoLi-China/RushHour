package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class BackgroundView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	BackgroundDrawThread backgroundDrawThread = null;

	Bitmap paper1;// ��ֽ1
	Bitmap paper2;// ��ֽ2
	Bitmap background;//����ͼƬ
	Bitmap background1;//����ͼƬ
	Bitmap main;// �������˵�ͼ��

	int paper1X = 70;// ��ֽ1��ʼ����
	int paper1Y = 110;
	int paper2X = 90;// ��ֽ2��ʼ����
	int paper2Y = 110;
	int mainX = 97;//���˵�ͼ���ʼ����
	int mainY = 400;
	int chX=40;//��һ����λ��
	int chY=155;
	int paperHeight=210;//��ֽ�ĸ߶�
	int charLine=1;//������
	int charList=1;//������
	int line;//��
	int list;//��
	
	int state=0;
	
	int alpha=1;
	
	Paint paint;
	Paint paint1;
	
	float textSize = 20f;//����Ĵ�С
	
	char [] ch={'��','��','��','��','��','ǰ','��','��','��','��','��','ͳ','��','��','��','��','��','��',
			'��','Ϊ','��','��','��','��','��','��','��','��','��','��','��','��','ʿ','��','��','ʼ','��',
			'��','Ѱ','��','��','˵','��','��','ħ','��','ʯ','��','��','Ҫ','��','��','ħ','��','ʯ','��',
			'��','��','��','��','��','��','��','��','��','��','��','��','��','ɭ','��','ħ','��','��','ˮ',
			'��','��','��','��','��','��','��','��','��','��','��','ʿ','��','��','��','ʧ','ȥ','��','��',
			'��','��','��','��','��','��','��','��','��','��','��','��','��','��','��','��'};
	public BackgroundView(RushHourActivity rushHourActivity) {// ������
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		getHolder().addCallback(this);
		backgroundDrawThread = new BackgroundDrawThread(this, getHolder());
		
		paper1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.paper1);
		paper2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.paper2);
		background = BitmapFactory.decodeResource(getResources(),
				R.drawable.background);
		background1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.background1);
		main = BitmapFactory.decodeResource(getResources(),
				R.drawable.main);
		paint=new Paint();
		paint1=new Paint();
	}

	protected void onDraw(Canvas canvas) {
		switch(state){
		case 0:
		canvas.drawBitmap(background, 0, 0, paint);//����ͼƬ
		canvas.drawBitmap(paper1, paper1X, paper1Y, paint);// ��ֽ1
		canvas.drawBitmap(paper2, paper2X, paper2Y, paint);// ��ֽ2
     	canvas.drawBitmap(main, mainX, mainY, paint);// �������˵�ͼ��
		break;
		case 1:
			canvas.drawBitmap(background, 0, 0, paint);//����ͼƬ
			paint1.setAlpha(alpha);
			canvas.drawBitmap(background1, 0, 0, paint1);//����ͼƬ1
			canvas.drawBitmap(paper1, paper1X, paper1Y, paint);// ��ֽ1
			canvas.drawBitmap(paper2, paper2X, paper2Y, paint);// ��ֽ2
	     	canvas.drawBitmap(main, mainX, mainY, paint);// �������˵�ͼ��
			
			//״̬����ʾ����
			paint.setTextSize(textSize);			//���������С
			paint.setTypeface(Typeface.DEFAULT_BOLD);	//���ô���
			paint.setAntiAlias(true);					//���ÿ����
			int line=(int) (paperHeight/textSize);
			int list=ch.length/charLine;
			if(charList <=list ){
			for(int i=0 ;i<charLine+line*charList;i++){
			canvas.drawText(ch[i]+"", chX+(i/line)*textSize, chY+(i%line)*textSize, paint);
			}	
				charLine++;
				if(charLine==line){
					charLine=1;
					charList++;
				}	
			}
			else
				backgroundDrawThread.setFlag(false);
			break;			
	}
	}
	
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		backgroundDrawThread.setFlag(true);
		backgroundDrawThread.start();// ����ˢ֡�߳�
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		backgroundDrawThread.setFlag(false);// ֹͣˢ֡�߳�
		while (retry) {
			try {
				backgroundDrawThread.join();// �ȴ�ˢ֡�߳̽���
				retry = false;
			} catch (InterruptedException e) {// ���ϵ�ѭ����ֱ���ȴ����߳̽���
			}
		}
	}
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getX() > 97 && event.getX() < 223 && event.getY() > 400
				&& event.getY() < 460) {// ��������˵���ť
			rushHourActivity.myHandler.sendEmptyMessage(7);// ��Activity��Handler������Ϣ
		} 
		return super.onTouchEvent(event);
	}
}