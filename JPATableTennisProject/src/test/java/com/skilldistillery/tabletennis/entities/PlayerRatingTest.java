package com.skilldistillery.tabletennis.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerRatingTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private PlayerRating playerRating;

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
		playerRating = em.find(PlayerRating.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		playerRating = null;
	}

	@Test
	@DisplayName("test PlayerRating ManyToOne userRated to User")
	void test1() {
		assertNotNull(playerRating);
		assertEquals("Ashley", playerRating.getUserRating().getFirstName());
//		assertEquals(1, playerRating.getRatedUser());
//		assertEquals(5, playerRating.getRating());
//		assertEquals(null, playerRating.getComment());
	}

	@Test
	@DisplayName("testing PlayerRating ManyToOne userRated to User")
	void test2() {
		assertNotNull(playerRating);
		assertEquals("Davis", playerRating.getRatedUser().getLastName());
	}
}
