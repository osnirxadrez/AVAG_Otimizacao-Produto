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
	    
	    for (Individuo ind : populacao.individuos) {
	     	 System.out.println(ind);
    	 }
	    
	     Roleta roleta = new Roleta(populacao);	    
	     Pais pais = new Pais();
	     pais.populaListaPais(qtPorGeracao/2, roleta);
	     	     
	    
	     System.out.println("*****************************************");
	     for (Individuo ind : pais.individuos) {
			System.out.println(ind);
		}
	     
	     Populacao nova = pais.reproduz(itens.size());
	     nova.calculaFitness2(itens, capacidadeProducao);
	     nova.calculaProbabilidades();
	     
	     System.out.println("*****************************************");
	     for (Individuo ind : nova.individuos) {
	     	 System.out.println(ind);
    	 }
	 
	}
	
	static void iniciaParaTestes() {
		capacidadeProducao = 400;
		qtPorGeracao = 20;
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
