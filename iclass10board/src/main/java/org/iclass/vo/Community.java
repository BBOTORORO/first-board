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

//글
public class Community {
	private long idx;		
	private String writer;		//작성자
	private String title;		//글 제목
	private String content;		//글 내용
	private int readCount;		//조회수
	private Timestamp createdAt;	//작성 날짜와 시간 기본값
	private String ip;			//작성자 ip
	private String commentCount;// 댓글 개수
	
}
