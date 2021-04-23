package modelos;

import java.util.ArrayList;
import java.util.Random;

public class Individuo {
   public int[] cromossomo;
   public int tempo;
   public int valor;
   public int lucro;
   public int fitness;
   public int materiaprima;
   public double probabilidade;
   
   public void populaCromossomo(int qtItens, int qtProducao) {
	   cromossomo = new int[qtItens];
	   //sorteia cada gen de acordo com estoque disponivel	   
	  cromossomo[0] = sorteia(qtProducao + 1);	  
	  qtProducao=qtProducao-cromossomo[0];
	  
	  cromossomo[1] = sorteia(qtProducao+1);
	  qtProducao=qtProducao-cromossomo[1];
	  
	  cromossomo[2] = sorteia(qtProducao+1);
	  qtProducao=qtProducao-cromossomo[2];
	  
	  cromossomo[3] = sorteia(qtProducao+1);
	  
	   
   }
     public int sorteia(int estoque) {
	   Random r = new Random();
	   return r.nextInt(estoque);
   }
  //verifica se  é mesmo cromossomo
   public boolean verificaClone(Individuo outro) {
	
	   for(int i=0; i<cromossomo.length; i++) {
		   if(cromossomo[i] != outro.cromossomo[i])
			   return false;
	   }
	   
	   return true;
   }
   
   public void calculaFitness(ArrayList<Item> itens, int capacidadeProducao) {
	   materiaprima=0;
	   for(int i=0; i<cromossomo.length; i++) {
		   int gene = cromossomo[i];
		   if(gene != 0 ) {
			  materiaprima=materiaprima+ gene;
			   tempo+=gene*itens.get(i).tempo;
			   valor+=gene*itens.get(i).valor;	
			   lucro+=gene*itens.get(i).lucro;
			   
		   }
	   }
	   fitness = lucro;
	   //penalidade fitness varia
	   if(tempo > 10000 || materiaprima > capacidadeProducao || valor > 50000 ) {
		   fitness -= 23000;
	   }
   }
   
   @Override
   public String toString() {
	   String ret = "";
	   for(int i : cromossomo) {
		   ret += i + " ";
	   }
	   return ret + "- Fitness: "+ fitness+" tempo: "+tempo+" valor: "+valor+ " LUCRO: "+lucro+" Probabilidade: "+probabilidade;
   }
   
}
