package model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VoucherModel {

    // Sinh ra voucher ngẫu nhiên
    public  String randomVoucher(int numberCharacterVoucher){
        String inputLow = "abcdefghijklmnopqrstuvwxyz";
        String inputUp = inputLow.toUpperCase();
        String input = inputLow+inputUp;
        Random random = new Random();
        String voucher = "";
        for (int i = 0; i < numberCharacterVoucher; i++) {
            int numberRandom = random.nextInt(0,input.length()-1);
            char charRandom = input.charAt(numberRandom);
            voucher += charRandom;
        }
        return voucher;
    }

    // tạo list voucher
    public void getVoucherByAdmin(ArrayList<Voucher> vouchers, Scanner sc){
        // số lượng voucher muốn sinh ra
        System.out.println("input number voucher:");
        int number = Integer.parseInt(sc.nextLine());
        // tỉ lệ khuyến mãi của voucher
        System.out.println("percent sale by voucher: ");
        int numberSale = Integer.parseInt(sc.nextLine());
        int i =0;
        while (i < number){
            String voucherRandom = randomVoucher(8);
            Voucher voucher = new Voucher(voucherRandom,true,numberSale);
            vouchers.add(voucher);
            i++;
        }
    }

    // admin xem và check voucher
    public void checkAndUseVoucher(ArrayList<Voucher> vouchers, Scanner sc){
        System.out.println("input voucher: ");
        String voucher = sc.nextLine();
        int check =0;
        for (Voucher voucherA: vouchers){
            if (voucherA.getVoucher().equals(voucher)){
                System.out.println(voucherA);
                check = 1;
                try {
                    System.out.println("1. use now");
                    System.out.println("2. use later");
                    int choose = Integer.parseInt(sc.nextLine());

                    // sử dụng voucher nếu voucher ở trạng thái true là chưa sử dụng(có thể áp dụng)
                    if (choose == 1){
                        if (voucherA.isStatus()){
                            System.out.println("apply ok");
                            voucherA.setStatus(false);
                        } else {
                            System.out.println("apply fail");
                        }
                    } else if (choose == 2){
                        break;
                    }
                } catch (Exception e){
                    System.out.println("error");
                }
            }
        }
        if (check ==0){
            System.out.println("voucher wrong");
        }
    }

    //Hàm này hình như sai a ạ, dòng 83 nếu xóa ở vị trí số 1 đi rồi thì get ra nó là voucher có vị trí số 2 lúc trước. 
    //Nếu list voucher ko có đủ số vcher thì sẽ bị OutOfBound exception
    //Có thể get(i).getvoucher lưu vào 1 biến String rồi mới remove(i) => return biến đó
    public String getVoucherByMem(ArrayList<Voucher> vouchers){
        Random random = new Random();
        if (vouchers.size() != 0){
            int i = random.nextInt(0,vouchers.size());
            vouchers.remove(i);
            return vouchers.get(i).getVoucher();
        } else {
            return "no voucher";
        }
    }
}
