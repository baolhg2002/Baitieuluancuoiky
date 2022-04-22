package Baitieuluancuoiky;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    static QuanLyDanhSach danhSach = new QuanLyDanhSach();
    static SimpleDateFormat sDF = new SimpleDateFormat("dd/MM/yyyy");
    public static void main(String[] args) throws ParseException {
        InputConsole iConsole = new InputConsole();
        Scanner input = new Scanner(System.in);

        boolean condition = true;

        danhSachMoi();
        
        do {
            System.out.println("/----------------------/");
            System.out.println("1 - Them hang hoa");
            System.out.println("2 - Sua hang hoa");
            System.out.println("3 - Xoa hang hoa");
            System.out.println("4 - Sap xep danh sach");
            System.out.println("5 - Tim kiem theo ma");
            System.out.println("6 - In danh sach");
            System.out.println("7 - In bang thong ke");
            System.out.println("8 - Lay danh gia");
            System.out.println("0 - Thoat chuong trinh");
            System.out.println("/----------------------/");
            int userKey = 0;

            try {
                System.out.print("-   Nhap lua chon: ");
                userKey = input.nextInt();
            } catch (Exception e) {
                System.out.println("Error: Nhap sai dinh dang.");
                e.printStackTrace();
            }

            switch (userKey) {
                case 1:
                    danhSach.them(iConsole.nhapHang());
                    iConsole.catchEnter();
                    break;
                case 2:
                    System.out.println(danhSach.suaHangHoa(iConsole.nhapMaHang(), iConsole.nhapHang()));
                    iConsole.catchEnter();
                    break;
                case 3:
                    System.out.println(danhSach.xoa(iConsole.nhapMaHang()));
                    iConsole.catchEnter();
                    break;
                case 4:
                    int key = 0;
                    try {
                        System.out.print("1 - Tang dan / 2 - Giam dan : ");
                        key = input.nextInt();
                    } catch (Exception e) {
                        System.out.println("Error: Chi nhan so!");
                    }
                    switch (key) {
                        case 1:
                            danhSach.sapXepTangDan();
                            break;
                        case 2:
                            danhSach.sapXepGiamDan();
                            break;
                        default:
                            break;
                    }
                    break;
                case 5:
                    danhSach.timKiem_toString(iConsole.nhapMaHang());
                    iConsole.catchEnter();
                    break;
                case 6:
                    System.out.println("|-----------------------------------------------------------------------------------------------------|");
                    danhSach.inDanhSach();
                    iConsole.catchEnter();
                    break;
                case 7:
                    danhSach.thongKe();
                    iConsole.catchEnter();
                    break;
                case 8:
                    danhSach.getDanhGia(iConsole.nhapMaHang());
                    iConsole.catchEnter();
                    break;
                case 0:
                    condition = false;
                    break;
                default:
                    break;
            }
        } while (condition);
        
        input.close();
    }

    public static void danhSachMoi() throws ParseException{
        HangHoa spThucPham1 = new HangThucPham("TP01" ,"Banh mi ngot", 5, 10000, sDF.parse("19/02/2022") , sDF.parse("29/01/2022") , "ORION VINA");
        HangHoa spThucPham2 = new HangThucPham("TP02" ,"Banh Lays", 20, 16000 , sDF.parse("17/12/2021") , sDF.parse("10/08/2022"), "FOOD VINA");
        HangHoa spThucPham3 = new HangThucPham("TP03","Keo Mashmalo", 9, 28000, sDF.parse("08/11/2021"), sDF.parse("20/04/2023") , "KINH DO");
        HangHoa spDienMay1 = new HangDienMay("DM01", "May giat", 85, 8500000, 5, 5_4);
        HangHoa spDienMay2 = new HangDienMay("DM02", "Dieu hoa", 76, 12000000, 12, 24_0);
        HangHoa spDienMay3 = new HangDienMay("DM03", "TV", 30, 35000000, 12, 20_0);
        HangHoa spSanhSu1 = new HangSanhSu("SS01", "Chen", 105, 5000, "Hai Long", sDF.parse("20/11/2021"));
        HangHoa spSanhSu2 = new HangSanhSu("SS02", "To", 20, 8000, "VNCRO", sDF.parse("01/01/2022"));
        HangHoa spSanhSu3 = new HangSanhSu("SS03", "Dia", 257, 7000, "Hai Long", sDF.parse("30/02/2022"));
        HangHoa spSanhSu4 = new HangSanhSu("SS04", "Ly", 15, 10000, "Minh Long", sDF.parse("12/12/2021"));
       
        danhSach.them(spDienMay1);  danhSach.them(spDienMay2);
        danhSach.them(spDienMay3);  danhSach.them(spSanhSu1);
        danhSach.them(spSanhSu2);   danhSach.them(spSanhSu3);
        danhSach.them(spSanhSu4);   danhSach.them(spThucPham1);
        danhSach.them(spThucPham2); danhSach.them(spThucPham3);
    }
    
}
