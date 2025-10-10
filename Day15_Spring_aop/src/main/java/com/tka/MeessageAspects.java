package com.tka;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MeessageAspects {

//	@Before("execution (public void myRecharge())")
//	public void BeforeRecharge() {
//		System.err.println("UR pack is Expirirng Soon plz Recharge...!");
//	}

//	@After("execution (* com.tka.Recharge.*(..))")
//	public void afterRecharge() {
//		System.err.println("Recharge Succcessfully ...! Enjoy UR DATA pack...!");
//	}

	@Around("execution (* com.tka.Recharge.*(..))")
	public void aroundRecharge(ProceedingJoinPoint p) {

		System.err.println("UR pack is Expirirng Soon plz Recharge...!");
		try {
			p.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.err.println("Recharge Succcessfully ...! Enjoy UR DATA pack...!");
	}

}
