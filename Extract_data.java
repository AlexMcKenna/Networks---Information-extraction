package networks.extract.data;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Extract_data {

    public static void extractPingData() throws IOException {
        try {
            //Creates file and log holder for extraction    
            PrintWriter pings = new PrintWriter("ping1.csv");
            PrintWriter log = null;
            //scan for file to be used
            Scanner s = new Scanner(new File("pinglog.log"));
            //while lines exist
            while (s.hasNextLine()) {
                String line = s.nextLine();
                //on lines that PING or 64 exist
                if (line.startsWith("PING") || line.startsWith("64")) {
                    log = pings;
                } else if (log != null) {
                    log.println(line);
                }
            }
            //close sections
            pings.close();
            s.close();
        } catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
    
    public static void extractTracerouteData() throws IOException {
        BufferedWriter bw = null;
        FileWriter filewriter;
        //String[] regex = "  ";
        try {
            filewriter = new FileWriter("traceroute.csv");
            bw = new BufferedWriter(filewriter);
            Scanner s = new Scanner(new File("tracelog1.log"));
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                String[] regex = line.split("  ");
                for (String str : regex) {
                    if (line.startsWith("traceroute")
                            || line.endsWith("ms")) {
                        bw.write(str);
                        bw.newLine();
                    }
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Extract_data.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bw.close();
        }
    }

    public static void extractWgetData() throws IOException {
        BufferedWriter bw = null;
        FileWriter filewriter;
        //String[] regex = "  ";
        try {
            filewriter = new FileWriter("wget.csv");
            bw = new BufferedWriter(filewriter);
            Scanner s = new Scanner(new File("wget1.log"));
            while (s.hasNextLine()) {
                String line = s.nextLine().trim();
                String[] regex = line.split(" ");
                for (String str : regex) {
                    if (line.startsWith("2017")
                            || line.endsWith("]")) {
                        bw.write(str);
                        bw.newLine();
                    }
                }
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(Extract_data.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            bw.close();
        }
    }
}
