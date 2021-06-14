

public class Author implements Comparable<Author> {
	String firstName;
	String lastName;
	String bookName;
	
	public Author(String firstName,String lastName,String bookName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.bookName = bookName;
	}

	@Override
	public int compareTo(Author o) {
		int result = o.firstName.compareTo(firstName);
		if(result ==0 ) {
			return 0;
		}
		else if(result < 0 ) {
			return -1;
		}
		else return 1;
		
	}
}