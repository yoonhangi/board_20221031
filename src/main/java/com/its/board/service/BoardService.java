package com.its.board.service;

import com.its.board.dto.BoardDTO;
import com.its.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;
    public boolean boardSave(BoardDTO boardDTO) {
       int result =  boardRepository.boardSave(boardDTO);
       if (result > 0) {
           return true;
       } else {
           return false;
       }
    }

    public List<BoardDTO> board() {
      return boardRepository.board();
    }
}
