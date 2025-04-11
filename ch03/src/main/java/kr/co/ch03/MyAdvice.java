package kr.co.ch03;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAdvice {

    @Pointcut("execution(void kr.co.ch03.MyService.insert())")
    public void insertPointCut(){}

    @Pointcut("execution(void kr.co.ch03.MyService.select*(..))") //select로 시작하는 모든 메서드
    public void selectPointCut(){}

    @Before("insertPointCut() || selectPointCut()")
    public void beforeAdvice(){
        System.out.println("부가기능 - beforeAdvice()");
    }

    @After("insertPointCut() || selectPointCut()")
    public void afterAdvice(){
        System.out.println("부가기능 - afterAdvice()");
    }

    @AfterReturning("insertPointCut()")
    public void afterReturnAdvice(){
        System.out.println("부가기능 - afterReturnAdvice()");
    }

    @Around("insertPointCut()")
    public void aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("부가기능 - aroundAdvice(1)");
        pjp.proceed(); // 핵심기능 실행
        System.out.println("부가기능 - aroundAdvice(2)");
    }

    @AfterThrowing("selectPointCut()") // 예외 발생시 실행
    public void afterThrowAdvice(){
        System.out.println("부가기능 - afterThrowAdvice()");
    }

}
