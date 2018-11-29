import java.util.ArrayList;
import java.util.List;

class D {
	@Override
	public String toString() {
		return s;
	}

	protected String s;

	public D(String s) {
		this.s = s;
	}

	protected void men() {
		System.out.println(s);
	}

}

class E extends D {

	public E(String s) {
		super(s);
	}

}

class F extends E {
	public F(String s) {
		super(s);
	}

}

class G extends F {
	public G(String s) {
		super(s);
	}

}
class Canv {
	static List<List<? extends D>> history =
			new ArrayList<List<? extends D>>();
	void print(List <? extends D> c) {
		history.add(c);
		for (D b:c) {
			b.men();
		}
		
	}
}
public class AnotherTestGen {
	public static void main(String[] args) {
		List l1 = new ArrayList();
		l1.add(new F("fere"));
		l1.add(new G("fe12re"));
		l1.add(new E("f43534534e12re"));
		l1.add(new D("dddd"));
		// l1.add(new String("gregerg gregerg gregerg"));
		Canv v = new Canv();
		v.print(l1);
		System.out.println(v.history);
		
		
		
		
	}

}
