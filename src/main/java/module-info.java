module com.example.supply_chain_management_sys {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.supply_chain_management_sys to javafx.fxml;
    exports com.example.supply_chain_management_sys;
}