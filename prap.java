import utilsPRAP.*;
import tadsPRAP.*;


class prap {


	public static void main (String args[]) throws Exception {
		
		InOut io=new InOut();
		sistema sistem;
		Associacio ass;
		sistem=new sistema();
		sistem.llegir_sistema(io);
		io.write("Escriu l'associació");
		ass=new Associacio(sistem, io);
		int IdP;
		int opcio;
		int n;
		boolean b;
		io.writeln("Introdueix la opcio desitjada:");
		opcio=io.readint();
		while (opcio !=-8)
		{
			if (opcio ==-1)
			{
				IdP=io.readint();
				io.writeln("Afegir un planeta");
				ass.afegir_planeta(IdP,sistem,io);
			}
			if (opcio == -2)
			{
				IdP=io.readint();
				io.writeln("Treure un planeta");
				ass.Treure1(sistem, IdP,io);
			}					
			if (opcio == -3)
			{
				io.writeln("Escriure els ID dels planetes en ordre creixent");
				sistem.ordenar_creixent_Ass(io);
  			}
			if (opcio==-4)
			{
				io.writeln("Escriure l'associaci�en inordre");
				ass.escriure_arbre(io);
			}
			if (opcio==-5)
			{
				io.writeln("Millor planeta per criteri");
				n=io.readint();
				sistem.millor_planeta_criteri(n,io);
			}
			if (opcio==-6)
			{				
				io.writeln("Modificar les puntuacions del planeta");
				io.writeln("Quin Id del planeta");	
				IdP=io.readint();
				sistem.modificar_planeta(IdP,io);
			}	
			
			if (opcio==-7)
			{
				io.writeln("Modificar requisits");
				ass.modificar_requisits(io);
				
			}
			io.write("Introdueix opcio");
			opcio=io.readint();
		}
		}
	}

