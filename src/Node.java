/**
 * Created by Francois on 07/02/2017.
 * MaNr: 553643
 */

public class Node {

   String data;
   Node left;
   Node right;

    /**
     * Konstruktor mit einem Parameter als wert fuer einen Knoten
     * @param data String als Datentyp
     */
   Node(String data){
       this.data = data;
       left = null;
       right = null;
   }
}