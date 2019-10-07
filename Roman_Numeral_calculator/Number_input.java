import java.util.*;
/**
 * 
 */

/**
 * @author RICHARD SEACOME
 *
 */
public class Number_input implements RomanNumeralGenerator {

	/* (non-Javadoc)
	 * @see RomanNumeralGenerator#generate(int)
	 */
	// Generate method to handle menu and send number to arraylist generator method..
	
	@Override
	public String generate(int number) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		int choice = 0;
		String roman_numb = "";

		do {
			try {
			System.out.println("Please type 1 to start the Roman numeral generator, 2 to test, 3 to exit");
			choice = input.nextInt();
			if(choice == 2) {
				Test_Romans.generate_random_number();
			}
			else if(choice == 3) {
				System.out.println("Goodbye and thank you for using Roman Numeral generator.");
				break;
			}
			else {
					System.out.println("Please enter a number between 1 and 3999");
					number = input.nextInt();
				}
				if((3999 >= number) && (number >= 1) && choice == 1) {
					roman_numb = makeArrayList(number).toString();
				System.out.println("Number = "+number + ", Roman number = " + roman_numb);
				}
				else {
					System.out.println("You must enter a number between 1 and 3999.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Please only enter integers, no other characters.");
				input.next();
				
			}
				} while (choice != 3);
		input.close();
		return roman_numb;
	}
	
	//method to convert number to an array of digits and call roman number convertor method.
	public static String makeArrayList(int number) {
		ArrayList digit_array_list = new ArrayList();
		String roman_add = "";
		String ones = "";
		String tens = "";
		String hundreds = "";
		String thousands = "";
		do {
			digit_array_list.add(number % 10);
			number = number/10;
		}while(number != 0);
		int num_array_size = digit_array_list.size();

		for(int i=0; i <= num_array_size-1; i++) {

			switch (i) {
			case 0: ones = getRomans((Integer)digit_array_list.get(i), "I", "V", "IX");
					roman_add = ones.toString();
					continue;
			case 1: tens = getRomans((Integer)digit_array_list.get(i), "X", "L", "XC");
					roman_add = tens.toString() + ones.toString();
					continue;
			case 2: hundreds = getRomans((Integer)digit_array_list.get(i), "C", "D", "CM");
					roman_add = hundreds.toString() + tens.toString() + ones.toString();
					continue;
			case 3: thousands = getRomans((Integer)digit_array_list.get(i), "M", "", "");
					roman_add = thousands.toString() + hundreds.toString() + tens.toString() + ones.toString();
					break;
			}
		}
		return roman_add;
	}
	
	//method to convert numbers in array list to roman numerals
	public static String getRomans(int array_numbers, String factorten, String factorfive, String factornine) {
		
		float number_check = (float)array_numbers/5;
		String roman_digit = "";
		
		if(number_check == 1) {
			roman_digit = factorfive;
		}
		else if((number_check < 1) && (number_check > 0)) {
			roman_digit = getMultiplier(array_numbers, factorten, factornine, factorfive);
		}
		else if((number_check > 1) && (number_check < 2)) {
			roman_digit = getMultiplier(array_numbers, factorten, factornine, factorfive);
		}
		return roman_digit;
	}
	
	// Method to multiply factorten and check for nines or fours.
	public static String getMultiplier(int arr_numbers, String factorA, String factorB, String factorC) {
		StringBuilder build = new StringBuilder();
		String multiplied_string = "";
		if(arr_numbers == 9) {
			multiplied_string = factorB;
		}
		else if(arr_numbers == 4) {
			multiplied_string = factorA + factorC;
		}
		else {
			if(arr_numbers <= 3) {
				for(int i=1; i<=arr_numbers; i++) {
					build.append(factorA);
			}
				multiplied_string = build.toString();
			}
			else {
				for(int i=1; i<=(arr_numbers % 5); i++) {
					build.append(factorA);
			}
			multiplied_string = factorC+build.toString();
			}
		}
		return multiplied_string;
	}

	//main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Number_input Romans = new Number_input();
		int number = 0;
		Romans.generate(number);
		
	}
}
