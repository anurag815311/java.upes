// question one code 
class q_one_i {
    static class Role {
        String roleName;

        Role(String name) {
            roleName = name;
        }

        void display() {
            System.out.println("Role: " + roleName);
        }
    }

    public static void main(String[] args) {
        q_one_i.Role manager = new q_one_i.Role("Manager");
        manager.display();
    }
}
