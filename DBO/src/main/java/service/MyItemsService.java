package service;

import java.util.List;

import dto.MemberDTO;
import dto.MyItemsDTO;

public interface MyItemsService {
	public int buyitem(MyItemsDTO dto);
	public List<String> getsolditem(String member_id);
	public int minusexp(MemberDTO dto);
	public int getexp(String member_id);
	public List<MyItemsDTO> getallmynickitem(String member_id);
	public int onnick(MyItemsDTO dto);
	public int offnick(MyItemsDTO dto);
}
