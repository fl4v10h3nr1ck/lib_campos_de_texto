package classes;



public class CampoCEP extends Campo{


private static final long serialVersionUID = 1L;





	public CampoCEP(){this("");}

	
	public CampoCEP(int valor){this(valor+"");}

	
	public CampoCEP(String valor){
	
	super();
	
	this.setDocument( new Format_TextField_CEP(this)); 
	
	this.setText(valor);
	}
	
	
	
	
	public boolean validacao(){
		
	if (this.getText().length() != 9)
    return false;
	
	return true;
	}
	
	
	
	
}
