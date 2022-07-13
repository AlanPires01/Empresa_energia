
public final class Relatorio {
	private static Relatorio instancia;
	private Relatorio() {
	}
	public static Relatorio getInstancia() {
		
		if(instancia == null) {
			instancia = new Relatorio();
		}
		return instancia;
	}
	
	
}
