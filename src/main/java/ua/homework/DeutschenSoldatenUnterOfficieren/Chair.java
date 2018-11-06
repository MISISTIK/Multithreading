package ua.homework.DeutschenSoldatenUnterOfficieren;

import java.util.concurrent.TimeUnit;

import static ua.homework.DeutschenSoldatenUnterOfficieren.Main.print;
import static ua.homework.DeutschenSoldatenUnterOfficieren.Main.semaphore;
import static ua.homework.DeutschenSoldatenUnterOfficieren.Main.sitSec;

public class Chair {

    void getChair(String name) {
        try {
            print("Nazi " +name + " SIT ON CHAIR", CmdColor.ANSI_CYAN);
            for (int i = 0; i < sitSec; i++) {
                try {
                    print("Sitting " + String.valueOf(i+1) + " second" + (i==0 ? "" : "s") + " ...", CmdColor.ANSI_BLUE);
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
