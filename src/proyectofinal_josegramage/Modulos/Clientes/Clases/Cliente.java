package proyectofinal_josegramage.Modulos.Clientes.Clases;

import java.io.Serializable;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import proyectofinal_josegramage.Clases.Fecha;
import proyectofinal_josegramage.Main;


@XStreamAlias("Cliente")
public class Cliente implements Comparable<Cliente>, Serializable {

    @XStreamAlias("nombre")
    public String nombre;
    @XStreamAlias("apellidos")
    public String apellidos;
    @XStreamAlias("dni")
    public String dni;
    @XStreamAlias("telefono")
    public String telefono;
    @XStreamAlias("direccion")
    public String direccion;
    @XStreamAlias("email")
    public String email;
    @XStreamAlias("fnacimiento")
    public Fecha fnacimiento;
    @XStreamAlias("fechaalta")
    public Fecha fechaalta;
    @XStreamAlias("login")
    public String login;
    @XStreamAlias("password")
    public String password;
    @XStreamAlias("estado")
    public String estado;
    @XStreamAlias("tipo")
    public String tipo;
    @XStreamAlias("avatar")
    public String avatar;
    

    public Cliente() {
    }

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public Cliente(String nombre, String apellidos, String dni, String telefono, String direccion, String email, Fecha fnacimiento,
            Fecha fechaalta, String login, String password, String estado, String tipo, String avatar) {

        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.email = email;
        this.fnacimiento = fnacimiento;
        this.fechaalta = fechaalta;
        this.login = login;
        this.password = password;
        this.estado = estado;
        this.tipo = tipo; 
        this.avatar = avatar;
                
    }

    public Cliente(String dni) {
        this.dni = dni;
    }
    
   
    @Override
    public String toString() {
       
        String toS = " Usuario= " + login +"\n --------" + "\n Nombre= " + nombre + "\n Apellidos= " + apellidos + "\n Dni= " + dni 
                    +  "\n Telefono= " + telefono + "\n Direccion= " + direccion + "\n Email: " + email + "\n Fecha de nacimiento= "
                    + getFnacimiento().aStringFecha() + "\n Fecha de alta= "+ getFechaalta().aStringFecha();

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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
     public String getDireccion (){
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
       public String getEmail (){
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public Fecha getFnacimiento() {
        return fnacimiento;
    }

    public void setFnacimiento(Fecha fnacimiento) {
        this.fnacimiento = fnacimiento;
    }

    public Fecha getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Fecha fechaalta) {
        this.fechaalta = fechaalta;
    }
    
       
    public String getLogin (){
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    
    public String getPassword (){
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
     
    
    public String getEstado (){
        return estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getTipo (){
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
     public String getAvatar (){
        return avatar;
    }
    
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
    

    //   @Override
    public int compareTo(Cliente cli) {//para ordenar los clientes
        if (this.getDni().compareTo(cli.getDni()) > 0) {
            return 1;
        }
        if (this.getDni().compareTo(cli.getDni()) < 0) {
            return -1;
        }
        return 0;
    }

    //   @Override

    public boolean equals(Object c) {
        return getDni().equals(((Cliente) c).getDni());
    }
}