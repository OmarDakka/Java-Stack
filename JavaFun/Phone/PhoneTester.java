
public class PhoneTester {

	public static void main(String[] args) {
		Galaxy Note8 = new Galaxy("Note 8", 85,"Jawwal","Tooo tooo rooooooo!!");
		IPhone iPhone12 = new IPhone("12",69,"Ooredoo","Ba Dum Tssssss!!");
		
		Note8.displayInfo();
		System.out.println(Note8.ring());
		System.out.println(Note8.unlock());
		
		iPhone12.displayInfo();
		System.out.println(iPhone12.ring());
		System.out.println(iPhone12.unlock());

	}

}
