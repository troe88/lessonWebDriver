package com.spbstu.helper;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spbstu.pageobjectsfactory.entities.User;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.Map;

/**
 * Created by dmitry on 11.04.2017.
 */
public class ResourceLoaderSTU {

    public static final String DATA_USERS_JSON = "data/users.json";
    private static Map<String, User> users;

    static {
        loadUsers();
    }

    @SneakyThrows
    private static void loadUsers() {
        String rawData = getRawData(DATA_USERS_JSON);
        Type type = new TypeToken<Map<String, User>>(){}.getType();
        users = new Gson().fromJson(rawData, type);
    }

    private static String getRawData(String dataUsersJson) throws IOException {
        URL resource = ResourceLoaderSTU.class.getClassLoader().getResource(DATA_USERS_JSON);
        return IOUtils.toString(resource, "utf-8");
    }

    public static User getUser(String key) {
        return users.get(key);
    }
}
