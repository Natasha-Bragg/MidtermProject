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

class AddressTest {

		private static EntityManagerFactory emf;
		private EntityManager em;
		private Address address;
		
		
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
			address = em.find(Address.class, 1);
		}

		@AfterEach
		void tearDown() throws Exception {
			em.close();
			address = null;
		}
		
		@Test
		@DisplayName("test Address entity mappings")
		void test1() {
			assertNotNull(address);
			assertEquals("123 Apple Street", address.getStreet());
			assertEquals("New Orleans", address.getCity());
			assertEquals("LA", address.getState());
			assertEquals("70094", address.getZip());
		}


	}