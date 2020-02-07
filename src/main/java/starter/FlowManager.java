package starter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlowManager implements IFlow {
    private boolean fileExist;

    public FlowManager(boolean fileExist) {
        this.fileExist = fileExist;
    }

    public void startFlow() throws IOException {
//        if (fileExist) {
            showListOfAccounts();
//        } else {
//            showInitView();
//        }
    }

    private void showInitView() {
        JFrame initFrame = new JFrame("Setup path to init and exe files");
        initFrame.setContentPane(new InitWindow(this).initPanel);
        initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame.setPreferredSize(new Dimension(400, 200));
        initFrame.pack();
        initFrame.setVisible(true);
    }

    private void showListOfAccounts() throws IOException {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader("account.json");
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;
            employeeList.forEach( emp -> System.out.print("ee"));
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
        JFrame initFrame = new JFrame("Choose account");
        AccountList accountList = new AccountList(this);
        initFrame.setContentPane(accountList.accountPanel);
        initFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initFrame.setPreferredSize(new Dimension(400, 200));
        initFrame.pack();
        initFrame.setVisible(true);

    }

    @Override
    public void onInitFinish(String initPathString, String exePathString) {
        JSONObject config = new JSONObject();
        config.put("initPath", initPathString);
        config.put("exePath", exePathString);
        //Write JSON file
        try (FileWriter file = new FileWriter("config.json")) {
            file.write(config.toJSONString());
            file.flush();
            showListOfAccounts();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
