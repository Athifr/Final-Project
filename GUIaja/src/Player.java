import java.util.Comparator;

public class Player {

		String namaplayer;
		String Headshot;
		int Kills;
		String Assist;
		String Death;
		double kda;
		

		public Player(String namaplayer, String headshot, String kills, String assist, String death) {
			super();
			this.namaplayer = namaplayer;
			Headshot = headshot;
			this.Kills = Integer.valueOf(kills);
			Assist = assist;
			Death = death;
			getKda();
		}

		

		@Override
		public String toString() {
			return "Player [namaplayer=" + namaplayer + ", Headshot=" + Headshot + ", Kills=" + Kills + ", Assist="
					+ Assist + ", Death=" + Death + ", kda=" + kda + "]";
		}



		public String getNamaplayer() {
			return namaplayer;
		}



		public void setNamaplayer(String namaplayer) {
			this.namaplayer = namaplayer;
		}



		public String getKills() {
			String k = String.valueOf(Kills);
			return k;
		}



		public void setKills(String kills) {
			Kills = Integer.valueOf(kills);
		}



		public String getAssist() {
			return Assist;
		}



		public void setAssist(String assist) {
			Assist = assist;
		}



		public String getDeath() {
			return Death;
		}



		public void setDeath(String death) {
			Death = death;
		}
		
		

		public String getHeadshot() {
			return Headshot;
		}



		public void setHeadshot(String headshot) {
			Headshot = headshot;
		}



		public void print() {
			System.out.println(namaplayer + " " + Kills + " " + Death + " " + Assist);
		}
		
		public double getKda() {
			int kill = Integer.valueOf(this.Kills);
			int death = Integer.valueOf(this.Death);
			int assist = Integer.valueOf(this.Kills);
			double Total = kill + assist;
			double da = Total/death;
			return kda = Math.round(da*100.0)/100.0;
		}
		
}

		class kdaComparator implements Comparator<Player> {
			public int compare(Player p1, Player p2) {
				if (p1.kda == p2.kda) {
					return 0;
				}
				else if (p1.kda > p2.kda) {
					return 1;
				}
				else {
					return -1;
				}
			}
		}
		
		class topkillComparator implements Comparator<Player> {
			public int compare(Player p1, Player p2) {
				if (p1.Kills == p2.Kills) {
					return 0;
				}
				else if (p1.Kills > p2.Kills) {
					return 1;
				}
				else {
					return -1;
				}
			}
		}
