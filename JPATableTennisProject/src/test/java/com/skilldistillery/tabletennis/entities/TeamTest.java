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


class TeamTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Team team;
	
	
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
		team = em.find(Team.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		team = null;
	}
	
	@Test
	@DisplayName("test Team entity mappings")
	void test1() {
		assertNotNull(team);
		assertEquals("Sharks",team.getName());
		assertEquals("a ping pong team", team.getDescription());
		assertEquals("https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.clipartmax.com%2Fpng%2Fmiddle%2F242-2423592_shark-contacts-shark-logo-png.png&imgrefurl=https%3A%2F%2Fwww.clipartmax.com%2Fmiddle%2Fm2H7K9G6Z5d3H7b1_shark-contacts-shark-logo-png%2F&tbnid=dORIiZVU2L9whM&vet=12ahUKEwiT57mHo93sAhVDLc0KHUnzCScQMygWegUIARClAg..i&docid=fYDar4OGuaKcCM&w=840&h=691&q=shark%20logo&ved=2ahUKEwiT57mHo93sAhVDLc0KHUnzCScQMygWegUIARClAg", team.getLogo());
	}

}
