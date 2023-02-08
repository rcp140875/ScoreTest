import ricardotest.TeamScores;

import java.io.*;

public class Main {

    public static void printInvalidFormat() {
        System.out.println("Invalid format:");
        System.out.println("Type a valid format.");
        System.out.println("Example: AC GDL 3, AGUILAS CLUB 1 ");
        System.out.println("Type x to exit + enter");
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Ricardo Tets!");
        TeamScores teamScores = new TeamScores();
        boolean readingFile = false;
        File file = null;
        BufferedReader reader = null;

        if (args.length > 0) {
            file = new File(args[0]);
            readingFile = true;
            try {
                reader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + file.getAbsolutePath());
                throw new RuntimeException(e);
            }
        } else {
            readingFile = false;
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        if (readingFile) {
            System.out.println("Reading your file at: " + file.getAbsolutePath());
        } else {
            System.out.println("Type your score.");
            System.out.println("Type x to exit + enter.");
            System.out.println("Example: AC GDL 3, AGUILAS CLUB 1 ");
        }

        String line = "";

        while (line != null && !line.equals("x") && !line.equals("X")) {
            try {
                line = reader.readLine();
                if (line == null || line.equals("x") || line.equals("X")) { // If we are reading a file we reached end of file
                    continue;
                }
                String[] tokensArray = line.split(",");
                if (tokensArray.length != 2) {
                    printInvalidFormat();
                    continue;
                }

                String team1Name = "";
                int team1Score = 0;
                String[] subTokens1Array = tokensArray[0].split(" ");
                try {
                    team1Score = Integer.parseInt(subTokens1Array[subTokens1Array.length - 1]);
                    if (subTokens1Array.length < 2) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    printInvalidFormat();
                    continue;
                }

                for (int i = 0; i < subTokens1Array.length - 1; i++) {
                    if (subTokens1Array.length > 2) {
                        team1Name = team1Name + " " + subTokens1Array[i];
                    } else {
                        team1Name = subTokens1Array[i];
                    }
                }

                //System.out.println(team1Name.trim() + " => " + team1Score);

                String team2Name = "";
                int team2Score = 0;
                String[] subTokens2Array = tokensArray[1].split(" ");
                try {
                    team2Score = Integer.parseInt(subTokens2Array[subTokens2Array.length - 1]);
                    if (subTokens1Array.length < 2) {
                        throw new NumberFormatException();
                    }
                } catch (NumberFormatException e) {
                    printInvalidFormat();
                    continue;
                }

                for (int i = 0; i < subTokens2Array.length - 1; i++) {
                    if (subTokens2Array.length > 2) {
                        team2Name = team2Name + " " + subTokens2Array[i];
                    } else {
                        team2Name = subTokens1Array[i];
                    }
                }
                //System.out.println(team2Name.trim() + " => " + team2Score);
                teamScores.addScore(team1Name.trim(), team1Score, team2Name.trim(), team2Score);

            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            //teamScores.print();
        }
        teamScores.print();
    }
}