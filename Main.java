// interfaz que básicamente dice qué cosas debe poder hacer cualquier unidad
// en este caso iniciar y finalizar operación
interface Operable {
    void iniciarOperacion();
    void finalizarOperacion();
}

// clase abstracta que sirve como base para todas las unidades
// no se puede crear directamente, solo sirve para heredar
abstract class UnidadEntrega {

    // aquí guardo el identificador, es protected para que las hijas lo puedan usar
    protected String identificador;

    // constructor para asignar el id cuando creo el objeto
    public UnidadEntrega(String identificador) {
        this.identificador = identificador;
    }

    // este método ya está hecho y lo heredan todas las clases
    public void mostrarInformacion() {
        System.out.println("ID: " + identificador);
    }

    // este método no lo defino aquí porque cada unidad entrega diferente
    public abstract void realizarEntrega();
}

// bicicleta hereda de la clase base y también cumple lo de la interfaz
class Bicicleta extends UnidadEntrega implements Operable {

    public Bicicleta(String identificador) {
        super(identificador); // uso el constructor de la clase padre
    }

    // mismo método que las otras clases pero con su propia forma de entregar
    public void realizarEntrega() {
        System.out.println("Entrega en bicicleta");
    }

    // estos métodos vienen de la interfaz
    public void iniciarOperacion() {
        System.out.println("Inicia bicicleta");
    }

    public void finalizarOperacion() {
        System.out.println("Finaliza bicicleta");
    }
}

// motocicleta funciona igual pero con su propio comportamiento
class Motocicleta extends UnidadEntrega implements Operable {

    public Motocicleta(String identificador) {
        super(identificador);
    }

    // mismo método pero cambia lo que hace
    public void realizarEntrega() {
        System.out.println("Entrega en motocicleta");
    }

    public void iniciarOperacion() {
        System.out.println("Inicia motocicleta");
    }

    public void finalizarOperacion() {
        System.out.println("Finaliza motocicleta");
    }
}

// drone igual, misma estructura pero comportamiento diferente
class Drone extends UnidadEntrega implements Operable {

    public Drone(String identificador) {
        super(identificador);
    }

    // aquí se ve el polimorfismo porque todos tienen este método pero hacen cosas distintas
    public void realizarEntrega() {
        System.out.println("Entrega con drone");
    }

    public void iniciarOperacion() {
        System.out.println("Inicia drone");
    }

    public void finalizarOperacion() {
        System.out.println("Finaliza drone");
    }
}

// clase principal donde pruebo todo
public class Main {
    public static void main(String[] args) {

        // creo los objetos
        Bicicleta bici = new Bicicleta("B1");
        Motocicleta moto = new Motocicleta("M1");
        Drone drone = new Drone("D1");

        // hago el mismo flujo con todos
        // aquí se nota que tienen la misma estructura pero cada uno responde diferente

        bici.iniciarOperacion();
        bici.mostrarInformacion();
        bici.realizarEntrega();
        bici.finalizarOperacion();

        System.out.println("-----");

        moto.iniciarOperacion();
        moto.mostrarInformacion();
        moto.realizarEntrega();
        moto.finalizarOperacion();

        System.out.println("-----");

        drone.iniciarOperacion();
        drone.mostrarInformacion();
        drone.realizarEntrega();
        drone.finalizarOperacion();
    }
}