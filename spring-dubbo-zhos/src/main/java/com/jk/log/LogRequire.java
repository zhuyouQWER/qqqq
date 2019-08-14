package com.jk.log;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;



@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface LogRequire {
	
	/**
     * 操作模块
     */
     String operationModel() default "";
    /**
     * 操作功能
     */
     String operationFunction()default "";
 
    /**
     * 操作说明
     */
     String operationExplain()default "";

}
