package com.blaze.job;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IJob {

    Class configType() default Void.class;
    
    /**
     * job name
     * @return
     */
    String name();
    
    /**
     * job group
     * @return
     */
    String group();
}
