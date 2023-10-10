package pkg;

public class Movimiento {

	public enum Signo {
		D, H
	};

	private double importe;
	private Signo signo;
	private String detalle;

	Movimiento(double i, Signo s, String d) {
		this.importe = i;
		this.signo = s;
		this.detalle = d;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Signo getSigno() {
		return signo;
	}

	public void setSigno(Signo signo) {
		this.signo = signo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
}
