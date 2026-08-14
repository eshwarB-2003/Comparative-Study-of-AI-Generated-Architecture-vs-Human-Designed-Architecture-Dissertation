package trade.patterns.interceptor;

public interface Interceptor {
    boolean preHandle(String email, String role);
}
