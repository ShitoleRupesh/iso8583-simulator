import org.jpos.iso.*;
import org.jpos.iso.packager.ISO87APackager;

import java.net.Socket;

public class POSClient {
    public static void main(String[] args) throws Exception {

        Socket socket = new Socket("localhost", 5000);

        ISO87APackager packager = new ISO87APackager();

        ISOMsg isoMsg = new ISOMsg();
        isoMsg.setPackager(packager);

        isoMsg.setMTI("0100");
        isoMsg.set(2, "1234567890123456");
        isoMsg.set(3, "000000");
        isoMsg.set(4, "000000010000");
        isoMsg.set(7, "0401123456");
        isoMsg.set(11, "123456");

        socket.getOutputStream().write(isoMsg.pack());

        System.out.println("📤 Sent 0100 Request");

        byte[] responseBytes = new byte[1024];
        socket.getInputStream().read(responseBytes);

        ISOMsg response = new ISOMsg();
        response.setPackager(packager);
        response.unpack(responseBytes);

        System.out.println("📥 Response MTI: " + response.getMTI());
        System.out.println("📥 Response Code: " + response.getString(39));

        socket.close();
    }
}