package projet4;

import java.util.Scanner;

public class Nova {

	public static void main(String[] args) {
		
		Calculator calculator = new Calculator();
		calculator.newOperation();
		int index = calculator.verifyOperation();
		if (index == -1) {	
			System.out.println("le resultat obtenu est: " +calculator.calculate() );
			
	   }
		else {
			if (index < calculator.getOperation().length() - 4 && index >= 3) {
				System.out.println("Erreur ligne" + (index + 2) + ":" + calculator.getOperation().substring(index - 2, index + 5));
			} 
			else
				System.out.println("erreur colonne  " + (index + 1));
		}

	}
}