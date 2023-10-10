package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Cuenta;
import pkg.Movimiento;

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
	void Test00014() {
		assertEquals(50, c1.getSaldo());
		assertEquals(0, c2.getSaldo());
		try {
			c1.reintegro(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			c2.reintegro(350);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		c1.ingreso(100);

		try {
			c2.reintegro(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			c2.reintegro(150);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try {
			c1.reintegro(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		c2.ingreso(50);
		try {
			c2.reintegro(100);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

		for (Movimiento m : c1.getListaMovimientos()) {
			System.out.println(m.getDetalle());
		}
		for (Movimiento m : c2.getListaMovimientos()) {
			System.out.println(m.getDetalle());
		}
		ArrayList<String> detalles1 = new ArrayList<String>();
		detalles1.add("Reintegro de 200€ (1)");
		detalles1.add("Ingreso de 100€ (3)");
		detalles1.add("Reintegro de 200€ (6)");
		ArrayList<String> detalles2 = new ArrayList<String>();
		detalles2.add("Reintegro de 350€ (2)");
		detalles2.add("Reintegro de 150€ (5)");
		detalles2.add("Ingreso de 50€ (7)");
		assertEquals(true, c1.seEncuentranMovimientosDetalles(detalles1));
		assertEquals(true, c2.seEncuentranMovimientosDetalles(detalles2));
		assertEquals(-250, c1.getSaldo());
		assertEquals(-450, c2.getSaldo());

	}

}
