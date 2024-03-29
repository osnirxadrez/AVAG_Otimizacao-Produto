package modelos;

import java.util.ArrayList;
import java.util.Random;

public class Pais {

	public ArrayList<Individuo> individuos = new ArrayList<Individuo>();
	
	public void populaListaPais(int qtpais, Roleta roleta) {
		int qtInseridos = 0;
		while(qtInseridos < qtpais) {
			Individuo pai = roleta.sorteia();
			if(podeInserirPai(pai)) {
				individuos.add(pai);
				qtInseridos++;
			}
		}
	}
	
	public boolean podeInserirPai(Individuo novo) {
		for(Individuo ind:individuos) {
			if (ind.verificaClone(novo))
				return false;
		}
		return true;
	}
	
	
	public Populacao reproduz(int tamCromossomo) {
		Populacao p = new Populacao();
		p.individuos.addAll(individuos);
		
		Random r = new Random();
		int posrCrossover = r.nextInt(tamCromossomo);
		
		int pos = 0;
		while(pos < individuos.size()-1) {
			Individuo pai1 = individuos.get(pos);
			Individuo pai2 = individuos.get(pos+1);
			Individuo[] filhos = fazCrossover(posrCrossover, pai1, pai2);
			p.individuos.add(filhos[0]);
			p.individuos.add(filhos[1]);
			pos+=2;
			
		}
	  //  p.mutacao();
		System.out.println("Crossover: "+posrCrossover);
		return p;
	}	
	
		
	public Individuo[] fazCrossover(int pos, Individuo pai1, Individuo pai2) {
		Individuo[] filhos = new Individuo[2];
		
		Individuo f1 = new Individuo();
		f1.cromossomo = new int[pai1.cromossomo.length];
		
		Individuo f2 = new Individuo();
		f2.cromossomo = new int[pai2.cromossomo.length];
		
		for(int i=0; i<pos;i++) {
			f1.cromossomo[i] = pai1.cromossomo[i];
			f2.cromossomo[i] = pai2.cromossomo[i];
		}
		for(int i=pos; i<pai1.cromossomo.length;i++) {
			f1.cromossomo[i] = pai2.cromossomo[i];
			f2.cromossomo[i] = pai1.cromossomo[i];
		}
		
		filhos[0] = f1;
		filhos[1] = f2;
		
		return filhos;
	}
	
		
}
