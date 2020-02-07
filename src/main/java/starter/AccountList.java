package starter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;

public class AccountList {
    private JList<String> accountList;
    private JButton runAccount;
    private JButton addNew;
    private JButton remove;
    public JPanel accountPanel;
    final private IFlow flow;
    private final String[] data1 = { "Чай" ,"Кофе"  ,"Минеральная","Морс","Морс","Морс","Морс","Морс","Морс","Морс","Морс","Морс","Морс","Морс"};
    public AccountList(IFlow flowManager) {
        this.flow = flowManager;
        DefaultListModel<String> dlm = new DefaultListModel();
        dlm.addElement(data1[0]);
        dlm.addElement(data1[1]);
        dlm.addElement(data1[2]);
        dlm.addElement(data1[3]);
        dlm.addElement(data1[4]);
        dlm.addElement(data1[5]);
        dlm.addElement(data1[6]);
        dlm.addElement(data1[7]);
        dlm.addElement(data1[8]);
        accountList.setModel(dlm);
        runAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
//                flow.runAccount(accountList.getSelectedValue());
            }
        });
        addNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }
}
