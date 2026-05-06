package prep.day7;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class RunnerReflection {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Calculator cal = new Calculator();
		System.out.println(cal.add(10, 20));
		Class<?> clazz=Calculator.class;
		Field x=clazz.getDeclaredField("x");
		x.setAccessible(true);
		System.out.println(x.getInt(cal));
		Method addMethod=clazz.getMethod("add", int.class,int.class);
		int result=(int)addMethod.invoke(cal, 10,40);
		System.out.println(result);
		Method demoMethod = clazz.getMethod("demo");
		demoMethod.invoke(null);
	}

}
