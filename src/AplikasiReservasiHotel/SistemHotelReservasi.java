/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package AplikasiReservasiHotel;

import java.util.Scanner;

public class SistemHotelReservasi {
    public static void main(String[] args) {
        RoomInterface[] kamar = new RoomInterface[3];
        kamar[0] = new HotelRoom("101", 150000.0, "Queen", 1, 1);
        kamar[1] = new DeluxeRoom("102", 200000.0, "King", 2, 1, true);
        kamar[2] = new HotelRoom("103", 100000.0, "Small", 1, 1);

        Scanner scanner = new Scanner(System.in);
        boolean selesai = false;

        while (!selesai) {
            System.out.println("\nSelamat Datang di Sistem Reservasi Hotel");
            System.out.println("1. Cek Ketersediaan Kamar");
            System.out.println("2. Pesan Kamar");
            System.out.println("3. Lihat Detail Kamar");
            System.out.println("4. Lihat Kamar yang Sudah Dipesan");
            System.out.println("5. Keluar");
            System.out.print("Silakan pilih opsi: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    tampilkanKetersediaanKamar(kamar);
                    kembaliKeMenu(scanner);
                    break;

                case 2:
                    prosesReservasi(kamar, scanner);
                    break;

                case 3:
                    prosesLihatDetailKamar(kamar, scanner);
                    break;

                case 4:
                    tampilkanKamarDipesan(kamar);
                    kembaliKeMenu(scanner);
                    break;

                case 5:
                    System.out.println("Terima kasih telah menggunakan Sistem Reservasi Hotel!");
                    selesai = true;
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                    break;
            }
        }

        scanner.close();
    }

    private static void tampilkanKetersediaanKamar(RoomInterface[] kamar) {
        System.out.println("\nKetersediaan Kamar:");
        for (RoomInterface room : kamar) {
            HotelRoom hotelRoom = (HotelRoom) room;
            System.out.println("Kamar " + hotelRoom.getNomorKamar() + ": " + (room.isTersedia() ? "Tersedia" : "Sudah Dipesan"));
        }
    }

    private static void prosesReservasi(RoomInterface[] kamar, Scanner scanner) {
        boolean lanjut = true;
        while (lanjut) {
            System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
            String nomorKamar = scanner.next();
            boolean ditemukan = false;

            for (RoomInterface room : kamar) {
                HotelRoom hotelRoom = (HotelRoom) room;

                if (hotelRoom.getNomorKamar().equals(nomorKamar)) {
                    if (room.isTersedia()) {
                        System.out.print("Masukkan tanggal check-in (DD-MM-YYYY): ");
                        String tanggalCheckIn = scanner.next();
                        System.out.print("Masukkan tanggal check-out (DD-MM-YYYY): ");
                        String tanggalCheckOut = scanner.next();

                        room.setTersedia(false);
                        hotelRoom.setTanggalReservasi(tanggalCheckIn, tanggalCheckOut);

                        System.out.println("Kamar " + nomorKamar + " berhasil dipesan.");
                        System.out.println("Anda dapat melakukan reservasi mulai tanggal " + tanggalCheckIn + " hingga " + tanggalCheckOut + ".");
                    } else {
                        System.out.println("Kamar " + nomorKamar + " sudah dipesan.");
                    }
                    ditemukan = true;
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Kamar " + nomorKamar + " tidak ditemukan.");
            }

            System.out.print("\nApakah Anda ingin melihat kamar yang sudah dipesan? (y/n): ");
            if (scanner.next().equalsIgnoreCase("y")) {
                tampilkanKamarDipesan(kamar);
                lanjut = !tanyaLanjut(scanner, "ingin kembali ke menu utama");
            } else {
                lanjut = !tanyaLanjut(scanner, "ingin kembali ke menu utama");
            }
        }
    }

    private static void prosesLihatDetailKamar(RoomInterface[] kamar, Scanner scanner) {
        boolean lanjut = true;
        while (lanjut) {
            System.out.print("Masukkan nomor kamar untuk melihat detail: ");
            String nomorKamar = scanner.next();
            boolean ditemukan = false;

            for (RoomInterface room : kamar) {
                HotelRoom hotelRoom = (HotelRoom) room;

                if (hotelRoom.getNomorKamar().equals(nomorKamar)) {
                    room.tampilkanInfoKamar();
                    if (!room.isTersedia()) {
                        System.out.println("Kamar ini sudah dipesan.");
                    }
                    ditemukan = true;
                    break;
                }
            }

            if (!ditemukan) {
                System.out.println("Kamar " + nomorKamar + " tidak ditemukan.");
            }

            lanjut = tanyaLanjut(scanner, "ingin melihat detail kamar lain");
        }
    }

    private static void tampilkanKamarDipesan(RoomInterface[] kamar) {
        System.out.println("\nKamar yang Sudah Dipesan:");
        boolean adaDipesan = false;

        for (RoomInterface room : kamar) {
            HotelRoom hotelRoom = (HotelRoom) room;
            if (!room.isTersedia()) {
                hotelRoom.tampilkanInfoKamar();
                adaDipesan = true;
            }
        }

        if (!adaDipesan) {
            System.out.println("Tidak ada kamar yang sudah dipesan.");
        }
    }

    private static boolean tanyaLanjut(Scanner scanner, String pesan) {
        System.out.print("Apakah Anda " + pesan + " (y/n)? ");
        String jawaban = scanner.next();
        return jawaban.equalsIgnoreCase("y");
    }

    private static void kembaliKeMenu(Scanner scanner) {
        System.out.println("\nKembali ke menu utama? (y/n)");
        String jawaban = scanner.next();
        if (jawaban.equalsIgnoreCase("n")) {
            System.out.println("Terima kasih telah menggunakan Sistem Reservasi Hotel!");
            System.exit(0);
        }
    }
}