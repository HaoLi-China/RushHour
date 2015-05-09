package game.rushHour;

import game.rushHour.RushHourActivity;

public class BackgroundViewGoThread extends Thread {
	
	int sleep = 200;// 睡眠的毫秒数
	private boolean flag = true;
	RushHourActivity rushHourActivity;// activity的引用

	public BackgroundViewGoThread(RushHourActivity rushHourActivity) {
		this.rushHourActivity = rushHourActivity;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public void run() {// 重写的run方法
		while (flag) {
			if (rushHourActivity.backgroundView.paper1X != 0){
				rushHourActivity.backgroundView.paper1X -= 2;
				rushHourActivity.backgroundView.paper2X += 2;
			}
			else {
					rushHourActivity.backgroundView.state=1;
					rushHourActivity.backgroundView.alpha+=2;
					if(rushHourActivity.backgroundView.alpha==255)
					 setFlag(false);
				}
						
			try {
				Thread.sleep(sleep);// 睡眠
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}