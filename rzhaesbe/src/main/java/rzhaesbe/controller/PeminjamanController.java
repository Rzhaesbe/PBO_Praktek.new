/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rzhaesbe.controller;
import rzhaesbe.model.*;
import java.util.*;
import javax.swing.JOptionPane;
import rzhaesbe.view.*;
import javax.swing.table.DefaultTableModel;
import rzhaesbe.dao.*;
import rzhaesbe.view.FormPeminjaman;

/**
 *
 * @author Rzhaesbe
 */
public class PeminjamanController {
    FormPeminjaman view;
    Peminjaman peminjaman;
    PeminjamanDao dao;
    
     public PeminjamanController(FormPeminjaman view) {
        this.view = view;
        dao = new PeminjamanDaoImpl() {};
    }
    
    public void clearForm() {
        view.getTxtKodeAnggota().setText("");
        view.getTxtKodeBuku().setText("");
        view.getTxtTglPinjam().setText("");
        view.getTxtTglKembali().setText("");
       
    }
    
     public void tampil(){
        DefaultTableModel tabelModel = (DefaultTableModel) view.getTabelPeminjaman().getModel();
        tabelModel.setRowCount(0);
        List<Peminjaman> list = dao.getAll();
        for (Peminjaman a : list) {
            Object[] row = {
                a.getKodeAnggota(),
                a.getKodeBuku(),
                a.getTglPinjam(),
                a.getTglKembali(),
            };
            tabelModel.addRow(row);
        }
    }
     public void insert() {
        peminjaman = new Peminjaman();
        peminjaman.setKodeAnggota(view.getTxtKodeAnggota().getText());
        peminjaman.setKodeBuku(view.getTxtKodeBuku().getText());
        peminjaman.setTglPinjam(view.getTxtTglPinjam().getText());
        peminjaman.setTglKembali(view.getTxtTglKembali().getText());
        dao.insert(peminjaman);
        JOptionPane.showMessageDialog(view,"Entri Data OK");
    }
      public void update() {
        int index = view.getTabelPeminjaman().getSelectedRow();
        peminjaman = new Peminjaman();
        peminjaman.setKodeAnggota(view.getTxtKodeAnggota().getText());
        peminjaman.setKodeBuku(view.getTxtKodeBuku().getText());
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
    
    public void getPeminjaman() {
        int index = view.getTabelPeminjaman().getSelectedRow();
        peminjaman = dao.getPeminjaman(index);
        view.getTxtKodeAnggota().setText(peminjaman.getKodeAnggota());
        view.getTxtKodeBuku().setText(peminjaman.getKodeBuku());
        view.getTxtTglPinjam().setText(peminjaman.getTglPinjam());
       
    }
}
