package CamposDeTexto.campos;

import java.util.InputMismatchException;

import CamposDeTexto.formatadores.Format_TextField_CPF;

public class CampoCPF extends Campo{

	
private static final long serialVersionUID = 1L;


	public CampoCPF(){this("");}

	
	public CampoCPF(int valor){this(valor+"");}

	
	public CampoCPF(String valor){
	
	super();
	
	this.setDocument( new Format_TextField_CPF(this)); 
	
	this.setText(valor);
	}
	
	

	public boolean validacao(){
		
		if(this.getText().length() != 14){	
		
		this.ativaModoDeErro();
		return false;
		}
		
	return true;
	}
	
	
	
	
	public boolean validacaoCompleta(){
	
	if(!validacao())	
	return false;
		
	String CPF = this.getText().replaceAll("\\D", "");	
	
		if (CPF.equals("00000000000") || CPF.equals("11111111111") ||
	        CPF.equals("22222222222") || CPF.equals("33333333333") ||
	        CPF.equals("44444444444") || CPF.equals("55555555555") ||
	        CPF.equals("66666666666") || CPF.equals("77777777777") ||
	        CPF.equals("88888888888") || CPF.equals("99999999999")){
			
		this.ativaModoDeErro();
		return false;
		}
	
    char dig10, dig11;
    int sm, i, r, num, peso;

    	try {

    	sm = 0;
    	peso = 10;
    	
    		for (i=0; i<9; i++) {              
    			
    		num = (int)(CPF.charAt(i) - 48); 
    		sm = sm + (num * peso);
    		peso = peso - 1;
    		}

    	r = 11 - (sm % 11);
    	if ((r == 10) || (r == 11))
        dig10 = '0';
    	else dig10 = (char)(r + 48);
    	
    	sm = 0;
    	peso = 11;
    		for(i=0; i<10; i++) {
    			
    		num = (int)(CPF.charAt(i) - 48);
    		sm = sm + (num * peso);
    		peso = peso - 1;
    		}

    	r = 11 - (sm % 11);
    	if ((r == 10) || (r == 11))
        dig11 = '0';
    	else dig11 = (char)(r + 48);

    	if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
        return true;
	    	else {
	    	
	    	this.ativaModoDeErro();	
	    	return false;
	    	}
    	} 
    	catch (InputMismatchException erro) {
    	
    	this.ativaModoDeErro();	
    	return false;
    	}
	}
	
	
		

	
	
}
