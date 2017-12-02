package com.example.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.example.web.msg.MessageVO;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Inject
	public MessageVO vo;

	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/sendVO")
	public MessageVO sendVO() {
		vo.setCode("00");
		vo.setMessage("json 객체로 전송");
		return vo;
	}

	@RequestMapping("/listVO")
	public List<MessageVO> listVO() {
		List<MessageVO> list = new ArrayList<MessageVO>();
		for (int i = 0; i < 10; i++) {
			vo.setNumber(i);
			vo.setCode("00");
			vo.setMessage("json 객체로 전송");
			list.add(vo);
		}

		return list;
	}

	@RequestMapping("/mapVO")
	public Map<Integer, MessageVO> mapVO() {
		Map<Integer, MessageVO> map = new HashMap<Integer, MessageVO>();
		for (int i = 0; i < 10; i++) {
			vo.setNumber(i);
			vo.setCode("00");
			vo.setMessage("json 객체로 전송");
			map.put(i, vo);
		}
		return map;
	}

	@RequestMapping("/view")
	public ModelAndView view() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/sendError")
	public ModelAndView sendError() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home");
		return mv;
	}

	@RequestMapping("/sendErrorNotFound")
	public ResponseEntity<MessageVO> sendErrorNotFound() {
		vo.setMessage("404 NOT Found");
		return new ResponseEntity<MessageVO>(vo, HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping("/sendErrorBad")
	@ResponseStatus(value=HttpStatus.BAD_GATEWAY)
	public MessageVO sendErrorBad() {
		vo.setMessage("Bad Gateway");
		return vo;
	}
	
}
