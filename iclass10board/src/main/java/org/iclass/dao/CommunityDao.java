package org.iclass.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.iclass.vo.Community;
import org.iclass.vo.CommunityComments;

import mybatis.SqlSessionBean;

public class CommunityDao {
	private static CommunityDao dao = new CommunityDao();
	private CommunityDao() {}
	public static CommunityDao getInstance() {
		return dao;
	}

		
	//insert에서 vo 객체가 xml 파일로 뿌려줍니다. 
	// 처음에는 idx 가 ? = 없는 값입니다
	// insert를 하고 나면 vo객체 idx에 자동으로 값을 넘겨줍니다
	// insert 하고 난 뒤 idx값이 없었던 vo객체에 저장되는 것입니다
	// insert를 한 다음에 넘겨줄 수 있습니다.
	//insert한 다음에 idx값 가져오는 방법
	public long insert(Community vo) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		mapperSession.insert("community.insert",vo);  
		mapperSession.commit();
		mapperSession.close();
		return vo.getIdx();	//매퍼 xml 에서 selectKey 로 시퀀스 값을 vo객체에 저장시킵니다.
	}
	
	public int update(Community vo) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.update("community.update",vo);
		mapperSession.commit();
		mapperSession.close();
		return result;
	}
	
	public int delete(long idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.delete("community.delete",idx);
		mapperSession.commit();
		mapperSession.close();
		return result;
	}

	public Community selectByIdx(long idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		Community vo = mapperSession.selectOne("community.selectByIdx",idx);
		mapperSession.close();
		return vo;
	}
	//전체 행의 개수 조회
	public int count() {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.selectOne("Community.count");
		mapperSession.close();
		return result;
	}
	//조회수 업데이트 하는 메서드
	public int setReadCount(long idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.selectOne("Community.setReadCount",idx);
		mapperSession.close();
		return result;
	}
	//메인 글 idx (mref)의 댓글 개수 (행)
		public int commentsCount() {
			SqlSession mapperSession = SqlSessionBean.getSession();
			int result = mapperSession.selectOne("Community.commentsCount");
			mapperSession.close();
			return result;
		}
	//댓글 개수 업데이트 메서드
	public int setCommentCount(int idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		int result = mapperSession.selectOne("Community.setCommentCount",idx);
		mapperSession.close();
		return result;
}
	// idx 값으로 댓글 내용 조회하기 
	public Community contentRead(int idx) {
		SqlSession mapperSession = SqlSessionBean.getSession();
		Community vo = mapperSession.selectOne("community.contentRead",idx);
		mapperSession.close();
		return vo;
	}
	//mref 메인글의 댓글목록 가져오기
		public List<CommunityComments> comments(long mref){
			SqlSession mapperSession = SqlSessionBean.getSession();
			List<CommunityComments> commentList = mapperSession.selectList("community.comments",mref);
			mapperSession.close();
			return commentList;
		}
		//메인글 목록 가져오기 - 할일 : 한번에(즉 한페이지에) 글 10개씩 가져오도록 변경  
		public List<Community> list() {
			SqlSession mapperSession = SqlSessionBean.getSession();
			List<Community> list = mapperSession.selectList("community.list");
			mapperSession.close();
			return list;
		}
		//idx 최대값 구하기
		public int maxOf() {
			SqlSession session = SqlSessionBean.getSession();
			int result = session.selectOne("community.maxOf");
			session.close();
			return result;
		}
}

	



