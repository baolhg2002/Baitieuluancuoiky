package Baitieuluancuoiky;
import java.util.Calendar;
import java.util.Date;

public class HangSanhSu extends HangHoa{
    private String nhaSX;
    private Date ngayNhapKho;
    private double VAT = 0.1;

    public HangSanhSu(){}

    public HangSanhSu(String maHang, String tenHang, int soLuongTon, double donGia, String nhaSX,
            Date ngayNhapKho) {
        super(maHang, tenHang, soLuongTon, donGia);
        this.nhaSX = nhaSX;
        this.ngayNhapKho = ngayNhapKho;
    }
    public double getVAT() {
        return VAT;
    }
    public String getNhaSX() {
        return nhaSX;
    }
    public void setNhaSX(String nhaSX) {
        this.nhaSX = nhaSX;
    }
    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }
    public void setNgayNhapKho(Date ngayNhapKho) {
        this.ngayNhapKho = ngayNhapKho;
    }
    @Override
    public String toString() {
        Date ngayNhapkhoD = getNgayNhapKho();
        return super.toString() + "\tNha san xuat: " + getNhaSX() + "\tNgay nhap kho: " + setChangeFD(ngayNhapkhoD);
    }
    @Override
    public String getDanhGia() {
        Date dateNhapKho = getNgayNhapKho();
        Calendar dateLuuKho = Calendar.getInstance();
        Calendar dateSoSanh = Calendar.getInstance();

        dateSoSanh.setTime(dateNhapKho);
        dateLuuKho.setTime(dateNhapKho);

        dateSoSanh.add(Calendar.DATE, 10);

        String danhGia = "Khong co danh gia";
        if(getSoLuongTon() > 50 && dateSoSanh.before(dateLuuKho)){
            danhGia = "Ban cham";
        }

        return danhGia;
    }
}