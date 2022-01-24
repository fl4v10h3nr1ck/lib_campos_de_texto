package CamposDeTexto.campos;

import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;



import javax.swing.JTextField;

public class Campo extends JTextField{


private static final long serialVersionUID = 1L;

	
	
	public Campo(){
	
	super();
	
		this.addFocusListener(
			new FocusAdapter() {  
				@Override
				public void focusGained(FocusEvent e) {
				   
				desativaModoDeErro();
				}
			}
		);
	}

	
	
	public void setText(int valor){
		
	super.setText(valor+"");	
	}
	
	
	
	
	public boolean validacao(){return true;}
	
	
	
	
	
	public void desativaModoDeErro(){
		
	this.setBackground(Color.white);
	this.setForeground(Color.black);		
	}
	
	

	
	public void ativaModoDeErro(){	
	
	if(this.getText().length() == 0)
	this.setBackground(Color.red);
	else
	this.setForeground(Color.red);		
	}
	
	
	
	
}
