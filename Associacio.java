import utilsPRAP.*;
import tadsPRAP.*;

class Associacio
{
	private Arbol arbre;
	private int[] requisits;
	final static int N=7;
	InOut io=new InOut();
	
	public Associacio (sistema sistem, InOut io) throws Exception
	{
		arbre=llegir_Associacio(sistem, io);
		io.write("fi arbre");
		requisits=llegir_requisits(io);
		io.write("fi llegir req");
	}
	
	private Arbol llegir_Associacio(sistema sistem, InOut io) throws Exception
	{ 
		Arbol b,c;
		int x=io.readint();
		Integer arrel= new Integer(x);
		if (x!=0)
		{
			sistem.afegir(x);
			b=llegir_Associacio (sistem,io);
			c=llegir_Associacio (sistem,io);
			b.plantar(arrel,c);
		}
		else
		{
			b=new Arbol();
			b.a_nulo();
		}
		return b;
	}

	private int[] llegir_requisits(InOut io) throws Exception
	{	
		int[] requisits;
		requisits=new int[8];
		int i=0;
		while (i<=7) {
			requisits[i]=io.readint();
			i++;
				}
	return requisits;
        }

	public void escriure_arbre(InOut io) throws Exception
	{
		escriure_arbre_int(arbre,io);
	}

	private void escriure_arbre_int (Arbol x, InOut io) throws Exception
	{
		Arbol aux1, aux2;
	
		if (!x.es_nulo())
		{
			aux1=new Arbol();
			aux2=new Arbol();

			try
			{
				aux1.hi(x);
				aux2.hd(x);
				escriure_arbre_int(aux1,io);
				Integer wraiz = (Integer) x.raiz();
				io.writeln(wraiz.intValue());
				escriure_arbre_int(aux2,io);
			}
			catch (EmptyTreeException e)
			{
			System.err.println("Error al escriure l'arbre");
			}
		}
	}

 public void afegir_planeta (int IdP, sistema sistem, InOut io) throws Exception
        {
            boolean b=false;
            int n=0;
            int IdC;
            int[] criteris_p;
            int i=0;

	IdC=sistem.Columna(IdP);
            
            criteris_p=sistem.consultar_criteris2(IdP);
            
            if (es_candidat(criteris_p)==true) {
                afegeix_candidat(arbre, IdP,i);
                n=1;
                sistem.afegir(IdP);
            }
            else {
                Afegeix_candidat_Padri(sistem, arbre, IdP,b,i);
                if(b=true){
                    n=2;
                    sistem.afegir(IdP);
                }
            }
            
            io.write(n);
        }
        
   private boolean es_candidat (int[] criteris_p) throws Exception
        {
            int i=0;
            boolean b=true;
            
            while((i<=N) && (b==true)){
                if (criteris_p[i]<requisits[i]) {
                                                b=false;}
                i++;
                }
            return b;
            }
            
            
 private boolean mitja (int IdP, int IdP2, sistema sistem) throws Exception
        {
            int i=0;
	    int c1=0;
            int c2=0;	
            boolean b=true;            
            while ((i<=7) && (b=true)){
		c1=sistem.consultar_criteri2(IdP,i);
		c2=sistem.consultar_criteri2(IdP,i);
                b=((requisits[i]<=(c1+c2))||(requisits[i]<=c1));
                i++;
            }
            return b;
            }
  
public void modificar_requisits (InOut io) throws Exception
        {
            int i=1;
            int b=0;
            int a=io.readint();
            while (i<=a){
                b=io.readint();
                requisits[b]=io.readint();
                i++;
            }
        }

private boolean es_fulla(Arbol arbre) throws Exception
        {
            boolean b=false;
            Arbol arb1;
            Arbol arb2;
	    arb1=new Arbol();
	    arb2=new Arbol();
            arb1.hi(arbre);
            arb2.hd(arbre);
            if ((arb1.es_nulo()==true) && (arb2.es_nulo()==true)) {
                b=true;
            }
            return b;
        }
        
        
public void Treure1(sistema sistem,int IdP, InOut io) throws Exception
        {
            int i;
            if (sistem.pertany2(IdP)==false){
                i=0;
            }
            else {
	    	i=0;
                Treure2(sistem, arbre, IdP,i);
                if (i==1){
                    sistem.treure(IdP);
		 
                }
                }
        io.writeln(i);
        }
        
private void afegeix_candidat (Arbol arbre, int IdP, int i) throws Exception
        {
            Arbol arb1;
            Arbol arb2;
            Arbol arb3;
            Arbol arb4;
            Arbol arb5;
            arb1=new Arbol();
            arb2=new Arbol();
            arb3=new Arbol();
            arb4=new Arbol();
            arb5=new Arbol();
            int raiz=0;
            int i1=0;
            int i2=0;
            
            if (arbre.es_nulo()==true){
	    Integer IdPa= new Integer(IdP);
            	arb1.a_nulo();
                arbre.plantar(IdPa,arb1,arb1);
                i=0;
            }
            else {
                arb1.hi(arbre);
                arb2.hd(arbre);
                arb3.hi(arbre);
                arb4.hd(arbre);
                Integer wraiz = (Integer) arbre.raiz();
				raiz=wraiz.intValue();
                afegeix_candidat(arb1,IdP,i1);
                afegeix_candidat(arb2,IdP,i2);
                if (i1<=i2){
                	
                    arbre.plantar(wraiz,arb1,arb4);
                    i=i1+1;
                }
                else {
                    arbre.plantar(wraiz,arb3,arb2);
                    i=i2+1;
                }
            }
            
        }
        
 private int te_fill (Arbol arbre) throws Exception
        {
            int fill=0;
            Arbol arb1;
            Arbol arb2;
	    arb1=new Arbol();
	    arb2=new Arbol();
            arb1.hi(arbre);
            arb2.hd(arbre);
            
            if (arb1.es_nulo()==true){
                    if (arb2.es_nulo()==true){
                          fill=0;
                    }
                    else {
                        fill=1;
                    }
            }
            else if (arb2.es_nulo()==true){
                    fill=2;
            }
     
            
            return fill;
        }
        

public void Treure2 (sistema sistem, Arbol arbre, int IdP, int i) throws Exception
        {
            Arbol arb1;
            Arbol arb2;
	    arb1=new Arbol();
	    arb2=new Arbol();
            int raiz=0;
	    int i1=0;
            int i2=0;


            
            if (arbre.es_nulo()==true) {
                i=0;
            }
            else {
	    Integer wraiz = (Integer) arbre.raiz();
		raiz=wraiz.intValue();
		if (raiz==IdP){
                if(es_fulla(arbre)==true){
                    arbre.a_nulo();
                    i=1;
                }
            }
	    
                 else {
                arb1.hi(arbre);
                arb2.hd(arbre);
                Treure2(sistem, arb1,IdP,i1);
                Treure2(sistem, arb2,IdP,i2);
                arbre.plantar(wraiz,arb1,arb2);
                i=i1+i2;
            }
        }
	} 
        
        
private void Afegeix_candidat_Padri (sistema sistem, Arbol arbre,int IdP, boolean b, int i) throws Exception
        {
            Arbol arb1;
            Arbol arb2;
            Arbol arb3;
            Arbol arb4;
	    Arbol arb5;
	    Arbol arb6;
	    arb1=new Arbol();
	    arb2=new Arbol();
	    arb3=new Arbol();
	    arb4=new Arbol();
	    arb5=new Arbol();
	    arb6=new Arbol();
            int i1=0;
            int i2=0;
            // arb3 y arb 4 son els modificats; arb1 y arb2 les copies de seguretat
            int raiz=0;
            int raiz1=0;
            int raiz2=0;
		boolean b1=false;
            boolean b2=false;
            int fill=0;
                arb1.hi(arbre);
                arb2.hd(arbre);
                arb3.hi(arbre);
                arb4.hd(arbre);
		arb6.a_nulo();
            
            if (arbre.es_nulo()==true) {
                b=false;
            }
            else {Integer wraiz3 = (Integer) arbre.raiz();
                raiz=wraiz3.intValue();
		Integer wraiz = (Integer) arb1.raiz();
		raiz1=wraiz.intValue();
		Integer wraiz2= (Integer) arb2.raiz();
		raiz2=wraiz.intValue();
                fill=te_fill(arbre);

                if ((fill==1) && (sistem.aigua(raiz2)==false) && (mitja(IdP,raiz2,sistem)==true)) 
                {
		 
                    arbre.plantar(wraiz,arb5,arb2);
                    i=0;
                    b=true;
                }
                else if ((fill==2) && 
			(sistem.aigua(raiz1)==false) && 
			(mitja(IdP,raiz1,sistem)==true))
			{
			Integer IdPa= new Integer(IdP);
                    arbre.plantar(wraiz,arb1,arb5);
                    i=0;
                    b=true;
                }
                else{
                    Afegeix_candidat_Padri(sistem, arb1, IdP, b1, i1);
                    Afegeix_candidat_Padri(sistem, arb2, IdP, b2, i2);
                    if (b1==false && b2==false){
                        b=false;
                    }
                    else if (b1==true && b2==true) {
                        if (i1<=i2){
                            arbre.plantar(wraiz,arb1,arb4);
                            i=i1+1;
                        }
                        else {
                            arbre.plantar(wraiz,arb3,arb2);
                            i=i2+1;
                        }
                   
             }
                    else if (b1==true){
                        arbre.plantar(wraiz,arb1,arb4);
                        i=i1+1;
						b=true;
                    }
                    else{
                        arbre.plantar(wraiz,arb3,arb2);
                        i=i2+1;
					b=true;
                    } 
            }          
        }
        }
}



