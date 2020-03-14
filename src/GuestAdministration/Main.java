package GuestAdministration;

import java.util.Scanner;

public class Main {
	
	private static Scanner sc = new Scanner(System.in);
	private static GuestList list1;
	
	private static void add() {
		sc.nextLine();
		list1.add(getLastName(), getFirstName(), getEmail(), getPhoneNumber());
		
	}
	
	public static void check() {
		
		System.out.println("Alege modul de autentificare, tastand:\r\n" + 
				"\t\"1\" - Nume si prenume\r\n" + 
				"\t\"2\" - Email\r\n" + 
				"\t\"3\" - Numar de telefon (format \"+40733386463\")");
		
		int number = getNumber3();
		
		switch(number) {
			case 1:
				list1.check(1, getFullName());
				break;
			case 2:
				list1.check(2, getEmail());
				break;
			case 3:
				list1.check(3, getPhoneNumber());
				break;	
		}
	}
	
	public static void remove() {
		
		System.out.println("Se sterge o persoana existenta din lista...");
		System.out.println("Alege modul de autentificare, tastand:\r\n" + 
				"\t\"1\" - Nume si prenume\r\n" + 
				"\t\"2\" - Email\r\n" + 
				"\t\"3\" - Numar de telefon (format \"+40733386463\")");
		
		int number = getNumber3();
		
		switch(number) {
			case 1:
				list1.remove(1, getFullName());
				break;
			case 2:
				list1.remove(2, getEmail());
				break;
			case 3:
				list1.remove(3, getPhoneNumber());
				break;
			
		}
		
	}
	
	public static void update() {
		
		System.out.println("Se actualizeaza detaliile unei persoane...");
		System.out.println("Alege modul de autentificare, tastand:\r\n" + 
				"\t\"1\" - Nume si prenume\r\n" + 
				"\t\"2\" - Email\r\n" + 
				"\t\"3\" - Numar de telefon (format \"+40733386463\")");
		
		int number = getNumber3();
		int guestIndex = -404;
		
		switch(number) {
			case 1:
				guestIndex = list1.check(1, getFullName());
				break;
			case 2:
				guestIndex = list1.check(2, getEmail());
				break;
			case 3:
				guestIndex = list1.check(3, getPhoneNumber());
				break;
			
		}
		
		if(guestIndex < 0) {
			return;
		}
		
		System.out.println("Alege campul de actualizat, tastand:\r\n" + 
				"\t\"1\" - Nume\r\n" + 
				"\t\"2\" - Prenume\r\n" + 
				"\t\"3\" - Email\r\n" + 
				"\t\"4\" - Numar de telefon (format \"+40733386463\")");
		
		number = getNumber4();
		
		switch(number) {
			case 1:
				list1.update(1, guestIndex, getLastName());
				break;
			case 2:
				list1.update(2, guestIndex, getFirstName());
				break;
			case 3:
				list1.update(3, guestIndex, getEmail());
				break;
			case 4:
				list1.update(4, guestIndex, getPhoneNumber());
				break;
		}
		
	}
	
	private static int getNumber3() {
		int number;
		
		do {
            while (!sc.hasNextInt()) {
            	
                String input = sc.next();
                
                System.out.print(input + " nu este un numar valid.\n");
            }
            
            number = sc.nextInt();
            sc.nextLine();
            
        } while (number < 1 && number > 3);
		
		return number;
	}
	
	private static int getNumber4() {
		
		int number;
		
		do {
            while (!sc.hasNextInt()) {
            	
                String input = sc.next();
                
                System.out.print(input + " nu este un numar valid.\n");
            }
            
            number = sc.nextInt();
            sc.nextLine();
            
        } while (number < 1 && number > 4);
		
		return number;
	}
	
	private static String getLastName() {
		System.out.println("Introduceti numele de familie:");
		return sc.nextLine();
	}
	 
	private static String getFirstName() {
	    System.out.println("Introduceti prenumele:");
	    return sc.nextLine();
	}
	 
	private static String getEmail() {
	    System.out.println("Introduceti email:");
	    return sc.nextLine();
	}
	 
	private static String getPhoneNumber() {
		
	    System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
	    return sc.nextLine();
	}
	  
	public static String getFullName() {
		String lastName = getLastName();
		String firstName = getFirstName();
		return lastName + " " + firstName;
		  
	}
	  
	
	public static void main(String[] args) {
		
		
		
		System.out.print("Bun venit! Introduceti numarul de locuri disponibile: ");
		int numberOfAvailableSpots;
		do {
            while (!sc.hasNextInt()) {
            	
                String input = sc.next();
                
                System.out.print(input + " nu este un numar valid.\n");
            }
            
            numberOfAvailableSpots = sc.nextInt();
            sc.nextLine();
            
        } while (numberOfAvailableSpots < 1);
		
		
		
		list1 = new GuestList(numberOfAvailableSpots);
		
		String command = "";
		
		while(!command.equals("quit")) {
			System.out.println("\nAsteapta comanda: (help - Afiseaza lista de comenzi)");
			
			switch(sc.next()) {
			
				case "help":
					list1.help();
					break;
					
				case "add":
					add();
					break;
					
				case "check":
					check();
					break;
					
				case "remove":
					remove();
					break;
					
				case "guests":
					list1.guests();
					break;
					
				case "waitlist":
					list1.waitlist();
					break;
					
				case "available":
					System.out.println(list1.available());
					break;
					
				case "guests_no":
					System.out.println(list1.guests_no());
					break;
					
				case "waitlist_no":
					System.out.println(list1.waitlist_no());
					break;
					
				case "subscribe_no":
					System.out.println(list1.subscribe_no());
					break;
					
				case "update":
					update();
					break;
					
				case "quit":
					System.out.println("Aplicatia se inchide...");
					command = "quit";
					break;
				default:
					System.out.println("Comanda introdusa nu este valida.");
					System.out.println("Incercati inca o data.");
					break;
			}
	
		}
		sc.close();
	}

}
