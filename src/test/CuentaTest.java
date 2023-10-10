package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;

class CuentaTest {

	static Cuenta c;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		c = new Cuenta("12345", "Manuel", 0.0);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		c = new Cuenta("12345", "Manuel", 0.0);
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
	void testReintegro() {
		c.reintegro(10);
		assertEquals(-10, c.getSaldo());
	}

}
