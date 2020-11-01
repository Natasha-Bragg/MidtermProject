package com.skilldistillery.tabletennis.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("TableTennisProject");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	@DisplayName("testing user entity")
	void test() {
		/*
		 select * from user where user.id = 1;
+----+------------------+----------+---------+-------+------------+-----------+------+--------+------------+----------------+----------------------------------------------------+
| id | email            | password | enabled | role  | first_name | last_name | host | travel | address_id | skill_level_id | profile_image_url                                  |
+----+------------------+----------+---------+-------+------------+-----------+------+--------+------------+----------------+----------------------------------------------------+
|  1 | ashley@email.com | admin    |       1 | admin | Ashley     | Davis     |    1 |      1 |          1 |              1 | https://en.wikipedia.org/wiki/File:Gambia_girl.jpg |
+----+------------------+----------+---------+-------+------------+-----------+------+--------+------------+----------------+----------------------------------------------------+
		 */
		assertNotNull(user);
		assertEquals("ashley@email.com", user.getEmail());
		assertEquals("admin", user.getPassword());
		assertEquals(1, user.getEnabled());
		assertEquals("admin", user.getRole());
		assertEquals("Ashley", user.getFirstName());
		assertEquals("Davis", user.getLastName());
		assertEquals(1, user.getHost());
		assertEquals(1, user.getTravel());
		assertEquals("https://en.wikipedia.org/wiki/File:Gambia_girl.jpg", user.getProfileImageUrl());
	}
	
	@Test
	@DisplayName("testing user to address")
	void test1() {
		/*
		 select address.street, address.city, address.state, address.zip, user.first_name FROM user JOIN address ON address.id = user.address_id where user.id = 1;
+------------------+-------------+-------+-------+------------+
| street           | city        | state | zip   | first_name |
+------------------+-------------+-------+-------+------------+
| 123 Apple Street | New Orleans | LA    | 70094 | Ashley     |
+------------------+-------------+-------+-------+------------+
		 */
		Address address = user.getAddress();
		assertEquals("123 Apple Street", address.getStreet());
		assertEquals("New Orleans", address.getCity());
		assertEquals("LA", address.getState());
		assertEquals("70094", address.getZip());
	}
	
	@Test
	@DisplayName("testing user OneToMany usersMakingRatings to PlayerRating")
	void test2()
	{
		/*
		 select * from player_rating;
+----+---------+---------------+--------+---------+---------+
| id | user_id | rated_user_id | rating | comment | enabled |
+----+---------+---------------+--------+---------+---------+
|  1 |       1 |             1 |      5 | NULL    |       1 |
+----+---------+---------------+--------+---------+---------+
		 */
		assertNotNull(user);
		assertNotNull(user.getUsersMakingRatings());
		assertEquals(5, user.getUsersMakingRatings().get(0).getRating());
	}
	@Test
	@DisplayName("testing user OneToMany RatedUsers to PlayerRating")
	void test3()
	{
		/*
		 select * from player_rating;
+----+---------+---------------+--------+---------+---------+
| id | user_id | rated_user_id | rating | comment | enabled |
+----+---------+---------------+--------+---------+---------+
|  1 |       1 |             1 |      5 | NULL    |       1 |
+----+---------+---------------+--------+---------+---------+
		 */
		assertNotNull(user);
		assertNotNull(user.getRatedUsers().get(0).getId());
		assertEquals(5, user.getUsersMakingRatings().get(0).getRating());
	}
	
	
}
