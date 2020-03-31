package model;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DecolarPistaNorte extends Thread {

	// 3 a 7 segundos
	private int tempoManobra;
	// 5 a 10 segundo
	private int tempoTaxiar;
	// 1 a 4 segundos
	private int tempoDecolagem;
	// 3 a 8 segundos
	private int tempoAfastamento;

	private Random num;
	private String aviao;
	private Semaphore controle;

	public DecolarPistaNorte(String aviao, Semaphore controle, Random num) {
		super();
		this.aviao = aviao;
		this.controle = controle;
		this.num = num;

	}

	@Override
	public void run() {
		try {
			controle.acquire();
			decolar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			controle.release();
		}
		
		super.run();
	}

	private void decolar() {

		try {

			System.out.println(aviao + " Em MANOBRA na Pista norte");
			tempoManobra = num.nextInt(11000)+3000;
			sleep(tempoManobra);
			System.out.println(aviao + " TAXIANDO na Pista norte");
			tempoTaxiar = num.nextInt(16000)+5000;
			sleep(tempoManobra);
			System.out.println(aviao + " DECOLANDO pista Norte");
			tempoDecolagem = num.nextInt(5000)+1000;
			sleep(tempoDecolagem);
			System.out.println(aviao + " se AFASTANDO pista Norte");
			tempoAfastamento = num.nextInt(9000)+3000;
			sleep(tempoAfastamento);
			System.out.println("Pista Norte liberada\n");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
