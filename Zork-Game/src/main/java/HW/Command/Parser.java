package HW.Command;

import HW.Game;

import java.util.Scanner;

public class Parser {
    private CommandFactory commands;
    private Scanner reader;

    /**
     * Create a parser to read from the terminal window.
     */
    public Parser(CommandFactory commandFactory) {
        commands = commandFactory;
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
     */
    public CommandLine getCommandLine() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");

        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
        if (commands.isCommand(word1)) {
            return new CommandLine(word1, word2);
        } else {
            return new CommandLine(null, word2);
        }
    }
}