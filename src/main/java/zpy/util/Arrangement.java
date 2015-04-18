package zpy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Arrangement {

	public <E> void permutation(List<E> str, Consumer<List<E>> consumer) {
		arrange(str, new ArrayList<>(), consumer);
	}

	public <E> void permutation(List<E> str, int n, Consumer<List<E>> consumer) {
		arrange(str, new ArrayList<>(), 0, n, consumer);
	}


	private <E> void arrange(List<E> l, List<E> s, Consumer<List<E>> consumer) {
		if (s.size() == l.size()) {
			consumer.accept(s);
			return;
		}
		for (int i = 0; i <= s.size(); i++) {
			List<E> t1 = new ArrayList<>(s);
			t1.add(i, l.get(s.size()));
			arrange(l, t1, consumer);
		}
	}

	private <E> void arrange(List<E> str, List<E> s, int i, int n, Consumer<List<E>> consumer) {
		if (n == 0) {
			arrange(s, new ArrayList<>(), consumer);
			return;
		}
		for (int j = i; j <= str.size() - n; j++) {
			List<E> t = new ArrayList<>(s);
			t.add(str.get(j));
			arrange(str, t, j + 1, n - 1, consumer);
		}
	}

}
