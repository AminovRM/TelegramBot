package Lessons.commands;

public class BotCommonCommands {
    @AppBotCommand(name = "/hello", description = "when request hello", showInHelp = true)
    String hello() {
        return "Hello, User";
    }

    @AppBotCommand(name = "/bye", description = "when request bye", showInHelp = true)
    String bye() {
        return "Good bye, User";
    }

    @AppBotCommand(name = "/help", description = "when request bye", showInKeyboard = true)
    String help() {
        return "HEEEELP";
    }
}
