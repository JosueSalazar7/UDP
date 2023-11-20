import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class HiloCliente extends Thread {
    private DatagramSocket socket;
    private DatagramPacket paquete;
    private Scanner scanner;

    // Constructor
    public HiloCliente(DatagramSocket socket, DatagramPacket paquete, Scanner scanner) {
        this.socket = socket;
        this.paquete = paquete;
        this.scanner = scanner;
    }

    public void run() {
        try {
            // Extraer la información del paquete recibido
            String mensajeRecibido = new String(paquete.getData(), paquete.getOffset(), paquete.getLength());
            System.out.println("Mensaje recibido: " + mensajeRecibido);

            // Obtener la dirección del cliente
            InetAddress direccionIP_cliente = paquete.getAddress();
            int puerto_cliente = paquete.getPort();

            // Mensaje respuesta
            System.out.print("Ingresa una respuesta: ");
            String respuesta = scanner.nextLine();

            // Arreglos de bytes para enviar los datos
            byte[] bufferSalida = respuesta.getBytes();

            // Crear paquete para enviar datos
            DatagramPacket paquete_respuesta = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIP_cliente, puerto_cliente);

            // Enviar Datagrama
            socket.send(paquete_respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
