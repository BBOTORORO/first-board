package org.iclass.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
//댓
public class CommunityComments {
	private int idx;			//기본키
	private long mref;			//community 테이블의 idx
	private String writer;		//작성자
	private String content;		//댓글 내용
	private Timestamp createdAt;	//작성 날짜와 시간 기본값
	private String ip;			//작성자 ip
	private int heart;			//좋아요 개수 
	//프로퍼티라고도 합니다 !
}
