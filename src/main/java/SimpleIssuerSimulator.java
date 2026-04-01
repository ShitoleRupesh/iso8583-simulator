import org.jpos.iso.*;
import org.jpos.iso.packager.ISO87APackager;

import java.net.ServerSocket;
import java.net.Socket;

public class SimpleIssuerSimulator {
    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(5000);
        System.out.println("✅ Issuer Simulator Running on port 5000...");

        while (true) {
            Socket socket = server.accept();

            ISO87APackager packager = new ISO87APackager();

            ISOMsg request = new ISOMsg();
            request.setPackager(packager);

            byte[] buffer = new byte[1024];
            socket.getInputStream().read(buffer);
            request.unpack(buffer);

            System.out.println("📥 Received MTI: " + request.getMTI());
            System.out.println("📥 STAN: " + request.getString(11));

            // Create Response
            ISOMsg response = new ISOMsg();
            response.setPackager(packager);

            response.setMTI("0110");
            response.set(11, request.getString(11)); // copy STAN
            response.set(39, "00"); // Approved

            socket.getOutputStream().write(response.pack());

            System.out.println("📤 Sent Response 0110 Approved");

            socket.close();
        }
    }
}