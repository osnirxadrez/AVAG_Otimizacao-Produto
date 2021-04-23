package modelos;

import java.util.ArrayList;
import java.util.Random;

public class Individuo {
   public int[] cromossomo;
   public int tempo;
   public int valor;
   public int fitness;
   public int materiaprima;
   public double probabilidade;
   
   public void populaCromossomo(int qtItens) {
	   cromossomo = new int[qtItens];
	   for (int i=0; i<qtItens; i++) {
		   cromossomo[i] = sorteia();
	   }
   }
   
   public int sorteia() {
	   Random r = new Random();
	   return r.nextInt(401);
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
		   }
	   }
	   fitness = valor;
	   //penalidade fitness varia
	   if(tempo > 10000 || materiaprima > capacidadeProducao ) {
		   fitness -= 56000;
	   }
   }
   
   @Override
   public String toString() {
	   String ret = "";
	   for(int i : cromossomo) {
		   ret += i + "";
	   }
	   return ret + "- Fitness: "+ fitness+" tempo: "+tempo+" valor: "+valor+ " Probabilidade: "+probabilidade;
   }
   
}
