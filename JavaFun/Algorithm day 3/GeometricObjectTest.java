import java.util.ArrayList;
public class GeometricObjectTest {

	public static void main(String[] args) {
		GeometricObject recPoly = new Rectangle(50.69,30,"black",true);
		System.out.println(((Rectangle) recPoly).getArea());
		System.out.println(recPoly.isFilled());
		ArrayList<GeometricObject> myArray = new ArrayList<GeometricObject>();
		myArray.add(new Rectangle());
		myArray.add(new Rectangle());
		myArray.add(new Circle());
		myArray.add(new Circle());
		
		
	}

}
