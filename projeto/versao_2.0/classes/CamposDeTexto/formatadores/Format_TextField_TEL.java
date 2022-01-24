/**
 * 
 *  
 *Esta classe descende de PlainDocument e pode ser usada, atraves do m�todo subscrito insertString,
* para formatar JTextField's tipo TEL. na forma: (xx)xxxx-xxxx ou (xx)xxxxx-xxxx
* 
*
* esta classe deve ser chamada da sequinte forma:
* 
* JTextField textField = new JTextField( num_colunn);
* textField.setDocument( new Format_TextField_TEL(  textField )  ); 
* 
* 
* STATUS = COMPLETA
* 
* 
*/



package CamposDeTexto.formatadores;



import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;




public class Format_TextField_TEL extends PlainDocument  {  
   
	
	

private static final long serialVersionUID = 1L;




private final  int MAXLENGTH = 11;  
private JTextField textField;

  


    public Format_TextField_TEL ( JTextField textField ) {  
        
    super();  
    
    this.textField = textField;
    }  

    
   
    
    
    
    
    
    
    
    
   /* o metodo insertString � subscrito da classe PlainDocument e � invocado sempre que o usuario alterar o
     * campo do jtextfield.
     */
 
    public void insertString( int offset, String str, AttributeSet attr)  throws BadLocationException {  
       
       
    String aux = "";
    String campo = "";
    int i;
           

           /* str n�o pode ser null*/ 
        if( str == null )
        return;
       
           
        
        /*adiciona a string str que foi digitada no campo de texto, na posicao correta na string que ja havia
         * no campo de texto caso o usuario cole, adicione no fim, inicio ou meio,
         * alem de remover caracteres invalidos como letras.
         */
        
            for( i = 0 ; i < offset ; i++ ){
            	
            if( getText( i , 1 ).compareTo(  "(") == 0 || getText( i , 1 ).compareTo(  ")") == 0 || getText( i , 1 ).compareTo(  "-") == 0 )
            continue;
            
            aux+= getText( i , 1 );	
            }
            
            
            
            for( i = 0 ; i < str.length() ; i++ ){
            	
            if( str.charAt(i) == '0' || str.charAt(i) == '1' ||str.charAt(i) == '2' ||str.charAt(i) == '3' ||str.charAt(i) == '4' ||
                str.charAt(i) == '5' ||str.charAt(i) == '6' ||str.charAt(i) == '7' ||str.charAt(i) == '8' ||str.charAt(i) == '9' )
            aux+= str.charAt(i);	
            	
            }
        
            
            
       int posicao_cursor = aux.length(); 	
       if( posicao_cursor > this.MAXLENGTH)
       posicao_cursor = MAXLENGTH;
                 
            
          
       
            for( i = offset ; i < getLength() ; i++ ){
            	
            if( getText( i , 1 ).compareTo(  "(") == 0 || getText( i , 1 ).compareTo(  ")") == 0 || getText( i , 1 ).compareTo(  "-") == 0 )
            continue;
           
            aux+= getText( i , 1 );	
            }
            
     
          
            
            for( i = 0 ; i < aux.length() && i < MAXLENGTH; i++){
           	   	
            	if( i  == 0 ){
            	campo+="(";      
           
            	if(offset ==  getLength())
            	posicao_cursor++; 
            
            	}
            
            
            campo += aux.charAt(i); 
        	
            	if(i == 1 ){
            	campo+=")";
            
            	if(offset ==  getLength())
            	posicao_cursor++; 
                
            	}
            
            	if(aux.length()>= this.MAXLENGTH){
            	
	            	if(i == 6 ){
	            	campo+="-";
	            
	            	if(offset ==  getLength())
	                posicao_cursor++; 
	            	}
                }
            	else{
            		
            		if(i == 5 ){
    	            campo+="-";
    	            
    	            if(offset ==  getLength())
    	            posicao_cursor++; 
    	            }		
            	}   	
            }
     	
     
            
            

            if(offset !=  getLength()){
            	
            if( posicao_cursor > 0)
            posicao_cursor++;
            
            if( posicao_cursor > 3)
            posicao_cursor ++;
               
	            if(aux.length()>= this.MAXLENGTH){
	            if( posicao_cursor > 9)
	            posicao_cursor ++;
	            }
	            else{
	            	
	          if( posicao_cursor > 8)
	           posicao_cursor ++;	
	            }
            }
            	  
            
            
            
            
            
         // limpa o campo antes de regrava-lo.  
        this.textField.setText( null );
        
        //grava a nova string no textfield.
        super.insertString( 0, campo , attr);  
        
        
        
        

        textField.moveCaretPosition(posicao_cursor); // move o cursor para a posi��o seguinte � string adicionada.
        textField.setSelectionEnd(0);// remove qualquer sele��o.
    }  
      
    	
    	
}


