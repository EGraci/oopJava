import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        int pilih = 0;
        Callculation obj = new Callculation();
//        System.out.println(obj.data_kelas());
        menuUtama: while(true){
            Scanner scan = new Scanner(System.in);
            if (obj.read_csv()) {
                obj.menu_utama();
                pilih = obj.input_int(scan);
                switch (pilih){
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        menu1: while(true) {
                            obj.hasil(obj.genrate_text(obj.mode(), "modus"));
                            pilih = obj.input_int(scan);
                            if (pilih == 1) {
                                break menu1;
                            } else if (pilih == 0) {
                               System.exit(0);
                            } else {
                                continue menu1;
                            }
                        }
                        break;
                    case 2:
                        menu2: while (true) {
                            obj.hasil(obj.genrate_text(obj.mea_med_mod(), "modus_mean_median"));
                            pilih = obj.input_int(scan);
                            if (pilih == 1) {
                                break menu2;
                            } else if (pilih == 0) {
                                System.exit(0);
                            } else {
                                continue menu2;
                            }
                        }
                        break;
                    case 3:
                        menu3: while (true){
                            obj.gabung(obj.genrate_text(obj.mode(),"modus"), obj.genrate_text(obj.mea_med_mod(),"modus_mean_median"));
                            pilih = obj.input_int(scan);
                            if(pilih == 1){
                                break menu3;
                            }else if(pilih == 0){
                                System.exit(0);
                            }else{
                                continue menu3;
                            }
                        }
                        break;
                    default:
                        continue menuUtama;
                }
            }else{
                obj.error_file();
                System.exit(0);
            }
            scan.close();
        }
    }
}
