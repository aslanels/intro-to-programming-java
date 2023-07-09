package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.json.JSONArray;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    /**
     * Parses the passed user list into a JSONArray using Streams
     * @param userList The user list to parse
     * @return The JSONArray containing the parsed users
     */
    public @NonNull JSONArray jsonArrayFromUserList(@NonNull List<User> userList) {
        
        return new JSONArray(userList.stream().map(User::toJson).collect(Collectors.toList()));
    }

    /**
     * Parses the passed course list into a JSONArray using Streams
     * @param courseList The course list to parse
     * @return The JSONArray containing the parsed courses
     */
    public @NonNull JSONArray jsonArrayFromCourseList(@NonNull List<Course> courseList) {

        return new JSONArray(courseList.stream().map(Course::toJson).collect(Collectors.toList()));
    }

}
