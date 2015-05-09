package game.rushHour;

/**
 * 
 * 该类为点击屏幕线程类
 * 
 */

public class TouchThread extends Thread {
	int t;
	int r;
	int sleep = 500;
	static boolean flag = true;
	RushHourActivity rushHourActivity;

	public TouchThread(int t, int r, RushHourActivity rushHourActivity) {
		this.t = t;
		this.r = r;
		this.rushHourActivity = rushHourActivity;
	}

	public void run() {
		if (flag) {

			if (r == 0 && t > 0) {
				flag = false;
				WarriorRunThread warriorRunThread = new WarriorRunThread(3,
						rushHourActivity, t, rushHourActivity.gameView.level);
				warriorRunThread.start();
			} else if (r == 0 && t < 0) {
				flag = false;
				WarriorRunThread warriorRunThread = new WarriorRunThread(4,
						rushHourActivity, -t, rushHourActivity.gameView.level);
				warriorRunThread.start();
			} else if (r > 0 && t == 0) {
				flag = false;
				WarriorRunThread warriorRunThread = new WarriorRunThread(1,
						rushHourActivity, r, rushHourActivity.gameView.level);
				warriorRunThread.start();
			} else if (r < 0 && t == 0) {
				flag = false;
				WarriorRunThread warriorRunThread = new WarriorRunThread(2,
						rushHourActivity, -r, rushHourActivity.gameView.level);
				warriorRunThread.start();
			}
		}
	}

	public void setFlag(boolean bool) {
		flag = bool;
	}
}