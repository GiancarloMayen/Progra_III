package departamentos_empleados;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class Departamentos_empleados {

    /* Este programa esta diseñado para calcular los sueldos de los empleados de una empresa en forma aleatoria,
        para esto utilizamos vectores,matrices,que nos ayudan a poder realizar el trabajo de una forma mas rapida
        con la ayuda de varios ciclos for.
        
    */
    public static void main(String[] args) {
        
        Scanner entrada=new Scanner(System.in);//declaramos una variable de tipo scanner 
        
        //declaramos un vector de tipo String con diferentes nombres de los empleados ya ingresados en el vector
        String [] strNombres={"Alexa","Brandom","Anahi","Steven","David","Lorena","Rocio","Mario","Valerio","Jimena","Emanuel"};
        //creamos un vector de 5 posiciones que contiene los nombres de cada departamento de la empresa
        String [] strDepartamentos={"Ingenieria","Recursos H.","Contabilidad","Auditoria","Huachicolero"};
        //declaramos una matriz de tipo short con dimensiones de: 10 filas y 5 columnas
        short matrix[][]=new short[10][5];
        
        
        
        
        //creamos un ciclo for que nos ayude a llenar la matriz con cada sueldo y descuento en sus respectivas posiciones       
        for(int z=0;z<10;z++){
            //aqui declaramos variables de tipo short que nos guardan de forma aleatoria el sueldo,descuento,etc en cada variable
            short shrSueldos=(short)((Math.random()*6000)+2000);
            short shrDescuentos=(short)((Math.random()*500)+200);
            short shrBonificaciones=(short)((Math.random()*700)+200);
            byte btDepto=(byte) ((Math.random()*5)+1);
            short shrTotal=(short) (shrSueldos+shrBonificaciones-shrDescuentos);
            //y estos a su vez se guardan el cada posicion de la matriz especificada
            matrix[z][0]=shrSueldos;
            matrix[z][1]=shrDescuentos;
            matrix[z][2]=shrBonificaciones;
            matrix[z][3]=shrTotal;
            matrix[z][4]=btDepto;
            
        }//fin del ciclo for
        
        //mostramos un OptionPane en pantalla que nos indica cuales son los departamentos que existen clasificandolos por numeros
        JOptionPane.showMessageDialog(null, "los departamentos que exiten son:\n1: Ingenieria\n2: RRHH\n3: Contabilidad\n4: Auditoria\n5: Huachicolero");
        
        
        //mostramos 2 mensajes,1 que  nos indican los titulos de las columnas
        System.out.println("Trabajador\tSueldo -   Descuentos  +  Bonif.  =  Total      Depto.");
        //y el otro que nos separa el titulo con unas lineas para diferenciar los datos
        System.out.println("------------------------------------------------------------------------");
        //ciclo for para recorrer la matriz
        for(int a=0;a<10;a++){//primer ciclo que recorre las filas
            //System.out.println();println que nos deja
            System.out.print(strNombres[a]+"\t\t ");//primer mensaje que nos muestra el vector de nombres en pantalla
            
            for(int b=0;b<5;b++){//inicico del segundo ciclo for que recorre las columnas
                
                System.out.print(matrix[a][b]+"         ");//mensaje en pantalla que nos muestra la matriz con sus respectivos valores
            }//fin del segundo ciclo for
            //salto de linea para separar cada fila
            System.out.println();
        }//fin del primer ciclo for
        
        //aqui creamos variables de tipo short en donde le vamos a guardar la suma de los sueldos de cada departamento
        short shrSuma_sueldos1=0,shrSuma_sueldos2=0,shrSuma_sueldos3=0,shrSuma_sueldos4=0,shrSuma_sueldos5=0;
        
//creamos un ciclo for que recorrera la columna 4 de la matriz en donde estan guardados el numero de departamento para poder sumar los sueldos
        for(int i=0;i<10;i++){//ciclo for que recorre la matriz
            byte btOpc;//creamos una variable de tipo bite
            btOpc=(byte)matrix[i][4];//aqui igualamos la variable bite al valor que esta en la fila del 1 al 10 y la columna 4
            //creamos un switch poniendo como parametro la variable byte
            switch(btOpc){//inicio del switch
                
                case 1:{//caso 1 si la variable es igual a 1 que significa que pertenece al departamento de Ingenieria
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos1=(short)(shrSuma_sueldos1+matrix[i][3]);
                    break;//break
                }//fin del caso 1
                
                case 2:{//caso 2 si la variable es igual a 1 que significa que pertenece al departamento de Recursos Humanos
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos2=(short)(shrSuma_sueldos1+matrix[i][3]);
                    break;
                }//fin del caso 2
                
                case 3:{//caso 3 si la variable es igual a 1 que significa que pertenece al departamento de Contabilidad
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos3=(short)(shrSuma_sueldos1+matrix[i][3]);
                    break;
                }//fin del caso 3
                
                case 4:{//caso 4 si la variable es igual a 1 que significa que pertenece al departamento de Auditoria
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos4=(short)(shrSuma_sueldos1+matrix[i][3]);
                    break;
                }//fin del caso 4
                
                case 5:{//caso 5 si la variable es igual a 1 que significa que pertenece a los huachicoleros
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos5=(short)(shrSuma_sueldos1+matrix[i][3]);
                    break;
                }//fin del caso 5
                
                default:break;
            }//fin del switch
            
        }//fin del ciclo for
        
        float shrVector[]=new float[5];//
        
        //aqui rellenamos el vector en su posicion especifica con el total de los sueldos sumados anteriormente en el switch
        shrVector[0]=shrSuma_sueldos1;
        shrVector[1]=shrSuma_sueldos2;
        shrVector[2]=shrSuma_sueldos3;
        shrVector[3]=shrSuma_sueldos4;
        shrVector[4]=shrSuma_sueldos5;
        
//creamos un for para que nos deje 30 espacios en pantalla, esto se hace para separar los datos que ya estan en pantalla con los nuevos datos
        for(int aa=0;aa<3;aa++){
            System.out.println();
        }
        
        //mostramos un OptionPane en pantalla que nos indica el nombre del departamento + la suma de los sueldos de cada departamento
        JOptionPane.showMessageDialog(null, "ahora mostraremos el vector que contiene el nombre del departamento + la suma de los sueldos de cada departamento");
        
        //muestra en consola el titulo departamento y sueldos totales
        System.out.println("\t\t\tDepartamento  Sueldos Totales \n");
        
        //creamos un ciclo for que nos muestre el vector con los sueldos sumados en el for anterior
        for(int j=0;j<5;j++){//inicio del ciclo for
            //mostramos en pantalla los 2 vectores
            System.out.println("\t\t"+(j+1)+"\t"+strDepartamentos[j]+"\t "+shrVector[j]);
        }//fin del ciclo for
        
        
        
        
    }
    
}
