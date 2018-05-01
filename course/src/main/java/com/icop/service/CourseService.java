package com.icop.service;

import java.util.List;

import com.icop.entity.Course;
import com.icop.exception.DeleteFailEx;
import com.icop.exception.InsersionFailEx;
import com.icop.exception.RetrieveFailEx;
import com.icop.exception.UpdateFailEx;

public interface CourseService {
	
	public Course addCourseDetails(Course course) throws InsersionFailEx;
	public Course updateCourseDetails(Course course) throws UpdateFailEx;
	public boolean deleteCourseDetails(long id) throws DeleteFailEx, DeleteFailEx;
	public Course getCourseDetails(long id) throws RetrieveFailEx, RetrieveFailEx;
	public List<Course> getCourseDetails();

}
