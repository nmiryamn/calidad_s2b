package pkg;

public class Empleado {

	public enum TipoEmpleado {
		VENDEDOR,
		ENCARGADO
	}

	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {

		float salarioBase;

		if (tipo == TipoEmpleado.VENDEDOR)
			salarioBase = 2000;
		else if (tipo == TipoEmpleado.ENCARGADO)
			salarioBase = 2500;
		else
			return -1;

		if (ventasMes >= 1500)	// Prima de 200€ si ventas >= 1500
			salarioBase += 200;
		else if (ventasMes >= 1000)	// Prima de 100€ si ventas >= 1000
			salarioBase += 100;

		if (horasExtra > 0)
			salarioBase += horasExtra * 30;

		return salarioBase;
	}

	public float calculoNominaNeta(float nominaBruta) {

		float retencion;

		if (nominaBruta >= 2500) // Retención de 18% a partir de 2500€
			retencion = 0.18f;
		else if (nominaBruta > 2100) // Entre 2500 y 2100€ retención de 15%
			retencion = 0.15f;
		else
			retencion = 0.0f;	// Nomina bruta < 2100 -> no hay retención

		return nominaBruta * (1 - retencion);
	}

}
