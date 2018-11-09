package cn.com.leadu.fms.extend.aop.repository;

import cn.com.leadu.fms.common.constant.FrameworkConstants;
import cn.com.leadu.fms.common.util.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author qiaomengnan
 * @ClassName: AopRepositoryInsert
 * @Description: 数据新增aop
 * @date 2018/2/23
 */
@Component
@Aspect
public class AopRepositoryInsert {

    @Pointcut(FrameworkConstants.AOP_REPOSITORY_INSERT)
    public void aspect(){}

    @Around("aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        Object [] args = joinPoint.getArgs();
        if(ArrayUtils.isNotNullAndLengthNotZero(args))
            for(Object arg : args)
                AopRepositoryUtil.insert(arg);
        Object result = joinPoint.proceed();
        return result;
    }

}
