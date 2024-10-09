/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AplikasiReservasiHotel;

/**
 *
 * @author kukib
 */
public class HotelRoom implements RoomInterface {
    private String nomorKamar;
    private boolean tersedia;
    private double hargaPerMalam;
    private String tipeTempatTidur;
    private int jumlahTempatTidur;
    private int jumlahKamarMandi;
    private String tanggalCheckIn;
    private String tanggalCheckOut;

    public HotelRoom(String nomorKamar, double hargaPerMalam, String tipeTempatTidur, int jumlahTempatTidur, int jumlahKamarMandi) {
        this.nomorKamar = nomorKamar;
        this.hargaPerMalam = hargaPerMalam;
        this.tersedia = true;
        this.tipeTempatTidur = tipeTempatTidur;
        this.jumlahTempatTidur = jumlahTempatTidur;
        this.jumlahKamarMandi = jumlahKamarMandi;
        this.tanggalCheckIn = "-";
        this.tanggalCheckOut = "-";
    }

    @Override
    public void tampilkanInfoKamar() {
        System.out.println("Nomor Kamar: " + nomorKamar);
        System.out.println("Harga per Malam: Rp " + hargaPerMalam);
        System.out.println("Tipe Tempat Tidur: " + tipeTempatTidur);
        System.out.println("Jumlah Tempat Tidur: " + jumlahTempatTidur);
        System.out.println("Jumlah Kamar Mandi: " + jumlahKamarMandi);
        System.out.println("Ketersediaan: " + (tersedia ? "Tersedia" : "Sudah Dipesan"));
        System.out.println("Tanggal Check-In: " + tanggalCheckIn);
        System.out.println("Tanggal Check-Out: " + tanggalCheckOut);
    }

    @Override
    public boolean isTersedia() {
        return tersedia;
    }

    @Override
    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public void setTanggalReservasi(String checkIn, String checkOut) {
        this.tanggalCheckIn = checkIn;
        this.tanggalCheckOut = checkOut;
    }

    public String getNomorKamar() {
        return nomorKamar;
    }
}