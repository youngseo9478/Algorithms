package com.my.biz.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.my.biz.board.vo.BoardVO;

public interface BoardMapper {
	
	/*<select id="boardlist" resultType="boardvo">
	 select * from board order by seq desc
	</select>*/
	@Select("select * from board order by seq desc")
	public List<BoardVO> boardlist();
	
	/*<insert id="addboard" parameterType="boardvo">
	insert into board (seq,title,writer,content)  
	values((select nvl(max(seq),0)+1 from board),#{title},#{writer},#{content})
	</insert>
	 */
	@Insert("insert into board (seq,title,writer,content)"
			+ " values((select nvl(max(seq),0)+1 from board),#{title},#{writer},#{content})")
	public int addboard(BoardVO vo);
		
	/*<select id="getboard" resultType="boardvo">
	select * from board where seq = #{seq}
	</select>*/
	@Select("select * from board where seq = #{seq}")
	public BoardVO getboard(int seq);
	
	/*<delete id="deleteboard">	
	delete from board where seq = #{seq}	
	</delete>*/
	@Delete("delete from board where seq = #{seq}")
	public int deleteboard(int seq);
	
	/*<update id="updateboard" parameterType="boardvo">
	update board set title = #{title}, content = #{content} where seq = #{seq}
	</update>*/
	@Update("update board set title = #{title}, content = #{content} where seq = #{seq}")
	public int updateboard(BoardVO vo);
	
	/*<select id="searchboard" resultType="boardvo" parameterType="boardvo">
		select * from board where ${condition} like '%' || #{keyword} || '%' 
		order by seq desc
	</select>*/
	@Select("select * from board where ${condition} like '%' || #{keyword} || '%' order by seq desc")
	public List<BoardVO> searchboard(HashMap<String, String> map);
			
	/*<update id="cnt" parameterType="boardvo">
		update board set cnt = #{cnt}+1 where seq = #{seq} 
	</update>*/
	@Update("update board set cnt = #{cnt}+1 where seq = #{seq}")
	public void cnt(BoardVO vo);
}
