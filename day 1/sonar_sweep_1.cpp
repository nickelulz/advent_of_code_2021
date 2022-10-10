#include <iostream>
#include <fstream>
#include <climits>
using namespace std;

int main(void) {
	fstream in;
	in.open("sonar_sweep", ios::in);
	string line;
	int last[3], cur[3], count = 0;
	while (getline(in, line)) {
		int cur = stoi(line);
		if (cur > last)
			count++;
		last = cur;
	}
	cout << count << endl;
}