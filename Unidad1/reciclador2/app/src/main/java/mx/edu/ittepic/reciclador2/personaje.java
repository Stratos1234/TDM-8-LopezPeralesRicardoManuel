package mx.edu.ittepic.reciclador2;

public class personaje {


    private String nombre;
    private String info;
    private String carre;
    private int foto;
    private int foto2;


    public personaje()
    {

    }

    public personaje(String nombre, String info,String carre, int foto,int foto2) {
        this.nombre = nombre;
        this.info = info;
        this.carre = carre;
        this.foto = foto;
        this.foto2=foto2;
    }

    public int getFoto2() {
        return foto2;
    }

    public void setFoto2(int foto2) {
        this.foto2 = foto2;
    }

    public String getCarre() {
        return carre;
    }

    public void setCarre(String carre) {
        this.carre = carre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
