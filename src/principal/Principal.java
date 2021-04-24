package principal;

import java.util.ArrayList;

import modelos.Individuo;
import modelos.Item;
import modelos.Pais;
import modelos.Populacao;
import modelos.Roleta;

public class Principal {
	
	static ArrayList<Item> itens = new ArrayList<Item>();
	static Populacao populacao = new Populacao();
	static int capacidadeProducao;
	static int qtPorGeracao;


	public static void main(String[] args) {
			
		iniciaParaTestes();
	    criaPopulacao();
	    populacao.calculaProbabilidades();
	    System.out.println("******POPULAÇÃO INICIAL*****");
	    System.out.println("                              ");
	    for (Individuo ind : populacao.individuos) {
	     	 System.out.println(ind);
    	 }
	    
	     Roleta roleta = new Roleta(populacao);	    
	     Pais pais = new Pais();
	     pais.populaListaPais(qtPorGeracao/2, roleta);
	     	     
	   /* IMPRIME PAIS
	     System.out.println("*****************************************");
	     for (Individuo ind : pais.individuos) {
			System.out.println(ind);
		}
	     */
	     Populacao nova = pais.reproduz(itens.size());
	     nova.calculaFitness2(itens, capacidadeProducao);
	     nova.calculaProbabilidades();
	    for(int i=0;i<=3;i++) {
	    	
	    
	     
	     Roleta roletanova = new Roleta(nova);	 
	     Pais paisnova = new Pais();
	     paisnova.populaListaPais(qtPorGeracao/2, roletanova);
	     nova = paisnova.reproduz(itens.size());
	     nova.calculaFitness2(itens, capacidadeProducao);
	     nova.calculaProbabilidades();
	      
	    	// IMPRIMI NOVA POPULAÇÃO
	    	 System.out.println("*****************************************");
	    	 System.out.println("******POPULAÇÃO "+(i+1)+"*****");
	 	    System.out.println("                              ");
		     for (Individuo ind : nova.individuos) {
		     	 System.out.println(ind);
	    	       }
	      
	     }
	    Individuo menorind = nova.individuos.get(0);
	    for (Individuo ind : nova.individuos) {
	    	int menor = nova.individuos.get(0).fitness;
	    	if(ind.fitness< menor) {
	    	   menorind=ind;
	    	}
   	       }
	    System.out.println("                              ");
	    System.out.println("O melhor resultado é com a venda de  "+menorind.cromossomo[0]+" Sandálias, "+
	    menorind.cromossomo[1]+" Sapatos Masculinos, "+menorind.cromossomo[2]+" Botas Femininas e "+menorind
	    .cromossomo[3]+" Sapatos Femininos, Somando um lucro total de "+menorind.lucro);
	    
	    
	     
	    
	}
	
	static void iniciaParaTestes() {
		capacidadeProducao = 400;
		qtPorGeracao = 10;
		itens.add(new Item(100, 20, 60));
		itens.add(new Item(120, 30, 80));
		itens.add(new Item(150, 25, 90));
		itens.add(new Item(120, 28, 50));
		
	}	
	
	
	static void criaPopulacao() {
		populacao.montaPopulacao(qtPorGeracao, itens.size(), capacidadeProducao);
		populacao.calculaFitness2(itens, capacidadeProducao);
	}

}
