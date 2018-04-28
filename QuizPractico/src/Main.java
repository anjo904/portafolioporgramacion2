/* Programa para crear fichero (si no existe) y escribir en el, y (si existe) preguntar a el usuario a ingresar un nuevo
    numero y este numero sumarlo con el ultimo que existe en el archivo y que solo se guarde la respuesta.
 */

import java.io.*;

public class Main {

    public static void main(String args []) {
        String archivo = "C:\\Users\\PC\\IdeaProjects\\QuizPractico\\src\\archivo.txt";
        String linea;
        int resp = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try{
            //para activar la escritura
            FileWriter fw = new FileWriter(archivo,true);
            BufferedWriter bw = new BufferedWriter(fw);

            //para preguntar con el nuevo numero
            System.out.print("Escriba Numero: ");
            String numero = br.readLine();

            //para la lectura del fichero
            FileReader fr = new FileReader(archivo);
            BufferedReader bf = new BufferedReader(fr);

            //sentencia while para que lea el fichero hasta que la respuesta sea nula (null)
            while ((linea = bf.readLine()) != null){

                //convertir la linea de string a int (entero)
                resp = Integer.parseInt(linea);

                //imprimir en pantalla la linea
                System.out.println (linea);

            }

            //convertir numero de entrada por el usuario a int
            int sumando = Integer.parseInt(numero);

            //crear int para resultado de la suma de el sumando y la linea resp
            int resultado = resp + sumando;

            // convertir resultado a string llamado respuesta para que pueda ser guardado en el fichero

            String respuesta = String.valueOf(resultado);

            // codigo para que se escribir en el fichero
            bw.write(respuesta);
            bw.write("\n");

            // para cerrar la lectura y escritura
            bw.close();
            bf.close();

            //para imprimir la respuesta
            System.out.println(respuesta);

            //excepciones si no se encuentra o problemas con leer archivo
        } catch (FileNotFoundException e) {
            System.out.println("No Se Encontro Archivo");
        } catch (IOException e) {
            System.out.println("Error con el Archivo");
        }
    }
}
