package game.rushHour;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Window;
import android.view.WindowManager;

public class RushHourActivity extends Activity {
	WelcomeView welcomeView = null;// 欢迎界面
	WelcomeDrawThread welcomeDrawThread;

	MenuView menuView = null;// 主菜单界面

	BackgroundView backgroundView = null;// 游戏背景界面
	BackgroundViewGoThread backgroundViewGoThread;
	
	SoundView soundView=null;

	HelpView helpView = null;// 帮助界面

	SetView setView=null;// 设置界面

	AboutView aboutView=null;// 关于界面

	GameView gameView=null;// 游戏界面

	StartView startView=null;// 闯关成功界面

	ProcessView processView;//加载界面
	
	ExitView exitView;//退出界面

	Map map;// 地图

	boolean isSound = false;// 是否播放声音
	MediaPlayer sound[]=new MediaPlayer[4];// 背景音乐

	Handler myHandler = new Handler() {// 用来更新UI线程中的控件
		public void handleMessage(Message msg) {
			if (msg.what == 0) {// 点击游戏背景后发来的消息
				soundView = null;
				goToWelcomeView();
			}
			if (msg.what == 1) {// 点击游戏背景后发来的消息
				welcomeView = null;
				goToBackgroundView();
			} else if (msg.what == 2) {// 在游戏系统菜单点击主菜单后发来的消息
				gameView = null;
				goToMenuView();
			} 
			  else if (msg.what == 3) {// 点击开始游戏后发来的消息
				menuView = null;
				goToStartView(0);
			} else if (msg.what == 4) {// 点击游戏设置后发来的消息
				menuView = null;
				goToSetView();
			} else if (msg.what == 5) {// 点击游戏帮助后发来的消息
				menuView = null;
				goToHelpView();
			} else if (msg.what == 6) {// 点击了音乐开启/关闭按钮
				setView=null;
				goToMenuView();
			} 
			else if (msg.what == 7) {// 在游戏背景界面点击主菜单后发来的消息
				backgroundView = null;
				welcomeView = null;
				backgroundViewGoThread.setFlag(false);
				goToMenuView();
			} else if (msg.what == 8) {// 点击关于游戏后发来的消息
				menuView = null;
				goToAboutView();
			} else if (msg.what == 9) {// 闯关失败后点击游戏屏幕发来的消息
				gameView = null;
				goToMenuView();
			} else if (msg.what == 10) {// 第一关闯关成功后发来的消息
				goToStartView(2);
			} else if (msg.what == 11) {// 点击第一关进入界面发来的消息
				startView = null;
				goToProcessView(1);
				new Thread(){//线程
		    		public void run(){
		    			Looper.prepare();
		    			gameViewPrepared(1);
		    			Looper.loop();
		    		}
		    	}.start();//启动线程
			}
			else if (msg.what == 12) {// 点击第二关进入界面发来的消息
				startView = null;
				goToProcessView(2);
				new Thread(){//线程
		    		public void run(){
		    			Looper.prepare();
		    			gameViewPrepared(2);
		    			Looper.loop();
		    		}
		    	}.start();//启动线程
			}
			else if (msg.what == 13) {// 点击第三关进入界面发来的消息
				startView = null;
				goToProcessView(3);
				new Thread(){//线程
		    		public void run(){
		    			Looper.prepare();
		    			gameViewPrepared(3);
		    			Looper.loop();
		    		}
		    	}.start();//启动线程
			}
			else if (msg.what == 14) {// 第二关闯关成功后发来的消息
				goToStartView(3);
			} 
			else if (msg.what == 15) {// 第三关闯关成功后发来的消息
				goToStartView(4);
			} 
			else if (msg.what == 16) {// 点击胜利界面主菜单后发来的消息
				startView=null;
				goToMenuView();
			} 
			else if (msg.what == 17) {// 游戏界面加载完后发来的消息
				processView=null;
				goToGameView();
			} 
			else if (msg.what == 18) {// 点击了退出游戏按钮
				menuView=null;
				goToExitView();
			} 
			else if (msg.what == 19) {// 点击了退出界面的否按钮
				exitView=null;
				goToMenuView();
			} 
		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 全屏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		sound[0] = MediaPlayer.create(this, R.raw.welcom_background);
		sound[0].setLooping(true);
		sound[1] = MediaPlayer.create(this, R.raw.level1);
		sound[2] = MediaPlayer.create(this, R.raw.level2);
		sound[3] = MediaPlayer.create(this, R.raw.level3);
		goToSoundView();

	}

	public void goToSoundView(){
		soundView = new SoundView(this);
		this.setContentView(soundView);
	}
	
	public void goToExitView(){
		exitView = new ExitView(this);
		this.setContentView(exitView);
	}
	
	public void goToWelcomeView() {
		welcomeView = new WelcomeView(this);
		if (isSound == true) {
			this.sound[0].start();// 播放声音
		} 
		this.setContentView(welcomeView);
	}

	public void goToMenuView() {
		menuView = new MenuView(this);
		this.setContentView(menuView);
	}

	public void goToBackgroundView() {
		backgroundView = new BackgroundView(this);
		this.setContentView(backgroundView);
		backgroundViewGoThread = new BackgroundViewGoThread(this);
		backgroundViewGoThread.start();
	}

	public void goToHelpView() {
		helpView = new HelpView(this);
		this.setContentView(helpView);
	}

	public void goToAboutView() {
		aboutView = new AboutView(this);
		this.setContentView(aboutView);
	}

	public void goToStartView(int i) {
        sound[0].pause();
		startView = new StartView(this,i);
		this.setContentView(startView);
	}

	public void gameViewPrepared(int level) {
		map = new Map(this);
		gameView = new GameView(RushHourActivity.this, level);
	}
	public void goToGameView() {
		this.setContentView(gameView);
	}
	public void goToProcessView(int level) {
		processView=new ProcessView(this, level);
		this.setContentView(processView);
	}

	public void goToSetView() {
		setView = new SetView(this);
		this.setContentView(setView);
	}
	public void setSound(int state){
		if (isSound == false) {
			this.sound[state].pause();// 停止播放声音
		} 
		else {
			this.sound[state].start();// 开始播放声音
		}
	}
}