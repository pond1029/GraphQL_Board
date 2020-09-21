package com.pond.graph_ql.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pond.graph_ql.domain.Board;
import com.pond.graph_ql.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	
	public List<Board> getBoardList(){
		return boardRepository.findAllByOrderByDateDesc();
	}
	
	public Board save(Map<String, Object> input) {
		
		Board newBoard = new Board();
		newBoard.setDate(new Date());
		newBoard.setContent((String) input.get("content"));
		newBoard.setAuthor((String) input.get("author"));
		return boardRepository.save(newBoard);
	}
}
