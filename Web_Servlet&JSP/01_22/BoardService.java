



public interface BoardService {
	//등록
	public int boardInsert(BoardVO vo);
	//삭제
	public int boardDelete(int seq);
	//글수정
	public int boardUpdate(BoardVO vo);
	//리스트
	public List<BoardVO> boardSelectAll();
	//글보기
	public BoardVO boardFind(int seq);
	
}
