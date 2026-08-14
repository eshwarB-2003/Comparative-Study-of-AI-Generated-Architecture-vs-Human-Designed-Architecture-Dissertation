package trade.view;

import java.util.Scanner;

import trade.util.InputValidator;
import trade.repo.*;
import trade.service.AdminService;
import trade.service.AuthService;
import trade.controller.*;
import trade.model.User;
import trade.service.BuyerService;
import trade.service.SellerService;
import trade.rules.RuleEngineService;

public class MainMenu {

    private AuthService auth = new AuthService();

    public void start() {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("Select Role:");
            System.out.println("1. Admin");
            System.out.println("2. Seller");
            System.out.println("3. Buyer");
            System.out.println("0. Exit");

            int roleOption = sc.nextInt();
            sc.nextLine();

            if (roleOption == 0) {
                System.out.println("Exiting System..");
                break;
            }

            String role = null;

            switch (roleOption) {
                case 1 -> role = "ADMIN";
                case 2 -> role = "SELLER";
                case 3 -> role = "BUYER";
                default -> {
                    System.out.println("Invalid role selection, Try again.");
                    continue;
                }
            }

            System.out.println("1. Register");
            System.out.println("2. Login");

            int option = sc.nextInt();
            sc.nextLine();

            // =========================
            // REGISTER
            // =========================

            if (option == 1) {

                System.out.print("Enter SME Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Company Email: ");
                String email = sc.nextLine();

                if (!InputValidator.isValidEmail(email)) {
                    System.out.println("Invalid email format.");
                    continue;
                }

                System.out.print("Enter Password: ");
                String pass = sc.nextLine();

                if (!InputValidator.isValidPassword(pass)) {
                    System.out.println(
                            "Password must be at least 6 characters and contain letters and numbers."
                    );
                    continue;
                }

                boolean success = auth.register(name, email, pass, role);

                System.out.println(
                        success
                                ? "Registration Successful"
                                : "User already exists!"
                );
            }

            // =========================
            // LOGIN
            // =========================

            if (option == 2) {

                System.out.print("Email: ");
                String email = sc.nextLine();

                if (!InputValidator.isValidEmail(email)) {
                    System.out.println("Invalid email format.");
                    continue;
                }

                System.out.print("Password: ");
                String pass = sc.nextLine();

                if (!InputValidator.isValidPassword(pass)) {
                    System.out.println(
                            "Password must be at least 6 characters and contain letters and numbers."
                    );
                    continue;
                }

                User user = auth.login(email, pass);

                if (user == null) {
                    System.out.println("Invalid Login !!!");
                    continue;
                }

                // =========================
                // ADMIN
                // =========================

                switch (user.getRole()) {

                    case "ADMIN" -> {

                        ActionRepository actionRepo =
                                ActionRepositoryJSON.getInstance();

                        CreditRepository creditRepo =
                                CreditRepositoryJSON.getInstance();

                        AdminService adminService =
                                new AdminService(actionRepo, creditRepo);

                        AdminController adminController =
                                new AdminController(adminService);

                        AdminView adminView =
                                new AdminView(adminController);

                        adminView.showDashboard(user);
                    }

                    // =========================
                    // SELLER
                    // =========================

                    case "SELLER" -> {

                        ActionRepository actionRepo =
                                ActionRepositoryJSON.getInstance();

                        CreditRepository creditRepo =
                                CreditRepositoryJSON.getInstance();

                        /*
                         * MONOLITHIC KERNEL
                         *
                         * All listing rules are contained inside
                         * RuleEngineService.
                         *
                         * No RulePlugin registration is required.
                         */

                        RuleEngineService ruleEngine =
                                new RuleEngineService();

                        SellerService sellerService =
                                new SellerService(
                                        actionRepo,
                                        creditRepo,
                                        ruleEngine
                                );

                        SellerController sellerController =
                                new SellerController(sellerService);

                        SellerView sellerView =
                                new SellerView(sellerController);

                        sellerView.showDashboard(user);
                    }

                    // =========================
                    // BUYER
                    // =========================

                    case "BUYER" -> {

                        /*
                         * MONOLITHIC KERNEL
                         *
                         * Purchase validation rules are contained
                         * directly inside RuleEngineService.
                         */

                        RuleEngineService engine =
                                new RuleEngineService();

                        CreditRepository creditRepo =
                                CreditRepositoryJSON.getInstance();

                        ReceiptRepository receiptRepo =
                                ReceiptRepositoryJSON.getInstance();

                        PortfolioRepository portfolioRepo =
                                PortfolioRepositoryJSON.getInstance();

                        BuyerService service =
                                new BuyerService(
                                        creditRepo,
                                        receiptRepo,
                                        portfolioRepo,
                                        engine
                                );

                        BuyerController controller =
                                new BuyerController(service);

                        BuyerView view =
                                new BuyerView(controller);

                        view.showDashboard(user);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new MainMenu().start();
    }
}