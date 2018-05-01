package com.icop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.icop.entity.Course;
import com.icop.exception.DeleteFailEx;
import com.icop.exception.InsersionFailEx;
import com.icop.exception.RetrieveFailEx;
import com.icop.exception.UpdateFailEx;

@Repository("CourseDAO")
@Transactional

public class CourseDAOimp implements CourseDAO {

	@PersistenceContext
	public EntityManager entityManager;
	
	@Transactional(readOnly=false)
	public Course addCourseDetails(Course course) throws InsersionFailEx {
		// TODO Auto-generated method stub
		try{
			entityManager.persist(course);
		}catch(Exception e)
		{
			e.printStackTrace();
			//LOG.error("Exception" + e);
			throw new InsersionFailEx("Fail to insert" +e);
		}
		
		return null;
		
	}

	@Transactional(readOnly=false)
	public Course updateCourseDetails(Course course) throws UpdateFailEx {
		// TODO Auto-generated method stub
		try{
			entityManager.merge(course);
		}catch(Exception e)
		{
			e.printStackTrace();
			//LOG.error("Updating Exception" + e);
			throw new UpdateFailEx("Fail to Update" +e);
		}
		finally
		{
			System.out.println("Done with updation");
		}		return null;

	}
	@Transactional(readOnly=false)
	public void deleteCourseDetails(long id) throws DeleteFailEx {
		// TODO Auto-generated method stub
		try{
			Course lid= getCourseDetails(id);
			entityManager.remove(lid);
		}catch(Exception e)
		{
			e.printStackTrace();
			//LOG.error("Deleting Exception" + e);
			throw new DeleteFailEx("Fail to Delete" +e);
		}
		finally
		{
			System.out.println("Done with Deletion");
		}
		
	}

	@Transactional(readOnly=true)
	public Course getCourseDetails(long id) throws RetrieveFailEx {
		// TODO Auto-generated method stub
		
		String sql = "select course from Course course where loan.id="+id;
		try{
			return (Course) entityManager.createQuery(sql).getSingleResult();
		}catch(Exception e)
		{
			e.printStackTrace();
			//LOG.error(e.getStackTrace().toString());
			//LOG.error("Exception" +e);
			throw new RetrieveFailEx("Fail to Retrieve" +e);
		}
		finally
		{
			System.out.println("Retrieve is done");
		}
	}

	@Transactional(readOnly=true)
	public List<Course> getCourseDetails() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("select loan from Loan loan").getResultList();
	}

}
