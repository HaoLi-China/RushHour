package game.rushHour;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * 
 * ����Ϊ��ʿ�� ����ʿ���˷�װ ��¼����ʿ��λ�ú������Լ���ǰ��״̬
 * 
 */
public class Warrior {
	int i;
	int j;// ��ʿ�ڵ�ͼ�ϵ�λ������
	Bitmap man;// ����ͼƬ
	int X;
	int Y;// ��ǰ��ʿ����Ļ�ϵ�λ��
	
	boolean isRun = false;// ��ʿ�Ƿ���������
	Integer[] manUpID1 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.up1, R.drawable.up2, R.drawable.up3, R.drawable.up4 };
	Integer[] manUpID2 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.car_up, R.drawable.car_up, R.drawable.car_up,
			R.drawable.car_up };
	Integer[] manUpID3 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.boat_up, R.drawable.boat_up, R.drawable.boat_up,
			R.drawable.boat_up };
	Integer[] manDownID1 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.down1, R.drawable.down2, R.drawable.down3, R.drawable.down4 };
	Integer[] manDownID2 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.car_down, R.drawable.car_down, R.drawable.car_down,
			R.drawable.car_down };
	Integer[] manDownID3 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.boat_down, R.drawable.boat_down, R.drawable.boat_down,
			R.drawable.boat_down };
	Integer[] manLeftID1 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.left1, R.drawable.left2, R.drawable.left3, R.drawable.left4 };
	Integer[] manLeftID2 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.car_left, R.drawable.car_left, R.drawable.car_left,
			R.drawable.car_left };
	Integer[] manLeftID3 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.boat_left, R.drawable.boat_left, R.drawable.boat_left,
			R.drawable.boat_left };
	Integer[] manRightID1 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.right1, R.drawable.right2, R.drawable.right3,
			R.drawable.right4 };
	Integer[] manRightID2 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.car_right, R.drawable.car_right, R.drawable.car_right,
			R.drawable.car_right };
	Integer[] manRightID3 = new Integer[]// ѭ����ͼƬID
	{ R.drawable.boat_right, R.drawable.boat_right, R.drawable.boat_right,
			R.drawable.boat_right };

	Bitmap manUp[];// ���ϵ���·��ͼƬ
	Bitmap manDown[];// ���µ���·��ͼƬ
	Bitmap manLeft[];// �������·��ͼƬ
	Bitmap manRight[];// ���ҵ���·��ͼƬ
	Bitmap carUp[];// ���ϵ���ʻ��ͼƬ
	Bitmap carDown[];// ���µ���ʻ��ͼƬ
	Bitmap carLeft[];// �������ʻ��ͼƬ
	Bitmap carRight[];// ���ҵ���ʻ��ͼƬ
	Bitmap boatUp[];// ���ϵ���ʻ��ͼƬ
	Bitmap boatDown[];// ���µ���ʻ��ͼƬ
	Bitmap boatLeft[];// �������ʻ��ͼƬ
	Bitmap boatRight[];// ���ҵ���ʻ��ͼƬ

	RushHourActivity rushHourActivity;// Activity������

	public Warrior(RushHourActivity rushHourActivity, int level) {// ������
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
					R.drawable.left4);// ��ʼ��ͼƬ
		}
		if (rushHourActivity.gameView.warriorState == 1) {
			X = rushHourActivity.gameView.initX + 32 * j;
			Y = rushHourActivity.gameView.initY + 32 * i;
			man = BitmapFactory.decodeResource(rushHourActivity.getResources(),
					R.drawable.car_left);// ��ʼ��ͼƬ
		}
		this.initBitmap();// ��ʼ�����е�ͼƬ
	}

	public void initBitmap() {// ��ʼ�����е�ͼƬ
		manUp = new Bitmap[manUpID1.length];// ��ʿ
		manDown = new Bitmap[manDownID1.length];
		manLeft = new Bitmap[manLeftID1.length];
		manRight = new Bitmap[manRightID1.length];
		carUp = new Bitmap[manUpID2.length];// ��
		carDown = new Bitmap[manDownID2.length];
		carLeft = new Bitmap[manLeftID2.length];
		carRight = new Bitmap[manRightID2.length];
		boatUp = new Bitmap[manUpID3.length];// ��
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
	
    //��������
	public void drawMySelf(Canvas canvas, Paint paint) {// ���Ʒ���
		if (this.isRun) {
			canvas.drawBitmap(man, X, Y-18, paint);
		} else {

			X = rushHourActivity.gameView.initX + 32 * j;
			Y = rushHourActivity.gameView.initY + 32 * i;
			canvas.drawBitmap(man, X, Y-18, paint);

		}
	}
}
