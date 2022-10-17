import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String love();
	String hate();
}

// @MyAnnotation => 약속, 규약, 규칙
// Contaier vs Component
// Spring에는 Annotation 을 많이 활용, xml, Bean java Class 도 많이 사용하지만 