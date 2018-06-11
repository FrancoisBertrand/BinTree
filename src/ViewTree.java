import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Francois on 07/02/2017.
 * MaNr: 553643
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
    JPanel panel;
    static JTextArea textArea;

    /**
     * Konstruktor zur darstellung aller wichtiger elemente
     */
    ViewTree() {

        frame = new JFrame("Binary Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMaximumSize(new Dimension(700, 500));
        frame.setMinimumSize(new Dimension(700, 500));
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        insertNode = new JTextField();
        insertNode.setSize(100, 35);
        insertNode.setLocation(0, 0);
        insertNode.setActionCommand("insertNode");
        frame.add(insertNode);

        insert = new JButton("insert node");
        insert.setSize(100, 35);
        insert.setLocation(100, 0);
        insert.setActionCommand("insert");
        frame.add(insert);

        deleteNode = new JTextField();
        deleteNode.setSize(100, 35);
        deleteNode.setLocation(200, 0);
        deleteNode.setActionCommand("deleteNode");
        frame.add(deleteNode);

        delete = new JButton("delete node");
        delete.setSize(100, 35);
        delete.setLocation(300, 0);
        delete.setActionCommand("delete");
        frame.add(delete);

        clearTree = new JButton("clear tree");
        clearTree.setSize(100, 35);
        clearTree.setLocation(400, 0);
        clearTree.setActionCommand("clearTree");
        frame.add(clearTree);

        loadTree = new JButton("load tree");
        loadTree.setSize(100, 35);
        loadTree.setLocation(500, 0);
        loadTree.setActionCommand("loadTree");
        frame.add(loadTree);

        saveTree = new JButton("save tree");
        saveTree.setSize(100, 35);
        saveTree.setLocation(600, 0);
        saveTree.setActionCommand("saveTree");
        frame.add(saveTree);

        Controller controller = new Controller(insertNode, insert, deleteNode, delete, clearTree, loadTree, saveTree);
        insertNode.addActionListener(controller);
        insert.addActionListener(controller);
        deleteNode.addActionListener(controller);
        delete.addActionListener(controller);
        clearTree.addActionListener(controller);
        loadTree.addActionListener(controller);
        saveTree.addActionListener(controller);

        textArea = new JTextArea();
        textArea.setLocation(0,35);
        textArea.setSize(700,465);
        textArea.setBackground(Color.cyan);
        textArea.setVisible(true);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 15));
        textArea.setEditable(false);
        frame.add(textArea);

        frame.pack();
        frame.setVisible(true);
    }
}



