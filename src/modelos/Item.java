package modelos;

import javax.swing.JOptionPane;

public class Item {
 
   public int valor;
   public int tempo;
   
   
   public Item() {
	   valor = Integer.parseInt(JOptionPane.showInputDialog("Valor"));
	   tempo = Integer.parseInt(JOptionPane.showInputDialog("tempo"));
   }
   
   public Item(int valor, int tempo) {
	  this.valor = valor;
	  this.tempo = tempo;
   }
   
   
}
