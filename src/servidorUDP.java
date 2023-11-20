    import java.net.DatagramPacket;
    import java.net.DatagramSocket;
    import java.util.Scanner;
    public class servidorUDP{
        Scanner scanner = new Scanner(System.in);
        public static void main(String[] args){

            try {
                int puerto=5000; //Número de puerto
                //Crear un socket UDP
                DatagramSocket socket = new DatagramSocket(puerto);
                System.out.println("Servidor esperando conexiones");

                while (true) {
                    // Arreglos de bytes para recibir los datos
                    //Crear paquete para recibir datos
                    DatagramPacket paquete;
                    byte[] bufferEntrada = new byte[1024];

                    paquete = new DatagramPacket(bufferEntrada,0, bufferEntrada.length);
                    //Recibir paquete
                    socket.receive(paquete);
                    //Iniciar un nuevo hilo para manejar solicitudes de clientes
                    Thread hilo_cliente = new HiloCliente(socket,paquete,new Scanner(System.in));
                    hilo_cliente.start();
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }





        }
    }