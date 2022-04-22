package Baitieuluancuoiky;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InputConsole {
    Scanner input = new Scanner(System.in);
    SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy");

    public HangHoa nhapHang() throws ParseException{
            HangHoa hanghoa = new HangHoa(){};

            System.out.println("Nhap thong tin");
            System.out.print("Ma hang: ");
            String maHang = null;
            try {
                maHang = input.next();
            } catch (Exception e) {
                System.out.println("Error: Nhap sai dinh dang.");
                e.printStackTrace();
            }
            System.out.print("Ten hang:");
            String tenHang = null;
            try {
                tenHang = input.next();
            } catch (Exception e) {
                System.out.println("Error: Nhap sai dinh dang.");
                e.printStackTrace();
            }

            catchEnter();
            System.out.print("So luong ton kho:");
            int soLuongTon = 0;
            try {
                soLuongTon = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Nhap sai dinh dang.");
                e.printStackTrace();
            }

            System.out.print("Don gia: ");
            double donGia = 0;
            try {
                donGia = input.nextDouble();
            } catch (Exception e) {
                System.out.println("Error: Nhap sai dinh dang.");
                e.printStackTrace();
            }


            System.out.println("1. Hang thuc pham / 2. Hang dien may / 3. Hang sanh su");
            System.out.print("-   Nhap lua chon: ");
            int userKey = 0;
            try {
                userKey = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Nhap sai dinh dang.");
                e.printStackTrace();
            }

            switch(userKey){
                case 1:
                    System.out.print("Ngay san xuat: ");
                    String ngaySX = null;
                    try {
                        ngaySX = input.next();
                    } catch (Exception e) {
                        System.out.println("Error: Nhap sai dinh dang.");
                        e.printStackTrace();
                    }
        
                    System.out.print("Ngay het han: ");
                    String ngayHH = null;
                    try {
                        ngayHH = input.next();
                    } catch (Exception e) {
                        System.out.println("Error: Nhap sai dinh dang.");
                        e.printStackTrace();
                    }
        
                    System.out.print("Nha cung cap: ");
                    String nhaCungCap = null;
                    try {
                        nhaCungCap = input.next();
                    } catch (Exception e) {
                        System.out.println("Error: Nhap sai dinh dang.");
                        e.printStackTrace();
                    }
        
                    HangHoa hanghoaThem = new HangThucPham(maHang, tenHang, soLuongTon, donGia, sDF.parse(ngaySX), sDF.parse(ngayHH), nhaCungCap);
                    hanghoa = hanghoaThem;
                    break;
                case 2:
                    System.out.print("Thoi gian bao hanh (Thang): ");
                    int tGbaoHanh = 0;
                    try {
                        tGbaoHanh = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Error: Nhap sai dinh dang.");
                        e.printStackTrace();
                    }
        
                    System.out.print("Cong suat: ");
                    double congSuat = 0;
                    try {
                        congSuat = input.nextDouble();
                    } catch (Exception e) {
                        System.out.println("Error: Nhap sai dinh dang.");
                        e.printStackTrace();
                    }
        
                    HangHoa hanghoaThem_1 = new HangDienMay(maHang, tenHang, soLuongTon, donGia, tGbaoHanh, congSuat);
                    hanghoa = hanghoaThem_1;
                    break;
                case 3:
                    System.out.print("Nha san xuat: ");
                    String nhaSX = null;
                    try {
                        nhaSX = input.next();
                    } catch (Exception e) {
                        System.out.println("Error: Nhap sai dinh dang.");
                        e.printStackTrace();
                    }
        
                    System.out.print("Ngay nhap kho: ");
                    String ngayNhapKho = null;
                    try {
                        ngayNhapKho = input.next();
                    } catch (Exception e) {
                        System.out.println("Error: Nhap sai dinh dang.");
                        e.printStackTrace();
                    }

                    HangHoa hanghoaThem_2 = new HangSanhSu(maHang, tenHang, soLuongTon, donGia, nhaSX, sDF.parse(ngayNhapKho));
                    hanghoa = hanghoaThem_2;
                    break;
            }
        return hanghoa;
    }

    public String nhapMaHang(){
        try {
            System.out.print("Nhap ma hang: ");
        } catch (Exception e) {
            System.out.println("Error: Nhap sai dinh dang");
            e.printStackTrace();
        }
        String maHang = input.next();

        return maHang;
    }
    public void catchEnter(){
        String catchEnter = input.nextLine();
    }
}
