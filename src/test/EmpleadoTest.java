package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pkg.Empleado;
import pkg.Empleado.TipoEmpleado;

class EmpleadoTest {

	Empleado emp;

	@BeforeEach
	void setUp() throws Exception {
		emp = new Empleado();
	}

	// ----------------------------TESTS CALCULO NOMINA BRUTA----------------------------------

	//	Cálculo nómina bruta VENDEDOR con valores : 999, 1000, 1499, 1500
	@Test
	void vendedorVentas999() {
		assertEquals(2000, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 999, 0), 0);
	}

	@Test
	void vendedorVentas1000() {
		assertEquals(2100, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1000, 0), 0);
	}

	@Test
	void vendedorVentas1499() {
		assertEquals(2100, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1499, 0), 0);
	}

	@Test
	void vendedorVentas1500() {
		assertEquals(2200, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 1500, 0), 0);
	}

	//	Cálculo nómina bruta ENCARGADO con valores : 999, 1000, 1499, 1500
	@Test
	void encargadoVentas999() {
		assertEquals(2500, emp.calculoNominaBruta(TipoEmpleado.ENCARGADO, 999, 0), 0);
	}

	@Test
	void encargadoVentas1000() {
		assertEquals(2600, emp.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1000, 0), 0);
	}

	@Test
	void encargadoVentas1499() {
		assertEquals(2600, emp.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1499, 0), 0);
	}

	@Test
	void encargadoVentas1500() {
		assertEquals(2700, emp.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1500, 0), 0);
	}

	// Cálculo nómina bruta con VENTAS NEGATIVAS
	@Test
	void ventasNegativas() {
		assertEquals(2000, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, -1, 0), 0);
	}

	// Cálculo nómina bruta con HORAS EXTRA : -1, 0, 1, 10
	@Test
	void horasExtraNegativas() {
		assertEquals(2000, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0, -1), 0);
	}

	@Test
	void horasExtraCero() {
		assertEquals(2000, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0, 0), 0);
	}

	@Test
	void horasExtraUna() {
		assertEquals(2030, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0, 1), 0);
	}
	
	@Test
	void horasExtraDiez() {
		assertEquals(2300, emp.calculoNominaBruta(TipoEmpleado.VENDEDOR, 0, 10), 0);
	}

	// Cálculo nómina bruta con PRIMA y HORAS EXTRA
	@Test
	void primaYHorasExtra() {
		assertEquals(3000, emp.calculoNominaBruta(TipoEmpleado.ENCARGADO, 1500, 10), 0);
	}

	// Cálculo nómina bruta con EMPLEADO NO VÁLIDO
	@Test
	void tipoNulo() {
		assertEquals(-1, emp.calculoNominaBruta(null, 1000, 0), 0);
	}

	// ----------------------------TESTS CALCULO NOMINA NETA----------------------------------
	
	//	Cálculo nómina neta con valores : 2099, 2100, 2101, 2499, 2500, 2501
	//  Margen de error de 0.01 porque al multiplicar por la retención salen decimales, es decir, si se diferencian en 0.01 o menos lo da por correcto
	@Test
	void neta2099() {
		assertEquals(2099, emp.calculoNominaNeta(2099), 0.01);
	}

	@Test
	void neta2100() {
		assertEquals(2100, emp.calculoNominaNeta(2100), 0.01);
	}

	@Test
	void neta2101() {
		assertEquals(1785.85, emp.calculoNominaNeta(2101), 0.01);
	}

	@Test
	void neta2499() {
		assertEquals(2124.15, emp.calculoNominaNeta(2499), 0.01);
	}

	@Test
	void neta2500() {
		assertEquals(2050, emp.calculoNominaNeta(2500), 0.01);
	}

	@Test
	void neta2501() {
		assertEquals(2050.82, emp.calculoNominaNeta(2501), 0.01);
	}

}
