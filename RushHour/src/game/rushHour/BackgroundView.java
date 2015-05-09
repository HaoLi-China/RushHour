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

	Bitmap paper1;// 宣纸1
	Bitmap paper2;// 宣纸2
	Bitmap background;//背景图片
	Bitmap background1;//背景图片
	Bitmap main;// 进入主菜单图标

	int paper1X = 70;// 宣纸1初始坐标
	int paper1Y = 110;
	int paper2X = 90;// 宣纸2初始坐标
	int paper2Y = 110;
	int mainX = 97;//主菜单图标初始坐标
	int mainY = 400;
	int chX=40;//第一个字位置
	int chY=155;
	int paperHeight=210;//宣纸的高度
	int charLine=1;//字行数
	int charList=1;//字列数
	int line;//行
	int list;//列
	
	int state=0;
	
	int alpha=1;
	
	Paint paint;
	Paint paint1;
	
	float textSize = 20f;//字体的大小
	
	char [] ch={'很','久','很','久','以','前','，','黑','暗','力','量','统','治','了','整','个','世','界',
			'。','为','了','打','败','黑','暗','的','力','量','，','无','数','勇','士','们','开','始','苦',
			'苦','寻','找','传','说','中','的','魔','法','石','，','而','要','找','到','魔','法','石','必',
			'须','闯','过','三','个','关','卡','，','死','亡','大','厅','，','森','林','魔','域','和','水',
			'域','迷','城','。','有','许','许','多','多','的','勇','士','在','这','里','失','去','生','命',
			'，','现','在','拯','救','世','界','的','任','务','就','交','给','你','了','。'};
	public BackgroundView(RushHourActivity rushHourActivity) {// 构造器
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
		canvas.drawBitmap(background, 0, 0, paint);//背景图片
		canvas.drawBitmap(paper1, paper1X, paper1Y, paint);// 宣纸1
		canvas.drawBitmap(paper2, paper2X, paper2Y, paint);// 宣纸2
     	canvas.drawBitmap(main, mainX, mainY, paint);// 进入主菜单图标
		break;
		case 1:
			canvas.drawBitmap(background, 0, 0, paint);//背景图片
			paint1.setAlpha(alpha);
			canvas.drawBitmap(background1, 0, 0, paint1);//背景图片1
			canvas.drawBitmap(paper1, paper1X, paper1Y, paint);// 宣纸1
			canvas.drawBitmap(paper2, paper2X, paper2Y, paint);// 宣纸2
	     	canvas.drawBitmap(main, mainX, mainY, paint);// 进入主菜单图标
			
			//状态：显示文字
			paint.setTextSize(textSize);			//设置字体大小
			paint.setTypeface(Typeface.DEFAULT_BOLD);	//设置粗体
			paint.setAntiAlias(true);					//设置抗锯齿
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
		backgroundDrawThread.start();// 启动刷帧线程
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		backgroundDrawThread.setFlag(false);// 停止刷帧线程
		while (retry) {
			try {
				backgroundDrawThread.join();// 等待刷帧线程结束
				retry = false;
			} catch (InterruptedException e) {// 不断地循环，直到等待的线程结束
			}
		}
	}
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getX() > 97 && event.getX() < 223 && event.getY() > 400
				&& event.getY() < 460) {// 点击了主菜单按钮
			rushHourActivity.myHandler.sendEmptyMessage(7);// 向Activity的Handler发送消息
		} 
		return super.onTouchEvent(event);
	}
}