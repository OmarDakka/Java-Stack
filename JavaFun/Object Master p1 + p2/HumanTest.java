
public class HumanTest {
	public static void main(String[] args) {
	Human Josh = new Human();
	Human John = new Human();
	John.attack(Josh);
	System.out.println(Josh.health);
	
	Ninja Naruto = new Ninja();
	Naruto.runAway();
	System.out.println(Naruto.health);
	
	Samurai Jack = new Samurai();
	Samurai Bayatneh = new Samurai();
	Samurai Omar = new Samurai();
	System.out.println(Samurai.howMany());
	}
}
