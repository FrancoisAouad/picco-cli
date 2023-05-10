package app.global;

import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Paths;

@Service
public class GlobalService {

    public static String currentDirectoryUsingSystemProperties() {
        return System.getProperty("user.dir");
    }

    public static String currentDirectoryUsingPaths() {
        return Paths.get("")
                .toAbsolutePath()
                .toString();
    }

    public static String currentDirectoryUsingFileSystems() {
        return FileSystems.getDefault()
                .getPath("")
                .toAbsolutePath()
                .toString();
    }

    public static String currentDirectoryUsingFile() {
        return new File("").getAbsolutePath();
    }

    public static String getOperatingSystem() {
        return System.getProperty("os.name");
    }
}
