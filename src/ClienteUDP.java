import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClienteUDP {
    public static void main(String[] args) {
        try {
            int puerto = 5000;
            DatagramSocket socket = new DatagramSocket();

            //Dirección IP del servidor
            InetAddress direccion_servidor = InetAddress.getByName("localhost");

            String mensaje = "Hola soy cliente";
            //Arrelo par enviar datos
            byte[] bufferSalida = mensaje.getBytes();

            //Crear paquetes para eunviar datos
            DatagramPacket paquete_enviar = new DatagramPacket(bufferSalida, 0, bufferSalida.length);

            //Enviar paquete
            socket.send(paquete_enviar);

            //Arreglos de bytes para recibir los datos
            byte[] bufferEntrada = new byte[1024];

            DatagramPacket paquete_recibir = new DatagramPacket(bufferEntrada, 0, bufferEntrada.length);

            //Revibir paquete
            socket.receive(paquete_recibir);

            //Extraer la información del paquete recibido
            String mensajeRecibido = new String(paquete_recibir.getData());
            System.out.println("Mensaje recibido: " + mensajeRecibido);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
