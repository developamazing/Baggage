package com.icop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icop.entity.Course;
import com.icop.exception.DeleteFailEx;
import com.icop.exception.InsersionFailEx;
import com.icop.exception.RetrieveFailEx;
import com.icop.exception.UpdateFailEx;
import com.icop.entity.Course;
import com.icop.dao.CourseDAO;

@Service("CourseService")
@Transactional
public class CourseServiceimp implements CourseService {
	
	@Autowired(required=true)
	@Qualifier("CourseDAO")
	
	private CourseDAO coursedao;
	
	@Transactional
	
	public Course addCourseDetails(Course course) throws InsersionFailEx {
		// TODO Auto-generated method stub
		System.out.println("Service is invoked:");
		try{
			course = coursedao.addCourseDetails(course);
		}catch(Exception e)
		{
			//LOG.error("Unable to  add this");
		}
		return course;
	}

	@Transactional
	public Course updateCourseDetails(Course course) throws UpdateFailEx {
		// TODO Auto-generated method stub
		System.out.println("Marketer Service Update invoked:");
		course = coursedao.updateCourseDetails(course);
		//LOG.debug(" loan updated");
		return course;
	}
	@Transactional
	public boolean deleteCourseDetails(long id) throws DeleteFailEx, DeleteFailEx {
		// TODO Auto-generated method stub
		try {
			coursedao.deleteCourseDetails(id);
		} catch (Exception e) {
			//LOG.error("deleting exception");
			e.printStackTrace();
		}
		
		return false;
	}

	public Course getCourseDetails(long id) throws RetrieveFailEx, RetrieveFailEx {
		// TODO Auto-generated method stub
		try
		{
			Course ln = coursedao.getCourseDetails(id);
			//LOG.info("Received  details..." + ln.getName());
			return ln;
		}
		catch(Exception ex)
		{
			//LOG.info("Received details exception..." ,ex);			
		}
		
		return null;
	}

	public List<Course> getCourseDetails() {
		// TODO Auto-generated method stub
		return coursedao.getCourseDetails();
	}

}
