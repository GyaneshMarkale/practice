package DesignPatterns.FactoryPattern;

public class EmployeeFactory {
    private static final String ANDROID_DEVELOPER= "ANDROID DEVELOPER";
    private static final String WEB_DEVELOPER= "WEB DEVELOPER";
    public static Employee getEmployee(String empType)
    {
        if (empType.trim().equalsIgnoreCase(ANDROID_DEVELOPER))
        {
            return new AndroidDeveloper();
        }
        else if(empType.trim().equalsIgnoreCase(WEB_DEVELOPER))
        {
            return new WebDeveloper();
        }
        return null;
    }
}
