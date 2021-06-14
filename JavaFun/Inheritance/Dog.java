public class Dog extends Animal{
	String type;
	public Dog(){
		super("Animal");
		type = "mammal";
		System.out.println("I am a dog");
	}

	public static void display(){
			System.out.println("Here is a Dog class");
		}


	public void printMessage(){
		display();
		super.display();
	}

	public void printType(){
		System.out.println(this.type);
		System.out.println(super.type);
	}
}