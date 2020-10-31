package com.skilldistillery.tabletennis.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "player_rating")
public class PlayerRating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany(mappedBy = "user_id")
	private List<User> ratingUser;
	
	@OneToMany(mappedBy = "rated_user_id")
	private List<User> ratedUser;
	
	
	private int rating;
	
	private String comment;

	public PlayerRating() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}






	public List<User> getRatingUser() {
		return ratingUser;
	}

	public void setRatingUser(List<User> ratingUser) {
		this.ratingUser = ratingUser;
	}

	public List<User> getRatedUser() {
		return ratedUser;
	}

	public void setRatedUser(List<User> ratedUser) {
		this.ratedUser = ratedUser;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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
		PlayerRating other = (PlayerRating) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PlayerRating [id=" + id + ", ratingUser=" + ratingUser + ", ratedUser=" + ratedUser + ", rating="
				+ rating + ", comment=" + comment + "]";
	}

	





}
