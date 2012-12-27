package com.term.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * bean property 之间的复制
 * 
 * @author 李国江
 * @date 2009-2-23
 */
public class BeanCopyUtil {

	/**
	 * bean property 之间的复制,必须属性和名字相同才能复制
	 * 
	 * @param source
	 * @param target
	 */
	public static void copyProperties(Object target, Object source) {
		if (source == null || target == null) {
			return;
		}
		try {
			// 获取目标类的属性信息
			BeanInfo targetbean = Introspector.getBeanInfo(target.getClass());
			PropertyDescriptor[] targetPropertyDescriptors = targetbean
					.getPropertyDescriptors();
			// 获取源目标类的属性信息
			BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass());
			PropertyDescriptor[] sourcePropertyDescriptors = sourceBean
					.getPropertyDescriptors();
			// 对每个目标类的属性查找set方法，并进行处理
			for (int i = 0; i < targetPropertyDescriptors.length; i++) {
				PropertyDescriptor targetPro = targetPropertyDescriptors[i];
				Method targetMethod = targetPro.getWriteMethod();
				// 当目标类的属性具有set方法时，查找源类中是否有相同属性的get方法
				if (targetMethod != null) {
					for (int j = 0; j < sourcePropertyDescriptors.length; j++) {
						PropertyDescriptor sourcePro = sourcePropertyDescriptors[j];
						Method sourceMethod = sourcePropertyDescriptors[j]
								.getReadMethod();//
						// 匹配,属性名,类型相同后再copy,不区分大小写
						if (sourceMethod != null
								&& sourcePro.getName().toUpperCase().equals(
										targetPro.getName().toUpperCase())
								&& sourcePro.getPropertyType().equals(
										targetPro.getPropertyType())) {
							// 如果方法不可访问(get方法是私有的或不可达),则抛出SecurityException
							if (!Modifier.isPublic(sourceMethod
									.getDeclaringClass().getModifiers())) {
								sourceMethod.setAccessible(true);
							}
							// 获取对应属性get所得到的值
							Object value = sourceMethod.invoke(source,
									new Object[0]);
							if (!Modifier.isPublic(targetMethod
									.getDeclaringClass().getModifiers())) {
								targetMethod.setAccessible(true);
							}
							// System.out.println(sourcePro.getName() + " | "
							// + sourcePro.getPropertyType() + " | "
							// + value);
							// 调用目标类对应属性的set方法对该属性进行填充
							targetMethod.invoke((Object) target,
									new Object[] { value });
							break;
						}
					}
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	@Deprecated
	public static void CopyBeanToBean(Object source, Object target) {
		try {
			Method[] method1 = source.getClass().getMethods();
			Method[] method2 = target.getClass().getMethods();
			String methodName1;
			String methodFix1;
			String methodName2;
			String methodFix2;
			for (int i = 0; i < method1.length; i++) {
				methodName1 = method1[i].getName();
				methodFix1 = methodName1.substring(3, methodName1.length());
				if (methodName1.startsWith("get")) {
					for (int j = 0; j < method2.length; j++) {
						methodName2 = method2[j].getName();
						methodFix2 = methodName2.substring(3, methodName2
								.length());
						if (methodName2.startsWith("set")) {
							if (methodFix2.equals(methodFix1)) {
								Object[] objs1 = new Object[0];
								Object[] objs2 = new Object[1];
								// 激活obj1的相应的get的方法，objs1数组存放调用该方法的参数,此例中没有参数，该数组的长度为0
								objs2[0] = method1[i].invoke(source, objs1);
								// 激活obj2的相应的set的方法，objs2数组存放调用该方法的参数
								method2[j].invoke(target, objs2);
								continue;
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
