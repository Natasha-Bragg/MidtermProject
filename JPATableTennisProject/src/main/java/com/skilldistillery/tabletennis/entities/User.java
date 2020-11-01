package com.skilldistillery.tabletennis.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	// fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String email;
	private String password;
	private int enabled;
	private String role;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private int host;
	private int travel;

	@Column(name = "profile_image_url")
	private String profileImageUrl;

	@OneToOne
	@JoinColumn(name = "address_id")
	private Address address;

	@ManyToOne
	@JoinColumn(name = "skill_level_id")
	private SkillLevel skillLevel;

	@OneToMany(mappedBy = "userMakingRating")
	private List<PlayerRating> usersMakingRatings;

	@OneToMany(mappedBy = "userBeingRated")
	private List<PlayerRating> ratedUsers;

//	@ManyToOne
//	@JoinColumn(name = "ratingUser")
//	private List<PlayerRating> ratingsUsers;
//	
//	@ManyToOne
//	@JoinColumn(name = "rated_user_id")
//	private List<PlayerRating> ratedUsers;

	// constructors
	public User() {
		super();
	}

	public User(int id, String email, String password, int enabled, String role, String firstName, String lastName,
			int host, int travel, String profileImageUrl) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.host = host;
		this.travel = travel;
		this.profileImageUrl = profileImageUrl;
	}

	// getters/setters
	public String getUsername() {
		return email;
	}

	public void setUsername(String username) {
		this.email = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getHost() {
		return host;
	}

	public void setHost(int host) {
		this.host = host;
	}

	public int getTravel() {
		return travel;
	}

	public void setTravel(int travel) {
		this.travel = travel;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public SkillLevel getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(SkillLevel skillLevel) {
		this.skillLevel = skillLevel;
	}

	public List<PlayerRating> getUsersMakingRatings() {
		return usersMakingRatings;
	}

	public void setUsersMakingRatings(List<PlayerRating> usersMakingRatings) {
		this.usersMakingRatings = usersMakingRatings;
	}

	public List<PlayerRating> getRatedUsers() {
		return ratedUsers;
	}

	public void setRatedUsers(List<PlayerRating> ratedUsers) {
		this.ratedUsers = ratedUsers;
	}

	// add/remove list methods
	public void addUserRating(PlayerRating userRating) {
		if (usersMakingRatings == null) {
			usersMakingRatings = new ArrayList<>();

			if (!usersMakingRatings.contains(userRating)) {
				usersMakingRatings.add(userRating);
			}
		}
	}

	public void removeUserRating(PlayerRating userRating) {
		if (usersMakingRatings != null && usersMakingRatings.contains(userRating)) {
			usersMakingRatings.remove(userRating);
		}
	}

	public void addRatedUser(PlayerRating ratedUser) {
		if (ratedUsers == null) {

			ratedUsers = new ArrayList<>();
			if (!ratedUsers.contains(ratedUser)) {
				ratedUsers.add(ratedUser);

			}
		}
	}

	public void removeRatedUser(PlayerRating ratedUser) {
		if (ratedUsers != null && ratedUsers.contains(ratedUser)) {
			ratedUsers.remove(ratedUser);
		}
	}

	// other methods
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", enabled=" + enabled + ", role="
				+ role + ", firstName=" + firstName + ", lastName=" + lastName + ", host=" + host + ", travel=" + travel
				+ ", profileImageUrl=" + profileImageUrl + ", address=" + address + ", skillLevel=" + skillLevel + "]";
	}

}