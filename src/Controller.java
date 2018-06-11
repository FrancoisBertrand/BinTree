import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Created by Francois on 07/02/2017.
 * MaNr: 553643
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
    BinTree binTree = new BinTree();
    ViewTree viewTree;


    /**
     * Konstruktor, der alle Viewelemente die auf ein Event warten übergeben bekommt
     * @param insertNode Textfeld zum hinzufuegen
     * @param insert hinzufuegen eines Wertes
     * @param deleteNode Textfeld zum entfernen
     * @param delete entfernen eines Wertes
     * @param clearTree loeschen aller Werte
     * @param loadTree lesen aller gespeicherten Werte
     * @param saveTree schreiben aller aktuellen Werte
     */
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
        // knoten hinzufuegen + ausgabe
        if (e.getActionCommand().equals("insert")){
            binTree.insert(insertNode.getText());
            binTree.output();
        }

        // knoten entfernen + ausgabe
        if (e.getActionCommand().equals("delete")){
            binTree.remove(deleteNode.getText());
            binTree.output();
        }

        // baum loeschen + ausgabe
        if (e.getActionCommand().equals("clearTree")){
            binTree.deleteTree();
            binTree.output();
        }

        // baum speichern
        if (e.getActionCommand().equals("saveTree")){
            binTree.saveTree();
        }

        // baum laden + ausgabe
        if (e.getActionCommand().equals("loadTree")){
            binTree.loadTree();
            for (int i = 0; i < binTree.list.size(); i++) {
                binTree.insert(binTree.list.get(i));
            }
            binTree.output();
        }






    }
}
