package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.iclass.dao.CommunityCommentsDao;
import org.iclass.dao.CommunityDao;
import org.iclass.vo.Community;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BoardTest {
	
	CommunityDao communityDao = CommunityDao.getInstance();
	CommunityCommentsDao commentsDao = CommunityCommentsDao.getInstance();
	
	@DisplayName("메인글 쓰기 insert")
	@Test
	void insert() {
		Community vo = Community.builder()
				.writer("조경현")
				.title("집가고싶다")
				.content("집가고싶어요")
				.build();
		communityDao.insert(vo);
		assertEquals(vo.getIdx(), 20);   
	}
	
}