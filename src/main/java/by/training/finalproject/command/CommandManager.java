package by.training.finalproject.command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private enum CommandType {
        SIGN_UP, SIGN_IN, UNKNOWN
    }

    private static Map<CommandType, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(CommandType.SIGN_UP, new SignUpCommand());
        commandMap.put(CommandType.SIGN_IN, new SignInCommand());
    }

    public static Command getCommand(String commandName) {
        //try {
        CommandType commandType = CommandType.valueOf(commandName.toUpperCase());
        //} catch (Exception e) {
        //LOGGER.error(e);
        //}

        return commandMap.get(commandType);
    }
}
