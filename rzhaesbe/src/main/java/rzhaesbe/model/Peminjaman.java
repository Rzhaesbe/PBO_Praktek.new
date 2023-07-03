/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rzhaesbe.model;

/**
 *
 * @author Rzhaebe
 */
public class Peminjaman {
    private String kodeAnggota;
    private String kodeBuku;
    private String tglPinjam;
    private String tglKembali;
    
    public Peminjaman(){
    }
    
    public Peminjaman(String kodeAnggota, String kodeBuku, String tglPinjam,String tglKembali) {
        this.kodeAnggota = kodeAnggota;
        this.kodeBuku = kodeBuku;
        this.tglPinjam = tglPinjam;
        this.tglKembali = tglKembali;
    }

    public String getKodeAnggota() {
        return kodeAnggota;
    }
    
        public void setKodeAnggota(String kodeAnggota) {
            this.kodeAnggota = kodeAnggota;
        }

    public String getKodeBuku() {
        return kodeBuku;
    }
    
        public void setKodeBuku(String KodeBuku) {
            this.kodeBuku = KodeBuku;
        }

    public String getTglPinjam() {
        return tglPinjam;
    }
    
        public void setTglPinjam(String tglPinjam) {
            this.tglPinjam = tglPinjam;
        }

    public String getTglKembali() {
        return tglKembali;
    }

        public void setTglKembali(String tglKembali) {
            this.tglKembali = tglKembali;
        }
}

