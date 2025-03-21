import java.util.ArrayList;
import java.util.Scanner;

public class KlinikAntrian {
    private static ArrayList<Pasien> daftarPasien = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Sistem Pendaftaran Antrian Klinik ===");
            System.out.println("1. Tambah Pasien");
            System.out.println("2. Lihat Daftar Pasien");
            System.out.println("3. Ubah Data Pasien");
            System.out.println("4. Hapus Pasien");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();
            
            switch (pilihan) {
                case 1:
                    tambahPasien();
                    break;
                case 2:
                    lihatPasien();
                    break;
                case 3:
                    ubahPasien();
                    break;
                case 4:
                    hapusPasien();
                    break;
                case 5:
                    System.out.println("Terima kasih! Program selesai.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
    }
    
    private static void tambahPasien() {
        System.out.print("Masukkan nama pasien: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan umur pasien: ");
        int umur = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Masukkan keluhan pasien: ");
        String keluhan = scanner.nextLine();
        
        daftarPasien.add(new Pasien(nama, umur, keluhan));
        System.out.println("Pasien berhasil ditambahkan!");
    }
    
    private static void lihatPasien() {
        if (daftarPasien.isEmpty()) {
            System.out.println("Tidak ada pasien dalam daftar.");
            return;
        }
        System.out.println("\nDaftar Pasien:");
        for (int i = 0; i < daftarPasien.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPasien.get(i));
        }
    }
    
    private static void ubahPasien() {
        lihatPasien();
        if (daftarPasien.isEmpty()) return;
        
        System.out.print("Pilih nomor pasien yang ingin diubah: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (index < 0 || index >= daftarPasien.size()) {
            System.out.println("Nomor pasien tidak valid.");
            return;
        }
        
        Pasien pasien = daftarPasien.get(index);
        
        System.out.print("Masukkan nama baru: ");
        pasien.setNama(scanner.nextLine());
        System.out.print("Masukkan umur baru: ");
        pasien.setUmur(scanner.nextInt());
        scanner.nextLine();
        System.out.print("Masukkan keluhan baru: ");
        pasien.setKeluhan(scanner.nextLine());
        
        System.out.println("Data pasien berhasil diubah!");
    }
    
    private static void hapusPasien() {
        lihatPasien();
        if (daftarPasien.isEmpty()) return;
        
        System.out.print("Pilih nomor pasien yang ingin dihapus: ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        
        if (index < 0 || index >= daftarPasien.size()) {
            System.out.println("Nomor pasien tidak valid.");
            return;
        }
        
        daftarPasien.remove(index);
        System.out.println("Pasien berhasil dihapus!");
    }
}
