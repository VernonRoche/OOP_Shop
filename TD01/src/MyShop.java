import java.util.*;

public class MyShop {

    static public void add_product(Scanner sc, List<Stock> stock_list){
        System.out.println("Please write in which stock do you wish to add a product.");
        String stock_name = sc.nextLine().toLowerCase();
        for (Stock stock : stock_list) {
            if (stock.getName().equals(stock_name)) {
                System.out.println("Please write the name of the product you wish to add.");
                String product_name = sc.nextLine().toLowerCase();
                System.out.println("Please write the quantity you want to add.");
                String user_input = sc.nextLine();
                try{
                    int product_quantity = Integer.parseInt(user_input);
                    List<Product> temp_list = stock.getProduct_list();
                    temp_list.add(new Product(product_name,product_quantity));
                    stock.setProduct_list(temp_list);
                    return;
                }
                catch(NumberFormatException e){
                    System.out.println("Something went wrong. Please enter an integer quantity.");
                }
            }
        }
        System.out.println("That stock does not exist.");
    }

    static public void remove_product(Scanner sc,List<Stock> stock_list){
        System.out.println("Please write in which stock do you wish to remove a product.");
        String stock_name = sc.nextLine().toLowerCase();
        for (Stock stock : stock_list) {
            if (stock.getName().equals(stock_name)) {
                System.out.println("Please write the name of the product you wish to remove.");
                String product_name = sc.nextLine().toLowerCase();

                for (Product product: stock.getProduct_list()) {
                    if (product.getName().equals(product_name)) {
                        System.out.println("Please write the quantity you want to remove.");
                        String user_input = sc.nextLine();
                        try {
                            int product_quantity = Integer.parseInt(user_input);
                            List<Product> temp_list = stock.getProduct_list();
                            int final_quantity=product.getQuantity()-product_quantity;
                            if (final_quantity<=0){
                                temp_list.remove(product);
                            }
                            else{
                                product.setQuantity(final_quantity);
                            }
                            stock.setProduct_list(temp_list);
                            return;
                        } catch (NumberFormatException e) {
                            System.out.println("Something went wrong. Please enter an integer quantity.");
                        }
                    }
                }
                System.out.println("That product does not exist.");
            }
        }
        System.out.println("That stock does not exist.");
    }

    static public void show_product(Scanner sc,List<Stock> stock_list){
        System.out.println("Please write in which stock do you wish to search for a product.");
        String stock_name = sc.nextLine().toLowerCase();
        for (Stock stock : stock_list) {
            if (stock.getName().equals(stock_name)) {
                System.out.println("Please write the name of the product you wish to show.");
                String product_name = sc.nextLine().toLowerCase();

                for (Product product: stock.getProduct_list()) {
                    if (product.getName().equals(product_name)) {
                        System.out.println("@@@"+product_name+"@@@");
                        System.out.println("Quantity: "+String.valueOf(product.getQuantity()));
                        System.out.println("Product ID: "+String.valueOf(product.getProduct_id()));
                    }
                }
                System.out.println("That product does not exist.");
            }
        }
        System.out.println("That stock does not exist.");
    }

    static public void add_stock(Scanner sc, List<Stock> stock_list){
        System.out.println("How do you want to name your new stock?");
        String stock_name = sc.nextLine().toLowerCase();
        System.out.println("What will be your new stock's address?");
        String stock_address = sc.nextLine().toLowerCase();
        stock_list.add(new Stock(new ArrayList<Product>(), stock_name, stock_address));
    }

    static public void remove_stock(Scanner sc, List<Stock> stock_list){
        System.out.println("Please write the name of the stock you want to remove.");
        String stock_name = sc.nextLine().toLowerCase();
        for (Stock stock : stock_list) {
            if (stock.getName().equals(stock_name)) {
                stock_list.remove(stock);
                return;
            }
        }
        System.out.println("That stock does not exist.");

    }

    static public void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String user_input;

        System.out.println("@@@Welcome to your shop! How do you want to name it?@@@");
        String shop_name=sc.nextLine().toLowerCase();
        System.out.println("Great your shop's name is "+shop_name);

        while (true) {
            System.out.println("Do you want to create your shop's first stock? yes/no");
            user_input = sc.nextLine().toLowerCase();
            if (user_input.equals("no")) {
                System.out.println("See you soon!");
                System.exit(0);
            } else if (!(user_input.equals("yes"))) {
                System.out.println("Please write yes or no.");
            }
            else{
                break;
            }
        }

        System.out.println("What will be your stock's name?");
        String stock_name=sc.nextLine().toLowerCase();
        System.out.println("What will be your stock's address?");
        user_input=sc.nextLine().toLowerCase();
        System.out.println("Great! You have created you first shop's stock!");

        List<Stock> stock_list = new ArrayList<Stock>();
        stock_list.add(new Stock(new ArrayList<Product>(), stock_name, user_input));

        while (true){
            System.out.println("@@@Please choose an action@@@");
            System.out.println("Write <add> in order to add a product.");
            System.out.println("Write <remove> in order to remove a product");
            System.out.println("Write <show> in order to show details about a product");
            System.out.println("Write <add stock> to add a new stock");
            System.out.println("Write <remove stock> to remove a stock");
            System.out.println("@@@Write <exit> to leave the program.@@@");
            System.out.println("Your chosen action: ");
            user_input=sc.nextLine().toLowerCase();

            switch (user_input) {
                case "add" -> add_product(sc, stock_list);
                case "remove" -> remove_product(sc, stock_list);
                case "show" -> show_product(sc, stock_list);
                case "add stock" -> add_stock(sc, stock_list);
                case "remove stock" -> remove_stock(sc, stock_list);
                case "exit" -> System.exit(0);
                default -> System.out.println("That command does not exist.");
            }
        }
    }


}

