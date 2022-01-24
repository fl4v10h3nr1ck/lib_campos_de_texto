package CamposDeTexto.formatadores;


/**
 * 
 *  
 *Esta classe descende de PlainDocument e pode ser usada, atraves do método subscrito insertString,
* para formatar JTextField's tipo CPF. na forma: xxx.xxx.xxx-xx
* 
*
* esta classe deve ser chamada da sequinte forma:
* 
* JTextField textField = new JTextField( num_colunn);
* textField.setDocument( new Format_TextField_CPF(  textField )  ); 
* 
* 
* STATUS = COMPLETA
* 
* 
*/




/* esta classe descende de PlainDocument e pode ser usada, atraves do método subscrito insertString,
 para formatar o field JTextField quanto à quantidade maxima de caractes suportados,
 * tipo de caracteres, bem com adicionar separadores como no caso de numeros de telefones e cpf.
 
 
 esta classe deve ser chamada da sequinte forma:
 * 
 * JTextField textField = new JTextField( num_colunn);
 * textField.setDocument( new FormatTextField_CPF( textField )  ); 
 * 
 * 
 */




import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


















public class Format_TextField_CPF extends PlainDocument{
    
    
    
    
   	
	

private static final long serialVersionUID = 1L;




private final  int MAXLENGTH = 11;  
private JTextField  textField;  
    
  







/* o contrutor recebe um inteiro com a quantidade maxima de caracteres que o field poderá
 * receber e uma referencia a ao proprio JTextField.
 */

    public Format_TextField_CPF(  JTextField  textField ) {  
        
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
        	
        if( getText( i , 1 ).compareTo(  ".") == 0  ||  getText( i , 1 ).compareTo(  "-") == 0)
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
        	
        if( getText( i , 1 ).compareTo(  ".") == 0  ||  getText( i , 1 ).compareTo(  "-") == 0)
        continue;
        	
        aux+= getText( i , 1 );	
        }
        
        
        
      
        
        
        for(i = 0 ; i < aux.length() && i < MAXLENGTH; i++){
        	
        field += aux.charAt(i);
        
        
        	if( i  == 2 || i  == 5){
        	field+=".";
    		
        	if(offset ==  getLength())
        	posicao_cursor++; 
        		
        	}
        
        	
        	if( i == 8 ){
        	field+="-";
    		
        	if(offset ==  getLength())
            posicao_cursor++; 
            		
            }
        	
        }
 	
        
        

        if(offset !=  getLength()){
        	
        if( posicao_cursor > 2)
        posicao_cursor++;
        
        if( posicao_cursor > 6)
        posicao_cursor ++;
        
        if( posicao_cursor > 10)
        posicao_cursor ++;
        	
        }
        	
            
        
 
    // limpa o campo antes de regrava-lo    
    this.textField.setText( null );
    
    //grava a nova string no textfield
    super.insertString( 0, field , attr);
    
    

    
    textField.moveCaretPosition(posicao_cursor); // move o cursor para a posição seguinte à string adicionada.
    textField.setSelectionEnd(0);// remove qualquer seleção.
    }  
      
    	
  
    
    
    
    
    
    
    
    
}
