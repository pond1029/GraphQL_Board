package com.pond.graph_ql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;

@Component
public class BoardDataFetcher {

	@Autowired
	private BoardService boardService;
	
	public DataFetcher<?> getBoardList(){
		return environment->{
			return boardService.getBoardList();
		};
	}
	
	public DataFetcher<?> setBoard(){
		return dataFetchingEnvironment ->{
			return boardService.save(dataFetchingEnvironment.getArgument("content"));
		};
	}
	
}
