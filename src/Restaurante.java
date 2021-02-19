import java.util.*;

public class Restaurante {
    public String nombre;
    public int cuantas;
    Mesa[] mesas;
    LinkedList<HashMap<String, Integer>> lista = new LinkedList<>();

    public Restaurante(String nombre, int cuantas) {
        this.nombre = nombre;
        this.cuantas = cuantas;
        mesas = new Mesa[cuantas];
        inicializarMesas();
    }

    private void inicializarMesas() {
        for (int i = 1; i < cuantas; i++) {
            int random = (int) (Math.random() * ((10 - 1) + 1));
            Mesa mesa = new Mesa(i, random);
            mesa.setLibre(true);
            mesas[i] = mesa;
        }
    }

    public String getNombre() {
        return this.nombre;
    }

    public void getArray() {
        for (int i = 1; i < mesas.length; i++) {
            System.out.println(mesas[i]);
        }
    }

    public boolean reservarMesa(String nombre, int comensales) {
        int size = lista.size();
        HashMap<String, Integer> mesasReservadas = new HashMap<>();
        mesasReservadas.put(nombre, asignarMesa(comensales));

        lista.add(0, mesasReservadas);

        return size < lista.size();

    }

    private int asignarMesa(int comensales) {
        int min;
        int numeroMesa = 0;
        HashMap<Integer, Integer> arr = new HashMap<>();
        for (int i = 1; i < mesas.length; i++) {
            if (mesas[i].getCapacidad() >= comensales && mesas[i].estaLibre()) {
                arr.put(Integer.parseInt(mesas[i].getId()), mesas[i].getCapacidad());
            }
        }

        min = Collections.min(arr.values());

        for (Map.Entry<Integer, Integer> entry : arr.entrySet()){
            if (min == entry.getValue()){
                numeroMesa = entry.getKey();
            }
        }

        for (int i = 1; i < mesas.length; i++) {
            if (numeroMesa == Integer.parseInt(mesas[i].getId())){
                mesas[i].setLibre(false);
            }
        }

        if (numeroMesa > 0) {
            return numeroMesa;
        } else {
            return -1;
        }
    }

    public void mostrarReservas() {
        Iterator<HashMap<String, Integer>> iterator = lista.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
