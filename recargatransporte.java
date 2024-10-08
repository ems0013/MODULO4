package Modulo4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;


 // Importa JOptionPane para mostrar mensajes

public class recargatransporte extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JComboBox<String> recargar_mes;
    private JTextField recargar_cantidad; // Campo de texto para la cantidad

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	recargatransporte frame = new recargatransporte();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public recargatransporte() 
    {
    	//PAGINA
		setIconImage(Toolkit.getDefaultToolkit().getImage(recargatransporte.class.getResource("/imagenes/logotransporte.png")));
		setTitle("Transportes Sevilla");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		//CENTRAR
		setLocationRelativeTo(null);
       
		//FONDO
		JLabel fondo = new JLabel(" ");
		fondo.setBounds(0, 0, 484, 700);
		ImageIcon img_fondo =new ImageIcon(getClass().getResource("/imagenes/fondo.jpg"));
		ImageIcon img1_fondo =new ImageIcon(img_fondo.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_SMOOTH));
		fondo.setIcon(img1_fondo);
			
		//LOGO
	    JLabel logo = new JLabel(" ");
	    logo.setBounds(0, 482, 115, 79);
	    ImageIcon img_logo =new ImageIcon(getClass().getResource("/imagenes/logotransporte.png"));
	    ImageIcon img1_logo =new ImageIcon(img_logo.getImage().getScaledInstance(logo.getWidth(), logo.getHeight(), Image.SCALE_SMOOTH));
		logo.setIcon(img1_logo);
	    contentPane.add(logo);   
	    
		//LABEL "RECARGA"
	    JLabel recargar_abono = new JLabel("RECARGAR");
	    recargar_abono.setHorizontalAlignment(SwingConstants.CENTER);
	    recargar_abono.setFont(new Font("DialogInput", Font.BOLD, 16));
	    recargar_abono.setBounds(175, 171, 133, 24);
	    contentPane.add(recargar_abono);
	    
	    //LABEL "CANTIDAD A RECARGAR"
        JLabel recargar_cantidad_label = new JLabel("Cantidad a recargar:");
        recargar_cantidad_label.setFont(new Font("DialogInput", Font.BOLD, 11));
        recargar_cantidad_label.setHorizontalAlignment(SwingConstants.LEFT);
        recargar_cantidad_label.setBounds(175, 269, 140, 24);
        contentPane.add(recargar_cantidad_label);
        
		//LABEL "SELECCIONE EL MES"
	    JLabel recargar_mes_label = new JLabel("Seleccione el mes:");
	    recargar_mes_label.setFont(new Font("DialogInput", Font.BOLD, 11));
	    recargar_mes_label.setHorizontalAlignment(SwingConstants.LEFT);
	    recargar_mes_label.setBounds(175, 206, 133, 24);
	    contentPane.add(recargar_mes_label);
	    
		//BANNER
	    JLabel banner = new JLabel(" ");
	    banner.setBounds(0, 0, 484, 121);
	    ImageIcon img_banner =new ImageIcon(getClass().getResource("/imagenes/Logo-junta-andalucia-europa-pie-pagina.png"));
	    ImageIcon img1_banner =new ImageIcon(img_banner.getImage().getScaledInstance(banner.getWidth(), banner.getHeight(), Image.SCALE_SMOOTH));
	    banner.setIcon(img1_banner);
	    contentPane.add(banner);
	    
		//TARJETA DE TRANSPORTE
	    JLabel img_tarjeta = new JLabel(" ");
	    img_tarjeta.setBounds(149, 378, 191, 129);
	    ImageIcon img_tarjetas =new ImageIcon(getClass().getResource("/imagenes/tarjeta_escuter.png"));
	    ImageIcon img1_tarjetas =new ImageIcon(img_tarjetas.getImage().getScaledInstance(img_tarjeta.getWidth(), img_tarjeta.getHeight(), Image.SCALE_SMOOTH));
	    img_tarjeta.setIcon(img1_tarjetas);
	    contentPane.add(img_tarjeta);     
       
        //COMBOBOX MESES
        String[] meses = 
        {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
        recargar_mes = new JComboBox<>(meses);
        recargar_mes.setFont(new Font("DialogInput", Font.PLAIN, 11));
        recargar_mes.setBounds(175, 234, 133, 24); 
        contentPane.add(recargar_mes);
       
        //INTRODUCIR CANTIDAD
        recargar_cantidad = new JTextField();
        recargar_cantidad.setBounds(175, 297, 133, 24);
        contentPane.add(recargar_cantidad);
       
        //BOTON RECARGA
        JButton boton_recargar = new JButton("Recargar abono");
        boton_recargar.setFont(new Font("DialogInput", Font.PLAIN, 11));
        boton_recargar.setBounds(175, 332, 133, 24);
        boton_recargar.addActionListener(e -> {
            String mesSeleccionado = (String) recargar_mes.getSelectedItem();
            String cantidadTexto = recargar_cantidad.getText();
            // Validar la entrada de cantidad
            if (!cantidadTexto.isEmpty()) 
            {
                try 
                {
                    double cantidad = Double.parseDouble(cantidadTexto);
                    JOptionPane.showMessageDialog(this, "Has recargado " + cantidad + " € para el mes de " + mesSeleccionado, "Recarga Exitosa", JOptionPane.INFORMATION_MESSAGE);
                } 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(this, "Por favor, introduce una cantidad numérica.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(this, "Por favor, introduce una cantidad.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        contentPane.add(boton_recargar);
       
	    //AL FINAL PARA VER LOS BOTONES
        contentPane.add(fondo);	   
    }
}