package de.tum.in.ase;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Artemis {

    /**
     * @param exams all exams a student has taken
     * @return average of all VALID grades
     * as default return 0
     */
    public static double averageGrade(Stream<Exam> exams) {

        return (exams == null) ? Double.valueOf(0) : exams.filter(Objects::nonNull)
                                                              .map(Exam::getGrade)
                                                               .filter(Objects::nonNull)
                                                                .filter(grade -> grade.getStatus() == Status.VALID )
                                                                 .collect(Collectors.averagingDouble(Grade::getValue));

    }

    /**
     * @param exams sorted based on the exam dates ascendingly
     * @return  a sorted list
     * Hint: the Comparator of Java may be helpful.
     */
    public static List<Exam> sortExamsByExamDate(Stream<Exam> exams) {

        return (exams == null) ? null : exams.filter(Objects::nonNull)
                                              .sorted(Comparator.comparing(Exam::getExamDate))
                                               .collect(Collectors.toList());


    }

    /**
     * @param exams all exams a student has taken
     * @return the earliest exam that a student has written, if no such exam exists return null
     */
    public static LocalDate dateOfFirstExam(Stream<Exam> exams) {

        return (exams == null) ? null : exams.filter(Objects::nonNull)
                                              .map(Exam::getExamDate)
                                               .filter(Objects::nonNull)
                                                .min(Comparator.comparing(LocalDate::toEpochDay))
                                                 .orElse(null);


    }

    /**
     * @param exams only take the VALID status
     * @return a map with isOnline as key : true (online exam) and false (on site exam) and the corresponding amounts of exams as value
     */
    public static Map<Boolean, Integer> countByOnline(Stream<Exam> exams) {

        Map<Boolean, Integer> emptyMap =  new HashMap<>();

        return (exams == null) ?  emptyMap : exams.filter(Objects::nonNull)
                                              .filter(exam -> exam.getGrade() != null )
                                               .filter(exam -> exam.getGrade().getStatus() == Status.VALID)
                                                .collect(Collectors.toMap(Exam::isOnline, exam -> 1, Integer::sum ));


    }


    /**
     * @param exams apply formatExam to every exam
     * @param formatter specifies exam output
     * @return formatted exams, with every exam in its own line.
     */
	public static String createFormattedReport(Stream<Exam> exams, Formatter formatter) {

        return (exams == null) ? null : exams.filter(Objects::nonNull)
                                              .map(formatter::formatExam)
                                               .collect(Collectors.joining());
	}


    /**
     *  call the method createFormattedReport and pass the Formatter as a lambda expression
     * @param exams all exams a student has taken
     * @return a report formatted using this scheme: [<grade-status>] Exam "<exam-name>": <grade>
     */
    public static String createSimpleReport(Stream<Exam> exams) {

        return createFormattedReport(exams, exam -> "[" + exam.getGrade().getStatus() + "] Exam \"" + exam.getName() + "\": " + exam.getGrade().getValue() +"\n");



    }

    public static void main(String[] args) {
/*
        Grade g1 = new Grade(1,Status.VALID);
        Grade g2 = new Grade(2,Status.INVALID);
        Grade g3 = new Grade(3,Status.PRELIMINARY);

        LocalDate d1 = LocalDate.of(2022, 1, 1);
        LocalDate d2 = LocalDate.of(2022,2,2);
        LocalDate d3 = LocalDate.of(2022,3,3);

        Exam x1 = new Exam("x1",g1,true,5,d1,d1);
        Exam x2 = new Exam("x2",g2,false,5,d2,d2);
        Exam x3 = new Exam("x3",g3,false,5,d3,d3);

        List<Exam> examList = Arrays.asList(x3,x2,x1,null);

        System.out.println(averageGrade(examList.stream()));

        List<Complaint> complaints = Complaint.complainAllPreliminary(examList.stream());

        for (Complaint complaint: complaints){
            System.out.println(complaint.getMessage());
        }

        List<Exam> sorted = sortExamsByExamDate(examList.stream());

        for (Exam exam: sorted){
            System.out.println(exam.getExamDate());
        }

        System.out.println(dateOfFirstExam(examList.stream()));

        Map<Boolean, Integer> countsOnline = countByOnline(examList.stream());

        for(Map.Entry mp: countsOnline.entrySet()){
            System.out.println(mp.getKey()+ ": "+mp.getValue());
        }



        System.out.println(createSimpleReport(examList.stream()));

*/


    }

}
