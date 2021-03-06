package com.skilldistillery.tabletennis.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="game_comment")

public class GameComment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column (name="comment_date")
	private LocalDateTime commentDate;
	
	@Column (name="comment_text")
	private String commentText;
	
	@Column (name="user_id")
	private int userId;

	@Column (name="game_id")
	private int gameId;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentDate == null) ? 0 : commentDate.hashCode());
		result = prime * result + ((commentText == null) ? 0 : commentText.hashCode());
		result = prime * result + gameId;
		result = prime * result + id;
		result = prime * result + userId;
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
		GameComment other = (GameComment) obj;
		if (commentDate == null) {
			if (other.commentDate != null)
				return false;
		} else if (!commentDate.equals(other.commentDate))
			return false;
		if (commentText == null) {
			if (other.commentText != null)
				return false;
		} else if (!commentText.equals(other.commentText))
			return false;
		if (gameId != other.gameId)
			return false;
		if (id != other.id)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

	public GameComment(int id, LocalDateTime commentDate, String commentText) {
		super();
		this.id = id;
		this.commentDate = commentDate;
		this.commentText = commentText;
	}

	public GameComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "GameComment [id=" + id + ", commentDate=" + commentDate + ", commentText=" + commentText + ", userId="
				+ userId + ", gameId=" + gameId + "]";
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public GameComment(int id, LocalDateTime commentDate, String commentText, int userId, int gameId) {
		super();
		this.id = id;
		this.commentDate = commentDate;
		this.commentText = commentText;
		this.userId = userId;
		this.gameId = gameId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	

}
