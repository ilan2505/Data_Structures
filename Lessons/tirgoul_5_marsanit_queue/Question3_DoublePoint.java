package tirgoul_5_marsanit_queue;


import java.util.Stack;

public class Question3_DoublePoint {
public static void main(String[] args) {
	double input = 1246.6421;
	boolean ans = Question3(input);
	System.out.println(ans);
}

private static boolean Question3(double input) {
	Stack<Character> s = new Stack<Character>();
	String inputString = input + "";
	int index = inputString.indexOf('.') + 1;
	for (int i = 0; inputString.charAt(i) != '.'; i++) {
		s.push(inputString.charAt(i));
	}
	for (int i = index; i < inputString.length(); i++) {
		if(s.pop() != inputString.charAt(i))
			return false;
	}
	return s.isEmpty();
}
}
