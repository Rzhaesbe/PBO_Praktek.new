/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rzhaesbe.dao;
import java.util.List;
import java.util.ArrayList;
import rzhaesbe.model.Buku;
/**
 *
 * @author Rzhaesbe
 */
public class BukuDaoImpl implements BukuDao {
    private List<Buku> data = new ArrayList<>();
    
    public BukuDaoImpl() {
        data.add(new Buku("B001","Filosofi Teras","Rahmad Sitepu","BangaiFoundations"));
        data.add(new Buku("B002","Hujan","Tere Liye","Gramedia"));
    }
    
    public void insert(Buku buku){
        data.add(buku);
    }
    
    public void update(int index, Buku buku){
        data.set(index, buku);
    }
    
    public void delete(int index){
        data.remove(index);
    }
    
    public Buku getAnggota(int index){
        return data.get(index);
    }
    
    public List<Buku> getAll(){
        return data;
    }

    @Override
    public Buku getBuku(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
