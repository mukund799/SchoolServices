package com.school.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FeePayment {
		public FeePayment() {
		super();
	}

		public FeePayment(Long idF, String month, String year, String paid, StudentEntity student) {
		super();
		this.idF = idF;
		this.month = month;
		this.year = year;
		this.paid = paid;
		this.student = student;
	}

		@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long idF;
	    private String month;
	    private String year;
	    private String paid;
	    
	    @OneToOne
	    @JoinColumn(name = "fk_rollNo", referencedColumnName = "rollNo")
	    private StudentEntity student;

		public Long getIdF() {
			return idF;
		}

		public void setIdF(Long idF) {
			this.idF = idF;
		}

		public String getMonth() {
			return month;
		}

		public void setMonth(String month) {
			this.month = month;
		}

		public String getYear() {
			return year;
		}

		public void setYear(String year) {
			this.year = year;
		}

		public String getPaid() {
			return paid;
		}

		public void setPaid(String paid) {
			this.paid = paid;
		}

		public StudentEntity getStudent() {
			return student;
		}

		public void setStudent(StudentEntity student) {
			this.student = student;
		}

		
}
