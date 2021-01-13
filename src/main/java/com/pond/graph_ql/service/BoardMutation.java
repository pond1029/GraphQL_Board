/**
  * @Package : com.pond.graph_ql.service
  * @FileName : Mutation.java
  * @Date : 2021. 1. 13. 
  * @Author : "LeeJaeYeon"
  * @Version :
  * @Information :
  */

package com.pond.graph_ql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.pond.graph_ql.domain.Board;
import com.pond.graph_ql.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

/**
  * @Package : com.pond.graph_ql.service
  * @FileName : Mutation.java
  * @Date : 2021. 1. 13. 
  * @Author : "LeeJaeYeon"
  * @Version :
  * @Information :
  */

@Service
@RequiredArgsConstructor
public class BoardMutation implements GraphQLMutationResolver{

	private final BoardRepository boardRepository;	
	
	public Board setBoard(String author, String content, String removeKey) {
		if(author.isBlank() || content.isBlank() || removeKey.isBlank()) {
			return null;
		}
		
		Board board = Board.builder()
		.author(author)
		.content(content)
		.removeKey(removeKey)
		.visible(true)
		.build();
		return boardRepository.save(board);
	}
	
	public Board removeBoard(Long boardId, String removeKey) {
		Optional<Board> removeBoard = boardRepository.findByBoardId(boardId);
		if(removeBoard.isEmpty()) return null;
		Board targetBoard = removeBoard.get();
		if(!targetBoard.getRemoveKey().equals(removeKey))return null;
		targetBoard.setVisible(false);
		
		return boardRepository.save(targetBoard);
	}
	
}
