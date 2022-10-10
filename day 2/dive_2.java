import java.util.*;
import java.io.*;

public class dive_2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("dive.in"));
		int depth = 0, x = 0, aim = 0;
		while (in.hasNextLine()) {
			String tokens[] = in.nextLine().split(" "), op = tokens[0];
			int delta = Integer.parseInt(tokens[1]);
			switch (op) {
			case "forward":
				x += delta;
				depth += delta * aim;
				break;
			case "up":
				aim -= delta;
				break;
			case "down":
				aim += delta;
				break;
			}
		}
		System.out.println(depth * x);
	}
}