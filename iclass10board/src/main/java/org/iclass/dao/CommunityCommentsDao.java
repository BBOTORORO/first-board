package org.iclass.dao;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;

import mybatis.SqlSessionBean;

public class CommunityCommentsDao {
	private static CommunityCommentsDao dao = new CommunityCommentsDao();
	private CommunityCommentsDao() {}
	public static CommunityCommentsDao getInstance() {
		return dao;
	}

	
	//누구의 insert을 namespace로 구별 
	public int insert(CommunityComments vo) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int idx = mapperSession.insert("CommunityComments.insert",vo);
		mapperSession.commit();
		mapperSession.close();
		return idx;
	}
	
	public int delete(int idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.delete("CommunityComments.delete",idx);
		mapperSession.commit();
		mapperSession.close();
		return result;
	}
	
	public int maxOf() {
		SqlSession session = SqlSessionBean.getSession();
		int result = session.selectOne("communityComments.maxOf");
		session.close();
		return result;
	}
	}
