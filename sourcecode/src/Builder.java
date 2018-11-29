import java.lang.reflect.Method;

class Pizza {
	int size;
	String meat;
	String cheese;
	String toppings;
	
}
class AB {
	void met1(String l){
		System.out.println("In the method met1 "+l);
	}
}
public class Builder  {
	public static void main(String[] args) throws Exception{
		AB a = new AB();
		Method m = a.getClass().getDeclaredMethod("met1",new Class[]{java.lang.String.class});
		m.invoke(a,"gfregregerg");
	}

}
