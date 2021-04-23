package modelos;

import java.util.ArrayList;
import java.util.Random;

public class Populacao {
        
	public ArrayList<Individuo> individuos = new ArrayList<Individuo>();
	
	public void montaPopulacao(int qtIndividuos, int qtItens, int capacidadeProducao) {
		int qtInseridos = 0;
		while(qtInseridos < qtIndividuos) {
			Individuo ind = new Individuo();
			ind.populaCromossomo(qtItens, capacidadeProducao);
			if(podeInserirListaIndividuos(ind));{
			individuos.add(ind);
			qtInseridos++;
			}
		}
	}
	
	public boolean podeInserirListaIndividuos(Individuo novo) {
		for(Individuo ind:individuos) {
			if (ind.verificaClone(novo))
				return false;
		}
		return true;
	}
	
	public void calculaFitness2(ArrayList<Item> itens, int capacidadeProducao) {
		for (Individuo individuo : individuos) {
			individuo.calculaFitness(itens, capacidadeProducao);
		}
	}
	
	public int menorFitnessPopulacao() {
		int menor = individuos.get(0).fitness;
		for (Individuo ind : individuos) {
			if(ind.fitness < menor)
				menor = ind.fitness;
		}
		
		return menor;
	}
	
	public void calculaProbabilidades() {
		int soma = somaFitnessPopulacao();
		int menor = menorFitnessPopulacao();
		for (Individuo ind : individuos) {
			int temp = ind.fitness - menorFitnessPopulacao();
			temp = temp == 0 ? 1 : temp;
			ind.probabilidade = ((double)temp / (double)soma) *100.0;
		}
	}
	
	public int somaFitnessPopulacao() {
		int soma = 0;
		for (Individuo ind : individuos) {
			soma+= ind.fitness;
		}
		
		return soma;
	}
	public int somaProbabilidadePopulacao() {
		int soma = 0;
		for (Individuo ind : individuos) {
			soma+= ind.probabilidade;
		}
		
		return soma;
	}
	
	public void mutacao() {
		Random r = new Random();
		int indSorteado= r.nextInt(individuos.size()-1) ;		
		int genamutar=individuos.get(indSorteado).cromossomo[r.nextInt(4)];
		int genmutado= r.nextInt(401);
		
				
		individuos.get(indSorteado).cromossomo[genamutar]=genmutado;
	}
}
