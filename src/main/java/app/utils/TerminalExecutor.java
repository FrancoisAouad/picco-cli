package app.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class TerminalExecutor {
    private static TerminalExecutor instance = null;

    private TerminalExecutor() {
    }

    public static TerminalExecutor getInstance() {
        if (instance == null) {
            instance = new TerminalExecutor();
        }
        return instance;
    }

    public static void executeCommand(String command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }


}

