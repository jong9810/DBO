package dto;


public class RankingDTO {
	String member_id, member_nick, nicknameitem_name;
	int exp_total;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public int getExp_total() {
		return exp_total;
	}
	public void setExp_total(int exp_total) {
		this.exp_total = exp_total;
	}
	public String getNicknameitem_name() {
		return nicknameitem_name;
	}
	public void setNicknameitem_name(String nicknameitem_name) {
		this.nicknameitem_name = nicknameitem_name;
	}
	@Override
	public String toString() {
		return "RankingDTO [member_id=" + member_id + ", member_nick=" + member_nick + ", nicknameitem_name="
				+ nicknameitem_name + ", exp_total=" + exp_total + "]";
	}
	
	
	
	
}
