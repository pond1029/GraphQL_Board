package com.pond.graph_ql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.pond.graph_ql.domain.Board;

public interface BoardRepository  extends JpaRepository<Board,Long> {

	  Page<Board> findByVisible(boolean visible, Pageable pageable);
	  
	  List<Board> findByVisibleOrderByCreatedDateDesc(boolean visible);
	  
	  Optional<Board> findByBoardId(Long boardId);
	  
	  Board save(Board board);
	  
}