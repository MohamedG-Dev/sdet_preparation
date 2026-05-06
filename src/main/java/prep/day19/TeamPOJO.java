package prep.day19;

public class TeamPOJO {
	private String pos;
	private String teamName;
	private double nrr;
	private int points;

	public TeamPOJO(String pos, String teamName, double nrr, int points) {
		this.pos = pos;
		this.teamName = teamName;
		this.nrr = nrr;
		this.points = points;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public double getNrr() {
		return nrr;
	}

	public void setNrr(double nrr) {
		this.nrr = nrr;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "TeamPOJO [pos=" + pos + ", teamName=" + teamName + ", nrr=" + nrr + ", points=" + points + "]";
	}

}
