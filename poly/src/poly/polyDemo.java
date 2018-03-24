package poly;

class Parent{
	public int a =20;
	public void sing() {
		System.out.println("Parent:sing() .......");
	}
	
	public void singWrap() {
		System.out.println("singWrap()");
		sing();
	}
}

class Child extends Parent{
	public int a =30;
	public void sing() {
		super.a = 50;
		System.out.println("Child:sing() %%%%%%%%%%");
	}
	
	public void childSing() {
		System.out.println("Child:childSing");
	}
}

public class polyDemo {

	public static void main(String[] args) {
		Parent p = new Child();
		
		p.sing();
		System.out.println("p.a:" + p.a);
		
		p.singWrap();
		
		((Child)p).childSing();
		
		/*Parent p2 = new Parent();
		
		p2.sing();
		System.out.println("p2.a:" + p2.a);
		
		p2.singWrap();*/
		
		
	

	}

}
