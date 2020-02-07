package starter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class InitWindow {
    private JButton select_init_path;
    private JButton select_exe_path;
    public JPanel initPanel;
    private JTextField exePath;
    private JTextField initPath;
    private JButton confirm;
    final private IFlow flow;
    private String initPathString = null;
    private String exePathString = null;

    private JFileChooser fileChooser = new JFileChooser();

    public InitWindow(IFlow flowManager) {
        this.flow = flowManager;
        Border line = BorderFactory.createLineBorder(Color.DARK_GRAY);
        Border empty = new EmptyBorder(0, 20, 0, 0);
        CompoundBorder border = new CompoundBorder(line, empty);
        exePath.setBorder(border);
        initPath.setBorder(border);

        select_init_path.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.showOpenDialog(null);
                initPath.setText(fileChooser.getSelectedFile().getPath());
                initPathString = fileChooser.getSelectedFile().getPath();
            }
        });
        select_exe_path.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileChooser.showOpenDialog(null);
                exePath.setText(fileChooser.getSelectedFile().getPath());
                exePathString = fileChooser.getSelectedFile().getPath();
            }
        });
        confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(initPathString==null||exePathString ==null){
                    JOptionPane.showMessageDialog(null,"Pls fill all field");
                }else{
                    flow.onInitFinish(initPathString,exePathString);
                }
            }
        });
    }


    private static void setupConfigedFlow(File file) {
    }


}
