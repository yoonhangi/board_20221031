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
        boardService.updateHits(id);
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/boardDetail";
    }

    @GetMapping("/update")
    public String updateFn(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/boardUpdate";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute BoardDTO boardDTO, Model model){
//        수정 처리 후 상세페이지 출력
        boardService.update(boardDTO);
//        DB에서 가져와서 boardDetail 출력
        BoardDTO dto = boardService.findById(boardDTO.getId());
        model.addAttribute("board",dto);
        return "boardPages/boardDetail";
    }

//    삭제할 id
    @GetMapping("/deleteCheck")
    public String deleteCheck(@RequestParam("id") Long id, Model model){
        BoardDTO boardDTO = boardService.findById(id);
        model.addAttribute("board", boardDTO);
        return "boardPages/deleteCheck";
    }

//    삭제 처리
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
       boardService.delete(id);
       return "redirect:/board/";
    }

}
