package entidades;

import java.util.Arrays;
import java.util.Date;

public class Vuelo {

    private int id;

    private int numero;

    public transient int longitudMillas;

    public int longitudPies;

    private int longitud;

    private Date horaSalida;

    public enum TipoVuelo {NACIONAL,EUROPA,ASIA,AMERICA};

    private TipoVuelo tipoVuelo;

    private String texto;

    private char[] codigo;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getLongitudMillas() {
        return longitudMillas;
    }
    public void setLongitudMillas(int longitudMillas) {
        this.longitudMillas = longitudMillas;
    }
    public int getLongitud() {
        return longitud;
    }
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    public Date getHoraSalida() {
        return horaSalida;
    }
    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }
    public TipoVuelo getTipo() {
        return tipoVuelo;
    }
    public void setTipo(TipoVuelo tipo) {
        this.tipoVuelo = tipo;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }

    public char[] getCodigo() {
        return codigo;
    }
    public void setCodigo(char[] codigo) {
        this.codigo = codigo;
    }


    public int getLongitudPies() {
        return longitudPies;
    }

    public void setLongitudPies(int longitudPies) {
        this.longitudPies = longitudPies;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "id=" + id +
                ", numero=" + numero +
                ", longitudMillas=" + longitudMillas +
                ", longitudPies=" + longitudPies +
                ", longitud=" + longitud +
                ", horaSalida=" + horaSalida +
                ", tipoVuelo=" + tipoVuelo +
                ", texto='" + texto + '\'' +
                ", codigo=" + Arrays.toString(codigo) +
                '}';
    }

    public TipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }
    public void setTipoVuelo(TipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }



}
