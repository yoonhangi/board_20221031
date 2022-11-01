package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/save")
    public String save(){
        return "boardSave";
    }

    @PostMapping("/boardSave")
    public String boardSave(@ModelAttribute BoardDTO boardDTO, Model model){
       boolean result = boardService.boardSave(boardDTO);
       model.addAttribute("result", result);
       if (result) {
          return "redirect:/boardList";
       } else {
           return "index";
       }
    }

    @GetMapping("/boardList")
    public String board(Model model) {
        List<BoardDTO> boardList = boardService.board();
        model.addAttribute("boardList", boardList);
        return "/boardList";
    }

    @GetMapping("/board")
    public String findByBoard(@RequestParam("title") String title, Model model){
        BoardDTO boardDTO = boardService.findByBoard(title);
        model.addAttribute("board", boardDTO);
        return "boardDetail";
    }

}
