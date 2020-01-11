package GuestAdministration;

import java.util.ArrayList;

public class GuestList {
	
	private final int availableSpots;
	private static ArrayList<Guest> guests;
	private static ArrayList<Guest> waitlist;
	private static int guestsNo;
	private static int waitlistNo;
	private static int subscribeNo;
	
	public GuestList(int availableSpots) {
		
		this.availableSpots = availableSpots;
		GuestList.guests = new ArrayList<Guest>(availableSpots);
		GuestList.waitlist = new ArrayList<Guest>();
		GuestList.guestsNo = 0;
		GuestList.subscribeNo = 0;
		GuestList.waitlistNo = 0;
		
	}
	
	public int available() {
		
		System.out.print("Numarul de locuri ramase: ");
		return this.availableSpots - GuestList.guestsNo;
		
	}

	public static int guests_no() {
		
		System.out.print("Numarul de participanti: ");
		return GuestList.guestsNo;
		
	}

	public static int waitlist_no() {
		
		System.out.print("Dimensiunea listei de asteptare: ");
		return GuestList.waitlistNo;
		
	}

	public static int subscribe_no() {
		
		System.out.print("Numarul total de persoane: ");
		return GuestList.subscribeNo;
	}

	public void help() {
		
		System.out.print("help - Afiseaza aceasta lista de comenzi"
				+ "\nadd - Adauga o noua persoana (inscriere)"
				+ "\ncheck - Verifica daca o persoana este inscrisa la eveniment"
				+"\nremove - Sterge o persoana existenta din lista"
				+"\nupdate - Actualizeaza detaliile unei persoane"
				+"\nguests - Lista de persoane care participa la eveniment"
				+"\nwaitlist - Persoanele din lista de asteptare"
				+"\navailable - Numarul de locuri libere"
				+"\nguests_no - Numarul de persoane care participa la eveniment"
				+"\nwaitlist_no - Numarul de persoane din lista de asteptare"
				+"\nsubscribe_no - Numarul total de persoane inscrise"
				+"\nsearch - Cauta toti invitatii conform sirului de caractere introdus"
				+"\nquit - Inchide aplicatia");
		
	}
	
	public void guests() {
		
		if(GuestList.guestsNo == 0) {
			System.out.println("Niciun participant inscris...");
		}
		else {
			for(int i = 0; i < GuestList.guestsNo; i++) {
				System.out.println((i+1) + GuestList.guests.get(i).toString());
			}
		}
		
	}
	
	public void waitlist() {
		
		if(GuestList.waitlistNo == 0) {
			System.out.println("Lista de asteptare este goala...");
		}
		else {
			for(int i = 0; i < GuestList.waitlistNo; i++) {
				System.out.println((i+1) + GuestList.waitlist.get(i).toString());
			}
		}
		
	}

	public int add(String lastName, String firstName, String email, String phoneNumber) {
		
		if(checkByName(lastName, firstName) >= 0  || checkByEmail(email) >= 0 || checkByPhone(phoneNumber) >= 0) {
			
			System.out.println("Persoana este deja inscrisa la eveniment!");
			return -1;
		}
		
		if(GuestList.guestsNo < this.availableSpots) {
			
			GuestList.guests.add(new Guest(lastName, firstName, email, phoneNumber));
			GuestList.subscribeNo++;
			GuestList.guestsNo++;
			System.out.println("[" + lastName + " " + firstName + "] Felicitari! Locul tau la eveniment este confirmat. Te asteptam!");
			return 0;
		
		}else {
			
			GuestList.waitlist.add(new Guest(lastName, firstName, email, phoneNumber));
			GuestList.subscribeNo++;
			GuestList.waitlistNo++;
			System.out.println("[" + lastName + " " + firstName + "] Te-ai inscris cu succes in lista de asteptare si ai primit numarul de ordine "+ GuestList.waitlistNo +". Te vom notifica daca un loc devine disponibil.");
			return GuestList.waitlistNo; 
			
		}
		
	}
		
	public int checkByName(String lastName, String firstName) {
		
		return (checkByLastName(lastName) == checkByFirstName(firstName)) ? checkByLastName(lastName) : -404;
		
	}
	
	public int checkByLastName(String lastName) {
		
		for(int i = 0; i < GuestList.guests.size(); i++) {
			
			if(GuestList.guests.get(i).containsLastName(lastName)) {

				return i;
			}
		}
		for(int i = 0; i < GuestList.waitlist.size(); i++) {
			
			if(GuestList.waitlist.get(i).containsLastName(lastName)){

				return i + this.availableSpots;
				
			}
		}
		return -404;
	}
	
	public int checkByFirstName(String firstName) {
		
		for(int i = 0; i < GuestList.guests.size(); i++) {
			
			if(GuestList.guests.get(i).containsFirstName(firstName)) {

				return i;
			}
		}
		for(int i = 0; i < GuestList.waitlist.size(); i++) {
			
			if(GuestList.waitlist.get(i).containsFirstName(firstName)){

				return i + this.availableSpots;
				
			}
		}
		return -404;
	}
	
	public int checkByEmail(String email) {
		
		for(int i = 0; i < GuestList.guests.size(); i++) {
			
			if(GuestList.guests.get(i).containsEmail(email)) {
			
				return i;
			}
		}
		
		for(int i = 0; i < GuestList.waitlist.size(); i++) {
			
			if(GuestList.waitlist.get(i).containsEmail(email)){

				return i + this.availableSpots;
				
			}
		}
		return -404;
		
	}
	
	public int checkByPhone(String phoneNumber) {
		
		for(int i = 0; i < GuestList.guests.size(); i++) {
		
			if(GuestList.guests.get(i).containsPhone(phoneNumber)) {
			
				return i;
			}
		}
		for(int i = 0; i < GuestList.waitlist.size(); i++) {
			
			if(GuestList.waitlist.get(i).containsPhone(phoneNumber)){

				return i + this.availableSpots;
				
			}
		}
		return -404;
		
	}
	
	public boolean removeByName(String lastName, String firstName) {
		
		if(checkByName(lastName, firstName) >= 0 && checkByName(lastName, firstName) < this.availableSpots) {
			GuestList.guests.remove(checkByName(lastName, firstName));
			GuestList.subscribeNo--;
			GuestList.guestsNo--;
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			if(GuestList.guestsNo < this.availableSpots && GuestList.waitlistNo > 0) {
				GuestList.guests.add(GuestList.waitlist.get(0));
				GuestList.guestsNo++;
				GuestList.waitlist.remove(0);
				GuestList.waitlistNo--;
			}
			return true;
		}
		else if(checkByName(lastName, firstName) >= this.availableSpots) {
			GuestList.waitlist.remove(checkByName(lastName, firstName) - this.availableSpots);
			GuestList.subscribeNo--;
			GuestList.waitlistNo--;
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			return true;
		}
		
		System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
		return false;
	}
	
	public boolean removeByEmail(String email) {
			
		if(checkByEmail(email) >= 0 && checkByEmail(email) < this.availableSpots) {
			GuestList.guests.remove(checkByEmail(email));
			GuestList.subscribeNo--;
			GuestList.guestsNo--;
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			if(GuestList.guestsNo < this.availableSpots && GuestList.waitlistNo > 0) {
				GuestList.guests.add(GuestList.waitlist.get(0));
				GuestList.guestsNo++;
				GuestList.waitlist.remove(0);
				GuestList.waitlistNo--;
			}
			return true;
		}
		else if(checkByEmail(email) > this.availableSpots) {
			GuestList.waitlist.remove(checkByEmail(email) - this.availableSpots);
			GuestList.subscribeNo--;
			GuestList.waitlistNo--;
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			return true;
		}
		
		System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
		return false;
	}

	public boolean removeByPhone(String phoneNumber) {
	
		if(checkByPhone(phoneNumber) >= 0 && checkByPhone(phoneNumber) < this.availableSpots) {
			GuestList.guests.remove(checkByPhone(phoneNumber));
			GuestList.subscribeNo--;
			GuestList.guestsNo--;
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			if(GuestList.guestsNo < this.availableSpots && GuestList.waitlistNo > 0) {
				GuestList.guests.add(GuestList.waitlist.get(0));
				GuestList.guestsNo++;
				GuestList.waitlist.remove(0);
				GuestList.waitlistNo--;
			}
			return true;
		}
		else if(checkByPhone(phoneNumber) > this.availableSpots) {
			GuestList.waitlist.remove(checkByPhone(phoneNumber) - this.availableSpots);
			GuestList.subscribeNo--;
			GuestList.waitlistNo--;
			System.out.println("Stergerea persoanei s-a realizat cu succes.");
			return true;
		}
		
		System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
		return false;
		}
	
	public void remove(int number, String str) {
				
		switch(number) {
			case 1:
				String[] fullName = str.split(" ");
				String lastName = fullName[0];
				String firstName = fullName[1];
				removeByName(lastName, firstName);
				break;
			case 2:
				removeByEmail(str);
				break;
			case 3:
				removeByPhone(str);
				break;
			default:
				System.out.println("Numar invalid, reincercati.");
				break;
			
		}
		
	}
	
	public int check(int number, String str) {
		
		switch(number) {
			case 1:
				String[] fullName = str.split(" ");
				String lastName = fullName[0];
				String firstName = fullName[1];
				if(checkByName(lastName, firstName) >= 0) {
					System.out.println("Persoana este deja inscrisa la eveniment!");
				}else {
					System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
				}
				return checkByName(lastName, firstName); //returns the index of Guest
			case 2:
				if(checkByEmail(str) >= 0) {
					System.out.println("Persoana este deja inscrisa la eveniment!");
				}else {
					System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
				}
				return checkByEmail(str);
			case 3:
				if(checkByPhone(str) >= 0) {
					System.out.println("Persoana este deja inscrisa la eveniment!");
				}else {
					System.out.println("Eroare: Persoana nu este inscrisa la eveniment.");
				}
				return checkByPhone(str);
			default:
				System.out.println("Numar invalid, reincercati.");
				return -404;
		}
		
		
	}
	
	public void update(int number, int index, String replace) {

		switch(number) {
			case 1:
				updateByLastName(index, replace);
				break;
			case 2:
				updateByFirstName(index, replace);
				break;
			case 3:
				updateByEmail(index, replace);
				break;
			case 4:
				updateByPhone(index, replace);
				break;
			default:
				System.out.println("Numar invalid, reincercati.");
				break;	
		}
		
	}
	
	public boolean updateByLastName(int index, String replace) {
		
		
		if(index >= 0 && index < this.availableSpots) {
			GuestList.guests.get(index).setLastName(replace);;
			return true;
		}
		else if(index >= this.availableSpots) {
			GuestList.waitlist.get(index - this.availableSpots).setLastName(replace);;
			return true;
		}
		
		return false;
		
	}
	
	public boolean updateByFirstName(int index, String replace) {
		
		
		if(index >= 0 && index < this.availableSpots) {
			GuestList.guests.get(index).setFirstName(replace);;
			return true;
		}
		else if(index >= this.availableSpots) {
			GuestList.waitlist.get(index - this.availableSpots).setFirstName(replace);;
			return true;
		}
		
		return false;
		
	}
	
	public boolean updateByEmail(int index, String replace ) {
		
		
		if(index >= 0 && index < this.availableSpots) {
			GuestList.guests.get(index).setEmail(replace);;
			return true;
		}
		else if(index >= this.availableSpots) {
			GuestList.waitlist.get(index - this.availableSpots).setEmail(replace);;
			return true;
		}
		
		return false;
	}
	
	public boolean updateByPhone(int index, String replace ) {
		
		
		if(index >= 0 && index < this.availableSpots) {
			GuestList.guests.get(index).setPhoneNumber(replace);;
			return true;
		}
		else if(index >= this.availableSpots) {
			GuestList.waitlist.get(index - this.availableSpots).setPhoneNumber(replace);;
			return true;
		}
		
		return false;
	}
}
