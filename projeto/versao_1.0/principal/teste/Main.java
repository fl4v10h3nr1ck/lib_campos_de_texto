
package teste;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import classes.CampoCEP;
import classes.CampoCNPJ;
import classes.CampoCPF;
import classes.CampoData;
import classes.CampoLimitado;
import classes.CampoLimitadoSoDigito;
import classes.CampoMoeda;
import classes.CampoTEL;


public class Main {

	
	public static void main(String[] args){
		
	JDialog dialogo = new 	JDialog();
		
	dialogo.setTitle("Teste de Campos de Texto");
	dialogo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	dialogo.setSize(600 , 600);
	dialogo.setLocationRelativeTo(null);
	dialogo.setLayout(new GridBagLayout());
	dialogo.setModal(true);
	dialogo.getContentPane().setBackground(Color.WHITE);  

	
	GridBagConstraints cons = new GridBagConstraints();  

	cons.fill = GridBagConstraints.HORIZONTAL;
	cons.gridwidth  = GridBagConstraints.REMAINDER;	
	cons.weighty  = 0;
	cons.weightx = 1;
	

	cons.insets = new Insets(2, 2, 0, 2);
	dialogo.add(new JLabel("CEP"), cons);
	cons.insets = new Insets(2, 2, 20, 2);
	dialogo.add(new CampoCEP(1), cons);
	
	cons.insets = new Insets(2, 2, 0, 2);
	dialogo.add(new JLabel("CNPJ"), cons);
	cons.insets = new Insets(2, 2, 20, 2);
	CampoCNPJ cnpj;
	dialogo.add(cnpj = new CampoCNPJ(), cons);
	cnpj.setText(1);
	
	cons.insets = new Insets(2, 2, 0, 2);
	dialogo.add(new JLabel("CPF"), cons);
	cons.insets = new Insets(2, 2, 20, 2);
	dialogo.add(new CampoCPF(), cons);
	
	cons.insets = new Insets(2, 2, 0, 2);
	dialogo.add(new JLabel("Data"), cons);
	cons.insets = new Insets(2, 2, 20, 2);
	dialogo.add(new CampoData(), cons);
	
	cons.insets = new Insets(2, 2, 0, 2);
	dialogo.add(new JLabel("Comprimento"), cons);
	cons.insets = new Insets(2, 2, 20, 2);
	dialogo.add(new CampoLimitado(5), cons);
	
	cons.insets = new Insets(2, 2, 0, 2);
	dialogo.add(new JLabel("Comprimento somente digito"), cons);
	cons.insets = new Insets(2, 2, 20, 2);
	dialogo.add(new CampoLimitadoSoDigito(5), cons);
	
	cons.insets = new Insets(2, 2, 0, 2);
	dialogo.add(new JLabel("Moeda"), cons);
	cons.insets = new Insets(2, 2, 20, 2);
	dialogo.add(new CampoMoeda(5), cons);
	
	cons.insets = new Insets(2, 2, 0, 2);
	dialogo.add(new JLabel("TEL"), cons);
	cons.insets = new Insets(2, 2, 20, 2);
	dialogo.add(new CampoTEL(), cons);
	
	
	System.out.println("data "+new CampoData("32122014").validacao());
	
	System.out.println("tel " + new CampoTEL("9132984564").validacao());
	
	System.out.println("cep " + new CampoCEP("66110-120").validacao());
	
	System.out.println("cnpj simples " + new CampoCNPJ("21.614.991/0001-72").validacao());
	
	System.out.println("cnpj completa " + new CampoCNPJ("21.614.992/0001-72").validacaoCompleta());
	
	System.out.println("CPF simples " + new CampoCPF("992.143.342-34").validacao());
	
	System.out.println("CPF completa " + new CampoCPF("992.143.342-32").validacaoCompleta());
	
	dialogo.setVisible(true);
	}
	
	
	
	
	
	
	
}
