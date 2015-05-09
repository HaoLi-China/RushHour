package game.rushHour;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
public class GameDrawThread extends Thread{
	private int sleep = 100;//˯�ߵĺ�����
	private boolean flag = true;//ѭ�����λ
	GameView gameView;//��Ϸ���������
	SurfaceHolder surfaceHolder = null;	
	public GameDrawThread(GameView gameView,SurfaceHolder surfaceHolder){//������
		this.gameView = gameView;
		this.surfaceHolder = surfaceHolder;
	}
	public void run(){
		Canvas c;//����
		while(flag){
         
			c = null;
			try {
				// �����������������ڴ�Ҫ��Ƚϸߵ�����£����������ҪΪnull
			    c = surfaceHolder.lockCanvas(null);
			    synchronized (this.surfaceHolder) {
			    	try{
			    		gameView.title1X++;
			    		if(gameView.title1X>=300){
			    		  gameView.title1X=-500;
			    		}
			    		gameView.onDraw(c);
			    		
			    	}
			    	catch(Exception e){}
			    }
			} finally {
			    if (c != null) {
			    	//������Ļ��ʾ����
			        surfaceHolder.unlockCanvasAndPost(c);
			    }
			}
			try{
				Thread.sleep(sleep);//˯��sleepSpan����
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

    public void setFlag(boolean flag) {//����ѭ�����
    	this.flag = flag;
    }	
}