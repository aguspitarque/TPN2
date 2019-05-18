package ar.edu.unlam.pb2.tp2;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCuentas {

	@Test(expected = AssertionError.class)
	public void testQueOfrecioElProfesor() {
		CuentaSueldo cuenta = new CuentaSueldo(0.0);
		cuenta.depositar(4000.0);

		Double saldo = cuenta.getSaldo();
		Double esperado = 4000.0;

		// saldo debe valer 4000.0
		assertEquals(saldo, esperado);

		cuenta.extraer(500.0);
		saldo = cuenta.getSaldo();
		esperado = 3500.0;

		// saldo debe valer 3500.0
		assertEquals(saldo, esperado);

		// la operación no debe poder realizarse y debe lanzar una excepción
		// (RuntimeException)
		Boolean montoExtraido = cuenta.extraer(4000.0);
		assertTrue(montoExtraido);

	}

	/*----------------- CUENTA SUELDO TEST'S -----------------*/

	@Test
	public void testQueLaCuentaTengaMasDineroDelQueSeRetira() {

		CuentaSueldo cuenta = new CuentaSueldo(2000.0);

		cuenta.setSaldo(4000.0);

		assertTrue(cuenta.extraer(3000.0));
	}

	@Test
	public void testQuePuedaDepositarCorrectamenteEnLaCuenta() {
		CuentaSueldo cuenta = new CuentaSueldo(4000.0);

		cuenta.depositar(2000.0);

		Double valorEsperado = 6000.0;
		Double valorObtenido = cuenta.getSaldo();

		assertEquals(valorEsperado, valorObtenido, 0.01);
	}

	/*----------------- CUENTA CORRIENTE TEST'S -----------------*/

	@Test
	public void testeaQueCompruebe() {

		CuentaCorriente cuenta = new CuentaCorriente(100.0);

		cuenta.extraer(200.0);

		Double valorEsperado = 105.0;
		Double valorObtenido = cuenta.getDeuda();

		assertEquals(valorEsperado, valorObtenido, 0.001);

	}

	/*----------------- CAJA DE AHORRO TEST'S -----------------*/

	@Test
	public void testQueDespuesDeCincoVecesQueSeExtraigaSeCobreSeisPesosDeMas() {
		CajaDeAhorro cuenta = new CajaDeAhorro(2000.0);

		assertTrue(cuenta.extraer(1000.0));

		Double valorEsperado = 1000.0;
		Double valorObtenido = cuenta.getSaldo();

		assertEquals(valorObtenido, valorEsperado, 0.01);
		
		CajaDeAhorro cuenta2 = new CajaDeAhorro(0.0);
		cuenta2.setSaldo(20000.0);

		cuenta2.extraer(2000.0); // 1 2000
		cuenta2.extraer(2000.0); // 2 2000
		cuenta2.extraer(2000.0); // 3 2000
		cuenta2.extraer(1000.0); // 4 1000
		cuenta2.extraer(1000.0); // 5 1000
		cuenta2.extraer(2000.0); // 6 2000 + 6

		Double valorEsperado2 = 9994.0;
		Double valorObtenido2 = cuenta2.getSaldo();

		assertEquals(valorEsperado2, valorObtenido2, 0.01);

	}

}
