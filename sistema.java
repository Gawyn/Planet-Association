import tadsPRAP.*;
import utilsPRAP.*;

class sistema
{

	InOut io = new InOut ();
	final static int N=2;
	private planeta[] sistem;
	
	public sistema() throws Exception
	{
		sistem= new planeta [N+1];
		int i=0;
		while (i<=N)
		{
			sistem[i] = new planeta();
			i++;
		}
	}
	
	public void llegir_sistema(InOut io) throws Exception
	{
		int i=0;
		while (i<=N)
		{
		
			sistem[i].llegir_planeta(io);
			i++;
		}
	}
	
	
	public void millor_planeta_criteri (int n, InOut io) throws Exception
	{
		int i = 0;
		int idc = -1;
		int max = -1;
		int idp;
		while (i<=N){
			if ((sistem[i].consultar_criteri_planeta(n)>max) && sistem[i].pertany()==false) 
					{
					max=sistem[i].consultar_criteri_planeta(n);
					idc=i;
					}
			i++;	
		}
		if (idc==-1) {
			}
		else {
		idp=sistem[idc].consultar_idp();
		io.write(idp);
		}
	}

	public int Columna (int idp) throws Exception
	{
		int i=0;
		int idc=-1;
		while(idc==-1){
		if (sistem[i].consultar_idp() == idp)
				{
				idc=i;
					}
		else {
			i++;
			}
			}
		return idc;
	}

	public void ordenar_creixent_Ass (InOut io) throws Exception
	{
		int i=0;
		int j=0;
		int[] vid=new int[N+1];


			while (i<=N){
			if(sistem[i].pertany()==true)
							{
					vid[j]=sistem[i].consultar_idp();
							}
			else {vid[j]=0;}
			i++;
			j++;
					}
			ordenar(vid);
		escriure_vector(vid,io);
			
	}

	private void ordenar (int[] vid) throws Exception
	{
		int i=0;
		int j=0;
		int a=0;
		while (i<=N){
		while (j<=N){
		if (vid[i]>vid[j]){
		a=vid[i];
		vid[i]=vid[j];
		vid[j]=a;
		}
		j++;
		}
		i++;
		j=i+1;
		}
	}

	private void escriure_vector (int vid[],InOut io) throws Exception
	{
	int i =0;
	while (i<=N){
			io.write(vid[i]);
			i++;
	}
	
	}

		
	public void modificar_planeta (int idp, InOut io) throws Exception
	{
		int idc;
		int c = io.readint();
		idc=Columna(idp);
		int i = 1;
		int n;
		
		while ( i<=c)
		{	
			n=io.readint();
			sistem[idc].modificar_criteri(n,io);
			i++;
		} 

	}

	public void afegir(int IdP) throws Exception
	{
		int IdC;
		IdC=Columna(IdP);
		sistem[IdC].afegir_a_Ass();
	}
	
	public void treure(int IdP) throws Exception
	{
		int IdC;
		IdC=Columna(IdP);
		sistem[IdC].treure_de_Ass();
	}
	
	public int[] consultar_criteris2(int IdP) throws Exception
	{
		int IdC;
		int[]v;
		IdC=Columna(IdP);
		v=sistem[IdC].consultar_criteris();
		return v;
	}
	
	public int consultar_criteri2(int IdP, int n) throws Exception
	{
		int IdC;
		int i;
		IdC=Columna(IdP);
		i=sistem[IdC].consultar_criteri_planeta(n);
		return i;
	}
	
	public boolean pertany2(int IdP) throws Exception
	{
		boolean b;
		int IdC;
		IdC=Columna(IdP);
		b=sistem[IdC].pertany();
		return b;
	}
	
	public boolean aigua(int IdP) throws Exception
	{
		boolean b;
		int IdC;
		IdC=Columna(IdP);
		b=sistem[IdC].te_aigua();
		return b;
		
	}
}
