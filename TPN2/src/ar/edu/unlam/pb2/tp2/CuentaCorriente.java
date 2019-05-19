package ar.edu.unlam.pb2.tp2;

public class CuentaCorriente extends CuentaSueldo {

	private Double deuda;

	public CuentaCorriente(Double saldo) {
		super(saldo);
	}

	public Boolean extraer(Double cantidad) {
		Double porcentaje = 0.05;
		Double positivo = -1.0;
		if (cantidad > super.saldo) {
			super.saldo = super.saldo - cantidad;
			porcentaje = super.saldo * porcentaje;
			this.deuda = (super.saldo + porcentaje) * positivo;
			return true;
		} else {
			super.saldo = super.saldo - cantidad;
			return true;
		}
	}

	public Double getDeuda() {
		return deuda;
	}

}
