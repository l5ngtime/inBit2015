package com.bit2015.mysite2.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit2015.mysite2.service.BoardService;
import com.bit2015.mysite2.vo.BoardVo;
import com.bit2015.mysite2.vo.ReplyVo;
import com.bit2015.mysite2.vo.UserVo;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping("/list")
	public String list(@RequestParam(required = false) String kwd,
			@RequestParam(required = false, defaultValue = "no") String search,
			@RequestParam(required = false, defaultValue = "1") int num, Model model) {
		List<BoardVo> list = null;
		int panum = 1;
		int total = 0;
		int to = 0;

		if (search.equals("no")) {
			total = boardService.totalPage();
			// int retotal=rdao.totalPage();
			if (total % 5 == 0) {
				to = total / 5;
			} else {
				to = (total / 5) + 1;
			}
			if (num <= 0 || num > to) {
				list = boardService.getList(num);
			} else {
				list = boardService.getList(num);
				if (num <= 5) {
				} else if (num > 5 && num < 11) {
					panum = 6;
				} else {
					int tom = num / 5;
					panum = 5 * tom + 1;
				}
			}
		}

		if (search.equals("yes")) {
			total = boardService.searchPage(kwd);
			if (total % 5 == 0) {
				to = total / 5;
			} else {
				to = (total / 5) + 1;
			}
			if (num <= 0 || num > to) {

				list = boardService.search(kwd, num);
			} else {
				list = boardService.search(kwd, num);
				if (num <= 5) {
				} else if (num > 5 && num < 11) {
					panum = 6;
				} else {
					int tom = num / 5;
					panum = 5 * tom + 1;
				}
			}
		}
		int stnum = total - (num - 1) * 5;

		model.addAttribute("list", list);
		model.addAttribute("total", total);
		model.addAttribute("panum", panum);
		model.addAttribute("num", num);
		model.addAttribute("to", to);
		model.addAttribute("stnum", stnum);
		model.addAttribute("kwd", kwd);

		return "board/list";
	}

	@RequestMapping("/view")
	public String view(@RequestParam long no, Model model) {
		BoardVo vo = boardService.getView(no);
		List<ReplyVo> rist = boardService.getReList(no);
		boardService.plusCnt(no);
		if (rist != null) {
			model.addAttribute("list", rist);
		}
		model.addAttribute("vo", vo);

		return "board/view";
	}

	@RequestMapping("/writeform")
	public String writeform() {
		return "board/write";
	}

	@RequestMapping("/write")
	public String write(HttpSession session, BoardVo vo) {
		UserVo uvo = (UserVo) session.getAttribute("authUser");
		boardService.insert(vo, uvo);
		return "redirect:/board/list";
	}

	@RequestMapping("/dapform")
	public String dapform(BoardVo vo, Model model) {
		model.addAttribute("vo", vo);
		return "board/dapform";
	}

	@RequestMapping("/dap")
	public String dap(BoardVo vo) {
		boardService.dapInsert(vo);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/reply")
	public String reply(@RequestParam long post_no, ReplyVo vo, Model model) {
		vo.setPost_no(post_no);
		boardService.reply(vo);
		model.addAttribute("no", post_no);
		return "redirect:/board/view";
	}
	
	@RequestMapping("/redelete")
	public String redelete(@RequestParam long post_no, @RequestParam long no, Model model) {
		boardService.redelete(no);
		model.addAttribute("no", post_no);
		return "redirect:/board/view";
	}

	@RequestMapping("/delete")
	public String redelete(@RequestParam long no) {
		boardService.delete(no);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/updateform")
	public String updateform(@RequestParam long no, Model model) {
		BoardVo vo =boardService.upView(no);
		model.addAttribute("vo", vo);
		return "board/updateform";
	}
	
	@RequestMapping("/update")
	public String update(@RequestParam long no, BoardVo vo, Model model) {
		vo.setNo(no);
		boardService.update(vo);
		model.addAttribute("no", vo.getNo());
		return "redirect:/board/view";
	}

}