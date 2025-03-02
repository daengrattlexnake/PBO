import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Buku {
    private String judul;
    private String penulis;
    private int tahun;
    private boolean tersedia;

    public Buku(String judul, String penulis, int tahun) {
        this.judul = judul;
        this.penulis = penulis;
        this.tahun = tahun;
        this.tersedia = true;
    }

    public String getJudul() {
        return judul;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean status) {
        this.tersedia = status;
    }

    public void tampilkanBuku() {
        System.out.println("Judul: " + judul + " | Penulis: " + penulis + " | Tahun: " + tahun + 
                           " | Status: " + (tersedia ? "Tersedia" : "Dipinjam"));
    }
}

class Perpustakaan {
    private ArrayList<Buku> daftarBuku = new ArrayList<>();

    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
    }

    public void tampilkanBuku() {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku yang tersedia.");
            return;
        }
        System.out.println("\nDaftar Buku:");
        for (int i = 0; i < daftarBuku.size(); i++) {
            System.out.print((i + 1) + ". ");
            daftarBuku.get(i).tampilkanBuku();
        }
    }

    public void pinjamBuku(int index) {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku yang bisa dipinjam.");
            return;
        }
        if (index < 1 || index > daftarBuku.size()) {
            System.out.println("Nomor buku tidak valid!");
            return;
        }
        Buku buku = daftarBuku.get(index - 1);
        if (buku.isTersedia()) {
            buku.setTersedia(false);
            System.out.println("Buku berhasil dipinjam!");
        } else {
            System.out.println("Maaf, buku ini sudah dipinjam.");
        }
    }

    public void kembalikanBuku(int index) {
        if (daftarBuku.isEmpty()) {
            System.out.println("Tidak ada buku yang bisa dikembalikan.");
            return;
        }
        if (index < 1 || index > daftarBuku.size()) {
            System.out.println("Nomor buku tidak valid!");
            return;
        }
        Buku buku = daftarBuku.get(index - 1);
        if (!buku.isTersedia()) {
            buku.setTersedia(true);
            System.out.println("Buku berhasil dikembalikan!");
        } else {
            System.out.println("Buku ini sudah tersedia.");
        }
    }
}

public class ManajemenPerpustakaan {
    private static final String PASSWORD_ADMIN = "admin123";

    public static void main(String[] args) {
        Perpustakaan perpustakaan = new Perpustakaan();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan kata sandi admin: ");
        String inputPass = scanner.nextLine();
        if (!inputPass.equals(PASSWORD_ADMIN)) {
            System.out.println("Kata sandi salah. Keluar...");
            return;
        }

        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Pinjam Buku");
            System.out.println("4. Kembalikan Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // Buang newline dari input sebelumnya

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan judul buku: ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan nama penulis: ");
                        String penulis = scanner.nextLine();
                        System.out.print("Masukkan tahun terbit: ");
                        int tahun = scanner.nextInt();
                        perpustakaan.tambahBuku(new Buku(judul, penulis, tahun));
                        System.out.println("Buku berhasil ditambahkan!");
                        break;
                    case 2:
                        perpustakaan.tampilkanBuku();
                        break;
                    case 3:
                        perpustakaan.tampilkanBuku();
                        System.out.print("Masukkan nomor buku yang ingin dipinjam: ");
                        int pinjamIndex = scanner.nextInt();
                        perpustakaan.pinjamBuku(pinjamIndex);
                        break;
                    case 4:
                        perpustakaan.tampilkanBuku();
                        System.out.print("Masukkan nomor buku yang ingin dikembalikan: ");
                        int kembaliIndex = scanner.nextInt();
                        perpustakaan.kembalikanBuku(kembaliIndex);
                        break;
                    case 5:
                        System.out.println("Keluar dari program...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Pilihan tidak valid! Silakan coba lagi.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine(); // Bersihkan input yang salah
            }
        }
    }
}
