/**
  * @Package : com.pond.graph_ql.service
  * @FileName : Mutation.java
  * @Date : 2021. 1. 13. 
  * @Author : "LeeJaeYeon"
  * @Version :
  * @Information :
  */

package com.pond.graph_ql.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.pond.graph_ql.domain.Board;
import com.pond.graph_ql.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

/**
  * @Package : com.pond.graph_ql.service
  * @FileName : Mutation.java
  * @Date : 2021. 1. 13. 
  * @Author : "LeeJaeYeon"
  * @Version :
  * @Information : 게시판 뮤테이션
  */
@Service
@RequiredArgsConstructor
public class BoardMutation implements GraphQLMutationResolver{

	private final BoardRepository boardRepository;	
	
	public Board setBoard(String author, String content, String removeKey) {
		if(author.isEmpty() || content.isEmpty() || removeKey.isEmpty()) {
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
		if(!removeBoard.isPresent()) return null;
		Board targetBoard = removeBoard.get();
		if(!targetBoard.getRemoveKey().equals(removeKey))return null;
		targetBoard.setVisible(false);
		
		return boardRepository.save(targetBoard);
	}
	
}
