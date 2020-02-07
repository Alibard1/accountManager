package starter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class AccountStarter {

    private static String fileConfig = "pathConfig.txt";
    private static String fileSeparator = "\\";

    public static void main(String[] args) {
        try {
            String path = new File(".").getCanonicalPath();
            System.out.print(path + " 11");
            File file = new File(path + fileSeparator + fileConfig);
            FlowManager flowManager = new FlowManager(file.exists());
            flowManager.startFlow();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
