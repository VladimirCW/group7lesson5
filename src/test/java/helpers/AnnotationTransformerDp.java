package test.java.helpers;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformerDp implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        if (method.getName().contains("parametrizedMethod")) {
            iTestAnnotation.setDataProvider(System.getProperty("dp"));
            iTestAnnotation.setDataProviderClass(DataProviders.class);
        }
    }
}
