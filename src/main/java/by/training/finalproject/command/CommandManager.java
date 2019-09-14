package by.training.finalproject.command;

import java.util.HashMap;
import java.util.Map;

public class CommandManager {
    private enum CommandType {
        SIGN_UP, UNKNOWN
    }

    private static Map<CommandType, Command> commandMap;

    static {
        commandMap = new HashMap<>();
        commandMap.put(CommandType.SIGN_UP, new SignUpCommand());
    }

    public static Command getCommand(String commandName) {
        CommandType commandType = CommandType.UNKNOWN;

        //try {
        commandType = CommandType.valueOf(commandName.toUpperCase());
        //} catch (Exception e) {
        //LOGGER.error(e);
        //}

        return commandMap.get(commandType);
    }
}
