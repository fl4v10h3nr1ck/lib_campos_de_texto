package CamposDeTexto.campos;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import CamposDeTexto.formatadores.Format_TextField_Date;

public class CampoData extends Campo{


private static final long serialVersionUID = 1L;





	public CampoData(){this("");}

	
	public CampoData(int valor){this(valor+"");}

	
	public CampoData(String valor){
	
	super();
	
	this.setDocument( new Format_TextField_Date(this)); 
	
	this.setText(valor);
	}
	
	
	
	public boolean validacao(){
			
		if(this.getText().length()==0){
		
		this.ativaModoDeErro();	
		return false;
		}
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	dateFormat.setLenient(false);
			
		try {
		dateFormat.parse(this.getText()); 
		} 
		catch(ParseException e) {
		
		this.ativaModoDeErro();	
		return false;
		}
			
	return true;	
	}
		
	
	
	
	
}
