package game.rushHour;

import java.util.Random;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView implements SurfaceHolder.Callback {
	RushHourActivity rushHourActivity;
	GameDrawThread gameDrawThread;
	Warrior warrior;

	int level;// 关卡

	int I;// 绘制第一个方块在地图上的坐标
	int J;

	int initX ;// 绘制时第一个的坐标,即开始绘制的位置
	int initY ;

	int sleep1 = 200;// WarriorRunThread线程的睡眠时间

	int gameState = 1;// 游戏进行时
	int warriorState=0;//勇士状态
	
	int lifeState=0;//生命值增减状态
	
	int gemState=0;//能量球状态
	
	int laserState=30;//激光状态
	
	int woodState=40;//木桩状态
	
	int speedState=0;//速度状态
	
	int markState=0;//光标状态
	
	int groundState;

	int newX;
	int newY;
	int t;
	int r;

	Paint paint;
	Paint paint1;
	TouchThread touchThread;
	
	Bitmap title1;
	Bitmap system_view;//系统菜单
	Bitmap mark;
	final int system_viewX=102;
	final int system_viewY=100;
	final int markY1=192;
	final int markY2=238;
	final int markY3=284;
	final int markY4=330;
	//音效设置
	Bitmap yellow;//光标
	Bitmap on;//开状态
	Bitmap off;//关状态
	Bitmap back;// 返回按钮
	final int buttonX=80;
	final int buttonY=218;
	final int yellowX=85;
	final int yellowY=227;
	final int backX=144;
	final int backY=400;
	//帮助
	Bitmap background;// 背景图片
	Bitmap helpView1;// 帮助界面
	Bitmap helpView2;// 帮助界面
	Bitmap up;// 向上按钮
	Bitmap down;// 向下按钮
	final int helpViewX=23;
	final int helpViewY=138;
	final int up_downX=147;
	final int upY=106;
	final int downY=358;
	int state=0;
	
	Bitmap tool_background1;// 工具栏背景
	Bitmap time_background;// 时间栏
	Bitmap time_background1;// 时间栏背景
	Bitmap system;//系统图标
	Bitmap floor_1;// 地板
	Bitmap explode;// 爆炸
	Bitmap wall_1;// 墙1
	Bitmap wall_2;// 墙2
	Bitmap wall_3;// 墙3
	Bitmap wall_4;// 墙4
	Bitmap wall_door;
	Bitmap door_1;// 门
	Bitmap door_2;
	Bitmap door_3;
	Bitmap door_4;
	Bitmap door_5;
	Bitmap black;// 黑色背景
	Bitmap obstacle1;// 障碍物1
	Bitmap key1;// 钥匙1
	Bitmap key2;// 钥匙2
	Bitmap key3;// 钥匙3
	Bitmap transfer;// 传送装置
	Bitmap box1;// 宝箱1
	Bitmap sage;// 智者
	Bitmap bottle1;// 血瓶1
	Bitmap bottle2;// 血瓶2
	Bitmap bottle3;// 血瓶3
	Bitmap tool;// 锯子
	Bitmap map;// 地图
	Bitmap amulet;// 护身符
	Bitmap one;// 1
	Bitmap two;// 2
	Bitmap three;// 3
	Bitmap watch;// 计时器
	Bitmap information1;// 提示画面1
	Bitmap information2;// 提示画面2
	Bitmap information3;// 提示画面3
	Bitmap information4;// 提示画面4
	Bitmap information5;// 提示画面5
	Bitmap information6;// 提示画面6
	Bitmap information7;// 提示画面7
	Bitmap information8;// 提示画面8
	Bitmap information9;// 提示画面9
	Bitmap information10;// 提示画面10
	Bitmap information20;// 提示画面20
	Bitmap road;// 路
	Bitmap obstacle;// 障碍物
	Bitmap destination;// 终点
	Bitmap myself;// 勇士
	Bitmap key;// 钥匙
	Bitmap little_map;// 小地图背景
	Bitmap life;// 生命值
	Bitmap time;// 时间值
	Bitmap game_over;// 游戏结束提示
	
	Bitmap road1;// 路面
	Bitmap ground1;//地面1
	Bitmap ground2;//地面2
	Bitmap ground3;//地面3
	Bitmap ground4;//地面4
	Bitmap ground5;//地面5
	Bitmap tree1;//树1
	Bitmap tree4;//树4
	Bitmap tree5;//树5
	Bitmap flower;//花
	Bitmap stone1;//石碑1
	Bitmap stone2;//石碑2
	Bitmap spring;//生命之泉
	Bitmap car_left;//车
	Bitmap push;//门开关
	Bitmap push2;//门开关
	Bitmap door_9;//门9
	Bitmap door_10;//门10
	Bitmap door_11;//门11
	Bitmap gem1;//能量石1
	Bitmap gem2;//能量石2
	Bitmap ball1;//能量球1
	Bitmap ball2;//能量球2
	Bitmap explode1;//能量球1爆炸
	Bitmap lightning;//闪电
	Bitmap obstacle4;//障碍物4
	Bitmap truncheon;//死亡权杖
	Bitmap information11;// 提示画面11
	Bitmap information12;// 提示画面12
	Bitmap information13;// 提示画面13
	Bitmap information14;// 提示画面14
	Bitmap information15;// 提示画面15
	Bitmap information16;// 提示画面16
	Bitmap information17;// 提示画面17
	Bitmap information18;// 提示画面18
	Bitmap information19;// 提示画面19
	Bitmap information21;// 提示画面21
	Bitmap information22;// 提示画面22
	Bitmap information23;// 提示画面23
	Bitmap information24;// 提示画面24
	
	Bitmap river;//河流
	Bitmap river1;//河流1
	Bitmap river3;//河流3
	Bitmap bank1;//河岸1
	Bitmap bank2;//河岸2
	Bitmap bank3;//河岸3
	Bitmap bank4;//河岸4
	Bitmap bank5;//河岸5
	Bitmap bank6;//河岸6
	Bitmap bank7;//河岸7
	Bitmap bank8;//河岸8
	Bitmap board1;//木板1
	Bitmap board2;//木板2
	Bitmap ground6;//地面6
	Bitmap laser1;//激光1
	Bitmap laser2;//激光2
	Bitmap island;//岛屿
	Bitmap gem3;//魔法石
	Bitmap stone3;//礁石
	Bitmap stone4;//石碑
	Bitmap wall_5;//墙5
	Bitmap boat;//船
	Bitmap car;//车
	Bitmap boat_right;//船
	Bitmap floor_2;//地板2
	Bitmap table1;//桌子1
	Bitmap tree6;//树6
	Bitmap water;//水
	Bitmap wood;//木头
	Bitmap ball3;//水元素
	Bitmap information25;// 提示画面25
	Bitmap information26;// 提示画面26
	Bitmap information27;// 提示画面27

	final int little_mapX = 30;
	final int little_mapY = 110;
	final int XX1 = 104;
	final int YY1 = 186;
	final int XX2 = 70;
	final int YY2 = 114;

	final int time_backgroundX = 60;
	final int time_background1Y = 448;
	final int time_backgroundY = 457;

	final int lifeX = 32;
	final int lifeY = 10;
	final int timeX = 70;
	final int timeY = 458;

	final int information14X = 10;
	final int informationX = 35;
	final int informationY = 64;
	final int amuletX = 130;
	final int bottleX = 162;
	final int gemX = 286;
	final int mapX = 194;
	final int toolX= 226;
	final int truncheonX = 130;
	final int key1X = 260;
	final int watchX = 28;
	final int figureX=292;
	final int figureY=448;
	final int game_overX = 10;
	final int game_overY = 64;
	final int title1Y=32;
	int river1Y=-100;
	int title1X=-500;

	int showTime = 0;
	int showMapTime = 0;
	int information = 0;
	int keyNum = 0;
	int door_key=0;
	int amuletNum = 0;
	int bottleNum = 0;
	int toolNum = 0;
	int mapNum = 0;
	int gemNum = 0;
	int truncheonNum=0;

	int energy_ballX=-1;//能量球位置
	int energy_ballY=-1;
	int explodeX=-1;
	int explodeY=-1;
	int ball_i=-1;//能量球在地图上坐标
	int ball_j=-1;
	int explode_i=-1;
	int explode_j=-1;
	
	int times=2;//光明之路走的次数
	int l, h;

	int process1 = 2700;//时间
	int process2 = 6;//生命值
	int process3 = 3200;//时间
	int process4 = 200;//生命值
	int process5 = 3800;//时间
	int process6 = 160;//生命值

	int explodeX1[] = new int[6];
	int explodeY1[] = new int[6];

	int explodeX2[] = new int[18];
	int explodeY2[] = new int[18];

	int explodeX3[] = new int[16];
	int explodeY3[] = new int[16];
	
	int explodeX4[] = new int[30];
	int explodeY4[] = new int[30];
	
	int explodeX5[] = new int[15];
	int explodeY5[] = new int[15];
	
	int lightningX1[] = new int[20];
	int lightningY1[] = new int[20];
	
	int lightningX2[] = new int[8];
	int lightningY2[] = new int[8];
	
	int alpha=180;
	int boatSoundState=0;//船声状态
	
	MediaPlayer explodeSound;
	MediaPlayer lightningSound;
	MediaPlayer shootSound;
	MediaPlayer startSound;
	MediaPlayer boatSound;

	public GameView(RushHourActivity rushHourActivity, int level) {// 构造器
		super(rushHourActivity);
		this.rushHourActivity = rushHourActivity;
		gameDrawThread = new GameDrawThread(this, getHolder());
		getHolder().addCallback(this);
		this.level = level;
		rushHourActivity.processView.process+=20;
		switch (level) {
		case 1:
			I = 12;
			J = 18;
			initX = -32*J;//绘制时第一个的坐标,即开始绘制的位置
			initY = -32*I;
			//随机产生地雷坐标
			for (int k = 0; k < explodeX1.length; k++) {
				explodeX1[k] = getCoordinate(8, 7);
				explodeY1[k] = getCoordinate(3, 20);
			}
			for (int k = 0; k < explodeX2.length; k++) {
				explodeX2[k] = getCoordinate(12, 2);
				explodeY2[k] = getCoordinate(6, 13);
			}
			for (int k = 0; k < explodeX3.length; k++) {
				explodeX3[k] = getCoordinate(22, 2);
				explodeY3[k] = getCoordinate(3, 5);
			}
			rushHourActivity.processView.process+=20;
			break;
		case 2:
			I = 16;
			J = 30;
			initX = -32*J;//绘制时第一个的坐标,即开始绘制的位置
			initY = -32*I;
			//随机产生地雷坐标
			for (int k = 0; k < explodeX4.length; k++) {
				explodeX4[k] = getCoordinate(9, 2);
				explodeY4[k] = getCoordinate(12, 21);
			}
			for (int k = 0; k < lightningX1.length; k++) {
				lightningX1[k] = getCoordinate(6, 24);
				lightningY1[k] = getCoordinate(9,11);
			}
			int num1= getOne(6);
			int num2= getOne(3);
			int num3= getOne(4);
			int flower[]=new int[num3+1];
			for (int k = 0; k < flower.length; k++) {
				flower[k]=getOne(4);
				switch(flower[k]){
				case 0:
					rushHourActivity.map.map2[1][16][15]="G";
					break;
				case 1:
					rushHourActivity.map.map2[1][18][15]="H";
					break;
				case 2:
					rushHourActivity.map.map2[1][20][15]="I";
					break;
				case 3:
					rushHourActivity.map.map2[1][22][15]="J";
					break;
				}
			}
			switch(num1){
			case 0:
				rushHourActivity.map.map2[1][22][29]="L";
				break;
			case 1:
				rushHourActivity.map.map2[1][22][33]="L";
				break;
			case 2:
				rushHourActivity.map.map2[1][22][37]="L";
				break;
			case 3:
				rushHourActivity.map.map2[1][25][28]="L";
				break;
			case 4:
				rushHourActivity.map.map2[1][25][32]="L";
				break;
			case 5:
				rushHourActivity.map.map2[1][25][36]="L";
				break;
			}
			switch(num2){
			case 0:
				rushHourActivity.map.map2[1][29][27]="N";
				break;
			case 1:
				rushHourActivity.map.map2[1][29][32]="N";
				break;
			case 2:
				rushHourActivity.map.map2[1][29][38]="N";
				break;
			}
			rushHourActivity.processView.process+=20;
			break;
		case 3:
			I = 0;
			J = 0;
			initX = -32*J;//绘制时第一个的坐标,即开始绘制的位置
			initY = -32*I;
			//随机产生地雷坐标
			for (int k = 0; k < explodeX5.length; k++) {

				explodeX5[k] = getCoordinate(15, 34);
				explodeY5[k] = getCoordinate(4, 4);
			}
			
			for (int k = 0; k < lightningX2.length; k++) {
				lightningX2[k] = getCoordinate(4,14);
				lightningY2[k] = getCoordinate(4,40);
			}
			//传送地点
			int n1= getOne(4);
			if(n1==0){
			int n2= getOne(4);
             rushHourActivity.map.map1[2][19][14]=-1-n2;
    		 rushHourActivity.map.map1[2][16][37]=-1-n2;
    		 rushHourActivity.map.map1[2][47][37]=-1-n2;
			}
            if(n1==1){
            	int n3= getOne(4);
             rushHourActivity.map.map1[2][19][15]=-1-n3;
       		 rushHourActivity.map.map1[2][16][38]=-1-n3;
       		 rushHourActivity.map.map1[2][47][38]=-1-n3;
			}
            if(n1==2){
            	int n4= getOne(4);
             rushHourActivity.map.map1[2][20][14]=-1-n4;
        	 rushHourActivity.map.map1[2][17][37]=-1-n4;
        	 rushHourActivity.map.map1[2][48][37]=-1-n4;
   			}
            if(n1==3){
            	int n5= getOne(4);
             rushHourActivity.map.map1[2][20][15]=-1-n5;
             rushHourActivity.map.map1[2][17][38]=-1-n5;
          	 rushHourActivity.map.map1[2][48][38]=-1-n5;
   			}
            rushHourActivity.processView.process+=20;
			break;
		}
		
		initSound();
		initBitmap(level);
	}
	public void startWarrior(){
		warrior = new Warrior(rushHourActivity,level);
		rushHourActivity.processView.process+=20;
	}
	public void initSound(){
		explodeSound = MediaPlayer.create(rushHourActivity, R.raw.explode);
		lightningSound = MediaPlayer.create(rushHourActivity, R.raw.lightning);
		shootSound = MediaPlayer.create(rushHourActivity, R.raw.shoot_sound);
		startSound = MediaPlayer.create(rushHourActivity, R.raw.start);
		boatSound = MediaPlayer.create(rushHourActivity, R.raw.boat);
		boatSound.setLooping(true);
		rushHourActivity.processView.process+=20;
	}
	public void initBitmap(int level) {
		paint = new Paint();
		paint1 = new Paint();
		paint1.setAlpha(alpha);
		title1= BitmapFactory.decodeResource(getResources(),
				R.drawable.title1);
		system_view= BitmapFactory.decodeResource(getResources(),
				R.drawable.system_view);
		mark = BitmapFactory.decodeResource(getResources(),
				R.drawable.mark);
		on = BitmapFactory.decodeResource(getResources(),R.drawable.on);
		off = BitmapFactory.decodeResource(getResources(),R.drawable.off);
		yellow = BitmapFactory.decodeResource(getResources(),R.drawable.yellow);
		back = BitmapFactory.decodeResource(getResources(),R.drawable.back);
		background = BitmapFactory.decodeResource(getResources(),R.drawable.background);
		helpView1 = BitmapFactory.decodeResource(getResources(),R.drawable.help_view1);
		helpView2 = BitmapFactory.decodeResource(getResources(),R.drawable.help_view2);
		back = BitmapFactory.decodeResource(getResources(),R.drawable.back);
		up = BitmapFactory.decodeResource(getResources(),R.drawable.up);
		down = BitmapFactory.decodeResource(getResources(),R.drawable.down);
		rushHourActivity.processView.process+=10;
		switch (level) {
		case 1:
			system= BitmapFactory.decodeResource(getResources(),
					R.drawable.system);
			tool_background1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.tool_background1);
			time_background = BitmapFactory.decodeResource(getResources(),
					R.drawable.time_background);
			time_background1= BitmapFactory.decodeResource(getResources(),
					R.drawable.time_background1);
			wall_1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.wall_1);
			wall_2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.wall_2);
			wall_3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.wall_3);
			wall_4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.wall_4);
			wall_door = BitmapFactory.decodeResource(getResources(),
					R.drawable.wall_door);
			floor_1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.floor_1);
			explode = BitmapFactory.decodeResource(getResources(),
					R.drawable.explode);
			floor_2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.floor_2);
			door_1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_1);
			door_2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_2);
			door_3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_3);
			door_4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_4);
			door_5 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_5);
			
			black = BitmapFactory.decodeResource(getResources(),
					R.drawable.black);
			table1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.table1);
			obstacle = BitmapFactory.decodeResource(getResources(),
					R.drawable.obstacle);
			obstacle1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.obstacle1);
			tree6 = BitmapFactory.decodeResource(getResources(),
					R.drawable.tree6);
			key1 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.key1);
			key2 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.key2);
			key3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.key3);
			one = BitmapFactory.decodeResource(getResources(),
					R.drawable.one);
	        two = BitmapFactory.decodeResource(getResources(), 
	        		R.drawable.two);
	        three = BitmapFactory.decodeResource(getResources(), 
	        		R.drawable.three);
	        watch= BitmapFactory.decodeResource(getResources(),
	        		R.drawable.watch);
			transfer = BitmapFactory.decodeResource(getResources(),
					R.drawable.transfer);
			box1 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.box1);
			sage = BitmapFactory.decodeResource(getResources(), 
					R.drawable.sage);
			information1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information1);
			information2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information2);
			information3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information3);
			information4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information4);
			information5 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information5);
			information6 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information6);
			information7 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information7);
			information8 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information8);
			information9 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information9);
			information10 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information10);
			information20= BitmapFactory.decodeResource(getResources(),
					R.drawable.information20);
			bottle1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bottle1);
			bottle2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bottle2);
			bottle3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bottle3);
			tool = BitmapFactory.decodeResource(getResources(), 
					R.drawable.tool);
			map = BitmapFactory.decodeResource(getResources(), 
					R.drawable.map);
			amulet = BitmapFactory.decodeResource(getResources(),
					R.drawable.amulet);
			road = BitmapFactory.decodeResource(getResources(),
					R.drawable.road);
			myself = BitmapFactory.decodeResource(getResources(),
					R.drawable.myself);
			key = BitmapFactory.decodeResource(getResources(),
					R.drawable.key);
			destination = BitmapFactory.decodeResource(getResources(),
					R.drawable.destination);
			little_map = BitmapFactory.decodeResource(getResources(),
					R.drawable.little_map);
			life = BitmapFactory.decodeResource(getResources(),
					R.drawable.life);
			time = BitmapFactory.decodeResource(getResources(), 
					R.drawable.time);
			game_over = BitmapFactory.decodeResource(getResources(),
					R.drawable.game_over);
			rushHourActivity.processView.process+=10;
			break;
		case 2:
			system= BitmapFactory.decodeResource(getResources(),
					R.drawable.system);
			road1= BitmapFactory.decodeResource(getResources(),
					R.drawable.road1);
			tool_background1= BitmapFactory.decodeResource(getResources(),
					R.drawable.tool_background1);
			time_background = BitmapFactory.decodeResource(getResources(),
					R.drawable.time_background);
			time_background1= BitmapFactory.decodeResource(getResources(),
					R.drawable.time_background1);
			ground1= BitmapFactory.decodeResource(getResources(),
					R.drawable.ground1);
			ground2= BitmapFactory.decodeResource(getResources(),
					R.drawable.ground2);
			ground3= BitmapFactory.decodeResource(getResources(),
					R.drawable.ground3);
			ground4= BitmapFactory.decodeResource(getResources(),
					R.drawable.ground4);
			ground5= BitmapFactory.decodeResource(getResources(),
					R.drawable.ground5);
			explode = BitmapFactory.decodeResource(getResources(),
					R.drawable.explode);
			tree1= BitmapFactory.decodeResource(getResources(),
					R.drawable.tree1);
			tree4= BitmapFactory.decodeResource(getResources(),
					R.drawable.tree4);
			tree5= BitmapFactory.decodeResource(getResources(),
					R.drawable.tree5);
			flower= BitmapFactory.decodeResource(getResources(),
					R.drawable.flower);
			stone1= BitmapFactory.decodeResource(getResources(),
					R.drawable.stone1);
			stone2= BitmapFactory.decodeResource(getResources(),
					R.drawable.stone2);
			spring= BitmapFactory.decodeResource(getResources(),
					R.drawable.spring);
			bottle1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bottle1);
			bottle2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bottle2);
			bottle3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bottle3);
			box1 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.box1);
			key1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.key1);
			key2= BitmapFactory.decodeResource(getResources(),
					R.drawable.key2);
			key3= BitmapFactory.decodeResource(getResources(),
                    R.drawable.key3);
			one = BitmapFactory.decodeResource(getResources(),  
					R.drawable.one);
	        two = BitmapFactory.decodeResource(getResources(),
	        		R.drawable.two);
	        three = BitmapFactory.decodeResource(getResources(),
	        		R.drawable.three);
	        watch= BitmapFactory.decodeResource(getResources(), 
	        		R.drawable.watch);
			push = BitmapFactory.decodeResource(getResources(),
					R.drawable.push);
			push2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.push2);
			gem1 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.gem1);
			gem2 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.gem2);
			explode1 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.explode1);
			truncheon= BitmapFactory.decodeResource(getResources(), 
					R.drawable.truncheon);
			lightning= BitmapFactory.decodeResource(getResources(), 
					R.drawable.lightning);
			sage = BitmapFactory.decodeResource(getResources(), 
					R.drawable.sage);
			transfer = BitmapFactory.decodeResource(getResources(),
					R.drawable.transfer);
			door_3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_3);
			door_4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_4);
			door_9 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_9);
			door_10 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_10);
			door_11 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_11);
			ball1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ball1);
			ball2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ball2);
			car_left = BitmapFactory.decodeResource(getResources(),
					R.drawable.car_left);
			obstacle1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.obstacle1);
			obstacle4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.obstacle4);
			life = BitmapFactory.decodeResource(getResources(),
					R.drawable.life);
	        time = BitmapFactory.decodeResource(getResources(), 
	        		R.drawable.time);
	        game_over = BitmapFactory.decodeResource(getResources(),
			        R.drawable.game_over);
			information2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information2);
			information7 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information7);
			information8= BitmapFactory.decodeResource(getResources(),
					R.drawable.information8);
			information9 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information9);
			information13 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information13);
			information11= BitmapFactory.decodeResource(getResources(),
					R.drawable.information11);
			information12= BitmapFactory.decodeResource(getResources(),
					R.drawable.information12);
			information14= BitmapFactory.decodeResource(getResources(),
					R.drawable.information14);
			information15= BitmapFactory.decodeResource(getResources(),
					R.drawable.information15);
			information16= BitmapFactory.decodeResource(getResources(),
					R.drawable.information16);
			information17= BitmapFactory.decodeResource(getResources(),
					R.drawable.information17);
			information18= BitmapFactory.decodeResource(getResources(),
					R.drawable.information18);
			information19= BitmapFactory.decodeResource(getResources(),
					R.drawable.information19);
			information20= BitmapFactory.decodeResource(getResources(),
					R.drawable.information20);
			information21= BitmapFactory.decodeResource(getResources(),
					R.drawable.information21);
			information22= BitmapFactory.decodeResource(getResources(),
					R.drawable.information22);
			information23= BitmapFactory.decodeResource(getResources(),
					R.drawable.information23);
			information24= BitmapFactory.decodeResource(getResources(),
					R.drawable.information24);
			rushHourActivity.processView.process+=10;
			break;
		case 3:
			system= BitmapFactory.decodeResource(getResources(),
					R.drawable.system);
			tool_background1= BitmapFactory.decodeResource(getResources(),
					R.drawable.tool_background1);
			time_background = BitmapFactory.decodeResource(getResources(),
					R.drawable.time_background);
			time_background1= BitmapFactory.decodeResource(getResources(),
					R.drawable.time_background1);
			life = BitmapFactory.decodeResource(getResources(),  
					R.drawable.life);
	        time = BitmapFactory.decodeResource(getResources(), 
	        		R.drawable.time);
	        watch= BitmapFactory.decodeResource(getResources(), 
	        		R.drawable.watch);
	        key1 = BitmapFactory.decodeResource(getResources(),
	        		R.drawable.key1);
	        key2 = BitmapFactory.decodeResource(getResources(),
	        		R.drawable.key2);
	        key3 = BitmapFactory.decodeResource(getResources(),
	        		R.drawable.key3);
	        ball1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ball1);
			ball2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ball2);
			ball3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ball3);
			explode1 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.explode1);
	        one = BitmapFactory.decodeResource(getResources(),  
					R.drawable.one);
	        two = BitmapFactory.decodeResource(getResources(),
	        		R.drawable.two);
	        three = BitmapFactory.decodeResource(getResources(),
	        		R.drawable.three);
	        river= BitmapFactory.decodeResource(getResources(),
					R.drawable.river);
			river1= BitmapFactory.decodeResource(getResources(),
					R.drawable.river1);
			river3= BitmapFactory.decodeResource(getResources(),
					R.drawable.river3);
			bank1= BitmapFactory.decodeResource(getResources(),
					R.drawable.bank1);
			bank2= BitmapFactory.decodeResource(getResources(),
					R.drawable.bank2);
			bank3= BitmapFactory.decodeResource(getResources(),
					R.drawable.bank3);
			bank4= BitmapFactory.decodeResource(getResources(),
					R.drawable.bank4);
			bank5= BitmapFactory.decodeResource(getResources(),
					R.drawable.bank5);
			bank6= BitmapFactory.decodeResource(getResources(),
					R.drawable.bank6);
			bank7 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bank7);
			bank8= BitmapFactory.decodeResource(getResources(),
					R.drawable.bank8);
			board1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.board1);
			board2= BitmapFactory.decodeResource(getResources(),
					R.drawable.board2);
			island= BitmapFactory.decodeResource(getResources(),
					R.drawable.island);
			tree1= BitmapFactory.decodeResource(getResources(),
					R.drawable.tree1);
			tree4= BitmapFactory.decodeResource(getResources(),
					R.drawable.tree4);
			tree5= BitmapFactory.decodeResource(getResources(),
					R.drawable.tree5);
			wall_1= BitmapFactory.decodeResource(getResources(),
					R.drawable.wall_1);
			wall_2= BitmapFactory.decodeResource(getResources(),
					R.drawable.wall_2);
			wall_5= BitmapFactory.decodeResource(getResources(),
					R.drawable.wall_5);
			wall_door = BitmapFactory.decodeResource(getResources(),
					R.drawable.wall_door);
			door_1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_1);
			door_2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_2);
			door_4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_4);
			door_5 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_5);
			door_9 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_9);
			door_10 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_10);
			door_11 = BitmapFactory.decodeResource(getResources(),
					R.drawable.door_11);
			box1 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.box1);
			gem3= BitmapFactory.decodeResource(getResources(),
					R.drawable.gem3);
			stone3= BitmapFactory.decodeResource(getResources(),
					R.drawable.stone3);
			stone4= BitmapFactory.decodeResource(getResources(),
					R.drawable.stone4);
			spring= BitmapFactory.decodeResource(getResources(),
					R.drawable.spring);
			floor_1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.floor_1);
			floor_2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.floor_2);
			ground6 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ground6);
			ground3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ground3);
			ground4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ground4);
			ground5 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ground5);
			ground1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.ground1);
			laser1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.laser1);
			laser2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.laser2);
			lightning= BitmapFactory.decodeResource(getResources(), 
					R.drawable.lightning);
			transfer= BitmapFactory.decodeResource(getResources(), 
					R.drawable.transfer);
			gem1 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.gem1);
			gem2 = BitmapFactory.decodeResource(getResources(), 
					R.drawable.gem2);
			boat = BitmapFactory.decodeResource(getResources(),
					R.drawable.boat);
			car = BitmapFactory.decodeResource(getResources(),
					R.drawable.car);
			boat_right = BitmapFactory.decodeResource(getResources(),
					R.drawable.boat_right);
			obstacle= BitmapFactory.decodeResource(getResources(),
					R.drawable.obstacle);
			obstacle1= BitmapFactory.decodeResource(getResources(),
					R.drawable.obstacle1);
			obstacle4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.obstacle4);
			table1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.table1);
			tree6 = BitmapFactory.decodeResource(getResources(),
					R.drawable.tree6);
			explode = BitmapFactory.decodeResource(getResources(),
					R.drawable.explode);
			water = BitmapFactory.decodeResource(getResources(),
					R.drawable.water);
			wood = BitmapFactory.decodeResource(getResources(),
					R.drawable.wood);
			sage = BitmapFactory.decodeResource(getResources(), 
					R.drawable.sage);
			car_left = BitmapFactory.decodeResource(getResources(),
					R.drawable.car_left);
			amulet = BitmapFactory.decodeResource(getResources(),
                    R.drawable.amulet);
			bottle1 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bottle1);
			bottle2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bottle2);
			bottle3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.bottle3);
			map = BitmapFactory.decodeResource(getResources(), 
					R.drawable.map);
			road = BitmapFactory.decodeResource(getResources(),
					R.drawable.road);
			myself = BitmapFactory.decodeResource(getResources(),
					R.drawable.myself);
			key = BitmapFactory.decodeResource(getResources(),
					R.drawable.key);
			destination = BitmapFactory.decodeResource(getResources(),
					R.drawable.destination);
			game_over = BitmapFactory.decodeResource(getResources(),
				        R.drawable.game_over);
			little_map = BitmapFactory.decodeResource(getResources(),
					R.drawable.little_map);
			information2 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information2);
			information3 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information3);
			information4 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information4);
			information6 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information6);
			information7 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information7);
			information8 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information8);
			information12 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information12);
			information16 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information16);
			information17 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information17);
			information21 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information21);
			information22 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information22);
			information25 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information25);
			information26 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information26);
			information27 = BitmapFactory.decodeResource(getResources(),
					R.drawable.information27);
			rushHourActivity.processView.process+=10;
			break;
		}
	}

	protected void onDraw(Canvas canvas) {
		if(gameState==3){
			canvas.drawColor(Color.BLACK);// 绘制黑色背景
			canvas.drawBitmap(system_view, system_viewX, system_viewY, paint);
			if(markState==0)
			canvas.drawBitmap(mark, 0, markY1, paint1);
			if(markState==1)
			canvas.drawBitmap(mark, 0, markY2, paint1);
			if(markState==2)
			canvas.drawBitmap(mark, 0, markY3, paint1);
			if(markState==3)
			canvas.drawBitmap(mark, 0, markY4, paint1);
		}
		else if(gameState==4){
			canvas.drawColor(Color.BLACK);// 绘制黑色背景
			if(rushHourActivity.isSound==true)
			canvas.drawBitmap(on, buttonX, buttonY, paint);
			if(rushHourActivity.isSound==false)
				canvas.drawBitmap(off, buttonX, buttonY, paint);
			canvas.drawBitmap(yellow,yellowX, yellowY, paint1);
			canvas.drawBitmap(back,backX, backY, paint);
		}
		else if(gameState==5){
			canvas.drawBitmap(background, 0, 0,paint);//背景图片
			if(state==0)
			canvas.drawBitmap(helpView1, helpViewX, helpViewY,paint1);//帮助界面
			if(state==1)
			canvas.drawBitmap(helpView2, helpViewX, helpViewY,paint1);//帮助界面
			canvas.drawBitmap(back, backX, backY,paint);// 返回按钮
			canvas.drawBitmap(up, up_downX, upY,paint);// 向上按钮
			canvas.drawBitmap(down, up_downX, downY,paint);// 向下按钮
		}
		else{
			canvas.drawColor(Color.BLACK);// 绘制黑色背景

			newX = initX + 32 * warrior.j;
			newY = initY + 32 * warrior.i;

			this.scroll(newX, newY,level);// 调用滚屏方法
		switch (level) {
		case 1:
			// 绘制第一层,即地板层
			for (int i = 0; i < rushHourActivity.map.map1[0].length; i++) {
				for (int j = 0; j < rushHourActivity.map.map1[0][0].length; j++) {
					// 根据索引值进行坐标转换
					int X = initX + 32 * j;
					int Y = initY + 32 * i;
					if (rushHourActivity.map.map1[0][i][j] == 0) {// 地板1
						canvas.drawBitmap(floor_1, X, Y, paint);
					} else if (rushHourActivity.map.map1[0][i][j] == 1) {
						canvas.drawBitmap(wall_1, X, Y, paint);
					} else if (rushHourActivity.map.map1[0][i][j] == 2) {// 地板2
						canvas.drawBitmap(floor_2, X, Y, paint);
					} else if (rushHourActivity.map.map1[0][i][j] == 3) {// 传送装置
						canvas.drawBitmap(transfer, X, Y, paint);
					} else if (rushHourActivity.map.map1[0][i][j] == 4) {// 爆炸
						canvas.drawBitmap(explode, X, Y, paint);
					}
				}
			}
			// 绘制第二层地图
			for (int i = 0; i < rushHourActivity.map.map1[0].length; i++) {
				for (int j = 0; j < rushHourActivity.map.map1[0][0].length; j++) {
					// 根据索引值进行坐标转换
					int X = initX + 32 * j;
					int Y = initY + 32 * i;
					char c = rushHourActivity.map.map2[0][i][j].charAt(0);
					if (Character.isUpperCase(c)) {// 黑色背景
						canvas.drawBitmap(black, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("b")) {// 墙1
						canvas.drawBitmap(wall_door, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("c")) {// 墙2
						canvas.drawBitmap(wall_2, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("d")) {// 墙3
						canvas.drawBitmap(wall_3, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("e")) {// 桌子
						canvas.drawBitmap(table1, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("f")) {// 门1
						canvas.drawBitmap(door_1, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("g")) {// 门2
						canvas.drawBitmap(door_2, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("j")) {// 门3
						canvas.drawBitmap(door_3, X, Y - 15, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("h")) {// 障碍物1
						canvas.drawBitmap(obstacle1, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("i")) {// 花盆
						canvas.drawBitmap(tree6, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("k")) {// 钥匙1
						canvas.drawBitmap(key1, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("l")) {// 钥匙2
						canvas.drawBitmap(key2, X, Y, paint);
					}  else if (rushHourActivity.map.map2[0][i][j].equals("n")) {// 门4
						canvas.drawBitmap(door_4, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("o")) {// 钥匙3
						canvas.drawBitmap(key3, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("p")) {// 宝箱
																				// 用于盛放金刚锯
						canvas.drawBitmap(box1, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("q")) {// 宝箱
																				// 用于盛放地图
						canvas.drawBitmap(box1, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("r")) {// 宝箱
																				// 用于盛放消除魔法的护身符
						canvas.drawBitmap(box1, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("s")) {// 智者
						canvas.drawBitmap(sage, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("t")) {// 宝箱
																				// 用于盛放加时器
						canvas.drawBitmap(box1, X, Y, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("u")) {// 门5
						canvas.drawBitmap(door_5, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("v")) {// 墙4
						canvas.drawBitmap(wall_4, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("w")) {// 宝箱
																				// 用于盛放生命药水
						canvas.drawBitmap(box1, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("x")) {// 智者
						canvas.drawBitmap(sage, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("y")) {// 智者
						canvas.drawBitmap(sage, X, Y - 18, paint);
					} else if (rushHourActivity.map.map2[0][i][j].equals("z")) {// 门4
						canvas.drawBitmap(door_4, X, Y - 18, paint);
					}
					if (i == warrior.i
							&& j == warrior.j) {
						warrior.drawMySelf(canvas, paint);
					}
				}
			}

			canvas.drawBitmap(tool_background1, 0, 0, paint);
			canvas.drawBitmap(time_background1, 0, time_background1Y, paint);
			canvas.drawBitmap(watch, watchX,time_background1Y, paint);
			canvas.drawBitmap(time_background, time_backgroundX,time_backgroundY, paint);
			canvas.drawBitmap(key1, key1X,time_background1Y, paint);
			canvas.drawBitmap(time, timeX, timeY, paint);
			canvas.drawBitmap(system, 0, 0, paint);
			canvas.drawBitmap(life, lifeX, lifeY, paint);

			if (showTime > 0) {
				showTime--;
				if (information == 1) {// 智者
					canvas.drawBitmap(information1, informationX,
							informationY, paint1);
				}
				if (information == 2) {// 智者
					canvas.drawBitmap(information2, informationX,
							informationY, paint1);
				}
				if (information == 3) {// 智者
					canvas.drawBitmap(information3, informationX,
							informationY, paint1);
				}
				if (information == 4) {// 护身符
					canvas.drawBitmap(information4, informationX,
							informationY, paint1);
				}
				if (information == 5) {// 金刚锯
					canvas.drawBitmap(information5, informationX,
							informationY, paint1);
				}
				if (information == 6) {// 地图
					canvas.drawBitmap(information6, informationX,
							informationY, paint1);
				}
				if (information == 7) {// 血瓶
					canvas.drawBitmap(information7, informationX,
							informationY, paint1);
				}
				if (information == 8) {// 加时器
					canvas.drawBitmap(information8, informationX,
							informationY, paint1);
				}
				if (information == 9) {// 门开关
					canvas.drawBitmap(information9, informationX,
							informationY, paint1);
				}
				if (information == 10) {// 传送门
					canvas.drawBitmap(information10, informationX,
							informationY, paint1);
				}
				if (information == 20) {// 开关门
					canvas.drawBitmap(information20, informationX,
							informationY, paint1);
				}
			}
			if (showMapTime > 0) {// 画小地图
				showMapTime--;
				if (showMapTime == 0) {
					touchThread.setFlag(true);
				}
				drawMap(canvas,level);
						}

			if (rushHourActivity.map.map1[0][warrior.i][warrior.j] == 3) {
				showTime = 1;
				information = 10;
			}

			if (amuletNum > 0) {
				canvas.drawBitmap(amulet, amuletX, 0, paint);
			}
			if (bottleNum > 0) {
				if (bottleNum == 3)
					canvas.drawBitmap(bottle3, bottleX, 0, paint);
				if (bottleNum == 2)
					canvas.drawBitmap(bottle2, bottleX, 0, paint);
				if (bottleNum == 1)
					canvas.drawBitmap(bottle1, bottleX, 0, paint);
			}
			if (toolNum > 0) {
				canvas.drawBitmap(tool, toolX, 0, paint);
			}
			if (mapNum > 0) {
				canvas.drawBitmap(map, mapX, 0, paint);
			}
			if (keyNum > 0) {
				if (keyNum == 1)
					canvas.drawBitmap(one, figureX, figureY, paint);
				if (keyNum == 2)
					canvas.drawBitmap(two, figureX, figureY, paint);
				if (keyNum == 3)
					canvas.drawBitmap(three, figureX, figureY, paint);
			}
			//地雷爆炸
			for (int r = 0; r < explodeX1.length; r++) {
				if (warrior.i == explodeX1[r]
						&& warrior.j == explodeY1[r]
						&& rushHourActivity.map.map1[0][warrior.i][warrior.j] != 4) {
					rushHourActivity.map.map1[0][warrior.i][warrior.j] = 4;
				if(rushHourActivity.isSound==true){
					explodeSound.start();
				}
					if (process2 > 0)
						process2--;
				}
			}
			//地雷爆炸
			for (int u = 0; u < explodeX2.length; u++) {
				if (warrior.i == explodeX2[u]
						&& warrior.j == explodeY2[u]
						&& rushHourActivity.map.map1[0][warrior.i][warrior.j] != 4) {
					rushHourActivity.map.map1[0][warrior.i][warrior.j] = 4;
					if(rushHourActivity.isSound==true){
						explodeSound.start();
					}
					if (process2 > 0)
						process2--;
				}
			}
			//地雷爆炸
			for (int w = 0; w < explodeX3.length; w++) {
				if (warrior.i == explodeX3[w]
						&& warrior.j == explodeY3[w]
						&& rushHourActivity.map.map1[0][warrior.i][warrior.j] != 4) {
					rushHourActivity.map.map1[0][warrior.i][warrior.j] = 4;
					if(rushHourActivity.isSound==true){
						explodeSound.start();
					}
					if (process2 > 0)
						process2--;
				}
			}
			if (process1 > 0) {
				process1--;
			}
            
			canvas.drawRect(timeX + process1 * ((float) time.getWidth() / 2700), timeY,
					timeX + time.getWidth(), timeY + time.getHeight(), paint);
			canvas.drawRect(lifeX + process2 * (life.getWidth() / 6), lifeY,
					lifeX + life.getWidth(), lifeY + life.getHeight(), paint);

			if (process1 <= 0 || process2 <= 0) {
				canvas.drawBitmap(game_over, game_overX, game_overY, paint);
				gameState=0;
				gameDrawThread.setFlag(false);
			}
			break;
		case 2:
			// 绘制第一层,即地板层
			for (int i = 0; i < rushHourActivity.map.map1[1].length; i++) {
				for (int j = 0; j < rushHourActivity.map.map1[1][0].length; j++) {
					// 根据索引值进行坐标转换
					int X = initX + 32 * j;
					int Y = initY + 32 * i;
					 if (rushHourActivity.map.map1[1][i][j] == 1) {
						canvas.drawBitmap(road1, X, Y, paint);
					} 
					 else if (rushHourActivity.map.map1[1][i][j] == 2) {
							canvas.drawBitmap(ground1, X, Y, paint);
					} 
					 else if (rushHourActivity.map.map1[1][i][j] == 3||rushHourActivity.map.map1[1][i][j] == -3) {
							canvas.drawBitmap(ground2, X, Y, paint);
					} 
					 else if (rushHourActivity.map.map1[1][i][j] == 4) {
							canvas.drawBitmap(ground3, X, Y, paint);
					} 
					 else if (rushHourActivity.map.map1[1][i][j] == 5) {
							canvas.drawBitmap(ground4, X, Y, paint);
					} 
					 else if (rushHourActivity.map.map1[1][i][j] == 6) {// 传送装置
							canvas.drawBitmap(transfer, X, Y, paint);
						}
					 else if (rushHourActivity.map.map1[1][i][j] == 7) {// 爆炸
							canvas.drawBitmap(explode, X, Y, paint);
						}
					 else if (rushHourActivity.map.map1[1][i][j] == 8) {// 闪电劈过的地
							canvas.drawBitmap(ground5, X, Y, paint);
						}
				}
			}
			//能量球
			energy_ballX=initX+ball_j*32;
			energy_ballY=initY+ball_i*32;
			explodeX = initX+explode_j*32;
			explodeY = initY+explode_i*32;
			if(ball_j>=0&&ball_i>=0&&gemNum==1&&gemState==0){
			canvas.drawBitmap(ball1,energy_ballX, energy_ballY, paint);
			}
			if(gemNum==1&&gemState>0){
				if(rushHourActivity.isSound==true){
					explodeSound.start();
				}
				canvas.drawBitmap(explode1,explodeX, explodeY, paint);
				gemState--;
				}
			if(ball_j>=0&&ball_i>=0&&gemNum==2&&gemState==0){
			   canvas.drawBitmap(ball2,energy_ballX, energy_ballY, paint);
			}
			if(gemNum==2&&gemState>0){
				if(rushHourActivity.isSound==true){
					explodeSound.start();
				}
				   canvas.drawBitmap(explode1,explodeX, explodeY, paint);
				   gemState--;
				}
			// 绘制第二层地图
			for (int i = 0; i < rushHourActivity.map.map1[1].length; i++) {
				for (int j = 0; j < rushHourActivity.map.map1[1][0].length; j++) {
					// 根据索引值进行坐标转换
					int X = initX + 32 * j;
					int Y = initY + 32 * i;
					
					if (rushHourActivity.map.map2[1][i][j].equals("b")) {// 树1
						canvas.drawBitmap(tree1, X, Y - 32, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("c")) {// 树1
						canvas.drawBitmap(tree1, X, Y-32, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("d")) {// 树4
						canvas.drawBitmap(tree4, X, Y-32, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("e")) {// 树4
						canvas.drawBitmap(tree4, X, Y-32, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("f")) {// 树5
						canvas.drawBitmap(tree5, X, Y-32, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("g")
							||rushHourActivity.map.map2[1][i][j].equals("G")) {// 花
						canvas.drawBitmap(flower, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("h")
							||rushHourActivity.map.map2[1][i][j].equals("H")) {// 花
						canvas.drawBitmap(flower, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("i")
							||rushHourActivity.map.map2[1][i][j].equals("I")) {// 花
						canvas.drawBitmap(flower, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("j")
							||rushHourActivity.map.map2[1][i][j].equals("J")) {// 花
						canvas.drawBitmap(flower, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("k")) {// 生命之泉
						canvas.drawBitmap(spring, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("l")
							||rushHourActivity.map.map2[1][i][j].equals("L")) {// 石碑1
						canvas.drawBitmap(stone1, X, Y-32, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("m")) {// 石碑2
						canvas.drawBitmap(stone2, X, Y-32, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("n")
							||rushHourActivity.map.map2[1][i][j].equals("N")) {// 钥匙箱
						canvas.drawBitmap(box1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("o")) {// 用于盛放生命药水
						canvas.drawBitmap(box1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("q")) {// 智者
						canvas.drawBitmap(sage, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("r")) {// 智者
						canvas.drawBitmap(sage, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("s")) {// 智者
						canvas.drawBitmap(sage, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("t")) {// 车
						canvas.drawBitmap(car_left, X, Y-20, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("u")) {// 门开关
						canvas.drawBitmap(push, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("U")) {// 门开关
						canvas.drawBitmap(push2, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("v")) {// 用于盛放加时器
						canvas.drawBitmap(box1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("w")) {// 车钥匙
						canvas.drawBitmap(key2, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("x")) {// 智者
						canvas.drawBitmap(sage, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("y")) {// 门4
						canvas.drawBitmap(door_4, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("z")) {// 第三把钥匙
						canvas.drawBitmap(key3, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("0")) {// 能量石1
						canvas.drawBitmap(gem1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("1")) {// 能量石2
						canvas.drawBitmap(gem2, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("2")) {// 门4
						canvas.drawBitmap(door_4, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("3")) {//栅栏 
						canvas.drawBitmap(obstacle1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("4")) {//闪电
						canvas.drawBitmap(lightning, X, Y-40, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("5")) {//障碍物4
						canvas.drawBitmap(obstacle4, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("6")) {//门9
						canvas.drawBitmap(door_9, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("7")) {//门10
						canvas.drawBitmap(door_10, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("8")) {//门11
						canvas.drawBitmap(door_11, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[1][i][j].equals("9")) {//门3
						canvas.drawBitmap(door_3, X, Y-18, paint);
					} 
					if (i == warrior.i
							&& j == warrior.j) {
						warrior.drawMySelf(canvas, paint);
					}
					}
				}
			
			canvas.drawBitmap(tool_background1, 0, 0, paint);
			canvas.drawBitmap(time_background1, 0, time_background1Y, paint);
			canvas.drawBitmap(watch, watchX,time_background1Y, paint);
			canvas.drawBitmap(time_background, time_backgroundX,time_backgroundY, paint);
			canvas.drawBitmap(key1, key1X,time_background1Y, paint);
			canvas.drawBitmap(time, timeX, timeY, paint);
			canvas.drawBitmap(system, 0, 0, paint);
			canvas.drawBitmap(life, lifeX, lifeY, paint);
			
			if (showTime > 0) {
				showTime--;
				if (information == 8) {// 加时器
					canvas.drawBitmap(information8, informationX,informationY, paint1);
				}
				if (information == 13) {// 智者
					canvas.drawBitmap(information13, informationX,
							informationY, paint1);
				}
				if (information == 7) {// 血瓶
					canvas.drawBitmap(information7, informationX,
							informationY, paint1);
				}
				if (information == 9) {// 门开关
					canvas.drawBitmap(information9, informationX,
							informationY, paint1);
				}
				if (information == 11) {// 光明之路
					canvas.drawBitmap(information11, informationX,
							informationY, paint1);
				}
				if (information == 12) {// 传送门
					canvas.drawBitmap(information12, informationX,
							informationY, paint1);
				}	
				if (information == 14) {// 智者
					canvas.drawBitmap(information14, information14X,
							informationY, paint1);
				}	
				if (information == 15) {// 智者
					canvas.drawBitmap(information15, informationX,
							informationY, paint1);
				}	
				if (information == 16) {// 蓝色能量石
					canvas.drawBitmap(information16, informationX,
							informationY, paint1);
				}	
				if (information == 17) {// 金色能量石
					canvas.drawBitmap(information17, informationX,
							informationY, paint1);
				}	
				if (information == 18) {// 死亡权杖
					canvas.drawBitmap(information18, informationX,
							informationY, paint1);
				}	
				if (information == 19) {// 第一把钥匙
					canvas.drawBitmap(information19, informationX,
							informationY, paint1);
				}	
				if (information == 20) {// 开关门
					canvas.drawBitmap(information20, informationX,
							informationY, paint1);
				}
				if (information == 21) {// 车
					canvas.drawBitmap(information21, informationX,
							informationY, paint1);
				}
				if (information == 22) {// 石门
					canvas.drawBitmap(information22, informationX,
							informationY, paint1);
				}
				if (information == 23) {// 智者
					canvas.drawBitmap(information23, informationX,
							informationY, paint1);
				}
				if (information == 24) {// 吸血花
					canvas.drawBitmap(information24, informationX,
							informationY, paint1);
				}
			}
			if (rushHourActivity.map.map1[1][warrior.i][warrior.j] == 6) {
				showTime = 1;
				information = 12;
			}
			
			if (bottleNum > 0) {
				if (bottleNum == 3)
					canvas.drawBitmap(bottle3, bottleX, 0, paint);
				if (bottleNum == 2)
					canvas.drawBitmap(bottle2, bottleX, 0, paint);
				if (bottleNum == 1)
					canvas.drawBitmap(bottle1, bottleX, 0, paint);
			}
			if (gemNum > 0) {
				if (gemNum == 3)
					canvas.drawBitmap(ball3, gemX, 0, paint);
				if (gemNum == 2)
					canvas.drawBitmap(gem2, gemX, 0, paint);
				if (gemNum == 1)
					canvas.drawBitmap(gem1, gemX, 0, paint);
			}
			if (truncheonNum > 0) {
					canvas.drawBitmap(truncheon, truncheonX, 0, paint);
			}
			if (keyNum > 0) {
				if (keyNum == 1)
					canvas.drawBitmap(one, figureX, figureY, paint);
				if (keyNum == 2)
					canvas.drawBitmap(two, figureX, figureY, paint);
				if (keyNum == 3)
					canvas.drawBitmap(three, figureX, figureY, paint);
			}
			if ((warrior.i ==6 && warrior.j ==1)
					|| (warrior.i ==10 && warrior.j ==5)){//传送
				warrior.i=24;
				warrior.j=11;
			}
			if ((warrior.i ==2 && warrior.j ==5)){//传送
				if(times==0){
					warrior.i=23;
					warrior.j=1;
				}
				else{
					times--;
				warrior.i=6;
				warrior.j=10;
				}
			}
			
			if (lifeState==1&&process4>0){
            	process4--;
            }
            if (lifeState==2&&process4<180){
            	process4+=20;
            }
            if (lifeState==2&&process4>=180&&process4<200){
            	process4=200;
            }
			//地雷爆炸
            for (int r = 0; r < explodeX4.length; r++) {
				if (warrior.i == explodeX4[r]
						&& warrior.j == explodeY4[r]
						&& rushHourActivity.map.map1[1][warrior.i][warrior.j] != 7) {
					rushHourActivity.map.map1[1][warrior.i][warrior.j] = 7;
					if(rushHourActivity.isSound==true){
						explodeSound.start();
					}
					if (process4>20)
						process4-=20;
					else if(process4>0&&process4<=20)
						process4=0;
				}
			}
            //电闪雷鸣
            for (int r = 0; r < lightningX1.length; r++) {
				if (warrior.i == lightningX1[r]&& warrior.j == lightningY1[r]
				    &&rushHourActivity.map.map1[1][warrior.i][warrior.j] != 8
				    &&rushHourActivity.map.map1[1][warrior.i][warrior.j] != 6) {
					rushHourActivity.map.map2[1][warrior.i][warrior.j] = "4";
					rushHourActivity.map.map1[1][warrior.i][warrior.j] = 8;
					if(rushHourActivity.isSound==true){
						lightningSound.start();
					}
					if (process4>20)
						process4-=20;
					else if(process4>0&&process4<=20)
						process4=0;
				}
			}
            //时间的流逝
            if (process3 > 0) {
				process3--;
			}
            
			canvas.drawRect(timeX + process3 * ((float) time.getWidth() / 3200), timeY,
					timeX + time.getWidth(), timeY + time.getHeight(), paint);
			canvas.drawRect(lifeX + process4 * ((float)life.getWidth() / 200), lifeY,
					lifeX + life.getWidth(), lifeY + life.getHeight(), paint);

			
			if (process3 <= 0 || process4 <= 0) {
				canvas.drawBitmap(game_over, game_overX, game_overY, paint);
				gameState=0;
				gameDrawThread.setFlag(false);
				
			}
			break;
		case 3:
			if(speedState==1&&warriorState==0){
				sleep1=600;
			}
			if(speedState==1&&warriorState>0){
				sleep1=300;
			}
			if(speedState==0&&warriorState==0){
				sleep1=200;
			}
			if(speedState==0&&warriorState>0){
				sleep1=100;
			}
			canvas.drawBitmap(river1, 0, river1Y, paint);
			
			if(river1Y<0){
				river1Y+=1;
    			}
    		else
    			river1Y=-100;
			//木桩
			if(woodState==0){
				woodState=40;
			}
			if(woodState>20&&woodState<=40&&gameState>0){
				woodState--;
				rushHourActivity.map.map1[2][48][26]=25;
				rushHourActivity.map.map1[2][48][27]=25;
				rushHourActivity.map.map1[2][49][28]=24;
				rushHourActivity.map.map1[2][49][29]=24;
				rushHourActivity.map.map1[2][48][30]=25;
				rushHourActivity.map.map1[2][48][31]=25;
				rushHourActivity.map.map1[2][49][32]=24;
				rushHourActivity.map.map1[2][49][33]=24;
				
				rushHourActivity.map.map1[2][15][26]=25;
				rushHourActivity.map.map1[2][15][27]=25;
				rushHourActivity.map.map1[2][16][28]=24;
				rushHourActivity.map.map1[2][16][29]=24;
				rushHourActivity.map.map1[2][15][30]=25;
				rushHourActivity.map.map1[2][15][31]=25;
				rushHourActivity.map.map1[2][16][32]=24;
				rushHourActivity.map.map1[2][16][33]=24;
				
				rushHourActivity.map.map1[2][28][14]=25;
				rushHourActivity.map.map1[2][29][14]=25;
				rushHourActivity.map.map1[2][30][13]=24;
				rushHourActivity.map.map1[2][31][13]=24;
				rushHourActivity.map.map1[2][32][14]=25;
				rushHourActivity.map.map1[2][33][14]=25;
				rushHourActivity.map.map1[2][34][13]=24;
				rushHourActivity.map.map1[2][35][13]=24;
				
			}
			if(woodState>0&&woodState<=20&&gameState>0){
				woodState--;
				rushHourActivity.map.map1[2][48][26]=24;
				rushHourActivity.map.map1[2][48][27]=24;
				rushHourActivity.map.map1[2][49][28]=25;
				rushHourActivity.map.map1[2][49][29]=25;
				rushHourActivity.map.map1[2][48][30]=24;
				rushHourActivity.map.map1[2][48][31]=24;
				rushHourActivity.map.map1[2][49][32]=25;
				rushHourActivity.map.map1[2][49][33]=25;
				
				rushHourActivity.map.map1[2][15][26]=24;
				rushHourActivity.map.map1[2][15][27]=24;
				rushHourActivity.map.map1[2][16][28]=25;
				rushHourActivity.map.map1[2][16][29]=25;
				rushHourActivity.map.map1[2][15][30]=24;
				rushHourActivity.map.map1[2][15][31]=24;
				rushHourActivity.map.map1[2][16][32]=25;
				rushHourActivity.map.map1[2][16][33]=25;
				
				rushHourActivity.map.map1[2][28][14]=24;
				rushHourActivity.map.map1[2][29][14]=24;
				rushHourActivity.map.map1[2][30][13]=25;
				rushHourActivity.map.map1[2][31][13]=25;
				rushHourActivity.map.map1[2][32][14]=24;
				rushHourActivity.map.map1[2][33][14]=24;
				rushHourActivity.map.map1[2][34][13]=25;
				rushHourActivity.map.map1[2][35][13]=25;
				
			}
			// 绘制第一层,即地板层
			for (int i = 0; i < rushHourActivity.map.map1[2].length; i++) {
				for (int j = 0; j < rushHourActivity.map.map1[2][0].length; j++) {
					// 根据索引值进行坐标转换
					int X = initX + 32 * j;
					int Y = initY + 32 * i;
					 if (rushHourActivity.map.map1[2][i][j] == 1) {//河岸1
						canvas.drawBitmap(bank1, X, Y, paint);
					} 
					 else if (rushHourActivity.map.map1[2][i][j] == 2) {//河岸2
							canvas.drawBitmap(bank2, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 3) {//河岸3
							canvas.drawBitmap(bank3, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 4) {//河岸4
							canvas.drawBitmap(bank4, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 5) {//河岸5
							canvas.drawBitmap(bank5, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 7) {//河岸6
							canvas.drawBitmap(bank6, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 8) {//河岸7
							canvas.drawBitmap(bank7, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 9) {//河岸8
							canvas.drawBitmap(bank8, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 10) {//传送装置
						 canvas.drawBitmap(transfer, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 11) {//岛
							canvas.drawBitmap(island, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 12) {//地板1
							canvas.drawBitmap(floor_1, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 13) {//地面6
							canvas.drawBitmap(ground6, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 15) {//地板2
						 canvas.drawBitmap(floor_2, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 16) {//地面3
							canvas.drawBitmap(ground3, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 17) {//地面8
							canvas.drawBitmap(ground4, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 18) {//地面9
							canvas.drawBitmap(ground1, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 19) {//河3
							canvas.drawBitmap(river3, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 20) {//木板1
							canvas.drawBitmap(board1, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 21) {//木板2
							canvas.drawBitmap(board2, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 23) {//地雷
							canvas.drawBitmap(explode, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 24
							 ||rushHourActivity.map.map1[2][i][j] == 14) {//木头
							canvas.drawBitmap(wood, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 25) {//水
							canvas.drawBitmap(water, X, Y, paint);
						} 
					 else if (rushHourActivity.map.map1[2][i][j] == 26) {//地面5
							canvas.drawBitmap(ground5, X, Y, paint);
						} 
				}
			}
			//能量球
			energy_ballX=initX+ball_j*32;
			energy_ballY=initY+ball_i*32;
			explodeX = initX+explode_j*32;
			explodeY = initY+explode_i*32;
			if(ball_j>=0&&ball_i>=0&&gemNum==1&&gemState==0){
			canvas.drawBitmap(ball1,energy_ballX, energy_ballY, paint);
			}
			if(gemNum==1&&gemState>0){
				if(rushHourActivity.isSound==true){
					explodeSound.start();
				}
				canvas.drawBitmap(explode1,explodeX, explodeY, paint);
				gemState--;
				}
			if(ball_j>=0&&ball_i>=0&&gemNum==2&&gemState==0){
			   canvas.drawBitmap(ball2,energy_ballX, energy_ballY, paint);
			}
			if(gemNum==2&&gemState>0){
				if(rushHourActivity.isSound==true){
					explodeSound.start();
				}
				   canvas.drawBitmap(explode1,explodeX, explodeY, paint);
				   gemState--;
				}
			if(ball_j>=0&&ball_i>=0&&gemNum==3&&gemState==0){
				   canvas.drawBitmap(ball3,energy_ballX, energy_ballY, paint);
				}
				if(gemNum==3&&gemState>0){
					if(rushHourActivity.isSound==true){
						explodeSound.start();
					}
					   canvas.drawBitmap(explode1,explodeX, explodeY, paint);
					   gemState--;
					}
			//激光
			if(laserState==0){
				laserState=30;
			}
			if(laserState>15&&laserState<=30&&gameState>0){
				laserState--;
				rushHourActivity.map.map2[2][50][4]="m";
				rushHourActivity.map.map2[2][52][4]="a";
				rushHourActivity.map.map2[2][54][4]="m";
				rushHourActivity.map.map2[2][55][8]="a";
				rushHourActivity.map.map2[2][55][10]="n";
				
				rushHourActivity.map.map2[2][55][14]="n";
				rushHourActivity.map.map2[2][55][16]="a";
				rushHourActivity.map.map2[2][55][18]="n";
				rushHourActivity.map.map2[2][55][20]="a";
				rushHourActivity.map.map2[2][55][22]="n";
			}
            if(laserState>0&&laserState<=15&&gameState>0){
            	laserState--;
            	rushHourActivity.map.map2[2][50][4]="a";
				rushHourActivity.map.map2[2][52][4]="m";
				rushHourActivity.map.map2[2][54][4]="a";
				rushHourActivity.map.map2[2][55][8]="n";
				rushHourActivity.map.map2[2][55][10]="a";
				
				rushHourActivity.map.map2[2][55][14]="a";
				rushHourActivity.map.map2[2][55][16]="n";
				rushHourActivity.map.map2[2][55][18]="a";
				rushHourActivity.map.map2[2][55][20]="n";
				rushHourActivity.map.map2[2][55][22]="a";
			}
			
			// 绘制第二层地图
			for (int i = 0; i < rushHourActivity.map.map1[2].length; i++) {
				for (int j = 0; j < rushHourActivity.map.map1[2][0].length; j++) {
					// 根据索引值进行坐标转换
					int X = initX + 32 * j;
					int Y = initY + 32 * i;
					
					if (rushHourActivity.map.map2[2][i][j].equals("b")) {// 树1
						canvas.drawBitmap(tree1, X, Y - 32, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("c")) {// 魔法石
						canvas.drawBitmap(gem3, X, Y - 8, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("d")) {// 礁石
						canvas.drawBitmap(stone3, X, Y - 18, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("e")) {// 树5
						canvas.drawBitmap(tree5, X, Y - 32, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("f")) {// 树3
						canvas.drawBitmap(tree4, X, Y - 32, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("g")) {// 生命之泉
						canvas.drawBitmap(spring, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("h")) {// 墙1
						canvas.drawBitmap(wall_1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("i")) {// 墙2
						canvas.drawBitmap(wall_2, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("j")) {// 墙
						canvas.drawBitmap(wall_door, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("k")) {// 门2
						canvas.drawBitmap(door_2, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("l")) {// 门1
						canvas.drawBitmap(door_1, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("m")) {// 激光1
						canvas.drawBitmap(laser1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("n")) {// 激光2
						canvas.drawBitmap(laser2, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("o")) {// 石碑
						canvas.drawBitmap(stone4, X, Y-32, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("p")) {// 墙5
						canvas.drawBitmap(wall_5, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("q")) {// 船
						canvas.drawBitmap(boat_right, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("s")) {// 门4
						canvas.drawBitmap(door_4, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("t")) {// 障碍物1
						canvas.drawBitmap(obstacle1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("u")) {// 树6
						canvas.drawBitmap(tree6, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("v")) {// 钥匙1
						canvas.drawBitmap(key1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("y")) {// 桌子1
						canvas.drawBitmap(table1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("z")) {// 树6
						canvas.drawBitmap(tree6, X, Y-18, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("1")) {// 宝箱 用于盛放地图
                            canvas.drawBitmap(box1, X, Y, paint);
					}
					else if (rushHourActivity.map.map2[2][i][j].equals("2")) {// 魔法箱
						canvas.drawBitmap(box1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("3")) {// 宝箱 用于盛放护身符
						canvas.drawBitmap(box1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("4")) {// 宝箱 用于盛放生命药水
						canvas.drawBitmap(box1, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("5")) {// 智者1
                        canvas.drawBitmap(sage, X, Y-22, paint);
				    }
				    else if (rushHourActivity.map.map2[2][i][j].equals("6")) {// 门5
					    canvas.drawBitmap(door_5, X, Y-18, paint);
				    } 
				    else if (rushHourActivity.map.map2[2][i][j].equals("7")) {// 车
					    canvas.drawBitmap(car_left, X, Y-18, paint);
				    } 
				    else if (rushHourActivity.map.map2[2][i][j].equals("8")) {// 钥匙2
					    canvas.drawBitmap(key2, X, Y, paint);
				    } 
				    else if (rushHourActivity.map.map2[2][i][j].equals("9")) {// 树4
						canvas.drawBitmap(tree4, X, Y - 32, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("!")) {//宝箱 用于盛放加时器
							canvas.drawBitmap(box1, X, Y, paint);
						} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("?")) {//闪电
						canvas.drawBitmap(lightning, X, Y-32, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("*")) {//金色能量石
						canvas.drawBitmap(gem2, X, Y, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("@")) {//门9
						canvas.drawBitmap(door_9, X, Y-18, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("#")) {//门10
						canvas.drawBitmap(door_10, X, Y-18, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("$")) {//门11
						canvas.drawBitmap(door_11, X, Y-18, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("=")) {//门4
						canvas.drawBitmap(door_4, X, Y-18, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("^")) {//钥匙3
						canvas.drawBitmap(key3, X, Y, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("&")) {//水元素
						canvas.drawBitmap(ball3, X, Y, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("+")) {//蓝色能量石
						canvas.drawBitmap(gem1, X, Y, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("-")) {//障碍物4
						canvas.drawBitmap(obstacle4, X, Y-18, paint);
					} 
					if (i == warrior.i
						&& j == warrior.j
						&&warriorState<3) {
						warrior.drawMySelf(canvas, paint);
					}
					}
				}
			
			canvas.drawBitmap(tool_background1, 0, 0, paint);
			canvas.drawBitmap(time_background1, 0, time_background1Y, paint);
			canvas.drawBitmap(watch, watchX,time_background1Y, paint);
			canvas.drawBitmap(time_background, time_backgroundX,time_backgroundY, paint);
			canvas.drawBitmap(key1, key1X,time_background1Y, paint);
			canvas.drawBitmap(time, timeX, timeY, paint);
			canvas.drawBitmap(system, 0, 0, paint);
			canvas.drawBitmap(life, lifeX, lifeY, paint);
			
			if (mapNum > 0) {
				canvas.drawBitmap(map, mapX, 0, paint);
			}
			if (amuletNum > 0) {
				canvas.drawBitmap(amulet, amuletX, 0, paint);
			}
			if (bottleNum > 0) {
				if (bottleNum == 3)
					canvas.drawBitmap(bottle3, bottleX, 0, paint);
				if (bottleNum == 2)
					canvas.drawBitmap(bottle2, bottleX, 0, paint);
				if (bottleNum == 1)
					canvas.drawBitmap(bottle1, bottleX, 0, paint);
			}
			if (gemNum > 0) {
				if (gemNum == 3)
					canvas.drawBitmap(ball3, gemX, 0, paint);
				if (gemNum == 2)
					canvas.drawBitmap(gem2, gemX, 0, paint);
				if (gemNum == 1)
					canvas.drawBitmap(gem1, gemX, 0, paint);
			}
			if (keyNum > 0) {
				if (keyNum == 1)
					canvas.drawBitmap(one, figureX, figureY, paint);
				if (keyNum == 2)
					canvas.drawBitmap(two, figureX, figureY, paint);
				if (keyNum == 3)
					canvas.drawBitmap(three, figureX, figureY, paint);
			}
			if (showTime > 0) {
				showTime--;
				if (information == 2) {// 智者
					canvas.drawBitmap(information2, informationX,informationY, paint1);
				}
				if (information == 3) {// 门
					canvas.drawBitmap(information3, informationX,informationY, paint1);
				}
				if (information == 4) {// 护身符
					canvas.drawBitmap(information4, informationX,informationY, paint1);
				}
				if (information == 6) {// 地图
					canvas.drawBitmap(information6, informationX,informationY, paint1);
				}
				if (information == 7) {// 生命药水
					canvas.drawBitmap(information7, informationX,informationY, paint1);
				}
				if (information == 8) {// 加时器
					canvas.drawBitmap(information8, informationX,informationY, paint1);
				}
				if (information == 12) {// 传送门
					canvas.drawBitmap(information12, informationX,informationY, paint1);
				}
				if (information == 16) {// 蓝色能量石
					canvas.drawBitmap(information16, informationX,informationY, paint1);
				}
				if (information == 17) {// 金色能量石
					canvas.drawBitmap(information17, informationX,informationY, paint1);
				}
				if (information == 21) {// 车
					canvas.drawBitmap(information21, informationX,informationY, paint1);
				}
				if (information == 22) {//门9
					canvas.drawBitmap(information22, informationX,informationY, paint1);
				}
				if (information == 25) {// 魔法箱
					canvas.drawBitmap(information25, informationX,informationY, paint1);
				}
				if (information == 26) {// 门5
					canvas.drawBitmap(information26, informationX,informationY, paint1);
				}
				if (information == 27) {// 水元素
					canvas.drawBitmap(information27, informationX,informationY, paint1);
				}
			}
			
			if (showMapTime > 0) {// 画小地图
				showMapTime--;
				if (showMapTime == 0) {
					touchThread.setFlag(true);
				}
				drawMap(canvas,level);
						}
			
			//穿过激光区
			if(warrior.j-3>0&&warrior.i-3>0){
			if(rushHourActivity.map.map2[2][warrior.i][warrior.j].equals("m")
		      ||rushHourActivity.map.map2[2][warrior.i][warrior.j-1].equals("m")
		      ||rushHourActivity.map.map2[2][warrior.i][warrior.j-2].equals("m")
		      ||rushHourActivity.map.map2[2][warrior.i][warrior.j-3].equals("m") ){
				if (process6>20){
					process6-=20;
					warrior.i--;
				}
				else if(process6>0&&process6<=20){
					process6=0;
					warrior.i--;
				}
			}
			if(rushHourActivity.map.map2[2][warrior.i][warrior.j].equals("n")
			   ||rushHourActivity.map.map2[2][warrior.i-1][warrior.j].equals("n")
			   ||rushHourActivity.map.map2[2][warrior.i-2][warrior.j].equals("n")
			   ||rushHourActivity.map.map2[2][warrior.i-3][warrior.j].equals("n")){
				if (process6>20){
					process6-=20;
					warrior.j--;
				}
				else if(process6>0&&process6<=20){
					process6=0;
					warrior.j--;
				}
			}
			}
			//木桩过河
			if(rushHourActivity.map.map1[2][warrior.i][warrior.j]==25){
				warriorState=3;
				WarriorRunThread.m=0;
				gameState=2;
				if (process6 > 5){
					process6-=5;
				}
				else if (process6 > 0&&process6<=5){
					process6=0;
				}
			}
			if(rushHourActivity.map.map1[2][warrior.i][warrior.j]==24){
				warriorState=0;
				if (process5 > 0 && process6 > 0){
				gameState=1;
				}
			}
			
			//传送区域
			if(rushHourActivity.map.map1[2][warrior.i][warrior.j]==-1){
				warrior.i=14;
				warrior.j=12;
				lifeState=1;
				rushHourActivity.map.map2[2][11][22]="q";
			}
            if(rushHourActivity.map.map1[2][warrior.i][warrior.j]==-2){
            	warrior.i=14;
				warrior.j=43;
				rushHourActivity.map.map2[2][11][22]="q";
			}
            if(rushHourActivity.map.map1[2][warrior.i][warrior.j]==-3){
            	warrior.i=47;
				warrior.j=43;
				rushHourActivity.map.map2[2][53][38]="q";
            }
            if(rushHourActivity.map.map1[2][warrior.i][warrior.j]==-4){
            warrior.i=47;
				warrior.j=12;
				speedState=1;
				rushHourActivity.map.map2[2][53][38]="q";
            }
           
			//打开门5
			if((warrior.i==56&&warrior.j==11)
				||(warrior.i==56&&warrior.j==12)
				||(warrior.i==56&&warrior.j==13)
				||(warrior.i==57&&warrior.j==11)
				||(warrior.i==57&&warrior.j==13)
				||(warrior.i==58&&warrior.j==11)
				||(warrior.i==58&&warrior.j==12)
				||(warrior.i==58&&warrior.j==13)){
				rushHourActivity.map.map1[2][warrior.i][warrior.j]=15;
			}
			if(rushHourActivity.map.map1[2][56][11]==15
			    &&rushHourActivity.map.map1[2][56][12]==15
				&&rushHourActivity.map.map1[2][56][13]==15
				&&rushHourActivity.map.map1[2][57][11]==15
				&&rushHourActivity.map.map1[2][57][13]==15
				&&rushHourActivity.map.map1[2][58][11]==15
				&&rushHourActivity.map.map1[2][58][12]==15
				&&rushHourActivity.map.map1[2][58][13]==15){
				rushHourActivity.map.map2[2][54][12]="a";
				}
			
			
			if (lifeState==1&&process6>0){
            	process6--;
            }
            if (lifeState==2&&process6<140){
            	process6+=20;
            }
            if (lifeState==2&&process6>=140&&process6<160){
            	process6=160;
            }
            //传送提示
            if (rushHourActivity.map.map1[2][warrior.i][warrior.j] == 10) {
				showTime = 1;
				information = 12;
			}
			//地雷爆炸
            for (int r = 0; r < explodeX5.length; r++) {
				if (warrior.i == explodeX5[r]
						&& warrior.j == explodeY5[r]
						&& rushHourActivity.map.map1[2][warrior.i][warrior.j] != 23) {
					rushHourActivity.map.map1[2][warrior.i][warrior.j] = 23;
					if(rushHourActivity.isSound==true){
						explodeSound.start();
					}
					if (process6>20){
						process6-=20;
					}
					else if(process6>0&&process6<=20){
						process6=0;
					}
				}
			}
            //电闪雷鸣
            for (int r = 0; r < lightningX2.length; r++) {
				if (warrior.i == lightningX2[r]&& warrior.j == lightningY2[r]
				    &&rushHourActivity.map.map1[2][warrior.i][warrior.j] != 26
				    &&rushHourActivity.map.map1[2][warrior.i][warrior.j] != 10) {
					rushHourActivity.map.map2[2][warrior.i][warrior.j] = "?";
					rushHourActivity.map.map1[2][warrior.i][warrior.j] = 26;
					if(rushHourActivity.isSound==true){
						lightningSound.start();
					}
					if (process6>20){
						process6-=20;
					}
					else if(process6>0&&process6<=20){
						process6=0;
					}
				}
			}
            
          //时间的流逝
            if (process5 > 0) {
				process5--;
			}
            
            canvas.drawRect(timeX + process5 * ((float) time.getWidth() / 3800), timeY,
					timeX + time.getWidth(), timeY + time.getHeight(), paint);
			canvas.drawRect(lifeX + process6 * ((float)life.getWidth() / 160), lifeY,
					lifeX + life.getWidth(), lifeY + life.getHeight(), paint);

			
			if (process5 <= 0 || process6 <= 0) {
				canvas.drawBitmap(game_over, game_overX, game_overY, paint);
				gameState=0;
				gameDrawThread.setFlag(false);
				
			}
			break;
		}
		canvas.drawBitmap(title1, title1X,title1Y, paint1);
	}
	}
		
	public boolean onTouchEvent(MotionEvent event) {
		if (gameState == 0) {
			rushHourActivity.myHandler.sendEmptyMessage(9);// 向Activity的Handler发送消息
		}
		else if (event.getX() > 0 && event.getX() < 32 && event.getY() > 0
				&& event.getY() < 32&&(gameState==1||gameState==2)) {// 点击了系统按钮
			gameState=3;
		}
		else if(gameState==3 && event.getY() > 192 && event.getY() < 238&& markState==0){//点击回到游戏
			gameState=1;
		}
        else if(gameState==3 && event.getY() > 192 && event.getY() < 238&& markState!=0){//点击回到游戏
        	markState=0;
		}
        else if(gameState==3 && event.getY() > 238 && event.getY() < 284&& markState==1){//点击音效设置
			gameState=4;
		}
        else if(gameState==3 && event.getY() > 238 && event.getY() < 284&& markState!=1){//点击音效设置
        	markState=1;
		}
        else if(gameState==3 && event.getY() > 284 && event.getY() < 330&& markState==2){//点击游戏帮助
			gameState=5;
		}
        else if(gameState==3 && event.getY() > 284 && event.getY() < 330&& markState!=2){//点击游戏帮助
        	markState=2;
		}
        else if(gameState==3 && event.getY() > 330 && event.getY() < 376&& markState==3){//点击主菜单
        	explodeSound = null;
    		lightningSound = null;
    		shootSound = null;
    		startSound = null;
    		if(boatSoundState==1){
				boatSound.pause();
			}
    		boatSound = null;
        	rushHourActivity.myHandler.sendEmptyMessage(2);// 向Activity的Handler发送消息
		}
        else if(gameState==3 && event.getY() > 330 && event.getY() < 376&& markState!=3){//点击主菜单
        	markState=3;
		}
        else if (gameState==4&&event.getX() > 80 && event.getX() < 239 && event.getY() > 218
				&& event.getY() < 262) {// 点击了音乐开启/关闭按钮
		if (rushHourActivity.isSound == true) {
			rushHourActivity.isSound = false;
			if(boatSoundState==1){
				boatSound.pause();
				boatSoundState=2;
			}
		} 
		else {
			rushHourActivity.isSound = true;
			if(boatSoundState==2){
				boatSound.start();
				boatSoundState=1;
			}
		}
		} 
        else if (gameState==4 && event.getX() > 144 && event.getX() < 176 && event.getY() > 400
			&& event.getY() < 432) {// 点击了返回菜单按钮
		gameState=3;
	    } 
        else if (gameState==5&&event.getX() > 144 && event.getX() < 176 && event.getY() > 400
				&& event.getY() < 432) {// 点击了返回菜单按钮
        	gameState=3;
		} 
	   else if (gameState==5&&event.getX() > 147 && event.getX() < 173 && event.getY() > 106
			&& event.getY() < 122) {// 点击了向上菜单按钮
		state=0;
	} 
	   else if (gameState==5&&event.getX() > 147 && event.getX() < 173 && event.getY() > 358
			&& event.getY() < 374) {// 点击了向下菜单按钮
		state=1;
	} 
	   else{
		switch (level) {
		case 1:
			if (event.getX() > 162 && event.getX() < 194 && event.getY() > 0
					&& event.getY() < 32 && bottleNum > 0 && gameState == 1) {// 点击了血瓶
				bottleNum--;
				if (process2 <= 4) {
					process2 += 2;
				} else if (process2 == 5) {
					process2++;
				}
			} else if (event.getX() > 226 && event.getX() < 258
					&& event.getY() > 0 && event.getY() < 32 && toolNum > 0
					&& gameState == 1) {// 点击了锯子
				if (rushHourActivity.map.map2[0][warrior.i][warrior.j - 1]
						.equals("h")
						&& WarriorRunThread.dir == 3) {
					toolNum--;
					rushHourActivity.map.map2[0][warrior.i][warrior.j - 1] = "a";
				} 
				else if (rushHourActivity.map.map2[0][warrior.i][warrior.j + 1]
						.equals("h")
						&& WarriorRunThread.dir == 4) {
					toolNum--;
					rushHourActivity.map.map2[0][warrior.i][warrior.j + 1] = "a";
				}
			} else if (event.getX() > 194 && event.getX() < 226
					&& event.getY() > 0 && event.getY() < 32 && mapNum > 0
					&& gameState == 1) {// 点击了地图
				mapNum--;
				showMapTime = 20;
				touchThread.setFlag(false);
			} else if (warrior.j == (int) event.getX() / 32+ J
					&& warrior.i == (int) event.getY() / 32+ I
					&& rushHourActivity.map.map1[0][warrior.i][warrior.j] == 3
					&& gameState == 1) {
				// 点击了传送门,进行传送
				int ran = (int) (Math.random() * 4);
				if (ran == 0) {
					warrior.i = 25;
					warrior.j = 5;
				}
				if (ran == 1) {
					warrior.i = 24;
					warrior.j = 14;
				}
				if (ran == 2) {
					warrior.i = 5;
					warrior.j = 20;
				}
				if (ran == 3) {
					warrior.i = 10;
					warrior.j = 23;
				}
			} else if (gameState == 1) {
				newX = (int) event.getX() / 32;
				newY = (int) event.getY() / 32;
				t = warrior.j - (newX + J);
				r = warrior.i - (newY + I);
				touchThread = new TouchThread(t, r, rushHourActivity);
				touchThread.start();
			}
			break;
		case 2:
			if (event.getX() > 162 && event.getX() < 194 && event.getY() > 0
					&& event.getY() < 32 && bottleNum > 0 && gameState == 1) {// 点击了血瓶
				bottleNum--;
				if (process4 <= 160) {
					process4 += 40;
				} 
				else if (process4 > 160&&process4<200) {
					process4=200;
				}
			} 
			else if (warrior.j == (int) event.getX() / 32 + J
					&& warrior.i == (int) event.getY() / 32 + I
					&& rushHourActivity.map.map1[1][warrior.i][warrior.j] == 6
					&& gameState == 1) {//点击传送门
				warrior.i=6;
				warrior.j=10;
			}
			else if (warrior.j == (int) event.getX() / 32 + J
					&& warrior.i == (int) event.getY() / 32 + I
					&& gemNum>0
					&& gameState == 1
					&& warriorState>0) {//点击车子
				if(rushHourActivity.isSound==true){
					shootSound.start();
				}
				Energy_ball energy_ball = new Energy_ball(WarriorRunThread.dir, rushHourActivity, gemNum);
				energy_ball.start();
			}
			else if (gameState == 1) {
				newX = (int) event.getX() / 32;
				newY = (int) event.getY() / 32;
				t = warrior.j - (newX + J);
				r = warrior.i - (newY + I);
				touchThread = new TouchThread(t, r, rushHourActivity);
				touchThread.start();
			}
			break;
		case 3:
			if (event.getX() > 162 && event.getX() < 194 && event.getY() > 0
					&& event.getY() < 32 && bottleNum > 0 && gameState == 1) {// 点击了血瓶
				bottleNum--;
				if (process6 <= 120) {
					process6 += 40;
				} else if (process6 > 120&&process6<160) {
					process6=160;
				}
			} 
			else if (warrior.j == (int) event.getX() / 32 + J
					&& warrior.i == (int) event.getY() / 32 + I
					&& rushHourActivity.map.map1[2][warrior.i][warrior.j] == 10
					&& gameState == 1) {//点击传送门
				if(warrior.i==17 &&warrior.j==15){
					warrior.i=17;
					warrior.j=18;
					lifeState=0;
				}
                if(warrior.i==17 &&warrior.j==40){
                	warrior.i=17;
					warrior.j=37;
				}
                if(warrior.i==50 &&warrior.j==15){
                	warrior.i=50;
					warrior.j=18;
					speedState=0;
                }
                if(warrior.i==50 &&warrior.j==40){
                	warrior.i=50;
					warrior.j=37;
                }
				
			}
			else if (warrior.j == (int) event.getX() / 32 + J
					&& warrior.i == (int) event.getY() / 32 + I
					&& gemNum>0
					&& gameState == 1
					&& warriorState>0) {//点击车(船)
				if(rushHourActivity.isSound==true){
					shootSound.start();
				}
				Energy_ball energy_ball = new Energy_ball(WarriorRunThread.dir, rushHourActivity, gemNum);
				energy_ball.start();
			}
			else if (event.getX() > 194 && event.getX() < 226
					&& event.getY() > 0 && event.getY() < 32 && mapNum > 0
					&& gameState == 1) {// 点击了地图
				mapNum--;
				showMapTime = 20;
				touchThread.setFlag(false);
			}
			else if (gameState == 1) {
				newX = (int) event.getX() / 32;
				newY = (int) event.getY() / 32;
				t =warrior.j - (newX + J);
				r = warrior.i - (newY + I);
				touchThread = new TouchThread(t, r, rushHourActivity);
				touchThread.start();
			}
			break;
		}
	   }
		return super.onTouchEvent(event);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
	}

	public void surfaceCreated(SurfaceHolder holder) {
		gameDrawThread.setFlag(true);
		gameDrawThread.start();
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		boolean retry = true;
		gameDrawThread.setFlag(false);
		while (retry) {
			try {
				gameDrawThread.join();
				retry = false;
			} 
			catch (InterruptedException e) {// 不断地循环，直到刷帧线程结束
			}
		}
	}

	public void scroll(int x, int y,int i) {// 滚屏方法
		if (x < 100 && J != 0) {// 距左边距100时
			rushHourActivity.gameView.initX += 32;
			warrior.X += 32;
			// if(i%4==0)
			rushHourActivity.gameView.J -= 1;
		}
		if (y < 180 && I != 0) {// 距上边距180时
			rushHourActivity.gameView.initY += 32;
			warrior.Y += 32;
			// if(i%4==0)
			rushHourActivity.gameView.I -= 1;
		}
		if (x > 220
				&& J != rushHourActivity.map.map1[i-1][0].length - 10) {// 距右边距100时
			rushHourActivity.gameView.initX -= 32;
			warrior.X -= 32;
			// if(i%4==0)
			rushHourActivity.gameView.J += 1;
		}
		if (y > 220
				&& I != rushHourActivity.map.map1[i-1].length - 15) {// 距下边距180时
			rushHourActivity.gameView.initY -= 32;
			warrior.Y -= 32;
			// if(i%4==0)
			rushHourActivity.gameView.I += 1;
		}
	}

	// 随机获得地雷坐标
	public int getCoordinate(int m, int n) {
		Random ran = new Random();
		int coordinate = ran.nextInt(m) + n;
		return coordinate;
	}
	// 随机获得一个数
	public int getOne(int m) {
		Random ran = new Random();
		int num = ran.nextInt(m);
		return num;
	}
	//画小地图
	public void drawMap(Canvas canvas,int level){
		canvas.drawBitmap(little_map, little_mapX, little_mapY, paint);
		switch(level){
		case 1:
		for (int i = 0; i < rushHourActivity.map.map1[0].length; i++) {
			for (int j = 0; j < rushHourActivity.map.map1[0][0].length; j++) {
				// 根据索引值进行坐标转换
				int X = XX1 + 4 * j;
				int Y = YY1 + 4 * i;
				String str = rushHourActivity.map.map2[0][i][j]
						.toLowerCase();
				if (rushHourActivity.map.map1[0][i][j] == 1) {
					canvas.drawBitmap(obstacle, X, Y, paint);
				}
				else if (str.equals("b")) {// 墙1
					canvas.drawBitmap(obstacle, X, Y, paint);
				} 
				else if (str.equals("c")) {// 墙2
					canvas.drawBitmap(obstacle, X, Y, paint);
				} 
				else if (str.equals("d")) {// 墙3
					canvas.drawBitmap(obstacle, X, Y, paint);
				} 
				else if (str.equals("e")) {// 箱子
					canvas.drawBitmap(obstacle, X, Y, paint);
				} 
				else if (str.equals("h")) {// 障碍物1
					canvas.drawBitmap(obstacle, X, Y, paint);
				} 
				else if (str.equals("i")) {// 障碍物2
					canvas.drawBitmap(obstacle, X, Y, paint);
				} 
				else if (rushHourActivity.map.map2[0][i][j]
						.equals("k")) {// 钥匙1
					canvas.drawBitmap(key, X, Y, paint);
				} 
				else if (rushHourActivity.map.map2[0][i][j]
						.equals("l")) {// 钥匙2
					canvas.drawBitmap(key, X, Y, paint);
				} 
				else if (str.equals("m")) {// 障碍物3
					canvas.drawBitmap(obstacle, X, Y, paint);
				}

				else if (rushHourActivity.map.map2[0][i][j].equals("o")) {// 钥匙3
					canvas.drawBitmap(key, X, Y, paint);
				}

				else if (str.equals("s")) {// 智者
					canvas.drawBitmap(obstacle, X, Y, paint);
				}

				else if (str.equals("v")) {// 墙4
					canvas.drawBitmap(obstacle, X, Y, paint);
				}

				else if (str.equals("x")) {// 智者2
					canvas.drawBitmap(obstacle, X, Y, paint);
				} 
				else if (str.equals("y")) {// 智者3
					canvas.drawBitmap(obstacle, X, Y, paint);
				} 
				else if (str.equals("j")) {// 终点传送门
					canvas.drawBitmap(destination, X, Y, paint);
				} 
				else {
					canvas.drawBitmap(road, X, Y, paint);
				}
				canvas.drawBitmap(myself, XX1
						+ warrior.j * 4, YY1
						+ warrior.i * 4, paint);
			}
		}
		break;
		case 3:
			for (int i = 0; i < rushHourActivity.map.map1[2].length; i++) {
				for (int j = 0; j < rushHourActivity.map.map1[2][0].length; j++) {
					// 根据索引值进行坐标转换
					int X = XX2 + 4 * j;
					int Y = YY2 + 4 * i;
					
					if (rushHourActivity.map.map2[2][i][j].equals("q")) {// 船
						   canvas.drawBitmap(boat, X, Y, paint);
						} 
					else if (rushHourActivity.map.map2[2][i][j].equals("7")) {// 车
					    	canvas.drawBitmap(car, X, Y, paint);
					    } 
				   
					else if (rushHourActivity.map.map2[2][i][j].equals("9")) {// 树4
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("b")) {// 树1
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("c")) {// 魔法石
						canvas.drawBitmap(destination, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("d")) {// 礁石
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("e")) {// 树5
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("f")) {// 树3
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("g")
							||rushHourActivity.map.map2[2][i][j].equals("G")) {// 生命之泉
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("h")) {// 墙1
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("i")) {// 墙2
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("j")) {// 墙
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("o")) {// 石碑
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("p")) {// 墙5
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("r")
							||rushHourActivity.map.map2[2][i][j].equals("R")) {// 游戏指南
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("t")) {// 障碍物1
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("u")) {// 障碍物2
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("v")) {// 钥匙1
						canvas.drawBitmap(key, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("y")
							||rushHourActivity.map.map2[2][i][j].equals("Y")) {// 桌子2
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("z")) {// 树6
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
					else if (rushHourActivity.map.map2[2][i][j].equals("5")) {// 智者1
						canvas.drawBitmap(obstacle, X, Y, paint);
				    }
				    else if (rushHourActivity.map.map2[2][i][j].equals("8")) {// 钥匙2
					    canvas.drawBitmap(key, X, Y, paint);
				    } 
				    else if (rushHourActivity.map.map2[2][i][j].equals("^")) {//钥匙3
						canvas.drawBitmap(key, X, Y, paint);
					} 
				    else if (rushHourActivity.map.map2[2][i][j].equals("-")) {//障碍物4
						canvas.drawBitmap(obstacle, X, Y, paint);
					} 
				    else if (rushHourActivity.map.map1[2][i][j]==6) {// 河
						canvas.drawBitmap(river, X, Y, paint);
					} 
				    else{
				    	canvas.drawBitmap(road, X, Y, paint);
				    }
					
					canvas.drawBitmap(myself, XX2
							+ warrior.j * 4, YY2
							+ warrior.i * 4, paint);
				}
			}
			break;
		}
	}
   
}