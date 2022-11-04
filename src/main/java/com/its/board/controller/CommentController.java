package com.its.board.controller;

import com.its.board.dto.CommentDTO;
import com.its.board.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody List<CommentDTO> save(@ModelAttribute CommentDTO commentDTO){
        commentService.save(commentDTO); // service 클래스로 넘겨준다
       List<CommentDTO> commentDTOList = commentService.findAll(commentDTO.getBoardId());
        return commentDTOList;
    }
}
