package com.pond.graph_ql.domain;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Board {

	@Id @GeneratedValue
	private Long boardId;	
	@Column(nullable = false)
	private String author;
	@Column(nullable = false)
	private String content;
	@Column(nullable = false)
	private String removeKey;
	@CreatedDate
	@Column(nullable = false)
	private LocalDateTime createdDate;
	@LastModifiedDate
	private LocalDateTime updatedDate;
	private boolean visible;
}
