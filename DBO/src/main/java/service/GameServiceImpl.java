package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GameDAO;
import dao.RankingDAO;
import dto.ExpDTO;
import dto.InningsDTO;
import dto.MemberDTO;
import dto.SingleDTO;


@Service
public class GameServiceImpl implements GameService {
	
	@Autowired
	GameDAO dao;

	@Override
	public int insertSingle(SingleDTO dto) {
		dao.insertSingle(dto);
		int result = dto.getSingle_id();
		return result;
	}

	@Override
	public int updateSingle(SingleDTO dto) {
		// TODO Auto-generated method stub
		return dao.updateSingle(dto);
	}
	

	@Override
	public int updateMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return dao.updateMember(dto);
	}

	@Override
	public int insertInnings(InningsDTO dto) {
		// TODO Auto-generated method stub
		return dao.insertInnings(dto);
	}

	@Override
	public int insertExp(ExpDTO dto) {
		// TODO Auto-generated method stub
		return dao.insertExp(dto);
	}

	@Override
	public MemberDTO selectMember(String member_id) {
		// TODO Auto-generated method stub
		return dao.selectMember(member_id);
	}

	
	
}
