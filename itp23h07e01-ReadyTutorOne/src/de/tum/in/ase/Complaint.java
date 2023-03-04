package de.tum.in.ase;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Complaint {
    private Exam exam;
    private String message;

    public Complaint(Exam exam, String message) {
        this.exam = exam;
        this.message = message;
    }

    //      getters and setters
    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * @param exams only take status PRELIMINARY
     * @return a List of Complaints with "Plz giv 1.0"
     */
    public static List<Complaint> complainAllPreliminary(Stream<Exam> exams) {

        return (exams == null) ? null : exams.filter(Objects::nonNull)
                                              .filter(exam -> exam.getGrade() != null )
                                               .filter(exam -> exam.getGrade().getStatus() == Status.PRELIMINARY)
                                                .map(exam -> new Complaint(exam,"Plz giv 1.0"))
                                                 .collect(Collectors.toList());



    }

}
