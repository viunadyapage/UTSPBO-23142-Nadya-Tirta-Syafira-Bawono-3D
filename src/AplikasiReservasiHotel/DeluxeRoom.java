/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiReservasiHotel;

/**
 *
 * @author kukib
 */
public class DeluxeRoom extends HotelRoom {
    private boolean memilikiBalkon;

    public DeluxeRoom(String nomorKamar, double hargaPerMalam, String tipeTempatTidur, int jumlahTempatTidur, int jumlahKamarMandi, boolean memilikiBalkon) {
        super(nomorKamar, hargaPerMalam, tipeTempatTidur, jumlahTempatTidur, jumlahKamarMandi);
        this.memilikiBalkon = memilikiBalkon;
    }

    @Override
    public void tampilkanInfoKamar() {
        super.tampilkanInfoKamar();
        System.out.println("Memiliki Balkon: " + (memilikiBalkon ? "Ya" : "Tidak"));
    }
}