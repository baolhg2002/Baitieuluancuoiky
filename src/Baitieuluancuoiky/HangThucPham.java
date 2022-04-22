package Baitieuluancuoiky;
import java.util.Date;
public class HangThucPham extends HangHoa {
    private Date ngaySX;
    private Date ngayHH;
    private String nhaCungCap;
    private double VAT = 0.05;

    public HangThucPham(){}

    public HangThucPham(String maHang, String tenHang, int soLuongTon, double donGia, Date ngaySX,
            Date ngayHH, String nhaCungCap) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.ngaySX = ngaySX;
        this.ngayHH = ngayHH;
        this.nhaCungCap = nhaCungCap;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }
    public void setNhaCungCap(String nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    public Date getNgaySX() {
        return ngaySX;
    }
    public void setNgaySX(Date ngaySX) {
        this.ngaySX = ngaySX;
    }
    public double getVAT() {
        return VAT;
    }
    public Date getNgayHH() {
        return ngayHH;
    }
    public void setNgayHH(Date ngayHH) {
        while (getLoop()) {
            if(ngayHH.before(getNgaySX())){
                System.out.println("Warning: Ngay het han phai lon hon ngay san xuat!");
            } else {
                this.ngayHH = ngayHH;
                setLoop(false);
            }  
        }
    }

    @Override
    public String toString() {
        String ngaySX = setChangeFD(getNgaySX());
        String ngayHH = setChangeFD(getNgayHH());
        return super.toString() + "\tNgay san xuat: " + ngaySX + "\tNgay het han: " + ngayHH + "\tNha cung cap: " + getNhaCungCap();
    }

    @Override
    public String getDanhGia() {
        Date presentDay = new Date();
        String danhGia = "Khong co danh gia";
        if(getSoLuongTon() > 0 && getNgayHH().before(presentDay) || getNgayHH().equals(presentDay)){
            danhGia = "Kho ban";
        }
        return danhGia;
    }
}
