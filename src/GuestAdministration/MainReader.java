package GuestAdministration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainReader{
	
	
	private static GuestList list1;
	
	private static void add(Scanner sc) {

		list1.add(getLastName(sc), getFirstName(sc), getEmail(sc), getPhoneNumber(sc));
		
	}
	
	public static void check(Scanner sc) {
		
		System.out.println("Alege modul de autentificare, tastand:\r\n" + 
				"\t\"1\" - Nume si prenume\r\n" + 
				"\t\"2\" - Email\r\n" + 
				"\t\"3\" - Numar de telefon (format \"+40733386463\")");
		
		int number = getNumber3(sc);
		
		switch(number) {
			case 1:
				list1.check(1, getFullName(sc));
				break;
			case 2:
				list1.check(2, getEmail(sc));
				break;
			case 3:
				list1.check(3, getPhoneNumber(sc));
				break;	
		}
	}
	
	public static void remove(Scanner sc) {
		
		System.out.println("Se sterge o persoana existenta din lista...");
		System.out.println("Alege modul de autentificare, tastand:\r\n" + 
				"\t\"1\" - Nume si prenume\r\n" + 
				"\t\"2\" - Email\r\n" + 
				"\t\"3\" - Numar de telefon (format \"+40733386463\")");
		
		int number = getNumber3(sc);
		
		switch(number) {
			case 1:
				list1.remove(1, getFullName(sc));
				break;
			case 2:
				list1.remove(2, getEmail(sc));
				break;
			case 3:
				list1.remove(3, getPhoneNumber(sc));
				break;
			
		}
		
	}
	
	public static void update(Scanner sc) {
		
		System.out.println("Se actualizeaza detaliile unei persoane...");
		System.out.println("Alege modul de autentificare, tastand:\r\n" + 
				"\t\"1\" - Nume si prenume\r\n" + 
				"\t\"2\" - Email\r\n" + 
				"\t\"3\" - Numar de telefon (format \"+40733386463\")");
		
		int number = getNumber3(sc);
		int guestIndex = -404;
		
		switch(number) {
			case 1:
				guestIndex = list1.check(1, getFullName(sc));
				break;
			case 2:
				guestIndex = list1.check(2, getEmail(sc));
				break;
			case 3:
				guestIndex = list1.check(3, getPhoneNumber(sc));
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
		
		number = getNumber4(sc);
		
		switch(number) {
			case 1:
				list1.update(1, guestIndex, getLastName(sc));
				break;
			case 2:
				list1.update(2, guestIndex, getFirstName(sc));
				break;
			case 3:
				list1.update(3, guestIndex, getEmail(sc));
				break;
			case 4:
				list1.update(4, guestIndex, getPhoneNumber(sc));
				break;
		}
		
	}
	
	private static int getNumber(Scanner sc) {
		
		int number;
		
		do {
	        while (!sc.hasNextInt()) {
	        	
	            String input = sc.next();
	            
	            System.out.print(input + " nu este un numar valid.\n");
	        }
	        
	        number = sc.nextInt();
	        sc.nextLine();
	        
	    } while (number < 1);
		
		return number;
	}
	
	private static int getNumber3(Scanner sc) {
		
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
	
	private static int getNumber4(Scanner sc) {
		
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

	private static String getLastName(Scanner sc) {
		System.out.println("Introduceti numele de familie:");
		return sc.nextLine();
	}
	 
	private static String getFirstName(Scanner sc) {
	    System.out.println("Introduceti prenumele:");
	    return sc.nextLine();
	}
	 
	private static String getEmail(Scanner sc) {
	    System.out.println("Introduceti email:");
	    return sc.nextLine();
	}
	 
	private static String getPhoneNumber(Scanner sc) {
		
	    System.out.println("Introduceti numar de telefon (format \"+40733386463\"):");
	    return sc.nextLine();
	}
	  
	public static String getFullName(Scanner sc) {
		String lastName = getLastName(sc);
		String firstName = getFirstName(sc);
		return lastName + " " + firstName;
		  
	}
	  
	
	public static void main(String[] args) throws IOException{
		
		try(Scanner sc = new Scanner(new FileReader("input.txt"))) {
		    
			while(sc.hasNextLine()) {
		      
				System.out.print("Bun venit! Introduceti numarul de locuri disponibile: ");
				
				int numberOfAvailableSpots = getNumber(sc);
				
				list1 = new GuestList(numberOfAvailableSpots);
				
				String command = "";
				
				while(!command.equals("quit")) {
					System.out.println("\nAsteapta comanda: (help - Afiseaza lista de comenzi)");
					
					switch(sc.nextLine()) {
					
						case "help":
							list1.help();
							break;
							
						case "add":
							add(sc);
							break;
							
						case "check":
							check(sc);
							break;
							
						case "remove":
							remove(sc);
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
							update(sc);
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
		    }
		 }
	}

}
