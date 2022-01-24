package CamposDeTexto.campos;

import CamposDeTexto.formatadores.Format_TextField_MaxLengthOnlyNum;

public class CampoLimitadoSoDigito extends Campo{


private static final long serialVersionUID = 1L;





	public CampoLimitadoSoDigito(int comprimento){this(comprimento, "");}

	
	
	public CampoLimitadoSoDigito(int comprimento, int valor){this(comprimento, valor+"");}

	
	
	public CampoLimitadoSoDigito(int comprimento, String valor){

	super();
	
	if(comprimento<0)
	comprimento = 0;
	
	this.setDocument( new Format_TextField_MaxLengthOnlyNum(comprimento, this)); 
	
	this.setText(valor);
	}
	
	
	


}
