package var_shadowing_hiding;
//class static area -> method area -> stack area -> heap 
//perform this on paper to understand how exactly this is working
//especially this.y because how is this accessing static int y 
//is y get converted to object or smthn
public class Demo {
    int x = 10;
    static int y = 3000;

    void show() {
        int x = 30;
        int y = 40;

        System.out.println(x);        // 30
        System.out.println(this.x);   // 10
        System.out.println(y);        // 40
        
        System.out.println(this.y);   // 3000
        System.out.println(Demo.y);   // 3000
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        d.show();
    }
}
