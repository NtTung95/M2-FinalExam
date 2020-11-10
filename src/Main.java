import java.util.Scanner;

public class Main {
    public static void program() {
        Scanner input = new Scanner(System.in);

        do {
            try {
                System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---");
                System.out.println("1.Xem danh sách");
                System.out.println("2.Thêm mới");
                System.out.println("3.Cập nhật");
                System.out.println("4.Xóa");
                System.out.println("5.Tìm kiếm");
                System.out.println("6.Đọc từ file");
                System.out.println("7.Ghi vào file");
                System.out.println("8.Thoát");
                System.out.println("");
                System.out.print("Chọn chức năng: ");
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        if (ContactManager.getInstance().getPhonebookList() == null || ContactManager.getInstance().getPhonebookList().isEmpty()) {
                            System.err.println("Chưa có mục danh bạ nào");
                        } else {
                            ContactManager.getInstance().displayAllContact();
                        }
                        break;
                    case 2:
                        Contact contact = Menus.getInstance().inputInfo();
                        if (ContactManager.getInstance().addContact(contact)) {
                            System.err.println("Thêm thành công");
                        }
                        ContactManager.getInstance().writeFile(ContactManager.getInstance().getPhonebookList());
                        break;
                    case 3:
                        System.out.println("Nhập SĐT cần update");
                        ContactManager.getInstance().updateContact(Integer.parseInt(input.nextLine()));
                        ContactManager.getInstance().writeFile(ContactManager.getInstance().getPhonebookList());
                        break;
                    case 4:
                        System.out.println("Nhập SĐT cần xóa");
                        ContactManager.getInstance().deleteContact(Integer.parseInt(input.nextLine()));
                        ContactManager.getInstance().writeFile(ContactManager.getInstance().getPhonebookList());
                        break;
                    case 5:
                        System.out.println("1.Tìm kiếm theo tên");
                        System.out.println("2.Tìm kiếm theo SĐT");
                        System.out.println("3.Thoát");
                        int searchChoice = Integer.parseInt(input.nextLine());
                        switch (searchChoice) {
                            case 1:
                                System.out.println("Nhập tên muốn tìm");
                                ContactManager.getInstance().searchContactByName(input.nextLine());
                                break;
                            case 2:
                                System.out.println("Nhập SĐT muốn tìm");
                                ContactManager.getInstance().searchContactByPhoneNumber(Integer.parseInt(input.nextLine()));
                                break;
                            case 3:
                                Main.program();
                                break;
                        }
                        break;
                    case 6:
                        for (Contact contactInFile : ContactManager.getInstance().readFile()) {
                            System.out.println(contactInFile);
                        }
                        break;
                    case 7:
                        ContactManager.getInstance().writeFile(ContactManager.getInstance().getPhonebookList());
                        System.err.println("Ghi thành công");
                        break;
                    case 8:
                        System.exit(0);
                        break;
                }
            }catch (NumberFormatException e){
                System.err.println("Nhập lỗi");
            }
        } while (true);
    }
    public static void main(String[] args) {
        program();
    }
}
