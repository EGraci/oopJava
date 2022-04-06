import java.util.*;
import java.util.stream.Collectors;

public class Callculation extends ReadCSV{
    Callculation(){
        String lokasi = "";
        if(getOs().indexOf("win") >= 0){
            lokasi = System.getProperty("java.io.tmpdir")+"\\data_sekolah.csv";
        }else{
            lokasi = System.getProperty("java.io.tmpdir")+"/data_sekolah.csv";
        }
        setLokasi(lokasi);
        setTmpDir();
    }
    public double mean() {
        double sum = 0;
        for (int i = 0; i < data_kelas().size(); i++) {
            sum += data_kelas().get(i);
        }
        return sum / data_kelas().size();
    }

    public double median() {
        List<Double> data = data_kelas().stream().sorted().collect(Collectors.toList());
        int middle = data.size()/2;
        if (data.size()%2 == 1) {
            return data.get(middle);
        } else {
            return (data.get(middle-1) + data_kelas().get(middle)) / 2.0;
        }
    }

    public Double modus() {
        Double maxValue = data_kelas().get(0);
        int maxCount = 0;
        for (int i = 0; i < data_kelas().size(); ++i) {
            int count = 0;
            for (int j = 0; j < data_kelas().size(); ++j) {
                if (data_kelas().get(j) == data_kelas().get(i)) ++count;
            }
            if (count > maxCount) {
                maxCount = count;
                maxValue = data_kelas().get(i);
            }
        }
        return maxValue;
    }
    public Map<Double, Long> frekuensi(){
        List<Double> data = data_kelas();
        Map<Double, Long> fre = new HashMap<>();
        for (Double e : data) fre.merge(e, 1L, Long::sum);
        return fre;
    }
    public List mea_med_mod(){
        List text = new ArrayList<>();
        text.add("Berikut Hasil Pengolahan Nilai: ");
        text.add("");
        text.add("Berikut hasil sebaran data nilai");
        text.add("Mean "+mean());
        text.add("Median "+median());
        text.add("Modus "+modus());
        return text;
    }

    public List mode(){
        List text = new ArrayList<>();
        text.add("Berikut Hasil Pengolahan Nilai:");
        text.add("Modus : "+modus());
        text.add("Nilai : Frekuensi");
        for ( Map.Entry<Double, Long> entry : frekuensi().entrySet()) {
            Double key = entry.getKey();
            Long val = entry.getValue();
            text.add(key + " : "+val);
        }
        return text;
    }
    public void menu_utama() {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("======================");
        System.out.println("Aplikasi Genrate Nilai");
        System.out.println("======================");
        System.out.println("Letak file CSV dengan nama data_sekolah.csv");
        if(os.indexOf("win") >= 0){
            System.out.println("Pada direktori "+System.getProperty("java.io.tmpdir"));
        }else {
            System.out.println("Pada direktori "+System.getProperty("java.io.tmpdir")+"/");
        }
        System.out.println("----------------------");
        System.out.println("1. Genrate txt untuk menampilkan modus");
        System.out.println("2. Genrate txt untuk menampilkan nilai rata-rata, median");
        System.out.println("3. Genrate txt kedua file");
        System.out.println("0. Tutup Aplikasi");
        System.out.println("======================");
    }

    public void hasil(String title) {
        System.out.println("======================");
        System.out.println("Berhasil Genrate File");
        System.out.println("Direktori File : "+title);
        System.out.println("======================");
        System.out.println("1. Kembali ke menu utama");
        System.out.println("0. Tutup Aplikasi");
        System.out.println("======================");
    }

    public void gabung(String l1, String l2) {
        System.out.println("======================");
        System.out.println("Berhasil Genrate File");
        System.out.println("Direktori File : "+l1);
        System.out.println("Direktori File : "+l2);
        System.out.println("======================");
        System.out.println("1. Kembali ke menu utama");
        System.out.println("0. Tutup Aplikasi");
        System.out.println("======================");
    }

    public void error_file() {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println("======================");
        System.out.println("File tidak ditemukan");
        System.out.println("Letak file CSV dengan nama data_sekolah.csv");
        if (os.indexOf("win") >= 0) {
            System.out.println("Pada direktori " + System.getProperty("java.io.tmpdir"));
        } else {
            System.out.println("Pada direktori " + System.getProperty("java.io.tmpdir") + "/");
        }
        System.out.println("======================");
    }
}
