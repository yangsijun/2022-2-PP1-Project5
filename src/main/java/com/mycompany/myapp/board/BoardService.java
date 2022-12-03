package com.mycompany.myapp.board;

import java.util.List;

public interface BoardService {
    public int insertBoard(BoardVO vo);
    public int updateBoard(BoardVO vo);
    public int deleteBoard(int seq);
    public BoardVO getBoard(int seq);
    public List<BoardVO> getBoardList();
}
