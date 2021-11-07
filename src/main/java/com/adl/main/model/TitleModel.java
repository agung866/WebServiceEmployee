package com.adl.main.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="title")
public class TitleModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String worker_title;
	private LocalDateTime affected_from;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="worker_ref_id",
	referencedColumnName = "worker_id")
	private WorkerModel worker_ref_id;
}
	
