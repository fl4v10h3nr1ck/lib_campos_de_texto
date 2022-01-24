/**
 * 
 *  
 *Esta classe descende de PlainDocument e pode ser usada, atraves do método subscrito insertString,
* para formatar JTextField's tipo CNPJ. na forma: xxxx.xxx.xxx/xxxx-xx
* 
*
* esta classe deve ser chamada da sequinte forma:
* 
* JTextField textField = new JTextField( num_colunn);
* textField.setDocument( new FormText_Field_CNPJ(  textField )  ); 
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







public class Format_TextField_CNPJ extends PlainDocument{
    
    
    
    
   	
	

private static final long serialVersionUID = 1L;





private JTextField  textField;  
private final  int MAXLENGTH =    15; 
  








/* o contrutor recebe um inteiro com a quantidade maxima de caracteres que o field poderá
 * receber e uma referencia a ao proprio JTextField.
 */

    public Format_TextField_CNPJ(  JTextField  textField ) {  
        
    super();  
    
    this.textField = textField;
    }  

 
     
   
    
    
    
    
    
    
    
    
    /* o metodo insertString é subscrito da classe PlainDocument e é invocado sempre que o usuario alterar o
     * campo do jtextfield.
     */
 
    public void insertString( int offset, String str, AttributeSet attr)   throws BadLocationException {  
       
    
        
        
    String aux = "";
    String field = "";
    int i;
      

    
   /* str não pode ser null*/ 
    if( str == null )
    return;
   
    
     /*adiciona a string str que foi digitada no campo de texto, na posicao correta na string que ja havia
     * no campo de texto caso o usuario cole, adicione no fim, inicio ou meio,
     * alem de remover caracteres invalidos como letras.
     */
    
        for( i = 0 ; i < offset ; i++ ){
        	
        if( getText( i , 1 ).compareTo(  ".") == 0  ||  getText( i , 1 ).compareTo(  "-") == 0 ||  getText( i , 1 ).compareTo(  "/") == 0)
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
        	
        if( getText( i , 1 ).compareTo(  ".") == 0  ||  getText( i , 1 ).compareTo(  "-") == 0 ||  getText( i , 1 ).compareTo(  "/") == 0)
        continue;
        	
        aux+= getText( i , 1 );	
        }
        
        
        
   int largura =  aux.length();  
        
        if( largura >= 15){
        
        
        	for(i = 0 ; i < aux.length() && i < 15; i++){
        	
        	field += aux.charAt(i);
        
        
        		if( i  == 2 || i  == 5){
        		field+=".";
        	
        		if(offset ==  getLength())
        		posicao_cursor++; 
            		
            	}
    		
        		
        		if( i == 8 ){
        		field+="/";
        	
        		if(offset ==  getLength())
            	posicao_cursor++; 
            		
        		}
        	
    		
        		
        		if( i == 12 ){
        		field+="-";
        	
        	
        		if(offset ==  getLength())
            	posicao_cursor++; 
            		
            	}
        		
        	}
        }
        else{
        	
        	
        	for(i = 0 ; i < aux.length() && i < 14; i++){
            	
            	field += aux.charAt(i);
            
          
            	
            	if( i  == 1 || i  == 4){
            	
            	field+=".";
            	
            	if(offset ==  getLength())
                posicao_cursor++; 
                		
                }
            	
        		
            	if( i == 7 ){
            	field+="/";
            	
            	if(offset ==  getLength())
                posicao_cursor++; 
                		
                }
        		
            	
            	
            	if( i == 11 ){
                field+="-";
            	
            	if(offset ==  getLength())
                posicao_cursor++; 
                		
                }
        	}	
        }
        
        
       
        
        i = 0;
        if(offset !=  getLength()){
             	
        if(largura >= 15)
        i = 1;	
        	
        
        if( posicao_cursor > 1+i)
        posicao_cursor++;	  		
        	
           	  
        if( posicao_cursor > 5+i)
        posicao_cursor ++;
        	
        
        if( posicao_cursor > 9+i)
        posicao_cursor++;
        
        if( posicao_cursor > 15+i)
        posicao_cursor++;
        	
        } 	
    
        	
        	
        	
        	
        
    // limpa o campo antes de regrava-lo    
    this.textField.setText( null );
    
    //grava a nova string no textfield
    super.insertString( 0, field , attr);  
   
    
    
    
    
    textField.moveCaretPosition(posicao_cursor); // move o cursor para a posição seguinte à string adicionada.
    textField.setSelectionEnd(0);// remove qualquer seleção.
    }  
      
    	
  
    
    
    
    
    
    
    
    
}
