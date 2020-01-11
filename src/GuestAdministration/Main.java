package GuestAdministration;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Bun venit! Introduceti numarul de locuri disponibile: ");
		int numberOfAvailableSpots;
		do {
            while (!sc.hasNextInt()) {
            	
                String input = sc.next();
                
                System.out.print(input + " nu este un numar valid.\n");
            }
            
            numberOfAvailableSpots = sc.nextInt();
            
        } while (numberOfAvailableSpots > 1);
		
		
		
		GuestList list1 = new GuestList(numberOfAvailableSpots);
		
		String command = "";
		
		while(!command.equals("quit")) {
			System.out.println("\nAsteapta comanda: (help - Afiseaza lista de comenzi)");
			
			switch(sc.next()) {
			
				case "help":
					list1.help();
					break;
					
				case "add":
					System.out.println("Introduceti numele de familie:");
					String lastName = sc.next();
					System.out.println("Introduceti prenumele:");
					String firstName = sc.next();
					System.out.println("Introduceti email:");
					String email = sc.next();
					System.out.println("Introduceti numar de telefon (format „+40733386463“):");
					String phoneNumber = sc.next();
					list1.add(lastName, firstName, email, phoneNumber);
					break;
					
				case "check":
					
					System.out.println("Alege modul de autentificare, tastand:\r\n" + 
							"\t\"1\" - Nume si prenume\r\n" + 
							"\t\"2\" - Email\r\n" + 
							"\t\"3\" - Numar de telefon (format \"+40733386463\")");
					
					int number;
					
					do {
			            while (!sc.hasNextInt()) {
			            	
			                String input = sc.next();
			                
			                System.out.print(input + " nu este un numar valid.\n");
			            }
			            
			            number = sc.nextInt();
			            
			        } while (number < 1 && number > 3);
					
					switch(number) {
						case 1:
							System.out.println("Introduceti numele de familie:");
							lastName = sc.next();
							System.out.println("Introduceti prenumele:");
							firstName = sc.next();
							String fullName = lastName + " " + firstName;
							list1.check(1, fullName);
							break;
						case 2:
							System.out.println("Introduceti email:");
							email = sc.next();
							list1.check(2, email);
							break;
						case 3:
							System.out.println("Introduceti numar de telefon (format „+40733386463“):");
							phoneNumber = sc.next();
							list1.check(3, phoneNumber);
							break;
						
					}
					break;
					
				case "remove":
					
					System.out.println("Se sterge o persoana existenta din lista...");
					System.out.println("Alege modul de autentificare, tastand:\r\n" + 
							"\t\"1\" - Nume si prenume\r\n" + 
							"\t\"2\" - Email\r\n" + 
							"\t\"3\" - Numar de telefon (format \"+40733386463\")");
					do {
			            while (!sc.hasNextInt()) {
			            	
			                String input = sc.next();
			                
			                System.out.print(input + " nu este un numar valid.\n");
			            }
			            
			            number = sc.nextInt();
			            
			        } while (number < 1 && number > 3);
					
					switch(number) {
						case 1:
							System.out.println("Introduceti numele de familie:");
							lastName = sc.next();
							System.out.println("Introduceti prenumele:");
							firstName = sc.next();
							String fullName = lastName + " " + firstName;
							list1.remove(1, fullName);
							break;
						case 2:
							System.out.println("Introduceti email:");
							email = sc.next();
							list1.remove(2, email);
							break;
						case 3:
							System.out.println("Introduceti numar de telefon (format „+40733386463“):");
							phoneNumber = sc.next();
							list1.remove(3, phoneNumber);
							break;
						
					}
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
					System.out.println(GuestList.guests_no());
					break;
					
				case "waitlist_no":
					System.out.println(GuestList.waitlist_no());
					break;
					
				case "subscribe_no":
					System.out.println(GuestList.subscribe_no());
					break;
					
				case "update":
					System.out.println("Se actualizeaza detaliile unei persoane...");
					System.out.println("Alege modul de autentificare, tastand:\r\n" + 
							"\t\"1\" - Nume si prenume\r\n" + 
							"\t\"2\" - Email\r\n" + 
							"\t\"3\" - Numar de telefon (format \"+40733386463\")");
					
					do {
			            while (!sc.hasNextInt()) {
			            	
			                String input = sc.next();
			                
			                System.out.print(input + " nu este un numar valid.\n");
			            }
			            
			            number = sc.nextInt();
			            
			        } while (number < 1 && number > 3);
					
					int guestIndex = -404;
					
					switch(number) {
						case 1:
							System.out.println("Introduceti numele de familie:");
							lastName = sc.next();
							System.out.println("Introduceti prenumele:");
							firstName = sc.next();
							String fullName = lastName + " " + firstName;
							guestIndex = list1.check(1, fullName);
							break;
						case 2:
							System.out.println("Introduceti email:");
							email = sc.next();
							guestIndex = list1.check(2, email);
							break;
						case 3:
							System.out.println("Introduceti numar de telefon (format „+40733386463“):");
							phoneNumber = sc.next();
							guestIndex = list1.check(3, phoneNumber);
							break;
						
					}
					
					if(guestIndex < 0) {
						break;
					}
					
					System.out.println("Alege campul de actualizat, tastand:\r\n" + 
							"\t\"1\" - Nume\r\n" + 
							"\t\"2\" - Prenume\r\n" + 
							"\t\"3\" - Email\r\n" + 
							"\t\"4\" - Numar de telefon (format \"+40733386463\")");
					
					do {
			            while (!sc.hasNextInt()) {
			            	
			                String input = sc.next();
			                
			                System.out.print(input + " nu este un numar valid.\n");
			            }
			            
			            number = sc.nextInt();
			            
			        } while (number < 1 && number > 4);
					
					switch(number) {
						case 1:
							System.out.println("Introduceti numele de familie:");
							lastName = sc.next();
							list1.update(1, guestIndex, lastName);
							break;
						case 2:
							System.out.println("Introduceti prenumele:");
							firstName = sc.next();
							list1.update(2, guestIndex, firstName);
							break;
						case 3:
							System.out.println("Introduceti email:");
							email = sc.next();
							list1.update(3, guestIndex, email);
							break;
						case 4:
							System.out.println("Introduceti numar de telefon (format „+40733386463“):");
							phoneNumber = sc.next();
							list1.update(4, guestIndex, phoneNumber);
							break;
					}
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
