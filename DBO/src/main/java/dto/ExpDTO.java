package dto;

import java.sql.Timestamp;

public class ExpDTO {
	String member_id;
	int single_id;
	Timestamp exp_date;
	int exp_amount;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getSingle_id() {
		return single_id;
	}
	public void setSingle_id(int single_id) {
		this.single_id = single_id;
	}
	public Timestamp getExp_date() {
		return exp_date;
	}
	public void setExp_date(Timestamp exp_date) {
		this.exp_date = exp_date;
	}
	public int getExp_amount() {
		return exp_amount;
	}
	public void setExp_amount(int exp_amount) {
		this.exp_amount = exp_amount;
	}
	@Override
	public String toString() {
		return "ExpDTO [member_id=" + member_id + ", single_id=" + single_id + ", exp_date=" + exp_date
				+ ", exp_amount=" + exp_amount + "]";
	}
	
	
	

	

}
