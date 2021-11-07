package dev.deltric.battlepass.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Optional;

/**
 * Boilerplate abstract class for server side mods.
 * TODO(Deltric): Move to library mod
 */
public abstract class ServerMod {

    private Logger logger = null;

    /**
     * Gets the mod id
     * @return mod id
     */
    public abstract String getId();

    /**
     * Gets the mod name
     * @return mod name
     */
    public abstract String getName();

    /**
     * Gets the mod version
     * @return mod version
     */
    public abstract String getVersion();

    /**
     * Gets or creates a logger instance for this plugin
     * @return logger instance
     */
    public Logger getLogger() {
        if(logger == null) {
            logger = LogManager.getLogger(this.getId());
        }
        return logger;
    }

    /**
     * Looks for an asset under this plugins asset folder
     * @param assetName - asset name to look for
     * @return the input stream for the asset or empty if it wasn't found
     */
    public Optional<InputStream> getAsset(String assetName) {
        return Optional.ofNullable(getClass().getClassLoader()
                .getResourceAsStream(String.format("assets/%s/%s", this.getId(), assetName)));
    }

}
