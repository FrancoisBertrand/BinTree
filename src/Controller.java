import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Francois on 07/02/2017.
 */
public class Controller extends JFrame implements ActionListener {

    JButton randomTree;
    JTextField insertNode;
    JButton insert;
    JTextField deleteNode;
    JButton delete;
    JButton clearTree;
    JButton loadTree;
    JButton saveTree;
    BinTree binTree;
    ViewTree viewTree;


    Controller(JTextField insertNode, JButton insert, JTextField deleteNode, JButton delete, JButton clearTree, JButton loadTree, JButton saveTree){
        this.insertNode = insertNode;
        this.insert = insert;
        this.deleteNode = deleteNode;
        this.delete = delete;
        this.clearTree = clearTree;
        this.loadTree = loadTree;
        this.saveTree = saveTree;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("insert")){
            System.out.println("bla irgendwas");
            String s = insertNode.getText();
            System.out.println(s);
            JButton jButton = new JButton();
            jButton.setLocation(500,380);
            jButton.setText(s);
            jButton.setVisible(true);
            viewTree.frame.add(jButton);
        }


    }
}
