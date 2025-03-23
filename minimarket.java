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
        double cashback = Cashback(pembelian);
        double total = pembelian - cashback;
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
    double Cashback(double transaksi) {
        if (transaksi > 1000000) {
            if (type == 38) {
                transaksi *= 5.0/100;
            } else if (type == 56) {
                transaksi *= 7.0/100;
            } else if (type == 74) {
                transaksi *= 10.0/100;
            }
        } else {
            if (type == 56) {
                transaksi *= 2.0/100;
            } else if (type == 74) {
                transaksi *= 5.0/100;
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

public class minimarket {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan nama Anda            : ");
        String nama = input.nextLine();
        System.out.print("Masukkan nomor pelanggan Anda : ");
        String nomor = input.next();
        if (nomor.length() < 10 || nomor.length() > 10) {
            System.out.print("Harap masukkan nomor rekening dengan benar.");
            System.exit(0);
        }
        System.out.print("Masukkan password Anda        : ");
        int pass = input.nextInt();
        double saldo = 10000;
        Pelanggan p1 = new Pelanggan(nama, nomor, saldo);
        p1.setPassword(pass);
        System.out.println("Selamat datang.");
        for ( ; ; ) {
            p1.Menu();
            int opt = input.nextInt();
            if (opt == 1) {
                System.out.print("Masukkan jumlah pembelian: Rp");
                double beli = input.nextDouble();
                System.out.print("Masukkan password Anda: ");
                int pwd = input.nextInt();
                p1.Transaksi(beli, pwd);
            } else if (opt == 2) {
                System.out.print("Masukkan jumlah top up: Rp");
                double topup = input.nextDouble();
                System.out.print("Masukkan password Anda: ");
                int psw = input.nextInt();
                p1.TopUp(topup, psw);
            } else if (opt == 3) {
                p1.displayInfo();
            } else if (opt == 4) {
                p1.Keluar();
            } else {
                System.out.println("Masukkan angka sesuai pilihan.");
            }
        }
    }
}
