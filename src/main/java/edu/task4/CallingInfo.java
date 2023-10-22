package edu.task4;

public record CallingInfo(String className, String methodName) {
    public static CallingInfo callingInfo() {
        Throwable throwable = new Throwable();
        StackTraceElement stackTraceElement = throwable.getStackTrace()[1];
        return new CallingInfo(stackTraceElement.getClassName(), stackTraceElement.getMethodName());
    }
}
