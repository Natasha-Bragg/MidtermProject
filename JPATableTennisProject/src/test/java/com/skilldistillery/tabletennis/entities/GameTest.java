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
import org.junit.jupiter.api.Test;

class GameTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Game game;

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
		game = em.find(Game.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		game = null;
	}

	@Test
	void test1() {
		assertNotNull(game);
		assertEquals(1, game.getId());
	}

	@Test
	void test2() {
		assertNotNull(game);
		assertEquals(2020, game.getDateTime().getYear());
		assertEquals(10, game.getDateTime().getMonthValue());
		assertEquals(29, game.getDateTime().getDayOfMonth());
		assertEquals(2, game.getDateTime().getHour());
	}

	@Test
	void test3() {
		assertNotNull(game);
		assertEquals("Ashley's house", game.getVenue());
	}

	@Test
	void test4() {
		assertNotNull(game);
		assertEquals("Ashley won", game.getResult());
	}

	@Test
	void test5() {
		assertNotNull(game);
		assertEquals("Ashley", game.getPlayerOne().getFirstName());
	}

	@Test
	void test6() {
		assertNotNull(game);
		assertEquals("Socrates", game.getPlayerTwo().getFirstName());
	}

	@Test
	void test7() {
		assertNotNull(game);
		assertEquals("Ashley", game.getWinner().getFirstName());
	}

	@Test
	void test8() {
		assertNotNull(game);
		assertEquals("123 Apple Street", game.getAddress().getStreet());
	}

}
