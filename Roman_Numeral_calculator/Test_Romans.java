import java.util.*;

public class Test_Romans {
	
	public static void generate_random_number() {

		Random R = new Random();
		Number_input in = new Number_input();
		String roman_random = "";
		int random = 0;
		System.out.println("Testing now");
		String test_string = "";
		for(int i=0; i<100; i++) {
			random = R.nextInt(4000);
			roman_random = in.makeArrayList(random);
			test_string = "Random number: "+random+"  Roman number:  "+roman_random;
			System.out.println(i +") "+test_string);
		}
		System.out.println("Testing complete");
	}
}
