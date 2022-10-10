import java.util.*;
import java.io.*;

class Point {
	int r, c, value;
	Point(int r, int c, int value) {
		this.r = r;
		this.c = c;
		this.value = value;
	}
}

class BingoCard {
	HashSet<HashSet<Point>> grid;
	HashSet<Point> read = null;

	BingoCard(int[][] matrix) {
		int size = matrix.length;
		grid = new HashSet<HashSet<Point>>(size);
		for (int r = 0; r < size; r++) {
			HashSet<Point> row = new HashSet<>();
			for (int c = 0; c < size; c++)
				row.add(new Point(r, c, matrix[r][c]));
			grid.add(row);
		}
		for (int c = 0; c < size; c++) {
			HashSet<Point> col = new HashSet<>();
			for (int r = 0; r < size; r++)
				col.add(new Point(r, c, matrix[r][c]));
			grid.add(col);
		}
		HashSet<Point> diag = new HashSet<>();
		for (int rc = 0; rc < size; rc++) {
			diag.add(new Point(rc, rc, matrix[rc][rc]));
		}
		grid.add(diag);
		HashSet<Point> rev_diag = new HashSet<>();
		for (int r = 0; r < size; r++)
			rev_diag.add(new Point(r, size-r, matrix[r][size-1-r]));
	}

	static ArrayList<Integer> values_only(HashSet<Point> set) {
		ArrayList<Integer> values = new ArrayList<Integer>();
		for (Point p: set)
			values.add(p.value);
		return values;
	}

	int total() {
		int total = 0;
		for (HashSet<Point> row: grid)
			for (Point p: row)
				if (!read.contains(p)) {
					total += p.value;
					read.add(p);
				}
		return total;
	}

	boolean check_winner(ArrayList<Integer> called) {
		for (HashSet<Point> e: grid)
			if (called.containsAll(values_only(e))) {
				read = e;
				return true;
			}
		return false;
	}
}

public class giant_squid {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input"));
		int[] call_order = Arrays.stream(in.nextLine().split(",")).filter(e -> e.length() > 0).mapToInt(Integer::valueOf).toArray();
		ArrayList<BingoCard> bingo_cards = new ArrayList<>();
		while (in.hasNextLine()) {
			in.nextLine();
			int[][] input_mat = new int[5][5];
			for (int i = 0; i < 5; i++)
				input_mat[i] = Arrays.stream(in.nextLine().split(" +")).mapToInt(Integer::valueOf).toArray();
			bingo_cards.add(new BingoCard(input_mat));
		}
		ArrayList<Integer> called = new ArrayList<>();
		BingoCard winner = null;
		for (int i = 0; i < call_order.length && winner == null; i++) {
			called.add(call_order[i]);
			if (i >= 5) {
				for (BingoCard b: bingo_cards)
					if (b.check_winner(called)) {
						winner = b;
						break;
					}
			}
		}
		System.out.println(winner.total() * called.get(called.size()-1));
	}
}