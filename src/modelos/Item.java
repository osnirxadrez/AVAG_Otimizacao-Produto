package modelos;

import javax.swing.JOptionPane;

public class Item {
 
   public int valor;
   public int tempo;
   public int lucro;
   
   
   public Item() {
	   valor = Integer.parseInt(JOptionPane.showInputDialog("Valor"));
	   tempo = Integer.parseInt(JOptionPane.showInputDialog("tempo"));
	   lucro = Integer.parseInt(JOptionPane.showInputDialog("lucro"));
   }
   
   public Item(int valor, int tempo, int lucro) {
	  this.valor = valor;
	  this.tempo = tempo;
	  this.lucro = lucro;
   }
   
   
}
