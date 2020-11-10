import java.time.LocalDate;
import java.util.Scanner;

public class Menus {
    Scanner input = new Scanner(System.in);

    private static Menus instanceMenu;
    private Menus(){}
    public static Menus getInstance(){
        if(instanceMenu == null){
            instanceMenu = new Menus();
        }
        return instanceMenu;
    }

    public Contact inputInfo(){
        System.out.println("---Thêm mới 1 mục danh bạ---");
        Contact contact = new Contact();
        System.out.println("Nhập SĐT");
        contact.setPhoneNumber(Integer.parseInt(input.nextLine()));
        updateGroup(contact);
        updateName(contact);
        updateGender(contact);
        updateAddress(contact);
        updateBirthday(contact);
        updateEmail(contact);

        return contact;
    }

    public void updateGroup(Contact contact){
        System.out.println("Nhập nhóm");
        contact.setGroup(input.nextLine());
    }

    public void updateName(Contact contact){
        System.out.println("Nhập tên");
        contact.setName(input.nextLine());
    }

    public void updateGender(Contact contact){
        System.out.println("Nhập giới tính");
        contact.setGender(input.nextLine());
    }

    public void updateAddress(Contact contact){
        System.out.println("Nhập địa chỉ");
        contact.setAddress(input.nextLine());
    }

    public void updateBirthday(Contact contact){
        System.out.println("Nhập ngày sinh");
        int date = Integer.parseInt(input.nextLine());
        System.out.println("Nhập tháng sinh");
        int month = Integer.parseInt(input.nextLine());
        System.out.println("Nhập năm sinh");
        int year = Integer.parseInt(input.nextLine());
        contact.setBirthday(LocalDate.of(year,month,date));
    }

    public void updateEmail(Contact contact){
        System.out.println("Nhập email");
        contact.setEmail(input.nextLine());
    }

}
