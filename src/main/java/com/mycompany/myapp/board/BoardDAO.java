package com.mycompany.myapp.board;

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
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String BOARD_INSERT = "insert into Board(title, writer, content) values (?,?,?)";
    private final String BOARD_UPDATE = "update Board set title=?, writer=?, content=? where seq=?";
    private final String BOARD_DELETE = "delete from Board where seq=?";
    private final String BOARD_GET = "select * from Board where seq=?";
    private final String BOARD_LIST = "select * from Board order by seq desc";

    public int insertBoard(BoardVO vo) {
        return template.update(BOARD_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
    }
    public int deleteBoard(int seq) {
        return template.update(BOARD_DELETE, seq);
    }
    public int updateBoard(BoardVO vo) {
        return template.update(BOARD_UPDATE, vo.getTitle(), vo.getWriter(), vo.getContent(), vo.getSeq());
    }
    public BoardVO getBoard(int seq) {
        return template.queryForObject(BOARD_GET, new Object[] {seq}, new BeanPropertyRowMapper<BoardVO>(BoardVO.class));
    }
    public List<BoardVO> getBoardList() {
        return template.query(BOARD_LIST, new RowMapper<BoardVO>() {
            @Override
            public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
                BoardVO data = new BoardVO();
                data.setSeq(rs.getInt("seq"));
                data.setTitle(rs.getString("title"));
                data.setWriter(rs.getString("writer"));
                data.setContent(rs.getString("content"));
                data.setRegDate(rs.getTimestamp("regDate").toLocalDateTime());
                System.out.println(data.getSeq());
                System.out.println(data.getTitle());
                System.out.println(data.getWriter());
                System.out.println(data.getContent());
                System.out.println(data.getRegDate());
                return data;
            }
        });
    }
}
