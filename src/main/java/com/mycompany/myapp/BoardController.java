package com.mycompany.myapp;

import com.mycompany.myapp.board.BoardDAO;
import com.mycompany.myapp.board.BoardService;
import com.mycompany.myapp.board.BoardServiceImpl;
import com.mycompany.myapp.board.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board")
public class BoardController {

    @Autowired
    BoardServiceImpl boardService;

    public void setBoardService(BoardServiceImpl boardService) {
        this.boardService = boardService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String boardList(Model model) {
        model.addAttribute("boardList", boardService.getBoardList());
        return "posts";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPost() {
        return "addform";
    }

    @RequestMapping(value = "/addok", method = RequestMethod.POST)
    public String addPostOk(BoardVO vo) {
        if (boardService.insertBoard(vo) == 0) {
            System.out.println("데이터 추가 실패");
        } else {
            System.out.println("데이터 추가 성공");
        }
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/editform/{id}", method = RequestMethod.GET)
    public String editPost(@PathVariable("id") int id, Model model) {
        BoardVO boardVO = boardService.getBoard(id);
        model.addAttribute("boardVO", boardVO);
        return "editform";
    }

    @RequestMapping(value = "/editok", method = RequestMethod.POST)
    public String editPostOk(BoardVO vo) {
        if (boardService.updateBoard(vo) == 0) {
            System.out.println("데이터 수정 실패");
        } else {
            System.out.println("데이터 수정 성공");
        }
        return "redirect:/board/list";
    }

    @RequestMapping(value = "/deleteok/{id}", method = RequestMethod.GET)
    public String deletePostOk(@PathVariable("id") int id) {
        if (boardService.deleteBoard(id) == 0) {
            System.out.println("데이터 삭제 실패");
        } else {
            System.out.println("데이터 삭제 성공");
        }
        return "redirect:../list";
    }
}
