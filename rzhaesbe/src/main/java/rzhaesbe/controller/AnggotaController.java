/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rzhaesbe.controller;
import rzhaesbe.dao.AnggotaDao;
import rzhaesbe.dao.AnggotaDaoImpl;
import rzhaesbe.model.Anggota;
import rzhaesbe.view.FormAnggota;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author LAB-MM
 */
public class AnggotaController {
    FormAnggota view;
    Anggota anggota;
    AnggotaDao dao;
    
    public AnggotaController(FormAnggota view) {
        this.view = view;
        dao = new AnggotaDaoImpl();
    }
    
    public void clearForm() {
        view.getTxtKodeAnggota().setText("");
        view.getTxtNamaAnggota().setText("");
        view.getTxtAlamat().setText("");
        view.getCboJenisKelamin().removeAllItems();
        view.getCboJenisKelamin().addItem("L");
        view.getCboJenisKelamin().addItem("P");
    }
    
    public void tampil(){
        DefaultTableModel tabelModel = (DefaultTableModel) view.getTabelAnggota().getModel();
        tabelModel.setRowCount(0);
        List<Anggota> list = dao.getAll();
        for (Anggota a : list) {
            Object[] row = {
                a.getKodeAnggota(),
                a.getNamaAnggota(),
                a.getAlamat(),
                a.getJenisKelamin(),
            };
            tabelModel.addRow(row);
        }
    }
    
    public void insert(){
        anggota = new Anggota();
        anggota.setKodeAnggota(view.getTxtKodeAnggota().getText());
        anggota.setNamaAnggota(view.getTxtNamaAnggota().getText());
        anggota.setAlamat(view.getTxtAlamat().getText());
        anggota.setJenisKelamin(view.getCboJenisKelamin().getSelectedItem().toString());
        dao.insert(anggota);
        JOptionPane.showMessageDialog(view, "Entri Data Oke");
    }
    
    public void update(){
        int index = view.getTabelAnggota().getSelectedRow();
        anggota.setKodeAnggota(view.getTxtKodeAnggota().getText());
        anggota.setNamaAnggota(view.getTxtNamaAnggota().getText());
        anggota.setAlamat(view.getTxtAlamat().getText());
        anggota.setJenisKelamin(view.getCboJenisKelamin().getSelectedItem().toString());
        dao.update(index ,anggota);
        JOptionPane.showMessageDialog(view, "Update Data Oke");
    }
    
    public void delete(){
        int index = view.getTabelAnggota().getSelectedRow();
        dao.delete(index);
        JOptionPane.showMessageDialog(view, "Delete Data Oke");
    }
    public void getAnggota() {
        int index = view.getTabelAnggota().getSelectedRow();
        anggota = dao.getAnggota(index);
        view.getTxtKodeAnggota().setText(anggota.getKodeAnggota());
        view.getTxtNamaAnggota().setText(anggota.getNamaAnggota());
        view.getTxtAlamat().setText(anggota.getAlamat());
        view.getCboJenisKelamin().setSelectedItem(anggota.getJenisKelamin());
        
        
    }
}

