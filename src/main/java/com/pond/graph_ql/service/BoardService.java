package com.pond.graph_ql.service;

import java.util.Date;
import java.util.List;

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
	
	public Board save(String content) {
		Board newBoard = new Board();
		newBoard.setContent(content);
		newBoard.setDate(new Date());
		return boardRepository.save(newBoard);
	}
}
