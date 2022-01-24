package classes;

public class CampoMoeda extends Campo{


private static final long serialVersionUID = 1L;



	public CampoMoeda(int comprimento){this(comprimento, "");}

	
	
	public CampoMoeda(int comprimento, int valor){this(comprimento, valor+"");}

	
	
	public CampoMoeda(int comprimento, String valor){

	super();
	
	if(comprimento<0)
	comprimento = 0;
	
	this.setDocument( new Format_TextField_Money(comprimento, this)); 
	
	this.setText(valor);
	}
	
	
	


}
