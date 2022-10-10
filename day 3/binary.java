import java.util.*;
import java.io.*;

public class binary {
	static class Count {
		int zero_ct;
		int one_ct;
		public String toString() {
			return "0: " + zero_ct + ", 1: " + one_ct;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Count[] histogram = new Count[12];
		for (int i = 0; i < 12; i++)
			histogram[i] = new Count();
		Scanner in = new Scanner (new File("input"));
		while (in.hasNextLine()) {
			char[] next_byte = in.nextLine().toCharArray();
			for (int i = 0; i < 12; i++)
				if (next_byte[i] == '0')
					histogram[i].zero_ct++;
				else
					histogram[i].one_ct++;
		}
		String gamma_str = "", epsilon_str = "";
		for (int i = 0; i < 12; i++) {
			if (histogram[i].zero_ct > histogram[i].one_ct) {
				gamma_str += "0";
				epsilon_str += "1";
			}
			else {
				gamma_str += "1";
				epsilon_str += "0";
			}
		}
		System.out.println(Arrays.toString(histogram));
		System.out.println("Gamma: " + gamma_str);
		System.out.println("Epsilon: " + epsilon_str);
		System.out.println(Integer.parseInt(gamma_str,2) * Integer.parseInt(epsilon_str, 2));
	}
}