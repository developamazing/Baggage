package com.icop.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course implements Serializable {
 
	private static final long serialVersionUID = 1L;
	 public Course(){
	 
    }
	 
	 public Course ( int mId, int cId, String mName, String mAss, String mDur)
	 {
		 super();
		 MODULEID = mId;
		 COURSEID = cId;
		 MODULENAME = mName;
		 MODULEASSIGNMENT = mAss;
		 MODULEDURATION = mDur;
		 
	 }
	 @Column(name = "MODULEID")
	 private int MODULEID;
	 @Column(name = "COURSEID")
	 private int COURSEID;
	 @Column(name = "MODULENAME")
	 private String MODULENAME;
	 @Column(name = "MODULEASSIGNMENT")
	 private String MODULEASSIGNMENT;
	 @Column(name = "MODULEDURATION")
	 private String MODULEDURATION;
	public int getMODULEID() {
		return MODULEID;
	}

	public void setMODULEID(int mODULEID) {
		MODULEID = mODULEID;
	}

	public int getCOURSEID() {
		return COURSEID;
	}

	public void setCOURSEID(int cOURSEID) {
		COURSEID = cOURSEID;
	}

	public String getMODULENAME() {
		return MODULENAME;
	}

	public void setMODULENAME(String mODULENAME) {
		MODULENAME = mODULENAME;
	}

	public String getMODULEASSIGNMENT() {
		return MODULEASSIGNMENT;
	}

	public void setMODULEASSIGNMENT(String mODULEASSIGNMENT) {
		MODULEASSIGNMENT = mODULEASSIGNMENT;
	}

	public String getMODULEDURATION() {
		return MODULEDURATION;
	}

	public void setMODULEDURATION(String mODULEDURATION) {
		MODULEDURATION = mODULEDURATION;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + COURSEID;
		result = prime * result + ((MODULEASSIGNMENT == null) ? 0 : MODULEASSIGNMENT.hashCode());
		result = prime * result + ((MODULEDURATION == null) ? 0 : MODULEDURATION.hashCode());
		result = prime * result + MODULEID;
		result = prime * result + ((MODULENAME == null) ? 0 : MODULENAME.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (COURSEID != other.COURSEID)
			return false;
		if (MODULEASSIGNMENT == null) {
			if (other.MODULEASSIGNMENT != null)
				return false;
		} else if (!MODULEASSIGNMENT.equals(other.MODULEASSIGNMENT))
			return false;
		if (MODULEDURATION == null) {
			if (other.MODULEDURATION != null)
				return false;
		} else if (!MODULEDURATION.equals(other.MODULEDURATION))
			return false;
		if (MODULEID != other.MODULEID)
			return false;
		if (MODULENAME == null) {
			if (other.MODULENAME != null)
				return false;
		} else if (!MODULENAME.equals(other.MODULENAME))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Course [MODULEID=" + MODULEID + ", COURSEID=" + COURSEID + ", MODULENAME=" + MODULENAME
				+ ", MODULEASSIGNMENT=" + MODULEASSIGNMENT + ", MODULEDURATION=" + MODULEDURATION + "]";
	}
	 
	 
	 
	
}
