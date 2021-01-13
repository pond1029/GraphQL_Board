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
public class BoardQuery implements  GraphQLQueryResolver{

	private final BoardRepository boardRepository;	
	
	public List<Board> getBoardList(){
		return boardRepository.findByVisibleOrderByCreatedDateDesc(true);
	}
	
	
}
