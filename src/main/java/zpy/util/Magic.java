package zpy.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class Magic<T> implements InvocationHandler {
	private List<T> target;

	public List<T> bind(List<T> target) {
		this.target = target;
		return (List<T>) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.getName().equals("get")) {
			Integer i = (Integer) args[0];
			if (i < 0) {
				args[0] = target.size() + i;
			}
		}
		return method.invoke(target, args);
	}

	public static <E> List<E> negativeIndex(List<E> list) {
		return new Magic<E>().bind(list);
	}
}
