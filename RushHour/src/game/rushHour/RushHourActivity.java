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
	WelcomeView welcomeView = null;// ��ӭ����
	WelcomeDrawThread welcomeDrawThread;

	MenuView menuView = null;// ���˵�����

	BackgroundView backgroundView = null;// ��Ϸ��������
	BackgroundViewGoThread backgroundViewGoThread;
	
	SoundView soundView=null;

	HelpView helpView = null;// ��������

	SetView setView=null;// ���ý���

	AboutView aboutView=null;// ���ڽ���

	GameView gameView=null;// ��Ϸ����

	StartView startView=null;// ���سɹ�����

	ProcessView processView;//���ؽ���
	
	ExitView exitView;//�˳�����

	Map map;// ��ͼ

	boolean isSound = false;// �Ƿ񲥷�����
	MediaPlayer sound[]=new MediaPlayer[4];// ��������

	Handler myHandler = new Handler() {// ��������UI�߳��еĿؼ�
		public void handleMessage(Message msg) {
			if (msg.what == 0) {// �����Ϸ������������Ϣ
				soundView = null;
				goToWelcomeView();
			}
			if (msg.what == 1) {// �����Ϸ������������Ϣ
				welcomeView = null;
				goToBackgroundView();
			} else if (msg.what == 2) {// ����Ϸϵͳ�˵�������˵���������Ϣ
				gameView = null;
				goToMenuView();
			} 
			  else if (msg.what == 3) {// �����ʼ��Ϸ��������Ϣ
				menuView = null;
				goToStartView(0);
			} else if (msg.what == 4) {// �����Ϸ���ú�������Ϣ
				menuView = null;
				goToSetView();
			} else if (msg.what == 5) {// �����Ϸ������������Ϣ
				menuView = null;
				goToHelpView();
			} else if (msg.what == 6) {// ��������ֿ���/�رհ�ť
				setView=null;
				goToMenuView();
			} 
			else if (msg.what == 7) {// ����Ϸ�������������˵���������Ϣ
				backgroundView = null;
				welcomeView = null;
				backgroundViewGoThread.setFlag(false);
				goToMenuView();
			} else if (msg.what == 8) {// ���������Ϸ��������Ϣ
				menuView = null;
				goToAboutView();
			} else if (msg.what == 9) {// ����ʧ�ܺ�����Ϸ��Ļ��������Ϣ
				gameView = null;
				goToMenuView();
			} else if (msg.what == 10) {// ��һ�ش��سɹ���������Ϣ
				goToStartView(2);
			} else if (msg.what == 11) {// �����һ�ؽ�����淢������Ϣ
				startView = null;
				goToProcessView(1);
				new Thread(){//�߳�
		    		public void run(){
		    			Looper.prepare();
		    			gameViewPrepared(1);
		    			Looper.loop();
		    		}
		    	}.start();//�����߳�
			}
			else if (msg.what == 12) {// ����ڶ��ؽ�����淢������Ϣ
				startView = null;
				goToProcessView(2);
				new Thread(){//�߳�
		    		public void run(){
		    			Looper.prepare();
		    			gameViewPrepared(2);
		    			Looper.loop();
		    		}
		    	}.start();//�����߳�
			}
			else if (msg.what == 13) {// ��������ؽ�����淢������Ϣ
				startView = null;
				goToProcessView(3);
				new Thread(){//�߳�
		    		public void run(){
		    			Looper.prepare();
		    			gameViewPrepared(3);
		    			Looper.loop();
		    		}
		    	}.start();//�����߳�
			}
			else if (msg.what == 14) {// �ڶ��ش��سɹ���������Ϣ
				goToStartView(3);
			} 
			else if (msg.what == 15) {// �����ش��سɹ���������Ϣ
				goToStartView(4);
			} 
			else if (msg.what == 16) {// ���ʤ���������˵���������Ϣ
				startView=null;
				goToMenuView();
			} 
			else if (msg.what == 17) {// ��Ϸ����������������Ϣ
				processView=null;
				goToGameView();
			} 
			else if (msg.what == 18) {// ������˳���Ϸ��ť
				menuView=null;
				goToExitView();
			} 
			else if (msg.what == 19) {// ������˳�����ķ�ť
				exitView=null;
				goToMenuView();
			} 
		}
	};

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// ȫ��
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
			this.sound[0].start();// ��������
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
			this.sound[state].pause();// ֹͣ��������
		} 
		else {
			this.sound[state].start();// ��ʼ��������
		}
	}
}