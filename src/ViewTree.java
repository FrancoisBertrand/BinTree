import javax.swing.*;
import java.awt.*;

/**
 * Created by Francois on 07/02/2017.
 */
public class ViewTree extends JFrame {

    static JFrame frame;
    JButton randomTree;
    JTextField insertNode;
    JButton insert;
    JTextField deleteNode;
    JButton delete;
    JButton clearTree;
    JButton loadTree;
    JButton saveTree;
    BinTree binTree;


    ViewTree(BinTree binTree){

        this.binTree = binTree;

        frame = new JFrame("Binary Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMaximumSize(new Dimension(1000,800));
        frame.setMinimumSize(new Dimension(1000,800));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setLayout(null);

        randomTree = new JButton("random tree");
        randomTree.setSize(100,35);
        randomTree.setLocation(0,0);
        randomTree.setVisible(true);
        randomTree.setActionCommand("randomTree");
        frame.add(randomTree);

        insertNode = new JTextField();
        insertNode.setSize(100,35);
        insertNode.setLocation(200,0);
        insertNode.setVisible(true);
        insertNode.setActionCommand("insertNode");
        frame.add(insertNode);

        insert = new JButton("insert node");
        insert.setSize(100,35);
        insert.setLocation(300,0);
        insert.setVisible(true);
        insert.setActionCommand("insert");
        frame.add(insert);

        deleteNode = new JTextField();
        deleteNode.setSize(100,35);
        deleteNode.setLocation(400,0);
        deleteNode.setVisible(true);
        deleteNode.setActionCommand("deleteNode");
        frame.add(deleteNode);

        delete = new JButton("delete node");
        delete.setSize(100,35);
        delete.setLocation(500,0);
        delete.setVisible(true);
        delete.setActionCommand("delete");
        frame.add(delete);

        clearTree = new JButton("clear tree");
        clearTree.setSize(100,35);
        clearTree.setLocation(700,0);
        clearTree.setVisible(true);
        clearTree.setActionCommand("clearTree");
        frame.add(clearTree);

        loadTree = new JButton("load tree");
        loadTree.setSize(100,35);
        loadTree.setLocation(800,0);
        loadTree.setVisible(true);
        loadTree.setActionCommand("loadTree");
        frame.add(loadTree);

        saveTree = new JButton("save tree");
        saveTree.setSize(100,35);
        saveTree.setLocation(900,0);
        saveTree.setVisible(true);
        saveTree.setActionCommand("saveTree");
        frame.add(saveTree);

        Controller controller = new Controller(randomTree,insertNode,insert, deleteNode, delete, clearTree, loadTree, saveTree, binTree);
        randomTree.addActionListener(controller);
        insertNode.addActionListener(controller);
        insert.addActionListener(controller);
        deleteNode.addActionListener(controller);
        delete.addActionListener(controller);
        clearTree.addActionListener(controller);
        loadTree.addActionListener(controller);
        saveTree.addActionListener(controller);

        

        frame.pack();
    }
}


