/**
 * 
 *  
 *  
 *  
 *  
 * Esta classe descende de PlainDocument e pode ser usada, atraves do m�todo subscrito insertString,
 *para formatar o campo JTextField. 
 *
 *
 *
 *ESTA CLASSE SEVER PARA FORMATADA VALORES MONET�RIOS.
 *
 *
 *esta classe deve ser chamada da sequinte forma:
 * 
 * JTextField textField = new JTextField( num_colunn);
 * textField.setDocument( new Form_TextField_Valores( textField )  ); 
 * 
 * 
 * 
 * 
 * 
 * STATUS = COMPLETA
 * 
 * 
 * 
 * 
 * 
 * 
 */








package CamposDeTexto.formatadores;







import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;





/* o contrutor recebe um inteiro representado o numero maximo de caracteres no campo
 * e uma referencia ao proprio JTextField.
 */
    
public class Format_TextField_Money  extends PlainDocument  {  
   
	
	

private static final long serialVersionUID = 1L;




private  int maxLength;  
private JTextField textField;



  
  
  


    public Format_TextField_Money( int maxLength ,  JTextField textField ) {  
        

	this(maxLength ,  2, textField);
    }  

    
    
	
	
	
	public Format_TextField_Money( int maxLength ,  int decimais, JTextField textField ) {  
        
    super();  
    
	this.maxLength = maxLength;
    this.textField = textField;
    } 
    
    
    
    
    
    
    
    
    
    
    
    
   /* o metodo insertString � subscrito da classe PlainDocument e � invocado sempre que o usuario alterar o
     * campo do jtextfield.
     */
  
  
    public void insertString( int offset, String str, AttributeSet attr)   throws BadLocationException {  

    
        
        
    String aux = "";
    int i;

        
    if( str == null )
    return;
       
        
         /*adiciona a string str que foi digitada no campo de texto, na posicao correta na string que ja havia
         * no campo de texto caso o usuario cole, adicione no fim, inicio ou meio,
         * alem de remover caracteres invalidos como letras.
         */
        
    
    
    // remove zeros e virgulas iniciais
		for( i = 0 ; i < offset; i++ ){
    	
        if( getText( i , 1 ).compareTo(  "0") == 0 || getText( i , 1 ).compareTo(  ",") == 0)
        continue;	
        else
        break;
        
        }
             
	
		//adiciona a aux string que ja havia no campo
    	for( ; i < offset; i++ ){
            	
        if( getText( i , 1 ).compareTo(  ",") == 0)
        continue;
            
        aux+= getText( i , 1 );	
        }
             
         
            
            
    	//adiciona a aux a string digitada no campo (apenas n�meros)  
    	for( i = 0 ; i < str.length() ; i++ ){
            
    	if( str.charAt(i) == '0' || str.charAt(i) == '1' ||str.charAt(i) == '2' ||str.charAt(i) == '3' ||str.charAt(i) == '4' ||
        str.charAt(i) == '5' ||str.charAt(i) == '6' ||str.charAt(i) == '7' ||str.charAt(i) == '8' ||str.charAt(i) == '9' )
            
        aux+= str.charAt(i);	
            	
    	}
            
         
    	
    	
    	
    	/* pega a posi��o do ultimo elemento da string a ser adicionada + a string que ja havia no campo
    	 * 
    	 * isso � importante porque o cursor sempre ser� posicionado no final da string no campo o que n�o � desejado quando se
    	 * adicionada um elemento no meio do campo, por exemplo. Dessa forma o cursor ficar� sempre uma posi��o a frente da string
    	 * digitada no campo.
    	 * 
    	 */
   int posicao_cursor = aux.length(); 	
   if( posicao_cursor > this.maxLength)
   posicao_cursor = maxLength;
    	
    	
    	// adiciona a aux a string restante que ja havia no campo
    	for( i = offset ; i < getLength() ; i++ ){
            	
        if( getText( i , 1 ).compareTo(  ",") == 0)
        continue;
            	
        aux+= getText( i , 1 );	
    	}
            
     
     	// corta a string aux caso tenha mais elementos que o m�ximo aceit�vel 	
    String aux2 = "";    
    for(i = 0 ; i < aux.length() && i < maxLength; i++)
    aux2 += aux.charAt(i);
    
    
	// a diciona a virgula monet�ria na posi��o correta independentemente de onde for adicionado strings no campo.
    StringBuffer field = new StringBuffer(aux2);   
    	if( aux2.length() == 1){
    
    	field.insert(0, "0,0");
    	posicao_cursor += 3;    		
    	}	
    	
 
    	if( aux2.length() == 2){
        
    	field.insert(0, "0,");
    	posicao_cursor += 2;    	
    	} 
 
  
    	if( aux2.length() > 2){
        
    	field.insert(aux2.length() -2, ",");
    
    	if( posicao_cursor > aux2.length() -2)    
    	posicao_cursor += 1;     
    
    	} 
   
    
  
     // limpa o campo antes de regrava-lo    
   this.textField.setText( null );
    //grava a nova string no textfield
   super.insertString( 0, String.valueOf(field) , attr); 
        
      
   textField.moveCaretPosition(posicao_cursor); // move o cursor para a posi��o seguinte � string adicionada.
   textField.setSelectionEnd(0);// remove qualquer sele��o.
         


    }
    
    
    
    
    
    
    
    
    
    
    
}