package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * 该类为勇士类 对勇士做了封装 记录了勇士的位置和坐标以及当前的状态
 * 
 */
public class Warrior {
	int i;
	int j;// 勇士在地图上的位置坐标
	Bitmap man;// 人物图片
	int X;
	int Y;// 当前勇士在屏幕上的位置
	
	boolean isRun = false;// 勇士是否正在行走
	Integer[] manUpID1 = new Integer[]// 循环的图片ID
	{ R.drawable.up1, R.drawable.up2, R.drawable.up3, R.drawable.up4 };
	Integer[] manUpID2 = new Integer[]// 循环的图片ID
	{ R.drawable.car_up, R.drawable.car_up, R.drawable.car_up,
			R.drawable.car_up };
	Integer[] manUpID3 = new Integer[]// 循环的图片ID
	{ R.drawable.boat_up, R.drawable.boat_up, R.drawable.boat_up,
			R.drawable.boat_up };
	Integer[] manDownID1 = new Integer[]// 循环的图片ID
	{ R.drawable.down1, R.drawable.down2, R.drawable.down3, R.drawable.down4 };
	Integer[] manDownID2 = new Integer[]// 循环的图片ID
	{ R.drawable.car_down, R.drawable.car_down, R.drawable.car_down,
			R.drawable.car_down };
	Integer[] manDownID3 = new Integer[]// 循环的图片ID
	{ R.drawable.boat_down, R.drawable.boat_down, R.drawable.boat_down,
			R.drawable.boat_down };
	Integer[] manLeftID1 = new Integer[]// 循环的图片ID
	{ R.drawable.left1, R.drawable.left2, R.drawable.left3, R.drawable.left4 };
	Integer[] manLeftID2 = new Integer[]// 循环的图片ID
	{ R.drawable.car_left, R.drawable.car_left, R.drawable.car_left,
			R.drawable.car_left };
	Integer[] manLeftID3 = new Integer[]// 循环的图片ID
	{ R.drawable.boat_left, R.drawable.boat_left, R.drawable.boat_left,
			R.drawable.boat_left };
	Integer[] manRightID1 = new Integer[]// 循环的图片ID
	{ R.drawable.right1, R.drawable.right2, R.drawable.right3,
			R.drawable.right4 };
	Integer[] manRightID2 = new Integer[]// 循环的图片ID
	{ R.drawable.car_right, R.drawable.car_right, R.drawable.car_right,
			R.drawable.car_right };
	Integer[] manRightID3 = new Integer[]// 循环的图片ID
	{ R.drawable.boat_right, R.drawable.boat_right, R.drawable.boat_right,
			R.drawable.boat_right };

	Bitmap manUp[];// 向上的走路的图片
	Bitmap manDown[];// 向下的走路的图片
	Bitmap manLeft[];// 向左的走路的图片
	Bitmap manRight[];// 向右的走路的图片
	Bitmap carUp[];// 向上的行驶的图片
	Bitmap carDown[];// 向下的行驶的图片
	Bitmap carLeft[];// 向左的行驶的图片
	Bitmap carRight[];// 向右的行驶的图片
	Bitmap boatUp[];// 向上的行驶的图片
	Bitmap boatDown[];// 向下的行驶的图片
	Bitmap boatLeft[];// 向左的行驶的图片
	Bitmap boatRight[];// 向右的行驶的图片

	RushHourActivity rushHourActivity;// Activity的引用

	public Warrior(RushHourActivity rushHourActivity, int level) {// 构造器
		this.rushHourActivity = rushHourActivity;
		if (level == 1) {
			i = 25;//25;
			j =27;// 27;
		}
		if (level == 2) {
			i = 28;// 28;
			j = 24;// 24;
		}
		if (level == 3) {
			i = 2;//2;
			j = 0;//0;
		}
		if (rushHourActivity.gameView.warriorState == 0) {
			X = rushHourActivity.gameView.initX + 32 * j;
			Y = rushHourActivity.gameView.initY + 32 * i;
			man = BitmapFactory.decodeResource(rushHourActivity.getResources(),
					R.drawable.left4);// 初始的图片
		}
		if (rushHourActivity.gameView.warriorState == 1) {
			X = rushHourActivity.gameView.initX + 32 * j;
			Y = rushHourActivity.gameView.initY + 32 * i;
			man = BitmapFactory.decodeResource(rushHourActivity.getResources(),
					R.drawable.car_left);// 初始的图片
		}
		this.initBitmap();// 初始化所有的图片
	}

	public void initBitmap() {// 初始化所有的图片
		manUp = new Bitmap[manUpID1.length];// 勇士
		manDown = new Bitmap[manDownID1.length];
		manLeft = new Bitmap[manLeftID1.length];
		manRight = new Bitmap[manRightID1.length];
		carUp = new Bitmap[manUpID2.length];// 车
		carDown = new Bitmap[manDownID2.length];
		carLeft = new Bitmap[manLeftID2.length];
		carRight = new Bitmap[manRightID2.length];
		boatUp = new Bitmap[manUpID3.length];// 船
		boatDown = new Bitmap[manDownID3.length];
		boatLeft = new Bitmap[manLeftID3.length];
		boatRight = new Bitmap[manRightID3.length];

		for (int i = 0; i < manUpID1.length; i++) {
			manUp[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manUpID1[i]);
		}
		for (int i = 0; i < manDownID1.length; i++) {
			manDown[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manDownID1[i]);
		}
		for (int i = 0; i < manLeftID1.length; i++) {
			manLeft[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manLeftID1[i]);
		}
		for (int i = 0; i < manRightID1.length; i++) {
			manRight[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manRightID1[i]);
		}

		for (int i = 0; i < manUpID2.length; i++) {
			carUp[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manUpID2[i]);
		}
		for (int i = 0; i < manDownID2.length; i++) {
			carDown[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manDownID2[i]);
		}
		for (int i = 0; i < manLeftID2.length; i++) {
			carLeft[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manLeftID2[i]);
		}
		for (int i = 0; i < manRightID2.length; i++) {
			carRight[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manRightID2[i]);
		}

		for (int i = 0; i < manUpID3.length; i++) {
			boatUp[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manUpID3[i]);
		}
		for (int i = 0; i < manDownID3.length; i++) {
			boatDown[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manDownID3[i]);
		}
		for (int i = 0; i < manLeftID3.length; i++) {
			boatLeft[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manLeftID3[i]);
		}
		for (int i = 0; i < manRightID3.length; i++) {
			boatRight[i] = BitmapFactory.decodeResource(rushHourActivity
					.getResources(), manRightID3[i]);
		}
	}
	
    //绘制自身
	public void drawMySelf(Canvas canvas, Paint paint) {// 绘制方法
		if (this.isRun) {
			canvas.drawBitmap(man, X, Y-18, paint);
		} else {

			X = rushHourActivity.gameView.initX + 32 * j;
			Y = rushHourActivity.gameView.initY + 32 * i;
			canvas.drawBitmap(man, X, Y-18, paint);

		}
	}
}
