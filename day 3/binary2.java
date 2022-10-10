import java.util.*;
import java.io.*;
import java.util.stream.*;

public class binary2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner (new File("input"));
		ArrayList<char[]> bytes = new ArrayList<>();
		while (in.hasNextLine()) {
			char[] next_byte = in.nextLine().toCharArray();
			bytes.add(next_byte);
		}
		System.out.println(filter(0, (ArrayList<char[]>) bytes.clone()) * filter(1, (ArrayList<char[]>) bytes.clone()));
	}
	static int filter(int mode, ArrayList<char[]> options) {
		int index = 0;
		while (options.size() > 1) {
			int c0 = 0, c1 = 0;
			for (int i = 0; i < options.size(); i++)
				if (options.get(i)[index] == '0')
					c0++;
				else
					c1++;
			char criteria = mode == 1 ? ( c1 >= c0 ? '1' : '0' ) : ( c0 <= c1 ? '0' : '1' );
			for (int i = options.size()-1; i >= 0; i--)
				if (options.get(i)[index] != criteria)
					options.remove(i);
			index++;
		}
		System.out.println((mode == 1 ? "Oxygen" : "CO2") + ": " + String.valueOf(options.get(0)) + " - " + Integer.parseInt(String.valueOf(options.get(0)), 2));
		return Integer.parseInt(String.valueOf(options.get(0)), 2);
	}
}