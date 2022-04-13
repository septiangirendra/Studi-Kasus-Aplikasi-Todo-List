public class AplikasiTodoList {

    /**
     * Langkah 1. Membuat Model > implementasi dengan array
     *
     * @param args
     */

    // angka 10 adalah batas untuk menambahkan data
    public static String[] model = new String[10];
    // untuk input data dari user
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {

        viewShowTodoList();


    }

    /**
     * Method inpute user
     *
     * @param info
     * @return
     */
    public static String input(String info){
        System.out.print(info + ":");
        String data = scanner.nextLine();
        return data;
    }

    /**
     * Method testing input
     */
    public static void testInput(){
        var name = input("Nama");
        System.out.println("Hi "+name);
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList(){
        System.out.println("TODO LIST");
        for (var i = 0; i< model.length; i++ ) {
            // mengambil data dari array yang sudah didefiniskan
            String todo = model[i];
            var no = i +1;

            if (todo != null){
                System.out.println(no + ". " + todo);
            }
        }
    }

    /**
     * Untu melakukan test
     */
    public static void testShowTodoList(){
        model[0] = "Belajar Java Dasar";
        model[1] = "Aplikasi Todo List";
        showTodoList();
    }

    /**
     * Menambah todo ke list
     * berikan parameter dan masukan data ke model
     */
    public static void addTodoList(String todo){
        // cek model penuh
        var isfull = true;
        for (int i = 0; i< model.length; i++){
            if (model[i] == null){
                // model masih ada yang kosong
                isfull = false;
                break;
            }
        }
        // jika penuh, resize ukuran array 2x lipat
        if (isfull){
            // simpan data sebelumnya
            var temp = model;
            // reset baru
            model = new String[model.length * 2];

            for (int i = 0; i<temp.length; i++){
                model[i] = temp[i];
            }
        }
        // tambahkan ke posisi yang data array nya null
        for (var i = 0; i< model.length; i++){
            if (model[i] == null){
                model[i] = todo;
                break;
            }
        }


    }

    public static void testAddTodoList(){
        for (int i = 0; i < 35; i++){
            addTodoList("Contoh Todo Ke. "+i);
        }

        showTodoList();
    }

    /**
     * Menghapus todo list
     */
    public static boolean removeTodoList(Integer number){
        if ((number-1) >= model.length){
            return false;
        } else if (model[number-1]== null){
            return false;
        } else {
            for (int i =(number-1); i< model.length; i++){
                if (i == (model.length)-1){
                    model[i] = null;
                }else {
                    model[i] = model[i+1];
                }
            }

            return true;
        }
    }

    public static void testRemodeTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");

        var result = removeTodoList(20);
        System.out.println(result);

        result = removeTodoList(7);
        System.out.println(result);

        result = removeTodoList(1);
        System.out.println(result);

        showTodoList();
    }

    /**
     * view show todo list
     */
    public static void viewShowTodoList(){
        //perulangan untuk menampilkan terus
        while (true){
            showTodoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. exit");

            var input = input("Pilih");
            if (input.equals("1")){
                viewAddTodoList();
            } else if (input.equals("2")){
                viewRemodeTodoList();
            } else if (input.equals("x")){
                break;
            }
            else {
                System.out.println("Pilihan tidak ada");
            }
        }

    }

    public static void testViewShowTodoList(){

        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");
        addTodoList("empat");
        addTodoList("lima");
        viewShowTodoList();
    }

    /**
     * view addTodolist
     */
    public static void viewAddTodoList(){

        System.out.println("Menambah Todo List");
        var todo = input("Todo(x if cancel)");
        if (todo.equals("x")){

        }else {
            addTodoList(todo);
        }

    }

    /**
     * Test view menambahkan todolist
     */

    public static void testViewAddTodoList(){
        viewAddTodoList();

        showTodoList();
    }

    /**
     * viewRemoveTodoList
     */
    public static void viewRemodeTodoList(){

        System.out.println("Menghapus todo list");

        var number = input("Number of remove(x if cance)");
        if (number.equals("x")){
            // batal
        }else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success){
                System.out.println("field remove todo list" + number);
            }
        }
    }

    public static void testViewRemoveTodoList(){
        addTodoList("satu");
        addTodoList("dua");
        addTodoList("tiga");

        showTodoList();

        viewRemodeTodoList();

        showTodoList();
    }


}
