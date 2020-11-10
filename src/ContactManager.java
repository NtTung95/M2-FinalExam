import java.io.*;
import java.util.ArrayList;

public class ContactManager {
    private final String CONTACT_LIST = "contactList.csv";
    private ArrayList<Contact> phonebookList = readFile();

    public ArrayList<Contact> getPhonebookList() {
        return phonebookList;
    }

    private static ContactManager instanceContactManager;

    private ContactManager(){}

    public static ContactManager getInstance(){
        if(instanceContactManager == null){
            instanceContactManager = new ContactManager();
        }
        return instanceContactManager;
    }

    public boolean addContact(Contact contact){
        if (phonebookList == null){
            phonebookList = new ArrayList<>();
        }
        return phonebookList.add(contact);
    }

    public void updateContact(int phoneNumber){
        for (Contact contact: phonebookList) {
            if (contact.getPhoneNumber() == phoneNumber){
                Menus.getInstance().updateGroup(contact);
                Menus.getInstance().updateName(contact);
                Menus.getInstance().updateGender(contact);
                Menus.getInstance().updateAddress(contact);
                Menus.getInstance().updateBirthday(contact);
                Menus.getInstance().updateEmail(contact);
                System.err.println("Sửa thành công");
            }
        }
        System.err.println("Không tìm thấy SĐT tương ứng");
    }

    public void deleteContact(int phoneNumber){
        Contact contactTemp=null;
        for (Contact contact: phonebookList) {
            if (contact.getPhoneNumber() == phoneNumber){
                contactTemp = contact;
            }
        }
        phonebookList.remove(contactTemp);
    }

    public void displayAllContact(){
        for (Contact contact : ContactManager.getInstance().readFile()) {
            System.out.println(contact);
        }
    }

    public void searchContactByName(String name){
        for (Contact contact: phonebookList) {
            if(name.equals(contact.getName())) {
                System.out.println(contact);
                break;
            }
        }
        System.err.println("Không tìm thấy tên tương ứng");
    }

    public void searchContactByPhoneNumber(int phoneNumber){
        for (Contact contact: phonebookList) {
            if(phoneNumber == contact.getPhoneNumber()) {
                System.out.println(contact);
                break;
            }
        }
        System.err.println("Không tìm thấy SĐT tương ứng");
    }

    public void writeFile(ArrayList<Contact> contacts){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(CONTACT_LIST);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(contacts);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Contact> readFile(){
        try {
            FileInputStream fileInputStream = new FileInputStream(CONTACT_LIST);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            return (ArrayList<Contact>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
    }
}
