package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import dto.RankingDTO;

@Repository
@Mapper
public interface RankingDAO {
	public List<RankingDTO> getWeekelyRanking(HashMap<String, String> map);

}
