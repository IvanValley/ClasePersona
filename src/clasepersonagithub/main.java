/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clasepersonagithub;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

import java.util.Scanner;

/**
 *
 * @author matam
 */
public class main {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Commit 1");
        
        System.out.println("Commit 2");
        
        System.out.println("Commit 3");
        
        System.out.println("Commit 4");
        
        System.out.println("Commit 5");

        int numPersonas;
        int numPersonasSinFecha;
        String nombre;
        String apellidos;
        String fecha;
        String cadenaNuevaFecha;
        boolean fechaCorrecta;

        Persona persona;

        numPersonas = sc.nextInt();
        numPersonasSinFecha = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numPersonas; i++) {

            nombre = sc.nextLine();
            apellidos = sc.nextLine();
            fecha = sc.nextLine();

            try {
                persona = new Persona(nombre, apellidos, fecha);
                fecha = persona.getFechaNacimiento();

                System.out.println("Procesado: " + persona.getNombre() + " "
                        + persona.getApellidos()
                        + ", nacido el " + fecha.substring(0, 2)
                        + " del " + fecha.substring(3, 5) + " de " + fecha.substring(6));

            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }

        for (int i = 1; i <= numPersonasSinFecha; i++) {

            nombre = sc.nextLine();
            apellidos = sc.nextLine();

            try {
                persona = new Persona(nombre, apellidos);
                fecha = persona.getFechaNacimiento();
                System.out.println("Procesado: " + persona.getNombre() + " "
                        + persona.getApellidos() + ", nacido el " + fecha);

                if (i == numPersonasSinFecha) {
                    fechaCorrecta = false;
                    cadenaNuevaFecha = sc.nextLine();

                    while (!fechaCorrecta) {
                        try {
                            persona.setFechaNacimiento (cadenaNuevaFecha);
                            fecha = persona.getFechaNacimiento();
                            fechaCorrecta = true;

                            System.out.println("Procesado: " + persona.getNombre() + " "
                                    + persona.getApellidos()
                                    + ", nacido el " + fecha.substring(0, 2)
                                    + " del " + fecha.substring(3, 5) + " de " + fecha.substring(6));

                        } catch (IllegalArgumentException e) {
                            System.out.println("Fecha Incorrecta");
                            cadenaNuevaFecha = sc.nextLine();
                        }

                    }

                }
            } catch (IllegalArgumentException e) {
                System.out.println("ERROR. Procesando siguiente persona");
            }

        }

    }
}