package fueraLuces.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JInternalFrame;
import java.awt.TextField;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;

public class VentanaPrincipal extends JFrame {

	
	public JPanel panelTablero;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setTitle("Fuera Luces - Tula Ignacio");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		
		
		
		JMenuBar menuPrincipal = new JMenuBar();
		getContentPane().add(menuPrincipal, BorderLayout.NORTH);
		
		JMenuItem menuItemNuevo = new JMenuItem("Nuevo");
		
		menuPrincipal.add(menuItemNuevo);
		
		JMenuItem menuItemDeshacer = new JMenuItem("Deshacer");
		menuPrincipal.add(menuItemDeshacer);
		
		JMenuItem menuItemAyuda = new JMenuItem("Ayuda");
		menuPrincipal.add(menuItemAyuda);
		
		this.panelTablero = new JPanel();
		getContentPane().add(panelTablero, BorderLayout.CENTER);
		panelTablero.setLayout(new GridLayout(5, 5, 0, 0));
		
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panelBarraEstado = new JPanel();
		panel.add(panelBarraEstado);
		panelBarraEstado.setBackground(Color.DARK_GRAY);
		panelBarraEstado.setForeground(Color.ORANGE);
		FlowLayout fl_panelBarraEstado = new FlowLayout(FlowLayout.CENTER, 0, 6);
		fl_panelBarraEstado.setAlignOnBaseline(true);
		panelBarraEstado.setLayout(fl_panelBarraEstado);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(10);
		panelBarraEstado.add(horizontalStrut_2);
		
		JLabel txtRecord = new JLabel("Record: 00");
		txtRecord.setForeground(Color.ORANGE);
		txtRecord.setFont(new Font("Dialog", Font.BOLD, 16));
		panelBarraEstado.add(txtRecord);
		
		Component horizontalStrut = Box.createHorizontalStrut(120);
		panelBarraEstado.add(horizontalStrut);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setFont(new Font("Dialog", Font.BOLD, 14));
		progressBar.setForeground(Color.ORANGE);
		progressBar.setValue(25);
		panelBarraEstado.add(progressBar);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(120);
		panelBarraEstado.add(horizontalStrut_1);
		
		JLabel txtCantMovimientos = new JLabel("Movimientos: 12");
		txtCantMovimientos.setForeground(Color.ORANGE);
		txtCantMovimientos.setFont(new Font("Dialog", Font.BOLD, 16));
		panelBarraEstado.add(txtCantMovimientos);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(10);
		panelBarraEstado.add(horizontalStrut_3);
		
		
		
		
		
		
	}
}
