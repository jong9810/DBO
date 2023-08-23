package dto;

public class MemberDTO {
	String member_id, member_pw, member_nick, member_email, member_team;
	int member_allexp, member_total, member_win;
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_nick() {
		return member_nick;
	}
	public void setMember_nick(String member_nick) {
		this.member_nick = member_nick;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_team() {
		return member_team;
	}
	public void setMember_team(String member_team) {
		this.member_team = member_team;
	}
	public int getMember_allexp() {
		return member_allexp;
	}
	public void setMember_allexp(int member_allexp) {
		this.member_allexp = member_allexp;
	}
	public int getMember_total() {
		return member_total;
	}
	public void setMember_total(int member_total) {
		this.member_total = member_total;
	}
	public int getMember_win() {
		return member_win;
	}
	public void setMember_win(int member_win) {
		this.member_win = member_win;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [member_id=" + member_id + ", member_pw=" + member_pw + ", member_nick=" + member_nick
				+ ", member_email=" + member_email + ", member_team=" + member_team + ", member_allexp=" + member_allexp
				+ ", member_total=" + member_total + ", member_win=" + member_win + "]";
	}
	
}
