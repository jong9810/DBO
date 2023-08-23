package service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MyItemsDAO;
import dto.MemberDTO;
import dto.MyItemsDTO;


@Service
public class MyItemsServiceImpl implements MyItemsService {
	
	@Autowired
	MyItemsDAO dao;

	@Override
	public int buyitem(MyItemsDTO dto) {
		return dao.buyitem(dto);
	}

	@Override
	public List<String> getsolditem(String member_id) {
		return dao.getsolditem(member_id);
	}

	@Override
	public int minusexp(MemberDTO dto) {
		return dao.minusexp(dto);
	}

	@Override
	public int getexp(String member_id) {
		return dao.getexp(member_id);
	}

	@Override
	public List<MyItemsDTO> getallmynickitem(String member_id) {
		return dao.getallmynickitem(member_id);
	}

	@Override
	public int onnick(MyItemsDTO dto) {
		return dao.onnick(dto);
	}

	@Override
	public int offnick(MyItemsDTO dto) {
		return dao.offnick(dto);
	}

	
}
