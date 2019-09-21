package by.training.finalproject.command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private enum CommandType {
        ADD_RECIPE, SIGN_UP, SIGN_IN, UNKNOWN
    }

    private static Map<CommandType, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(CommandType.SIGN_UP, new SignUpCommand());
        commandMap.put(CommandType.SIGN_IN, new SignInCommand());
        commandMap.put(CommandType.ADD_RECIPE, new AddRecipeCommand());
    }

    public static Command getCommand(String commandName) {
        CommandType commandType = CommandType.valueOf(commandName.toUpperCase());
        return commandMap.get(commandType);
    }
}
