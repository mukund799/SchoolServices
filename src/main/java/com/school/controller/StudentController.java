package com.school.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.school.beantest.PrototypeScope;
import com.school.beantest.SingletonScope;
import com.school.entity.StudentEntity;
import com.school.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private final SingletonScope sbt1;
	
	
	@Autowired
	public StudentController(SingletonScope sbt1) {
		this.sbt1 = sbt1;
	}
	
	private PrototypeScope bt;
	@Autowired(required = false)
	public void setStudentController(PrototypeScope bt) {
		this.bt = bt;
	}
	
	
	
	@Autowired
	StudentService service;
	
	@Value("${app.name}")
	String name;
	@GetMapping("/start")
	public String test() {
		
       
		String res  = sbt1.BeanTest("Mukund Narayan");
		String res2  = bt.beantest("Mukund 2");
//		if(sbt1==sbt2) {
//			System.out.println("true");
//		}
//		else {
//			System.out.println("false");
//		}
		return "Hello bachho, Kaise ho bete!!" +" name is: "+name+ res+" singletoneScope is: "+ res2;
	}
	
	@PostMapping("/addDetails")
	public ResponseEntity<String> addDetails(@RequestBody StudentEntity s) {
		
//		String rn = s.getClassName() + s.getSection() + s.getRollNo();
//		s.setRollNo(rn);
//		FeePayment f = new FeePayment();
//		f.setStudent(s);
//		f.setMonth(s.getFeePayments().get(0).getMonth());
//		f.setPaid(s.getFeePayments().get(0).getPaid());
//		f.setYear((s.getFeePayments().get(0).getYear()));
//		f.setStudent(s);
////		s.setFeePayments(f);
//		List<FeePayment> arr = new ArrayList<>();
//		arr.add(f);
//		s.setFeePayments(arr);
		StudentEntity rs = service.saveStudentData(s);
		
		if (rs != null)
		 return new ResponseEntity<>("Student Details Addedd.", HttpStatus.OK);
		else return new ResponseEntity<> ("student details already saved.", HttpStatus.CONFLICT );
	}
	
	@GetMapping("/getAllDetails")
	public ResponseEntity<List<StudentEntity>> getAllDetails(){
		List<StudentEntity> list =  service.getAllDetailsOfStudent();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/getDetails/{id}")
	public ResponseEntity<?> getDetails(@PathVariable String id){
		
		StudentEntity entity =  service.getDetailsOfStudent(id);
		if ( entity != null)
		return new ResponseEntity<>(entity, HttpStatus.OK);
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID " + id + " not found");
		
		return new ResponseEntity<>("Student with id "+id+" not ffound", HttpStatus.NOT_FOUND);
	}

	@GetMapping("getDetailsByname/{name}")
	public ResponseEntity<?> getDetailsByName(@PathVariable String name){
		
		StudentEntity se = service.getDetailsByName(name);
		if ( se != null)
			return new ResponseEntity<>(se, HttpStatus.OK);
		return new ResponseEntity<>("Student with name "+name +" not found", HttpStatus.NOT_FOUND);
	}

}