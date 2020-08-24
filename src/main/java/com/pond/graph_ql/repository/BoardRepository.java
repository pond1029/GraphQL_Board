package com.pond.graph_ql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pond.graph_ql.domain.Board;

@Repository
public interface BoardRepository  extends JpaRepository<Board,Long> {

	  List<Board> findAll();
	  List<Board> findAllByOrderByDateDesc();
	  Board save(Board board);
}