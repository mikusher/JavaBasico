package cv.mikusher.cursojava.aula26;

public class TestarCarro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Carro van = new Carro();
		van.marca = "Fiat";
		van.modelo = "Ducato";
		van.capCombustivel = 100;
		van.consumoCombustivel = 0.2;

		System.out.println(van.marca);
		System.out.println(van.modelo);
		double autonomia = van.obterAutonomia();
		System.out.println("Autonomia do carro " + autonomia);
	}

}
