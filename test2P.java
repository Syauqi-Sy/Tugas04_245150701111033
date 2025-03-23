// anggap ini isian (methods) *selalu run di file ini, jgn di childny

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class area {
    int len, wid;
    double jar, bas, hgt;
    area() { // constructor awal
        this.len = 0;
        this.wid = 0;
        this.bas = 0;
        this.hgt = 0;
        this.jar = 0;
    }
    area(int len, int wid) { // persegi
        this.len = len;
        this.wid = wid;
    }
    area(double jar) { // lingkaran
        this.jar = jar;
    }
    area(double bas, double hgt) { // segitiga
        this.bas = bas;
        this.hgt = hgt;
    }
    int sqArea() { // luas persegi
        return len * wid;
    }
    double ciArea() { // luas lingkaran
        return Math.PI * Math.pow(jar, 2);
    }
    double trArea() { // luas segitiga
        return bas * hgt / 2;
    }

    void sqAreaInfo() { // output luas persegi
        System.out.println("luas persegi = " + sqArea() + " cm.");
    }
    void ciAreaInfo() { // output luas lingkaran
        System.out.printf("luas lingkaran = %.0f cm.", ciArea());
        System.out.println("");
    }
    void trAreaInfo() { // output luas segitiga
        System.out.printf("luas segitiga = %.0f cm.", trArea());
        System.out.println("");
    }
}

class circle {
    double jar;
    circle() {
        this.jar = 0;
    }
    circle(double jar) {
        this.jar = jar;
    }
    double ciArea() {
        return Math.PI * Math.pow(jar, 2);
    }
    
    void circleInfo() {
        System.out.printf("luas lingkaran = %.0f", ciArea());
        System.out.println("");
    }
}

class square {
    int len;
    int wid;
    square() {
        this.len = 0;
        this.wid = 0;
    }
    square(int len, int wid) {
        this.len = len;
        this.wid = wid;
    }
    int crcmSqr() {
        return 2 * (len + wid);
    }
    int sqrArea() {
        return len * wid;
    }
    double diagSqr() {
        return Math.sqrt(Math.pow(len, 2) + Math.pow(wid, 2));
    }

    void squareInfo() {
        System.out.println("luas persegi = " + sqrArea());
    }
}

class triangle {
    int bas;
    int hgt;
    triangle() {
        this.bas = 0;
        this.hgt = 0;
    }
    triangle(int bas, int hgt) {
        this.bas = bas;
        this.hgt = hgt;
    }
    int trArea() {
        return this.bas * this.hgt / 2;
    }

    void triangleInfo() {
        System.out.println("luas segitiga = " + trArea());
    }
}

//----------------------------------------------------------------------------------------------------
public class test2P {
    String nama;
    double a;
    int b;
    double cnvrtd;
    int year;
    int pri;
    int tax;

    void setnama (String mynama) {
        nama = mynama;
    }

    void seta (double mya) {
        a = mya;
    }

    void setb (int myb) {
        b = myb;
    }

    void setconv (double myconv) {
        cnvrtd = myconv * (36/10);
    }

    void setyear (int myyear) {
        year = myyear;
    }

    void setpri (int mypri) {
        pri = mypri;
    }

    void settax (int mytax) {
        if (year < 2020) {
            mytax = pri * 5/100;
        } else {
            mytax = pri * 10/100;
        }
        tax = mytax;
    }

    void displayInfo(String info) {
        System.out.println("Nama mobil = " + nama);
        System.out.println("Kecepatan mobil = " + a + " km/h");
        System.out.println("Kecepatan mobil = " + cnvrtd + " m/s");
        System.out.println("Garansi mobil = " + b + " tahun");
        System.out.println("Harga mobil = " + pri);
        System.out.println("Tahun mobil = " + year);
        System.out.println("Pajak mobil = " + tax);
        System.out.println(info);
    }
}

//----------------------------------------------------------------------------------------------------
class Film {
    private String judulFilm;
    private String genreFilm;
    private LocalTime jTayangFilm;
    private int hTiketFilm;

    public Film(String aJFilm, String aGFilm, LocalTime aJTFilm, int aHTFilm) {
        this.judulFilm = aJFilm;
        this.genreFilm = aGFilm;
        this.jTayangFilm = aJTFilm;
        this.hTiketFilm = aHTFilm;
    }

    void filmInfo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String jTayangFilm = this.jTayangFilm.format(formatter);
        System.out.println("Judul film: " + judulFilm);
        System.out.println("Genre film: " + genreFilm);
        System.out.println("Jam tayang film: " + jTayangFilm + " WIB");
        System.out.println("Harga tiket film: Rp" + hTiketFilm);
    }
}

class Studio {
    private int noStudio;
    private int kursiStudio;
    private Film film;

    public Studio(int aNStudio,int aKStudio, Film film) {
        this.noStudio = aNStudio;
        this.kursiStudio = aKStudio;
        this.film = film;
    }

    void setFilm(Film film) {
        this.film = film;
    }

    int getKursi() {
        return kursiStudio;
    }

    void studioInfo() {
        System.out.println("Nomor studio: " + noStudio);
        System.out.println("Kapasitas studio: " + kursiStudio + " orang");
        film.filmInfo();
    }
}

class Audiens {
    private String name;

    public Audiens(String name) {
        this.name = name;
    }

    void audiensInfo() {
        System.out.println("Nama: " + name);
    }
}

class Tiket {
    int noTiket;
    Film film;
    Studio studio;
    int tempatDuduk;
    Audiens audiens;

    public Tiket(int noTiket, Film film, Studio studio, int tempatDuduk, Audiens audiens) {
        this.noTiket = noTiket;
        this.film = film;
        this.studio = studio;
        // a
        // if (tempatDuduk > studio.getKursi()) {
        //     System.out.println("Kursi melebihi kapasitas.");
        //     this.tempatDuduk = studio.getKursi();
        // } else if (tempatDuduk < 1) {
        //     System.out.println("Kursi tidak boleh kurang dari 1.");
        //     this.tempatDuduk = 1;
        // } else {
        //     this.tempatDuduk = tempatDuduk;
        // }
        this.tempatDuduk = tempatDuduk;
        this.audiens = audiens;
    }

    void tiketInfo() {
        audiens.audiensInfo();
        System.out.println("Kursi: " + tempatDuduk);
        System.out.println("No. Tiket: " + noTiket);
        studio.studioInfo();
        System.out.println("");
    }
}

//----------------------------------------------------------------------------------------------------
class Pegawai {
    String workerName;
    String workerChair;
    double priSalary;
    double secSalary;
    double compTax;
    double compBonus;
    double extCompBonus;
    Pegawai() {
        workerName = "";
        workerChair = "";
        priSalary = 0;
        secSalary = 0;
        compTax = 0;
        compBonus = 0;
        extCompBonus = 0;
    }
    Pegawai(String nama, String jabatan, double gaji, double tunjangan, double pajak, double bonus) {
        workerName = nama;
        workerChair = jabatan;
        priSalary = gaji;
        secSalary = tunjangan;
        compTax = pajak;
        compBonus = bonus;
    }
    double hitungGajiTotal() {
        return priSalary + secSalary + compBonus - compTax;
    }
    void tambahBonus(double tambahanBonus) {
        extCompBonus = compBonus + tambahanBonus;
    }

    void displayInfo() {
        System.out.println("___Data pegawai___");
        System.out.println("Nama pegawai : " + workerName);
        System.out.println("Jabatan pegawai : " + workerChair);
        System.out.printf("Gaji pokok : Rp%.0f\n", priSalary);
        System.out.printf("Tunjangan : Rp%.0f\n", secSalary);
        System.out.printf("Bonus : Rp%.0f\n", compBonus);
        System.out.printf("Pajak : Rp%.0f\n", compTax);
        System.out.printf("Total gaji : Rp%.0f\n", hitungGajiTotal());
        System.out.printf("Bonus (ditambah) : Rp%.0f\n", extCompBonus);
        System.out.println("");
    }
}

//----------------------------------------------------------------------------------------------------
class Customer {
    String cusName;
    String noPhone;
    Keranjang myBasket;
    Customer() {
        cusName = "";
        noPhone = "";
    }
    Customer(String nama, String nohp, Keranjang krjg) {
        cusName = nama;
        noPhone = nohp;
        myBasket = krjg;
    }

    void displayInfo() {
        System.out.println("___Data Customer___");
        System.out.println("Nama : " + cusName);
        System.out.println("No. HP : " + noPhone);
        myBasket.displayInfo();
        System.out.println("");
    }
}

class Keranjang {
    int jProd;
    int tHarga;
    Produk prod;
    Keranjang() {
        jProd = 0;
        tHarga = 0;
    }
    Keranjang(int prod, int sHarga) {
        jProd += prod;
        tHarga += sHarga;
    }

    void displayInfo() {
        System.out.println("Jumlah produk dibeli : " + jProd);
        System.out.println("Total harga : Rp" + tHarga);
    }
}

class Produk {
    String namProd;
    int jumProd;
    int priProd;
    int sumProd;
    Produk() {
        namProd = "";
        jumProd = 0;
        priProd = 0;
        sumProd = 0;
    }
    Produk(String nProd, int sProd, int hProd, int tProd) {
        namProd = nProd;
        jumProd = sProd;
        priProd = hProd;
        sumProd = tProd;
    }
    int totalHargaProd() {
        return priProd*sumProd;
    }

    void displayInfo() {
        System.out.println("Nama barang : " + namProd);
        System.out.println("Jumlah produk : " + jumProd);
        System.out.println("Harga satuan : " + priProd);
        System.out.println("Jumlah harga : " + sumProd);
    }
}

//----------------------------------------------------------------------------------------------------
class PengirimanBarang {
    String namaPengirim;
    String alamatTujuan;
    double berat;
    double biayaDasar;
    int jarakPaket;
    PengirimanBarang() {
        namaPengirim = "";
        alamatTujuan = "";
        berat = 0;
        biayaDasar = 0;
        jarakPaket = 0;
    }
    PengirimanBarang(String sender, String toAdd, double weight, double basePrice) {
        namaPengirim = sender;
        alamatTujuan = toAdd;
        berat = weight;
        biayaDasar = basePrice;
    }
    double hitungOngkir(double diskonPersen) {
        return biayaDasar -= (biayaDasar * diskonPersen / 100);
    }
    double hitungOngkir(double diskonPersen, double biayaTambahan) {
        return biayaDasar = (biayaDasar - (biayaDasar * diskonPersen / 100)) + biayaTambahan;
    }
    void hitungOngkir(int jarak) {
        double surcharge = 0;
        double disc = 0;
        jarakPaket = jarak;
        System.out.println("Jarak pengiriman               : " + jarakPaket + " km");
        if (jarak > 50) {
            surcharge = biayaDasar * 10/100;
            biayaDasar += surcharge;
            System.out.println("Biaya tambahan (jarak > 50 km) : Rp" + surcharge);
        } else if (jarak <= 0) {
            System.out.println("Error: Jarak tidak boleh sama dengan atau lebih dari 0.");
        } else {
            disc = biayaDasar * 5/100;
            biayaDasar -= disc;
            System.out.println("Diskon (jarak <= 50 km)        : Rp" + disc);
        }
        System.out.println("Biaya pengiriman akhir         : Rp" + biayaDasar);
    }

    void displayInfoLogistik() {
        System.out.println("---Status paket xX_BoltExpress_Xx---");
        System.out.println("Nama pengirim                  : " + namaPengirim);
        System.out.println("Alamat tujuan                  : " + alamatTujuan);
        System.out.println("Berat paket                    : " + berat + " kg");
        System.out.println("Biaya ongkir dasar             : Rp" + biayaDasar);
    }
}

//----------------------------------------------------------------------------------------------------
class Pelanggan {
    private String name;
    private String number;
    private double balance;
    private int type;
    private String typeS;
    private int password;
    private int wrongAuth;
    Pelanggan() {
        name = "";
        number = "";
        balance = 0;
        type = 0;
        typeS = "";
        password = 0;
        wrongAuth = 0;
    }
    Pelanggan(String nama, String rekening, double saldo) {
        name = nama;
        number = rekening;
        String tempa = rekening.substring(0, 2);
        type = Integer.parseInt(tempa);
        switch (type) {
            case 38:
                typeS = "Silver";
                break;
            case 56:
                typeS = "Gold";
                break;
            case 74:
                typeS = "Platinum";
                break;
            default:
                System.out.println("Harap masukkan nomor rekening dengan benar.");
                System.exit(0);
                break;
        }
        balance = saldo;
    }
    void setPassword(int pwd) {
        password = pwd;
    }
    boolean Autentikasi(int pwd) {
        if (pwd == password) {
            wrongAuth = 0;
            return true;
        } else {
            wrongAuth++;
            return false;
        }
    }
    boolean akunTerblokir() {
        return wrongAuth >= 2;
    }
    boolean Transaksi(double pembelian, int pass) {
        if (akunTerblokir()) {
            System.out.println("Akun Anda terblokir.");
            System.exit(0);
        }
        if (!Autentikasi(pass)) {
            System.out.println("Password salah!\n");
            return false;
        }
        double cashback = Cashback(pembelian); //nyari ribut ni. biar apa jinx gk work
        double total = pembelian - cashback;
        System.out.println(cashback); //how you can be 0????
        System.out.println(total);
        if (balance >= total && (balance - total) >= 10000) {
            balance -= total;
            System.out.println("Pembelian berhasil. Saldo Anda sekarang: " + balance + "\n");
            return true;
        } else {
            System.out.println("Saldo Anda tidak cukup atau saldo Anda setelah pembelian kurang dari Rp10.000.");
            System.out.println("Silakan top up terlebih dahulu sebelum melakukan pembelian kembali.");
            System.out.println("Saldo Anda sekarang: Rp" + balance + "\n");
            return false;
        }
    }
    double Cashback(double transaksi) { //scheiBe, why you dont run???
        if (transaksi > 1000000) {
            if (type == 38) {
                transaksi *= 5/100;
            } else if (type == 56) {
                transaksi *= 7/100;
            } else if (type == 74) {
                transaksi *= 10/100;
            }
        } else {
            if (type == 56) {
                transaksi *= 2/100;
            } else if (type == 74) {
                transaksi *= 5/100;
            }
        }
        return transaksi;
    }
    void TopUp(double topup, int pass) {
        if (akunTerblokir()) {
            System.out.println("Akun Anda terblokir.");
            System.exit(0);
        }
        if (!Autentikasi(pass)) {
            System.out.println("Password salah!\n");
            return;
        }
        balance += topup;
        System.out.println("Anda berhasil top up sebesar Rp" + topup + ". Saldo Anda sekarang Rp" + balance + "\n");
    }
    void Menu() {
        System.out.println("Pilih jenis transaksi:");
        System.out.println("1. Pembelian");
        System.out.println("2. Top Up");
        System.out.println("3. Profil Anda");
        System.out.println("4. Keluar");
    }
    void displayInfo() {
        System.out.println("===---Profil pelanggan---===");
        System.out.println("Username         : " + name);
        System.out.println("Nomor rekening   : " + number);
        System.out.println("Jenis rekening   : " + typeS);
        System.out.println("Saldo            : Rp" + balance);
        System.out.println("===---****************---===");
        System.out.println("");
    }
    void Keluar() {
        System.out.println("Terima kasih telah bertransaksi.");
        System.out.println("Semoga hari Anda menyenangkan.");
        System.exit(0);
    }
}