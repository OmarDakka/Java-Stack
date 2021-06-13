import java.util.HashMap;
import java.util.Set;
public class Songs{
	public static void main(String[] args) {
		HashMap<String, String> songMap = new HashMap<String, String>();
		songMap.put("Choker","Twenty One Pilots");
		songMap.put("Kingslayer","Bring Me The Horizon");
		songMap.put("Teardrops","Bring Me The Horizon");
		songMap.put("Touch off","UVERworld");

		String singer = songMap.get("Choker");
		System.out.println("The Singer of Choker is " + singer);

		Set<String> songs = songMap.keySet();
		for(String sing : songs) {
			System.out.println(sing);
			System.out.println(songMap.get(sing));
		} 
	}
}