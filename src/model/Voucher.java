package model;

public class Voucher {
    private String voucher;
    private boolean status;
    private float percentSale;

    public Voucher(String voucher, boolean status, float percentSale) {
        this.voucher = voucher;
        this.status = status;
        this.percentSale = percentSale;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "voucher='" + voucher + '\'' +
                ", status=" + status +
                ", Sale=" + percentSale +
                "%\n";
    }
}
