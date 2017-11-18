package com.blaze.common;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;

public class CustomAnnotationBeanNameGenerator  extends AnnotationBeanNameGenerator {  
  
    @Override  
    protected String buildDefaultBeanName(BeanDefinition definition) {  
        return definition.getBeanClassName();
    }
}
