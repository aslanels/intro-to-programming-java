package de.tum.in.ase;

/**
 * Implement a functional interface Formatter with the annotation @FunctionalInterface.
 * This interface has a method called formatExam(Exam exam) whose return type is String.
 */
@FunctionalInterface
interface Formatter {
    String formatExam(Exam exam);
}
