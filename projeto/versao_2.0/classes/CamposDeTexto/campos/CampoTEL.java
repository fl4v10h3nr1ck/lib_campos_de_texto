package CamposDeTexto.campos;

import java.util.regex.Pattern;

import CamposDeTexto.formatadores.Format_TextField_TEL;

public class CampoTEL extends Campo{


private static final long serialVersionUID = 1L;



	public CampoTEL(){this("");}


	public CampoTEL(int valor){this(valor+"");}

	
	public CampoTEL(String valor){
	
	super();
	
	this.setDocument( new Format_TextField_TEL(this)); 
	
	this.setText(valor);
	}


	
	
	public boolean validacao(){
		
		if(this.getText().length() == 0){
			
		this.ativaModoDeErro();
		return false;	
		}		
		
	Pattern pattern = Pattern.compile(".((10)|([1-9][1-9]).)9?[6-9][0-9]{3}-[0-9]{4}");  
	
	if(pattern.matcher(this.getText()).matches())
	return true;
		
	pattern = Pattern.compile(".((10)|([1-9][1-9]).)[2-5][0-9]{3}-[0-9]{4}");  
	
	if(pattern.matcher(this.getText()).matches())
	return true;
		
	this.ativaModoDeErro();
	return false;
	}
		
		



}
