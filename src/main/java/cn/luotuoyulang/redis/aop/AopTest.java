package cn.luotuoyulang.redis.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class AopTest {


    // 公用的切点，该类下所有方法
    @Pointcut("execution(* cn.luotuoyulang.redis.controller..*.*(..))")
    public void log() {
        log.info("调用 log() ");
    }

    // 使用log函数定义的 execution，不执行log()方法
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("调用 doBefore   ");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        log.info("获取 request");
        HttpServletRequest request = attributes.getRequest();
        log.info("获取 reponse");
        attributes.getResponse();
        log.info("获取 session");
        attributes.getRequest().getSession();
        log.info("获取 class:" + joinPoint.getSignature().getDeclaringTypeName().toString());
        log.info("获取 args:" + joinPoint.getArgs());
    }

    // 获取返回值
    @AfterReturning(pointcut = "log()", returning = "object")
    public void doAfterReturning(Object object) {
        log.info("获取返回值" + object.toString());
    }
}
