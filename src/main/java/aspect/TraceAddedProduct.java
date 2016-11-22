package aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class TraceAddedProduct {

	@After("execution(* controller.ProductController.AddProduct(..))")
	public void traceaftermethod(JoinPoint joinpoint) {
		// What we want to do
		Object[] obj = joinpoint.getArgs();
		System.out.println("after execution of method " + joinpoint.getSignature().getName());
	}
}
