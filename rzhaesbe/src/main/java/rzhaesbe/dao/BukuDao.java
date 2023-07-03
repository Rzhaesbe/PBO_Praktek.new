/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rzhaesbe.dao;
import rzhaesbe.model.Buku;
import java.util.List;
/**
 *
 * @author LAB-MM
 */
public interface BukuDao {
    void insert(Buku buku);
    void update(int index, Buku buku);
    void delete(int index);
    Buku getAnggota(int index);
    List<Buku> getAll();

    public Buku getBuku(int index);

     
}
