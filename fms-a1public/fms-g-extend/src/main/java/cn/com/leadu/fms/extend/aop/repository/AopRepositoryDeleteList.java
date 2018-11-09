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
 * @ClassName: AopRepositoryDeleteList
 * @Description: 数据集合删除util
 * @date 2018/2/24
 */
@Component
@Aspect
public class AopRepositoryDeleteList {

    @Pointcut(FrameworkConstants.AOP_REPOSITORY_DELETE_LIST)
    public void aspect(){}

    @Around("aspect()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        Object [] args = joinPoint.getArgs();
        if(ArrayUtils.isNotNullAndLengthNotZero(args))
                AopRepositoryUtil.delete(args[1]);
        Object result = joinPoint.proceed();
        return result;
    }

}
