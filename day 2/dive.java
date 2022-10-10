import java.util.*;
import java.io.*;

public class dive {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("dive.in"));
		int depth = 0, x = 0;
		while (in.hasNextLine()) {
			String tokens[] = in.nextLine().split(" "), op = tokens[0];
			int delta = Integer.parseInt(tokens[1]);
			switch (op) {
			case "forward":
				x += delta;
				break;
			case "up":
				depth -= delta;
				break;
			case "down":
				depth += delta;
				break;
			}
		}
		System.out.println(depth * x);
	}
}