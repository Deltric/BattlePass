package dev.deltric.battlepass.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * Gson utility for loading configs
 * TODO(Deltric): Move to library mod
 */
public class GConfig {

    private static Gson gson;

    /**
     * Loads a config file of the object
     * @param mod - mod instance
     * @param configName - config name
     * @param configObject - class to load as
     * @return loaded config object or null if failed to load
     */
    public static <T> T load(ServerMod mod, String configName, Class<T> configObject) {
        return load(mod, configName, configObject, true);
    }

    /**
     * Loads a config file of the object
     * @param mod - mod instance
     * @param configName - config name
     * @param configObject - class to load as
     * @return loaded config object or null if failed to load
     */
    public static <T> T load(ServerMod mod, String configName, Class<T> configObject, boolean createDefault) {
        // Make configuration folder if it doesn't exist
        File configDir = new File(System.getProperty("user.dir"), "/config/" + mod.getId() + "/");
        if(configDir.mkdirs())
            mod.getLogger().info("Created " + mod.getName() + " Config directory.");

        File configFile = new File(configDir, configName + ".json");
        if(createDefault && !configFile.exists()) {
            mod.getAsset(configName + ".json").ifPresent(assetStream -> {
                try {
                    FileUtils.copyInputStreamToFile(assetStream, configFile);
                } catch (IOException e) {
                    mod.getLogger().error("Failed to copy the default config.");
                    e.printStackTrace();
                }
            });
        }

        // TODO(Deltric): Test if the same file automatically updates
        // Check if config doesn't exist
        if(!configFile.exists()) {
            return null;
        }

        Gson gson = getGson();
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(configFile));
            return gson.fromJson(jsonReader, configObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Saves a config object to a json file
     * @param mod - mod instance
     * @param configName - config name
     * @param object - object to save
     * @return true if successful otherwise false
     */
    public static boolean save(ServerMod mod, String configName, Object object) {
        // Make configuration folder if it doesn't exist
        File configDir = new File(System.getProperty("user.dir"), "/config/" + mod.getId() + "/");
        if(configDir.mkdirs())
            mod.getLogger().info("Created " + mod.getName() + " Config directory.");

        File configFile = new File(configDir, configName + ".json");
        Gson gson = getGson();
        try {
            FileWriter fileWriter = new FileWriter(configFile);
            gson.toJson(object, fileWriter);
            fileWriter.flush();
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Gets or creates a configured gson instance
     * @return gson instance
     */
    private static Gson getGson() {
        if(gson == null)
            gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
        return gson;
    }

}