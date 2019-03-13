package training.endava.app.test.helpers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TestResourceResolver {

    public static String readFromFile(String... paths) throws Exception {
        URL url = getContextClassLoader()
                .getResource(".");

        Path filePath = getPath(url, paths);

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath.toFile()));
        return bufferedReader.lines()
                .collect(Collectors.joining());
    }

    private static Path getPath(URL url, String[] paths) throws Exception {
        if (url == null) {
            throw new Exception("Could not find root directory");
        }

        Path rootDirPath = Paths.get(url.toURI());
        return Paths.get(rootDirPath.toString(), paths)
                .normalize();
    }

    private static ClassLoader getContextClassLoader() {
        ClassLoader classLoader = TestResourceResolver.class.getClassLoader();
        if (classLoader == null) {
            return Thread.currentThread().getContextClassLoader();
        }
        return classLoader;
    }

}
