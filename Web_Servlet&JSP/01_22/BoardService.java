



public interface BoardService {
	//���
	public int boardInsert(BoardVO vo);
	//����
	public int boardDelete(int seq);
	//�ۼ���
	public int boardUpdate(BoardVO vo);
	//����Ʈ
	public List<BoardVO> boardSelectAll();
	//�ۺ���
	public BoardVO boardFind(int seq);
	
}
