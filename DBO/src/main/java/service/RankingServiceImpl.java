package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RankingDAO;
import dto.RankingDTO;


@Service
public class RankingServiceImpl implements RankingService {
	
	@Autowired
	RankingDAO dao;

	@Override
	public List<RankingDTO> getWeekelyRanking(HashMap<String, String> map) {
		return dao.getWeekelyRanking(map);
	}

	
}
