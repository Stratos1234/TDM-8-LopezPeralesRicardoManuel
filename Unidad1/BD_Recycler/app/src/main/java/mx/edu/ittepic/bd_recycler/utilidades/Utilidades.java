package mx.edu.ittepic.bd_recycler.utilidades;




public class Utilidades {
    public static String TABLA="usuario";
    public static String CLAVE="clave";
    public static String NOMBRE="nombre";
    public static String SUELDO="sueldo";
    public static String ID="_id";

    public static final String DBNAME="usuarios";


    public static String CREAR_TABLA="CREATE TABLE "+TABLA+"("+
            ID +" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            CLAVE+" TEXT NOT NULL, "+
            NOMBRE+" TEXT, " +
            SUELDO+" TEXT)";


}
