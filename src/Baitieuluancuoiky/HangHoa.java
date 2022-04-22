package Baitieuluancuoiky;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class HangHoa {
    private String maHang;
    private String tenHang;
    private int soLuongTon;
    private double donGia;
    private boolean loop = true;

    SimpleDateFormat changeFD = new SimpleDateFormat("dd/MM/yyyy");

    public HangHoa(){}
    
    public HangHoa(String maHang, String tenHang, int soLuongTon, double donGia) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
    }
    public String setChangeFD(Date date) {
        String string = changeFD.format(date);

        return string;
    }
    public boolean getLoop() {
        return loop;
    }
    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    public String getMaHang() {
        return maHang;
    }
    public void setMaHang(String maHang) {
        while(loop){
            if(maHang == null){
                System.out.println("Warning: Ma hang khong duoc trong!!");
            } else{
                this.maHang = maHang;
                loop = false;
            }
        }
    }
    public String getTenHang() {
        return tenHang;
    }
    public void setTenHang(String tenHang) {
        while(loop){
            if(tenHang == null){
                System.out.println("Warning: Ten hang khong duoc trong!!");
            } else {
                this.tenHang = tenHang;
                loop = false;
            }
        }
    }
    public int getSoLuongTon() {
        return soLuongTon;
    }
    public void setSoLuongTon(int soLuongTon) {
        while(loop){
            if(soLuongTon < 0){
                System.out.println("Warning: So luong ton kho khong duoc nho hon 0!");
            } else {
                this.soLuongTon = soLuongTon;
                loop = false;
            }
        }
    }
    public double getDonGia() {
        return donGia;
    }
    public void setDonGia(double donGia) {
        while(loop){
            if(donGia <= 0){
                System.out.println("Warning: Don gia khong duoc bang hoac nho hon 0!");
            } else {
                this.donGia = donGia;
                loop = false;
            }
        }
    }

    @Override
    public String toString() {
        return "Ma hang: " + getMaHang() + "\tTen hang: " + getTenHang() + "\tSo luong ton kho: " + getSoLuongTon()
        + "\tDon gia: " + getDonGia() + " VND";
    }

    public String getDanhGia(){
        return null;
    }
}

