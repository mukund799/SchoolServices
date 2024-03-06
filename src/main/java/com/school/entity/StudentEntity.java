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
@NoArgsConstructor
public class StudentEntity {
	
	private int id;
	private String name;
	private String fatherName;
	private String motherName;
	@Id
	@Column(unique = true)
	private String rollNo;
	private String section;
	private String className;
	
	@OneToMany( cascade = CascadeType.ALL)
	private List<FeePayment> feePayments = new ArrayList<>();

	StudentEntity() {
		//super();
		// TODO Auto-generated constructor stub
	}
	public StudentEntity(int id, String name, String fatherName, String motherName, String rollNo, String section,
			String className) {
		this.id = id;
		this.name = name;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.rollNo = rollNo;
		this.section = section;
		this.className = className;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMotherName() {
		return motherName;
	}
	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<FeePayment> getFeePayments() {
		return feePayments;
	}
	public void setFeePayments(List<FeePayment> feePayments) {
		this.feePayments = feePayments;
	}
	
}
