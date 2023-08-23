package dto;

import java.sql.Timestamp;

public class MyItemsDTO {
	String member_id, nicknameitem_name;
	boolean nicknameitem_use;
	Timestamp nicknameitem_date;
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getNicknameitem_name() {
		return nicknameitem_name;
	}
	public void setNicknameitem_name(String nicknameitem_name) {
		this.nicknameitem_name = nicknameitem_name;
	}
	public boolean isNicknameitem_use() {
		return nicknameitem_use;
	}
	public void setNicknameitem_use(boolean nicknameitem_use) {
		this.nicknameitem_use = nicknameitem_use;
	}
	public Timestamp getNicknameitem_date() {
		return nicknameitem_date;
	}
	public void setNicknameitem_date(Timestamp nicknameitem_date) {
		this.nicknameitem_date = nicknameitem_date;
	}
	@Override
	public String toString() {
		return "MyItemsDTO [member_id=" + member_id + ", nicknameitem_name=" + nicknameitem_name + ", nicknameitem_use="
				+ nicknameitem_use + ", nicknameitem_date=" + nicknameitem_date + "]";
	}
	
	
	
}
