package pkg;

public class Cuenta {

	private Double saldo;
	private String numero, titular;

	public Cuenta(String string, String string2, double i) {
		this.numero = string;
		this.titular = string2;
		this.saldo = i;
	}


	public void ingreso(int i) {
		// TODO Auto-generated method stub
		this.saldo = this.saldo+i;
	}


	public void reintegro(int i) {
		// TODO Auto-generated method stub
		this.saldo = this.saldo-i;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

}
