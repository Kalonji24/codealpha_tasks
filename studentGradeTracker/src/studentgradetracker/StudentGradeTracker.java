package studentgradetracker;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> grades = new ArrayList<>();

        System.out.println("Welcome to the Student Grade Tracker!");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add a grade");
            System.out.println("2. View all grades");
            System.out.println("3. Calculate average grade");
            System.out.println("4. Find highest grade");
            System.out.println("5. Find lowest grade");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

   switch (choice) {
         case 1:
                    System.out.print("Enter the grade to add (0-100): ");
                    double grade = scanner.nextDouble();
           if (grade >= 0 && grade <= 100) {
                        grades.add(grade);
                        System.out.println("Grade added successfully.");
                } else {
                        System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                    }
                    break;
                case 2:
                    System.out.println("Grades: " + grades);
                    break;
                case 3:
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to calculate average.");
                    } else {
                        double average = calculateAverage(grades);
                        System.out.printf("Average grade: %.2f\n", average);
                    }
                    break;
                case 4:
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to find the highest grade.");
                    } else {
                        double highest = findHighest(grades);
                        System.out.println("Highest grade: " + highest);
                    }
                    break;
                case 5:
                    if (grades.isEmpty()) {
                        System.out.println("No grades available to find the lowest grade.");
                    } else {
                        double lowest = findLowest(grades);
                        System.out.println("Lowest grade: " + lowest);
                    }
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }


    public static double calculateAverage(ArrayList<Double> grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }


    public static double findHighest(ArrayList<Double> grades) {
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }



    public static double findLowest(ArrayList<Double> grades) {
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
