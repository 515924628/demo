package zpy.calc;

import java.util.List;

/**
 * Created by zpy on 2014/9/24.
 */
public class Addition extends Operator{

	protected Addition(){
		this.setName("+");
		this.setCount(2);
		this.setPriority(Operator.PRIORITY1);
	}

	@Override
	public Number exec(List<Number> numbers) throws Exception {
		if (numbers.size() != 2){
			throw new Exception();
		}
		double num1 = numbers.get(0).doubleValue();
		double num2 = numbers.get(1).doubleValue();
		return num1 + num2;
	}
}
