package app.cmd;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ShellComponent
public class LinuxCommands {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @ShellMethod(key = "install", value = "Install packages or repositories")
    public void install(
            @ShellOption() String arg,
            @ShellOption(value = { "-s", "--sudo" }, defaultValue = "false") boolean sudo,
            @ShellOption(value = { "-d", "--dnf" }, defaultValue = "false") boolean dnf,
            @ShellOption(value = { "-r", "--rpm" }, defaultValue = "false") boolean rpm) {

    }

    @ShellMethod(key = "find", value = "Searches for packages or repositories")
    public void find(@ShellOption() String arg) {

    }

    @ShellMethod(key = "delete", value = "Removes for packages or repositories")
    public void delete(@ShellOption() String arg) {
    }
}
