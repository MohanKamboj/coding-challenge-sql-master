package exercise.command;

import exercise.exception.InvalidParameterException;

public interface Command {
    String helpText();
    void execute(String[] params) throws InvalidParameterException;
}
