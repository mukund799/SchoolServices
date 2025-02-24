package com.school.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "School", uniqueConstraints = @UniqueConstraint(columnNames = {"rollNo"}))
@Data
public class StudentEntity {

	
	private int id;
	private String name;
	private String fatherName;
	private String motherName;
	@Id
	private String rollNo;
	private String section;
	private String className;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<FeePayment> feePayments = new ArrayList<>();

	
	
}
