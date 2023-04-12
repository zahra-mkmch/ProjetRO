package projetroarbitrage;
import java.io.*;
import java.lang.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ProjetROArbitrage {
    
   //structure represent l'arc avec le sommet soure et sommet destination et le poids de l'arc
	static class arc {
		int src, dest;
                double poid;
	}
	static class Graph {
		int S, A;  //les sommets et les arcs
		arc arc[]; // graph representer comme tableau des arc.
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
	// fonction cherche le plus court chemin de source vers tous les sommets utilisant
        //l'algorithme de belman-ford et qui detecte le circuit absorbant
        // Début d'Algorithme de Bellman-Ford  du: (https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/)
	static boolean BellmanFord(Graph graph, int src) {
		int S = graph.S;
		int A = graph.A;
		double[] dist = new double[S];
                 double gg=0;
		Graph g = createGraph(S, A);

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
                                {	dist[v] = dist[u] + poid;
                             
                               }
			}    
		}
        
//cherche circuit absorbant
		for (int i = 0; i < A; i++) {
			int u = graph.arc[i].src;
			int v = graph.arc[i].dest;
			double poid = graph.arc[i].poid;
                                               
			if (dist[u] != Double.MAX_VALUE && dist[u] + poid < dist[v]){
			
				return true;}
		}
		return false;  }
	
	public static void main(String[] args) {
		int S = 5, A = 20; //5 sommets et 20 arcs
		Graph graph = createGraph(S, A);
      //Fin d'Algorithme de Bellman-Ford
      
     //remplissage de graphe de l'utilisateur
for(int i=0; i<20;i++){
    int src,dst;double w;
    //Les sources (usd=0   euro=1  GBP=2  CHF=3   CAD=4 )
	     System.out.print(" Entrez le sommet source : ");	 
             Scanner som=new Scanner(System.in);  
             src=som.nextInt();
             
             System.out.print(" Entrez le sommet destination : ");
             Scanner desti=new Scanner(System.in); 
             dst=desti.nextInt();
             
             System.out.print(" Entrez le poids de l'arc : "); 
             Scanner p=new Scanner(System.in); 
             w=p.nextDouble();
             
             graph.arc[i].src = src;
	     graph.arc[i].dest = dst;
		
   /*poids*/ graph.arc[i].poid = -Math.log(w);	//remplace chaque poids par -ln(w)
                     
}                      
                DecimalFormat df = new DecimalFormat("#.####"); //Pour afficher 4 nombres après la virgule  
                for(int i=0; i<20; i++)  //il y a 20 arcs et 5 sommets
                {
                    String USD="USD",EURO="EURO",GBP="GBP",CHF="CHF",CAD="CAD";
                   double poi=graph.arc[i].poid;
                    if(graph.arc[i].src == 0) //Si la source=0 cvdr le sommet USD
                    {
                        if(graph.arc[i].dest == 1) /* Si la source =0 et la destination =1 alors a-b cvdr USD-->EURO */{
                       System.out.println(USD+" ---> "+EURO+": "+df.format(poi));} //df.format---Pour afficher certains nombres après la virgule
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(USD+" ---> "+GBP+": "+df.format(poi));} //USD--->GBP
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(USD+" ---> "+CHF+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(USD+" ---> "+CAD+": "+df.format(poi));}
                    }
                    
                      if(graph.arc[i].src == 1)
                    {
                        if(graph.arc[i].dest == 0){
                       System.out.println(EURO+" ---> "+USD+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(EURO+" ---> "+GBP+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(EURO+" ---> "+CHF+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(EURO+" ---> "+CAD+": "+df.format(poi));}
                    }
                      
                        if(graph.arc[i].src == 2)
                    {
                        if(graph.arc[i].dest == 1){
                       System.out.println(GBP+" ---> "+EURO+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 0){
                       System.out.println(GBP+" ---> "+USD+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(GBP+" ---> "+CHF+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(GBP+" ---> "+CAD+": "+df.format(poi));}
                    }
                          if(graph.arc[i].src == 3)
                    {
                        if(graph.arc[i].dest == 1){
                       System.out.println(CHF+" ---> "+EURO+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(CHF+" ---> "+GBP+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 0){
                       System.out.println(CHF+" ---> "+USD+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 4){
                       System.out.println(CHF+" ---> "+CAD+": "+df.format(poi));}
                    }
                            if(graph.arc[i].src == 4)
                    {
                        if(graph.arc[i].dest == 1){
                       System.out.println(CAD+" ---> "+EURO+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 2){
                       System.out.println(CAD+" ---> "+GBP+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 3){
                       System.out.println(CAD+" ---> "+CHF+": "+df.format(poi));}
                        else  if(graph.arc[i].dest == 0){
                       System.out.println(CAD+" ---> "+USD+": "+df.format(poi));}
                    }
                       
                }
                //appel de la fonction Bellman-Ford
          	if (BellmanFord(graph, 0)) {
			System.out.println("il y a un circuit absorbant");
                
                }else{
                    System.out.println("il n'y a pas un circuit absorbant");
                }
               
		
	}
       
        } 
