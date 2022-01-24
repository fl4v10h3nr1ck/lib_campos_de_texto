package classes;

import javax.swing.JTextField;

public class Campo extends JTextField{


private static final long serialVersionUID = 1L;

	
	
	public Campo(){this("");}
	
	
	
	public Campo(int valor){this(valor+"");	}
	
	
	
	public Campo(String valor){super(valor);	}

	
	
	public void setText(int valor){
		
	super.setText(valor+"");	
	}
	
	
	
	public boolean validacao(){return true;}
	
	
	
	
	
	
}
