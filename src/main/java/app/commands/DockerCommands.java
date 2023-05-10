package app.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import app.global.GlobalService;
import app.utils.TerminalExecutor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@ShellComponent
public class DockerCommands {
    private final Logger logger = LogManager.getLogger(this.getClass());


    public DockerCommands() {
    }

    @ShellMethod(key = "start monitoring", value = "Starts prometheus system monitoring")
    public void startMonitoring() {
        var command = "cd /home/Documents/monitoring & docker-compose up -d";
        try {
            String os = GlobalService.getOperatingSystem();
            if (os.toLowerCase().contains("windows")) {
                logger.info("Operating System is WINDOWS");
                TerminalExecutor.executeCommand(command);
            } else {
                TerminalExecutor.executeCommand(command);
                logger.info("Operating System is LINUX");
            }
        } catch (Exception e) {
            logger.error("Failed to execute command: " + command, e.getMessage());
        }
    }
  
    @ShellMethod(key = "stop monitoring", value = "Stops prometheus system monitoring")
    public void stopMonitoring() {
        var command = "cd /home/Documents/monitoring & docker-compose down";
        try {
            String os = GlobalService.getOperatingSystem();
            if (os.toLowerCase().contains("windows")) {
                logger.info("Operating System is WINDOWS");
                TerminalExecutor.executeCommand(command);
            } else {
                TerminalExecutor.executeCommand(command);
                logger.info("Operating System is LINUX");
            }
        } catch (Exception e) {
            logger.error("Failed to execute command: " + command, e.getMessage());
        }
    }

    @ShellMethod(key = "docker list", value = "Return list of all containers")
    public void getContainerList() {
        var command = "docker ps -a";
      
        try {
            String os = GlobalService.getOperatingSystem();
            if (os.toLowerCase().contains("windows")) {
                logger.info("Operating System is WINDOWS");
                TerminalExecutor.executeCommand(command);
            } else {
                TerminalExecutor.executeCommand(command);
                logger.info("Operating System is LINUX");
            }
        } catch (Exception e) {
            logger.error("Failed to execute command: " + command, e.getMessage());
        }
    }

    @ShellMethod(key = "stop", value = "Stop Docker Container")
    public void stopDockerContainer(@ShellOption() String name) {
        var command = "docker stop";
        var finalCmd = "";
        try {
            String os = GlobalService.getOperatingSystem();
            if (os.toLowerCase().contains("windows")) {
                logger.info("Operating System is WINDOWS");
                finalCmd = "cmd /c " + command;
                if (!name.isEmpty()) {
                    finalCmd += " " + name;
                }
                TerminalExecutor.executeCommand(finalCmd);
            } else {
                finalCmd = "/bin/bash " + command;
                if (!name.isEmpty()) {
                    finalCmd += " " + name;
                }
                TerminalExecutor.executeCommand(finalCmd);
                logger.info("Operating System is LINUX");
            }
        } catch (Exception e) {
            logger.error("Failed to execute command: " + finalCmd, e.getMessage());
        }
        logger.info("arg");
    }

    @ShellMethod(key = "init", value = "Stop Docker Container")
    public void startServiceProcess(@ShellOption()String service) {
        var command = "systemctl start";
        if(!service.isEmpty()){
            command+=service;
        }
        try {
            String os = GlobalService.getOperatingSystem();
            if (os.toLowerCase().contains("windows")) {
                logger.info("Operating System is WINDOWS");
                TerminalExecutor.executeCommand(command);
            } else {
                TerminalExecutor.executeCommand(command);
                logger.info("Operating System is LINUX");
            }
        } catch (Exception e) {
            logger.error("Failed to execute command: " + command, e.getMessage());
        }
    }

}
