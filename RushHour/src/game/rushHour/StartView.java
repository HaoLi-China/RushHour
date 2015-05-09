package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class StartView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	StartDrawThread startDrawThread = null;

	Bitmap background1;//背景图片
	Bitmap touch1;//提示
	Bitmap touch2;//提示
	
	Bitmap rooms;//第一关进入界面背景图片
	Bitmap level1_door;//进入第一关门
	
	Bitmap trees;//第二关进入界面背景图片
	Bitmap level2_door1;//左门
	Bitmap level2_door2;//右门
	
	Bitmap water_city;//第三关进入界面背景图片
	Bitmap water[]=new Bitmap[2];//进入第三关门

	Bitmap choice;//关卡选择背景图片
	Bitmap level1;//第一关选择图标
	Bitmap level2;//第二关选择图标
	Bitmap level3;//第三关选择图标
	Bitmap right[]=new Bitmap[4];//勇士
	
	//胜利界面
	Bitmap background;//背景图片
	Bitmap main;// 进入主菜单图标
	Bitmap win;//胜利
	
    int level1X=35;
    int level2X=130;
    int level3X=225;
    int levelY=200;
    int choiceX=52;
    int choiceY=70;
    int backgroundX=72;
    int backgroundY=100;
    int touchX=108;
    int touchY=356;
    int level1_doorX=72;
    int level1_doorY=100;
    int level2_door1X=72;
    int level2_door2X=160;
    int level2_doorY=100;
    int backgroundX1=-248;
    int backgroundX2=248;
    int mainX = 97;//主菜单图标初始坐标
	int mainY = 400;
	int winX = -195;
	int winY = 200;
	int rightX=0;
	int rightY=400;
    	
    int waterX=120;
    int waterY=180;
    
    int state;
    int showState=0;
    
    int alpha=255;
    int alpha1=180;
    
    int i=0; 
    
    Paint paint;
    Paint paint1;
    Paint paint2;

	public StartView(RushHourActivity rushHourActivity,int state) {// 构造器
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		this.state=state;
		getHolder().addCallback(this);	
		startDrawThread = new StartDrawThread(this, getHolder());
		background1= BitmapFactory.decodeResource(getResources(), R.drawable.background1);
		touch1= BitmapFactory.decodeResource(getResources(), R.drawable.touch1);
		touch2= BitmapFactory.decodeResource(getResources(), R.drawable.touch2);
			choice = BitmapFactory.decodeResource(getResources(), R.drawable.choice);
			level1 = BitmapFactory.decodeResource(getResources(), R.drawable.level1);
			level2 = BitmapFactory.decodeResource(getResources(), R.drawable.level2);
			level3 = BitmapFactory.decodeResource(getResources(), R.drawable.level3);
			right[0]= BitmapFactory.decodeResource(getResources(), R.drawable.right1);
			right[1]= BitmapFactory.decodeResource(getResources(), R.drawable.right2);
			right[2]= BitmapFactory.decodeResource(getResources(), R.drawable.right2);
			right[3]= BitmapFactory.decodeResource(getResources(), R.drawable.right3);
			rooms =BitmapFactory.decodeResource(getResources(), R.drawable.rooms);
			level1_door=BitmapFactory.decodeResource(getResources(), R.drawable.level1_door);
			trees = BitmapFactory.decodeResource(getResources(), R.drawable.trees);
			level2_door1 = BitmapFactory.decodeResource(getResources(), R.drawable.level2_door1);
			level2_door2 = BitmapFactory.decodeResource(getResources(), R.drawable.level2_door2);
			water_city = BitmapFactory.decodeResource(getResources(), R.drawable.water_city);
			water[0]= BitmapFactory.decodeResource(getResources(), R.drawable.water1);
			water[1]= BitmapFactory.decodeResource(getResources(), R.drawable.water2);
			background = BitmapFactory.decodeResource(getResources(),
					R.drawable.background);
			main = BitmapFactory.decodeResource(getResources(),
					R.drawable.main);
			win = BitmapFactory.decodeResource(getResources(),
					R.drawable.win);
			if(rushHourActivity.isSound==true&&state!=0&&state!=4){
				rushHourActivity.sound[state].start();
			}
			
			paint=new Paint();
			paint1=new Paint();
			paint2=new Paint();
			paint2.setAlpha(alpha1);
		}
	protected void onDraw(Canvas canvas) {
		switch(state){
		case 0:
			canvas.drawBitmap(background1, 0, 0, paint);
			canvas.drawBitmap(choice, choiceX, choiceY, paint);
			canvas.drawBitmap(level1, level1X, levelY, paint);
			canvas.drawBitmap(level2, level2X, levelY, paint);
			canvas.drawBitmap(level3, level3X, levelY, paint);
			canvas.drawBitmap(right[i], rightX, rightY, paint);
			i+=1;
			if(i==4){
			i=0;
			}
			rightX+=8;
			if(rightX==320){
			rightX=0;	
			}
			break;
		case 1:
			canvas.drawBitmap(background1, 0, 0, paint);
			canvas.drawBitmap(rooms, backgroundX, backgroundY, paint);
			if(showState==0){
				canvas.drawBitmap(touch1, touchX, touchY, paint);
				showState=1;
				}
				else if(showState==1){
					canvas.drawBitmap(touch2, touchX, touchY, paint);
					showState=0;
					}
			canvas.drawBitmap(level1_door, level1_doorX, level1_doorY, paint1);
			paint1.setAlpha(alpha);
			break;
		case 2:
			canvas.drawBitmap(background1, 0, 0, paint);
		canvas.drawBitmap(trees,backgroundX, backgroundY, paint);
		if(showState==0){
			canvas.drawBitmap(touch1, touchX, touchY, paint);
			showState=1;
			}
			else if(showState==1){
				canvas.drawBitmap(touch2, touchX, touchY, paint);
				showState=0;
				}
		canvas.drawBitmap(level2_door1, level2_door1X, level2_doorY, paint);
		canvas.drawBitmap(level2_door2, level2_door2X, level2_doorY, paint);
		canvas.drawBitmap(background1, backgroundX1, 0, paint);
		canvas.drawBitmap(background1, backgroundX2, 0, paint);
		break;
		case 3:
			canvas.drawBitmap(water_city, backgroundX, backgroundY, paint);
			break;	
		case 4:
			canvas.drawBitmap(background, 0, 0, paint);//背景图片
			paint1.setAlpha(alpha);
			canvas.drawBitmap(background1, 0, 0, paint1);//背景图片1
			canvas.drawBitmap(main, mainX, mainY, paint);// 进入主菜单图标
			canvas.drawBitmap(win, winX, winY, paint2);// 进入主菜单图标
			break;
			
	}
	}
	protected void onDraw(Canvas canvas,int i) {
		canvas.drawBitmap(background1, 0, 0, paint);
		canvas.drawBitmap(water_city, backgroundX, backgroundY, paint);
		if(showState==0){
			canvas.drawBitmap(touch1, touchX, touchY, paint);
			showState=1;
			}
			else if(showState==1){
				canvas.drawBitmap(touch2, touchX, touchY, paint);
				showState=0;
				}
		canvas.drawBitmap(water[i], waterX, waterY, paint);
	}
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		startDrawThread.setFlag(true);
		startDrawThread.start();// 启动刷帧线程
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		startDrawThread.setFlag(false);// 停止刷帧线程
		while (retry) {
			try {
				startDrawThread.join();// 等待刷帧线程结束
				retry = false;
			} catch (InterruptedException e) {// 不断地循环，直到等待的线程结束
			}
		}
	}

	  public boolean onTouchEvent(MotionEvent event) {
		     if(state==1){
				 rushHourActivity.myHandler.sendEmptyMessage(11);// 向Activity的Handler发送消息	   
			 }
			 else if(state==2){
				 rushHourActivity.myHandler.sendEmptyMessage(12);// 向Activity的Handler发送消息	   
			 }
			 else if(state==3){
				 rushHourActivity.myHandler.sendEmptyMessage(13);// 向Activity的Handler发送消息	   
			 }
	     else if(state==0){
		 if (event.getX() > 35 && event.getX() < 95
					&& event.getY() > 200 && event.getY() < 293) {
		     state=1; 
		     if(rushHourActivity.isSound==true)
		     rushHourActivity.sound[1].start();
		 }
		 if (event.getX() > 130 && event.getX() < 190
					&& event.getY() > 200 && event.getY() < 293) {
			 state=2;  
			 if(rushHourActivity.isSound==true)
			 rushHourActivity.sound[2].start();
		 }
		 if (event.getX() > 225 && event.getX() < 285
					&& event.getY() > 200 && event.getY() < 293) {
			 state=3; 
			 if(rushHourActivity.isSound==true)
			 rushHourActivity.sound[3].start();
		 }
		 }
	     else if(state==4){
	    	 if (event.getX() > 97 && event.getX() < 223 && event.getY() > 400
	 				&& event.getY() < 460) {// 点击了主菜单按钮
	 			rushHourActivity.myHandler.sendEmptyMessage(16);// 向Activity的Handler发送消息
	 		} 
	     }
		  return super.onTouchEvent(event); 
		  }
}
