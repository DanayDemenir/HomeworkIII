package hw03;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class TestRunner {

    public static void runner(Class<?> cls) {
        int errores = 0;
        int allTests = 0;
        for ( Method method : cls.getDeclaredMethods ( ) ) {
            try {
                allTests += runBefore (cls, method);
            } catch (Exception e) {
                System.out.println (e.getMessage ());
                errores += 1;
                allTests +=1;
            }
        }
        for ( Method method : cls.getDeclaredMethods ( ) ) {
            try {
                allTests += runTest (cls, method);
            } catch (Exception e) {
                System.out.println (e.getMessage ());
                errores += 1;
                allTests +=1;
            }
        }
        for ( Method method : cls.getDeclaredMethods ( ) ) {
            try {
                allTests += runAfter (cls, method);
            } catch (Exception e) {
                System.out.println (e.getMessage ());
                errores += 1;
                allTests +=1;
            }
        }
        System.out.println ((allTests - errores) + " successful tests");
    }

    private static int runTest(Class<?> cls, Method method) {
        Annotation afterTest = method.getAnnotation (After.class);
        Annotation test = method.getAnnotation (Test.class);
        Annotation beforeTest = method.getAnnotation (Before.class);
        if ((test != null) && (beforeTest == null) && (afterTest == null)) {
            try {
                method.invoke (cls
                        .getDeclaredConstructor ( )
                        .newInstance ( ));
            } catch (Exception ex) {
                throw new RuntimeException (method.getName ( ) + " cause error " + ex.getCause ( ));
            }
            return 1;
        }
        return 0;
    }


    private static int runBefore(Class<?> cls, Method method) {
        Annotation beforeTest = method.getAnnotation (Before.class);
        Annotation test = method.getAnnotation (Test.class);
        if ((beforeTest != null) && (test == null)) {
            try {
                method.invoke (cls
                        .getDeclaredConstructor ( )
                        .newInstance ( ));
            } catch (Exception ex) {
                throw new RuntimeException (method.getName ( ) + " cause error " + ex.getCause ( ));
            }
            return 1;
        }
        return 0;
    }

    private static int runAfter(Class<?> cls, Method method) {
        Annotation afterTest = method.getAnnotation (After.class);
        Annotation test = method.getAnnotation (Test.class);
        if ((afterTest != null) && (test == null)) {
            try {
                method.invoke (cls
                        .getDeclaredConstructor ( )
                        .newInstance ( ));
            } catch (Exception ex) {
                throw new RuntimeException (method.getName ( ) + " cause error " + ex.getCause ( ));
            }
            return 1;
        }
        return 0;
    }
}
