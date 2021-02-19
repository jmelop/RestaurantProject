public class Mesa {
    public int identificador;
    public int capacidad;
    public Estado estado;

    public Mesa(int identificador, int capacidad) {
        this.identificador = identificador;
        this.capacidad = capacidad;
        this.estado = Estado.LIBRE;
    }

    public String getId() {
        return String.valueOf(this.identificador);
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public boolean estaLibre() {
        return estado.equals(Estado.LIBRE);
    }

    public void setLibre(boolean libre) {
        if (libre){
            this.estado = Estado.LIBRE;
        }else {
            this.estado = Estado.NOLIBRE;
        }
    }

    public String toString(){
        return "La mesa dispone del identificador: "+identificador+" con la capacidad de "+capacidad+" personas y su estado es "+estado+".";
    }


}
