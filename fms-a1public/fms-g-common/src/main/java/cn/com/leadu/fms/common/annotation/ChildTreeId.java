package cn.com.leadu.fms.common.annotation;

import java.lang.annotation.*;

/**
 * @author qiaomengnan
 * @ClassName: ParentTreeId
 * @Description: 属性下级节点id
 * @date 2018/3/29
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ChildTreeId {

    String value() default  "";

}
