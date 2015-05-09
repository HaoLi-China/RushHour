package game.rushHour;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
public class ProcessView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;//activity的引用
	private ProcessDrawThread processDrawThread;//刷帧的线程
	Paint paint;//画笔
	Bitmap processLength;//加载
	Bitmap rooms;//死亡大厅
	Bitmap trees;//森林魔域
	Bitmap water_city;//水域迷城

	int process = 0;//进度
	int startX = 70;//进度条位置
	int startY = 430;
	int backgroundX=72;
	int backgroundY=100;
    int level;//关卡数
	public ProcessView(RushHourActivity rushHourActivity, int level) {//构造器 
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;//得到activity的引用
        getHolder().addCallback(this);
        this.processDrawThread = new ProcessDrawThread(getHolder(), this);//初始化重绘线程
        this.level=level;
        initBitmap();//初始化图片资源
	}
	public void initBitmap(){//初始化图片资源的方法
		paint = new Paint();//创建画笔
		
		switch(level){
		case 1:
			rooms = BitmapFactory.decodeResource(getResources(), R.drawable.rooms);
			break;
		case 2:
			trees = BitmapFactory.decodeResource(getResources(), R.drawable.trees);
			break;
		case 3:
			water_city = BitmapFactory.decodeResource(getResources(), R.drawable.water_city);
			break;
		}
		processLength = BitmapFactory.decodeResource(getResources(), R.drawable.time);
	}
	public void onDraw(Canvas canvas){//自己写的绘制方法
		switch(level){
	case 1:
		canvas.drawBitmap(rooms, backgroundX, backgroundY, paint);
		break;
	case 2:
		canvas.drawBitmap(trees, backgroundX, backgroundY, paint);
		break;
	case 3:
		canvas.drawBitmap(water_city, backgroundX, backgroundY, paint);
		break;
		}
		canvas.drawBitmap(processLength, startX, startY, paint);
		canvas.drawRect(startX+process*((float)processLength.getWidth()/100), startY, startX+processLength.getWidth(), startY+processLength.getHeight(), paint);
		
	}
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}
	public void surfaceCreated(SurfaceHolder holder) {//创建是被调用
        this.processDrawThread.setFlag(true);//设置线程标志位
        this.processDrawThread.start();//启动线程
	}
	public void surfaceDestroyed(SurfaceHolder holder) {//摧毁时被调用
        boolean retry = true;//循环标志位
        processDrawThread.setFlag(false);//设置循环标志位
        while (retry) {
            try {
            	processDrawThread.join();//等待线程结束
                retry = false;
            } 
            catch (InterruptedException e) {}//不断地循环，直到刷帧线程结束
        }
	}
	class ProcessDrawThread extends Thread{//刷帧线程
		private int span = 50;//睡眠
		private SurfaceHolder surfaceHolder;
		private ProcessView processView;//processView引用
		private boolean flag = false;//循环标志位
        public ProcessDrawThread(SurfaceHolder surfaceHolder, ProcessView processView) {//构造器
            this.surfaceHolder = surfaceHolder;
            this.processView = processView;//得到加载界面
        }
        public void setFlag(boolean flag) {//设置标志位
        	this.flag = flag;
        }
		public void run() {
			Canvas c;//画布
            while (this.flag) {//循环
                c = null;
                try {
                	// 锁定整个画布，在内存要求比较高的情况下，建议参数不要为null
                    c = this.surfaceHolder.lockCanvas(null);
                    synchronized (this.surfaceHolder) {
                    	processView.onDraw(c);//调用绘制方法
                    }
                } finally {//使用finally语句保证下面代码一定被执行
                    if (c != null) {
                    	//更新屏幕显示内容
                        this.surfaceHolder.unlockCanvasAndPost(c);
                    }
                }
                if(processView.process ==80){
                	rushHourActivity.gameView.startWarrior();
                }
                if(processView.process >= 100){//当加载完成时
                processView.rushHourActivity.myHandler.sendEmptyMessage(17);//向主activity发送Handler消息
                }
                
                try{
                	Thread.sleep(span);//睡眠指定毫秒数
                }
                catch(Exception e){//捕获异常信息
                	e.printStackTrace();//打印异常信息
                }
            }
		}
	}
}