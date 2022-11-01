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
    public boolean save(BoardDTO boardDTO) {
       int result =  boardRepository.save(boardDTO);
       if (result > 0) {
           return true;
       } else {
           return false;
       }
    }

    public List<BoardDTO> findAll() {
      return boardRepository.findAll();
    }

    public BoardDTO findById(Long id) {
        // 조회수증가
        boardRepository.updateHits(id);
        // 상세내용 가져와서 리턴
        return boardRepository.findById(id);
    }


    public BoardDTO updateFn(BoardDTO boardDTO) {
        return boardRepository.updateFn(boardDTO);
    }

    public boolean update(BoardDTO boardDTO) {
        int result = boardRepository.update(boardDTO);
        if (result > 0){
            return true;
        } else {
            return false;
        }
    }
}
