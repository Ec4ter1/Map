//package UI;
//
//import java.util.Scanner;
//import java.util.UUID;
//
//public class Ui implements UIInterface<UUID>{
//    private Service service;
//    private Scanner in = new Scanner(System.in);
//
//    public Ui(Service service) {
//        this.service = service;
//    }
//
//    public void run(){
//        menu();
//        Scanner scanner = new Scanner(System.in);
//        int i = scanner.nextInt();
//        while(i != 0){
//            option(i);
//            menu();
//            i = scanner.nextInt();
//        }
//        System.out.println("Exiting...");
//    }
//
//    private void menu(){
//        System.out.println("Menu");
//        System.out.println("1. Add user");
//        System.out.println("2. Remove user");
//        System.out.println("3. Add friendship");
//        System.out.println("4. Remove friendship");
//        System.out.println("5. Show all users");
//        System.out.println("6. Show all friendships");
//        System.out.println("7. Show number of communities");
//        System.out.println("8. Show most sociable community");
//        System.out.println(("0. Exit"));
//    }
//
//    private void option(int i){
//        switch(i){
//            case 1:
//                //add user
//                uiAddUser();
//                break;
//            case 2:
//                //remove user
//                uiRemoveUser();
//                break;
//            case 3:
//                //add friendship
//                uiAddFriendship();
//                break;
//            case 4:
//                //remove friendship
//                uiRemoveFriendship();
//                break;
//            case 5:
//                //show all users
//                uiShowAllUsers();
//                break;
//            case 6:
//                //show all friendships
//                uiShowAllFriendships();
//                break;
//            case 7:
//                //show number of communities
//                uiShowNumberOfCommunities();
//                break;
//            case 8:
//                //show most sociable community
//                uiShowMostSociableCommunity();
//                break;
//            default:
//                System.out.println("There is no option with this number!");
//        }
//    }
//
//}
