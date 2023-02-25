package de.tum.in.ase;

import java.util.Arrays;
import java.util.List;

public class LectureHall {
    //      attributes
    private String name;
    private int capacity;
    private int rows;
    private Student[][] rowsOfStudents;

    //      constructor

    public LectureHall(String name, int capacity) {
        this.name = name;
        if ( capacity < 90){
            this.capacity = 90;
        }else {
            int modulo = capacity % 30;
            this.capacity = capacity - modulo;
        }

        this.rows = this.capacity / 30;
        this.rowsOfStudents = new Student[this.rows][30];

    }

    //      methods

    public void placeStudents(List<Student> waitingStudents){
        System.out.println("Waiting students: " + waitingStudents.size());

        if (waitingStudents.size() > this.capacity){
            System.out.println( this.getName() + " hall doesn't have enough places for all the students!\nWe can place only the first " + this.getCapacity() + " out of " + waitingStudents.size() + " students.");

            List<Student> allowedStudents = waitingStudents.subList(0, this.getCapacity());
            int count = 0;
            for(int x = 0; x < rowsOfStudents.length; x++){
                for(int y = 0; y < rowsOfStudents[x].length; y++) {
                    rowsOfStudents[x][y] = allowedStudents.get(count);
                    count++;
                }
            }

        }else {
            System.out.println("All students are sitting in the lecture hall.");

            int count = waitingStudents.size();
            int i = 0;
            for(int x = 0; x < rowsOfStudents.length; x++){
                for(int y = 0; y < rowsOfStudents[x].length; y++) {
                     rowsOfStudents[x][y] = waitingStudents.get(i);
                     count--;
                     i++;
                     if (count == 0)
                         break;

                }
                if (count == 0)
                    break;
            }
        }

        System.out.println(this.toString());
    }

    public void empty(){
        for (Student[] rowsOfStudent : rowsOfStudents) {
            Arrays.fill(rowsOfStudent, null);
        }

    }

    public String toString(){
        StringBuilder hall = new StringBuilder();

        hall.append(this.getName() + " hall:\n");

        for (int x = 0; x < rowsOfStudents.length; x++){
           hall.append("Row " + (x+1) + ": ");
            for (int y = 0; y < rowsOfStudents[x].length; y++){
                hall.append("[");
                if(rowsOfStudents[x][y] != null){
                    hall.append( rowsOfStudents[x][y].getName());
                }
                hall.append("]");
            }

            if ( x < rowsOfStudents.length -1){
                hall.append("\n");
            }
        }
         return String.valueOf(hall);
    }

    //      getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public Student[][] getRowsOfStudents() {
        return rowsOfStudents;
    }

    public void setRowsOfStudents(Student[][] rowsOfStudents) {
        this.rowsOfStudents = rowsOfStudents;
    }
}
