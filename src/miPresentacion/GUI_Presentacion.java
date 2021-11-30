package miPresentacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUI_Presentacion extends JFrame {

    //atributos

    public GUI_Presentacion() {
        initGUI();

        this.setTitle("Mi Presentacion");
        this.setSize(800, 800);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private JButton miFoto, misHobbies, misExpectativas;
    private Titulos titulo;
    private JPanel panelBotones, panelDatos;
    private JLabel labelImagen;
    private JTextArea textoExpectativas,textoHobbies;
    private Escucha escucha;



    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GUI_Presentacion mIGUIPresentacion = new GUI_Presentacion();
            }
        });
    }


    private void initGUI() {
        //definir Conainer y Layout
        //crear objetos Escucha y controles
        // definir JComponents

        escucha = new Escucha();


        titulo = new Titulos("Hola soy Manuel :D", Color.BLACK);
        this.add(titulo, BorderLayout.NORTH);

        panelDatos = new JPanel();
        panelDatos.setBorder(BorderFactory.createTitledBorder(null, "Este soy yo:", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Arial", Font.PLAIN, 20), Color.BLACK));

        this.add(panelDatos, BorderLayout.CENTER);

        miFoto = new JButton("Mi foto ;3");
        miFoto.addMouseListener(escucha);
        misHobbies = new JButton("Este es mi hobby:");
        misHobbies.addMouseListener(escucha);
        misExpectativas = new JButton("Mis Expectativas son:");
        misExpectativas.addKeyListener(escucha);

        panelBotones = new JPanel();
        panelBotones.add(miFoto);
        panelBotones.add(misHobbies);
        panelBotones.add(misExpectativas);


        this.add(panelBotones, BorderLayout.AFTER_LAST_LINE);


        labelImagen = new JLabel();
        textoExpectativas = new JTextArea(10,12);




    }
/*
    private class Escucha implements ActionListener {
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e) {
            panelDatos.removeAll();;
            if (e.getSource() == miFoto) {
                image= new ImageIcon(getClass().getResource("/recursos/mifoto.jpeg"));
                labelImagen.setIcon(image);
                panelDatos.add(labelImagen);



            } else {
                if (e.getSource() == misHobbies) {
                    image= new ImageIcon(getClass().getResource("/recursos/hobbies.jpeg"));
                    labelImagen.setIcon(image);
                    panelDatos.add(labelImagen,textoHobbies);



                } else {


                    textoExpectativas.setText("Mis expectativas para este semestre \n" +
                            "Es aprender todo lo que pueda de este semestre :D \n" +
                            "Crear con mis compañeros programas bonitos ");
                    textoExpectativas.setBackground(null);
                    panelDatos.add(textoExpectativas);

                }
            }
            revalidate();
            repaint();
        }
    }


    */
    private class Escucha implements MouseListener, KeyListener{
    private ImageIcon image;
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar()=='m' ||e.getKeyChar()=='a'){
            panelDatos.removeAll();
            textoExpectativas.setText("Mis expectativas para este semestre \n" +
                    "Es aprender todo lo que pueda de este semestre :D \n" +
                    "Crear con mis compañeros programas bonitos ");
            textoExpectativas.setBackground(null);
            panelDatos.add(textoExpectativas);


        }
        revalidate();
        repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent()==miFoto && e.getClickCount()==1){
            panelDatos.removeAll();
            image= new ImageIcon(getClass().getResource("/recursos/mifoto.jpeg"));
            labelImagen.setIcon(image);
            panelDatos.add(labelImagen);
        }
        if (e.getComponent()==misHobbies && e.getClickCount()==2){
            panelDatos.removeAll();
            image= new ImageIcon(getClass().getResource("/recursos/hobbies.jpeg"));
            labelImagen.setIcon(image);
            panelDatos.add(labelImagen,textoHobbies);
        }
        revalidate();
        repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
}


