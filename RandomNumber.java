// Java Program
// File RandomNumber

import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class RandomNumber {
    public static void main (String[] args) {

String filePath = "C:\\Users\\danii\\OneDrive\\Рабочий стол\\Программы\\RandomNumber\\RandomNumberBase.txt";
String filePathName = "C:\\Users\\danii\\OneDrive\\Рабочий стол\\Программы\\RandomNumber\\RandomNumberBaseName.txt";

File file = new File(filePath);
    if (file.length() == 0) {
                String contentToAppend = "100000";
                try (FileWriter writer = new FileWriter(filePath, true)) {
                    writer.write(contentToAppend + System.lineSeparator());
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
    }

File fileName = new File(filePathName);
    if (fileName.length() == 0) {
                String contentToAppend = "Vasya";
                try (FileWriter writer = new FileWriter(filePathName, true)) {
                    writer.write(contentToAppend + System.lineSeparator());
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
    }

        System.out.println("Это игра угадай число!");
        System.out.println("Я загадаю число, а ты долден будешь его угадать!");
        System.out.println("Я буду тебе подсказывать, это число больше или меньше!");

        String userAnswer = "Yes";
do {

        Scanner scanner4 = new Scanner(System.in);
        System.out.println();
        System.out.println("ИГРА НАЧАЛАСЬ");
        System.out.print("Кто играет (на английском)? ");
        String userAnswerName = scanner4.nextLine();

        Random random = new Random();
        int randomNumber = 0;
        int userGuess = 0;
        int konets = 0;
        int popitki = 0;
        String line = null;
        String lineName = null;

        System.out.println();
        System.out.println("Я загадал число от 1 до 100!");
            Scanner scanner = new Scanner(System.in);
            randomNumber = random.nextInt(100) + 1;

        do {
            if (konets == 0)
            System.out.println();
            System.out.print("Твой вариант: ");
            userGuess = scanner.nextInt();
            if (userGuess < randomNumber) {
                System.out.println("Число больше!");
                popitki++;
            } else if (userGuess > randomNumber) {
                System.out.println("Число меньше!");
                popitki++;
            } else {
                popitki++;
                konets++;

                filePath = "C:\\Users\\danii\\OneDrive\\Рабочий стол\\Программы\\RandomNumber\\RandomNumberBase.txt";
                try (Scanner scanner2 = new Scanner(new File(filePath))) {
                    while (scanner2.hasNextLine()) {
                        line = scanner2.nextLine();
                    }
                } catch (FileNotFoundException e) {
                    System.err.println(e.getMessage());
                        }

                filePathName = "C:\\Users\\danii\\OneDrive\\Рабочий стол\\Программы\\RandomNumber\\RandomNumberBaseName.txt";
                try (Scanner scanner5 = new Scanner(new File(filePathName))) {
                    while (scanner5.hasNextLine()) {
                        lineName = scanner5.nextLine();
                    }
                } catch (FileNotFoundException e) {
                    System.err.println(e.getMessage());
                        }


                int rekord = Integer.parseInt(line);

                System.out.println();
                System.out.println("Молодец! Ты угадал моё число!  ");
                System.out.println("Тебе понадобилось " + popitki + " попыток!");
                System.out.println("----------------------------");
                if (popitki <= rekord) {
                    System.out.println("Рекорд угадать число за " + popitki + " попыток!");
                    System.out.println("Рекорд установил: " + userAnswerName);
                } else if (popitki > rekord) {
                    System.out.println("Рекорд угадать число за " + line + " попыток!");
                    System.out.println("Рекорд установил: " + lineName);
                }

                if (popitki <= rekord) {
                        try (FileWriter writer = new FileWriter(filePath)) {
                                writer.write(String.valueOf(popitki));
                            } catch (IOException e) {
                                System.err.println(e.getMessage());
                            }

                        try (FileWriter writer = new FileWriter(filePathName)) {
                                writer.write(String.valueOf(userAnswerName));
                            } catch (IOException e) {
                                System.err.println(e.getMessage());
                            }

                    }
                konets = 1;
            }
        } while (konets == 0);

    do {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println();
        System.out.println("Сыграем ещё раз (Yes или No)? ");
        userAnswer = scanner3.nextLine();

        if (userAnswer.equals("No") || userAnswer.equals("NO") || userAnswer.equals("no")) {
            scanner.close();
            scanner3.close();
            scanner4.close();
        }
        else if (userAnswer.equals("Yes") || userAnswer.equals("YES") || userAnswer.equals("yes")) {
            System.out.println();
        }
        if (!userAnswer.equals("No") && !userAnswer.equals("NO") && !userAnswer.equals("no") && !userAnswer.equals("Yes") && !userAnswer.equals("YES") && !userAnswer.equals("yes")) {
            System.out.println("Я вас не понял!");
        }
    } while (!userAnswer.equals("No") && !userAnswer.equals("NO") && !userAnswer.equals("no") && !userAnswer.equals("Yes") && !userAnswer.equals("YES") && !userAnswer.equals("yes"));


} while (userAnswer.equals("Yes") || userAnswer.equals("YES") || userAnswer.equals("yes"));

    }
}