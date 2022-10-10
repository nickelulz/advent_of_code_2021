import java.util.*;
import java.io.*;

public class sonar_sweep_2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("sonar_sweep.dat"));
		LinkedList<Integer> windows = new LinkedList<Integer>(); // queue
		int last_group_total = 0, count = 0;
		while (in.hasNextInt()) {
			System.out.println(windows + " " + last_group_total + " " + count);
			int next = in.nextInt();
			if (windows.size() == 3) {
				int total = windows.get(0) + windows.get(1) + windows.get(2);
				if (total > last_group_total)
					count++;
				last_group_total = total;
			}
			if (!windows.isEmpty() && windows.size() == 3)
				windows.remove();
			windows.add(next);
		}
		System.out.println(count);
	}
}