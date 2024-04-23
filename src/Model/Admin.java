
package Model;


public class Admin extends User{
    private int admin_id;
    private String admin_pinChangeMenu;

    public Admin(int admin_id, String admin_pinChangeMenu, int user_id, String user_name, String user_password) {
        super(user_id, user_name, user_password);
        this.admin_id = admin_id;
        this.admin_pinChangeMenu = admin_pinChangeMenu;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_pinChangeMenu() {
        return admin_pinChangeMenu;
    }

    public void setAdmin_pinChangeMenu(String admin_pinChangeMenu) {
        this.admin_pinChangeMenu = admin_pinChangeMenu;
    }
}
