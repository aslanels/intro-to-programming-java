package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {

    private @NonNull final Artemis artemis;
    private @NonNull List<Course> courses;

    public CourseManager(@NonNull Artemis artemis) {
        this.artemis = artemis;
        this.courses = new ArrayList<>();
    }

    /**
     * Loads courses from the passed Json data
     * @param json The Json data to parse
     */
    public void loadCourses(@NonNull String json) {
        // TODO: Task 3.3: implement loadCourses()
        courses = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(json);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Course course = Course.fromJson(jsonObject, artemis.getUserManager());
            courses.add(course);
        }


    }

    /**
     * Serializes the courses to Json
     * @return The course list represented in Json format
     */
    public @NonNull String serializeCourses() {
        JSONArray jsonArray = new JSONArray();
        for (Course course: courses) {
            jsonArray.put(course.toJson());
        }

        return jsonArray.toString();
    }

    public @NonNull List<Course> getCourses() {
        return courses;
    }

    public void setCourses(@NonNull List<Course> courses) {
        this.courses = courses;
    }
}
