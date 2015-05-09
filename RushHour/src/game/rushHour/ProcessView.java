package game.rushHour;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
public class ProcessView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;//activity������
	private ProcessDrawThread processDrawThread;//ˢ֡���߳�
	Paint paint;//����
	Bitmap processLength;//����
	Bitmap rooms;//��������
	Bitmap trees;//ɭ��ħ��
	Bitmap water_city;//ˮ���Գ�

	int process = 0;//����
	int startX = 70;//������λ��
	int startY = 430;
	int backgroundX=72;
	int backgroundY=100;
    int level;//�ؿ���
	public ProcessView(RushHourActivity rushHourActivity, int level) {//������ 
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;//�õ�activity������
        getHolder().addCallback(this);
        this.processDrawThread = new ProcessDrawThread(getHolder(), this);//��ʼ���ػ��߳�
        this.level=level;
        initBitmap();//��ʼ��ͼƬ��Դ
	}
	public void initBitmap(){//��ʼ��ͼƬ��Դ�ķ���
		paint = new Paint();//��������
		
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
	public void onDraw(Canvas canvas){//�Լ�д�Ļ��Ʒ���
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
	public void surfaceCreated(SurfaceHolder holder) {//�����Ǳ�����
        this.processDrawThread.setFlag(true);//�����̱߳�־λ
        this.processDrawThread.start();//�����߳�
	}
	public void surfaceDestroyed(SurfaceHolder holder) {//�ݻ�ʱ������
        boolean retry = true;//ѭ����־λ
        processDrawThread.setFlag(false);//����ѭ����־λ
        while (retry) {
            try {
            	processDrawThread.join();//�ȴ��߳̽���
                retry = false;
            } 
            catch (InterruptedException e) {}//���ϵ�ѭ����ֱ��ˢ֡�߳̽���
        }
	}
	class ProcessDrawThread extends Thread{//ˢ֡�߳�
		private int span = 50;//˯��
		private SurfaceHolder surfaceHolder;
		private ProcessView processView;//processView����
		private boolean flag = false;//ѭ����־λ
        public ProcessDrawThread(SurfaceHolder surfaceHolder, ProcessView processView) {//������
            this.surfaceHolder = surfaceHolder;
            this.processView = processView;//�õ����ؽ���
        }
        public void setFlag(boolean flag) {//���ñ�־λ
        	this.flag = flag;
        }
		public void run() {
			Canvas c;//����
            while (this.flag) {//ѭ��
                c = null;
                try {
                	// �����������������ڴ�Ҫ��Ƚϸߵ�����£����������ҪΪnull
                    c = this.surfaceHolder.lockCanvas(null);
                    synchronized (this.surfaceHolder) {
                    	processView.onDraw(c);//���û��Ʒ���
                    }
                } finally {//ʹ��finally��䱣֤�������һ����ִ��
                    if (c != null) {
                    	//������Ļ��ʾ����
                        this.surfaceHolder.unlockCanvasAndPost(c);
                    }
                }
                if(processView.process ==80){
                	rushHourActivity.gameView.startWarrior();
                }
                if(processView.process >= 100){//���������ʱ
                processView.rushHourActivity.myHandler.sendEmptyMessage(17);//����activity����Handler��Ϣ
                }
                
                try{
                	Thread.sleep(span);//˯��ָ��������
                }
                catch(Exception e){//�����쳣��Ϣ
                	e.printStackTrace();//��ӡ�쳣��Ϣ
                }
            }
		}
	}
}