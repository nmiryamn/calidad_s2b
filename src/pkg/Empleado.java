package pkg;

import java.util.Iterator;

public class Empleado {
	
	public enum TipoEmpleado {
		VENDEDOR,
		ENCARGADO
	}
	
	// Vendedor, encargado u otro
	// Ventasmes <1000, 1000 - 1500, >1500, Negativo
	// horasextra: si / no
	
	float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) { 
		
		int salarioBase = 0;
		
		if(tipo == TipoEmpleado.VENDEDOR) 
			salarioBase = 2000;
		else if(tipo == TipoEmpleado.ENCARGADO) 
			salarioBase = 2500;
		else
			return -1;
		
		if(ventasMes >= 1000) 
			salarioBase += 100;
		else if(ventasMes >= 1500)
			salarioBase += 200;
		
		if(horasExtra > 0) salarioBase += (horasExtra*30);
		
		return salarioBase;
	}
	
	
	float calculoNominaNeta(float nominaBruta) {
		
		float retencion = 0;
		
		if(nominaBruta > 2500) 
				retencion = 0.18f;
		else if(nominaBruta > 2100)
			retencion = 0.15f;	
		else 
			retencion = 0.0f;
		
		return nominaBruta * (1-retencion);
	}
	
}
