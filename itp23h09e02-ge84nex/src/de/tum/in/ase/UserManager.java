package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserManager {

    private @NonNull List<User> users;

    public UserManager() {
        this.users = new ArrayList<>();
    }

    /**
     * Creates a Json backup containing all users
     *
     * @return The user list represented in Json format
     */
    public @NonNull String serializeUsers() {
        // TODO: Task 2.2: implement serializeUsers()
        JSONArray jsonArray = new JSONArray();

        for (User user: users) {
            jsonArray.put(user.toJson());
        }
        return jsonArray.toString();
    }

    /**
     * Loads users from the passed Json data
     *
     * @param json The Json data to parse
     */
    public void loadUsers(@NonNull String json) {
        users = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            User user = User.fromJson(jsonObject);
            users.add(user);
        }

    }

    /**
     * Gets the user object to the respective name
     *
     * @param name The users name
     * @return The respective user
     */
    public @NonNull Optional<User> getUserByName(@NonNull String name) {
        return users.stream()
                .filter(user -> name.equals(user.getName()))
                .findFirst();
    }

    public @NonNull List<User> getUsers() {
        return users;
    }

    public void setUsers(@NonNull List<User> users) {
        this.users = users;
    }
}
