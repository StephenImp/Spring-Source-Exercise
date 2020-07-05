package com.cn.source.learn.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * 这尼玛讲的些什么鬼哦
 *
 * java Bean 元信息
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        // ???
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);

        Stream.of(beanInfo.getPropertyDescriptors())
                .forEach(propertyDescriptor -> {
                    //System.out::println(propertyDescriptor); //todo why?
                    //System.out.println(propertyDescriptor);

                    //propertyDescriptor 允许添加属性编辑器  - PropertyEditor
                    //GUI -> text(String) ->PropertyType
                    //name -> String
                    //age -> Integer
                    Class<?> propertyType = propertyDescriptor.getPropertyType();
                    String name = propertyDescriptor.getName();
                    if ("age".equals(name)){//为age字段/属性添加  PropertyEditor

                        //String -> Integer
                        //Integer.valueOf("");
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                        //propertyDescriptor.createPropertyEditor()
                    }

                });
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{
        public void setAsText(String text) throws java.lang.IllegalArgumentException {
            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }

}
