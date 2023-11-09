package app.global;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class TerminalService {
    private static TerminalService instance = null;

    private TerminalService() {
    }

    public static TerminalService getInstance() {
        if (instance == null) {
            instance = new TerminalService();
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
