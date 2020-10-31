package com.skilldistillery.tabletennis.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "date_time")
	private LocalDateTime dateTime;

	private String venue;

	private String result;

	@OneToOne
	@JoinColumn(name = "player_one_id")
	private int playerOneId;

	@OneToOne
	@JoinColumn(name = "player_two_id")
	private int playerTwoId;

	@OneToOne
	@JoinColumn(name = "winner_id")
	private int winnerId;

	@OneToOne
	@JoinColumn(name = "address_id")
	private int addressId;

	public Game() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getPlayerOneId() {
		return playerOneId;
	}

	public void setPlayerOneId(int playerOneId) {
		this.playerOneId = playerOneId;
	}

	public int getPlayerTwoId() {
		return playerTwoId;
	}

	public void setPlayerTwoId(int playerTwoId) {
		this.playerTwoId = playerTwoId;
	}

	public int getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(int winnerId) {
		this.winnerId = winnerId;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", dateTime=" + dateTime + ", venue=" + venue + ", result=" + result
				+ ", playerOneId=" + playerOneId + ", playerTwoId=" + playerTwoId + ", winnerId=" + winnerId
				+ ", addressId=" + addressId + "]";
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
		Game other = (Game) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
