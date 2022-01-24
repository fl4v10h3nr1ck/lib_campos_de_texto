package classes;


public class CampoLimitado extends Campo{


private static final long serialVersionUID = 1L;





	public CampoLimitado(int comprimento){this(comprimento, "");}

	
	
	public CampoLimitado(int comprimento, int valor){this(comprimento, valor+"");}

	
	
	public CampoLimitado(int comprimento, String valor){

	super();
	
	if(comprimento<0)
	comprimento = 0;
	
	this.setDocument( new Format_TextField_MaxLength(comprimento, this)); 
	
	this.setText(valor);
	}
	
	
	

}
