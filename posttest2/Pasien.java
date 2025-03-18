class Pasien {
    String nama;
    int umur;
    String keluhan;
    
    public Pasien(String nama, int umur, String keluhan) {
        this.nama = nama;
        this.umur = umur;
        this.keluhan = keluhan;
    }
    
    @Override
    public String toString() {
        return "Nama: " + nama + ", Umur: " + umur + ", Keluhan: " + keluhan;
    }
}