package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		Integer number;
		String holder;
		Double balance, withDrawLimit;
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			holder = sc.nextLine();
			System.out.print("Initial balance: ");
			balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			withDrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withDrawLimit);
			
			System.out.print("Enter amount for withdraw: ");
			account.withDraw(sc.nextDouble());
			System.out.println("New balance: "+account.getBalance());
		}
		catch (InputMismatchException e) {
			System.out.println("Valor inválido");
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		finally {
			System.out.println("Final do programa");
			sc.close();
		}
			
	}

}
