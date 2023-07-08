/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rzhaesbe.controller;
import rzhaesbe.model.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import rzhaesbe.dao.*;
import rzhaesbe.view.FormPeminjaman;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Adam
 */
public class PeminjamanController {
    FormPeminjaman view;
    Peminjaman peminjaman;
    PeminjamanDao dao;
    AnggotaDao anggotadao;
    BukuDao bukudao;
    
     public PeminjamanController(FormPeminjaman view) {
        this.view = view;
        dao = new PeminjamanDaoImpl() {};
        anggotadao = new AnggotaDaoImpl();
        bukudao = new BukuDaoImpl();
    }
    
    public void clearForm() {
      
        view.getTxtTglPinjam().setText("");
        view.getTxtTglKembali().setText("");
       
    }
    public void isiCombo() {
        view.getCboAnggota().removeAllItems();
        List<Anggota>listanggota = anggotadao.getAll();
        for (Anggota anggota : listanggota) {
            view.getCboAnggota().addItem(anggota.getKodeAnggota ());
            
        }
         view.getCboBuku().removeAllItems();
        List<Buku>listbuku = bukudao.getAll();
        for (Buku buku: listbuku) {
            view.getCboBuku().addItem(buku.getKodeBuku ());
            
        }
        
        
    }
    public void tampil(){
        DefaultTableModel tabelModel = (DefaultTableModel)view.getTabelPeminjaman().getModel();
        tabelModel.setRowCount(0);
        List<Peminjaman> list = dao.getAll();
        for(Peminjaman c : list){
            try {
                Object[] row = {
                    c.getKodeAnggota(),
                    c.getKodeBuku(),
                    c.getTglPinjam(),
                    c.getTglKembali(),
                    c.getSelisih()
                };
                tabelModel.addRow(row);
            } catch (ParseException ex) {
                Logger.getLogger(PeminjamanController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     public void insert() {
        peminjaman = new Peminjaman();
        peminjaman.setKodeAnggota(view.getCboAnggota().getSelectedItem().toString());
        peminjaman.setKodeBuku(view.getCboBuku().getSelectedItem().toString());
        peminjaman.setTglPinjam(view.getTxtTglPinjam().getText());
        peminjaman.setTglKembali(view.getTxtTglKembali().getText());
        dao.insert(peminjaman);
        JOptionPane.showMessageDialog(view,"Entri Data OK");
    }
      public void update() {
        int index = view.getTabelPeminjaman().getSelectedRow();
        peminjaman = new Peminjaman();
         peminjaman.setKodeAnggota(view.getCboAnggota().getSelectedItem().toString());
        peminjaman.setKodeBuku(view.getCboBuku().getSelectedItem().toString());
        peminjaman.setTglPinjam(view.getTxtTglPinjam().getText());
        peminjaman.setTglKembali(view.getTxtTglKembali().getText());
        dao.update(index, peminjaman);
        JOptionPane.showMessageDialog(view,"Update Data OK");
        
    }
      public void delete(){
        int index = view.getTabelPeminjaman().getSelectedRow();
        dao.delete(index);
        JOptionPane.showMessageDialog(view,"Delete Data OK");
    }
    
   // data gel All
    public void getPeminjaman(){
        int index = view.getTabelPeminjaman().getSelectedRow();
        peminjaman = dao.getPeminjaman(index);
        view.getCboAnggota().setSelectedItem(peminjaman.getKodeAnggota());
        view.getCboBuku().setSelectedItem(peminjaman.getKodeBuku());
        view.getCboBuku().setSelectedItem(peminjaman.getKodeBuku());
        view.getTxtTglPinjam().setText(peminjaman.getTglPinjam());
    }
}