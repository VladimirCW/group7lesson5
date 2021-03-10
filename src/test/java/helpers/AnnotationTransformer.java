package test.java.helpers;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Locale;

public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {
        iTestAnnotation.setRetryAnalyzer(RetryAnalyzer.class);
        if(!System.getProperty("dp").toLowerCase().equals("empty")) {
            iTestAnnotation.setDataProviderClass(DataProviders.class);
            iTestAnnotation.setDataProvider(System.getProperty("dp").toLowerCase());
        }
    }
}
