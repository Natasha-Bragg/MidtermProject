package com.skilldistillery.tabletennis.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameCommentTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private GameComment gameComment;

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
		gameComment = em.find(GameComment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		gameComment = null;
	}

	@Test
	void test() {
		assertNotNull(gameComment);
		assertEquals( 1, gameComment.getId());	}
}
