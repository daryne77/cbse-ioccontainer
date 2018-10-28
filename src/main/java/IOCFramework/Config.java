package IOCFramework;

import java.util.Arrays;

public class Config {
    private SimpleConfig[] simpleConfig;
    private ParamsConfig[] paramsConfig;

    public Config() {
    }

    public SimpleConfig[] getSimpleConfig() {
        return simpleConfig;
    }

    public void setSimpleConfig(SimpleConfig[] simpleConfig) {
        this.simpleConfig = simpleConfig;
    }

    public ParamsConfig[] getParamsConfig() {
        return paramsConfig;
    }

    public void setParamsConfig(ParamsConfig[] paramsConfig) {
        this.paramsConfig = paramsConfig;
    }

    @Override
    public String toString() {
        return "Config{" +
                "simpleConfig=" + Arrays.toString(simpleConfig) +
                ", paramsConfig=" + Arrays.toString(paramsConfig) +
                '}';
    }
}
