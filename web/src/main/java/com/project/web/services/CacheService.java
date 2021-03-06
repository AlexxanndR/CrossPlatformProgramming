package com.project.web.services;

import com.project.web.IO.InputParams;
import com.project.web.IO.OutputParams;
import com.project.web.logger.MyLogger;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Component;
import java.util.HashMap;

@Component
public class CacheService {
    private final HashMap<InputParams, OutputParams> cache = new HashMap<>();

    public void add(InputParams in, OutputParams out) {
        if (!cache.containsKey(in)) {
            cache.put(in, out);
            MyLogger.log(Level.INFO, "Value " + in + "@" + out + " added to cache!");
        }
    }

    public OutputParams find(InputParams in) {
        if (cache.containsKey(in)) {
            MyLogger.log(Level.INFO, "Value " + in + " found in cache!");
            return cache.get(in);
        }
        MyLogger.log(Level.INFO, "Value " + in + " not found in cache!");
        return null;
    }

    public HashMap<InputParams, OutputParams> getCache() {
        return cache;
    }

    @Override
    public String toString() {
        return cache.toString();
    }
}
