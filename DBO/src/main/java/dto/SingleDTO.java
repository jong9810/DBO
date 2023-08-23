package dto;

public class SingleDTO {
	int single_id;
	String member_id;
	int single_all;
	boolean single_result;
	String single_answer;
	

	public int getSingle_id() {
		return single_id;
	}
	public void setSingle_id(int single_id) {
		this.single_id = single_id;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public int getSingle_all() {
		return single_all;
	}
	public void setSingle_all(int single_all) {
		this.single_all = single_all;
	}
	public boolean isSingle_result() {
		return single_result;
	}
	public void setSingle_result(boolean single_result) {
		this.single_result = single_result;
	}
	
	public String getSingle_answer() {
		return single_answer;
	}
	public void setSingle_answer(String single_answer) {
		this.single_answer = single_answer;
	}
	@Override
	public String toString() {
		return "SingleDTO [single_id=" + single_id + ", member_id=" + member_id + ", single_all=" + single_all
				+ ", single_result=" + single_result + "]";
	}
	

}
