package game.rushHour;

/**
 * 
 * 勇士移动线程类 给定初始位置和结束位置所在的行列 自动计算成实际坐标 当距边界较近时自动滚屏
 * 
 */
public class WarriorRunThread extends Thread {
	RushHourActivity rushHourActivity;// Activity的引用

	static int dir;// 方向
	static int m;// 走的坐标数
	int level;// 关卡
	boolean bool = true;

	public WarriorRunThread(int dir, RushHourActivity rushHourActivity, int m,
			int level) {// 构造器
		WarriorRunThread.dir = dir;
		this.rushHourActivity = rushHourActivity;
		WarriorRunThread.m = m;
		this.level = level;
	}

	public void run() {
		if (bool) {
			rushHourActivity.gameView.warrior.X = rushHourActivity.gameView.initX
					+ 32 * rushHourActivity.gameView.warrior.j;

			rushHourActivity.gameView.warrior.Y = rushHourActivity.gameView.initY
					+ 32 * rushHourActivity.gameView.warrior.i;// 调整坐标
			switch (level) {
			case 1:
				if (dir == 1) {// 向上

					rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manUp[3];

					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("x")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 1;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("s")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 2;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("y")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 3;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("p")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 5;
						rushHourActivity.gameView.toolNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("q")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 6;
						rushHourActivity.gameView.mapNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("r")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 4;
						rushHourActivity.gameView.amuletNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.sleep1 = 200;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("t")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						if (rushHourActivity.gameView.process1 <= 2450)
							rushHourActivity.gameView.process1 += 250;
						else
							rushHourActivity.gameView.process1 = 2700;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("j")
							&& rushHourActivity.gameView.keyNum == 3) {
						rushHourActivity.myHandler.sendEmptyMessage(10);// 向Activity的Handler发送消息
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("w")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("n")
							&& (rushHourActivity.gameView.keyNum == 1)) {
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("z")
							&& (rushHourActivity.gameView.keyNum == 2)) {
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.gameView.warrior.i == 2
							&& rushHourActivity.gameView.warrior.j == 14) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 9;
						rushHourActivity.map.map2[0][14][14] = "a";
						for (int t = 15; t <= 22; t++) {
							for (int i = 9; i < 19; i++) {
								rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
										.toLowerCase();
							}
						}
					}
					if (rushHourActivity.gameView.warrior.i == 2
							&& rushHourActivity.gameView.warrior.j == 1) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 9;
						rushHourActivity.map.map2[0][18][1] = "a";
						rushHourActivity.map.map2[0][17][1] = "a";
						for (int t = 19; t <= 25; t++) {
							for (int i = 1; i < 4; i++) {
								rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
										.toLowerCase();
							}
						}
					}
					if (!(rushHourActivity.gameView.warrior.i <= 0)
							&& rushHourActivity.map.map1[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] != 1
							&& (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
									.equals("a")
									|| rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
											.equals("f")
									|| rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
											.equals("k") || rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
									.equals("o"))) {
						// 可以移动的时
						if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
								.equals("f")) {
							rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
							if (rushHourActivity.gameView.warrior.i - 1 == 12
									&& rushHourActivity.gameView.warrior.j == 25) {
								for (int t = 8; t <= 11; t++) {
									for (int i = 24; i <= 26; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
							if (rushHourActivity.gameView.warrior.i - 1 == 7
									&& rushHourActivity.gameView.warrior.j == 26) {
								for (int t = 2; t <= 6; t++) {
									for (int i = 24; i <= 26; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
						}
						if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
								.equals("k")) {
							rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
							rushHourActivity.map.map2[0][6][9] = "A";
							rushHourActivity.gameView.keyNum++;
						}
						if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
								.equals("o")) {
							rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
							rushHourActivity.gameView.keyNum++;
						}

						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;
						for (int i = 0; i < 4 * m; i++) {

							rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manUp[i % 4];
							rushHourActivity.gameView.warrior.Y -= 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.i -= 1;

								if (!(rushHourActivity.gameView.warrior.i <= 0)
										&& rushHourActivity.map.map1[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] != 1
										&& (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
												.equals("a") || rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
												.equals("f"))) {
									// 可以移动的时

									if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
											.equals("f")) {
										rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
										if (rushHourActivity.gameView.warrior.i - 1 == 12
												&& rushHourActivity.gameView.warrior.j == 25) {
											for (int t = 8; t <= 11; t++) {
												for (int u = 24; u <= 26; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
										if (rushHourActivity.gameView.warrior.i - 1 == 7
												&& rushHourActivity.gameView.warrior.j == 26) {
											for (int t = 2; t <= 6; t++) {
												for (int u = 24; u <= 26; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
									}
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						rushHourActivity.gameView.warrior.isRun = false;
					}

				} else if (dir == 2) {// 向下

					rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manDown[3];

					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("x")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 1;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("u")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 20;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("s")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 2;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("y")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 3;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("p")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 5;
						rushHourActivity.gameView.toolNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("q")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 6;
						rushHourActivity.gameView.mapNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("r")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 4;
						rushHourActivity.gameView.amuletNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.sleep1 = 200;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("t")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						if (rushHourActivity.gameView.process1 <= 2450)
							rushHourActivity.gameView.process1 += 250;
						else
							rushHourActivity.gameView.process1 = 2700;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("w")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (!(rushHourActivity.gameView.warrior.i >= rushHourActivity.map.map1[0].length - 1)
							&& rushHourActivity.map.map1[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] != 1
							&& (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
									.equals("a") || rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
									.equals("f"))) {
						// 可以移动的时
						if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
								.equals("f")) {
							rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
							if (rushHourActivity.gameView.warrior.i + 1 == 14
									&& rushHourActivity.gameView.warrior.j == 11) {
								for (int t = 15; t <= 22; t++) {
									for (int i = 9; i < 19; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
							if (rushHourActivity.gameView.warrior.i + 1 == 12
									&& rushHourActivity.gameView.warrior.j == 2) {
								for (int t = 13; t <= 17; t++) {
									for (int i = 1; i < 4; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
						}
						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;

						for (int i = 0; i < 4 * m; i++) {

							rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manDown[i % 4];
							rushHourActivity.gameView.warrior.Y += 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.i += 1;

								if (!(rushHourActivity.gameView.warrior.i >= rushHourActivity.map.map1[0].length - 1)
										&& rushHourActivity.map.map1[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] != 1
										&& (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
												.equals("a") || rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
												.equals("f"))) {
									// 可以移动的时
									if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
											.equals("f")) {
										rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
										if (rushHourActivity.gameView.warrior.i + 1 == 14
												&& rushHourActivity.gameView.warrior.j == 11) {
											for (int t = 15; t <= 22; t++) {
												for (int u = 9; u < 19; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
										if (rushHourActivity.gameView.warrior.i + 1 == 12
												&& rushHourActivity.gameView.warrior.j == 2) {
											for (int t = 13; t <= 17; t++) {
												for (int u = 1; u < 4; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
									}
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						rushHourActivity.gameView.warrior.isRun = false;
					}

				} else if (dir == 3) {// 向左

					rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manLeft[3];

					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("x")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 1;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("s")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 2;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("y")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 3;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("p")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 5;
						rushHourActivity.gameView.toolNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("q")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 6;
						rushHourActivity.gameView.mapNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("r")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 4;
						rushHourActivity.gameView.amuletNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						rushHourActivity.gameView.sleep1 = 200;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("t")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						if (rushHourActivity.gameView.process1 <= 2450)
							rushHourActivity.gameView.process1 += 250;
						else
							rushHourActivity.gameView.process1 = 2700;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("w")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
					}
					if (!(rushHourActivity.gameView.warrior.j <= 0)
							&& rushHourActivity.map.map1[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] != 1
							&& (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
									.equals("a")
									|| rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
											.equals("g") || rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
									.equals("l"))) {
						// 可以移动时
						if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
								.equals("g")) {
							rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
							rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j - 1] = "c";
							if (rushHourActivity.gameView.amuletNum == 0
									&& rushHourActivity.gameView.warrior.i == 18
									&& rushHourActivity.gameView.warrior.j - 1 == 19) {
								rushHourActivity.gameView.sleep1 = 600;
							}
							if (rushHourActivity.gameView.warrior.i == 18
									&& rushHourActivity.gameView.warrior.j - 1 == 19) {
								for (int t = 15; t <= 22; t++) {
									for (int i = 17; i < 19; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
							if (rushHourActivity.gameView.warrior.i == 5
									&& rushHourActivity.gameView.warrior.j - 1 == 19) {
								for (int t = 2; t <= 13; t++) {
									for (int i = 13; i < 19; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
							if (rushHourActivity.gameView.warrior.i == 7
									&& rushHourActivity.gameView.warrior.j - 1 == 12) {
								for (int t = 2; t <= 13; t++) {
									for (int i = 9; i < 12; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
							if (rushHourActivity.gameView.warrior.i == 25
									&& rushHourActivity.gameView.warrior.j - 1 == 4) {
								for (int t = 19; t <= 25; t++) {
									for (int i = 1; i < 4; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
							if (rushHourActivity.gameView.warrior.i == 15
									&& rushHourActivity.gameView.warrior.j - 1 == 4) {
								for (int t = 13; t <= 17; t++) {
									for (int i = 1; i < 4; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
							if (rushHourActivity.gameView.warrior.i == 4
									&& rushHourActivity.gameView.warrior.j - 1 == 4) {
								for (int t = 2; t <= 11; t++) {
									for (int i = 1; i < 4; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
						}
						if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
								.equals("l")) {
							rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
							rushHourActivity.gameView.keyNum++;
						}
						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;
						for (int i = 0; i < 4 * m; i++) {

							rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manLeft[i % 4];
							rushHourActivity.gameView.warrior.X -= 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.j -= 1;

								if (!(rushHourActivity.gameView.warrior.j <= 0)
										&& rushHourActivity.map.map1[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] != 1
										&& (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
												.equals("a") || rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
												.equals("g"))) {
									// 可以移动时
									if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
											.equals("g")) {
										rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
										rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j - 1] = "c";
										if (rushHourActivity.gameView.amuletNum == 0
												&& rushHourActivity.gameView.warrior.i == 18
												&& rushHourActivity.gameView.warrior.j - 1 == 19) {
											rushHourActivity.gameView.sleep1 = 600;
										}
										if (rushHourActivity.gameView.warrior.i == 18
												&& rushHourActivity.gameView.warrior.j - 1 == 19) {
											for (int t = 15; t <= 22; t++) {
												for (int u = 17; u < 19; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
										if (rushHourActivity.gameView.warrior.i == 5
												&& rushHourActivity.gameView.warrior.j - 1 == 19) {
											for (int t = 2; t <= 13; t++) {
												for (int u = 13; u < 19; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
										if (rushHourActivity.gameView.warrior.i == 7
												&& rushHourActivity.gameView.warrior.j - 1 == 12) {
											for (int t = 2; t <= 13; t++) {
												for (int u = 9; u < 12; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
										if (rushHourActivity.gameView.warrior.i == 25
												&& rushHourActivity.gameView.warrior.j - 1 == 4) {
											for (int t = 19; t <= 25; t++) {
												for (int u = 1; u < 4; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
										if (rushHourActivity.gameView.warrior.i == 15
												&& rushHourActivity.gameView.warrior.j - 1 == 4) {
											for (int t = 13; t <= 17; t++) {
												for (int u = 1; u < 4; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
										if (rushHourActivity.gameView.warrior.i == 4
												&& rushHourActivity.gameView.warrior.j - 1 == 4) {
											for (int t = 2; t <= 11; t++) {
												for (int u = 1; u < 4; i++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
									}
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						rushHourActivity.gameView.warrior.isRun = false;
					}

				} else if (dir == 4) {// 向右

					rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manRight[3];

					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("x")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 1;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("s")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 2;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("y")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 3;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("p")) {
						rushHourActivity.gameView.showTime = 30;
						rushHourActivity.gameView.information = 5;
						rushHourActivity.gameView.toolNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("q")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 6;
						rushHourActivity.gameView.mapNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("r")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 4;
						rushHourActivity.gameView.amuletNum = 1;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						rushHourActivity.gameView.sleep1 = 200;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("t")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						if (rushHourActivity.gameView.process1 <= 2450)
							rushHourActivity.gameView.process1 += 250;
						else
							rushHourActivity.gameView.process1 = 2700;
					}
					if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("w")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
						rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (!(rushHourActivity.gameView.warrior.j + 1 > rushHourActivity.map.map1[0][0].length - 1)
							&& rushHourActivity.map.map1[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 1
							&& (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("a") || rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("g"))) {
						// 可以移动时
						if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
								.equals("g")) {
							rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
							rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j + 1] = "c";
							if (rushHourActivity.gameView.warrior.i == 18
									&& rushHourActivity.gameView.warrior.j + 1 == 23) {
								for (int t = 13; t <= 22; t++) {
									for (int i = 24; i <= 26; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
							if (rushHourActivity.gameView.warrior.i == 5
									&& rushHourActivity.gameView.warrior.j + 1 == 23) {
								for (int t = 2; t <= 6; t++) {
									for (int i = 24; i <= 26; i++) {
										rushHourActivity.map.map2[0][t][i] = rushHourActivity.map.map2[0][t][i]
												.toLowerCase();
									}
								}
							}
						}
						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;

						for (int i = 0; i < 4 * m; i++) {

							rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manRight[i % 4];
							rushHourActivity.gameView.warrior.X += 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.j += 1;

								if (!(rushHourActivity.gameView.warrior.j + 1 > rushHourActivity.map.map1[0][0].length - 1)
										&& rushHourActivity.map.map1[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 1
										&& (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
												.equals("a") || rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
												.equals("g"))) {
									// 可以移动时
									if (rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
											.equals("g")) {
										rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
										rushHourActivity.map.map2[0][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j + 1] = "c";
										if (rushHourActivity.gameView.warrior.i == 18
												&& rushHourActivity.gameView.warrior.j + 1 == 23) {
											for (int t = 13; t <= 22; t++) {
												for (int u = 24; u <= 26; u++) {
													rushHourActivity.map.map2[0][t][u] = rushHourActivity.map.map2[0][t][u]
															.toLowerCase();
												}
											}
										}
									}
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);// 睡眠
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						rushHourActivity.gameView.warrior.isRun = false;
					}
				}
				break;
			case 2:
				if (dir == 1) {// 向上

					if (rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manUp[3];
					}
					if (rushHourActivity.gameView.warriorState == 1) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carUp[0];
					}

					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("K")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
									.equals("k")) {
						rushHourActivity.gameView.lifeState = 2;
					}
					if (!(rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("K") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("k"))
							&& rushHourActivity.gameView.lifeState == 2) {
						rushHourActivity.gameView.lifeState = 0;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("o")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("u")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 9;
						rushHourActivity.map.map2[1][13][17] = "a";
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "U";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("m")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 11;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("s")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 23;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("9")
							&& rushHourActivity.gameView.keyNum == 3) {
						rushHourActivity.myHandler.sendEmptyMessage(14);// 向Activity的Handler发送消息
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("6")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 22;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("2")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 20;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("y")
							&& rushHourActivity.gameView.door_key == 1) {
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("w")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("x")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 15;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("0")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 16;
						rushHourActivity.gameView.gemNum = 1;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("r")) {
						rushHourActivity.gameView.showTime = 40;
						rushHourActivity.gameView.information = 14;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("L")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 18;
						rushHourActivity.gameView.truncheonNum = 1;
						rushHourActivity.map.map1[1][13][34] = 3;
						rushHourActivity.map.map1[1][17][34] = 3;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "l";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("v")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						if (rushHourActivity.gameView.process3 <= 2950)
							rushHourActivity.gameView.process3 += 250;
						else
							rushHourActivity.gameView.process3 = 3200;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("t")
							&& rushHourActivity.gameView.keyNum == 2) {
						rushHourActivity.gameView.warriorState = 1;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.sleep1 = 100;
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.startSound.start();
						}
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("t")
							&& !(rushHourActivity.gameView.keyNum == 2)) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 21;
					}
					if (!(rushHourActivity.gameView.warrior.i <= 0)
							&& (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
									.equals("a") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
									.equals("4"))) {
						// 可以移动的时
						if (rushHourActivity.gameView.warrior.i - 1 == 6
								&& rushHourActivity.gameView.warrior.j == 38) {
							rushHourActivity.gameView.sleep1 = 600;
						}
						if (rushHourActivity.gameView.warrior.i - 1 == 17
								&& rushHourActivity.gameView.warrior.j == 32) {
							rushHourActivity.gameView.lifeState = 0;
						}
						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;
						for (int i = 0; i < 4 * m; i++) {
							if (rushHourActivity.gameView.warriorState == 0) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manUp[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 1) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carUp[i % 4];
							}
							rushHourActivity.gameView.warrior.Y -= 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.i -= 1;

								if (!(rushHourActivity.gameView.warrior.i <= 0)
										&& (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
												.equals("a") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
												.equals("4"))) {
									// 可以移动的时
									if (rushHourActivity.gameView.warrior.i - 1 == 6
											&& rushHourActivity.gameView.warrior.j == 38) {
										rushHourActivity.gameView.sleep1 = 600;
									}
									if (rushHourActivity.gameView.warrior.i - 1 == 17
											&& rushHourActivity.gameView.warrior.j == 32) {
										rushHourActivity.gameView.lifeState = 0;
									}
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						rushHourActivity.gameView.warrior.isRun = false;
					}

				} else if (dir == 2) {// 向下

					if (rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manDown[3];
					}
					if (rushHourActivity.gameView.warriorState == 1) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carDown[0];
					}

					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("K")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
									.equals("k")) {
						rushHourActivity.gameView.lifeState = 2;
					}
					if (!(rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("K") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("k"))
							&& rushHourActivity.gameView.lifeState == 2) {
						rushHourActivity.gameView.lifeState = 0;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("o")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("m")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 11;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("s")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 23;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("z")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("N")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 19;
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.gameView.door_key = 1;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("n")) {
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("r")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 14;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("L")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 18;
						rushHourActivity.gameView.truncheonNum = 1;
						rushHourActivity.map.map1[1][13][34] = 3;
						rushHourActivity.map.map1[1][17][34] = 3;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "l";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("v")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						if (rushHourActivity.gameView.process3 <= 2950)
							rushHourActivity.gameView.process3 += 250;
						else
							rushHourActivity.gameView.process3 = 3200;
					}
					if (!(rushHourActivity.gameView.warrior.i >= rushHourActivity.map.map1[1].length - 1)
							&& (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
									.equals("a") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
									.equals("4"))) {
						// 可以移动的时
						if (rushHourActivity.gameView.warrior.i + 1 == 8
								&& rushHourActivity.gameView.warrior.j == 38) {
							rushHourActivity.gameView.sleep1 = 200;
						}
						if (rushHourActivity.gameView.warrior.i + 1 == 20
								&& rushHourActivity.gameView.warrior.j == 32) {
							rushHourActivity.gameView.lifeState = 1;
						}
						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;

						for (int i = 0; i < 4 * m; i++) {
							if (rushHourActivity.gameView.warriorState == 0) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manDown[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 1) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carDown[i % 4];
							}
							rushHourActivity.gameView.warrior.Y += 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.i += 1;

								if (!(rushHourActivity.gameView.warrior.i >= rushHourActivity.map.map1[1].length - 1)
										&& (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
												.equals("a") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
												.equals("4"))) {
									// 可以移动的时
									if (rushHourActivity.gameView.warrior.i + 1 == 8
											&& rushHourActivity.gameView.warrior.j == 38) {
										rushHourActivity.gameView.sleep1 = 200;
									}
									if (rushHourActivity.gameView.warrior.i + 1 == 20
											&& rushHourActivity.gameView.warrior.j == 32) {
										rushHourActivity.gameView.lifeState = 1;
									}
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						rushHourActivity.gameView.warrior.isRun = false;
					}

				} else if (dir == 3) {// 向左

					if (rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manLeft[3];
					}
					if (rushHourActivity.gameView.warriorState == 1) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carLeft[0];
					}

					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("K")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
									.equals("k")) {
						rushHourActivity.gameView.lifeState = 2;
					}
					if (!(rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("K") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("k"))
							&& rushHourActivity.gameView.lifeState == 2) {
						rushHourActivity.gameView.lifeState = 0;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("o")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("m")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 11;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("s")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 23;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("u")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 9;
						rushHourActivity.map.map2[1][13][17] = "a";
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "U";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("w")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("z")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("N")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 19;
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.gameView.door_key = 1;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("n")) {
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("q")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 13;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("x")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 15;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("L")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 18;
						rushHourActivity.gameView.truncheonNum = 1;
						rushHourActivity.map.map1[1][13][34] = 3;
						rushHourActivity.map.map1[1][17][34] = 3;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "l";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("1")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 17;
						rushHourActivity.gameView.gemNum = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";

					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("v")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						if (rushHourActivity.gameView.process3 <= 2950)
							rushHourActivity.gameView.process3 += 250;
						else
							rushHourActivity.gameView.process3 = 3200;
					}
					if (!(rushHourActivity.gameView.warrior.j <= 0)
							&& (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
									.equals("a") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
									.equals("4"))) {
						// 可以移动时

						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;
						for (int i = 0; i < 4 * m; i++) {
							if (rushHourActivity.gameView.warriorState == 0) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manLeft[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 1) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carLeft[i % 4];
							}
							rushHourActivity.gameView.warrior.X -= 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.j -= 1;

								if (!(rushHourActivity.gameView.warrior.j <= 0)
										&& (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
												.equals("a") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
												.equals("4"))) {
									// 可以移动时
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						rushHourActivity.gameView.warrior.isRun = false;
					}

				} else if (dir == 4) {// 向右

					if (rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manRight[3];
					}
					if (rushHourActivity.gameView.warriorState == 1) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carRight[0];
					}

					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("K")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("k")) {
						rushHourActivity.gameView.lifeState = 2;
					}
					if (!(rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("K") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("k"))
							&& rushHourActivity.gameView.lifeState == 2) {
						rushHourActivity.gameView.lifeState = 0;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("o")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("m")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 11;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("G")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("H")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("I")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("J")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 24;
						rushHourActivity.gameView.process4 -= 120;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("g")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("h")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("i")
							|| rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("j")) {
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("s")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 23;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("u")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 9;
						rushHourActivity.map.map2[1][13][17] = "a";
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "U";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("N")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 19;
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.gameView.door_key = 1;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("n")) {
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("r")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 14;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("x")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 15;
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("L")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 18;
						rushHourActivity.gameView.truncheonNum = 1;
						rushHourActivity.map.map1[1][13][34] = 3;
						rushHourActivity.map.map1[1][17][34] = 3;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "l";
					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("0")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 16;
						rushHourActivity.gameView.gemNum = 1;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";

					}
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("v")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						if (rushHourActivity.gameView.process3 <= 2950)
							rushHourActivity.gameView.process3 += 250;
						else
							rushHourActivity.gameView.process3 = 3200;
					}
					if (!(rushHourActivity.gameView.warrior.j + 1 > rushHourActivity.map.map1[1][0].length - 1)
							&& (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("a") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("4"))
							&& rushHourActivity.map.map1[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] >= 0) {
						// 可以移动时

						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;

						for (int i = 0; i < 4 * m; i++) {
							if (rushHourActivity.gameView.warriorState == 0) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manRight[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 1) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carRight[i % 4];
							}
							rushHourActivity.gameView.warrior.X += 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.j += 1;

								if (!(rushHourActivity.gameView.warrior.j + 1 > rushHourActivity.map.map1[1][0].length - 1)
										&& (rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
												.equals("a") || rushHourActivity.map.map2[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
												.equals("4"))
										&& rushHourActivity.map.map1[1][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] >= 0) {
									// 可以移动时
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);// 睡眠
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						rushHourActivity.gameView.warrior.isRun = false;
					}
				}
				break;
			case 3:
				if (dir == 1) {// 向上

					if (rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manUp[3];
					}
					if (rushHourActivity.gameView.warriorState == 1) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carUp[0];
					}
					if (rushHourActivity.gameView.warriorState == 2) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.boatUp[0];
					}

					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("c")) {
						rushHourActivity.myHandler.sendEmptyMessage(15);// 向Activity的Handler发送消息
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("q")
							&& rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warriorState = 2;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.startSound.start();
						}
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.boatSound.start();
							rushHourActivity.gameView.boatSoundState = 1;
						} else
							rushHourActivity.gameView.boatSoundState = 2;
					}
					if (rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] == 21
							&& rushHourActivity.gameView.warriorState == 1
							&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
									.equals("a")) {
						rushHourActivity.gameView.warriorState = 0;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j] = "7";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("7")
							&& rushHourActivity.gameView.keyNum >= 2) {
						rushHourActivity.gameView.warriorState = 1;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.startSound.start();
						}
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("7")
							&& rushHourActivity.gameView.keyNum == 1) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 21;
					}
					if (rushHourActivity.gameView.warriorState == 2
							&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
									.equals("a")
							&& (rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] == 20 || rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] == 21)) {
						if (rushHourActivity.gameView.boatSoundState == 1) {
							rushHourActivity.gameView.boatSound.pause();
							rushHourActivity.gameView.boatSoundState = 0;
						}
						rushHourActivity.gameView.warriorState = 0;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j] = "q";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("l")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("4")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("5")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 2;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("6")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 26;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("8")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.keyNum++;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("v")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.keyNum++;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("^")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("1")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 6;
						rushHourActivity.gameView.mapNum = 1;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("*")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 17;
						rushHourActivity.gameView.gemNum = 2;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("@")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 22;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("=")
							&& rushHourActivity.gameView.keyNum < 3) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 3;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("=")
							&& rushHourActivity.gameView.keyNum == 3) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("s")
							&& rushHourActivity.gameView.keyNum == 1) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("s")
							&& rushHourActivity.gameView.keyNum != 1) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 3;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("g")
							|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
									.equals("G")) {
						rushHourActivity.gameView.lifeState = 2;
					}
					if (!(rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("g") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("G"))
							&& rushHourActivity.gameView.lifeState == 2) {
						rushHourActivity.gameView.lifeState = 0;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
							.equals("&")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 27;
						rushHourActivity.gameView.gemNum = 3;
					}

					if (!(rushHourActivity.gameView.warrior.i <= 0)
							&& ((rushHourActivity.gameView.warriorState == 0
									&& (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
											.equals("a")
											|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
													.equals("?")
											|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
													.equals("m") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
											.equals("n"))
									&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] != 6 && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] != 19)
									|| (rushHourActivity.gameView.warriorState == 1
											&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
													.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] != 21) || (rushHourActivity.gameView.warriorState == 2
									&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
											.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] == 6))) {
						// 可以移动的时

						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;
						for (int i = 0; i < 4 * m; i++) {
							if (rushHourActivity.gameView.warriorState == 0) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manUp[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 1) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carUp[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 2) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.boatUp[i % 4];
							}
							rushHourActivity.gameView.warrior.Y -= 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.i -= 1;

								if (!(rushHourActivity.gameView.warrior.i <= 0)
										&& ((rushHourActivity.gameView.warriorState == 0
												&& (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
														.equals("a")
														|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
																.equals("?")
														|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
																.equals("m") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
														.equals("n"))
												&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] != 6 && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] != 19)
												|| (rushHourActivity.gameView.warriorState == 1
														&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
																.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] != 21) || (rushHourActivity.gameView.warriorState == 2
												&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j]
														.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j] == 6))) {
									// 可以移动的时

								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						rushHourActivity.gameView.warrior.isRun = false;
					}

				} else if (dir == 2) {// 向下

					if (rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manDown[3];
					}
					if (rushHourActivity.gameView.warriorState == 1) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carDown[0];
					}
					if (rushHourActivity.gameView.warriorState == 2) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.boatDown[0];
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("c")) {
						rushHourActivity.myHandler.sendEmptyMessage(15);// 向Activity的Handler发送消息
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("q")
							&& rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warriorState = 2;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.startSound.start();
						}
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.boatSound.start();
							rushHourActivity.gameView.boatSoundState = 1;
						} else
							rushHourActivity.gameView.boatSoundState = 2;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("7")
							&& rushHourActivity.gameView.keyNum >= 2) {
						rushHourActivity.gameView.warriorState = 1;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.startSound.start();
						}
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("7")
							&& rushHourActivity.gameView.keyNum == 1) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 21;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("^")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.gameView.warriorState == 2
							&& (rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] == 20 || rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] == 21)) {
						if (rushHourActivity.gameView.boatSoundState == 1) {
							rushHourActivity.gameView.boatSound.pause();
							rushHourActivity.gameView.boatSoundState = 0;
						}
						rushHourActivity.gameView.warriorState = 0;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j] = "q";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("l")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("v")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("1")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 6;
						rushHourActivity.gameView.mapNum = 1;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("2")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 25;
						if (rushHourActivity.gameView.amuletNum == 0) {
							rushHourActivity.gameView.speedState = 1;
						}
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("3")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 4;
						rushHourActivity.gameView.amuletNum = 1;
						rushHourActivity.gameView.speedState = 0;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("4")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("s")
							&& rushHourActivity.gameView.keyNum == 1) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("s")
							&& rushHourActivity.gameView.keyNum != 1) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 3;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("!")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						if (rushHourActivity.gameView.process5 <= 3500)
							rushHourActivity.gameView.process5 += 300;
						else
							rushHourActivity.gameView.process5 = 3800;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("+")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 16;
						rushHourActivity.gameView.gemNum = 1;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("g")
							|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
									.equals("G")) {
						rushHourActivity.gameView.lifeState = 2;
					}
					if (!(rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("g") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
							.equals("G"))
							&& rushHourActivity.gameView.lifeState == 2) {
						rushHourActivity.gameView.lifeState = 0;
					}

					if (!(rushHourActivity.gameView.warrior.i <= 0)
							&& ((rushHourActivity.gameView.warriorState != 2
									&& (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
											.equals("a")
											|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
													.equals("?")
											|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
													.equals("m") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
											.equals("n"))
									&& !(rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] == 6) && !(rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] == 19)) || (rushHourActivity.gameView.warriorState == 2
									&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
											.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] == 6))) {
						// 可以移动的时

						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;

						for (int i = 0; i < 4 * m; i++) {
							if (rushHourActivity.gameView.warriorState == 0) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manDown[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 1) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carDown[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 2) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.boatDown[i % 4];
							}
							rushHourActivity.gameView.warrior.Y += 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.i += 1;

								if (!(rushHourActivity.gameView.warrior.i <= 0)
										&& ((rushHourActivity.gameView.warriorState != 2
												&& (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
														.equals("a")
														|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
																.equals("?")
														|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
																.equals("m") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
														.equals("n"))
												&& !(rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] == 6) && !(rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] == 19)) || (rushHourActivity.gameView.warriorState == 2
												&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j]
														.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i + 1][rushHourActivity.gameView.warrior.j] == 6))) {
									// 可以移动的时

								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						rushHourActivity.gameView.warrior.isRun = false;
					}

				} else if (dir == 3) {// 向左

					if (rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manLeft[3];
					}
					if (rushHourActivity.gameView.warriorState == 1) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carLeft[0];
					}
					if (rushHourActivity.gameView.warriorState == 2) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.boatLeft[0];
					}

					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("c")) {
						rushHourActivity.myHandler.sendEmptyMessage(15);// 向Activity的Handler发送消息
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("q")
							&& rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warriorState = 2;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.startSound.start();
						}
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.boatSound.start();
							rushHourActivity.gameView.boatSoundState = 1;
						} else
							rushHourActivity.gameView.boatSoundState = 2;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("7")
							&& rushHourActivity.gameView.keyNum >= 2) {
						rushHourActivity.gameView.warriorState = 1;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.startSound.start();
						}
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("7")
							&& rushHourActivity.gameView.keyNum == 1) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 21;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("^")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
					}
					if (rushHourActivity.gameView.warriorState == 2
							&& (rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] == 20 || rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] == 21)) {
						if (rushHourActivity.gameView.boatSoundState == 1) {
							rushHourActivity.gameView.boatSound.pause();
							rushHourActivity.gameView.boatSoundState = 0;
						}
						rushHourActivity.gameView.warriorState = 0;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j] = "q";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("k")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j - 1] = "i";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("5")) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 2;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("1")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 6;
						rushHourActivity.gameView.mapNum = 1;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("2")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 25;
						if (rushHourActivity.gameView.amuletNum == 0) {
							rushHourActivity.gameView.speedState = 1;
						}
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("3")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 4;
						rushHourActivity.gameView.amuletNum = 1;
						rushHourActivity.gameView.speedState = 0;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("4")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("+")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 16;
						rushHourActivity.gameView.gemNum = 1;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("g")
							|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
									.equals("G")) {
						rushHourActivity.gameView.lifeState = 2;
					}
					if (!(rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("g") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
							.equals("G"))
							&& rushHourActivity.gameView.lifeState == 2) {
						rushHourActivity.gameView.lifeState = 0;
					}

					if (!(rushHourActivity.gameView.warrior.i <= 0)
							&& ((rushHourActivity.gameView.warriorState != 2
									&& (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
											.equals("a")
											|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
													.equals("?")
											|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
													.equals("m") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
											.equals("n"))
									&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] != 6 && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] != 19) || (rushHourActivity.gameView.warriorState == 2
									&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
											.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] == 6))) {
						// 可以移动时

						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;
						for (int i = 0; i < 4 * m; i++) {
							if (rushHourActivity.gameView.warriorState == 0) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manLeft[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 1) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carLeft[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 2) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.boatLeft[i % 4];
							}
							rushHourActivity.gameView.warrior.X -= 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.j -= 1;

								if (!(rushHourActivity.gameView.warrior.i <= 0)
										&& ((rushHourActivity.gameView.warriorState != 2
												&& (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
														.equals("a")
														|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
																.equals("?")
														|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
																.equals("m") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
														.equals("n"))
												&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] != 6 && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] != 19) || (rushHourActivity.gameView.warriorState == 2
												&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1]
														.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j - 1] == 6))) {
									// 可以移动时
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						rushHourActivity.gameView.warrior.isRun = false;
					}

				} else if (dir == 4) {// 向右

					if (rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manRight[3];
					}
					if (rushHourActivity.gameView.warriorState == 1) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carRight[0];
					}
					if (rushHourActivity.gameView.warriorState == 2) {
						rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.boatRight[0];
					}

					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("c")) {
						rushHourActivity.myHandler.sendEmptyMessage(15);// 向Activity的Handler发送消息
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("q")
							&& rushHourActivity.gameView.warriorState == 0) {
						rushHourActivity.gameView.warriorState = 2;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.startSound.start();
						}
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.boatSound.start();
							rushHourActivity.gameView.boatSoundState = 1;
						} else
							rushHourActivity.gameView.boatSoundState = 2;
					}
					if (rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] == 20
							&& rushHourActivity.gameView.warriorState == 1) {
						rushHourActivity.gameView.warriorState = 0;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j] = "7";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("7")
							&& rushHourActivity.gameView.keyNum >= 2) {
						rushHourActivity.gameView.warriorState = 1;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						if (rushHourActivity.isSound == true) {
							rushHourActivity.gameView.startSound.start();
						}
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("7")
							&& rushHourActivity.gameView.keyNum == 1) {
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 21;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("^")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (rushHourActivity.gameView.warriorState == 2
							&& (rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] == 20 || rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] == 21)) {
						if (rushHourActivity.gameView.boatSoundState == 1) {
							rushHourActivity.gameView.boatSound.pause();
							rushHourActivity.gameView.boatSoundState = 0;
						}
						rushHourActivity.gameView.warriorState = 0;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j] = "q";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("k")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i - 1][rushHourActivity.gameView.warrior.j + 1] = "i";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("v")) {
						rushHourActivity.gameView.keyNum++;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("1")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 6;
						rushHourActivity.gameView.mapNum = 1;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("4")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 7;
						rushHourActivity.gameView.bottleNum = 3;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("8")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						rushHourActivity.gameView.keyNum++;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("!")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 8;
						if (rushHourActivity.gameView.process5 <= 3500)
							rushHourActivity.gameView.process5 += 300;
						else
							rushHourActivity.gameView.process5 = 3800;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("*")) {
						rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] = "a";
						rushHourActivity.gameView.showTime = 15;
						rushHourActivity.gameView.information = 17;
						rushHourActivity.gameView.gemNum = 2;
					}
					if (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("g")
							|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
									.equals("G")) {
						rushHourActivity.gameView.lifeState = 2;
					}
					if (!(rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("g") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
							.equals("G"))
							&& rushHourActivity.gameView.lifeState == 2) {
						rushHourActivity.gameView.lifeState = 0;
					}

					if (!(rushHourActivity.gameView.warrior.i <= 0)
							&& ((rushHourActivity.gameView.warriorState == 0
									&& (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
											.equals("a")
											|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
													.equals("?")
											|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
													.equals("m") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
											.equals("n"))
									&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 6 && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 19)
									|| (rushHourActivity.gameView.warriorState == 1
											&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
													.equals("a")
											&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 19
											&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 20
											&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 24 && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 25) || (rushHourActivity.gameView.warriorState == 2
									&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
											.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] == 6))) {
						// 可以移动时

						// 移动勇士
						rushHourActivity.gameView.warrior.isRun = true;

						for (int i = 0; i < 4 * m; i++) {
							if (rushHourActivity.gameView.warriorState == 0) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.manRight[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 1) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.carRight[i % 4];
							}
							if (rushHourActivity.gameView.warriorState == 2) {
								rushHourActivity.gameView.warrior.man = rushHourActivity.gameView.warrior.boatRight[i % 4];
							}
							rushHourActivity.gameView.warrior.X += 8;
							if ((i + 1) % 4 == 0) {
								rushHourActivity.gameView.warrior.j += 1;
								if (!(rushHourActivity.gameView.warrior.i <= 0)
										&& ((rushHourActivity.gameView.warriorState == 0
												&& (rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
														.equals("a")
														|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
																.equals("?")
														|| rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
																.equals("m") || rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
														.equals("n"))
												&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 6 && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 19)
												|| (rushHourActivity.gameView.warriorState == 1
														&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
																.equals("a")
														&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 19
														&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 20
														&& rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 24 && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] != 25) || (rushHourActivity.gameView.warriorState == 2
												&& rushHourActivity.map.map2[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1]
														.equals("a") && rushHourActivity.map.map1[2][rushHourActivity.gameView.warrior.i][rushHourActivity.gameView.warrior.j + 1] == 6))) {
									// 可以移动时
								} else
									break;
							}
							try {
								Thread.sleep(rushHourActivity.gameView.sleep1);// 睡眠
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}

						rushHourActivity.gameView.warrior.isRun = false;
					}
				}
				break;

			}
			TouchThread.flag = true;
		}
	}

}
