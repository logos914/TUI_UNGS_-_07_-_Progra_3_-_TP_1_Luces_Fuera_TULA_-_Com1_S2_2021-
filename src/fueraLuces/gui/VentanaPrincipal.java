package fueraLuces.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentListener;

import fueraLuces.modelo.Iluminable;
import grilla.Grilla;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Canvas;

public class VentanaPrincipal extends JFrame {

	
	public JPanel panelTablero;
	private JMenuBar menuPrincipal;
	private JMenuItem menuItemNuevo;
	private JMenuItem menuItemDeshacer;
	private JMenuItem menuItemAyuda;
	private JPanel panel;
	private JPanel panelBarraEstado;
	private FlowLayout fl_panelBarraEstado;
	private JLabel txtRecord;
	private Component horizontalStrut;
	private JProgressBar progressBar;
	private Component horizontalStrut_1;
	private JLabel txtCantMovimientos;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Fuera Luces - Tula Ignacio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		this.panelTablero = new JPanel();
		getContentPane().add(this.panelTablero, BorderLayout.CENTER);
		this.panelTablero.setLayout(new GridLayout(5, 5, 0, 0));
		
		this.menuPrincipal = new JMenuBar();
		getContentPane().add(menuPrincipal, BorderLayout.NORTH);
		
		this.menuItemNuevo = new JMenuItem("Nuevo");
		
		this.menuPrincipal.add(this.menuItemNuevo);
		
		this.menuItemDeshacer = new JMenuItem("Deshacer");
		this.menuPrincipal.add(this.menuItemDeshacer);
		
		this.menuItemAyuda = new JMenuItem("Ayuda");
		this.menuPrincipal.add(this.menuItemAyuda);
		
		
		
		
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panelBarraEstado = new JPanel();
		panel.add(panelBarraEstado);
		panelBarraEstado.setBackground(Color.DARK_GRAY);
		panelBarraEstado.setForeground(Color.ORANGE);
		fl_panelBarraEstado = new FlowLayout(FlowLayout.CENTER, 0, 6);
		fl_panelBarraEstado.setAlignOnBaseline(true);
		panelBarraEstado.setLayout(fl_panelBarraEstado);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(10);
		panelBarraEstado.add(horizontalStrut_2);
		
		txtRecord = new JLabel("Record: 00");
		txtRecord.setForeground(Color.ORANGE);
		txtRecord.setFont(new Font("Dialog", Font.BOLD, 16));
		panelBarraEstado.add(txtRecord);
		
		horizontalStrut = Box.createHorizontalStrut(120);
		panelBarraEstado.add(horizontalStrut);
		
		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Dialog", Font.BOLD, 14));
		progressBar.setForeground(Color.ORANGE);
		progressBar.setValue(25);
		panelBarraEstado.add(progressBar);
		
		horizontalStrut_1 = Box.createHorizontalStrut(120);
		panelBarraEstado.add(horizontalStrut_1);
		
		txtCantMovimientos = new JLabel("Movimientos: 12");
		txtCantMovimientos.setForeground(Color.ORANGE);
		txtCantMovimientos.setFont(new Font("Dialog", Font.BOLD, 16));
		panelBarraEstado.add(txtCantMovimientos);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(10);
		panelBarraEstado.add(horizontalStrut_3);
		
		
		
		
		
		
	}
	
	public void redibujarTablero( Grilla<Iluminable> grilla) {
		int tamanio = grilla.getTamanio();
		this.panelTablero.removeAll();
		this.panelTablero.setLayout(new GridLayout(tamanio,tamanio,5,5));
		
		Iterator <Iluminable> grillaVisual = grilla.iterator();
		
		while (grillaVisual.hasNext()) {
			// System.out.println("hola");
				LuzLed luz = (LuzLed) grillaVisual.next();
				
				this.panelTablero.add(new JButton(luz.obtenerEstadoVisual()));
		
				
				 
			
			// System.out.println(luz.obtenerEstado());
			}
		
		
		// this.inicializarEmisionEventosCeldas();
		
		
	}
	
	
	public void inicializarEmisionEventosCeldas(ActionListener escuchante) {

		int contador = 0;
		for (Component  componente : this.panelTablero.getComponents()) {
			
			JButton celda = (JButton) componente;
			
			celda.putClientProperty("pos", contador);
			celda.addActionListener(escuchante);
			contador++;
		}

	}
	
	public void eventoNuevoJuego(ActionListener escucha) {
		this.menuItemNuevo.addActionListener(escucha);
	}
	
}
