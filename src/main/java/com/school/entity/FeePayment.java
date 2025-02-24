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
	    
	    @ManyToOne
	    @JoinColumn(name = "fk_rollNo", referencedColumnName = "rollNo")
	    private StudentEntity student;

		public Object getPaid() {
			// TODO Auto-generated method stub
			return null;
		}

		
}
