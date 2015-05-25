package proyectofinal_josegramage.Modulos.Juegos.Clases;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import proyectofinal_josegramage.Clases.Fecha;
import proyectofinal_josegramage.Main;


@XStreamAlias("Juego")
public class Juego implements Comparable<Juego>, Serializable {

    @XStreamAlias("ref")
    public String ref;
    @XStreamAlias("nombre")
    public String nombre;
    @XStreamAlias("companyia")
    public String companyia;
    @XStreamAlias("descripcion")
    public String descripcion;
    @XStreamAlias("fecha_alta")
    public Fecha fecha_alta;
    @XStreamAlias("tipo")
    public String tipo;
    @XStreamAlias("precio")
    public float precio;
    @XStreamAlias("imagen")
    public String imagen;
       

    public Juego() {
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Juego(String ref, String nombre, String companyia, String descripcion, Fecha fecha_alta, String tipo, float precio, String imagen) {

        this.ref = ref;
        this.nombre = nombre;
        this.companyia = companyia;
        this.descripcion = descripcion;
        this.fecha_alta = fecha_alta;
        this.tipo = tipo;
        this.precio = precio;
        this.imagen = imagen;
                        
    }

    public Juego(String ref) {
        this.ref = ref;
    }
    
   
    @Override
    public String toString() {
       
        String toS = " Nombre= " + nombre + "\n Referencia= " + ref + "\n Companyia= " + companyia 
                    +  "\n Descripcion= " + descripcion + "\n Fecha de alta= " + getFecha_alta().aStringFecha() + "\n Tipo: " + tipo
                    +  "\n Precio = " + precio + " €";
                    

        StringBuffer cadena = new StringBuffer();
        cadena.append(toS);
        return cadena.toString();
    }
      

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCompanyia() {
        return companyia;
    }

    public void setCompanyia(String companyia) {
        this.companyia = companyia;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
     public String getTipo (){
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
       public float getPrecio (){
        return precio;
    }
    
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
    
    public Fecha getFecha_alta() {
        return fecha_alta;
    }

    public void setFecha_alta(Fecha fecha_alta) {
        this.fecha_alta = fecha_alta;
    }
 
    public String getImagen (){
        return imagen;
    }
    
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
   
    

    //   @Override
    public int compareTo(Juego jue) {//para ordenar los clientes
        if (this.getRef().compareTo(jue.getRef()) > 0) {
            return 1;
        }
        if (this.getRef().compareTo(jue.getRef()) < 0) {
            return -1;
        }
        return 0;
    }

    //   @Override

    public boolean equals(Object c) {
        return getRef().equals(((Juego) c).getRef());
    }
}