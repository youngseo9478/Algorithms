package com.my.biz.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.my.biz.board.vo.BoardVO;
import com.my.biz.user.vo.UserVO;

public interface BoardMapper {

	@Select ("SELECT*FROM board order by seq desc")
	public List<BoardVO> boardlist(); //select 처리해주는 메소드
	
	@Insert("insert into board (seq,title,writer,content) values(#{seq},#{title},#{writer},#{content})")
	public int boardadd(BoardVO vo);
	
	@Delete("delete from board where seq = #{seq}")
	public int boarddel(int seq);
	
	@Update("update board set title = #{title}, content = #{content} where seq = #{seq}")
	public int boardupdate(BoardVO vo);
	
	@Select("select * from board where seq = #{seq}")
	public BoardVO boardfind(int seq);

	@Select("select * from board where ${condition} like '%'||#{keyword}||'%'")
	public List<BoardVO> usersearch2(BoardVO vo); //UserVO로 한 방법
	
	@Select("select * from board where ${condition} like '%'||#{keyword}||'%' order by seq desc")
	public List<BoardVO> usersearch(HashMap<String, String> map); //HashMap으로 한 방법
		
	@Update("update board set cnt = #{cnt}+1 where seq = #{seq}")
	public int cnt(BoardVO vo);
	
}
