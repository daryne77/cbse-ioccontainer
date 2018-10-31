package IOCFramework;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class IOCContainerFactory {

    public static IOCContainer configureIOCContainer(String configFileName) {
        IOCContainer container = new IOCContainer();

        Config config = getConfig(configFileName);

        if (config == null) return null;

        for (SimpleConfig simpleConfig : config.getSimpleConfig()) {
            try {
                container.registerImplementation(Class.forName(simpleConfig.getType()), Class.forName(simpleConfig.getImplementation()));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        for (ParamsConfig paramsConfig : config.getParamsConfig()) {
            try {
                container.registerImplementation(Class.forName(paramsConfig.getType()), Class.forName(paramsConfig.getImplementation()), paramsConfig.getParams());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        return container;
    }

    private static Config getConfig(String configFileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream(configFileName);

            return mapper.readValue(is, Config.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
