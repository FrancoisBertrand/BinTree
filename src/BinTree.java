import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

/**
 * Created by Francois on 07/02/2017.
 * MaNr: 553643
 */
public class BinTree extends JPanel {

    public static ArrayList<String> list = new ArrayList<String>();
    public Node root = null;
    private int deepness;
    ViewTree viewTree;

    /**
     * Methode zum einfuegen der Knoten bzw. ihrer Werte als Strings
     * sie ruft eine Rekursive Methode zum einfuegen auf
     * @param d = wert eines Knotens mit dem Datentyp String
     */
    public void insert(String d){
        if (root == null){
            root = new Node(d);
            list.add(root.data);
        }
        else {
            insertRek(root, d);
        }
    }

    /**
     * Rekursiver aufruf zum einfuegen der Knoten und ihrere Werte
     * @param node Knoten
     * @param d Stringwert
     */
    private void insertRek(Node node, String d){
        if (d.compareTo(node.data) < 0){
            if (node.left == null){
                node.left = new Node(d);
                list.add(node.left.data);
            }
            else {
                insertRek(node.left, d);
            }
        }
        else if (d.compareTo(node.data) > 0){
            if ((node.right == null)){
                node.right = new Node(d);
                list.add(node.right.data);
            }
            else {
                insertRek(node.right, d);
            }
        }
        else if (d.compareTo(node.data) == 0){
            System.out.println("Knoten gibt es schon");
        }
    }

    /**
     * Methode ruft eine rekursive Methoden zum entfernen des gewuenschten Elements auf
     * @param wert der zu entfernende Wert
     */
    public void remove(String wert){
        for (int i = 0; i < list.size(); i++){
            list.remove(wert);
        }
        if(this.root == null){
            return;
        }
        this.root = remove(wert, this.root);
    }

    /**
     * Methode durchsucht den gesamten Binarbaum und entfernt das Element (rekursiv)
     * @param wert der zu entfernende wert
     * @param node der aktuell besuchte Knoten
     * @return gibt den Wurzelknoten ohne zu entfernenden Wert zerueck
     */
    private Node remove(String wert, Node node){
        if (node.data.compareTo(wert) > 0){
            node.left = remove(wert, node.left);
        }
        else  if (node.data.compareTo(wert) < 0){
            node.right = remove(wert, node.right);
        }
        else {
            if (node.right == null){
                return node.left;
            }
            if (node.left == null){
                return node.right;
            }
            Node tmp = node;
            node = findLowestLeft(tmp.right);
            node.right = deleteLowestLeft(tmp.right);
            node.left = tmp.left;
        }
        return node;
    }

    /**
     * sucht den niedrigsten linken Knoten im rechten Teilbaum des Knoten
     * @param node der aktuell durchsuchte Teilbaum / Knoten
     * @return gibt den niedrigsten linken Knoten im rechten Teilbaum des Knoten zureuck
     */
    private Node findLowestLeft(Node node){
        if (node.left == null){
            return node;
        }
        else {
            return findLowestLeft(node.left);
        }
    }

    /**
     * entfernt den angebenen Teilbaum / Knoten
     * @param node der zu entfernende Knoten
     * @return gibt den geaenderten Rechten Teilbaum zurueck
     */
    private Node deleteLowestLeft(Node node){
        if (node.left == null){
            return node.right;
        }
        node.left = deleteLowestLeft(node.left);
        return node;
    }

    /**
     * loescht den gesamten Baum
     * erstellt einen Leeren Baum
     */
    public void deleteTree(){
        list.clear();
        root = null;
    }

    /**
     * Methode zum ausgeben des Baumes
     */
    public void output(){
        System.out.println("----- Tree -----\n");
        deepness = 0;
        viewTree.textArea.setText("");
        design(root);
    }

    /**
     * gibt die Knoten bzw Werte der Knoten auf der Konsole und auf
     * der Textarea in der View aus
     * @param node aktuell besuchter Knoten / Teilbaum
     */
    private void design(Node node){
        if (node != null){
            deepness++;
            design(node.right);
            deepness--;
            for (int i = 0; i < deepness; i++){
                System.out.print("   ");
                viewTree.textArea.append("      ");
            }
            System.out.println(" <- " + node.data);
            viewTree.textArea.append(" <- " + node.data + "\n");
            deepness++;
            design(node.left);
            deepness--;
        }
    }


    /**
     * Methode speichert / schreibt die Werte der Knoten in eine Textdatei
     */
    public void saveTree(){
        BufferedWriter bufferedWriter;
        String s;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter("tree.txt"));
            for (int i = 0; i < list.size(); i++){
                s = list.get(i);
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
        catch (IOException e){
            System.out.println("Fehler beim lesen der Datei");
        }
    }

    /**
     * Methode liest die Werte aus der Textdatei und speichert diese
     * in die Arrayliste
     */
    public void loadTree(){
        BufferedReader bufferedReader;
        String l;

        list.clear();
        root = null;

        try {
            bufferedReader = new BufferedReader(new FileReader("tree.txt"));
            while ((l = bufferedReader.readLine()) != null){
                list.add(l);
            }
             bufferedReader.close();
        }
        catch (IOException e){
            System.out.println("Fehler beim Laden der Datei");
        }
    }
}