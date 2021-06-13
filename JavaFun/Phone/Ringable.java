
public interface Ringable {
	public default String ring() {
		return "The phone is ringing!!";
	}
	
	public default String unlock() {
		return "The phone is unlocked!";
	}
}
