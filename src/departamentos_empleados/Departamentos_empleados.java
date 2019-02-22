package departamentos_empleados;
import javax.swing.JOptionPane;
public class Departamentos_empleados {

    // Autor Giancarlo
    
    
    
    /* Este programa esta diseniado para calcular los sueldos de los empleados de una empresa en forma aleatoria,
        para esto utilizamos vectores,matrices,que nos ayudan a poder realizar el trabajo de una forma mas rapida
        con la ayuda de varios ciclos for.
    */
    
    public static void main(String[] args) {
        // declaramos las constantes al principio del programa
        final float IGSS=4.83f;
        final short ftBonificaciones = 250;
        short sueldoIng=15000,sueldoRH=9000,sueldoCon=8000,sueldoAud=10000,sueldoSec=4000,isr=0;
        
        //creamos objetos para paso de parametros donde se decide el departamento
        decide_depto dd1=new decide_depto();decide_depto dd2=new decide_depto();
        decide_depto dd3=new decide_depto();decide_depto dd4=new decide_depto();
        decide_depto dd5=new decide_depto();decide_depto dd6=new decide_depto();
        decide_depto dd7=new decide_depto();decide_depto dd8=new decide_depto();
        decide_depto dd9=new decide_depto();decide_depto dd10=new decide_depto();
        
        //creamos el vector que designa a donde van a pertenecer nuestros empleados
        String [] strDepto_Emplea2=new String[10];
        
        //llenamos el vector con cada objeto
        strDepto_Emplea2[0]=dd1.decide_depto();strDepto_Emplea2[1]=dd2.decide_depto();
        strDepto_Emplea2[2]=dd3.decide_depto();strDepto_Emplea2[3]=dd4.decide_depto();
        strDepto_Emplea2[4]=dd5.decide_depto();strDepto_Emplea2[5]=dd6.decide_depto();
        strDepto_Emplea2[6]=dd7.decide_depto();strDepto_Emplea2[7]=dd8.decide_depto();
        strDepto_Emplea2[8]=dd9.decide_depto();strDepto_Emplea2[9]=dd10.decide_depto();
        
        //declaramos una matriz de tipo short con dimensiones de: 10 filas y 7 columnas
        short matrix[][] = new short[10][7];
     
        
        //declaramos un vector de tipo String con diferentes nombres de los empleados ya ingresados en el vector
        String [] strNombres={"Alexa","Brandom","Anahi","Steven","David","Lorena","Rocio","Mario","Valerio","Jimena","Emanuel"};
        //creamos un vector de 5 posiciones que contiene los nombres de cada departamento de la empresa
        String [] strDepartamentos={"Ingenieria","Recursos H.","Contabilidad","Auditoria","Huachicolero"};
 
        /*columnas de la matriz:
        1:  van los sueldos de las personas
        2:  van las bonificaciones de las personas 250
        3:  van las comisiones de las personas
        4:  van el igss de las personas
        5:  van el isr de las personas
        6:  va el descuento del bantrab
        7:  va el sueldo total
        */
        
         //mostramos un OptionPane en pantalla que nos indica cuales son los departamentos que existen clasificandolos por numeros
        JOptionPane.showMessageDialog(null, "Los departamentos que exiten son:\n\n1: Ingenieria\n2: RRHH\n3: Contabilidad\n4: Auditoria\n5: Huachicolero"); 
        
        //creamos un ciclo for que nos ayude a llenar la matriz con cada sueldo y descuento en sus respectivas posiciones       
        for (int z = 0; z < 10; z++) {
          //  byte alf=(byte)((Math.random()*10)+1);
            String depto= strDepto_Emplea2[z];
            
            if (depto.equals("Ingenieria")) {
                matrix[z][0] = sueldoIng;
            } else if (depto.equals("Recursos H.")) {
                matrix[z][0] = sueldoRH;
            } else if (depto.equals("Contabilidad")) {
                matrix[z][0] = sueldoCon;
            } else if (depto.equals("Auditoria")) {
                matrix[z][0] = sueldoAud;
            } else if (depto.equals("Secretaria")) {
                matrix[z][0] = sueldoSec;
            }
            
            //creamos un if que decide si se sacara isr al empleado o no
            if (JOptionPane.showConfirmDialog(null,"   ¿Es afectado? "+strNombres[z],"  AFECTADOS POR EL ISR",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                     //if (alf % 2 == 0) {
                         //if que decide que porcentaje de isr se aplicara
                         if (matrix[z][0] >= 2600 && matrix[z][0] <= 5000) {
                             isr = (short) ((matrix[z][0] * 3) / 100);
                         } else if (matrix[z][0] >= 5001 && matrix[z][0] <= 10000) {
                             isr = (short) ((matrix[z][0] * 5) / 100);
                         } else if (matrix[z][0] >= 10001) {
                             isr = (short) ((matrix[z][0] * 10) / 100);
                         }
                    // } //fin del if
                     else {//else que indica que si no se sacara isr entonces isr=0
                         matrix[z][4] = (short) (isr*0);
                     }
                     matrix[z][4] = isr;
             }
            //aqui declaramos variables de tipo short que nos guardan de forma aleatoria el sueldo,descuento,etc en cada variable
            short ftComisiones = (short) ((Math.random() * 700) + 200);
            short ftIGSS = (short) ((matrix[z][0] * IGSS) / 100);
            short fBancoTrabajadores = (short) ((Math.random() * 1000) + 2000);
            short shrTotal = (short) ((matrix[z][0] + ftBonificaciones + ftComisiones) - (ftIGSS + fBancoTrabajadores));

            //y estos a su vez se guardan el cada posicion de la matriz especificada**
            
            matrix[z][1] = ftBonificaciones;
            matrix[z][2] = ftComisiones;
            matrix[z][3] = ftIGSS;
            matrix[z][5] = fBancoTrabajadores;
            matrix[z][6] = shrTotal;

        }//fin del ciclo for

         
        //mostramos 2 mensajes,1 que  nos indican los titulos de las columnas
        System.out.println("                                        _______________                                ___________");
        System.out.println("          \t\t                 |Bonificaciones|           -                   |Descuentos|");
        System.out.println("                                        ---------------                                -----------");
        System.out.println("Emplea2\tDepartamento\t      Sueldo Base + (Bonificaciones+comisiones) -  (  IGSS\t\t+ ISR     +    BT )     =    Total");
        //y el otro que nos separa el titulo con unas lineas para diferenciar los datos
        System.out.println("------------------------------------------------------------------------------------------------------------------------------");
        
        //ciclo for para recorrer la matriz
        for (int a = 0; a < 10; a++) {//primer ciclo que recorre las filas
            //System.out.println();println que nos deja
            System.out.print(strNombres[a] +"\t"+strDepto_Emplea2[a]+ "\t\t ");//primer mensaje que nos muestra el vector de nombres en pantalla

            for (int b = 0; b < 7; b++) {//inicico del segundo ciclo for que recorre las columnas

                System.out.printf(matrix[a][b] + "\t\t");//mensaje en pantalla que nos muestra la matriz con sus respectivos valores
            }//fin del segundo ciclo for
            //salto de linea para separar cada fila
            System.out.println();
        }//fin del primer ciclo for

        //aqui creamos variables de tipo short en donde le vamos a guardar la suma de los sueldos de cada departamento
        int shrSuma_sueldos1=0,shrSuma_sueldos2=0,shrSuma_sueldos3=0,shrSuma_sueldos4=0,shrSuma_sueldos5=0;
            
//creamos un ciclo for que recorrera la columna 4 de la matriz en donde estan guardados el numero de departamento para poder sumar los sueldos

        for(int i=0;i<10;i++){//ciclo for que recorre la matriz
            String aca=strDepto_Emplea2[i];//aqui igualamos la variable bite al valor que esta en la fila del 1 al 10 y la columna 4
            //creamos un switch poniendo como parametro la variable byte
            switch(aca){//inicio del switch
                
                case "Ingenieria":{//caso 1 si la variable es igual a 1 que significa que pertenece al departamento de Ingenieria
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos1=(shrSuma_sueldos1+matrix[i][6]);
                    break;//break
                }//fin del caso 1
                
                case "Recursos H.":{//caso 2 si la variable es igual a 1 que significa que pertenece al departamento de Recursos Humanos
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos2=(shrSuma_sueldos1+matrix[i][6]);
                    break;
                }//fin del caso 2
                
                case "Contabilidad":{//caso 3 si la variable es igual a 1 que significa que pertenece al departamento de Contabilidad
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos3=(shrSuma_sueldos1+matrix[i][6]);
                    break;
                }//fin del caso 3
                
                case "Auditoria":{//caso 4 si la variable es igual a 1 que significa que pertenece al departamento de Auditoria
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos4=(shrSuma_sueldos1+matrix[i][6]);
                    break;
                }//fin del caso 4
                
                case "Secretaria":{//caso 5 si la variable es igual a 1 que significa que pertenece a Secretaria
                    //ponemos que la variable=variable mas el valor que tiene el sueldo en la matriz
                    shrSuma_sueldos5=(shrSuma_sueldos1+matrix[i][6]);
                    break;
                }//fin del caso 5
                
                default:break;
            }//fin del switch
            
        }//fin del ciclo for
        int shrVector[]=new int[5];//
        
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
       // JOptionPane.showMessageDialog(null, "ahora mostraremos el vector que contiene el nombre del departamento + la suma de los sueldos de cada departamento");
        
        //muestra en consola el titulo departamento y sueldos totales
        System.out.println("\t\t\tDepartamento  Sueldos Totales \n");
        
        //creamos un ciclo for que nos muestre el vector con los sueldos sumados en el for anterior
        for(int j=0;j<5;j++){//inicio del ciclo for
            //mostramos en pantalla los 2 vectores
            System.out.println("\t\t"+(j+1)+"\t"+strDepartamentos[j]+"\t"+shrVector[j]);
        }//fin del ciclo for

        //falta arreglar lo de los float, no me deja ponerle solo 2 decimales, solo coregir eso y ordenar los numeros y columnas
    }
    
}
