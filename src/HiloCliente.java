import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class HiloCliente extends Thread{
    private DatagramSocket socket;
    private DatagramPacket paquete;

    //Constructor
    public HiloCliente(DatagramSocket socket, DatagramPacket paquete){
        this.socket=socket;
        this.paquete=paquete;
    }
    public void run(){
        try {
            //Extraer la información del pquete recibido
            String mensajeRecibido = new String(paquete.getData());
            System.out.println("Mensaje recibido: " + mensajeRecibido);

            //obtener la dirección del cliente
            InetAddress direccionIP_cliente = (InetAddress) paquete.getAddress();
            int puerto_cliente = paquete.getPort();

            //Mensaje respuesta
            String resouesta = "Hola, soy el servidor";
            //Arreglos de bytes para enviar los datos
            byte[] bufferSalida = resouesta.getBytes();

            //Crear paquete para enviar datos
            DatagramPacket paquete_respuesta = new DatagramPacket(bufferSalida, 0, bufferSalida.length);

            //Enviar Datagrama
            socket.send(paquete_respuesta);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
