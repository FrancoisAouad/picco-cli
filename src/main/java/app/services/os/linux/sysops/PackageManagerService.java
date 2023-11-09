package app.services.os.linux.sysops;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import app.global.GlobalService;
import app.global.TerminalService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ShellComponent
public class PackageManagerService {
    private final Logger logger = LogManager.getLogger(this.getClass());

    public PackageManagerService() {
    }

    @ShellMethod(key = "init", value = "Start system service")
    public void startServiceProcess(@ShellOption() String service) {
        var command = "systemctl start";

        if (!service.isEmpty()) {
            command += " " + service;
        }

        try {
            String os = GlobalService.getOperatingSystem();
            if (os.toLowerCase().contains("windows")) {
                logger.info("Operating System is WINDOWS");
                TerminalService.executeCommand(command);
            } else {
                TerminalService.executeCommand(command);
                logger.info("Operating System is LINUX");
            }
        } catch (Exception e) {
            logger.error("Failed to execute command: " + command, e.getMessage());
        }
    }

    @ShellMethod(key = "status", value = "Get service status")
    public void getServiceStatus(@ShellOption() String service) {
        var command = "systemctl status";
        if (!service.isEmpty()) {
            command += " " + service;
        }
        try {
            String os = GlobalService.getOperatingSystem();
            if (os.toLowerCase().contains("windows")) {
                logger.info("Operating System is WINDOWS");
                TerminalService.executeCommand(command);
            } else {
                TerminalService.executeCommand(command);
                logger.info("Operating System is LINUX");
            }
        } catch (Exception e) {
            logger.error("Failed to execute command: " + command, e.getMessage());
        }
    }

    @ShellMethod(key = "stop", value = "Stop system service")
    public void stopServiceProcess(@ShellOption() String service) {
        var command = "systemctl stop";
        if (!service.isEmpty()) {
            command += " " + service;
        }
        try {
            String os = GlobalService.getOperatingSystem();
            if (os.toLowerCase().contains("windows")) {
                logger.info("Operating System is WINDOWS");
                TerminalService.executeCommand(command);
            } else {
                TerminalService.executeCommand(command);
                logger.info("Operating System is LINUX");
            }
        } catch (Exception e) {
            logger.error("Failed to execute command: " + command, e.getMessage());
        }
    }

}
