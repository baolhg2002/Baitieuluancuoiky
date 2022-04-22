package Baitieuluancuoiky;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QuanLyDanhSach implements DanhGia {
    private List<HangHoa> dsHH = new ArrayList<>();

    public void them(HangHoa hanghoaThem){
        int count = 0;
        int check = 0;
        String success = "System: Added successfully!";

            if(hanghoaThem.getMaHang() == null){
                System.out.println("Error: Ma hang khong duoc rong!");
                check = 1;
            } else if(hanghoaThem.getTenHang() == null){
                System.out.println("Error: Ten hang khong duoc rong!");
                check = 1;
            } else if(hanghoaThem.getSoLuongTon() < 0){
                System.out.println("Error: So luong ton kho khong duoc nho hon 0!");
                check = 1;
            } else if(hanghoaThem.getDonGia() <= 0){
                System.out.println("Error: Don gia khong duoc nho hon hoac bang 0!");
                check = 1;
            }
    
            if(hanghoaThem instanceof HangDienMay){
                if(((HangDienMay) hanghoaThem).getCongSuat() < 0 && ((HangDienMay) hanghoaThem).gettGbaoHanh() < 0){
                    System.out.println("Error: Cong suat phai > 0 & Thoi gian bao hanh > 0!");
                    check = 1;
                }
            } else if(hanghoaThem instanceof HangSanhSu){
                if(((HangSanhSu) hanghoaThem).getNgayNhapKho() == null || ((HangSanhSu) hanghoaThem).getNhaSX() == null){
                    System.out.println("Error: Nha san xuat & Ngay nhap kho khong duoc trong!");
                    check = 1;
                }
            } else if(hanghoaThem instanceof HangThucPham){
                if(((HangThucPham) hanghoaThem).getNgayHH().before(((HangThucPham) hanghoaThem).getNgaySX())){
                    System.out.println("Error: Ngay het han phai sau hoac la Ngay san xuat!");
                    check = 1;
                }
                if(((HangThucPham) hanghoaThem).getNhaCungCap() == null){
                    System.out.println("Error: Nha cung cap khong duoc rong!");
                    check = 1;
                }
            }

            if(check == 0){
                if(dsHH.size() == 0){
                    dsHH.add(hanghoaThem);
                    System.out.println(success);
                } else {
                    for (HangHoa hangHoa : dsHH) {
                        if(hangHoa.getMaHang() == hanghoaThem.getMaHang()){
                            System.out.println("Ma hang khong duoc trung!");
                            count = 0;
                        } else {
                            count = 1;
                        }
                    }
                if(count == 1){
                    dsHH.add(hanghoaThem);
                    System.out.println(success);
                }
            }
        }
    }
    public void inDanhSach(){
        for (HangHoa hangHoa : dsHH) {
            System.out.println(hangHoa + "\n");
        }
    }
    public String xoa(String maHang){
        String result = "System: Delete failed!";
        for (HangHoa hangHoa : dsHH) {
            if(hangHoa.getMaHang().equalsIgnoreCase(maHang)){
                dsHH.remove(timkiem_Vitri(maHang));
                result = "System: Deleted successed";
                break;
            } 
        }
        return result;
    }
    public int timkiem_Vitri(String maHang){
        int i = 0;
        for (HangHoa hangHoa : dsHH) {
            if(hangHoa.getMaHang().equalsIgnoreCase(maHang)){
                break;
            }
            i++;
        }
        return i;
    }
    public HangHoa timkiem_HangHoa(String maHang){
        HangHoa hang = new HangHoa() {
        };
        for (HangHoa hangHoa : dsHH) {
            if(hangHoa.getMaHang().equalsIgnoreCase(maHang)){
                hang = hangHoa;
                break;
            }
        }
        return hang;
    }
    public void timKiem_toString(String maHang){
        for (HangHoa hangHoa : dsHH) {
            if(hangHoa.getMaHang().equalsIgnoreCase(maHang)){
                System.out.println(hangHoa.toString());
            }
        }
    }
    public boolean checkList(String maHang){
        boolean check = false;
        for (HangHoa hangHoa : dsHH) {
            if(hangHoa.getMaHang().equalsIgnoreCase(maHang)){
                check = true;
                break;
            }
        }
        return check;
    }
    //Thêm checkList() vào sơ đồ
    public String suaHangHoa(String maHang, HangHoa hanghoaSua){
        String result = "System: Sua that bai!";
        if(checkList(maHang)){
            for (HangHoa hangHoa : dsHH) {
                if(hangHoa.getMaHang().equalsIgnoreCase(maHang)){
                    dsHH.set(timkiem_Vitri(maHang), hanghoaSua);
                    result = "System: Sua thanh cong!";
                }
            }
        }
        return result;
    }
    public void thongKe(){
        int sL_DienMay = 0;
        int sL_SanhSu = 0;
        int sL_ThucPham = 0;

        for (HangHoa hangHoa : dsHH) {
            if(hangHoa instanceof HangThucPham){
                sL_ThucPham++;
            } else if(hangHoa instanceof HangDienMay) {
                sL_DienMay++;
            } else if(hangHoa instanceof HangSanhSu) {
                sL_SanhSu++;
            }
        }

        System.out.println("So luong cac loai hang:");
        System.out.println("+ Thuc Pham: " + sL_ThucPham);
        System.out.println("+ Dien May: " + sL_DienMay);
        System.out.println("+ Sanh Su: " + sL_SanhSu);
    }
    public void sapXepTangDan(){
        Collections.sort(dsHH, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getDonGia() > o2.getDonGia()) {
                    return 0;
                }
                return -1;
            }
        });

        if(dsHH.size() == 0){
            System.out.println("System: Danh sach trong!");
        } else {
            System.out.println("System: Sap xep thanh cong.");
        }
    }
    public void sapXepGiamDan(){
        Collections.sort(dsHH, new Comparator<HangHoa>() {
            @Override
            public int compare(HangHoa o1, HangHoa o2) {
                if(o1.getDonGia() < o2.getDonGia()) {
                    return 0;
                }
                return -1;
            }
        });

        if(dsHH.size() == 0){
            System.out.println("System: Danh sach trong!");
        } else {
            System.out.println("System: Sap xep thanh cong.");
        }
    }
    public void danhGia(HangHoa hanghoa){
        if(hanghoa instanceof HangThucPham){
            System.out.println("Danh gia san pham: " + ((HangThucPham) hanghoa).getDanhGia());
        } else if(hanghoa instanceof HangDienMay){
           System.out.println("Danh gia san pham: " + ((HangDienMay) hanghoa).getDanhGia());
        } else if(hanghoa instanceof HangSanhSu){
            System.out.println("Danh gia san pham: " + ((HangSanhSu) hanghoa).getDanhGia());
        }
    }
    public void getDanhGia(String maHang){
        danhGia(timkiem_HangHoa(maHang));
    }
}
   
