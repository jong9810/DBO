package service;

import java.util.HashMap;
import java.util.List;

import dto.RankingDTO;

public interface RankingService {
	public List<RankingDTO> getWeekelyRanking(HashMap<String, String> map);

}
