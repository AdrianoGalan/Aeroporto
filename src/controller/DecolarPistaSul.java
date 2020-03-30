package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class DecolarPistaSul extends Thread {

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

	public DecolarPistaSul(String aviao, Semaphore controle, Random num) {
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
		} finally {
			controle.release();
		}

		super.run();
	}

	private void decolar() {

		try {
			System.err.println(aviao + " Em MANOBRA na Pista sul");
			tempoManobra = num.nextInt(4000)+3000;
			sleep(tempoManobra);
			System.err.println(aviao + " TAXIANDO na Pista sul");
			tempoTaxiar = num.nextInt(5000)+5000;
			sleep(tempoManobra);
			System.err.println(aviao + " DECOLANDO pista sul");
			tempoDecolagem = num.nextInt(3000)+1000;
			sleep(tempoDecolagem);
			System.err.println(aviao + " se AFASTANDO pista sul");
			tempoAfastamento = num.nextInt(5000)+3000;
			sleep(tempoAfastamento);
			System.err.println("Pista Sul liberada\n");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
