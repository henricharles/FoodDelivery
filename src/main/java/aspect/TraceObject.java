package aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.ui.Model;

import domain.Category;

// When it will be applied
//           Where it will applied
	public class TraceObject{
	@Before("execution(public String controller.CategoryController.addCategoryy(..))")
	public void tracebeforemethod(JoinPoint joinpoint){
	// What we want to do
		Object[] args=joinpoint.getArgs();
		Category category=(Category)args[0];
		
		System.out.println("before execution of method "+joinpoint.getSignature().getName()+"\n"+category.getName());
	}
	// When it will be applied
	//                  Where it will applied
	@After("execution(public String controller.CategoryController.addCategoryy(..))")
	public void traceaftermethod(JoinPoint joinpoint) {
	// What we want to do
		Object[] args=joinpoint.getArgs();
		Category category=(Category)args[0];
	System.out.println("after execution of method "+joinpoint.getSignature().getName());
	}
}