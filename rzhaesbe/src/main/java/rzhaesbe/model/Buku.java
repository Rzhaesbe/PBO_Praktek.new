/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rzhaesbe.model;

/**
 *
 * @author Rzhaesbe
 */
public class Buku {
    private String kodeBuku;
    private String Judul;
    private String Pengarang;
    private String Penerbit;
    
    public Buku(){
    }

    public Buku(String kodeBuku, String Judul, String pengarang, String Penerbit) {
        this.kodeBuku = kodeBuku;
        this.Judul = Judul;
        this.Pengarang = pengarang;
        this.Penerbit = Penerbit;
        
        
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String Judul) {
        this.Judul = Judul;
    }

     

    public String getPengarang() {
        return Pengarang;
    }

    public void setPengarang(String Pengarang) {
        this.Pengarang = Pengarang;
    }

    public String getPenerbit() {
        return Penerbit;
    }

    public void setPenerbit(String Penerbit) {
        this.Penerbit = Penerbit;
    }

    
}
     