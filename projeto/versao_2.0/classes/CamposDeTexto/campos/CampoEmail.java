package CamposDeTexto.campos;

import java.util.regex.Pattern;

import CamposDeTexto.formatadores.Format_TextField_MaxLength;



public class CampoEmail extends Campo{


private static final long serialVersionUID = 1L;





	public CampoEmail(int comprimento){this(comprimento, "");}

	
	
	public CampoEmail(int comprimento, int valor){this(comprimento, valor+"");}

	
	
	public CampoEmail(int comprimento, String valor){

	super();
	
	if(comprimento<0)
	comprimento = 0;
	
	this.setDocument( new Format_TextField_MaxLength(comprimento, this)); 
	
	this.setText(valor);
	}
	
	
	
	public boolean validacao(){
		
		if(this.getText().length() == 0){
			
		this.ativaModoDeErro();
		return false;
		}
		
	Pattern pattern = Pattern.compile(".+@.+\\.[a-z]+");  
			   
	if(pattern.matcher(this.getText()).matches())
	return true;
	
	this.ativaModoDeErro();
	return false;
	}
		

}

