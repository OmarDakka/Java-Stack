
public class HumanTest {
	public static void main(String[] args) {
	Human Josh = new Human();
	Human John = new Human();
	John.attack(Josh);
	System.out.println(Josh.health);
	}
}
