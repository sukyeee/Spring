import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {

	public static void main(String[] args) throws Exception {
		// 내가 직접 MyReflection 클래스를 사용할 경우 
//		MyReflection mr = new MyReflection();
//		mr.aboutMe();
		
//		// Spring 이 MyReflection 클래스를 사용할 경우 - by String
//		String className = "MyReflection";
//		Class<?> myClass = Class.forName(className);
//		
//		// Reflection API
//		MyReflection mf = (MyReflection) myClass.getDeclaredConstructor().newInstance(); // 왼쪽에 선언된 애를 찾아감 
//		mf.aboutMe();
		
		// Spring 이 MyReflection 클래스를 사용할 경우 - by 외부 설정 파일 
		InputStream is = new FileInputStream("MyConfig.properties");
		Properties prop = new Properties();
		prop.load(is);
		
		String className = prop.getProperty("class.name");
		Class<?> myClass = Class.forName(className);
		
		// Reflection API
		MyReflection mf = (MyReflection) myClass.getDeclaredConstructor().newInstance(); // 왼쪽에 선언된 애를 찾아감 
		mf.aboutMe();
		
		
		// parameter & return
		Method m = myClass.getMethod("robot", int.class); // parameter
		String str = (String) m.invoke(mf, 80);
		System.out.println(str);
	}

}
