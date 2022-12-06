package com.mycompany.myapp.board;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BoardDAO {

    @Autowired
    SqlSession sqlSession;

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String BOARD_INSERT = "insert into Board(title, writer, content) values (?,?,?)";
    private final String BOARD_UPDATE = "update Board set title=?, writer=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from Board where seq=?";
    private final String BOARD_GET = "select * from Board where seq=?";
    private final String BOARD_LIST = "select * from Board order by seq desc";

    public int insertBoard(BoardVO vo) {
        return sqlSession.insert("Board.insertBoard", vo);
    }
    public int deleteBoard(int seq) {
        return sqlSession.delete("Board.deleteBoard", seq);
    }
    public int updateBoard(BoardVO vo) {
        return sqlSession.update("Board.updateBoard", vo);
    }
    public BoardVO getBoard(int seq) {
        return sqlSession.selectOne("Board.getBoard", seq);
    }
    public List<BoardVO> getBoardList() {
        return sqlSession.selectList("Board.getBoardList");
    }
}
