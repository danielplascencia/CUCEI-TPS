import java.util.*;

public class Automata {

	int cont;
	boolean aceptado;
	static char[] car;

	public static void main(String[] automata){
		Automata aut = new Automata();
		String cadena = "bbaabababababc";
		car = cadena.toCharArray();
		aut.inicio();
		if (aut.aceptado)
			System.out.println("Cadena valida");
		else
			System.out.println("Cadena no valida");
	}

	public void inicio(){
		aceptado = false;
		cont = 0;
		q0();
	}

	public void q0(){
		System.out.println("Estado actual: q0");
		if (cont < car.length){
			if (car[cont] == 'a'){
				cont++;
				q0();
			}
			else if (car[cont] == 'b'){
				cont++;
				q1();
			}
			else if (car[cont] != 'a' || car[cont] != 'b')
				qError();
		}
	}

	public void q1(){
		System.out.println("Estado actual: q1");
		if (cont < car.length){
			if (car[cont] == 'a'){
				cont++;
				q1();
			}
			else if (car[cont] == 'b'){
				cont++;
				q2();
			}
			else if (car[cont] != 'a' || car[cont] != 'b')
				qError();
		}
	}

	public void q2(){
		System.out.println("Estado actual: q2");
		if (cont < car.length){
			if (car[cont] == 'a'){
				cont++;
				q2();
			}
			else if (car[cont] == 'b'){
				cont++;
				q3();
			}
			else if (car[cont] != 'a' || car[cont] != 'b')
				qError();
		}
	}

	public void q3(){
		System.out.println("Estado actual: q3");
		aceptado = true;
		if (cont < car.length){
			if (car[cont] == 'a'){
				cont++;
				q3();
			}
			else if (car[cont] == 'b'){
				cont++;
				qError();
			}
			else if (car[cont] != 'a' || car[cont] != 'b')
				qError();
		}
	}

	public void qError(){
		System.out.println("Error");
		aceptado = false;
		return;
	}
}