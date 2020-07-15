
package networks.extract.data;

import java.io.IOException;
import static networks.extract.data.Extract_data.extractPingData;
import static networks.extract.data.Extract_data.extractTracerouteData;
import static networks.extract.data.Extract_data.extractWgetData;

public class NetworksExtractData {


    public static void main(String[] args) throws IOException {
        extractPingData();
        extractTracerouteData();
        extractWgetData();
//extractTracerouteData();
    }
    
}
