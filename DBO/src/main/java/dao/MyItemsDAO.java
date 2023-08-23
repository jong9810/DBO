package dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import dto.MemberDTO;
import dto.MyItemsDTO;


@Repository
@Mapper
public interface MyItemsDAO {
	public int buyitem(MyItemsDTO dto);
	public List<String> getsolditem(String member_id);
	public int minusexp(MemberDTO dto);
	public int getexp(String member_id);
	public List<MyItemsDTO> getallmynickitem(String member_id);
	public int onnick(MyItemsDTO dto);
	public int offnick(MyItemsDTO dto);
	public String getusingmynickitem(String member_id);
}
