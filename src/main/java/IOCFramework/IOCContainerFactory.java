package IOCFramework;

import MovieApp.MovieFinder.IMovieFinder;
import MovieApp.MovieFinder.MovieFinder;
import MovieApp.MovieLister.MovieLister;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class IOCContainerFactory {

    public static IOCContainer configureIOCContainer() {
        IOCContainer container = new IOCContainer();

        Config config = getConfig();

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

    private static Config getConfig() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            InputStream is = classloader.getResourceAsStream("config.json");

            Config config = mapper.readValue(is, Config.class);
            return config;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
