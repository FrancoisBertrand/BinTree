import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Francois on 07/02/2017.
 */
public class Controller implements ActionListener {

    JButton randomTree;
    JTextField insertNode;
    JButton insert;
    JTextField deleteNode;
    JButton delete;
    JButton clearTree;
    JButton loadTree;
    JButton saveTree;
    BinTree binTree;


    Controller(JButton randomTree, JTextField insertNode, JButton insert, JTextField deleteNode, JButton delete, JButton clearTree, JButton loadTree, JButton saveTree, BinTree binTree){
        this.binTree = binTree;
        this.randomTree = randomTree;
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
        if (e.getActionCommand().equals("insertNode")){

        }



    }
}
