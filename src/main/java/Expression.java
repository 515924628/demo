import org.wltea.expression.ExpressionEvaluator;

public class Expression {
	public static void main(String[] args) {
		Object result = ExpressionEvaluator.evaluate("1+2*3");
		System.out.println(result);
	}
}
