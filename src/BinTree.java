import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Francois on 07/02/2017.
 */
public class BinTree extends JPanel {

    public static ArrayList<String> list = new ArrayList<String>();
    public Node root = null;
    private int deepness;

    public void insert(String d){
        if (root == null){
            root = new Node(d);
            list.add(root.data);
        }
        else {
            insertRek(root, d);
        }
    }

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
    }


    public void remove(String wert){
//        list.remove(wert);
        for (int i = 0; i < list.size(); i++){
            list.remove(wert);
//            System.out.println(list.get(i));
        }
        if(this.root == null){
            return;
        }
        this.root = remove(wert, this.root);
    }

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

    private Node findLowestLeft(Node node){
        if (node.left == null){
            return node;
        }
        else {
            return findLowestLeft(node.left);
        }
    }

    private Node deleteLowestLeft(Node node){
        if (node.left == null){
            return node.right;
        }
        node.left = deleteLowestLeft(node.left);
        return node;
    }

    public void deleteTree(){
        list.clear();
        root = null;
    }

    public void output(){
        System.out.println("----- Tree -----\n");
//        System.out.println("Anzahl der Elemente im Baum: " + list.size());
        deepness = 0;
        design(root);
    }

    private void design(Node node){
        if (node != null){
            deepness++;
            design(node.right);
            deepness--;
            for (int i = 0; i < deepness; i++){
                System.out.print("   ");
            }
            System.out.println(" <- " + node.data);
            deepness++;
            design(node.left);
            deepness--;
        }
    }

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

    public void loadTree(){
        BufferedReader bufferedReader;
        String l;

        list.clear();
        root = null;

//        System.out.println(list.size());
        try {
            bufferedReader = new BufferedReader(new FileReader("tree.txt"));
            while ((l = bufferedReader.readLine()) != null){
                list.add(l);
            }
//            System.out.println(list.size());
            bufferedReader.close();
        }
        catch (IOException e){
            System.out.println("Fehler beim Laden der Datei");
        }
    }

}