public class Animal {
		public String type;
		public Animal(){
			type = "animal";
			System.out.println("I am an animal");		
		}

		public Animal(String type){
			this.type = type;
			System.out.println("Type: " + type);
		}

		public static void display(){
			System.out.println("Here is an animal class");
		}

	}
