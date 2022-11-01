package com.its.board.controller;

import com.its.board.dto.BoardDTO;
import com.its.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {
    @Autowired
    private BoardService boardService;

    @GetMapping("/save")
    public String save(){
        return "boardPages/boardSave";
//        return "boardPages/boardSave"; => views/boardPages/boardSave.jsp
    }


   @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute BoardDTO boardDTO, Model model){
       boolean result = boardService.save(boardDTO);
       model.addAttribute("result", result);
       if (result) {
          return "redirect:/board/";
       } else {
           return "index";
       }
    }

    @GetMapping("/")
    public String findAll(Model model) {
        List<BoardDTO> boardList = boardService.findAll();
        model.addAttribute("boardList", boardList);
        return "boardPages/boardList";
    }

    // 상세조회: /board?id=
    // 파라미터만 받아오면 되기 때문에 주소를 안써도 된다.
    @GetMapping
    public String findByBoard(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/boardDetail";
    }

    @GetMapping("/update")
    public String updateFn(@ModelAttribute BoardDTO boardDTO ,Model model){
        BoardDTO result = boardService.updateFn(boardDTO);
        model.addAttribute("result", result);
        return "boardPages/boardUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO){
        boolean result = boardService.update(boardDTO);
        if (result){
            return "redirect:boardPages/boardList";
        } else {
            return "boardPages/boardUpdate";
        }
    }

}
