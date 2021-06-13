public class Samurai extends Human {
	public static int counter = 0;
	
	public Samurai(){
		this.health = 200;
		counter++;
	}
	
	public void deathBlow(Human x) {
		x.health = 0;
		this.health = health/2;
	}
	
	public void meditate() {
		this.health += health/2;
	}

	public static int howMany() {
		return counter;
	}	
	
	
	
}
