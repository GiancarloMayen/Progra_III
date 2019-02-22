package departamentos_empleados;

public class decide_depto {
    //variable encapsulada
    private String strDeptos;
    //metodo constructor
    public decide_depto() {
        //ciclo for que decide a que departamento va cada empleado
        for (int a = 0; a < 9; a++) {
            byte decidir;
            decidir = (byte) ((Math.random() * 5) + 1);
            switch (decidir) {//switch que designa el departamento para mandar al vector
                case 1:
                    strDeptos = "Ingenieria";
                    break;
                case 2:
                    strDeptos = "Recursos H.";
                    break;
                case 3:
                    strDeptos = "Contabilidad";
                    break;
                case 4:
                    strDeptos = "Auditoria";
                    break;
                case 5:
                    strDeptos = "Secretaria";
                    break;
                default:
                    break;
            }//fin del switch     
        }//fin del for
    }//fin del constructor

    //creamos un setter que decide a que departamento pertenece cada persona
    public void decidirDepto(String strDeptos) {

        this.strDeptos = strDeptos;
    }

    //getter que llena el vector con sus respectivos departamentos
    public String decide_depto() {
        return strDeptos;
    }

}
