package ar.edu.unlam.pb2.tp2;

public class CajaDeAhorro extends CuentaSueldo {
	private Double cobroAdd = 6.0;
	private Integer contador = 0;

	public CajaDeAhorro(Double saldo) {
		super(saldo);
	}

	public Boolean extraer(Double cantidad) {
		contador++;

		if (contador < 6 && cantidad < super.saldo) {
			super.saldo -= cantidad;
			return true;
		} else {
			if (cantidad > super.saldo) {
				super.saldo = 0.0;
				return false;
			} else {
				super.saldo = super.saldo - cantidad - cobroAdd;
			}
			return true;
		}
	}

	public Integer getContador() {
		return contador;
	}

	public void depositar(Double cantidad) {
		this.saldo = this.saldo + cantidad;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		contador = 0;
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CajaDeAhorro other = (CajaDeAhorro) obj;
		if (saldo == null) {
			if (other.saldo != null)
				return false;
		} else if (!saldo.equals(other.saldo))
			return false;
		return true;
	}

}
