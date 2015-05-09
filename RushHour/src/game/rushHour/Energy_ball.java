package game.rushHour;

/*
 * 能量炮发射后能量球的运动路径
 * 
 * */
public class Energy_ball extends Thread {
	RushHourActivity rushHourActivity;// Activity的引用
	int dir;// 方向
	int gemNum;// 能量石数量
	int sleep = 400;

	boolean flag = true;
	static boolean bool = true;

	public Energy_ball(int dir, RushHourActivity rushHourActivity, int gemNum) {
		this.rushHourActivity = rushHourActivity;
		this.dir = dir;
		this.gemNum = gemNum;
	}

	public void run() {
		if (bool) {
			bool = false;
			int count = 0;
			rushHourActivity.gameView.ball_i = rushHourActivity.gameView.warrior.i;
			rushHourActivity.gameView.ball_j = rushHourActivity.gameView.warrior.j;
			while (flag) {
				switch(rushHourActivity.gameView.level){
				case 2:
				switch (dir) {
				case 1:
					rushHourActivity.gameView.ball_i--;
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("a")) {
						rushHourActivity.gameView.energy_ballY -= 4;
						count += 4;
						if (count % 32 == 0) {
							rushHourActivity.gameView.ball_i--;
						}
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("3")) {
						
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("5")) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("6")
							&& gemNum == 2) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "7";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("7")
							&& gemNum == 2) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "8";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("8")
							&& gemNum == 2) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else {
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					}
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				case 2:
					rushHourActivity.gameView.ball_i++;
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("a")) {
						rushHourActivity.gameView.energy_ballY += 4;
						count += 4;
						if (count % 32 == 0) {
							rushHourActivity.gameView.ball_i++;
						}
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("3")) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("5")) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else {
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					}
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				case 3:
					rushHourActivity.gameView.ball_j--;
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("a")) {
						rushHourActivity.gameView.energy_ballX -= 4;
						count += 4;
						if (count % 32 == 0) {
							rushHourActivity.gameView.ball_j--;
						}
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("3")) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("5")) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else {
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					}
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				case 4:
					rushHourActivity.gameView.ball_j++;
					if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("a")) {
						rushHourActivity.gameView.energy_ballX += 4;
						count += 4;
						if (count % 32 == 0) {
							rushHourActivity.gameView.ball_j++;
						}
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("3")) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else if (rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							.equals("5")) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[1][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					} else {
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
					}
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				}
                break;
				case 3:
					switch (dir) {
					case 1:
						rushHourActivity.gameView.ball_i--;
						if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
								.equals("a")) {
							rushHourActivity.gameView.energy_ballY -= 4;
							count += 4;
							if (count % 32 == 0) {
								rushHourActivity.gameView.ball_i--;
							}
						} 
						else if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
						  .equals("-")) {
						rushHourActivity.gameView.gemState = 2;
						rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
		                rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						rushHourActivity.gameView.ball_j = -1;
						rushHourActivity.gameView.ball_i = -1;
						flag = false;
						bool = true;
						} else if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
								.equals("@")
								&& gemNum == 2) {
							rushHourActivity.gameView.gemState = 2;
							rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "#";
							rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
							rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
							rushHourActivity.gameView.ball_j = -1;
							rushHourActivity.gameView.ball_i = -1;
							flag = false;
							bool = true;
						} else if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
								.equals("#")
								&& gemNum == 2) {
							rushHourActivity.gameView.gemState = 2;
							rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "$";
							rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
							rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
							rushHourActivity.gameView.ball_j = -1;
							rushHourActivity.gameView.ball_i = -1;
							flag = false;
							bool = true;
						} else if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
								.equals("$")
								&& gemNum == 2) {
							rushHourActivity.gameView.gemState = 2;
							rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
							rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
							rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
							rushHourActivity.gameView.ball_j = -1;
							rushHourActivity.gameView.ball_i = -1;
							flag = false;
							bool = true;
						} else if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
						                                          								.equals("d")
						                                        								&& gemNum == 3) {
							rushHourActivity.gameView.gemState = 2;
						    rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
						    rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
						    rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
						    rushHourActivity.gameView.ball_j = -1;
						    rushHourActivity.gameView.ball_i = -1;
						    flag = false;
						    bool = true;
						                                        						} 
						else {
							rushHourActivity.gameView.ball_j = -1;
							rushHourActivity.gameView.ball_i = -1;
							flag = false;
							bool = true;
						}
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					case 2:
						rushHourActivity.gameView.ball_i++;
						if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
								.equals("a")) {
							rushHourActivity.gameView.energy_ballY += 4;
							count += 4;
							if (count % 32 == 0) {
								rushHourActivity.gameView.ball_i++;
							}
						}else if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
						                                               						  .equals("-")) {
							rushHourActivity.gameView.gemState = 2;
							rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
							rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
			                rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
							rushHourActivity.gameView.ball_j = -1;
							rushHourActivity.gameView.ball_i = -1;
							flag = false;
							bool = true;
							}
						 else if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							                                          								.equals("d")
							                                        								&& gemNum == 3) {
							    rushHourActivity.gameView.gemState = 2;
							    rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
							    rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
							    rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
							    rushHourActivity.gameView.ball_j = -1;
							    rushHourActivity.gameView.ball_i = -1;
							    flag = false;
							    bool = true;
							                                        						} 
						else {
							rushHourActivity.gameView.ball_j = -1;
							rushHourActivity.gameView.ball_i = -1;
							flag = false;
							bool = true;
						}
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					case 3:
						rushHourActivity.gameView.ball_j--;
						if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
								.equals("a")) {
							rushHourActivity.gameView.energy_ballX -= 4;
							count += 4;
							if (count % 32 == 0) {
								rushHourActivity.gameView.ball_j--;
							}
						}
						 else if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							                                          								.equals("d")
							                                        								&& gemNum == 3) {
							    rushHourActivity.gameView.gemState = 2;
							    rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
							    rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
							    rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
							    rushHourActivity.gameView.ball_j = -1;
							    rushHourActivity.gameView.ball_i = -1;
							    flag = false;
							    bool = true;
							                                        						} 
						else {
							rushHourActivity.gameView.ball_j = -1;
							rushHourActivity.gameView.ball_i = -1;
							flag = false;
							bool = true;
						}
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					case 4:
						rushHourActivity.gameView.ball_j++;
						if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
								.equals("a")) {
							rushHourActivity.gameView.energy_ballX += 4;
							count += 4;
							if (count % 32 == 0) {
								rushHourActivity.gameView.ball_j++;
							}
						} 
						 else if (rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j]
							                                          								.equals("d")
							                                        								&& gemNum == 3) {
							    rushHourActivity.gameView.gemState = 2;
							    rushHourActivity.map.map2[2][rushHourActivity.gameView.ball_i][rushHourActivity.gameView.ball_j] = "a";
							    rushHourActivity.gameView.explode_j=rushHourActivity.gameView.ball_j;
							    rushHourActivity.gameView.explode_i=rushHourActivity.gameView.ball_i;
							    rushHourActivity.gameView.ball_j = -1;
							    rushHourActivity.gameView.ball_i = -1;
							    flag = false;
							    bool = true;
							                                        						} 
						else {
							rushHourActivity.gameView.ball_j = -1;
							rushHourActivity.gameView.ball_i = -1;
							flag = false;
							bool = true;
						}
						try {
							Thread.sleep(sleep);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						break;
					}
					break;
			}

		}
	}
}
}