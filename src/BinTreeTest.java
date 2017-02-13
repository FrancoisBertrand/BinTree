import javax.swing.*;
import Prog1Tools.IOTools;

/**
 * Created by Francois on 07/02/2017.
 */

public class BinTreeTest {

    public static void main(String[] args) {

        BinTree binTree = new BinTree();

        ViewTree viewTree = new ViewTree(binTree);


        while (true){
            System.out.println("################## Menü ###################\n");
            System.out.println("1) Knoten hinzufügen: ");
            System.out.println("2) Baum ausgeben: ");
            System.out.println("3) Knoten löschen: ");
            System.out.println("4) Baum löschen: ");
            System.out.println("5) Baum speichern: ");
            System.out.println("6) Baum laden: ");

            System.out.println("7) Programm beenden");

            int auswahl = IOTools.readInteger();
            if (auswahl < 1 && auswahl >7){
                System.out.println("Falsche eingabe");
            }else {
                switch (auswahl){
                    case 1:
                        System.out.println("Bitte tragen Sie einen Wert für den Knoten ein: ");
                        String wert = IOTools.readLine();
                        binTree.insert(wert);
                        System.out.println("\n");
                        break;
                    case 2:
                        for (int i = 0; i < binTree.list.size(); i++){
                            binTree.insert(binTree.list.get(i));
                        }
                        binTree.output();
                        System.out.println("\n");
                        break;
                    case 3:
                        System.out.println("Bitte zu löschenden Wert eingeben: ");
                        binTree.output();
                        String del = IOTools.readLine();
                        binTree.remove(del);
                        binTree.output();
                        break;
                    case 4:
                        binTree.deleteTree();
                        System.out.println("Baum ist gelöscht");
                        break;
                    case 5:
                        binTree.saveTree();
                        System.out.println("Baum ist gespeichert");
                        break;
                    case 6:
                        binTree.loadTree();
                        break;
                    case 7:
                        System.out.println("Programm Beendet!");
                        System.exit(0);
                        break;
                }
            }
        }
    }
}
