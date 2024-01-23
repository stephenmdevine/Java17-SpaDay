package org.launchcode.spaday.data;

import org.launchcode.models.User;

import java.util.HashMap;
import java.util.Map;

public class UserData {
    private static final Map<Integer, User> users = new HashMap<>();

    public static void add(User user) {
        users.put(user.getId(), user);
    }
}
