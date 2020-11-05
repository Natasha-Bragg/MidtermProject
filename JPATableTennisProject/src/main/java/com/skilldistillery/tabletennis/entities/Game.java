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

	@Column(name = "d_time")
	private LocalDateTime gameTime;

	private String venue;

	private String result;

	@OneToOne
	@JoinColumn(name = "player_one_id")
	private User playerOne;

	@OneToOne
	@JoinColumn(name = "player_two_id")
	private User playerTwo;

	@OneToOne
	@JoinColumn(name = "winner_id")
	private User winner;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	private Boolean enabled;
	
	public Game() {
		super();
		this.enabled = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getGameTime() {
		return gameTime;
	}

	public void setGameTime(LocalDateTime dateTime) {
		this.gameTime = dateTime;
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

	public User getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(User playerOne) {
		this.playerOne = playerOne;
	}

	public User getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(User playerTwo) {
		this.playerTwo = playerTwo;
	}

	public User getWinner() {
		return winner;
	}

	public void setWinner(User winner) {
		this.winner = winner;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address addressId) {
		this.address = addressId;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", gameTime=" + gameTime + ", venue=" + venue + ", result=" + result + ", playerOne="
				+ playerOne + ", playerTwo=" + playerTwo + ", winner=" + winner + ", address=" + address + ", enabled="
				+ enabled + "]";
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
