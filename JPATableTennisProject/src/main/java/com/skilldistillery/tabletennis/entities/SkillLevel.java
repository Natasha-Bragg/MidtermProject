package com.skilldistillery.tabletennis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="skill_level")

public class SkillLevel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name="level_name" )
	private String levelName;
	
	private String description;
	
//	@OneToMany(mappedBy = "skillLevel")
//	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SkillLevel(int id, String levelName, String description) {
		super();
		this.id = id;
		this.levelName = levelName;
		this.description = description;
	}

	public SkillLevel() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	@Override
	public String toString() {
		return "SkillLevel [id=" + id + ", levelName=" + levelName + ", description=" + description + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		SkillLevel other = (SkillLevel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
}
