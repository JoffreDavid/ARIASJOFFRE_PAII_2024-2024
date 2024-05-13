package Vistas;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import DAO.StudentDAO;
import models.Student;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class VistaTablas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel studentPanel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VistaTablas frame = new VistaTablas();
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
    public VistaTablas() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 678, 558);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnStudent = new JButton("Student");
        btnStudent.setBounds(10, 29, 89, 23);
        contentPane.add(btnStudent);

        // Panel para contener los botones CRUD
        studentPanel = new JPanel();
        studentPanel.setBounds(120, 10, 532, 498);
        contentPane.add(studentPanel);
        studentPanel.setLayout(null);
        studentPanel.setVisible(false); // Ocultar el panel al inicio

        // Botones CRUD dentro del panel studentPanel
        JButton btnCreate = new JButton("Create");
        btnCreate.setBounds(30, 50, 120, 30);
        studentPanel.add(btnCreate);

        JButton btnRead = new JButton("Read");
        btnRead.setBounds(30, 100, 120, 30);
        studentPanel.add(btnRead);

        JButton btnUpdate = new JButton("Update");
        btnUpdate.setBounds(30, 150, 120, 30);
        studentPanel.add(btnUpdate);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setBounds(30, 200, 120, 30);
        studentPanel.add(btnDelete);
        
        // JTextArea para mostrar la información del estudiante
        JTextArea textArea = new JTextArea();
        textArea.setBounds(200, 50, 300, 300);
        textArea.setEditable(false);
        studentPanel.add(textArea);

        // ActionListener para el botón "Student"
        btnStudent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Mostrar u ocultar el panel de botones CRUD al hacer clic en "Student"
                studentPanel.setVisible(!studentPanel.isVisible());
            }
        });

        // ActionListener para el botón "Create"
        btnCreate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Solicitar datos por medio de cuadros de diálogo de entrada
                String idStr = JOptionPane.showInputDialog("Enter Student ID:");
                String name = JOptionPane.showInputDialog("Enter Student Name:");
                String lastName = JOptionPane.showInputDialog("Enter Student Last Name:");
                String ageStr = JOptionPane.showInputDialog("Enter Student Age:");

                try {
                    // Convertir los datos ingresados a tipos adecuados
                    int id = Integer.parseInt(idStr);
                    int age = Integer.parseInt(ageStr);

                    // Llamar al método createStudent del DAO con los datos ingresados
                    StudentDAO dao = new StudentDAO();
                    dao.createStudent(id, name, lastName, age);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers for ID and Age.");
                }
            }
        });

        // Puedes agregar ActionListener individuales para cada botón CRUD
        btnRead.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Solicitar el ID del estudiante a buscar
                String idStr = JOptionPane.showInputDialog("Enter Student ID:");

                try {
                    // Convertir el ID ingresado a entero
                    int id = Integer.parseInt(idStr);

                    // Obtener el estudiante con el ID especificado
                    StudentDAO dao = new StudentDAO();
                    Student student = dao.readStudent(id);

                    if (student != null) {
                        // Mostrar la información del estudiante en el JTextArea
                        String studentInfo = "ID: " + student.getId() + "\n"
                                + "Name: " + student.getName() + "\n"
                                + "Last Name: " + student.getLastName() + "\n"
                                + "Age: " + student.getAge();
                        textArea.setText(studentInfo);
                    } else {
                        // Mostrar un mensaje si el estudiante no fue encontrado
                        textArea.setText("Student not found.");
                    }
                } catch (NumberFormatException ex) {
                    // Manejar errores de conversión de ID inválido
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid Student ID.");
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Solicitar el ID del estudiante a actualizar
                String idStr = JOptionPane.showInputDialog("Enter Student ID:");

                try {
                    // Convertir el ID ingresado a entero
                    int id = Integer.parseInt(idStr);

                    // Obtener el estudiante con el ID especificado
                    StudentDAO dao = new StudentDAO();
                    Student student = dao.readStudent(id);

                    if (student != null) {
                        // Mostrar los detalles del estudiante a actualizar
                        String name = JOptionPane.showInputDialog("Enter new Name:");
                        String lastName = JOptionPane.showInputDialog("Enter new Last Name:");
                        String ageStr = JOptionPane.showInputDialog("Enter new Age:");

                        // Convertir la nueva edad ingresada a entero
                        int age = Integer.parseInt(ageStr);

                        // Actualizar el estudiante con los nuevos datos
                        dao.updateStudent(id, name, lastName, age);

                        // Mostrar los datos actualizados en el JTextArea
                        String updatedInfo = "ID: " + id + "\n"
                                + "Name: " + name + "\n"
                                + "Last Name: " + lastName + "\n"
                                + "Age: " + age;
                        textArea.setText(updatedInfo);
                    } else {
                        // Mostrar un mensaje si el estudiante no fue encontrado
                        textArea.setText("Student not found.");
                    }
                } catch (NumberFormatException ex) {
                    // Manejar errores de conversión de ID inválido
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid Student ID.");
                }
            }
        });

        btnDelete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                // Solicitar el ID del estudiante a eliminar
                String idStr = JOptionPane.showInputDialog("Enter Student ID to delete:");

                try {
                    // Convertir el ID ingresado a entero
                    int id = Integer.parseInt(idStr);

                    // Eliminar al estudiante con el ID especificado
                    StudentDAO dao = new StudentDAO();
                    dao.deleteStudent(id);

                    // Mostrar mensaje de éxito en un cuadro de diálogo
                    JOptionPane.showMessageDialog(null, "Student with ID " + id + " deleted successfully.");

                } catch (NumberFormatException ex) {
                    // Manejar errores de conversión de ID inválido
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid Student ID.");
                }
            }
        });
    }
}
