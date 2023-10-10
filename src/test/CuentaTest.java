package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;

class CuentaTest {

	static Cuenta c, c1, c2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new Cuenta("12345", "Manuel", 0.0);
		c1 = new Cuenta("12345", "Manuel", 50.0);
		c2 = new Cuenta("67890", "Manuela", 0.0);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		c.setSaldo(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testIngreso() {
		c.ingreso(10);
		assertEquals(10, c.getSaldo());
	}

	@Test
	void testReintegro() throws Exception {
		c.reintegro(10);
		assertEquals(-10, c.getSaldo());
	}
	
	@Test
	void Test00014() throws Exception {
		c1.reintegro(200);
		c2.reintegro(350);
		c1.ingreso(100);
		c2.reintegro(200);
		c2.reintegro(150);
		c1.reintegro(200);
		c2.ingreso(50);
		c2.reintegro(100);
	}

}
