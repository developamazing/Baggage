package com.icop.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;

import com.icop.exception.RetrieveFailEx;
import com.icop.exception.DeleteFailEx;
import com.icop.exception.InsersionFailEx;
import com.icop.exception.UpdateFailEx;
import com.icop.entity.Course;
import com.icop.service.CourseService;



//@RestController
@RequestMapping("/co")
public class RestController {
	
	//Logger LOG = Logger.getLogger(LoanRestController.class.getName());
	
	@Autowired(required=true)
	@Qualifier("CourseService")
	private CourseService lservice;
	
	@GetMapping("/{id}")
	public Course getdetails(@PathVariable("id") long id){
		//LOG.info("getMarketers for " + id);
		try {
			return lservice.getCourseDetails(id);
		} catch (RetrieveFailEx e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value="/all",method=RequestMethod.GET)
	public ResponseEntity<List<Course>> alldetails(){
		//LOG.info("get all details");
		List<Course> list = lservice.getCourseDetails();
		return new ResponseEntity<List<Course>>(list, HttpStatus.OK);
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public Course editMarketer(@RequestBody Course loan){
		 try {
			loan = lservice.updateCourseDetails(loan);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return loan;
		
	}
	
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public Course addLoanDetails(@RequestBody Course loan){
		
	
	    try {
			loan = lservice.addCourseDetails(loan);
			
            
		} catch (Exception e) {
			
			e.printStackTrace();
			//LOG.error("Unable to add details");
			/*response.setData(marketer);
            response.setStatus(-1);
            response.setMessage("Failed: " + e);*/
			
		}
		return loan;
	}
	
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public Course deleteLoanDetails(@PathVariable("id") long id){
		//LOG.info("delete Marketers for " + id);
		try {
			lservice.deleteCourseDetails(id);
		
		} catch (Exception e) {
			e.printStackTrace();
			//LOG.error("Marketer Deleted Failed");
			
		}
		
		return null;
	}
	
	
	
	

}
