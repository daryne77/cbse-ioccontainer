package IOCFramework;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;

public class IOCContainer {
    private final HashMap<Class, Class> registeredClasses = new HashMap<>();
    private final HashMap<Class, Object[]> registeredParams = new HashMap<>();

    private class UnregisteredParamsException extends Exception {}

    public HashMap<Class, Class> getRegisteredClasses() {
        return (HashMap)registeredClasses.clone();
    }

    public HashMap<Class, Object[]> getRegisteredParams() {
        return (HashMap)registeredParams.clone();
    }

    void registerImplementation(Class type, Class implementationClass) {
        this.registeredClasses.put(type, implementationClass);
    }

    void registerImplementation(Class type, Class implementationClass, Object[] params) {
        this.registerImplementation(type, implementationClass);
        this.registeredParams.put(type, params);
    }

    private Class getRegisteredClass(Class type) {
        return this.registeredClasses.get(type);
    }

    private Object[] getParams(Class type) { return this.registeredParams.get(type); }

    public Object getInstance(Class type) {
        Class registeredClass = this.getRegisteredClass(type);
        Object[] params = this.getParams(type);

        // If we have no registered implementation, return null
        if (registeredClass == null) {
            return null;
        }

        // If we have no params registered for this class
        if (params == null) {
            try {
                // Try using the empty constructor
                return registeredClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                // Try using constructors with registered classes
                for (Constructor constructor : registeredClass.getConstructors()) {
                    try {
                        // Iterate through constructor parameters and attempt to match with registered params

                        Class[] constructorParams = constructor.getParameterTypes();
                        ArrayList<Object> instanceParams = new ArrayList<>();

                        for (Class parameterType : constructorParams) {
                            Object param = this.getInstance(parameterType);

                            if (param == null) {
                                // There is no implementation registered for this param
                                throw new UnregisteredParamsException();
                            }

                            instanceParams.add(param);
                        }

                        try {
                            return constructor.newInstance(instanceParams.toArray());
                        } catch (InstantiationException | IllegalAccessException | InvocationTargetException exc) {
                            exc.printStackTrace();
                        }
                    } catch (UnregisteredParamsException ignored) { }
                }
            }
        } else {
            // If we have registered params
            return getInstance(type, params);
        }

        return null;
    }

    public Object getInstance(Class type, Object[] params) {
        Class registeredClass = this.getRegisteredClass(type);

        for (Constructor constructor : registeredClass.getConstructors()) {
            try {
                Class[] constructorParams = constructor.getParameterTypes();

                if (constructorParams.length != params.length) {
                    throw new UnregisteredParamsException();
                }

                else {
                    // Iterate through constructor parameters and attempt to match with registered params
                    for (int index = 0; index < params.length; ++index) {
                        if (constructorParams[index] != params[index].getClass()) {
                            throw new UnregisteredParamsException();
                        }
                    }
                }

                try {
                    return constructor.newInstance((Object[]) params);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (UnregisteredParamsException ignored) { }
        }

        return null;
    }
}
