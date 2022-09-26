package ua.hillel.homeworks.homework15;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestRunner {
    public static void start(Class<?> testClass) {
        Object testObject = createNewInstance(testClass);
        Method[] declaredMethods = getDeclaredMethods(testClass);

        startBeforeMethods(testObject, declaredMethods);
        startTestMethods(testObject, declaredMethods);
        startAfterMethods(testObject, declaredMethods);
    }

    private static void startBeforeMethods(Object testObject, Method[] declaredMethods) {
        List<Method> beforeMethods = filterByAnnotation(declaredMethods, BeforeSuite.class);

        if (beforeMethods.size() > 1) {
            throw new RuntimeException("Class must contain only one @BeforeSuite method");
        }
        beforeMethods.forEach(method -> doMethodInvoke(method, testObject));
    }

    private static void startTestMethods(Object testObject, Method[] declaredMethods) {
        // не воспользовалась filterByAnnotation,
        // так как для sorted надо было бы снова использовать stream и toList, оно того не стоит

        List<Method> testMethods = Arrays.stream(declaredMethods)
                .filter(method -> method.isAnnotationPresent(Test.class))
                .sorted(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()))
                .toList();

        testMethods.forEach(method -> doMethodInvoke(method, testObject));
    }

    private static void startAfterMethods(Object testObject, Method[] declaredMethods) {
        List<Method> afterMethods = filterByAnnotation(declaredMethods, AfterSuite.class);

        if (afterMethods.size() > 1) {
            throw new RuntimeException("Class must contain only one @AfterSuite method");
        }
        afterMethods.forEach(method -> doMethodInvoke(method, testObject));
    }

    private static Object createNewInstance(Class<?> testClass) {
        try {
            return testClass.getConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException("Some mistake in creation of the new instance", e);
        }
    }

    private static Method[] getDeclaredMethods(Class<?> testClass) {
        return testClass.getDeclaredMethods();
    }

    private static List<Method> filterByAnnotation(Method[] declaredMethods, Class<? extends Annotation> annotationType) {
        return Arrays.stream(declaredMethods)
                .filter(method -> method.isAnnotationPresent(annotationType))
                .toList();
    }

    private static void doMethodInvoke(Method method, Object testObject) {
        method.setAccessible(true);
        try {
            method.invoke(testObject);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException("Some mistake in invocation of the method of the object", e);
        } finally {
            method.setAccessible(false);
        }
    }
}
