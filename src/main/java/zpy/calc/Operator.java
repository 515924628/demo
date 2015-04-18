package zpy.calc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by zpy on 2014/9/12.
 * 操作符类
 */
public abstract class Operator {

	static {
		map = new HashMap<String, Operator>();
		add(new Addition());
		add(new Subtract());
		add(new Multiply());
		add(new Division());
		add(new ChengFang());
	}

	public static final int PRIORITY1 = 1; //加法，减法的优先级
	public static final int PRIORITY2 = 2; //乘法，除法的优先级
	public static final int PRIORITY3 = 3; //乘方的优先级
	public static final int PRIORITY4 = 4; //函数的优先级

	public abstract Number exec(List<Number> numbers) throws Exception;

	public static Operator getOperator(String str) {
		return map.get(str);
	}

	public int getPriority() {
		return priority;
	}

	public int getCount() {
		return count;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "name:" + this.name + ",priority:" + this.priority + ",count:" + this.count;
	}


	protected void setPriority(int priority) {
		this.priority = priority;
	}

	protected void setCount(int count) {
		this.count = count;
	}

	protected void setName(String name) {
		this.name = name;
	}



	private static void add(Operator o) {
		map.put(o.name, o);
	}


	private static Map<String, Operator> map;
	private int priority;//操作符优先级
	private int count;//操作符需要的操作数个数
	private String name;//操作符名称
}
