import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class IOCContainer {
    private final HashMap<Class, Class> registeredClasses = new HashMap<>();
    private final HashMap<Class, Object> registeredInstances = new HashMap<>();

    private class UnregisteredParameterException extends Exception {}

    public void registerClass(Class type, Class implementationClass) {
        this.registeredClasses.put(type, implementationClass);
    }

    public void registerInstance(Class type, Object implementationInstance) {
        this.registeredInstances.put(type, implementationInstance);
    }

    private Class getRegisteredClass(Class type) {
        return this.registeredClasses.get(type);
    }

    private Object getRegisteredInstance(Class type) {
        return this.registeredInstances.get(type);
    }

    public Object getInstance(Class type) {
        Object registeredInstance = this.getRegisteredInstance(type);
        if (registeredInstance != null) {
            return registeredInstance;
        }

        Class registeredClass = this.getRegisteredClass(type);

        if (registeredClass != null) {
            for (Constructor constructor : registeredClass.getConstructors()) {
                ArrayList<Object> parameters = new ArrayList<>();

                try {
                    for (Class parameterType : constructor.getParameterTypes()) {
                        Object parameter = this.getInstance(parameterType);

                        if (parameter != null) {
                            parameters.add(parameter);
                        } else {
                            throw new UnregisteredParameterException();
                        }
                    }

                    try {
                        return constructor.newInstance(parameters);
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                } catch (UnregisteredParameterException e) { }
            }
        }

        return null;
    }
}
