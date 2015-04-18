package zpy.calc;


import java.util.List;
import java.util.Stack;

/**
 * Created by zpy on 2014/9/11.
 * 表达式计算器类
 */
public class Calc {
	/**
	 * 计算结果
	 *
	 * @param formula 表达式字符串
	 * @return 结果
	 */
	public String calculator(String formula) throws Exception {
		return calc(create(formula));
	}

	private String calc(List<String> list) throws Exception {
		Stack<Number> numbers = new Stack<Number>();
		for (int i = 0; i != list.size(); i++) {
			try {
				Number n = Double.valueOf(list.get(i));
				numbers.push(n);
			} catch (NumberFormatException e) {
				Operator o = Operator.getOperator(list.get(i));
				List<Number> l = numbers.subList(numbers.size() - o.getCount(), numbers.size());
				Number n = o.exec(l);
				l.clear();
				numbers.push(n);
			}
		}
		if (numbers.size() != 1) {
			throw new Exception();
		}
		return numbers.pop().toString();
	}

	private boolean isNumber(int ch) {
		return "1234567890.".indexOf(ch) != -1;
	}

	private Stack<String> create(String formula) throws Exception {
		Stack<String> stack = new Stack<String>();
		Stack<String> fuhao = new Stack<String>();
		for (int i = 0; i < formula.length(); i++) {
			if (isNumber(formula.charAt(i))) {
				int j = i;
				i++;
				while ((i < formula.length()) && isNumber(formula.charAt(i))) {
					i++;
				}
				stack.push(formula.substring(j, i));
				i--;
			} else if (formula.charAt(i) == '(') {
				fuhao.push("(");
			} else if (formula.charAt(i) == ')') {
				while (!fuhao.empty() && !fuhao.peek().equals("(")){
					stack.push(fuhao.pop());
				}
				if (!fuhao.empty() && fuhao.peek().equals("(")){
					fuhao.pop();
				}
			} else {
				int j = i;
				String str;
				if (formula.charAt(i) == '-' && (i == 0 || "1234567890.)".indexOf(formula.charAt(i - 1)) == -1)){
					//如果‘-’是负号
					str = "-";
					stack.push("0");
				} else {
					while (!isNumber(formula.charAt(i))) {
						i++;
					}
					str = formula.substring(j,i);
					while (Operator.getOperator(str) == null) {
						i--;
						if (j == i){
							throw new Exception();
						}
						str = formula.substring(j, i);
					}
					i--;
					if (!str.equals(Operator.getOperator(str).getName())){
						throw new Exception();
					}
				}

				Operator o = Operator.getOperator(str);

				//符号栈为空，或栈顶为左括号，或栈顶操作符优先级低于当前操作符时
				if (fuhao.empty() || fuhao.peek().equals("(") || Operator.getOperator(fuhao.peek()).getPriority() < o.getPriority()){
					fuhao.push(str);
				} else {
					while (!fuhao.empty() && Operator.getOperator(fuhao.peek()).getPriority() >= o.getPriority()){
						stack.push(fuhao.pop());
					}
					fuhao.push(str);
				}
			}
		}
		while (!fuhao.empty()){
			stack.push(fuhao.pop());
		}
		return stack;
	}
}
