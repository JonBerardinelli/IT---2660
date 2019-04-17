
public class A3_Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack pancakes = new Stack(3);
		
		pancakes.peek();
		pancakes.showAll();
		pancakes.pop();
		
		Serving order1 = new Serving("Plain", "Small", "3");
		pancakes.modPush(order1);
		Serving order2 = new Serving("Chocolate Chip", "Medium", "1");
		pancakes.modPush(order2);
		Serving order3 = new Serving("Bluberry", "Large", "4");
		pancakes.modPush(order3);
		Serving order4 = new Serving("Strawberry", "Large", "2");
		pancakes.modPush(order4);

		pancakes.peek();
		pancakes.showAll();
		pancakes.pop();
		pancakes.showAll();
		

	}

}
