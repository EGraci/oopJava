import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class ReadCSV implements Cleaning {
    private String lokasi;
    private String tmpDir;
    private String os = System.getProperty("os.name").toLowerCase(Locale.ROOT);

    public String getOs() {
        return os;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getTmpDir() {
        return tmpDir;
    }

    public void setTmpDir() {
        this.tmpDir = System.getProperty("java.io.tmpdir");
    }
    @Override
    public List<Double> data_kelas() {
        List<Double> kelas = new ArrayList<>();
        try {
            File myObj = new File(getLokasi());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] tmpStr = data.split(";");
                Double[] tmpDou = hapus_kelas(tmpStr);
                Arrays.stream(tmpDou).
                        forEach((value) ->{
                            kelas.add(value);
                        });
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return kelas;
    }

    @Override
    public Double[] hapus_kelas(String[] arr) {
        List<Double> tmp = new ArrayList<>();
        int i = 0;
        Arrays.stream(arr).
                forEach((value) ->{
                    try {
                        tmp.add(Double.parseDouble(value));
                    }catch (NumberFormatException e){
                    }
                });
        return tmp.toArray(new Double[0]);
    }

    public boolean read_csv(){
        try {
            File myObj = new File(getLokasi());
            Scanner myReader = new Scanner(myObj);
            myReader.close();
            return true;
        } catch (FileNotFoundException e) {
            return false;
        }
    }

    public String genrate_text(List data, String nama) throws IOException {
        nama += ".txt";
        String os = System.getProperty("os.name").toLowerCase();
        File myFile = new File(getTmpDir(),nama);
        myFile.createNewFile();
        PrintWriter pw = new PrintWriter(myFile);
        for(Object index: data){
            pw.println(index);
        }
        pw.flush();
        pw.close();
        if(os.indexOf("win") >= 0){
            return tmpDir+"\\"+nama;
        }else{
            return tmpDir+"/"+nama;
        }
    }
    public int input_int(Scanner scan){
        int pilih = 0;
        System.out.print("Pilih Menu : ");
        try {
           pilih = scan.nextInt();
           return pilih;
        }catch (Exception e){
            return -1;
        }
    }
}
