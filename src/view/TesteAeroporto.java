package view;

import java.util.Random;
import java.util.concurrent.Semaphore;


import controller.DecolarPistaNorte;
import controller.DecolarPistaSul;

public class TesteAeroporto {

	public static void main(String[] args) {

		Semaphore controleSul = new Semaphore(1);
		Semaphore controleNorte = new Semaphore(1);
		Random num = new Random();

		for (int i = 1; i < 13; i++) {
			
			int pista = num.nextInt(2);
			
			switch (pista) {
			case 0:
				DecolarPistaSul ps = new DecolarPistaSul("aviao " + i, controleSul, num);
				ps.start();
				break;
			case 1:
				DecolarPistaNorte pn = new DecolarPistaNorte("aviao " + i, controleNorte, num);
				pn.start();
				break;

			default:
				break;
			}
			
			

		}

	}

}
