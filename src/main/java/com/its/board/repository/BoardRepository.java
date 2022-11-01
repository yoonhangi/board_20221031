package com.its.board.repository;

import com.its.board.dto.BoardDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BoardRepository {
    @Autowired
    private SqlSessionTemplate sql;

    public int boardSave(BoardDTO boardDTO) {
        return sql.insert("Board.boardSave", boardDTO);
    }

    public List<BoardDTO> board() {
        return sql.selectList("Board.board");
    }

    public BoardDTO findByBoard(String title) {
        return sql.selectOne("Board.findByBoard", title);
    }
}
