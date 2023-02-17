package com.demo.metric;

import java.util.Objects;

public class MetricFrame {

    private String methodName;

    private String className;

    private Boolean isNativeMethod;

    private String fileName;

    private int lineNumber;

    private StackTraceElement[] stackTraceElements;


    public MetricFrame(String methodName, String className, Boolean isNativeMethod) {
        this.methodName = methodName;
        this.className = className;
        this.isNativeMethod = isNativeMethod;
    }

    public MetricFrame(String methodName, String className, Boolean isNativeMethod, String fileName, int lineNumber) {
        this.methodName = methodName;
        this.className = className;
        this.isNativeMethod = isNativeMethod;
        this.fileName = fileName;
        this.lineNumber = lineNumber;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }


    public Boolean getNativeMethod() {
        return isNativeMethod;
    }

    public void setNativeMethod(Boolean nativeMethod) {
        isNativeMethod = nativeMethod;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public StackTraceElement[] getStackTraceElements() {
        return stackTraceElements;
    }

    public void setStackTraceElements(StackTraceElement[] stackTraceElements) {
        this.stackTraceElements = stackTraceElements;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MetricFrame) {
            MetricFrame other = (MetricFrame) obj;
            if (Objects.equals(other.methodName, getMethodName())
                    && Objects.equals(other.className, getClassName())
                    && Objects.equals(other.fileName, getFileName())) {
                return true;
            }
        }

        return false;
    }
}
