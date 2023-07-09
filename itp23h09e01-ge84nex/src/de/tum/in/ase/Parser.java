package de.tum.in.ase;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class Parser {

    // This constructor prevents the utility class Parser is instantiated.
    private Parser() {
    }

    /**
     * Extract a date time from the given line of the log, and return it as {@link LocalDateTime}.
     * {@link DateTimeFormatter} would be useful for this task.
     * If it cannot the given line because of its invalid format, throw {@link IllegalArgumentException}
     *
     * The format should follow below.
     * - It should be `yyyy-MM-dd HH:mm:ss`.
     * - It is required to start from the beginning of the line.
     *
     * e.g.) "INFO" from "2023-01-01 00:00:00 [INFO]: Happy New Year"
     *
     * @param line  the line of the log
     * @return the extracted date time
     * @throws IllegalArgumentException if the format of the line is invalid.
     * @see LocalDateTime
     * @see DateTimeFormatter
     */
    public static @NonNull LocalDateTime extractDateTime(@NonNull String line) {
        // TODO Task 1.1: Implement the method to extract a date time.

        String timeRegex = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
        Pattern pattern = Pattern.compile(timeRegex);
        Matcher matcher = pattern.matcher(line);
        if (!matcher.find()) {
            throw new IllegalArgumentException("IllegalArgumentException: format of the line is invalid");
        }

        String timeString = matcher.group();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(timeString, formatter);

    }

    /**
     * Extract a level from the given line of the log.
     * If it cannot the given line because of its invalid format, throw {@link IllegalArgumentException}
     *
     * The format should follow below.
     * - The levels are DEBUG, INFO, WARN, and ERROR as specified in the enum {@link Level}.
     * - The level is between square brackets. (e.g. [DEBUG])
     *
     * e.g.) "2023-01-01 00:00:00" from "2023-01-01 00:00:00 [INFO]: Happy New Year"
     *
     * @param line  the line of the log
     * @return the extracted level
     * @throws IllegalArgumentException if the format of the line is invalid.
     * @see Level
     */
    public static @NonNull Level extractLevel(@NonNull String line) {
        // TODO Task 1.2: Implement the method to extract a level.
        String levelRegex = "\\[(DEBUG|INFO|WARN|ERROR)\\]";
        Pattern pattern = Pattern.compile(levelRegex);
        Matcher matcher = pattern.matcher(line);

        if (!matcher.find()) {
            throw new IllegalArgumentException("IllegalArgumentException: format of the line is invalid");
        }

        String levelString = matcher.group();
        String levelValue = levelString.substring(1, levelString.length() - 1);
        return Level.valueOf(levelValue);
    }

    /**
     * Extract a message from the given line of the log.
     * If it cannot the given line because of its invalid format, throw {@link IllegalArgumentException}
     *
     * The format should follow below.
     * - The message is after the first ": " till the end of the line.
     * - The space after the colon is not included in the message.
     * - The message can contain any character.
     * - The message can be empty.
     *
     * e.g.) "Happy New Year" from "2023-01-01 00:00:00 [INFO]: Happy New Year"
     *
     * @param line the line of the log
     * @return the extracted message
     * @throws IllegalArgumentException if the format of the line is invalid.
     */
    public static @NonNull String extractMessage(@NonNull String line) {
        // TODO Task 1.3: Implement the method to extract a message.
        String message = ": (.*?)$";
        Pattern pattern = Pattern.compile(message);
        Matcher matcher = pattern.matcher(line);

        if (!matcher.find()) {
            throw new IllegalArgumentException("IllegalArgumentException: format of the line is invalid");
        }

        String messageString = matcher.group();

        return messageString.substring(2);
    }

    /**
     * Parse the given line of the log to an instance of {@link Log}.
     * If it cannot the given line because of its invalid format, throw {@link IllegalArgumentException}
     *
     * @param line  the line of the log
     * @return the parsed instance of Log
     * @throws IllegalArgumentException if the format of the line is invalid.
     * @see Log
     */
    public static @NonNull Log parseLine(@NonNull String line) {
        // TODO Task 2.1: Implement the method to parse one line of the log.
        LocalDateTime dateTime = extractDateTime(line);
        Level level = extractLevel(line);
        String message = extractMessage(line);

        return new Log(dateTime, level, message);
    }

    /**
     * Parse the log file to a List of Logs.
     * It ignores the invalid lines.
     *
     * @param fileName the filename of the log file
     * @return the parsed List of Logs
     * @throws IOException if there is a problem for reading the specified file.
     * @see Log
     */
    public static @NonNull List<Log> parseLogFile(@NonNull String fileName) throws IOException {
        // TODO Task 2.2: Implement the method to parse the entire log file.

        List<Log> logs = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(fileName), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    Log log = parseLine(line);
                    logs.add(log);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid line: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return logs;
    }
}
