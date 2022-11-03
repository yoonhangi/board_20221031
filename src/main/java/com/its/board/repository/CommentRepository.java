package com.its.board.repository;

import com.its.board.dto.CommentDTO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
    @Autowired
    private SqlSessionTemplate sql;


    public void save(CommentDTO commentDTO) {
       sql.insert("Comment.save", commentDTO);
    }
}
