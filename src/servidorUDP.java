import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class servidorUDP {
    public static void main(String[] args) throws IOException {
        try {
            int puerto = 5000;

            DatagramSocket socket = new DatagramSocket(puerto);

            // Arreglos de bytes para recibir los datos

            byte[] bufferEntrada = new byte[1024];

            DatagramPacket paquete = new DatagramPacket(bufferEntrada, 0, bufferEntrada.length);

            // Crear paquete

            socket.receive(paquete);
            // Inciar un nuevo hilo para manejar solicitudes de cliente
            Thread hilo_cliente = new HiloCliente(socket, paquete);
            hilo_cliente.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
