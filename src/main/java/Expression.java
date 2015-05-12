import org.wltea.expression.ExpressionEvaluator;

import java.util.Scanner;

public class Expression {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(ExpressionEvaluator.evaluate(scanner.next()));
	}
}
