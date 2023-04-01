package projetro;
import java.io.*;
import java.lang.*;
import java.text.DecimalFormat;
import java.util.Scanner;
import static javafx.scene.input.KeyCode.S;

public class ProjetRO {
    
   //structure represent l'arc avec le sommet soure et sommet destination et le poids de l'arc
	static class arc {
		int src, dest;double poid;
	}
	static class Graph {
		int S, A;  //les sommets et les arcs
		// graph representer comme tableau des arc.
		arc arc[];
	}
	// creation de graph 
	static Graph createGraph(int S, int A) {
		Graph graph = new Graph();
		graph.S = S;// nombre des sommets
		graph.A = A;// nombre des arcs
		graph.arc = new arc[graph.A];

		for (int i = 0; i < graph.A; i++) /* i inférieur du nombre des arcs */ {
			graph.arc[i] = new arc();
		}return graph;
	}
	// fonction cherche le plus court shemin de source vers tous les sommets utilisant
        //l'algorithme de belman-ford et qui detecte le circuit absorbant
        // Début d'Algorithme de Bellman-Ford
	void isNegCycleBellmanFord(Graph graph, int src) {
		int S = graph.S;
		int A = graph.A;
		double[] dist = new double[S];
                

		//initialisation distance source vers tous les sommet par infinité
		for (int i = 0; i < S; i++)
			dist[i] = Double.MAX_VALUE;
		dist[src] = 0;
           //calcul de la distance     
		for (int i = 1; i <= S - 1; i++) {
			for (int j = 0; j < A; j++) {
				int u = graph.arc[j].src;
				int v = graph.arc[j].dest;
				double poid = graph.arc[j].poid;
				if (dist[u] != Double.MAX_VALUE && dist[u] + poid < dist[v])
                                	dist[v] = dist[u] + poid;
                               
			}    
		}
		//chercher un circuit absorbant
		for (int i = 0; i < A; i++) {
			int u = graph.arc[i].src;
			int v = graph.arc[i].dest;
			double poid = graph.arc[i].poid;    
			if (dist[u] != Double.MAX_VALUE && dist[u] + poid < dist[v])
                          
                              System.out.println("Le graphe contient un cycle de poids négatif");
                            
}         
}

		
	public static void main(String[] args) {
		int S = 5, A = 20; //sommets et arcs
		Graph graph = createGraph(S, A);
      //Fin d'Algorithme de Bellman-Ford
      
	//////////remplissage de graphe de l'utilisateur
for(int i=0; i<20;i++){
    int src,dst;double w;
    //Les sources (usd=0   euro=1  GBP=2  CHF=3   CAD=4 )
	System.out.print(" donner le sommet source : ");	 
    
             Scanner som=new Scanner(System.in);  
		 src=som.nextInt();
                 graph.arc[i].src = src;
                 System.out.print(" donner le sommet destination : ");
                  Scanner desti=new Scanner(System.in);  
		dst=desti.nextInt();
		graph.arc[i].dest = dst;
                System.out.print(" donner le poids de l'arc : "); 
                Scanner p=new Scanner(System.in);  
		 w=p.nextDouble();
		//remplace chaque poids par -ln(w)	
		/*poids*/ graph.arc[i].poid = -Math.log(w);
                 
}                      
                DecimalFormat df = new DecimalFormat("#.####"); //Pour afficher 4 nombres après la virgule  
                for(int i=0; i<20; i++)  //il y a 20 arcs et 5 sommets
                {
                    String a="USD",b="EURO",c="GBP",d="CHF",e="CAD";
                  
                    if(graph.arc[i].src == 0) //Si la source=0 cvdr USD
                    {
                        if(graph.arc[i].dest == 1) /* Si la source =0 et la destination =1 alors a-b cvdr USD-EURO */{
                       System.out.println(a+" ---> "+b+": "+df.format(graph.arc[i].poid));} //df.format---Pour afficher certains nombres après la virgule
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(a+" ---> "+c+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(a+" ---> "+d+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(a+" ---> "+e+": "+df.format(graph.arc[i].poid));}
                    }
                    
                      if(graph.arc[i].src == 1)
                    {
                        if(graph.arc[i].dest == 0){
                       System.out.println(b+" ---> "+a+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(b+" ---> "+c+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(b+" ---> "+d+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(b+" ---> "+e+": "+df.format(graph.arc[i].poid));}
                    }
                        if(graph.arc[i].src == 2)
                    {
                        if(graph.arc[i].dest == 1){
                       System.out.println(c+" ---> "+b+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 0){
                       System.out.println(c+" ---> "+a+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(c+" ---> "+d+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(c+" ---> "+e+": "+df.format(graph.arc[i].poid));}
                    }
                          if(graph.arc[i].src == 3)
                    {
                        if(graph.arc[i].dest == 1){
                       System.out.println(d+" ---> "+b+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(d+" ---> "+c+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 0){
                       System.out.println(d+" ---> "+a+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(d+" ---> "+e+": "+df.format(graph.arc[i].poid));}
                    }
                            if(graph.arc[i].src == 4)
                    {
                        if(graph.arc[i].dest == 1){
                       System.out.println(e+" ---> "+b+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(e+" ---> "+c+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(e+" ---> "+d+": "+df.format(graph.arc[i].poid));}
                        else  if(graph.arc[i].dest == 0){
                       System.out.println(e+" ---> "+a+": "+df.format(graph.arc[i].poid));}
                    }
                }
          
        }}