package dto;

public class InningsDTO {
	int single_id, innings_count, innings_strike, innings_ball;
	String innings_chall ;
	

	public int getSingle_id() {
		return single_id;
	}
	public void setSingle_id(int single_id) {
		this.single_id = single_id;
	}
	public int getInnings_count() {
		return innings_count;
	}
	public void setInnings_count(int innings_count) {
		this.innings_count = innings_count;
	}
	public int getInnings_strike() {
		return innings_strike;
	}
	public void setInnings_strike(int innings_strike) {
		this.innings_strike = innings_strike;
	}
	public int getInnings_ball() {
		return innings_ball;
	}
	public void setInnings_ball(int innings_ball) {
		this.innings_ball = innings_ball;
	}
	
	public String getInnings_chall() {
		return innings_chall;
	}
	public void setInnings_chall(String innings_chall) {
		this.innings_chall = innings_chall;
	}
	@Override
	public String toString() {
		return "InningsDTO [single_id=" + single_id + ", innings_count=" + innings_count + ", innings_strike="
				+ innings_strike + ", innings_ball=" + innings_ball + "]";
	}

}
