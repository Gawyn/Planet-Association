import utilsPRAP.*;
import tadsPRAP.*;

       class planeta 
       {
	   	InOut io = new InOut ();
	   	final static int M=8;
           	private int[] pln;

	   	public planeta()
	   	{
	       		pln = new int [M+2];
	       		int i=0;
	       		while(i<=M+1)
	       		{
		   	pln[i]=0;
		   	i++;
	       		}
	   	}

	   	public void llegir_planeta(InOut io)throws Exception
	   	{
			pln[0]=0;
	       		int i=2;
			boolean b;

	       		while (i<=M+1)
		   	{
		       		pln[i]=io.readint();
		       		i=i+1;
		   	}
			io.write("aigua");
			b = io.readboolean();
			if (b == true)
			{	
				pln[1]=1;
			}
			else {
				pln[1] = 0;
				}
	   	}
		
		public int[] consultar_criteris() throws Exception
		{
			int[]v;
			v=new int [8];
			int i=0;
		while (i<=7){
			v[i]=pln[i+2];
			i++;
			}
		return v;
		}

	   	public int consultar_criteri_planeta(int n)throws Exception
	   	{
	       		return pln[n+1];
	   	}

		public void modificar_criteri (int n, InOut io) throws Exception
		{
			pln[n+1]=io.readint();
		}
       
	   	public boolean te_aigua () throws Exception
	   	{
			return pln[1]==1;
	   	}

		public boolean pertany () throws Exception
		{
			boolean b=false;
			if (pln[0]==1) {
			b=true;
			}
			return b;
		}

		public void afegir_a_Ass() throws Exception
		{
			pln[0]=1;
		}

		public void treure_de_Ass() throws Exception
		{
			pln[0]=0;
		}

		public int consultar_idp() throws Exception
		{
			return pln[2];
		}
	}
        


