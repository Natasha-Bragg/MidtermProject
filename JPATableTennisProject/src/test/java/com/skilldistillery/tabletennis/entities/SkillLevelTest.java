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


class SkillLevelTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private SkillLevel skillLevel;

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
		skillLevel = em.find(SkillLevel.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		skillLevel = null;
	}

	@Test
	void test() {
		assertNotNull(skillLevel);
		assertEquals("Advanced", skillLevel.getLevelName());
	}

}
